package Commands;

import API.NpcAPI;
import CupidCraft.CupidCraft;
import Math.RandomId;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class npc extends Command{

	private CupidCraft plugin;
	
	public npc(String name, CupidCraft plugin) {
		super("npc");
		this.plugin = plugin;
		this.setPermission("npcss");
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player instanceof Player) {
			if(player.hasPermission("npcss")) {
				NpcAPI npc = new NpcAPI(plugin);
				 String answer = "";
			     int randomLength = (int) RandomId.rand(10.0,20.0);
			     String characters       = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			     int charactersLength = characters.length();
			     for (int i = 0; i < randomLength; i++ ) {
			          answer += characters.charAt((int) Math.floor(Math.random() * charactersLength));
			     }
			    String character = "NPC"+answer;
				if(arg2.length == 0) {
					player.sendMessage("Fail pls try again");
					return true;
				}
				switch(arg2[0].toLowerCase()) {
				case "create":
					npc.CreateNpc(character, arg2[1], player.getFloorX(), player.getFloorY(), player.getFloorZ(), player.getLevel().getName(), arg2[2]);
					player.sendMessage("Npc Created Name: "+arg2[1]+"Command: "+arg2[2]);
					break;
				case "setCommand":
					npc.setCommand(arg2[1], arg2[2]);
					player.sendMessage("Npc set Command: "+arg2[2]);
					break;
				case "removeCommand":
					npc.removeCommand(arg2[1]);
					player.sendMessage("Npc removed Command: "+arg2[2]);
					break;
				}
			}
		}
		return false;
	}

}
