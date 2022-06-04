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
import model.Fornecedor;

public class FornecedoresController implements Initializable{

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;
    
    @FXML
    private TableView<Fornecedor> tabelaFornecedores;
    
    @FXML
    private TableColumn<Fornecedor, String> idTableColumn;

    @FXML
    private TableColumn<Fornecedor, String> nomeTableColumn;

    @FXML
    private TableColumn<Fornecedor, String> cnpjTableColumn;

    @FXML
    private TableColumn<Fornecedor, String> enderecoTableColumn;
    
    @FXML
    private TableColumn<Fornecedor, String> produtosTableColumn;

    @FXML
    private Button voltarButton;
    
    private ArrayList<Fornecedor> listaFornecedores = Main.getBancoDeDados().getListaFornecedores();
    
    private ObservableList<Fornecedor> observableListFornecedor;
    
    //Métodos
    @FXML
    void cadastrarFornecedor(ActionEvent event) {

    }
    
    @FXML
    void editarFornecedor(ActionEvent event) {

    }

    @FXML
    void excluirFornecedor(ActionEvent event) {

    }
    
    @FXML
    void voltarParaMain(ActionEvent event) {

    }
    
    public void carregarListaUsuarios() {
		
    	idTableColumn.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("id"));
    	nomeTableColumn.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nome"));
    	cnpjTableColumn.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("cnpj"));
    	enderecoTableColumn.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("endereco"));
    	produtosTableColumn.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("produtosToString"));
    	
		
		observableListFornecedor = FXCollections.observableArrayList(listaFornecedores);
		tabelaFornecedores.setItems(observableListFornecedor);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarListaUsuarios();
	}

}
