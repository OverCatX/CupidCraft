package Forms;

import cn.nukkit.Player;
import cn.nukkit.event.Listener;
import cn.nukkit.form.window.FormWindowSimple;

public class joinForm implements Listener{
	
	public void JoinForm(Player player) {
		FormWindowSimple form = new FormWindowSimple("Welcome","");
		player.showFormWindow(form);
	}

}
  