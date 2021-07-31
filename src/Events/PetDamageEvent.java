package Events;

import API.PetAPI;
import CupidCraft.CupidCraft;
import Forms.PetForm;
import Pets.PetEntity;
import cn.nukkit.Player;
import cn.nukkit.entity.passive.EntityHorse;
import cn.nukkit.entity.passive.EntityOcelot;
import cn.nukkit.entity.passive.EntityPanda;
import cn.nukkit.entity.passive.EntityPolarBear;
import cn.nukkit.entity.passive.EntityWolf;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.utils.Config;

public class PetDamageEvent implements Listener{
	private CupidCraft plugin;
	
	public PetDamageEvent(CupidCraft plugin) {
		this.plugin = plugin;
	}
	
	private static int wolf = EntityWolf.NETWORK_ID;
	private static int ocelot = EntityOcelot.NETWORK_ID;
	private static int panda = EntityPanda.NETWORK_ID;
	private static int horse = EntityHorse.NETWORK_ID;
	private static int polarbear = EntityPolarBear.NETWORK_ID;
	
	@EventHandler
	public void DamagePet(EntityDamageByEntityEvent event){         
		Player damager = (Player) event.getDamager();
		PetAPI api = new PetAPI(plugin);
		PetForm form = new PetForm(plugin);
		if(event.getEntity() instanceof PetEntity) {
			if(event.getDamager() instanceof Player) {
				String petTag = event.getEntity().getNameTag();
				Config data = new Config(plugin.getDataFolder() + "/pets/"+damager.getName()+".yml", Config.YAML);
			    if (petTag.equals("§c[§fสัตว์เลี้ยง§c] §d"+damager.getName())) {
			    	if(event.getEntity().getNetworkId() == wolf) {
			    		String pet = PetAPI.Type.DOG_PET;
			    		form.Petme(damager, pet, 
				    			api.getFeed(pet), 
				    			api.getPrice(pet), 
				    			api.getLevel(damager.getName(),pet), 
				    			api.getExp(damager.getName(), pet), 
				    			api.getMaxExp(damager.getName(), pet));
			    		event.setCancelled();
			    		return;
			    	}
			    	if(event.getEntity().getNetworkId() == ocelot) {
			    		String pet = PetAPI.Type.CAT_PET;
			    		form.Petme(damager, pet, 
			    				api.getFeed(pet), 
			    				api.getPrice(pet), 
			    				api.getLevel(damager.getName(),pet), 
			    				api.getExp(damager.getName(), pet), 
			    				api.getMaxExp(damager.getName(), pet));
			    		event.setCancelled();
			    		return;
			    	}
			    	if(event.getEntity().getNetworkId() == panda) {
			    		String pet = PetAPI.Type.PANDA_PET;
			    		form.Petme(damager, pet, 
				    			api.getFeed(pet), 
				    			api.getPrice(pet), 
				    			api.getLevel(damager.getName(),pet), 
				    			api.getExp(damager.getName(), pet), 
				    			api.getMaxExp(damager.getName(), pet));
			    		event.setCancelled();
			    		return;
			    	}
			    	if(event.getEntity().getNetworkId() == horse) {
			    		String pet = PetAPI.Type.HORSE_PET;
			    		form.Petme(damager, pet, 
			    				api.getFeed(pet), 
			    				api.getPrice(pet), 
			    				api.getLevel(damager.getName(),pet), 
			    				api.getExp(damager.getName(), pet), 
			    				api.getMaxExp(damager.getName(), pet));
			    		event.setCancelled();
			    		return;
			    	}
			    	if(event.getEntity().getNetworkId() == polarbear) {
			    		String pet = PetAPI.Type.POLARBEAR_PET;
			    		form.Petme(damager, pet, 
			    				api.getFeed(pet), 
			    				api.getPrice(pet), 
			    				api.getLevel(damager.getName(),pet), 
			    				api.getExp(damager.getName(), pet), 
			    				api.getMaxExp(damager.getName(), pet));
			    		event.setCancelled();
			    		return;
			    	}
			    } else {
			    	event.setCancelled();
			    }
			}
		}
	}

}