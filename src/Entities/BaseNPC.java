package Entities;

import API.NpcAPI;
import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public abstract class BaseNPC extends Entity{
	
	private CupidCraft plugin;

	public BaseNPC(FullChunk chunk, CompoundTag nbt, CupidCraft plugin) {
		super(chunk, nbt);
		this.plugin = plugin;
		
	}
	protected void initEntity() {
        super.initEntity();
    }
	
	public boolean attack(EntityDamageEvent source) {
        if (source instanceof EntityDamageByEntityEvent) {
            Entity entity = source.getEntity();
            NpcAPI npc = new NpcAPI(plugin);
            Entity damage = ((EntityDamageByEntityEvent)source).getDamager();
            if (damage instanceof Player && entity instanceof BaseNPC && ((Player) damage).isOp()) {
                Player player = (Player)damage;
                if(player.isSneaking()) {
                	player.sendMessage("Npc said: "+entity.getNameTag());
                	System.out.print(entity.getNameTag());
                	source.setCancelled();
                }
                Server.getInstance().dispatchCommand(player, npc.getCommand(entity.getNameTag()));
                source.setCancelled();
            }
        }

        return super.attack(source);
    }
	

}
