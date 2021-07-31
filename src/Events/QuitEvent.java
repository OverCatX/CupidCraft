package Events;

import API.PetAPI;
import CupidCraft.CupidCraft;
import Pets.PetEntity;
import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.level.Level;

public class QuitEvent implements Listener{
	
private CupidCraft plugin;
	
	public QuitEvent(CupidCraft plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		PetAPI api = new PetAPI(plugin);
		if(!api.getProcessName(player.getName()).equals("")) {
			for (Level level : plugin.getServer().getLevels().values()) {
                for (Entity entity : level.getEntities()) {
                	if (entity instanceof PetEntity) {
                		String nametag = entity.getNameTag();
                        if (nametag.equals("§c[§fสัตว์เลี้ยง§c] §d"+player.getName())) {
                        	entity.close();
                        	System.out.println("Saved Pet");            
                        }
                	}
                }
			}
		}
	}
}
