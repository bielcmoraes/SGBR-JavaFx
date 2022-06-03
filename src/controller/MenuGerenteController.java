package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MenuGerenteController {

    @FXML
    private Button cardapioButton;

    @FXML
    private Button clientesButton;

    @FXML
    private Button deslogarButton;

    @FXML
    private Button fornecedoresButton;

    @FXML
    private Button produtosButton;

    @FXML
    private Button usuariosButton;

    @FXML
    private Button vendasButton;
     
    @FXML
    private void deslogar(ActionEvent event) {
    	trocarTela(event, "/view/Login.fxml");
    }
    
    @FXML
    private void tela_produtos(ActionEvent event) {
    	trocarTela(event, "/view/Produtos.fxml");
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