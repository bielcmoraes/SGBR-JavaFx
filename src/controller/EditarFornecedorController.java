package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import exceptions.NaoEncontrado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Fornecedor;
import model.GerenciaFornecedor;
import model.Produto;
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
    private Button adicionarProduto;
    
    @FXML
    private ComboBox<String> produtosComboBox;
    
    @FXML
    private TableColumn<Produto, String> produtosColuna;

    @FXML
    private TableView<Produto> produtosTableView;

    @FXML
    private Button removerProduto;
    
    private ObservableList<String> obsProdutos;
    private ObservableList<Produto> produtosDaTabela;
    private Fornecedor fornecedor = (Fornecedor) ObjetoSelecionado.getInstance().getObj();
    
    //Metodos
    
    @FXML
    void adicionar(ActionEvent event) {
    	if(!produtosComboBox.getSelectionModel().isEmpty()) {
    		Produto produtoSelecionado = BancoDeDados.getInstance().getListaProdutos().get(produtosComboBox.getSelectionModel().getSelectedItem()).get(0);
    		if(!produtosDaTabela.contains(produtoSelecionado)) {
    			produtosDaTabela.add(produtoSelecionado);
    		}else {
    			Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("ATENCAO!");
        		alert.setHeaderText("Produto ja adicionado!");
        		alert.setContentText("Selecione outro produto!");
        		alert.showAndWait();
    		}
    		}else {
    			Alert alert = new Alert(AlertType.WARNING);
        		alert.setTitle("ATENCAO!");
        		alert.setHeaderText("Produto não selecionado!");
        		alert.setContentText("Selecione um produto antes de adiciona-lo!");
        		alert.showAndWait();
    		}
    }
    @FXML
    void remover(ActionEvent event) {
    	if(!produtosTableView.getSelectionModel().isEmpty()) {
    		produtosDaTabela.remove(produtosTableView.getSelectionModel().getSelectedItem());
    	}else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Produto não selecionado!");
    		alert.setContentText("Selecione um produto antes de remove-lo!");
    		alert.showAndWait();
    	}
    }
    
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
			
			ArrayList<String> produtos = new ArrayList<String>();
			for(Produto produto : produtosDaTabela) {
				produtos.add(produto.getNome());
			}
			GerenciaFornecedor gerenciaFornecedor = new GerenciaFornecedor();
			
			try {
				gerenciaFornecedor.editarFornecedor(BancoDeDados.getInstance().getListaFornecedores(), fornecedor.getId(), info, produtos);
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
		preencherComboBox();
		carregarTableView();
	}
	
	private void preencherComboBox() {
		obsProdutos = FXCollections.observableArrayList(BancoDeDados.getInstance().getListaProdutos().keySet());
		produtosComboBox.setItems(obsProdutos);
    }
	
	private void carregarTableView() {
		produtosDaTabela = FXCollections.observableArrayList();
		for(String produto: fornecedor.getProdutos()) {
			Produto produtoSelecionado = BancoDeDados.getInstance().getListaProdutos().get(produto).get(0);
			produtosDaTabela.add(produtoSelecionado);
		}
    	produtosColuna.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
    	produtosTableView.setItems(produtosDaTabela);
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
