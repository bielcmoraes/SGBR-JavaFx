package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EditarVendaController {

    @FXML
    private Button adicionarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private ComboBox<?> clienteComboBox;

    @FXML
    private DatePicker dataDatePicker;

    @FXML
    private Button editarButton;

    @FXML
    private TextField horasTextField;

    @FXML
    private ComboBox<?> mdpComboBox;

    @FXML
    private TextField minutosTextField;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    private ComboBox<?> pratoComboBox;

    @FXML
    private TableColumn<?, ?> pratoTableColumn;

    @FXML
    private TableView<?> pratosTableView;

    @FXML
    private Button removerButton;

    @FXML
    void adicionar(ActionEvent event) {

    }

    @FXML
    void cancelar(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void remover(ActionEvent event) {

    }

}
