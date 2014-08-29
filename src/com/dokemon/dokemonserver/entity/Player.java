package com.dokemon.dokemonserver.entity;

import java.util.HashSet;
import java.util.Set;
import com.esotericsoftware.kryonet.Connection;

public class Player {
	private static Set<Player> players = new HashSet<Player>();
	private static int serverIdCount = 0;
	
	private String name;
	private Connection connection;
	private int serverId;
	
	public Player(String name, Connection connection) {
		getPlayers().add(this);
		
		this.name = name;
		this.connection = connection;
		this.serverId = generateServerId();
	}

	public Connection getConnection() {
		return this.connection;
	}
	
	public static int generateServerId() {
		serverIdCount++;
		return serverIdCount;
	}

	public static Set<Player> getPlayers() {
		return players;
	}

	public String getName() {
		return this.name;
	}

	public int getServerId() {
		return this.serverId;
	}
}
