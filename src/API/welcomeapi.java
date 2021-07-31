package API;

import CupidCraft.CupidCraft;
import cn.nukkit.utils.Config;

public class welcomeapi {
	
	private CupidCraft plugin;

    public welcomeapi(CupidCraft plugin) {
        this.plugin = plugin;
    }
	
	public void CreateData() {
        Config data = new Config(plugin.getDataFolder() + "/welcome.yml", Config.YAML);
        if (!data.exists("Message.")) {
            data.set("Message.welcome", "");
            data.save();
        }
    }
	public void setMessage(String message) {
        Config data = new Config(plugin.getDataFolder() + "/welcome.yml", Config.YAML);
        if (!data.exists("Message.")) {
            data.set("Message.welcome", message);
            data.save();
        }
    }

}
