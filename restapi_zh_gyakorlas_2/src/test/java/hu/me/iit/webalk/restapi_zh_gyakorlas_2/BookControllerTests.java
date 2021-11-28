package hu.me.iit.webalk.restapi_zh_gyakorlas_2;

import hu.me.iit.webalk.restapi_zh_gyakorlas_2.repository.BookEntity;
import hu.me.iit.webalk.restapi_zh_gyakorlas_2.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class BookControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    public void setup(){
        List<BookEntity> bookEntityList = new ArrayList<>(Arrays.asList(
                new BookEntity(1L, "sanyi", 1234),
                new BookEntity(2L, "sanyi", 122),
                new BookEntity(3L, "levi", 800),
                new BookEntity(4L, "donat", 100)
        ));

        bookEntityList.forEach(b -> bookRepository.save(b));
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void should_NoMainPage() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
