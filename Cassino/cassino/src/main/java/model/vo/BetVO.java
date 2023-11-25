package model.vo;

public class BetVO {

	private int idTransaction;
	private int idPlayer;
	private double value;	

	public BetVO(int idTransaction, int idPlayer, double value) {
		super();
		this.idTransaction = idTransaction;
		this.idPlayer = idPlayer;
		this.value = value;
	}
	
	public BetVO() {
		super();
	}

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
