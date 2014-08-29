package com.dokemon.dokemonserver.net.packages;

import com.dokemon.dokemonserver.entity.Player;
import com.esotericsoftware.kryonet.Connection;

public class PlayerLoginPackage extends NetPackage{
	public String name;
	public int serverId;

	@Override
	public void onRecieve(Connection connection) {
		Player player = new Player(this.name, connection);

		this.serverId = player.getServerId();
		
		System.out.printf("Player '%s' logged in" , this.name);
		
		for(Player oplayer : Player.getPlayers()){
			oplayer.getConnection().sendTCP(this);
			
			if(oplayer != player){
				PlayerLoginPackage playerNew = new PlayerLoginPackage();
				playerNew.name = oplayer.getName();
				playerNew.serverId = oplayer.getServerId();
				player.getConnection().sendTCP(playerNew);
			}
		}
	}
}	
