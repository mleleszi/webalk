package hu.me.iit.webalk.random_proverb.service;

import hu.me.iit.webalk.random_proverb.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomServiceImpl implements RandomService {

    private final Repository repository;

    public RandomServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public String getRandomStudent() {
        int rand = ThreadLocalRandom.current().nextInt(0, repository.readAllStudents().size() - 1);
        return repository.readAllStudents().get(rand);
    }

    @Override
    public String getRandomProverb() {
        int rand = ThreadLocalRandom.current().nextInt(0, repository.readAllProverbs().size() - 1);
        return repository.readAllProverbs().get(rand);
    }
}
