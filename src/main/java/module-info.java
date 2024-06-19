module io.jp {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens io.jp to javafx.fxml;

    exports io.jp;
}
