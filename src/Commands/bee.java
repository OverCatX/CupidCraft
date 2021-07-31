package Commands;

import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class bee extends Command{
	
	private CupidCraft plugin;

	public bee(String name,CupidCraft plugin) {
		super("beesdadwads");
		this.plugin = plugin;
		this.setPermission("bessdfds.bee");
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player instanceof Player) {
			 
		}
		return false;
	}
}
