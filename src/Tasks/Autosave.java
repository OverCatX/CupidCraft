package Tasks;

import CupidCraft.CupidCraft;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.scheduler.PluginTask;

public class Autosave extends PluginTask<CupidCraft>{
	
	public Autosave(CupidCraft owner) {
		super(owner);
	}

	@Override
	public void onRun(int i) {
		owner.getServer().getCommandMap().dispatch(new ConsoleCommandSender(), "save-all");
		owner.getServer().broadcastMessage("§aร§eะ§3บ§4บ §7กำลังเซฟ§c...");
		owner.getServer().broadcastMessage("§aร§eะ§3บ§4บ §7ได้ทำการเซฟสำเร็จ§b!");
	}	
}
