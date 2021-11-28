package hu.me.iit.webalk.restapi_zh_gyakorlas_2.service;

public class NoSuchEntityException extends RuntimeException {
    private Long id;

    public NoSuchEntityException(Long id) {
        super(String.format("No entity with id: %s", id));
        this.id = id;
    }

    public NoSuchEntityException() {
        super("No such entity");
    }

    public Long getId() {
        return id;
    }
}
