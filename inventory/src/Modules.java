public abstract class Modules {

    public void returnToMain() {
        UserInterface mainInterface = new UserInterface();

        mainInterface.menuMain();
    }

    public abstract void moduleDriver();

    public abstract void userOptions();

    public abstract void userInput();
}
