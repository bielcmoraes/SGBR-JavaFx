package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.Cliente;

public class CadastrarVendaController {

    @FXML
    private Button adicionarButton;

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private ComboBox<Cliente> clienteComboBox;

    @FXML
    private ComboBox<?> mdpComboBox;

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
    void cadastrar(ActionEvent event) {

    }

    @FXML
    void cancelar(ActionEvent event) {

    }

    @FXML
    void remover(ActionEvent event) {

    }

}