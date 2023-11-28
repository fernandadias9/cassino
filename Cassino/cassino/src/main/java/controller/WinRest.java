package controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.bo.BetBO;
import model.dao.BetDAO;
import model.dao.WinDAO;
import model.vo.BetVO;
import model.vo.CarteiraDigitalVO;
import model.vo.WinVO;

@Path("/win")
public class WinRest {

	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CarteiraDigitalVO registerBet(WinVO winVO) {
		WinDAO winDAO = new WinDAO();
		CarteiraDigitalVO carteira = new CarteiraDigitalVO();
		winDAO.registerWinDAO(winVO);		
		winDAO.updatePlayerBalanceDAO(winVO);		
		double finalBalance = winDAO.checkPlayerBalanceDAO(winVO);
		carteira.setPlayer(winVO.getIdPlayer());
		carteira.setBalance(finalBalance);
		carteira.setTxn(winVO.getIdTransaction());
		return carteira;
	}
}	
