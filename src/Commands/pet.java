package Commands;

import CupidCraft.CupidCraft;
import Forms.PetForm;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class pet extends Command{

	private CupidCraft plugin;

	public pet(String name, CupidCraft plugin) {
		super("petwdadawsdawaedw");
		this.setPermission("saeeadawdsada");
		this.plugin = plugin;
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		Player player = ((Player) arg0).getPlayer();
		if(player instanceof Player) {
			PetForm form = new PetForm(plugin);
			form.Pet(player);
		}
		return false;
	}


}

