package Sistema;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String entradaTipoCliente = entrada("Escolha o Tipo de Cliente (Regular/Reward): ");
		String entradaDataInicio = entrada("Data de Entrada: (DD/MM/YYYY)");
		String entradaDataFim = entrada("Data de Saída (DD/MM/YYYY)");
		
		TipoCliente tipoCliente = TipoCliente.valueOf(entradaTipoCliente);
				
		Datas GerenciarDatas = new Datas();
		Date dataInicio = GerenciarDatas.toDate(entradaDataInicio);
		Date dataFim = GerenciarDatas.toDate(entradaDataFim);
		List<Date> periodo = GerenciarDatas.getPeriodo(dataInicio, dataFim);

		ArrayList<Hotel> hoteis = new ArrayList<Hotel>();
		hoteis.add(new Hotel("Lakewood", 3, 110, 80, 90, 80));
		hoteis.add(new Hotel("Bridgewood", 4, 160, 110, 60, 50));
		hoteis.add(new Hotel("Ridgewood", 5, 220, 100, 150, 40));

		GerenciadorTarifas gerenciarTarifas = new GerenciadorTarifas();
		Tarifas melhorTarifa = gerenciarTarifas.getMelhorTarifa(tipoCliente, periodo, hoteis);
		System.out.println("------------------------------------------");
		System.out.println("O hotel mais barato para este período é: " + melhorTarifa.getHotel());
		System.out.printf("O Valor Total é: R$ %.2f", melhorTarifa.getPreco());
		
	}
	
	private static String entrada(String info) {
		System.out.print(info + " ");
		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String s = bufferRead.readLine();
			return s;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
