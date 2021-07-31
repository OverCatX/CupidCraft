package Entities.EntityLists;

import Entities.BaseEntity;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.entity.passive.EntityBee;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.tag.CompoundTag;

public class BeeEntity extends BaseEntity{

	public BeeEntity(FullChunk chunk, CompoundTag nbt) {
		super(chunk, nbt);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public int getNetworkId() {
        return EntityBee.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .7f;
    }

    @Override
    public float getHeight() {
        return .6f;
    }

    @Override
    public void walkTo(Vector3 flower) {
        if (this.isClosed()) {
            return;
        }

        if (this.isImmobile()) {
            this.setImmobile(false);
        }
        final double diffX = flower.getX() - this.getX();
        final double diffZ = flower.getZ() - this.getZ();
        final double diffY = flower.getY() - this.getY();
        final double diff = Math.abs(diffX) + Math.abs(diffZ) + Math.abs(diffY);

        final boolean isJumping = this.isJumping();
        final boolean isFalling = !isJumping && !this.isGrounded();

        this.motionX = 0.0f;
        this.motionZ = 0.0f;

        if (!isFalling) {
            this.motionY = isJumping ? this.motionY : 0;
        } else {
            this.motionY = this.motionY > .01 ? 0 : this.motionY - .32;
        }

        if (!isGrounded() && this.following.getY() + 1 > this.getY()) {
            this.motionY = .32;
        }

        if (diff > 5) {
            if (diff > 40) this.teleport(following.getLocation());
            this.motionX = this.movementSpeed * 0.5 * (diffX / diff);
            this.motionZ = this.movementSpeed * 0.5 * (diffZ / diff);
        }

        this.lookAt(flower);
        this.move(this.motionX, this.motionY, this.motionZ);
        this.updateMovement();
    }

    private boolean isGrounded() {
        Block below = this.getLevel().getBlock(this.getFloorX(), this.getFloorY() - 1, this.getFloorZ());
        Block below2 = this.getLevel().getBlock(this.getFloorX(), this.getFloorY() - 2, this.getFloorZ());
        return below.getId() == BlockID.AIR && below2.getId() != BlockID.AIR;
    }

}
