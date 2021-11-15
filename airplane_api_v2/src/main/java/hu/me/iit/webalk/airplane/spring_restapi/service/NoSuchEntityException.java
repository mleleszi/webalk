package hu.me.iit.webalk.airplane.spring_restapi.service;

public class NoSuchEntityException extends RuntimeException {
    private Long id;


    public NoSuchEntityException(Long id) {
        super(String.format("No entity with id: %d", id));
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
