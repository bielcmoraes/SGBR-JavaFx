package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import exceptions.EscolhaIncorreta;
import exceptions.LoginJaCadastrado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Fornecedor;
import model.GerenciaUsuario;

public class CadastrarUsuarioController implements Initializable{

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private PasswordField confirmaSenhaTextField;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    private PasswordField senhaTextField;

    @FXML
    private ComboBox<String> tipoUsuarioComboBox;

    @FXML
    void cadastrar(ActionEvent event) {
    	
    	
    	
    	if(!senhaTextField.getText().isBlank() && !loginTextField.getText().isBlank() && !nomeTextField.getText().isBlank() && !tipoUsuarioComboBox.getSelectionModel().getSelectedItem().toString().isBlank()) {
    		
    		String nome = nomeTextField.getText();
        	String tipoUsuario = tipoUsuarioComboBox.getSelectionModel().getSelectedItem().toString();
        	String login = loginTextField.getText();
        	
    		if(senhaTextField.getText().equals(confirmaSenhaTextField.getText())) {
        		String senha = senhaTextField.getText();
        		String [] info = new String[4];
            	info[0] = nome;
            	info[1] = tipoUsuario;
            	info[2] = login;
            	info[3] = senha;
            	GerenciaUsuario gerenciaUsuario = new GerenciaUsuario();
            	
    				try {
    					gerenciaUsuario.cadastrarUsuario(BancoDeDados.getInstance().getListaUsuarios(), BancoDeDados.getInstance().getListaIds(), info);
    					atualizarPainel("/view/Usuarios.fxml");
    				} catch (EscolhaIncorreta e) {
    					e.printStackTrace();
    				} catch (LoginJaCadastrado e) {
    					Alert loginRepetido = new Alert(Alert.AlertType.ERROR);
    					loginRepetido.setTitle("Login repetido");
    					loginRepetido.setHeaderText("Login já cadastrado");
    					loginRepetido.setContentText("TENTE NOVAMENTE!!!!");
    					loginRepetido.showAndWait();
    					
    				} catch (ErroGrave e) {
    					e.printStackTrace();
    				}
    			
    			}else {
    				Alert senhasDiferentes = new Alert(Alert.AlertType.ERROR);
    				senhasDiferentes.setTitle("Erro na confirmação de senha");
    				senhasDiferentes.setHeaderText("As senhas são diferentes");
    				senhasDiferentes.setContentText("TENTE NOVAMENTE!!!!");
    				senhasDiferentes.showAndWait();
    			}
    	}else {
    		Alert senhasDiferentes = new Alert(Alert.AlertType.ERROR);
			senhasDiferentes.setTitle("Campos vazios");
			senhasDiferentes.setHeaderText("Um ou mais campos não preenchidos");
			senhasDiferentes.setContentText("PREENCHA OS CAMPOS!!!!");
			senhasDiferentes.showAndWait();
    	}
    	
    	}
    	

    @FXML
    void cancelar(ActionEvent event) {
    	atualizarPainel("/view/Usuarios.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		preencherComboBox();
	}
	
	private void preencherComboBox() {
		
		ArrayList<String> opcaoComboBox = new ArrayList<String>();
		opcaoComboBox.add("Gerente");
		opcaoComboBox.add("Funcionário");
		ObservableList<String> obsComboBox = FXCollections.observableArrayList(opcaoComboBox);
		tipoUsuarioComboBox.setItems(obsComboBox);
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
