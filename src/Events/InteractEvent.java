package Events;

import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;

public class InteractEvent implements Listener{
	
	private CupidCraft plugin;
	
	public InteractEvent(CupidCraft plugin) {
		this.plugin = plugin;
	}
	
	public void Interact(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Item item = event.getItem();
		item.setCustomName("§aB§co§eo§dk\n§7หนังสือช่วยเหลือ");
		if(player.getInventory().getItemInHand().equals(item)) {
			
		}
	}

}
