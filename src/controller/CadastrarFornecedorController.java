package controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.GerenciaFornecedor;
import model.Produto;

public class CadastrarFornecedorController implements Initializable{

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField cnpjTextField;

    @FXML
    private TextField enderecoTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private AnchorPane painelAnchorPane;
    
    @FXML
    private ComboBox<String> produtosComboBox;
    
    @FXML
    private Button removerProduto;
    
    @FXML
    private Button adicionarProduto;
    
    @FXML
    private TableView<Produto> produtosTableView;
    
    @FXML
    private TableColumn<Produto, String> produtosColuna;
    
    private ObservableList<String> obsProdutos;
    private ObservableList<Produto> produtosDaTabela;
    
    //Metodos
    @FXML
    void adicionarLista(ActionEvent event) {
    	if(!produtosComboBox.getSelectionModel().isEmpty()) {
    		Produto produtoSelecionado = BancoDeDados.getInstance().getListaProdutos().get(produtosComboBox.getSelectionModel().getSelectedItem()).get(0);
    		if(!produtosDaTabela.contains(produtoSelecionado)) {
    			produtosDaTabela.add(produtoSelecionado);
    		}else {
    			Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("ATENCAO!");
        		alert.setHeaderText("Produto ja adicionado!");
        		alert.setContentText("Selecione outro produto!");
        		alert.showAndWait();
    		}
    		}else {
    			Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("ATENCAO!");
        		alert.setHeaderText("Produto não selecionado!");
        		alert.setContentText("Selecione um produto antes de adiciona-lo!");
        		alert.showAndWait();
    		}
    	
    }
    
    @FXML
    void removerLista(ActionEvent event) {
    	if(!produtosTableView.getSelectionModel().isEmpty()) {
    		produtosDaTabela.remove(produtosTableView.getSelectionModel().getSelectedItem());
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Produto não selecionado!");
    		alert.setContentText("Selecione um produto antes de remove-lo!");
    		alert.showAndWait();
    	}
    }

    @FXML
    void cadastrar(ActionEvent event) {
    	
    	String nome = nomeTextField.getText();
    	String cnpj = cnpjTextField.getText();
    	String endereco = enderecoTextField.getText();
    	
    	String [] info = new String[3];
		info[0] = nome;
		info[1] = cnpj;
		info[2] = endereco;
		
		GerenciaFornecedor gerenciaFornecedores = new GerenciaFornecedor();
		
		try {
			gerenciaFornecedores.cadastrarFornecedor(BancoDeDados.getInstance().getListaFornecedores(), BancoDeDados.getInstance().getListaIds(), info);
		} catch (ErroGrave e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		atualizarPainel("/view/Fornecedores.fxml");
    }
    	
    @FXML
    void cancelar(ActionEvent event) {
    	atualizarPainel("/view/Fornecedores.fxml");
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
    
    private void preencherComboBox() {
		obsProdutos = FXCollections.observableArrayList(BancoDeDados.getInstance().getListaProdutos().keySet());
		produtosComboBox.setItems(obsProdutos);
    }
    
    private void carregarTableView() {
    	produtosColuna.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
    	produtosDaTabela = FXCollections.observableArrayList();
    	produtosTableView.setItems(produtosDaTabela);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		preencherComboBox();
		carregarTableView();
		
	}

}
