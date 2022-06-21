package controller;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoQuantidadeInvalido;
import exceptions.FornecedorNaoCadastrado;
import exceptions.PrecoInvalido;
import exceptions.QuantidadeInvalida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Fornecedor;
import model.GerenciaProdutos;

public class CadastrarProdutoController implements Initializable{
	
    @FXML
    private Button cadastrarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private AnchorPane painelAnchorPane;
    
    @FXML
    private ComboBox<Fornecedor> fornecedorComboBox;

    @FXML
    private ComboBox<String> medidaComboBox;
    
    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField precoTextField;

    @FXML
    private TextField quantidadeTextField;

    @FXML
    private DatePicker validadeDatePicker;
    
    private ObservableList<Fornecedor> obsFornecedores;
    
    private ObservableList<String> obsMedidas;
    
    @FXML
    private void cadastrar(ActionEvent event) {
    	if (!fornecedorComboBox.getSelectionModel().isEmpty() && !medidaComboBox.getSelectionModel().isEmpty() && !nomeTextField.getText().isBlank()
    			&& !precoTextField.getText().isBlank() && !quantidadeTextField.getText().isBlank() && validadeDatePicker.getValue() != null){
	    	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	
	    	String nome =  nomeTextField.getText();
	    	String preco = precoTextField.getText();
	    	String quantidade = quantidadeTextField.getText() + " " + medidaComboBox.getSelectionModel().getSelectedItem();
	    	String validade = validadeDatePicker.getValue().format(formatoData);
	    	String fornecedor = fornecedorComboBox.getSelectionModel().getSelectedItem().toString();
    	
    		String [] info = new String[5];
			info[0] = nome;
			info[1] = preco;
			info[2] = quantidade;
			info[3] = validade;
			info[4] = fornecedor;
			
	    	GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
	    	try {
				gerenciaProdutos.cadastrarProduto(BancoDeDados.getInstance().getListaProdutos(), BancoDeDados.getInstance().getListaIds(), info, BancoDeDados.getInstance().getListaFornecedores());
			} catch (PrecoInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FormatoQuantidadeInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (QuantidadeInvalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FormatoDataInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FornecedorNaoCadastrado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ErroGrave e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	atualizarPainel("/view/Produtos.fxml");
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENÇÃO!");
    		alert.setHeaderText("Existe campos não preenchidos!");
    		alert.setContentText("Preenchas os campos restantes antes de cadastrar.");
    		alert.showAndWait();
    	}
    }
    
    @FXML
    private void cancelar(ActionEvent event) {
    	atualizarPainel("/view/Produtos.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarFornecedores();
		carregarMedidas();
		permiteDecimal(precoTextField);
		permiteDecimal(quantidadeTextField);
		
	}
	
	private void carregarFornecedores() {
		obsFornecedores = FXCollections.observableArrayList(BancoDeDados.getInstance().getListaFornecedores());
		fornecedorComboBox.setItems(obsFornecedores);
	}
	
	private void carregarMedidas() {
		obsMedidas = FXCollections.observableArrayList("kg", "g", "l", "ml", "un.");
		medidaComboBox.setItems(obsMedidas);
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
    
    
    public void permiteDecimal(TextField textfield) {
        textfield.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    try {
                        if (!newValue.matches("\\d*(\\.\\d*)?")) {
                            textfield.setText(oldValue);
                        }

                    } catch(Exception e) {
                        textfield.setText(oldValue);
                    }
                }
        );
    }

	
}
