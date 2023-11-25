package model.vo;

public class WinVO {

	private int idTransaction;
	private int idPlayer;
	private double value;	

	public WinVO(int idTransaction, int idPlayer, double value) {
		super();
		this.idTransaction = idTransaction;
		this.idPlayer = idPlayer;
		this.value = value;
	}

	public WinVO() {
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
