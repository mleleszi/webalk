package hu.me.iit.webalk.bid;

import hu.me.iit.webalk.bid.repository.BidEntity;
import hu.me.iit.webalk.bid.repository.BidRepository;
import hu.me.iit.webalk.bid.service.NoSuchEntityException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class BidControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BidRepository bidRepository;

    @BeforeEach
    public void setup(){
        List<BidEntity> bidEntityList = new ArrayList<>(
                Arrays.asList(
                        new BidEntity(1L, 1L, 1231L),
                        new BidEntity(2L, 1L, 12313L),
                        new BidEntity(3L, 2L, 12313L),
                        new BidEntity(4L, 2L, 321L)
                )
        );

        bidEntityList.forEach(b -> bidRepository.save(b));
    }

    @Test
    public void should_NoMainPage() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void should_GetAllBids() throws Exception {
        mockMvc.perform(get("/bid"))
                .andDo(print())
                .andExpect(content().string("[{\"id\":1,\"userId\":1,\"bid\":1231},{\"id\":2,\"userId\":1,\"bid\":12313},{\"id\":3,\"userId\":2,\"bid\":12313},{\"id\":4,\"userId\":2,\"bid\":321}]"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_GetBidById_When_Exists() throws Exception {
        mockMvc.perform(get("/bid/2"))
                .andDo(print())
                .andExpect(content().string("{\"id\":2,\"userId\":1,\"bid\":12313}"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_Return404_When_BidDoesNotExist() throws Exception {
        mockMvc.perform(get("/bid/10"))
                .andDo(print())
                .andExpect(content().string("No entity with id: 10"))
                .andExpect(status().isNotFound());
    }

    @Test
    void contextLoads() {
    }



}
