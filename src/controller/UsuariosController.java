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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.GerenciaUsuario;
import model.Produto;
import model.Usuario;

public class UsuariosController implements Initializable{
	
	@FXML
    private AnchorPane painelAnchorPane;
	
    @FXML
    private Button cadastrarButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;
    
    @FXML
    private TableView<Usuario> tabelaUsuarios;
    
    @FXML
    private TableColumn<Usuario, String> idTableColumn;

    @FXML
    private TableColumn<Usuario, String> nomeTableColumn;
    
    private ArrayList<Usuario> listaUsuarios = BancoDeDados.getInstance().getListaUsuarios();
    
    private ObservableList<Usuario> observableListUsuarios;

    @FXML
    private Button voltarButton;
    
    
    //Métodos
    @FXML
    void cadastrarUsuario(ActionEvent event) {
    	atualizarPainel("/view/CadastrarUsuario.fxml");
    }
    
    @FXML
    void editar(ActionEvent event) {
    	Usuario usuario = tabelaUsuarios.getSelectionModel().getSelectedItem();
    	if(usuario != null) {
    		ObjetoSelecionado.getInstance().setObj(usuario);
    		atualizarPainel("/view/EditarUsuario.fxml");
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENÇÃO!");
    		alert.setHeaderText("Nenhum usuário selecionado!");
    		alert.setContentText("Selecione um usuário na tabela para que possa edita-lo.");
    		alert.showAndWait();
    	}
    }
    
    @FXML
    void excluirUsuario(ActionEvent event) {
    	
    	if (tabelaUsuarios.getSelectionModel().getSelectedItem() != null) {
    		String idSelecionado = tabelaUsuarios.getSelectionModel().getSelectedItem().getId();
    		GerenciaUsuario gerenciaUsuario = new GerenciaUsuario();
        	try {
    			gerenciaUsuario.excluirUsuario(BancoDeDados.getInstance().getListaUsuarios(), BancoDeDados.getInstance().getListaIds(), idSelecionado);
    		} catch (ErroGrave e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
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
		
		idTableColumn.setCellValueFactory(new PropertyValueFactory<Usuario, String>("id"));
		nomeTableColumn.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
		
		observableListUsuarios = FXCollections.observableArrayList(listaUsuarios);
		tabelaUsuarios.setItems(observableListUsuarios);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarListaUsuarios();
		
	}
}
