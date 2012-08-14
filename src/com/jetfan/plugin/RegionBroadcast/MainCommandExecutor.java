package com.jetfan.plugin.RegionBroadcast;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class MainCommandExecutor implements CommandExecutor{
	List<String> set;
	private Main main;

	public MainCommandExecutor(Main main) {
		this.main=main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		} else {
			sender.sendMessage("Please use as a player.");
		}
		if(cmd.getName().equalsIgnoreCase("sayl")){
			Location loc = player.getLocation();
			Player[] playing = main.getServer().getOnlinePlayers();
			if (args == null){
				return true;
			}
			for(int i = 0; i<playing.length;i++){
					int b = 0;
					int x = 0, y = 0, z = 0;
					boolean xt = false, yt = false, zt = false;
					Location loc2 = playing[i].getLocation();
					double distance = loc.distance(loc2);
					double range=100;
					try{
					if(Double.valueOf(args[0]) != null){
						range = Double.valueOf(args[0]);
						b=1;

					}
					} catch(NumberFormatException e){
						
					}
					boolean brea=true;
					do{
					try{
						if(Integer.valueOf(args[1]) != null){
							x = Integer.valueOf(args[1]);
							b=2;
							
						}
						} catch(NumberFormatException e){
							
					}
					try{
						if(Integer.valueOf(args[2]) != null){
							y = Integer.valueOf(args[2]);
							b=3;
							
						}
						} catch(NumberFormatException e){
							
					}
					try{
						if(Integer.valueOf(args[3]) != null){
							z = Integer.valueOf(args[3]);
							b=4;
							
						}
						} catch(NumberFormatException e){
							
					}
					if(x!=0){
						xt=true;
					}
					if(y!=0){
						yt=true;
					}
					if(z!=0){
						zt=true;
					}
					if(xt==true&&yt==true&&zt==true){
						brea=false;
					} else {
						return false;
					}
					}  while(brea==true);
					
					String str = "&3[Local] &r"+player.getDisplayName()+": &7";
					if(distance<=range){
						for (int a = b;a<args.length;a++) {
							str=str.concat(args[a]).concat(" ");
							
						}
						str=ChatColor.translateAlternateColorCodes('&', str);
						if(playing[i]!=player){
						playing[i].sendMessage(str);
						}
						return true;
					}
				
				
			}
		}
		return false;
		} 

}
