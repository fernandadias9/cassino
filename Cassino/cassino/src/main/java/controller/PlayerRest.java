package controller;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.dao.PlayerDAO;
import model.vo.PlayerVO;

@Path("/player")
public class PlayerRest {

	@GET
	@Path("/balance/{idplayer}")
	@Produces(MediaType.APPLICATION_JSON)
	public PlayerVO playerBalance(@PathParam("idplayer") int idplayer) {
		PlayerDAO player = new PlayerDAO();
		return player.checkPlayerBalanceDAO(idplayer);
	}

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PlayerVO registerPlayerController(PlayerVO playerVO) {
		PlayerBO playerBO = new PlayerBO();
		return playerBO.registerPlayerBO(playerVO);
	}
}
