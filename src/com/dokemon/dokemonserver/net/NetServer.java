package com.dokemon.dokemonserver.net;

import java.io.IOException;

import com.dokemon.dokemonserver.net.packages.PlayerLoginPackage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Server;

public class NetServer {
	public Server server;

	public static Kryo kryo;

	public NetServer (){
		server = new Server();

		// Register the classes that will be sent over the network.
		registerKryoClasses(server);

		// Add listener
		server.addListener(new NetListener());

		//Bind port
		try {
			server.bind(54555,54556);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Start server
		server.start();
	}

	//Kryo
	public static void registerKryoClasses (EndPoint endPoint) {
		kryo = endPoint.getKryo();

		//Initialize kryo classes
		kryo.register(PlayerLoginPackage.class);

		//TODO: Automatisieren
	}
}
