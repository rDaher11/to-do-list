package views;

public class StandardOutputTaskView implements ITaskView {


    @Override
    public void success(String massage) {
        System.out.println(massage);
    }

    @Override
    public void error(String massage) {
        System.out.println(massage);
    }

    @Override
    public void info(String massage) {
        System.out.println(massage);
    }
}
