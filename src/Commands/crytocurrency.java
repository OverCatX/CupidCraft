package Commands;

import CupidCraft.CupidCraft;
import Forms.cryptoForm;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class crytocurrency extends Command{
	
	private CupidCraft plugin;

	public crytocurrency(String name,CupidCraft plugin) {
		super("crypto");
		this.plugin = plugin;
		this.setPermission("cryotsodakdwoidmaofmsoif");
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player instanceof Player) {
			cryptoForm form = new cryptoForm(plugin);
			form.CurrencyForm(player);
		}
		return false;
	}

}
