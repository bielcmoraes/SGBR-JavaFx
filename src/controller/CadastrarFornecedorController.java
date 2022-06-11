package controller;

import java.io.IOException;

import exceptions.ErroGrave;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.GerenciaFornecedor;
import model.Produto;

public class CadastrarFornecedorController {

    @FXML
    private Button cadastrarButton;

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
    void cadastrar(ActionEvent event) {
    	
    	String nome = nomeTextField.getText();
    	String cnpj = cnpjTextField.getText();
    	String endereco = enderecoTextField.getText();
    	
    	String [] info = new String[3];
		info[0] = nome;
		info[1] = cnpj;
		info[2] = endereco;
		
		GerenciaFornecedor gerenciaFornecedores = new GerenciaFornecedor();
		
		try {
			gerenciaFornecedores.cadastrarFornecedor(BancoDeDados.getInstance().getListaFornecedores(), BancoDeDados.getInstance().getListaIds(), info);
		} catch (ErroGrave e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		atualizarPainel("/view/Fornecedores.fxml");
    }
    	
    @FXML
    void cancelar(ActionEvent event) {
    	atualizarPainel("/view/Fornecedores.fxml");
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
