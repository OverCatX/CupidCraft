package Forms;

import API.NpcAPI;
import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;

public class npcAdminForm implements Listener{
	
	private CupidCraft plugin;
	
	public npcAdminForm(CupidCraft plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
    public void ResponseNpc(PlayerFormRespondedEvent event) {
        if (event.wasClosed()) return;
        Player player = event.getPlayer();
        NpcAPI npc = new NpcAPI(plugin);
        if (event.getWindow() instanceof FormWindowSimple) {
            String title = ((FormWindowSimple) event.getWindow()).getTitle();
            int button = ((FormWindowSimple) event.getWindow()).getResponse().getClickedButtonId();
            if(title.equals("Npc")){
                if(button == 0){
                    npc.setCommand(title, title);
                }
                if(button == 1){
                    
                }
            }
        }
    }
	
	public void NpcForm(Player player) {
		FormWindowSimple form = new FormWindowSimple("Npc","");
		form.addButton(new ElementButton("SetCommand"));
		form.addButton(new ElementButton("RemoveCommand"));
		form.addButton(new ElementButton("Remove NPC"));
		player.showFormWindow(form);
	}

}
