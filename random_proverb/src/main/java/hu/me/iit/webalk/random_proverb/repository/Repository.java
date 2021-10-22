package hu.me.iit.webalk.random_proverb.repository;

import java.util.List;

public interface Repository {
    List<String> readAllStudents();
    List<String> readAllProverbs();

}
