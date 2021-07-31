package Monster;

import cn.nukkit.entity.Entity;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class MonsterEntity extends Entity{

	public MonsterEntity(FullChunk chunk, CompoundTag nbt) {
		super(chunk, nbt);
		this.setNameTagAlwaysVisible();
	}

	@Override
	public int getNetworkId() {
		return 0;
	}

}
