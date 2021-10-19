package hu.me.iit.webalk.dependency;

public class ServiceImpl implements Service {
    private final Dependency dependency;

    public ServiceImpl(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public void calculate() {
        dependency.helpNoParameterNoReturnValue();
    }

    @Override
    public int returnFive() {
        return 5;
    }

    @Override
    public int callHelpAndUseReturnValue() {
        int result = dependency.helpNoParameterReturnValue();
        return result;
    }

    @Override
    public void callHelpAndPassParameter5(){
        dependency.helpWithParameterNoReturnValue(5);
    }

    @Override
    public String getImportantAbstract(String a) {

        String goal = getFirst3Char(a);

        String result = dependency.important(goal);

        return result;
    }

    public String getFirst3Char(String a){
        String getFirstThreeCharacter = a.substring(0, Math.min(a.length(), 3));
        String result = getFirstThreeCharacter + "...";
        return result;
    }


}
