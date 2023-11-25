package cassino;

public class Player {

	private int idPlayer;
	private String name;
	private double balance;
	
	
	public Player(int idPlayer, String name, double balance) {
		super();
		this.idPlayer = idPlayer;
		this.name = name;
		this.balance = balance;
	}

	public Player() {
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