package Commands;

import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class clan extends Command{
	
	private CupidCraft plugin;

	public clan(String name, CupidCraft plugin) {
		super("ccc2");
		this.setPermission("sss");
		this.plugin = plugin;
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player instanceof Player) {
			
		}
		return false;
	}

}
