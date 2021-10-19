package hu.me.iit.webalk.dependency;

public class DependencyImpl implements Dependency {
    @Override
    public void helpNoParameterNoReturnValue() {}

    @Override
    public int helpNoParameterReturnValue() {
        return 45;
    }

    @Override
    public void helpWithParameterNoReturnValue(int a) {

    }
    @Override
    public String important(String a) {
        return  "<b>"+a+"</b>";
    }
}
