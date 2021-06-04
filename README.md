# CustomGrid

This is a step-by-step example of how to integrate various client-side features with Vaadin Flow. You can view the commit history to see how integration features are incrementally introduced.

The project is a standard Maven project, so you can import it to your IDE of choice. [Read more how to set up a development environment](https://vaadin.com/docs/v14/flow/installing/installing-overview.html) for Vaadin projects (Windows, Linux, macOS). 

This project was created from https://start.vaadin.com.

## Running and debugging the application

### Running the application from the command line.
To run from the command line, use `mvn` and open http://localhost:8080 in your browser.

### Running and debugging the application in Intellij IDEA
- Locate the Application.java class in the Project view. It is in the src folder, under the main package's root.
- Right-click on the Application class
- Select "Debug 'Application.main()'" from the list

After the application has started, you can view it at http://localhost:8080/ in your browser. 
You can now also attach breakpoints in code for debugging purposes, by clicking next to a line number in any source file.

### Running and debugging the application in Eclipse
- Locate the Application.java class in the Package Explorer. It is in `src/main/java`, under the main package.
- Right-click on the file and select `Debug As` --> `Java Application`.

Do not worry if the debugger breaks at a `SilentExitException`. This is a Spring Boot feature and happens on every startup.

After the application has started, you can view it at http://localhost:8080/ in your browser.
You can now also attach breakpoints in code for debugging purposes, by clicking next to a line number in any source file.
