package hu.me.iit.webalk.db.repository;

import hu.me.iit.webalk.db.repository.People;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PeopleRepository extends PagingAndSortingRepository<People, Long> {
}
