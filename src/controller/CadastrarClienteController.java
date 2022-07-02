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
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.GerenciaCliente;

public class CadastrarClienteController {

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField cpfTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    private TextField telefoneTextField;

    @FXML
    void cadastrar(ActionEvent event) {
    	
    	if(!telefoneTextField.getText().isBlank() && !cpfTextField.getText().isBlank() && !emailTextField.getText().isBlank() && !nomeTextField.getText().isBlank()) {
    		
    		String nome = nomeTextField.getText();
    		String cpf = cpfTextField.getText();
    		String email = emailTextField.getText();
    		String telefone = telefoneTextField.getText();
    		
    		String [] info = new String[4];
    		info[0] = nome;
        	info[1] = cpf;
        	info[2] = email;
        	info[3] = telefone;
        	
        	GerenciaCliente gerenciaCliente = new GerenciaCliente();
        	
        	try {
				gerenciaCliente.cadastrarCliente(BancoDeDados.getInstance().getListaClientes(), BancoDeDados.getInstance().getListaIds(), info);
			} catch (ErroGrave e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	atualizarPainel("/view/Clientes.fxml");
    	}else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle("Campos vazios");
			alert.setHeaderText("Um ou mais campos não preenchidos");
			alert.setContentText("PREENCHA OS CAMPOS!!!!");
			alert.showAndWait();
    	}
    }

    @FXML
    void cancelar(ActionEvent event) {
    	atualizarPainel("/view/Clientes.fxml");
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
