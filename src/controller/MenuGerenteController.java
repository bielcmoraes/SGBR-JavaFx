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
    
    @FXML
    private Button relatoriosButton;
    
    @FXML
    private Button listarButton;

    
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
    	atualizarPainel("/view/Cardapio.fxml");
    }

    @FXML
    void tela_vendas(ActionEvent event) {
    	atualizarPainel("/view/Vendas.fxml");
    }
    
    @FXML
    void tela_clientes(ActionEvent event) {
    	atualizarPainel("/view/Clientes.fxml");
    }
    
    @FXML
    void tela_relatorios(ActionEvent event) {
    	atualizarPainel("/view/Relatorios.fxml");
    }
    
    @FXML
    void tela_listagem(ActionEvent event) {
    	atualizarPainel("/view/Listagem.fxml");
    }
    
    @FXML
    private void deslogar(ActionEvent event) {
    	trocarTela(event, "/view/Login.fxml");
    }     
}