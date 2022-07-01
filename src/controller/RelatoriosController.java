package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import exceptions.RelatorioNaoGerado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.GeraRelatorio;

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
    		
		GeraRelatorio geraRelatorio = new GeraRelatorio();
		
		if(estoqueComboBox.getSelectionModel().getSelectedItem().toString().equals("Estoque total")) {
			try {
				geraRelatorio.estoqueTotal(BancoDeDados.getInstance().getListaProdutos());
			} catch (RelatorioNaoGerado | ErroGrave e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(estoqueComboBox.getSelectionModel().getSelectedItem().toString().equals("Estoque por produto")) {
			try {
				geraRelatorio.estoquePorProduto(BancoDeDados.getInstance().getListaProdutos());
			} catch (RelatorioNaoGerado | ErroGrave e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(estoqueComboBox.getSelectionModel().getSelectedItem().toString().equals("Estoque perto de vencer")) {
			try {
				geraRelatorio.estoqueProdutosPertoDeVencer(BancoDeDados.getInstance().getListaProdutos());
			} catch (ErroGrave | RelatorioNaoGerado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(fornecedorComboBox.getSelectionModel().getSelectedItem().toString().equals("Fornecedor por produto")) {
			try {
				geraRelatorio.fornecedorPorProduto(BancoDeDados.getInstance().getListaProdutos());
			} catch (RelatorioNaoGerado | ErroGrave e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(fornecedorComboBox.getSelectionModel().getSelectedItem().toString().equals("Fornecedor por fornecedor")) {
			try {
				geraRelatorio.fornecedorPorFornecedor(BancoDeDados.getInstance().getListaFornecedores());
			} catch (RelatorioNaoGerado | ErroGrave e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(produtoComboBox.getSelectionModel().getSelectedItem().toString().equals("Vendas total")) {
			try {
				geraRelatorio.vendasTotal(BancoDeDados.getInstance().getListaVendas());
			} catch (ErroGrave | RelatorioNaoGerado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(produtoComboBox.getSelectionModel().getSelectedItem().toString().equals("Vendas por periodo")) {
			try {
				geraRelatorio.vendasPorPeriodo(BancoDeDados.getInstance().getListaVendas());
			} catch (ErroGrave e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(produtoComboBox.getSelectionModel().getSelectedItem().toString().equals("Vendas por tipo de prato")) {
			try {
				geraRelatorio.vendasPorTipoDePrato(BancoDeDados.getInstance().getListaVendas());
			} catch (ErroGrave | RelatorioNaoGerado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
    private void preencherComboBox() {
		
		ArrayList<String> relatoriosEstoque = new ArrayList<String>();
		ArrayList<String> relatoriosFornecedor = new ArrayList<String>();
		ArrayList<String> relatoriosProduto = new ArrayList<String>();
		relatoriosEstoque.add("Estoque total");
		relatoriosEstoque.add("Estoque por produto");
		relatoriosEstoque.add("Estoque perto de vencer");
		
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
