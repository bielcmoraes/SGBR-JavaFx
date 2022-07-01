package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import exceptions.FormatoIngredientesInvalido;
import exceptions.PrecoInvalido;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import model.GerenciaCardapio;
import model.GerenciaProdutos;
import model.Prato;
import model.Produto;

public class CadastrarPratoController extends Tela implements Initializable{

    @FXML
    private Button adicionarButton;

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private ComboBox<String> categoriaComboBox;

    @FXML
    private TextField descricaoTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    private TextField precoTextField;

    @FXML
    private ComboBox<String> produtoComboBox;
    
    @FXML
    private ComboBox<String> medidaComboBox;

    @FXML
    private TableColumn<Ingrediente, String> produtoTableColumn;
    
    @FXML
    private TableColumn<Ingrediente, String> medidaTableColumn;

    @FXML
    private TableView<Ingrediente> produtosTableView;

    @FXML
    private TableColumn<Ingrediente, String> quantidadeTableColumn;

    @FXML
    private Button removerButton;
    
    @FXML
    private TextField quantidadeTextField;
    
    private ObservableList<Ingrediente> obsIngredientes;
    
    private ObservableList<String> obsProdutos;
    
    private ObservableList<String> obsCategorias;
    
    private ObservableList<String> obsMedidas;
    
	GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
	
	ArrayList<Prato> cardapio = BancoDeDados.getInstance().getCardapio();
	
	ArrayList<String> listaIds = BancoDeDados.getInstance().getListaIds();
	
	HashMap<String, ArrayList<Produto>> listaProdutos = BancoDeDados.getInstance().getListaProdutos();

    @FXML
    void adicionar(ActionEvent event) {
    	if (!produtoComboBox.getSelectionModel().isEmpty() && !medidaComboBox.getSelectionModel().isEmpty()
    			&& !quantidadeTextField.getText().isBlank()) {
    		String nome = produtoComboBox.getSelectionModel().getSelectedItem();
    	String quantidade = quantidadeTextField.getText();
    	String medida = medidaComboBox.getSelectionModel().getSelectedItem();
    	Ingrediente ingrediente = new Ingrediente(nome, medida, quantidade);
    	obsIngredientes.add(ingrediente);
    	obsProdutos.remove(nome);
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENÇÃO!");
    		alert.setHeaderText("Existe campos não preenchidos!");
    		alert.setContentText("Preenchas os campos restantes antes de adicionar.");
    		alert.showAndWait();
    	}
    	
    }
    
    @FXML
    void remover(ActionEvent event) {
    	if (!produtosTableView.getSelectionModel().isEmpty()) {
    		Ingrediente ingrediente = produtosTableView.getSelectionModel().getSelectedItem();
	    	obsIngredientes.remove(ingrediente);
	    	obsProdutos.add(ingrediente.getNome());
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENÇÃO!");
    		alert.setHeaderText("Nenhum item selecionado!");
    		alert.setContentText("Selecione um item na tabela para que possa remove-lo.");
    		alert.showAndWait();
    	}
    	
    }

    @FXML
    void cadastrar(ActionEvent event) {
    	if (!nomeTextField.getText().isBlank() && !precoTextField.getText().isBlank()
    			&& !descricaoTextField.getText().isBlank() && !categoriaComboBox.getSelectionModel().isEmpty()
    			&& !obsIngredientes.isEmpty()) {
    		String nome = nomeTextField.getText();
	    	String preco = precoTextField.getText();
	    	String descricao = descricaoTextField.getText();
	    	String categoria = categoriaComboBox.getSelectionModel().getSelectedItem();
	    	
	    	String ingredientes = "";
	    	for (Ingrediente ingrediente: obsIngredientes) {
	    		ingredientes += ingrediente.getQuantidade() + ";" + ingrediente.getMedida()+ ";" + ingrediente.getNome() + ";";
	    	}
	    	
	    	String [] info = new String[5];
	    	
			info[0] = nome;
			info[1] = preco;
			info[2] = descricao;
			info[3] = categoria;
			info[4] = ingredientes;
	    	
	    	try {
				gerenciaCardapio.cadastrarPrato(cardapio, listaIds, listaProdutos, info);
			} catch (PrecoInvalido | QuantidadeInvalida | ProdutoNaoCadastrado | FormatoIngredientesInvalido
					| ErroGrave e) {
				e.printStackTrace();
			}
	    	
	    	atualizarPainel("/view/Cardapio.fxml");
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENÇÃO!");
    		alert.setHeaderText("Existe campos não preenchidos!");
    		alert.setContentText("Preenchas os campos restantes antes de cadastrar.");
    		alert.showAndWait();
    	}
    	
    }

    @FXML
    void cancelar(ActionEvent event) {
    	atualizarPainel("/view/Cardapio.fxml");
    }
    
    private void carregarProdutos() {
		obsProdutos = FXCollections.observableArrayList(BancoDeDados.getInstance().getListaProdutos().keySet());
		produtoComboBox.setItems(obsProdutos);
    }
    
    private void carregarCategorias() {
		obsCategorias = FXCollections.observableArrayList("Entrada", "Massa", "Sobremesa", "Bebida", "Lanche");
		categoriaComboBox.setItems(obsCategorias);
    }
    
	private void carregarMedidas() {
		obsMedidas = FXCollections.observableArrayList("kg", "g", "l", "ml", "un.");
		medidaComboBox.setItems(obsMedidas);
	}
    
    private void carregarIngredientes() {
		produtoTableColumn.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("nome"));
		medidaTableColumn.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("medida"));
		quantidadeTableColumn.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("quantidade"));
		obsIngredientes = FXCollections.observableArrayList();
		produtosTableView.setItems(obsIngredientes);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarMedidas();
		carregarProdutos();
		carregarCategorias();
		carregarIngredientes();
		
		permiteDecimal(precoTextField);
		permiteDecimal(quantidadeTextField);
	}

}
