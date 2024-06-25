module io.jp {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens io.jp to javafx.fxml;
    opens io.jp.gui to javafx.fxml;

    exports io.jp;
    exports io.jp.model.entities;
}
