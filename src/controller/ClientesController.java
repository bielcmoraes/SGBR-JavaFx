package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Cliente;

public class ClientesController implements Initializable{

    @FXML
    private Button cadastrarButton;

    @FXML
    private TableColumn<Cliente, String> cpfTableColumn;

    @FXML
    private Button editarButton;

    @FXML
    private TableColumn<Cliente, String> emailTableColumn;

    @FXML
    private Button excluirButton;

    @FXML
    private TableColumn<Cliente, String> idTableColumn;

    @FXML
    private TableColumn<Cliente, String> nomeTableColumn;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableColumn<Cliente, String> telefoneTableColumn;
    
    private ArrayList<Cliente> listaClientes = BancoDeDados.getInstance().getListaClientes();
    
    private ObservableList<Cliente> observableListUsuarios;
    
    //Metodo
    @FXML
    void cadastrarUsuario(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void excluirUsuario(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarListaClientes();
		
	}
	
	public void carregarListaClientes() {
		
		idTableColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("id"));
		nomeTableColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
		cpfTableColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
		emailTableColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
		telefoneTableColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
		
		observableListUsuarios = FXCollections.observableArrayList(listaClientes);
		tabelaClientes.setItems(observableListUsuarios);
	}

}