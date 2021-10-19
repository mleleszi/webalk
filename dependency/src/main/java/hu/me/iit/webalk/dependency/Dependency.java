package hu.me.iit.webalk.dependency;

public interface Dependency {
    void helpNoParameterNoReturnValue();
    int helpNoParameterReturnValue();
    void helpWithParameterNoReturnValue(int a);
   // void helpWithParameterNoReturnValue(String str);
    String important(String a);
}
