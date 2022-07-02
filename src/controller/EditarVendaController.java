package controller;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import exceptions.ClienteNaoCadastrado;
import exceptions.ErroGrave;
import exceptions.FormatoDataInvalido;
import exceptions.FormatoHorarioInvalido;
import exceptions.PratoNaoCadastrado;
import exceptions.QuantidadeProdutosInsuficiente;
import exceptions.VendaNaoCadastrada;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Cliente;
import model.GerenciaVendas;
import model.Prato;
import model.Produto;
import model.Venda;

public class EditarVendaController extends Tela implements Initializable{

    @FXML
    private Button adicionarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private ComboBox<Cliente> clienteComboBox;

    @FXML
    private DatePicker dataDatePicker;

    @FXML
    private Button editarButton;

    @FXML
    private TextField horasTextField;

    @FXML
    private ComboBox<String> mdpComboBox;

    @FXML
    private TextField minutosTextField;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    private ComboBox<Prato> pratoComboBox;

    @FXML
    private TableColumn<Prato, String> pratoTableColumn;

    @FXML
    private TableView<Prato> comprasTableView;

    @FXML
    private Button removerButton;

    private ObservableList<Prato> obsCompras;
    
    private ObservableList<Prato> obsPratos;
    
    private ObservableList<Cliente> obsClientes;
    
    private ObservableList<String> obsMdps;
    
    private GerenciaVendas gerenciaVendas = new GerenciaVendas();
    
    private ArrayList<Venda> listaVendas = BancoDeDados.getInstance().getListaVendas();
    
    private ArrayList<Cliente> listaClientes = BancoDeDados.getInstance().getListaClientes();
    
    private ArrayList<Prato> cardapio = BancoDeDados.getInstance().getCardapio();
	
    private ArrayList<String> listaIds = BancoDeDados.getInstance().getListaIds();
	
    private HashMap<String, ArrayList<Produto>> listaProdutos = BancoDeDados.getInstance().getListaProdutos();
	
	private Venda venda = (Venda) ObjetoSelecionado.getInstance().getObj();
    
    @FXML
    void adicionar(ActionEvent event) {
    	if (!pratoComboBox.getSelectionModel().isEmpty()) {
    		obsCompras.add(pratoComboBox.getSelectionModel().getSelectedItem());
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Existe campos nao preenchidos!");
    		alert.setContentText("Preenchas os campos restantes antes de adicionar.");
    		alert.showAndWait();
    	}
    }

    @FXML
    void remover(ActionEvent event) {
    	if (!comprasTableView.getSelectionModel().isEmpty()) {
	    	obsCompras.remove(comprasTableView.getSelectionModel().getSelectedItem());
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Nenhum item selecionado!");
    		alert.setContentText("Selecione um item na tabela para que possa remove-lo.");
    		alert.showAndWait();
    	}
    }
    
    @FXML
    void editar(ActionEvent event) {
    	if (!clienteComboBox.getSelectionModel().isEmpty()
    			&& !mdpComboBox.getSelectionModel().isEmpty()
    			&& !obsCompras.isEmpty()
    			&& dataDatePicker.getValue() != null
    			&& !horasTextField.getText().isBlank()
    			&& !minutosTextField.getText().isBlank()) {
    		
    		String cliente = clienteComboBox.getSelectionModel().getSelectedItem().getNome();
	    	String mdp = mdpComboBox.getSelectionModel().getSelectedItem();
	    	String horario = horasTextField.getText() + ":" + minutosTextField.getText();
	    	
	    	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	
	    	String data = dataDatePicker.getValue().format(formatoData);
	    	
	    	String compras = "";
	    	for (Prato prato: obsCompras) {
	    		compras += prato.getNome() + ", ";
	    	}
	    	
			compras = compras.substring(0, compras.length()-2);
	    	
	    	String [] info = new String[6];
	    	
			info[0] = data;
			info[1] = horario;
			info[2] = compras;
			info[3] = mdp;
			info[4] = compras;
			info[5] = cliente;
			
			try {
				gerenciaVendas.editarVenda(listaVendas, cardapio, venda.getId(), info, listaProdutos, listaClientes);
			} catch (FormatoDataInvalido | FormatoHorarioInvalido | PratoNaoCadastrado | QuantidadeProdutosInsuficiente
					| ErroGrave | VendaNaoCadastrada | ClienteNaoCadastrado e) {
				e.printStackTrace();
			}
	    	
	    	atualizarPainel("/view/Vendas.fxml");
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENCAO!");
    		alert.setHeaderText("Existe campos nao preenchidos!");
    		alert.setContentText("Preenchas os campos restantes antes de cadastrar.");
    		alert.showAndWait();
    	}
    }

    @FXML
    void cancelar(ActionEvent event) {
    	atualizarPainel("/view/Vendas.fxml");
    }

    private void carregarClientes() {
		obsClientes = FXCollections.observableArrayList(BancoDeDados.getInstance().getListaClientes());
		clienteComboBox.setItems(obsClientes);
    }
    
    private void carregarPratos() {
		obsPratos = FXCollections.observableArrayList(BancoDeDados.getInstance().getCardapio());
		pratoComboBox.setItems(obsPratos);
    }
    
	private void carregarMdps() {
		obsMdps = FXCollections.observableArrayList("Cartão", "Pix", "Dinheiro");
		mdpComboBox.setItems(obsMdps);
	}
	
    private void carregarCompras() {
		pratoTableColumn.setCellValueFactory(new PropertyValueFactory<Prato, String>("nome"));
		obsCompras = FXCollections.observableArrayList();
		obsCompras.addAll(venda.getPratos());
		comprasTableView.setItems(obsCompras);
	}
    
    private void carregarDados() {
    	dataDatePicker.setValue(venda.getData());
    	String horas = String.valueOf(venda.getHorario().getHour());
    	horasTextField.setText(horas);
    	String minutos = String.valueOf(venda.getHorario().getMinute());
    	minutosTextField.setText(minutos);
    	mdpComboBox.setValue(venda.getMetodoDePagamento());
    	clienteComboBox.setValue(venda.getCliente());
    }
    
    public void permiteInteiro(TextField textfield) {
        textfield.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    try {
                        if (!newValue.matches("\\d*")) {
                            textfield.setText(oldValue);
                        }

                    } catch(Exception e) {
                        textfield.setText(oldValue);
                    }
                }
        );
    }
    
    public void limitarValor(TextField textfield) {
        textfield.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    try {
                        if (newValue.length() > 2) {
                            textfield.setText(oldValue);
                        }

                    } catch(Exception e) {
                        textfield.setText(oldValue);
                    }
                }
        );
    }
    
    public void validarHoras(TextField textfield) {
        textfield.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                	if (!newValue.isBlank()) {
                        if (Integer.valueOf(newValue) > 23) {
                            textfield.setText(oldValue);
                        }

                    }
                }
        );
    }
    
    public void validarMinutos(TextField textfield) {
        textfield.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.isBlank()) {
                        if (Integer.valueOf(newValue) > 59) {
                            textfield.setText(oldValue);
                        }

                    }
                }
        );
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarClientes();
		carregarPratos();
		carregarMdps();
		carregarCompras();
		carregarDados();
		
		permiteInteiro(minutosTextField);
		permiteInteiro(horasTextField);
		limitarValor(minutosTextField);
		limitarValor(horasTextField);
		validarHoras(horasTextField);
		validarMinutos(minutosTextField);
	}

}
