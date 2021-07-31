package Commands;

import CupidCraft.CupidCraft;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class admin extends Command{

	private CupidCraft plugin;

	public admin(String name,CupidCraft plugin) {
		super("admin");
		this.plugin = plugin;
		this.setPermission("admin.cmd");
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return false;
	}

}
