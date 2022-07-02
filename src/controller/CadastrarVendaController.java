package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import exceptions.ClienteNaoCadastrado;
import exceptions.ErroGrave;
import exceptions.FormatoIngredientesInvalido;
import exceptions.PratoNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.ProdutoNaoCadastrado;
import exceptions.QuantidadeInvalida;
import exceptions.QuantidadeProdutosInsuficiente;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Cliente;
import model.GerenciaVendas;
import model.Prato;
import model.Produto;
import model.Venda;

public class CadastrarVendaController extends Tela implements Initializable{

    @FXML
    private Button adicionarButton;

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private ComboBox<Cliente> clienteComboBox;

    @FXML
    private ComboBox<String> mdpComboBox;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    private ComboBox<Prato> pratoComboBox;

    @FXML
    private TableColumn<Prato, String> pratoTableColumn;

    @FXML
    private TableView<Prato> comprasTableView;

    @FXML
    private Button removerButton;
    
    private ObservableList<Prato> obsCompras;
    
    private ObservableList<Prato> obsPratos;
    
    private ObservableList<Cliente> obsClientes;
    
    private ObservableList<String> obsMdps;
    
    private GerenciaVendas gerenciaVendas = new GerenciaVendas();
    
    private ArrayList<Venda> listaVendas = BancoDeDados.getInstance().getListaVendas();
    
    private ArrayList<Cliente> listaClientes = BancoDeDados.getInstance().getListaClientes();
    
    private ArrayList<Prato> cardapio = BancoDeDados.getInstance().getCardapio();
	
    private ArrayList<String> listaIds = BancoDeDados.getInstance().getListaIds();
	
    private HashMap<String, ArrayList<Produto>> listaProdutos = BancoDeDados.getInstance().getListaProdutos();

    @FXML
    void cadastrar(ActionEvent event) {
    	if (!clienteComboBox.getSelectionModel().isEmpty()
    			&& !mdpComboBox.getSelectionModel().isEmpty()
    			&& !obsCompras.isEmpty()) {
    		String cliente = clienteComboBox.getSelectionModel().getSelectedItem().getNome();
	    	String mdp = mdpComboBox.getSelectionModel().getSelectedItem();
	    	
	    	String compras = "";
	    	for (Prato prato: obsCompras) {
	    		compras += prato.getNome() + ", ";
	    	}
	    	
			compras = compras.substring(0, compras.length()-2);
	    	
	    	String [] info = new String[3];
	    	
			info[0] = compras;
			info[1] = mdp;
			info[2] = cliente;
	    	
			try {
				gerenciaVendas.cadastrarVenda(listaVendas, listaIds, cardapio, info, listaProdutos, listaClientes);
			} catch (PratoNaoCadastrado | QuantidadeProdutosInsuficiente | ErroGrave | ClienteNaoCadastrado e) {
				e.printStackTrace();
			}
	    	
	    	atualizarPainel("/view/Vendas.fxml");
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Existe campos nao preenchidos!");
    		alert.setContentText("Preenchas os campos restantes antes de cadastrar.");
    		alert.showAndWait();
    	}
    }

    @FXML
    void cancelar(ActionEvent event) {
    	atualizarPainel("/view/Vendas.fxml");
    }
    
    @FXML
    void adicionar(ActionEvent event) {
    	if (!pratoComboBox.getSelectionModel().isEmpty()) {
    		obsCompras.add(pratoComboBox.getSelectionModel().getSelectedItem());
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Existe campos nao preenchidos!");
    		alert.setContentText("Preenchas os campos restantes antes de adicionar.");
    		alert.showAndWait();
    	}
    }

    @FXML
    void remover(ActionEvent event) {
    	if (!comprasTableView.getSelectionModel().isEmpty()) {
	    	obsCompras.remove(comprasTableView.getSelectionModel().getSelectedItem());
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Nenhum item selecionado!");
    		alert.setContentText("Selecione um item na tabela para que possa remove-lo.");
    		alert.showAndWait();
    	}
    }
    
    private void carregarClientes() {
		obsClientes = FXCollections.observableArrayList(BancoDeDados.getInstance().getListaClientes());
		clienteComboBox.setItems(obsClientes);
    }
    
    private void carregarPratos() {
		obsPratos = FXCollections.observableArrayList(BancoDeDados.getInstance().getCardapio());
		pratoComboBox.setItems(obsPratos);
    }
    
	private void carregarMdps() {
		obsMdps = FXCollections.observableArrayList("Cartão", "Pix", "Dinheiro");
		mdpComboBox.setItems(obsMdps);
	}
	
    private void carregarCompras() {
		pratoTableColumn.setCellValueFactory(new PropertyValueFactory<Prato, String>("nome"));
		obsCompras = FXCollections.observableArrayList();
		comprasTableView.setItems(obsCompras);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarClientes();
		carregarPratos();
		carregarMdps();
		carregarCompras();
		
	}

}