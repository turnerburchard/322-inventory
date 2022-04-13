public interface ModuleSpecific { // for Modules children, methods that are needed but must be specific to a module

    void driver(); // drives functionality of module

    void userOptions(); // presents options available to user during the module

    void userInput(); // processes user input specific to module
}
