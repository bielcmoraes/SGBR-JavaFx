package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Funcionario;
import model.Gerente;
import model.Login;
import model.Usuario;

public class LoginController {
	
    @FXML
    private Button loginButton;

    @FXML
    private PasswordField senhaTextField;

    @FXML
    private TextField usuarioTextField;

    @FXML
    private void logar(ActionEvent event) {
    	BancoDeDados dados = Main.getBancoDeDados();
    	Login login = new Login(dados.getListaUsuarios());
    	Usuario usuarioLogado = login.autenticarLogin(dados.getListaUsuarios(), usuarioTextField.getText(), senhaTextField.getText());
    	
    	if(usuarioLogado == null) {
    		 Alert erroLogin = new Alert(Alert.AlertType.ERROR);
    		 erroLogin.setTitle("Falha no login");
    		 erroLogin.setHeaderText("Nome de Usuario ou senha incorretos");
    		 erroLogin.setContentText("TENTE NOVAMENTE!!!!");
    		 erroLogin.showAndWait();
    	}else {
    		if(usuarioLogado instanceof Gerente) {
    			trocarTela(event, "/view/MenuGerente.fxml");
    			
    		}else if(usuarioLogado instanceof Funcionario) {
    			trocarTela(event, "/view/MenuFuncionario.fxml");
    		}
    	}
    	
    	
    	
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
