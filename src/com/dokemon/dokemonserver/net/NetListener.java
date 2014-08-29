package com.dokemon.dokemonserver.net;

import com.dokemon.dokemonserver.net.packages.NetPackage;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class NetListener extends Listener{

	@Override
	public void disconnected(Connection connection){
		/*Player player = Player.get(connection);
		if(player != null){
			player.remove();

			//Send Disconnect
			PlayerDisconnectPackage disconnectPackage = new PlayerDisconnectPackage();
			disconnectPackage.playerId = player.getId();
			for(Player oplayer : Player.get()){
				oplayer.getConnection().sendTCP(disconnectPackage);
			}
		}*/
	}

	@Override
	public void received(Connection connection, Object object){
		if(object instanceof NetPackage){
			NetPackage netPackage = (NetPackage) object;
			netPackage.onRecieve(connection);
		}
	}
}
