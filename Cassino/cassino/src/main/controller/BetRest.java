package controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.bo.BetBO;
import model.dao.BetDAO;
import model.vo.BetVO;

@Path("/bet")
public class BetRest {

	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String registerBet(BetVO betVO) {
		BetBO bet = new BetBO();
		BetDAO betDAO = new BetDAO();
		bet.registerBetBO(betVO);
		betDAO.updatePlayerBalanceDAO(betVO);		
		return "player: " + betVO.getIdPlayer() + "balance: " + betDAO.checkPlayerBalanceDAO(betVO) + "txn: " + betVO.getIdTransaction();
	}
}
