package hu.me.iit.webalk.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface LicitRepository extends PagingAndSortingRepository<LicitEntity, Long> {
    LicitEntity findTopByOrderByLicitDesc();

    LicitEntity findTopByUseridAndOrderByLicitDesc(Long userId);
}
