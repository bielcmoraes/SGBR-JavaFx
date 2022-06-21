package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Prato;
import model.Produto;

public class CardapioController extends Tela implements Initializable{

    @FXML
    private Button cadastrarButton;

    @FXML
    private TableColumn<Prato, String> categoriaTableColumn;

    @FXML
    private TableColumn<Prato, String> descricaoTableColumn;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;

    @FXML
    private TableColumn<Prato, String> idTableColumn;

    @FXML
    private TableColumn<Prato, String> nomeTableColumn;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    private TableColumn<Prato, Double> precoTableColumn;

    @FXML
    private TableColumn<Prato, String> produtosTableColumn;

    @FXML
    private TableView<Prato> cardapioTableView;

    private ArrayList<Prato> cardapio = BancoDeDados.getInstance().getCardapio();
    
    private ObservableList<Prato> observableListCardapio;
    
    @FXML
    void cadastrarProduto(ActionEvent event) {

    }

    @FXML
    void editarProduto(ActionEvent event) {

    }

    @FXML
    void excluirProduto(ActionEvent event) {

    }

    public void carregarListaProdutos() {
		
		idTableColumn.setCellValueFactory(new PropertyValueFactory<Prato, String>("id"));
		nomeTableColumn.setCellValueFactory(new PropertyValueFactory<Prato, String>("nome"));
		precoTableColumn.setCellValueFactory(new PropertyValueFactory<Prato, Double>("preco"));        
		descricaoTableColumn.setCellValueFactory(new PropertyValueFactory<Prato, String>("descricao"));
		categoriaTableColumn.setCellValueFactory(new PropertyValueFactory<Prato, String>("categoria"));
		produtosTableColumn.setCellValueFactory(new PropertyValueFactory<Prato, String>("ProdutosToString"));
		
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
		
		observableListCardapio = FXCollections.observableArrayList();
		observableListCardapio.addAll(cardapio);
		cardapioTableView.setItems(observableListCardapio);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarListaProdutos();
		
	}

}
