package API;

import java.util.ArrayList;
import java.util.List;

import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.utils.Config;

public class SkyBlockAPI {
	
	private CupidCraft plugin;

    public SkyBlockAPI(CupidCraft plugin) {
        this.plugin = plugin;
    }
	
	public void CreateIsland(String p,String island) {
		ArrayList<String> members = new ArrayList<>();
        Config data = new Config(plugin.getDataFolder() + "/SkyBlock/skyblocks.yml", Config.YAML);
        Config data1 = new Config(plugin.getDataFolder() + "/SkyBlock/players.yml", Config.YAML);
        if(!data1.exists(p)) {
        	data1.set(p, "");
            data1.save();
        }
        if (!data.exists(island)) {
            data.set(island+".Owner", p);
            data.set(island+".Members", members);
            data.set(island+".AmountMembers", 1);
            data.set(island+".MaxMembers", 5);
            data.set(island+".AmountIsland", 1);
            data.set(island+".Level", 1);
            data.save();
            
        }
	}
	public void addMembers(Player player,String target,String island) {
        Config data = new Config(plugin.getDataFolder() + "/SkyBlock/skyblocks.yml", Config.YAML);
        Config data1 = new Config(plugin.getDataFolder() + "/SkyBlock/players.yml", Config.YAML);
        List<String> members =  data.getStringList(island+".Members");
        members.add(target);
        //Map<String,String> m = new HashMap<String,String>();
        //m.put("members", members.toString());
        if(data.getInt(island+".AmountMembers") >= data.getInt(island+".MaxMembers")) {
        	player.sendMessage("");
        	return;
        }
        if(data1.getString(target).equals("")) {
        	data1.set(target, island);
        	data1.save();
            data.set(island+".Members", members);
            data.set(island+".AmountMembers", data.getInt(island+".AmountMembers") + 1);
            data.save();
        } else {
        	
        }
	}

}
