package model.vo;

public class PlayerVO {

	private int idPlayer;
	private String name;
	private double balance;
		
	public PlayerVO(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}	

	public PlayerVO() {
		super();
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}	
}
