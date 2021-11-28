package hu.me.iit.webalk.restapi_zh_gyakorlas_2.service;

import hu.me.iit.webalk.restapi_zh_gyakorlas_2.repository.BookEntity;
import hu.me.iit.webalk.restapi_zh_gyakorlas_2.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @InjectMocks
    BookServiceImpl bookService;

    @Mock
    BookRepository bookRepository;

    List<BookEntity> bookEntityList;

    @BeforeEach
    public void setup(){
        bookEntityList = new ArrayList<>(Arrays.asList(
                new BookEntity(1L, "sanyi", 1234),
                new BookEntity(2L, "sanyi", 122),
                new BookEntity(3L, "levi", 800),
                new BookEntity(4L, "donat", 100)
                ));
    }

    @Test
    public void should_GetAllBooks(){
        // given
        when(bookRepository.findAll()).thenReturn(bookEntityList);
        int expected = 4;

        // when
        int actual = ((List) bookService.getAllBooks()).size();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void should_ThrowException_When_BookDoesNotExist(){
        // given
        Long id = 10L;
        Class expected = NoSuchEntityException.class;
        when(bookRepository.findById(id)).thenThrow(expected);

        // when
        Executable executable = () -> bookService.getBookById(id);

        // then
        assertThrows(expected, executable);
    }

    @Test
    public void should_GetLongestBook(){
        // given
        int expected = 1234;
        when(bookRepository.findTopByOrderByPageCountDesc()).thenReturn(java.util.Optional.ofNullable(bookEntityList.get(0)));

        // when
        int actual = bookService.getLongestBook().getPageCount();

        // then
        assertEquals(expected, actual);
    }

}