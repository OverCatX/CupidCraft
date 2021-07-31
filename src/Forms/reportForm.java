package Forms;

import API.LineAPI;
import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementDropdown;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;

public class reportForm implements Listener{
	
	private CupidCraft plugin;
	private static int Report_Form = 0x000002;
	private static String token = "6CCSz7EiLxBoL0jKFmORYw3WBaZnZYNB3dX3NiFdJQ6";
	
	public reportForm(CupidCraft plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
    public void Response(PlayerFormRespondedEvent event) {
        if (event.wasClosed()) return;
        Player player = event.getPlayer();
        LineAPI line = new LineAPI();
        if (event.getWindow() instanceof FormWindowCustom) {
            int drop = ((FormWindowCustom) event.getWindow()).getResponse().getDropdownResponse(1).getElementID();
            String report = ((FormWindowCustom) event.getWindow()).getResponse().getInputResponse(2);
            if(event.getFormID() == Report_Form) {
            	if(drop == 0) {
            		Reported(player,"หยาบคาย,ด่าผู้เล่นอื่นหรือแอดมิน",report);
            		line.callEvent(token,"\nรายงาน:หยาบคาย\nข้อความ: "+report);
            	}
            	if(drop == 1) {
            		Reported(player,"เกรียน,โปร",report);
            		line.callEvent(token,"\nรายงาน:เกรียน,โปร\nข้อความ: "+report);
            	}
            	if(drop == 2) {
            		Reported(player,"โปรโมทเซิฟเวอร์อื่นๆ",report);
            		line.callEvent(token,"\nรายงาน:โปรโมทเซิฟเวอร์อื่นๆ\nข้อความ: "+report);
            	}
            }
        }
    }
	
	public void Report(Player player) {
		FormWindowCustom form = new FormWindowCustom("Report");
		form.addElement(new ElementLabel("รายงาน,ส่งข้อความถึงแอดมิน"));
		ElementDropdown drop = new ElementDropdown("ประเภทการรายงาน");
		drop.addOption("หยาบคาย,ด่าผู้เล่นอื่นหรือแอดมิน");
		drop.addOption("เกรียน,โปร");
		drop.addOption("โปรโมทเซิฟเวอร์อื่นๆ");
		ElementInput input = new ElementInput("ข้อความ");
		form.addElement(drop);
		form.addElement(input);
		player.showFormWindow(form,Report_Form);
	}
	public void Reported(Player player,String type,String message) {
		FormWindowSimple form = new FormWindowSimple("Reported", "คุณได้รายงานสำเร็จ\nรายงานประเภท: "+type+
				"\nข้อความ: "+message);
		player.showFormWindow(form);
	}

}
