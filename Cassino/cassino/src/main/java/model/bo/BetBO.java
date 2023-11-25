package model.bo;

import model.dao.BetDAO;
import model.vo.BetVO;

public class BetBO {

	public BetVO registerBetBO(BetVO betVO) {
		BetDAO betDAO = new BetDAO();
		if(betDAO.checkPlayerBalanceDAO(betVO) < betVO.getValue()) {
			System.out.println("\nInsufficient balance to place the bet.");
		} else {			
			betVO = betDAO.registerBetDAO(betVO);
		}
		return betVO;
	}
}