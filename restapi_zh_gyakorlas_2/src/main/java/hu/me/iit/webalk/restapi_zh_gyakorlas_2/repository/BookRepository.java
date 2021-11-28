package hu.me.iit.webalk.restapi_zh_gyakorlas_2.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BookRepository extends PagingAndSortingRepository<BookEntity, Long> {
    Iterable<BookEntity> findAllByAuthor(String author);
    Optional<BookEntity> findTopByOrderByPageCountDesc();
}
