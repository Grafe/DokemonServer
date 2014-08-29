package com.dokemon.dokemonserver;

import com.dokemon.dokemonserver.net.NetServer;

public class Main {
	private static NetServer netServer;
	
	public static void main (String args[]) {
		netServer = new NetServer();
		
		return;
	}
}
