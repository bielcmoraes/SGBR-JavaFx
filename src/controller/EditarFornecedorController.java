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
import model.Fornecedor;
import model.GerenciaFornecedor;
import model.Usuario;

public class EditarFornecedorController implements Initializable{

    @FXML
    private Button atualizarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField cnpjTextField;

    @FXML
    private TextField enderecoTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    void atualizar(ActionEvent event) {
    	if(!nomeTextField.getText().isBlank() && !enderecoTextField.getText().isBlank() && !cnpjTextField.getText().isBlank()) {
    		Fornecedor fornecedor = (Fornecedor) ObjetoSelecionado.getInstance().getObj();
    		String nome = nomeTextField.getText();
    		String endereco = enderecoTextField.getText();
    		String cnpj = cnpjTextField.getText();
    		
    		String [] info = new String[3];
    		info[0] = nome;
			info[1] = endereco;
			info[2] = cnpj;
			
			GerenciaFornecedor gerenciaFornecedor = new GerenciaFornecedor();
			
			try {
				gerenciaFornecedor.editarFornecedor(BancoDeDados.getInstance().getListaFornecedores(), fornecedor.getId(), info);
			} catch (ErroGrave | NaoEncontrado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			atualizarPainel("/view/Fornecedores.fxml");
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
    	atualizarPainel("/view/Fornecedores.fxml");
    }
    
    private void carregarDados() {
		Fornecedor fornecedor = (Fornecedor) ObjetoSelecionado.getInstance().getObj();
		nomeTextField.setText(fornecedor.getNome());
		enderecoTextField.setText(fornecedor.getEndereco());
		cnpjTextField.setText(fornecedor.getCnpj());
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
}
