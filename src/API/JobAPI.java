package API;

import CupidCraft.CupidCraft;
import cn.nukkit.utils.Config;

public class JobAPI {
	
	private CupidCraft plugin;

    public JobAPI(CupidCraft plugin) {
        this.plugin = plugin;
    }
	
	public void CreateData(String p) {
        Config data = new Config(plugin.getDataFolder() + "/jobs.yml", Config.YAML);
        Config wood = new Config(plugin.getDataFolder() + "/woods.yml", Config.YAML);
        Config baker = new Config(plugin.getDataFolder() + "/baker.yml", Config.YAML);
        Config fisher = new Config(plugin.getDataFolder() + "/fisher.yml", Config.YAML);
        Config bitcoin = new Config(plugin.getDataFolder() + "/bitcoin.yml", Config.YAML);
        if (!data.exists(p)) {
            data.set(p+".Job", "ว่างงาน");
            data.set(p+".Level", 0);
            data.set(p+".Exp", 0);
            data.set(p+".MaxExp", 1000);
            data.set(p+".Date", 0);
            data.set(p+".Time", 0);
            data.set(p+".Earns", 0);
            data.save();
        }
        if (!wood.exists(p)) {
            data.set(p+".Tree", 0);
            data.save();
        }
        if (!baker.exists(p)) {
            data.set(p+".Made", 0);
            data.save();
        }
        if (!fisher.exists(p)) {
            data.set(p+".Got", 0);
            data.save();
        }
        if (!bitcoin.exists(p)) {
            data.set(p+".Coins", 0);
            data.save();
        }
    }
	
	public void SetJob(String p, String job,String date, String time) {
		Config data = new Config(plugin.getDataFolder() + "/jobs.yml", Config.YAML);
        data.set(p+".Job", job);
        data.set(p+".Date", date);
        data.set(p+".Time", time);
        data.save();
	}
	
	public void QuitJob(String p, String job) {
		Config data = new Config(plugin.getDataFolder() + "/jobs.yml", Config.YAML);
        data.set(p+".Job", "ว่างงาน");
        data.save();
	}
	public String getJob(String p) {
		Config data = new Config(plugin.getDataFolder() + "/jobs.yml", Config.YAML);
        return data.getString(p+".Job");
	}
	public String getLevel(String p) {
		Config data = new Config(plugin.getDataFolder() + "/jobs.yml", Config.YAML);
        return data.getString(p+".Level");
	}
	public String getEarns(String  job) {
		Config data = new Config(plugin.getDataFolder() + "/jobs.yml", Config.YAML);
		String earns = "";
		if(job.equals("คนงานเหมือง")) {
			earns = "100-500/วัน";
		} else {
			if(job.equals("คนทำขนมปัง,เค้ก")) {
				earns = "50-300/วัน";
			} else {
				if(job.equals("นักตกปลา")) {
					earns = "70-450บาท/วัน";
				} else {
					if(job.equals("นักขุดบิทคอย")) {
						earns = "450-10000บาท/วัน";
					}
				}
			}
		}
        return earns;
	}
	public String getExp(String p) {
		Config data = new Config(plugin.getDataFolder() + "/jobs.yml", Config.YAML);
        return data.getString(p+".Exp");
	}
	public String getDate(String p) {
		Config data = new Config(plugin.getDataFolder() + "/jobs.yml", Config.YAML);
        return data.getString(p+".Date");
	}

}
