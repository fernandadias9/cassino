package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.PlayerVO;

public class PlayerDAO {

	public boolean checkPlayerRegistrationInDatabaseDAO(PlayerVO playerVO) {
		Connection conn = Base.getConnection();
		Statement stmt = Base.getStatement(conn);
		ResultSet result = null;
		boolean playerExists = false;
		String query = "SELECT nameplayer FROM player WHERE nameplayer = '" + playerVO.getName() + "'";
		try {
			result = stmt.executeQuery(query); 
			if(result.next()) { 
				playerExists = true;
			}
		} catch(SQLException error) {
			System.out.println("\nError executing method query checkPlayerRegistrationInDatabaseDAO.");
			System.out.println("Error: " + error.getMessage());
		} finally {
			Base.closeResultSet(result);
			Base.closeStatement(stmt);
			Base.closeConnection(conn);
		}
		return playerExists;		
	}
	
	public PlayerVO registerPlayerDAO(PlayerVO playerVO) {
		String query = "INSERT INTO usuario (name, balance) VALUES (?, ?)";
		Connection conn = Base.getConnection();
		PreparedStatement pstmt = Base.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setString(1, playerVO.getName());
			pstmt.setDouble(2, playerVO.getBalance());
			pstmt.execute();
			ResultSet result = pstmt.getGeneratedKeys(); 
			if(result.next()) {
				playerVO.setIdPlayer(result.getInt(1));
			}
		} catch(SQLException error) {
			System.out.println("\nError executing method query registerPlayerDAO.");
			System.out.println("Error: " + error.getMessage());
		} finally {
			Base.closePreparedStatement(pstmt);
			Base.closeConnection(conn);
		}
		return playerVO;
	}
	
	public PlayerVO checkPlayerBalanceDAO(int idPlayer) {
		PlayerVO player = new PlayerVO();
		Connection conn = Base.getConnection();
		Statement stmt = Base.getStatement(conn);	
		ResultSet result = null;
		String query = "SELECT idplayer, balance FROM player WHERE idplayer = " + idPlayer;
		try {
			result = stmt.executeQuery(query);
			if(result.next()) { 
				player.setIdPlayer(idPlayer);
				player.setBalance(result.getDouble(2));
			}
		} catch(SQLException error) {
			System.out.println("\nError executing method query checkPlayerBalanceDAO.");
			System.out.println("Error: " + error.getMessage());
		} finally {
			Base.closeResultSet(result);
			Base.closeStatement(stmt);
			Base.closeConnection(conn);
		}
		return player;
	}
}
