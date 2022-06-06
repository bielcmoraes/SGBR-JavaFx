package controller;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoQuantidadeInvalido;
import exceptions.FornecedorNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.QuantidadeInvalida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Fornecedor;
import model.GerenciaProdutos;
import model.Produto;

public class CadastrarProdutoController implements Initializable{

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private ComboBox<Fornecedor> fornecedorComboBox;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField precoTextField;

    @FXML
    private TextField quantidadeTextField;

    @FXML
    private DatePicker validadeDatePicker;
    
    private ObservableList<Fornecedor> obsFornecedores;
    
    @FXML
    private void cadastrar(ActionEvent event) {
    	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	
    	String nome =  nomeTextField.getText();
    	String preco = precoTextField.getText();
    	String quantidade = quantidadeTextField.getText();
    	String validade = validadeDatePicker.getValue().format(formatoData);
    	String fornecedor = fornecedorComboBox.getSelectionModel().getSelectedItem().toString();
    	
    	String [] info = new String[5];
		info[0] = nome;
		info[1] = preco;
		info[2] = quantidade;
		info[3] = validade;
		info[4] = fornecedor;
		
    	GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
    	try {
			gerenciaProdutos.cadastrarProduto(Main.getBancoDeDados().getListaProdutos(), Main.getBancoDeDados().getListaIds(), info, Main.getBancoDeDados().getListaFornecedores());
		} catch (PrecoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FormatoQuantidadeInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QuantidadeInvalida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FormatoDataInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FornecedorNaoCadastrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErroGrave e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	trocarTela(event, "/view/Produtos.fxml");
    }
    
    @FXML
    private void cancelar(ActionEvent event) {
    	trocarTela(event, "/view/Produtos.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarFornecedores();
		
	}
	
	private void carregarFornecedores() {
		obsFornecedores = FXCollections.observableArrayList(Main.getBancoDeDados().getListaFornecedores());
		fornecedorComboBox.setItems(obsFornecedores);
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
	
}
