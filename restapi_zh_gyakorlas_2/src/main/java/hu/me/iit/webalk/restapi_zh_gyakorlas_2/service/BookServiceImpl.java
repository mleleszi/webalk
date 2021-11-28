package hu.me.iit.webalk.restapi_zh_gyakorlas_2.service;

import hu.me.iit.webalk.restapi_zh_gyakorlas_2.repository.BookEntity;
import hu.me.iit.webalk.restapi_zh_gyakorlas_2.repository.BookRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .map(Book::new)
                .collect(Collectors.toList());
    }

    @Override
    public Book getBookById(Long id) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(id);
        if(optionalBookEntity.isEmpty())
            throw new NoSuchEntityException(id);
        return new Book(optionalBookEntity.get());
    }

    @Override
    public Book save(Book book) {
        return new Book(bookRepository.save(book.toEntity()));
    }

    @Override
    public void update(Book book) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(book.getId());
        if(optionalBookEntity.isEmpty())
            throw new NoSuchEntityException(book.getId());
        bookRepository.save(book.toEntity());
    }

    @Override
    public void deleteById(Long id) {
       try {
           bookRepository.deleteById(id);
       } catch(EmptyResultDataAccessException ex){
           throw new NoSuchEntityException(id);
       }
    }

    @Override
    public Book getLongestBook() {
        Optional<BookEntity> optionalBookEntity = bookRepository.findTopByOrderByPageCountDesc();
        if(optionalBookEntity.isEmpty())
            throw new NoSuchEntityException();
        return new Book(optionalBookEntity.get());
    }

    @Override
    public Iterable<Book> getBooksByAuthor(String author) {
        return StreamSupport.stream(bookRepository.findAllByAuthor(author).spliterator(), false)
                .map(Book::new)
                .collect(Collectors.toList());
    }
}
