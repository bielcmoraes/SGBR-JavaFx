package model;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

/**Classe para objetos do tipo Relatorio, onde são contidos, valores e metódos necessarios para implementação da classe.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class Relatorio{
	
	/**Cria um novo documento PDF, adicona as informações de data e horário fornecedidos pelo sistema, tipo de relatório e a tabela que foi passada
	 * como parâmetro ao documento criado. Por fim fecha o documento criado. 
	 * 
	 * @param tabela Tabela com as informações do relatório
	 * @param tipoRelatorio Título do relatório
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	public Relatorio(Table tabela, String tipoRelatorio) throws DocumentException, FileNotFoundException {
		
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("HH:mm");
    	
    	//Data e horarios do sistema formatados
    	String data = formatoData.format(LocalDate.now());
    	String horario = formatoHorario.format(LocalTime.now());
        
    	//Instancia um novo documento
    	Document documentPDF = new Document();
        
        	String nomeArquivo = tipoRelatorio.toLowerCase().replaceAll("\\s+","_") + data.formatted(formatoData).replace("-", "")+".pdf";
            PdfWriter.getInstance(documentPDF, new FileOutputStream(nomeArquivo));
            documentPDF.open();
            
            //Cabeçalho do Arquivo
            Paragraph cabecalho = new Paragraph();
            cabecalho.add("\nData: " + data);
            cabecalho.add("\nHorário: " + horario);
            cabecalho.add("\n\n" + tipoRelatorio);
            
            //Tabela com as informações
            Paragraph corpo = new Paragraph();
            corpo.add(tabela);
            
            //Adiciona os paragrafos ao documento
            documentPDF.add(cabecalho);
            documentPDF.add(corpo);
            documentPDF.close();
	}
	
	/**Cria um novo documento PDF, adicona as informações de data e horário fornecedidos pelo sistema, tipo de relatório e as duas tabelas que foram
	 * passadas como parâmetro ao documento criado. Por fim fecha o documento criado. 
	 * 
	 * @param tabela Tabela com as informações do relatório
	 * @param tipoRelatorio Título do relatório
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	public Relatorio(Table tabela1, Table tabela2, String tipoRelatorio) throws DocumentException, FileNotFoundException {
		
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("HH:mm");
    	
    	//Data e horarios do sistema formatados
    	String data = formatoData.format(LocalDate.now());
    	String horario = formatoHorario.format(LocalTime.now());
        
    	//Instancia um novo documento
    	Document documentPDF = new Document();
    	
    	String nomeArquivo = tipoRelatorio.toLowerCase().replaceAll("\\s+","_") + data.formatted(formatoData).replace("-", "")+".pdf";
        PdfWriter.getInstance(documentPDF, new FileOutputStream(nomeArquivo));

        documentPDF.open();
        //Cabeçalho do Arquivo
        Paragraph cabecalho = new Paragraph();
        cabecalho.add("\nData: " + data);
        cabecalho.add("\nHorário: " + horario);
        cabecalho.add("\n\n" + tipoRelatorio);
        
        Paragraph corpo = new Paragraph();
        corpo.add(tabela1);
        corpo.add(tabela2);
        
        //Adiciona os paragrafos ao documento
        documentPDF.add(cabecalho);
        documentPDF.add(corpo);
        documentPDF.close();
	}
	
	public Relatorio(Venda venda) throws DocumentException, FileNotFoundException {
		
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("HH:mm");
    	
    	//Instancia um novo documento
    	Document documentPDF = new Document();
    	
    	String nomeArquivo = venda.getId() + "nota" + formatoData.format(venda.getData()) + ".pdf";
        PdfWriter.getInstance(documentPDF, new FileOutputStream(nomeArquivo));
        documentPDF.open();
        
        
        //Cabeçalho do Arquivo
        Paragraph cabecalho = new Paragraph();
        cabecalho.add("\nRelatório fiscal - NIMBUS GERENCIAMENTO");
        Table tabelaCabecalho = new Table(1);
        String data = "\nData: " + formatoData.format(venda.getData());
        String horario = "\nData: " + formatoHorario.format(venda.getHorario());
        tabelaCabecalho.addCell(data);
        tabelaCabecalho.addCell(horario);
        
        /* Esperar adicionar o cliente em vendas
        //Corpo do arquivo
        Paragraph infoCliente = new Paragraph();
        infoCliente.add("\nInformações do cliente");
        Table tabelaCliente = new Table(1);
        */
        
        Paragraph infoVenda = new Paragraph();
        infoVenda.add("\nInformações da venda");
        Table tabelaVenda = new Table(2);
        Cell pratosText = new Cell(new Paragraph("Pratos"));
        pratosText.setColspan(2);
		tabelaVenda.addCell(pratosText);
        for(Prato prato : venda.getPratos()) {
        	tabelaVenda.addCell(prato.getNome());
        	tabelaVenda.addCell(String.valueOf(prato.getPreco()));
        }
        
        Paragraph pagamentotext = new Paragraph();
        pagamentotext.add("\nMétodo de pagamento: " + venda.getMetodoDePagamento());
        Paragraph totalText = new Paragraph();
        totalText.add("\nTotal: " + String.valueOf(venda.getPrecoTotal()));
        
      //Adiciona os paragrafos ao documento
        documentPDF.add(cabecalho);
        documentPDF.add(tabelaCabecalho);
        /*
        documentPDF.add(infoCliente);
        documentPDF.add(tabelaCliente);
        */
        documentPDF.add(infoVenda);
        documentPDF.add(tabelaVenda);
        documentPDF.add(pagamentotext);
        documentPDF.add(totalText);
        documentPDF.close();
	}
	
}