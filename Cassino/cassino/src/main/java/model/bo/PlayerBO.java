package model.bo;

import model.dao.PlayerDAO;
import model.vo.PlayerVO;

public class PlayerBO {

	public PlayerVO registerPlayerBO(PlayerVO playerVO) {
		PlayerDAO playerDAO = new PlayerDAO();
		if(playerDAO.checkPlayerRegistrationInDatabaseDAO(playerVO)) {
			System.out.println("\nPerson already registered in the database.");
		} else {			
			playerVO = playerDAO.registerPlayerDAO(playerVO);
		}
		return playerVO;
	}
}
