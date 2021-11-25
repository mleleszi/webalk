package hu.me.iit.webalk.bid.service;

public class NoSuchEntityException extends RuntimeException {
    private Long id;

    public NoSuchEntityException(Long id) {
        super(String.format("No entity with id: %s", id));
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
