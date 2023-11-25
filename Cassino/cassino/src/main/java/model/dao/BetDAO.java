package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.BetVO;

public class BetDAO {
	
	public double checkPlayerBalanceDAO(BetVO betVO) {
		Connection conn = Base.getConnection();
		Statement stmt = Base.getStatement(conn);	
		ResultSet result = null;
		double playerBalance = 0;
		String query = "SELECT balance FROM player WHERE idplayer = " + betVO.getIdPlayer();
		try {
			result = stmt.executeQuery(query);
			if(result.next()) { 
				playerBalance = result.getDouble("balance");
			}
		} catch(SQLException error) {
			System.out.println("\nError executing method query checkPlayerBalanceDAO.");
			System.out.println("Error: " + error.getMessage());
		} finally {
			Base.closeResultSet(result);
			Base.closeStatement(stmt);
			Base.closeConnection(conn);
		}
		return playerBalance;
	}
	
	public BetVO registerBetDAO(BetVO betVO) {
		String query = "INSERT INTO bet (idplayer, betvalue) VALUES (?, ?)";
		Connection conn = Base.getConnection();
		PreparedStatement pstmt = Base.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setInt(1, betVO.getIdPlayer());
			pstmt.setDouble(2, betVO.getValue());
			pstmt.execute();
			ResultSet result = pstmt.getGeneratedKeys(); 
			if(result.next()) {
				betVO.setIdTransaction(result.getInt(1));
			}
		} catch(SQLException error) {
			System.out.println("\nError executing method query registerBetDAO.");
			System.out.println("Error: " + error.getMessage());
		} finally {
			Base.closePreparedStatement(pstmt);
			Base.closeConnection(conn);
		}
		return betVO;
	}
	
	public double updatePlayerBalanceDAO(BetVO betVO) {
		BetDAO betDAO = new BetDAO();
		Connection conn = Base.getConnection();
		Statement stmt = Base.getStatement(conn);	
		boolean updatedBalance = false;
		double playerBalance = 0;
		String query = "UPDATE FROM player SET balance = balance - " + betVO.getValue() + "WHERE idplayer = " + betVO.getIdPlayer();
		try {
			if(stmt.executeUpdate(query)  == 1) {
				updatedBalance = true;
			}
			if(updatedBalance) {
				playerBalance = betDAO.checkPlayerBalanceDAO(betVO);
			}
		} catch(SQLException erro ){
			System.out.println("\nErro ao executar a query do método atualizarPessoaDAO.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Base.closeStatement(stmt);
			Base.closeConnection(conn);
		}
		return playerBalance;
	}
}