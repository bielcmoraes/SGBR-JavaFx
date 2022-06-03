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
    private AnchorPane tela_atualizacao;
    
    //Métodos
    @FXML
    private void tela_usuarios(ActionEvent event) {
    	trocarTela(event, "/view/Usuarios.fxml");
    }
    
    @FXML
    void tela_fornecedores(ActionEvent event) {
    	trocarTela(event, "/view/Fornecedores.fxml");
    }
    
    @FXML
    private void tela_produtos(ActionEvent event) {
    	
		try {
			atualizarPane("/view/Produtos.fxml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void tela_cardapio(ActionEvent event) {
    	try {
			atualizarPane("/view/Cardapio.fxml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void tela_vendas(ActionEvent event) {
    	trocarTela(event, "/view/Vendas.fxml");
    }
    
    @FXML
    void tela_clientes(ActionEvent event) {
    	trocarTela(event, "/view/Clientes.fxml");
    }
    
    @FXML
    private void deslogar(ActionEvent event) {
    	trocarTela(event, "/view/Login.fxml");
    }
    
    @FXML
    public void atualizarPane(String url) throws IOException, Exception {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource(url));
        tela_atualizacao.setTopAnchor(a, 0.0);
        tela_atualizacao.setBottomAnchor(a, 0.0);
        tela_atualizacao.setLeftAnchor(a, 0.0);
        tela_atualizacao.setRightAnchor(a, 0.0);
        tela_atualizacao.getChildren().add(a);

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