package hu.me.itt.webalk.gyak10_19;

import org.springframework.stereotype.Component;

@Component
@Scope()
public class ServiceImpl implements Service {
    private final Dependency dependency;
    private final String value;

    public ServiceImpl(Dependency dependency) {
        this.dependency = dependency;
        this.value = Double.toString(Math.random());
    }


    @Override
    public void calculate() {

    }

    @Override
    public String getValue() {
        return value;
    }
}
