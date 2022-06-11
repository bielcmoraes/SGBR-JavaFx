package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    }

    @FXML
    void cancelar(ActionEvent event) {
    	atualizarPainel("/view/Usuarios.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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
