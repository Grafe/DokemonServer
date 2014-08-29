package com.dokemon.dokemonserver.net.packages;

import com.dokemon.dokemonserver.entity.Player;
import com.esotericsoftware.kryonet.Connection;

public class ChatPackage extends NetPackage{
	public int playerId;
	public String message;
	
	@Override
	public void onRecieve(Connection connection) {
		Player player = Player.get(connection);
		
		if (player != null) {
			this.playerId = player.getServerId();
			
			for(Player oplayer : Player.getPlayers()){
				oplayer.getConnection().sendTCP(this);
			}
		}
	}
}
