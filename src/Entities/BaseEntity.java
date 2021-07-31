package Entities;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockFence;
import cn.nukkit.block.BlockFenceGate;
import cn.nukkit.block.BlockSlab;
import cn.nukkit.block.BlockStairs;
import cn.nukkit.entity.EntityCreature;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.math.NukkitMath;
import cn.nukkit.math.Vector2;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.scheduler.Task;

public abstract class BaseEntity extends EntityCreature {

	public Block following;
    public int distance;

    public BaseEntity(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setNameTagVisible(true);
        this.setDataFlag(DATA_FLAGS, DATA_FLAG_TAMED, true);
        this.movementSpeed = 1.0f;
        this.distance = 4;
    }

    @Override
    public int getNetworkId() {
        return 0;
    }

    public void follow(final Block flower) {
        this.following = flower;
        Server.getInstance().getScheduler().scheduleDelayedRepeatingTask(new Task() {
            @Override
            public void onRun(int i) {
                if (following == null || isClosed()) {
                    this.getHandler().cancel();
                    return;
                }
                walkTo(following);
            }
        }, 1, 3);
    }

    public void walkTo(final Vector3 flower) {
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
        final boolean isFalling = !isJumping && !this.onGround;

        this.motionX = 0.0f;
        this.motionZ = 0.0f;

        if (!isFalling) {
            this.motionY = isJumping ? this.motionY : 0;
        } else {
            this.motionY = this.motionY > .01 ? 0 : this.motionY - .32;
        }

        if (diff > this.distance) {
            if (diff > 20) this.teleport(following.getLocation());
            this.motionX = this.movementSpeed * 0.5 * (diffX / diff);
            this.motionZ = this.movementSpeed * 0.5 * (diffZ / diff);
        }

        this.lookAt(flower);
        this.move(this.motionX, this.motionY, this.motionZ);
        this.updateMovement();
    }

    public void lookAt(final Vector3 flower) {
        final double diffX = flower.getX() - this.getX();
        final double diffZ = flower.getZ() - this.getZ();
        final double diffY = flower.getY() - this.getY();

        double angle = Math.atan2(diffZ, diffX);

        final double yaw = ((angle * 180) / Math.PI) - 90;

        final Vector2 vector2 = new Vector2(this.getX(), this.getZ());
        final double distance = vector2.distance(flower.getX(), flower.getZ());

        angle = Math.atan2(distance, diffY);

        final double pitch = ((angle * 180) / Math.PI) - 90;

        this.setRotation(yaw, pitch);
    }

    public boolean isJumping() {
        if (this.onGround) return false;

        double dx = this.motionX;
        double dz = this.motionZ;

        Block that = this.getLevel().getBlock(new Vector3(NukkitMath.floorDouble(this.x + dx), (int) this.y, NukkitMath.floorDouble(this.z + dz)));
        if (this.getDirection() == null) {
            return false;
        }

        Block block = that.getSide(this.getHorizontalFacing());
        if (!block.canPassThrough() && block.up().canPassThrough() && that.up(2).canPassThrough()) {
            if (block instanceof BlockFence || block instanceof BlockFenceGate) {
                this.motionY = 0.08;
            } else if (this.motionY <= 0.32) {
                this.motionY = 0.32;
            } else if (block instanceof BlockSlab || block instanceof BlockStairs) {
                this.motionY = 0.32;
            } else if (this.motionY <= (0.64)) {
                this.motionY = 0.64;
            } else {
                this.motionY += 0.02;
            }
            return true;
        }
        return false;
    }
}
