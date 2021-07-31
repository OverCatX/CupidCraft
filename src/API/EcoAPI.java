package API;

import CupidCraft.CupidCraft;
import cn.nukkit.utils.Config;

public class EcoAPI {
	
	private CupidCraft plugin;

    public EcoAPI(CupidCraft plugin) {
        this.plugin = plugin;
    }
	
	public void CreateAccount(String p) {
        Config data = new Config(plugin.getDataFolder()+ "/eco.yml", Config.YAML);
        if (!data.exists("Player."+p)) {
            data.set("Player."+p, 0);
            data.save();
        }
    }
	public void addMoney(String p, double eco) {
        Config data = new Config(plugin.getDataFolder() + "/eco.yml", Config.YAML);
        data.set("Player."+p, data.getInt("Player."+p) + eco);
        data.save();
    }
	public void reduceMoney(String p, double eco) {
        Config data = new Config(plugin.getDataFolder() + "/eco.yml", Config.YAML);
        data.set("Player."+p, data.getInt("Player."+p) - eco);
        data.save();
    }
	public int myMoney(String p) {
        Config data = new Config(plugin.getDataFolder() + "/eco.yml", Config.YAML);
        return data.getInt("Player."+p);
    }


}
