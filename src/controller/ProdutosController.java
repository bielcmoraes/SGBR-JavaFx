package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Fornecedor;
import model.Produto;
import model.Usuario;

public class ProdutosController implements Initializable{

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;
    
    @FXML
    private TableView<Produto> tabelaProdutos;
 
    @FXML
    private TableColumn<Produto, String> fornecedores;

    @FXML
    private TableColumn<Produto, String> idTableColumn;

    @FXML
    private TableColumn<Produto, String> medidaTableColumn;

    @FXML
    private TableColumn<Produto, String> nomeTableColumn;

    @FXML
    private TableColumn<Produto, Double> precoTableColumn;

    @FXML
    private TableColumn<Produto, Double> quantidadeTableColumn;

    @FXML
    private TableColumn<Produto, LocalDate> validadeTableColumn;

    @FXML
    private Button voltarButton;
    
    private HashMap<String, ArrayList<Produto>> listaProdutos = Main.getBancoDeDados().getListaProdutos();
    
    private ObservableList<Produto> observableListProdutos;
    
    //Métodos
    @FXML
    void cadastrarProduto(ActionEvent event) {
    	trocarTela(event, "/view/CadastrarProduto.fxml");
    }
    
    @FXML
    void voltarParaMain(ActionEvent event) {
    	trocarTela(event, "/view/MenuGerente.fxml");
    }
    
    private void trocarTela(ActionEvent event, String url) {
    	Node node = (Node) event.getSource();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(url));
			node.getScene().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public void carregarListaProdutos() {
			
			idTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, String>("id"));
			nomeTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
			precoTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, Double>("preco"));
			quantidadeTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, Double>("quantidade"));
			medidaTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, String>("unidadeDeMedida"));
			validadeTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, LocalDate>("validade"));
			fornecedores.setCellValueFactory(new PropertyValueFactory<Produto, String>("fornecedoresToString"));
			
			
			for(ArrayList<Produto> estoque: listaProdutos.values()) {
				observableListProdutos = FXCollections.observableArrayList(estoque);
				}
				
				tabelaProdutos.setItems(observableListProdutos);	
		}
    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarListaProdutos();
		
	}
}
