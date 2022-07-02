package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import exceptions.NaoEncontrado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Cliente;
import model.GerenciaCliente;

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
    	atualizarPainel("/view/CadastrarCliente.fxml");
    }

    @FXML
    void editar(ActionEvent event) {
    	Cliente cliente = tabelaClientes.getSelectionModel().getSelectedItem();
    	if(cliente != null) {
    		ObjetoSelecionado.getInstance().setObj(cliente);
    		atualizarPainel("/view/EditarCliente.fxml");
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Nenhum cliente selecionado!");
    		alert.setContentText("Selecione um cliente na tabela para que possa edita-lo.");
    		alert.showAndWait();
    	}
    }

    @FXML
    void excluirCliente(ActionEvent event) {
    	
    	if(tabelaClientes.getSelectionModel().getSelectedItem() != null) {
    		String idSelecionado = tabelaClientes.getSelectionModel().getSelectedItem().getId();
        	GerenciaCliente gerenciaCliente = new GerenciaCliente();
        	try {
    			gerenciaCliente.excluirCliente(BancoDeDados.getInstance().getListaClientes(), BancoDeDados.getInstance().getListaIds(), idSelecionado);
    		} catch (ErroGrave | NaoEncontrado e) {
    			e.printStackTrace();
    		}
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Nenhum item selecionado!");
    		alert.setContentText("Selecione um item na tabela para que possa exclui-lo.");
    		alert.showAndWait();
    	}
    	
    	carregarListaClientes();
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

}