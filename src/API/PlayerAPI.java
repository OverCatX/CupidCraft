package API;

import CupidCraft.CupidCraft;
import cn.nukkit.utils.Config;

public class PlayerAPI {
	
	private CupidCraft plugin;

    public PlayerAPI(CupidCraft plugin) {
        this.plugin = plugin;
    }
	
	public void CreateAccount(String p) {
        Config data = new Config(plugin.getDataFolder() + "/playerdata.yml", Config.YAML);
        if (!data.exists(p)) {
            data.set(p+".Facebook", "");
            data.set(p+".Line", "");
            data.set(p+".Instagram", "");
            data.set(p+".Youtube", "");
            data.save();
        }
    }
	public void setFacebook(String p, String facebook) {
		Config data = new Config(plugin.getDataFolder() + "/playerdata.yml", Config.YAML);
		data.set(p+".Facebook", facebook);
        data.save();
    }
	public void setLine(String p, String line) {
		Config data = new Config(plugin.getDataFolder() + "/playerdata.yml", Config.YAML);
		data.set(p+".Line", line);
        data.save();
    }
	public void setInstagram(String p, String instagram) {
		Config data = new Config(plugin.getDataFolder() + "/playerdata.yml", Config.YAML);
		data.set(p+".Instagram", instagram);
        data.save();
    }
	public void setYoutube(String p, String youtube) {
		Config data = new Config(plugin.getDataFolder() + "/playerdata.yml", Config.YAML);
		data.set(p+".Youtube", youtube);
        data.save();
    }
	public String MyFacebook(String p) {
		Config data = new Config(plugin.getDataFolder() + "/playerdata.yml", Config.YAML);
		return data.getString(p+".Facebook");
	}
	public String MyLine(String p) {
		Config data = new Config(plugin.getDataFolder() + "/playerdata.yml", Config.YAML);
		return data.getString(p+".Line");
	}
	public String MyInstagram(String p) {
		Config data = new Config(plugin.getDataFolder() + "/playerdata.yml", Config.YAML);
		return data.getString(p+".Instagram");
	}
	public String MyYoutube(String p) {
		Config data = new Config(plugin.getDataFolder() + "/playerdata.yml", Config.YAML);
		return data.getString(p+".Youtube");
	}
}
