package hu.me.iit.webalk.restapi_zh_gyakorlas_2.controller;


import hu.me.iit.webalk.restapi_zh_gyakorlas_2.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<BookDto> getAllBooks(){
        List<BookDto> bookDtoList = new ArrayList<>();
        bookService.getAllBooks().forEach(b -> bookDtoList.add(new BookDto(b)));
        return bookDtoList;
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id){
        return new BookDto(bookService.getBookById(id));
    }

    @PostMapping(consumes = "application/json")
    public BookDto save(@RequestBody @Valid BookCreateDto bookCreateDto){
        return new BookDto(bookService.save(bookCreateDto.toBook()));
    }

    @PutMapping(consumes = "application/json")
    public void update(@RequestBody @Valid BookDto bookDto){
        bookService.update(bookDto.toBook());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }

    @GetMapping("/longest")
    public BookDto getLongestBook(){
        return new BookDto(bookService.getLongestBook());
    }

    @GetMapping("/byAuthor/{author}")
    public Iterable<BookDto> getBooksByAuthor(@PathVariable String author){
        List<BookDto> bookDtoList = new ArrayList<>();
        bookService.getBooksByAuthor(author).forEach(b -> bookDtoList.add(new BookDto(b)));
        return bookDtoList;
    }

}
