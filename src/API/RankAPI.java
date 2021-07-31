package API;

import CupidCraft.CupidCraft;
import cn.nukkit.utils.Config;


public class RankAPI {
	private CupidCraft plugin;

    public RankAPI(CupidCraft plugin) {
        this.plugin = plugin;
    }

    public void CreateData(String p) {
        Config data = new Config(plugin.getDataFolder() + "/ranks.yml", Config.YAML);
        Config gender = new Config(plugin.getDataFolder() + "/genders.yml", Config.YAML);
        Config suffix = new Config(plugin.getDataFolder() + "/suffixs.yml", Config.YAML);
        if (!data.exists("Players.Rank."+ p)) {
            data.set("Players.Rank." + p, "Newbie");
            data.save();
        }
        if (!gender.exists("Players.Gender."+ p)) {
        	gender.set("Players.Gender." + p, "null");
        	gender.save();
        }
        if (!suffix.exists("Players.Suffix."+ p)) {
        	suffix.set("Players.Suffix." + p, "null");
        	suffix.save();
        }
    }
    public void setRank(String p, String rank) {
        Config data = new Config(plugin.getDataFolder() + "/ranks.yml", Config.YAML);
        data.set("Players." + p, rank);
        data.save();
    }
    public void removeRank(String p, String rank) {
        Config data = new Config(plugin.getDataFolder() + "/ranks.yml", Config.YAML);
        data.set("Players." + p, "Newbie");
        data.save();
    }
    public String myRank(String p) {
        Config data = new Config(plugin.getDataFolder() + "/ranks.yml", Config.YAML);
        return data.getString("Players." + p);
    }
    
    //Gender
    public void setGender(String p, String gender) {
        Config data = new Config(plugin.getDataFolder() + "/genders.yml", Config.YAML);
        data.set("Players." + p, gender);
        data.save();
    }
    public void removeGender(String p, String gender) {
        Config data = new Config(plugin.getDataFolder() + "/genders.yml", Config.YAML);
        data.set("Players." + p, "null");
        data.save();
    }
    public String myGender(String p) {
        Config data = new Config(plugin.getDataFolder() + "/genders.yml", Config.YAML);
        return data.getString("Players." + p);
    }
    
    //Suffix
    public void setSuffix(String p, String suffix) {
        Config data = new Config(plugin.getDataFolder() + "/suffixs.yml", Config.YAML);
        data.set("Players." + p, suffix);
        data.save();
    }
    public void removeSuffix(String p, String suffix) {
        Config data = new Config(plugin.getDataFolder() + "/suffixs.yml", Config.YAML);
        data.set("Players." + p, "null");
        data.save();
    }
    public String mySuffix(String p) {
        Config data = new Config(plugin.getDataFolder() + "/suffixs.yml", Config.YAML);
        return data.getString("Players." + p);
    }

}
