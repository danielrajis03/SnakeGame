module example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jlayer;
    requires junit;
    requires javafx.graphics;
    requires javafx.base;




    opens gameObjects to javafx.fxml;
    exports gameObjects;
    opens controller;
    exports GamePlay;
    opens GamePlay to javafx.fxml;
    

    exports controller;
    opens fxml;
    //opens food;
    exports Model;
    opens Model to javafx.fxml;
}

