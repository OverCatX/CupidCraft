package API;

import CupidCraft.CupidCraft;
import cn.nukkit.utils.Config;

public class NpcAPI {

	private CupidCraft plugin;

    public NpcAPI(CupidCraft plugin) {
        this.plugin = plugin;
    }
	
	public void CreateNpc(String npc,String command, int x,int y, int z,String level,String name) {
        Config data = new Config(plugin.getDataFolder() + "/"+name+".yml", Config.YAML);
        if (!data.exists("Npc.")) {
            data.set("Npc.Command", command);
            data.set("Npc.x", x);
            data.set("Npc.y", y);
            data.set("Npc.z", z);
            data.set("Npc.level", level);
            data.set("Npc.Id", npc);
            data.save();
        }
    }
	public void setCommand(String name,String command) {
		Config data = new Config(plugin.getDataFolder() + "/"+name+".yml", Config.YAML);
		data.set("Npc.Command", command);
		data.save();
    }
	public void removeCommand(String name) {
		Config data = new Config(plugin.getDataFolder() + "/"+name+".yml", Config.YAML);
		data.set("Npc.Command", "");
		data.save();
    }
	public String getCommand(String name) {
		Config data = new Config(plugin.getDataFolder() + "/"+name+".yml", Config.YAML);
		return data.getString("Npc.Command");
    }
}
