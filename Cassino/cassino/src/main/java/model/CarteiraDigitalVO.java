package model.vo;

public class CarteiraDigitalVO {

	private int player;
	private double balance;
	private int txn;
		
	public CarteiraDigitalVO(int player, double balance, int txn) {
		super();
		this.player = player;
		this.balance = balance;
		this.txn = txn;
	}


	public CarteiraDigitalVO() {
		super();
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getTxn() {
		return txn;
	}

	public void setTxn(int txn) {
		this.txn = txn;
	}
}