package Commands;

import CupidCraft.CupidCraft;
import Forms.reportForm;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class report extends Command {
	
	private CupidCraft plugin;

	public report(String name, CupidCraft plugin) {
		super("reportsdawda");
		this.plugin = plugin;
		this.setPermission("adwadsada");
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player instanceof Player) {
			reportForm form = new reportForm(plugin);
			form.Report(player);
		}
		return false;
	}

}
