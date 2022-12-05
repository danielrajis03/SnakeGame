module example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jlayer;


    opens example to javafx.fxml;
    exports example;
    opens controller;
    exports GamePlay;
    opens GamePlay to javafx.fxml;
    opens com.example.snake to javafx.fxml;

    exports controller;
    opens fxml;

    exports com.example.snake.model;
    opens com.example.snake.model to javafx.fxml;
}

