package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.GerenciaProdutos;
import model.GerenciaUsuario;
import model.Produto;
import model.Usuario;

public class EditarUsuarioController implements Initializable{

    @FXML
    private Button atualizarButton;

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
    void atualizar(ActionEvent event) {
    	
    	if(!nomeTextField.getText().isBlank() && !senhaTextField.getText().isBlank() && !confirmaSenhaTextField.getText().isBlank()) {
    		if(senhaTextField.getText().equals(confirmaSenhaTextField.getText())) {
    			Usuario usuario = (Usuario) ObjetoSelecionado.getInstance().getObj();
        		String nome = nomeTextField.getText();
        		String senha = senhaTextField.getText();
        		
        		String [] info = new String[2];
        		
        		info[0] = nome;
    			info[1] = senha;
    			
    			GerenciaUsuario gerenciaUsuario = new GerenciaUsuario();
    			
    			try {
    				gerenciaUsuario.editarUsuario(BancoDeDados.getInstance().getListaUsuarios(), usuario.getId(), info);
    			} catch (ErroGrave e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			atualizarPainel("/view/Usuarios.fxml");
    		}else {
    			Alert senhasDiferentes = new Alert(Alert.AlertType.ERROR);
				senhasDiferentes.setTitle("Erro na confirmação de senha");
				senhasDiferentes.setHeaderText("As senhas são diferentes");
				senhasDiferentes.setContentText("TENTE NOVAMENTE!!!!");
				senhasDiferentes.showAndWait();
    		}
			
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Existe campos nao preenchidos!");
    		alert.setContentText("Preenchas os campos restantes antes de editar.");
    		alert.showAndWait();
    	}
    }

    @FXML
    void cancelar(ActionEvent event) {
    	atualizarPainel("/view/Usuarios.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarDados();
		
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
	
	private void carregarDados() {
		Usuario usuario = (Usuario) ObjetoSelecionado.getInstance().getObj();
		loginTextField.setText(usuario.getLogin());
		nomeTextField.setText(usuario.getNome());
		senhaTextField.setText(usuario.getSenha());
	}

}
