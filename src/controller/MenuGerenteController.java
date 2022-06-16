package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuGerenteController extends Tela {

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
    
    //Métodos
    @FXML
    private void tela_usuarios(ActionEvent event) {
    	atualizarPainel("/view/Usuarios.fxml");
    }
    
    @FXML
    void tela_fornecedores(ActionEvent event) {
    	atualizarPainel("/view/Fornecedores.fxml");
    }
    
    @FXML
    private void tela_produtos(ActionEvent event) {
    	atualizarPainel("/view/Produtos.fxml");
    }
    
    @FXML
    void tela_cardapio(ActionEvent event) {
    	try {
    		atualizarPainel("/view/Cardapio.fxml");
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
<<<<<<< HEAD
    
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
    
    private void trocarTela(ActionEvent event, String url) {
    	Node node = (Node) event.getSource();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(url));
			node.getScene().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
=======
>>>>>>> branch 'main' of https://github.com/bielcmoraes/SGBR-JavaFx.git
     
}