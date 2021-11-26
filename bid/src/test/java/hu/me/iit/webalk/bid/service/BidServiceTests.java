package hu.me.iit.webalk.bid.service;

import hu.me.iit.webalk.bid.repository.BidEntity;
import hu.me.iit.webalk.bid.repository.BidRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BidServiceTests {

    @InjectMocks
    BidServiceImpl bidService;

    @Mock
    BidRepository bidRepository;

    List<BidEntity> bidEntityList;

    @BeforeEach
    public void setup(){
        bidEntityList = new ArrayList<>(Arrays.asList(
                new BidEntity(1L, 1L, 1123L),
                new BidEntity(2L, 1L, 1123L),
                new BidEntity(3L, 2L, 1232L),
                new BidEntity(4L, 3L, 1231312L)
                ));
    }

    @Test
    public void should_GetAllBids(){
        // given
        when(bidRepository.findAll()).thenReturn((Iterable) bidEntityList);
        int expected = 4;

        // when
        int actual = ((List) bidService.getAllBids()).size();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void should_GetBidById_When_BidExists(){
        // given
        Long expected = 2L;
        when(bidRepository.findById(expected)).thenReturn(java.util.Optional.ofNullable(bidEntityList.get(1)));

        // when
        Long actual = bidService.getBidById(expected).getId();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void should_ThrowException_When_BidDoesNotExist(){
        // given
        Class expected = NoSuchEntityException.class;
        when(bidRepository.findById(anyLong())).thenThrow(expected);

        // when
        Executable executable = () -> bidService.getBidById(10L);

        // then
        assertThrows(expected, executable);
    }

    @Test
    public void should_DeleteBid_When_BidExists(){
        // given
        Long id = 2L;

        // when
        bidService.deleteById(id);

        // then
        verify(bidRepository, times(1)).deleteById(id);
    }

    @Test
    public void should_NotDeleteBid_When_BidDoesNotExist(){
        // given
        Class expected = NoSuchEntityException.class;
        doThrow(expected).when(bidRepository).deleteById(anyLong());

        // when
        Executable executable = () -> bidService.deleteById(10L);

        // then
        assertThrows(expected, executable);
    }

}