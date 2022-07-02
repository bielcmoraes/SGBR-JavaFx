package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import exceptions.ErroGrave;
import exceptions.PratoNaoCadastrado;
import exceptions.VendaNaoCadastrada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.BancoDeDados;
import model.Cliente;
import model.GerenciaVendas;
import model.Prato;
import model.Venda;

public class VendasController extends Tela implements Initializable{

    @FXML
    private Button cadastrarButton;

    @FXML
    private TableColumn<Venda, String> clienteTableColumn;

    @FXML
    private TableColumn<Venda, LocalDate> dataTableColumn;

    @FXML
    private Button editarButton;

    @FXML
    private Button excluirButton;

    @FXML
    private TableColumn<Venda, LocalTime> horarioTableColumn;

    @FXML
    private TableColumn<Venda, String> idTableColumn;

    @FXML
    private TableColumn<Venda, String> mdpTableColumn;

    @FXML
    private AnchorPane painelAnchorPane;

    @FXML
    private TableColumn<Venda, String> pratosTableColumn;

    @FXML
    private TableColumn<Venda, Double> precoTotalTableColumn;

    @FXML
    private TableView<Venda> vendasTableView;

    private ArrayList<Venda> listaVendas = BancoDeDados.getInstance().getListaVendas();
    
    private ObservableList<Venda> observableListVendas;
    
    GerenciaVendas gerenciaVendas = new GerenciaVendas();
    
	ArrayList<String> listaIds = BancoDeDados.getInstance().getListaIds();
    
    @FXML
    void cadastrar(ActionEvent event) {
    	atualizarPainel("/view/CadastrarVenda.fxml");
    }

    @FXML
    void editar(ActionEvent event) {
    	if (!vendasTableView.getSelectionModel().isEmpty()) {
    		Venda venda = vendasTableView.getSelectionModel().getSelectedItem();
    		ObjetoSelecionado.getInstance().setObj(venda);
        	atualizarPainel("/view/EditarVenda.fxml");
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENÇÃO!");
    		alert.setHeaderText("Nenhum item selecionado!");
    		alert.setContentText("Selecione um item na tabela para que possa edita-lo.");
    		alert.showAndWait();
    	}
    }

    @FXML
    void excluir(ActionEvent event) {
    	if (!vendasTableView.getSelectionModel().isEmpty()) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("ATENÇÃO!");
    		alert.setHeaderText("Deseja mesmo excluir o item selecionado?");
    		alert.setContentText("Clique em ok se sim.");
    		Optional<ButtonType> escolha = alert.showAndWait();
    		if (escolha.isPresent() && escolha.get() == ButtonType.OK) {
    			Venda venda = vendasTableView.getSelectionModel().getSelectedItem();
    			String idSelecionado = venda.getId();
				try {
					gerenciaVendas.excluirVenda(listaVendas, listaIds, idSelecionado);
				} catch (VendaNaoCadastrada | ErroGrave e) {
					e.printStackTrace();
				}
				
		    	carregarVendas();
    		}
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("ATENÇÃO!");
    		alert.setHeaderText("Nenhum item selecionado!");
    		alert.setContentText("Selecione um item na tabela para que possa exclui-lo.");
    		alert.showAndWait();
    	}
    }
    
    public void carregarVendas() {
    	idTableColumn.setCellValueFactory(new PropertyValueFactory<Venda, String>("id"));
    	dataTableColumn.setCellValueFactory(new PropertyValueFactory<Venda, LocalDate>("data"));
    	horarioTableColumn.setCellValueFactory(new PropertyValueFactory<Venda, LocalTime>("horario"));
    	pratosTableColumn.setCellValueFactory(new PropertyValueFactory<Venda, String>("PratosToString"));
    	precoTotalTableColumn.setCellValueFactory(new PropertyValueFactory<Venda, Double>("precoTotal"));
    	mdpTableColumn.setCellValueFactory(new PropertyValueFactory<Venda, String>("metodoDePagamento"));
    	clienteTableColumn.setCellValueFactory(new PropertyValueFactory<Venda, String>("cliente"));

    	
		precoTotalTableColumn.setCellFactory(c -> new TableCell<>() {
		    @Override
		    protected void updateItem(Double precoTotal, boolean empty) {
		        super.updateItem(precoTotal, empty);
		        if (precoTotal == null || empty) {
		            setText(null);
		        } else {
		            setText(String.format("R$ %.2f", precoTotal));
		        }
		    }
		});
		
		dataTableColumn.setCellFactory(c -> new TableCell<>() {
		    @Override
		    protected void updateItem(LocalDate data, boolean empty) {
		        super.updateItem(data, empty);
		        if (data == null || empty) {
		            setText(null);
		        } else {
		        	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		            setText(data.format(formatoData));
		        }
		    }
		});
		
		horarioTableColumn.setCellFactory(c -> new TableCell<>() {
		    @Override
		    protected void updateItem(LocalTime horario, boolean empty) {
		        super.updateItem(horario, empty);
		        if (horario == null || empty) {
		            setText(null);
		        } else {
		        	DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("HH:mm");
		            setText(horario.format(formatoData));
		        }
		    }
		});
		
		observableListVendas = FXCollections.observableArrayList();
		observableListVendas.addAll(listaVendas);
		vendasTableView.setItems(observableListVendas);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarVendas();
		
	}

}
