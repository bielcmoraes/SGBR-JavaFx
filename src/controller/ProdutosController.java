package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.GerenciaProdutos;
import model.GerenciaUsuario;
import model.Produto;

public class ProdutosController implements Initializable{

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;
    
    @FXML
    private AnchorPane painelAnchorPane;
    
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
    
    private HashMap<String, ArrayList<Produto>> listaProdutos = BancoDeDados.getInstance().getListaProdutos();
    
    private ObservableList<Produto> observableListProdutos;
    
    //Métodos
    @FXML
    void cadastrarProduto(ActionEvent event) {
    	atualizarPainel("/view/CadastrarProduto.fxml");
    }
    
    @FXML
    void excluirProduto(ActionEvent event) {
    	String idSelecionado = tabelaProdutos.getSelectionModel().getSelectedItem().getId();
    	GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
    	try {
    		gerenciaProdutos.excluirProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), idSelecionado);
		} catch (ErroGrave e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	carregarListaProdutos();
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
    
	public void carregarListaProdutos() {
			
			idTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, String>("id"));
			nomeTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
			precoTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, Double>("preco"));        
			quantidadeTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, Double>("quantidade"));
			medidaTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, String>("unidadeDeMedida"));
			validadeTableColumn.setCellValueFactory(new PropertyValueFactory<Produto, LocalDate>("validade"));
			fornecedores.setCellValueFactory(new PropertyValueFactory<Produto, String>("fornecedoresToString"));
			
			precoTableColumn.setCellFactory(c -> new TableCell<>() {
			    @Override
			    protected void updateItem(Double preco, boolean empty) {
			        super.updateItem(preco, empty);
			        if (preco == null || empty) {
			            setText(null);
			        } else {
			            setText(String.format("R$ %.2f", preco));
			        }
			    }
			});
			
			validadeTableColumn.setCellFactory(c -> new TableCell<>() {
			    @Override
			    protected void updateItem(LocalDate validade, boolean empty) {
			        super.updateItem(validade, empty);
			        if (validade == null || empty) {
			            setText(null);
			        } else {
			        	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			            setText(validade.format(formatoData));
			        }
			    }
			});
			
			observableListProdutos = FXCollections.observableArrayList();
			for(ArrayList<Produto> estoque: listaProdutos.values()) {
				observableListProdutos.addAll(estoque);
				}
				
				tabelaProdutos.setItems(observableListProdutos);	
		}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarListaProdutos();
		
	}
}
