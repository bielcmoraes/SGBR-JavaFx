package controller;

<<<<<<< HEAD
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class ProdutosController {

    @FXML
    private Button cadastrarButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;

    @FXML
    private TableColumn<?, ?> fornecedores;

    @FXML
    private TableColumn<?, ?> idTableColumn;

    @FXML
    private TableColumn<?, ?> medidaTableColumn;

    @FXML
    private TableColumn<?, ?> nomeTableColumn;

    @FXML
    private TableColumn<?, ?> precoTableColumn;

    @FXML
    private TableColumn<?, ?> quantidadeTableColumn;

    @FXML
    private TableColumn<?, ?> validadeTableColumn;

    @FXML
    private Button voltarButton;

}

=======
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ProdutosController {

    @FXML
    private Button voltarButton;

    @FXML
    void voltarParaMain(ActionEvent event) {
    	trocarTela(event, "/view/MenuGerente.fxml");
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
>>>>>>> branch 'main' of https://github.com/bielcmoraes/SGBR-JavaFx.git
