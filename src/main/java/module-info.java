module edu.fiuba.algo3 {
    requires javafx.controls;
    requires json.simple;
    requires javafx.fxml;
    exports edu.fiuba.algo3;
    opens edu.fiuba.algo3.controladores to javafx.fxml;
    opens edu.fiuba.algo3.controladores.vistas to javafx.fxml;
    opens edu.fiuba.algo3.vistas to javafx.fxml;
}