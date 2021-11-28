package hu.me.iit.webalk.restapi_zh_gyakorlas_2.service;

public interface BookService {
    Iterable<Book> getAllBooks();
    Book getBookById(Long id);
    Book save(Book book);
    void update(Book book);
    void deleteById(Long id);

    // custom queries
    Book getLongestBook();
    Iterable<Book> getBooksByAuthor(String author);
}
