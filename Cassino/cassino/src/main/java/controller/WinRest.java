package controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.dao.WinDAO;
import model.vo.WinVO;


@Path("/win")
public class WinRest {

	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String registerBet(WinVO winVO) {
		WinDAO winDAO = new WinDAO();
		winDAO.registerWinDAO(winVO);
		winDAO.updatePlayerBalanceDAO(winVO);		
		return "player: " + winVO.getIdPlayer() + "balance: " + winDAO.checkPlayerBalanceDAO(winVO) + "txn: " + winVO.getIdTransaction();
	}
}
