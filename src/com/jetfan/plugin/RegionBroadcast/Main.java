package com.jetfan.plugin.RegionBroadcast;

import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin{

	private MainCommandExecutor mainExecutor;

	public void onEnable(){
		mainExecutor = new MainCommandExecutor(this);
		getCommand("sayl").setExecutor(mainExecutor);
	}
 
	public void onDisable(){
		
	}
}
