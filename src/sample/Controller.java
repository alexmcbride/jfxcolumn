package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.skin.TableViewSkin;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class Controller {
    @FXML
    public TableView<Record> recordTableView;

    @FXML
    private TableColumn<Record, String> nameColumn;

    @FXML
    private Button clickButton;

    private ObservableList<Record> recordObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        recordTableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

        clickButton.setOnAction(actionEvent -> {
            recordObservableList.add(new Record("This is an even longer really long string what happens?!!!?!! 1"));
            autoResizeColumns(recordTableView);
        });

        recordObservableList.addAll(new Record("This is a really long string what happens? 1"), new Record("Test 2"));

        nameColumn.setCellValueFactory(record -> record.getValue().getNameProperty());
        recordTableView.setItems(recordObservableList);

        autoResizeColumns(recordTableView);
    }

    public static void autoResizeColumns(TableView<?> table) {
        table.getColumns().forEach((column) ->
        {
            Text text = new Text(column.getText());
            double maxWidth = text.getLayoutBounds().getWidth();
            for (int i = 0; i < table.getItems().size(); i++) {
                if (column.getCellData(i) != null) {
                    text = new Text(column.getCellData(i).toString());
                    double textWidth = text.getLayoutBounds().getWidth();
                    if (textWidth > maxWidth) {
                        maxWidth = textWidth;
                    }
                }
            }
            column.setPrefWidth(maxWidth + 10.0d); // plus some padding
        });
    }
}
