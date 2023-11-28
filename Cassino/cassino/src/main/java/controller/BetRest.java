package controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.bo.BetBO;
import model.dao.BetDAO;
import model.vo.BetVO;
import model.vo.CarteiraDigitalVO;

@Path("/bet")
public class BetRest {
	
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CarteiraDigitalVO registerBet(BetVO betVO) {
		BetBO bet = new BetBO();
		BetDAO betDAO = new BetDAO();
		CarteiraDigitalVO carteira = new CarteiraDigitalVO();
		bet.registerBetBO(betVO);
		betDAO.updatePlayerBalanceDAO(betVO);
		double finalBalance = betDAO.checkPlayerBalanceDAO(betVO);
		carteira.setPlayer(betVO.getIdPlayer());
		carteira.setBalance(finalBalance);
		carteira.setTxn(betVO.getIdTransaction());
		return carteira;		
	}
}
