package Sistema;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Sistema.TipoCliente.Regular;
import static Sistema.TipoCliente.Reward;

public class GerenciadorTarifas {

	public Tarifas getMelhorTarifa(TipoCliente tipoCliente, List<Date> periodo, List<Hotel> hoteis) {

		List<Tarifas> listaDeTarifas = new ArrayList<Tarifas>();

		for (Hotel hotel : hoteis) {
			Tarifas tarifa = calculaTarifaDoHotel(tipoCliente, periodo, hotel);
			listaDeTarifas.add(tarifa);
		}

		Tarifas menorTarifa = calculaMenorTarifa(listaDeTarifas);

		return menorTarifa;
	}

	private Tarifas calculaMenorTarifa(List<Tarifas> listaDeTarifas) {

		Tarifas menorTarifa = null;

		for (Tarifas tarifa : listaDeTarifas) {
			if (menorTarifa == null || tarifa.getPreco() < menorTarifa.getPreco()) {
				menorTarifa = tarifa;
			} else if (tarifa.getPreco().equals(menorTarifa.getPreco()) && tarifa.getHotel().getClassificacao() > menorTarifa.getHotel().getClassificacao()) {
				menorTarifa = tarifa;
			}
		}

		return menorTarifa;
	}

	private Tarifas calculaTarifaDoHotel(TipoCliente tipoCliente, List<Date> periodo, Hotel hotel) {

		Datas GerenciarDatas = new Datas();
		Double preco = 0d;
		for (Date data : periodo) {
			if (tipoCliente == Regular) {
				if (GerenciarDatas.FimDeSemana(data)) {
					preco += hotel.getFimSemanaRegular();
				} else {
					preco += hotel.getDiaUtilRegular();
				}
			} else if (tipoCliente == Reward) {
				if (GerenciarDatas.FimDeSemana(data)) {
					preco += hotel.getFimSemanaReward();
				} else {
					preco += hotel.getDiaUtilReward();
				}
			}
		}

		Tarifas tarifa = new Tarifas(hotel, preco);

		return tarifa;
	}

}
