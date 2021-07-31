package Forms;

import API.PlayerAPI;
import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.window.FormWindowCustom;

public class playerdataForm implements Listener{
	
	private CupidCraft plugin;
	private static int Data_Form = 0x000001;
	
	public playerdataForm(CupidCraft plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void response(PlayerFormRespondedEvent event) {
		if (event.wasClosed()) return;
        Player player = event.getPlayer();
        PlayerAPI playerapi = new PlayerAPI(plugin);
        if (event.getWindow() instanceof FormWindowCustom) {
            String facebook = ((FormWindowCustom) event.getWindow()).getResponse().getInputResponse(1);
            String line = ((FormWindowCustom) event.getWindow()).getResponse().getInputResponse(2);
            String instagram = ((FormWindowCustom) event.getWindow()).getResponse().getInputResponse(3);
            String youtube = ((FormWindowCustom) event.getWindow()).getResponse().getInputResponse(4);
            if(event.getFormID() == Data_Form) {
            	playerapi.setFacebook(player.getName(), facebook);
            	playerapi.setLine(player.getName(), line);
            	playerapi.setFacebook(player.getName(), instagram);
            	playerapi.setFacebook(player.getName(), youtube);
            	player.sendMessage(" §aS§ey§bs§dt§3e§5m §f: §7ระบบกำลังบันทึกข้อมูล....");
            	player.sendMessage(" §aS§ey§bs§dt§3e§5m §f: §7ระบบบันทึกข้อมูลสำเร็จแล้ว");
            	return;
            }
        }
            
	}
	
	public void PlayerData(Player player) {
		FormWindowCustom form = new FormWindowCustom("PlayerData");
		form.addElement(new ElementLabel("ตั้งค่าโปรไฟล์ของท่าน"));
		ElementInput input = new ElementInput("⨫ Facebook [ไม่จำเป็น]");
		ElementInput input1 = new ElementInput("Line [ไม่จำเป็น]");
		ElementInput input2 = new ElementInput("Instagram [ไม่จำเป็น]");
		ElementInput input3 = new ElementInput("⨬ Youtube [ไม่จำเป็น]");
		form.addElement(input);
		form.addElement(input1);
		form.addElement(input2);
		form.addElement(input3);
		player.showFormWindow(form,Data_Form);
	}

}
