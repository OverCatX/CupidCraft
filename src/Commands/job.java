package Commands;

import CupidCraft.CupidCraft;
import Forms.jobForm;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class job extends Command{
	
	private CupidCraft plugin;

	public job(String name,CupidCraft plugin) {
		super("jobasdawqbbbb");
		this.plugin = plugin;
		this.setPermission("asdwwaafweef");
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player instanceof Player) {
			jobForm form = new jobForm(plugin);
			form.Job(player);
		}
		return false;
	}

}
