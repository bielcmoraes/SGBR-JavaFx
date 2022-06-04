package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BancoDeDados;
import model.Usuario;

public class UsuariosController implements Initializable{

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
    
    private ArrayList<Usuario> listaUsuarios = Main.getBancoDeDados().getListaUsuarios();
    
    private ObservableList<Usuario> observableListUsuarios;

    @FXML
    private Button voltarButton;
    
    
    //Métodos
    @FXML
    void cadastrarUsuario(ActionEvent event) {

    }

    @FXML
    void voltarParaMain(ActionEvent event) {

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
