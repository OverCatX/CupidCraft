package Pets.Entities;

import API.PetAPI;
import Math.RandomId;
import Pets.PetEntity;
import cn.nukkit.Player;
import cn.nukkit.entity.passive.EntityOcelot;
import cn.nukkit.item.Item;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.level.particle.HappyVillagerParticle;
import cn.nukkit.nbt.tag.CompoundTag;


public class CatPet extends PetEntity{

	public CatPet(FullChunk chunk, CompoundTag nbt) {
		super(chunk, nbt);
		this.movementSpeed = 2.0f;
	}
	public int getNetworkId() {
        return EntityOcelot.NETWORK_ID;
    }
 
    @Override
    public float getLength() {
        return 1.825F;
    }

    @Override
    public float getWidth() {
        return 1.125F;
    }

    @Override
    public float getHeight() {
        return 1.25F;
    }
    
    @Override
    public boolean onInteract(Player player, Item item) {
        switch (player.getInventory().getItemInHand().getId()) {
            case Item.RAW_FISH:
            case Item.RAW_SALMON:
            case Item.CLOWNFISH:
                player.getInventory().decreaseCount(player.getInventory().getHeldItemIndex());
                this.level.addParticle(new HappyVillagerParticle(
                        this.add(RandomId.rand(-0.5, 0.5), RandomId.rand(-0.3, 0.6), RandomId.rand(-0.5, 0.5))));
                player.addExperience(1);
                PetAPI.addExp(player.getName(), this.getNameTag(), RandomId.rand(1.5, 5.0));
                return true;
            default:
                return super.onInteract(player, item);
        }
    }


}
