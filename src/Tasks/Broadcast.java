package Tasks;

import CupidCraft.CupidCraft;
import cn.nukkit.scheduler.PluginTask;

public class Broadcast extends PluginTask<CupidCraft>{

	public Broadcast(CupidCraft owner) {
		super(owner);
	}

	@Override
	public void onRun(int i) {
		owner.getServer().broadcastMessage(" §6เซิฟเวอร์นี้§eเป็น§aเซิฟ§cเวอร์§3แนว §5Sky§2Block§6MMORPG §fนะ§dครับ §aขอให้สนุก§5ในการ§3เล่นครับ");
	}

}
