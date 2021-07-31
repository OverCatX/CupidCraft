package Forms;

import java.text.SimpleDateFormat;
import java.util.Date;

import API.JobAPI;
import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;

public class jobForm implements Listener{
	
	private CupidCraft plugin;
	private static int Job_EMPTY = 0x000320;
	private static int Job = 0x000321;
	
	public jobForm(CupidCraft plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
    public void ResponseJob(PlayerFormRespondedEvent event) {
        if (event.wasClosed()) return;
        Player player = event.getPlayer();
        JobAPI job = new JobAPI(plugin);
        String datee = "วันที่ MM เดือน dd ปี yyyy";
        String time = "HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datee);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(time);
        String date = simpleDateFormat.format(new Date());
        String times = simpleDateFormat1.format(new Date());
        if (event.getWindow() instanceof FormWindowSimple) {
            int button = ((FormWindowSimple) event.getWindow()).getResponse().getClickedButtonId();
            if(event.getFormID() == Job_EMPTY){
                if(button == 0){
                    job.SetJob(player.getName(), "คนงานเหมือง", date, times);
                    JobDone(player,"คนงานเหมือง",date,times);
                }
                if(button == 1){
                	job.SetJob(player.getName(), "คนทำขนมปัง,เค้ก", date, times);
                    JobDone(player,"คนทำขนมปัง,เค้ก",date,times);
                }
                if(button == 2){
                	job.SetJob(player.getName(), "นักตกปลา", date, times);
                    JobDone(player,"นักตกปลา",date,times);
                }
                if(button == 3){
                	job.SetJob(player.getName(), "นักขุดบิทคอย", date, times);
                    JobDone(player,"นักขุดบิทคอย",date,times);
                }
            }
        }
    }
	
	public void Job(Player player) {
		String message = "";
		JobAPI job = new JobAPI(plugin);
		if(job.getJob(player.getName()).equals("ว่างงาน")) {
			message = "คุณยังไม่มีอาชีพ ตอนนี้คุณสามารถเลือกอาชีพได้เลยย";
			FormWindowSimple form = new FormWindowSimple("Job",message);
			form.addButton(new ElementButton("Miner\nคนงานเหมือง"));
			form.addButton(new ElementButton("Baker\nคนทำขนมปัง,เค้ก"));
			form.addButton(new ElementButton("Fisherman\nนักตกปลา"));
			form.addButton(new ElementButton("Bitcoin\nนักขุดบิทคอย"));
			player.showFormWindow(form, Job_EMPTY);
		} else {
			message = "อาชีพของท่าน: "+job.getJob(player.getName())+
					"\nเลเวลอาชีพของท่าน: "+job.getLevel(player.getName())+
					"\nค่าประสบการณ์อาชีพ: "+job.getExp(player.getName())+
					"\nวันที่สมัครอาชีพนี้: "+job.getDate(player.getName()+
							"\n\nรายได้ต่อวัน: "+job.getEarns(job.getJob(player.getName())));
			FormWindowSimple form = new FormWindowSimple("Job",message);
			form.addButton(new ElementButton("Claim\nรับเงินรายวัน"));
			player.showFormWindow(form, Job);
		}
	}

	public void JobDone(Player player,String job,String date,String time) {
		FormWindowSimple form = new FormWindowSimple("ใบยืนยันอาชีพ","คุณได้สมัครอาชีพ: "+job+
				"\nวันที่: "+date+
				"\nเวลา"+time);
		player.showFormWindow(form);
	}
}
