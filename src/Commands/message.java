package Commands;

import API.welcomeapi;
import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class message extends Command{
	
	private CupidCraft plugin;

	public message(String name, CupidCraft plugin) {
		super("setmessage");
		this.setPermission("messageas,q0cqwpfkefoik");
		this.plugin = plugin;
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player.hasPermission("messageas,q0cqwpfkefoik")) {
			welcomeapi welcome = new welcomeapi(plugin);
			welcome.setMessage(arg1);
			player.sendMessage("Message has changed: "+arg1);
		}
		return false;
	}

}
