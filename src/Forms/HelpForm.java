package Forms;

import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.event.Listener;
import cn.nukkit.form.window.FormWindowSimple;

public class HelpForm implements Listener{
	
	private CupidCraft plugin;
	private static int HelpForm = 0x0002321;
	
	public HelpForm(CupidCraft plugin) {
		this.plugin = plugin;
	}
	public void Help(Player player) {   
		FormWindowSimple form = new FormWindowSimple("Help","");
		player.showFormWindow(form);
	}
}
	
