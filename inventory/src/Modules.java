import java.io.IOException;

// Written by:
// Reviewed by:

public abstract class Modules { // abstract class for system function modules
    // clear OCP area of the system, can always add new module to add new system functions

    public void returnToMain() throws IOException { // returns system to main menu when in a module
        UserInterface mainInterface = new UserInterface();

        mainInterface.menuMain();
    }

    public abstract void moduleDriver() throws IOException; // a module's driver, must be unique for each module
}
