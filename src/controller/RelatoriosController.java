package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

public class RelatoriosController implements Initializable{

    @FXML
    private Button cancelarButton;

    @FXML
    private ComboBox<String> estoqueComboBox;

    @FXML
    private ComboBox<String> fornecedorComboBox;

    @FXML
    private Button gerarButton;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    private ComboBox<String> produtoComboBox;

    @FXML
    void cancelar(ActionEvent event) {

    }

    @FXML
    void gerar(ActionEvent event) {
    	if(!estoqueCombobox) {
    		
    	}
    }
    
    private void preencherComboBox() {
		
		ArrayList<String> relatoriosEstoque = new ArrayList<String>();
		ArrayList<String> relatoriosFornecedor = new ArrayList<String>();
		ArrayList<String> relatoriosProduto = new ArrayList<String>();
		relatoriosEstoque.add("Estoque total");
		relatoriosEstoque.add("Estoque por produto");
		relatoriosEstoque.add("Estoque de vencidos");
		
		relatoriosFornecedor.add("Fornecedor por produto");
		relatoriosFornecedor.add("Fornecedor por fornecedor");
		
		relatoriosProduto.add("Vendas total");
		relatoriosProduto.add("Vendas por periodo");
		relatoriosProduto.add("Vendas por tipo de prato");
		
		
		ObservableList<String> obsEstoque = FXCollections.observableArrayList(relatoriosEstoque);
		ObservableList<String> obsFornecedor = FXCollections.observableArrayList(relatoriosFornecedor);
		ObservableList<String> obsProduto = FXCollections.observableArrayList(relatoriosProduto);
		
		estoqueComboBox.setItems(obsEstoque);
		fornecedorComboBox.setItems(obsFornecedor);
		produtoComboBox.setItems(obsProduto);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		preencherComboBox();
		
	}
}
