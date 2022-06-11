package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Fornecedor;
import model.GerenciaFornecedor;
import model.GerenciaUsuario;

public class FornecedoresController implements Initializable{

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;
    
    @FXML
    private AnchorPane painelAnchorPane;
    
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
    
    private ArrayList<Fornecedor> listaFornecedores = BancoDeDados.getInstance().getListaFornecedores();
    
    private ObservableList<Fornecedor> observableListFornecedor;
    
    //Métodos
    @FXML
    void cadastrarFornecedor(ActionEvent event) {
    	atualizarPainel("/view/CadastroFornecedor.fxml");
    }
    
    @FXML
    void editarFornecedor(ActionEvent event) {
    	
    }

    @FXML
    void excluirFornecedor(ActionEvent event) {
    	
    	String idSelecionado = tabelaFornecedores.getSelectionModel().getSelectedItem().getId();
    	GerenciaFornecedor gerenciaFornecedor = new GerenciaFornecedor();
    	try {
    		gerenciaFornecedor.excluirFornecedor(BancoDeDados.getInstance().getListaFornecedores(), BancoDeDados.getInstance().getListaIds(), idSelecionado);
		} catch (ErroGrave e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	carregarListaUsuarios();
    }
    
    @FXML
    void voltarParaMain(ActionEvent event) {

    }
    
    private void atualizarPainel(String url) {
		try {
			AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
			AnchorPane.setTopAnchor(a, 0.0);
			AnchorPane.setBottomAnchor(a, 0.0);
			AnchorPane.setLeftAnchor(a, 0.0);
			AnchorPane.setRightAnchor(a, 0.0);
			painelAnchorPane.getChildren().clear();
			painelAnchorPane.getChildren().add(a);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
