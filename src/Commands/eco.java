package Commands;

import API.EcoAPI;
import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class eco extends Command{
	
	private CupidCraft plugin;

	public eco(String name, CupidCraft plugin) {
		super("eco");
		this.setPermission("eco.commandssss");
		this.plugin = plugin;
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player instanceof Player) {
			if(player.hasPermission("eco.commandssss")) {
				EcoAPI eco = new EcoAPI(plugin);
				if(arg2.length == 0) {
					player.sendMessage("Fail pls try again");
					return true;
				}
				switch(arg2[0].toLowerCase()) {
				case "add":
					int i = Integer.parseInt(arg2[2]);
					eco.addMoney(arg2[1], i);
					player.sendMessage("add money: "+arg2[1]+"amount: "+arg2[2]);
					break;
				case "reduce":
					int i1 = Integer.parseInt(arg2[2]);
					eco.reduceMoney(arg2[1], i1);
					player.sendMessage("reduce money: "+arg2[1]+"amount: "+arg2[2]);
					break;
				}
			} else {
				player.sendMessage("for admin");
			}
		}
		return false;
	}


}
