package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import exceptions.NaoEncontrado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Cliente;
import model.GerenciaCliente;

public class EditarClienteController implements Initializable{

    @FXML
    private Button atualizarButton;

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
    
    //Metodos
    @FXML
    void atualizar(ActionEvent event) {
    	
    	if(!nomeTextField.getText().isBlank() && !emailTextField.getText().isBlank() && !cpfTextField.getText().isBlank() && !telefoneTextField.getText().isBlank()) {
    		
    		Cliente cliente = (Cliente) ObjetoSelecionado.getInstance().getObj();
        	String nome = nomeTextField.getText();
        	String email = emailTextField.getText();
        	String cpf = cpfTextField.getText();
        	String telefone = telefoneTextField.getText();
        	
        	String [] info = new String[4];
        	info[0] = nome;
    		info[1] = email;
    		info[2] = cpf;
    		info[3] = telefone;
    		
    		GerenciaCliente gerenciaCliente = new GerenciaCliente();
    		try {
    			gerenciaCliente.editarCliente(BancoDeDados.getInstance().getListaClientes(), cliente.getId(), info);
    		} catch (ErroGrave | NaoEncontrado e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		atualizarPainel("/view/Clientes.fxml");
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
    	atualizarPainel("/view/Clientes.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarDados();
		
	}
	
	private void carregarDados() {
		Cliente cliente = (Cliente) ObjetoSelecionado.getInstance().getObj();
		nomeTextField.setText(cliente.getNome());
		emailTextField.setText(cliente.getEmail());
		cpfTextField.setText(cliente.getCpf());
		telefoneTextField.setText(cliente.getTelefone());
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
