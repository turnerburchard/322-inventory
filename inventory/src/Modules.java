import java.io.IOException;

public abstract class Modules {

    public void returnToMain() throws IOException {
        UserInterface mainInterface = new UserInterface();

        mainInterface.menuMain();
    }

    public abstract void moduleDriver() throws IOException;

    public abstract void userOptions() throws IOException ;

    public abstract void userInput() throws IOException;
}
