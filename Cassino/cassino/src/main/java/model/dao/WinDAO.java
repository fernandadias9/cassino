package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.WinVO;

public class WinDAO {
	
	public double checkPlayerBalanceDAO(WinVO winVO) {
		Connection conn = Base.getConnection();
		Statement stmt = Base.getStatement(conn);	
		ResultSet result = null;
		double playerBalance = 0;
		String query = "SELECT balance FROM player WHERE idplayer = " + winVO.getIdPlayer();
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

	public WinVO registerWinDAO(WinVO winVO) {
		String query = "INSERT INTO win (idplayer, transactionvalue) VALUES (?, ?)";
		Connection conn = Base.getConnection();
		PreparedStatement pstmt = Base.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setInt(1, winVO.getIdPlayer());
			pstmt.setDouble(2, winVO.getValue());
			pstmt.execute();
			ResultSet result = pstmt.getGeneratedKeys(); 
			if(result.next()) {
				winVO.setIdTransaction(result.getInt(1));
			}
		} catch(SQLException error) {
			System.out.println("\nError executing method query registerBetDAO.");
			System.out.println("Error: " + error.getMessage());
		} finally {
			Base.closePreparedStatement(pstmt);
			Base.closeConnection(conn);
		}
		return winVO;
	}
	
	public double updatePlayerBalanceDAO(WinVO winVO) {
		WinDAO winDAO = new WinDAO();
		Connection conn = Base.getConnection();
		Statement stmt = Base.getStatement(conn);	
		boolean updatedBalance = false;
		double playerBalance = 0;
		String query = "UPDATE player SET balance = balance + " + winVO.getValue() + "WHERE idplayer = " + winVO.getIdPlayer();
		try {
			if(stmt.executeUpdate(query) == 1) {
				updatedBalance = true;
			}
			if(updatedBalance) {
				playerBalance = winDAO.checkPlayerBalanceDAO(winVO);
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
