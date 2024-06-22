module io.jp {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens io.jp to javafx.fxml;
    opens io.jp.gui to javafx.fxml;

    exports io.jp;
    exports io.jp.model.entities;
}
