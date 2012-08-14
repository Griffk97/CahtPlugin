package com.jetfan.plugin.RegionBroadcast;

import org.bukkit.plugin.java.JavaPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.plugin.Plugin;
public class Main extends JavaPlugin{

	private MainCommandExecutor mainExecutor;

	public void onEnable(){
		mainExecutor = new MainCommandExecutor(this);
		getCommand("sayl").setExecutor(mainExecutor);
	}
 
	public void onDisable(){
		
	}

	 
	public WorldGuardPlugin getWorldGuard() {
	    Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
	 
	    // WorldGuard may not be loaded
	    if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
	        return null; // Maybe you want throw an exception instead
	    }
	 
	    return (WorldGuardPlugin) plugin;
	}
}
