package Commands;

import API.RankAPI;
import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class rank extends Command{
	
	private CupidCraft plugin;

	public rank(String name,CupidCraft plugin) {
		super("rank");
		this.setPermission("rank.command");
		this.plugin = plugin;
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player.hasPermission("rank.command")) {
			RankAPI rank = new RankAPI(plugin);
			if(arg2.length == 0) {
				player.sendMessage("Fail pls try again");
				return true;
			}
			switch(arg2[0].toLowerCase()) {
			case "setgroup":
				rank.setRank(arg2[1], arg2[2]);
				player.sendMessage("setgroup completed: "+arg2[1]+" Group:"+arg2[2]);
				break;
			case "removegroup":
				rank.setRank(arg2[1], arg2[2]);
				player.sendMessage("removegroup completed: "+arg2[1]+" Group:"+arg2[2]);
				break;
			}
		}
		return false;
	}

}
