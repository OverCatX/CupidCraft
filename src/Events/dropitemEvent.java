package Events;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.item.EntityItem;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.ItemSpawnEvent;
import cn.nukkit.item.Item;

public class dropitemEvent implements Listener{
	
	@EventHandler
	public void DropItem(ItemSpawnEvent event) {
		Entity entity = event.getEntity();
		Item item = ((EntityItem) entity).getItem();
		String itemname = item.getName();
		entity.setNameTag("§7"+itemname+" §5x§b"+item.getCount());
		entity.setNameTagVisible(true);
		entity.setNameTagAlwaysVisible(true);
	}

}
