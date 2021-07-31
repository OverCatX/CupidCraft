package Commands;

import API.SkyBlockAPI;
import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class island extends Command{

	private CupidCraft plugin;

	public island(String name, CupidCraft plugin) {
		super("island");
		this.setPermission("wadasda");
		this.plugin = plugin;
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player instanceof Player) {
			if(player.hasPermission("eco.commandssss")) {
				SkyBlockAPI skyblock = new SkyBlockAPI(plugin);
				if(arg2.length == 0) {
					player.sendMessage("Fail pls try again");
					return true;
				}
				switch(arg2[0].toLowerCase()) {
				case "add":
					skyblock.addMembers(player,arg2[1], arg2[2]);
					player.sendMessage("add Player: "+arg2[1]+" Island: "+arg2[2]);
					break;
				}
			} else {
				player.sendMessage("for admin");
			}
		}
		return false;
	}

}
