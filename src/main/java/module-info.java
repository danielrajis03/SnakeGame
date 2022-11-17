module example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jlayer;



    opens example to javafx.fxml;
    exports example;
}