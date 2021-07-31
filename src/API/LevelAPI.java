package API;

import CupidCraft.CupidCraft;
import cn.nukkit.utils.Config;

public class LevelAPI {
	
	private CupidCraft plugin;

    public LevelAPI(CupidCraft plugin) {
        this.plugin = plugin;
    }
	
	public void CreateData(String p) {
        Config data = new Config(plugin.getDataFolder() + "/levels.yml", Config.YAML);
        if (!data.exists(p+".Level")) {
            data.set(p+".Level", 1);
            data.set(p+".Experience", 0);
            data.set(p+".MaxExp", 100);
            data.save();
        }
    }
	public void addExp(String p, int exp) {
		Config data = new Config(plugin.getDataFolder() + "/levels.yml", Config.YAML);
        data.set(p+".Experience", data.getInt(p+".Experience") + exp);
        if(data.getInt(p+".Experience") >= data.getInt(p+".MaxExp") * 3) {
        	data.set(p+".Level", data.getInt(p+".Level") + 1);
        	data.save();
        }
       
    }
	public int myLevel(String p) {
        Config data = new Config(plugin.getDataFolder() + "/levels.yml", Config.YAML);
        return data.getInt(p+".Level");
    }


}
