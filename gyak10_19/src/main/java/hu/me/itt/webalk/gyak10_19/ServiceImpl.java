package hu.me.itt.webalk.gyak10_19;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ServiceImpl implements Service {
    private final Dependency dependency;
    private String value;

    //  @Value(${sajat-cucc})
    public void setValue(String value) {
        this.value = value;
    }

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
