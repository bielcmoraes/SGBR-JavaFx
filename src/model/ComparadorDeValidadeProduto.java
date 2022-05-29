package model;

import java.util.Comparator;

public class ComparadorDeValidadeProduto implements Comparator<Produto>{

	@Override
	public int compare(Produto o1, Produto o2) {
		if (o1.getValidade().isBefore(o2.getValidade())) {
			return -1;
		} else if (o1.getValidade().isAfter(o2.getValidade())) {
			return +1;
		} else {
			return 0;
		}
	}

}
