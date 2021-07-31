package Commands;

import CupidCraft.CupidCraft;
import Forms.playerdataForm;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class playerdata extends Command{
	
	private CupidCraft plugin;

	public playerdata(String name,CupidCraft plugin) {
		super("playerdataaaaa");
		this.setPermission("bbbbbsd");
		this.plugin = plugin;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player instanceof Player) {
			playerdataForm form = new playerdataForm(plugin);
			form.PlayerData(player);
		}
		return false;
	}

}
