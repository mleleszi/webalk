package hu.me.iit.webalk.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface LicitRepository extends PagingAndSortingRepository<LicitEntity, Long> {
    Optional<LicitEntity> findTopByOrderByLicitDesc();

    Optional<LicitEntity>  findTopByUserIdAndOrderByLicitDesc(Long userId);
}
