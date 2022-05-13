package Sistema;


public class Hotel {
	private String nome;
	private int classificacao;
	private double diaUtilRegular;
	private double diaUtilReward;
	private double fimSemanaRegular;
	private double fimSemanaReward;

	public Hotel(String nome, int classificacao, double diaUtilRegular, double diaUtilReward, double fimSemanaRegular,
			double fimSemanaReward) {
		this.nome = nome;
		this.classificacao = classificacao;
		this.diaUtilRegular = diaUtilRegular;
		this.diaUtilReward = diaUtilReward;
		this.fimSemanaRegular = fimSemanaRegular;
		this.fimSemanaReward = fimSemanaReward;
	}

	public String getNome() {
		return nome;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public double getDiaUtilRegular() {
		return diaUtilRegular;
	}

	public double getDiaUtilReward() {
		return diaUtilReward;
	}

	public double getFimSemanaRegular() {
		return fimSemanaRegular;
	}

	public double getFimSemanaReward() {
		return fimSemanaReward;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public void setDiaUtilRegular(double diaUtilRegular) {
		this.diaUtilRegular = diaUtilRegular;
	}

	public void setDiaUtilReward(double diaUtilReward) {
		this.diaUtilReward = diaUtilReward;
	}

	public void setFimSemanaRegular(double fimSemanaRegular) {
		this.fimSemanaRegular = fimSemanaRegular;
	}

	public void setFimSemanaReward(double fimSemanaReward) {
		this.fimSemanaReward = fimSemanaReward;
	}

	@Override
	public String toString() {
		return this.getNome();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classificacao;
		long temp;
		temp = Double.doubleToLongBits(diaUtilRegular);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(diaUtilReward);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fimSemanaRegular);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fimSemanaReward);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (classificacao != other.classificacao)
			return false;
		if (Double.doubleToLongBits(diaUtilRegular) != Double.doubleToLongBits(other.diaUtilRegular))
			return false;
		if (Double.doubleToLongBits(diaUtilReward) != Double.doubleToLongBits(other.diaUtilReward))
			return false;
		if (Double.doubleToLongBits(fimSemanaRegular) != Double.doubleToLongBits(other.fimSemanaRegular))
			return false;
		if (Double.doubleToLongBits(fimSemanaReward) != Double.doubleToLongBits(other.fimSemanaReward))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
