package API;

import java.util.ArrayList;

import CupidCraft.CupidCraft;
import Math.RandomId;
import cn.nukkit.Player;
import cn.nukkit.utils.Config;

public class PetAPI {
	
	private CupidCraft plugin;

    public PetAPI(CupidCraft plugin) {
        this.plugin = plugin;
    }
	
	public void CreateData(String p,String pet,String feed) {
		ArrayList<String> pets = new ArrayList<>();
        Config data = new Config(plugin.getDataFolder() + "/pets/"+p+".yml", Config.YAML);
        Config data1 = new Config(plugin.getDataFolder() + "/pets/procces.yml", Config.YAML);
        if (!data.exists(pet)) {
            data.set(pet+".Levels", 1);
            data.set(pet+".Exp", 0);
            data.set(pet+".MaxExp", 1000);
            data.set(pet+".Feed", feed);
            data.save();
        }
        if (!data1.exists(p)) {
        	data1.set(p+".PetName", "");
        	data1.set(p+".PetType", "");
        	data1.set(p+".Calling", "");
        	data1.save();
        }
    }
	public void addPet(Player player,String pet,String feed) {
		String p = player.getName();
	    CreateData(p,pet,feed);
	}
	public static void addExp(String p,String pet,double exp) {
		 Config data = new Config(CupidCraft.getInstance().getDataFolder() + "/pets/"+p+".yml", Config.YAML);
		 if(data.getDouble(pet+".Exp") >= data.getInt(pet+".MaxExp")) {
			 data.set(pet+".Levels", data.getInt(pet+".Levels") + 1);
			 data.set(pet+".Exp", 0);
			 data.set(pet+".MaxExp", data.getInt(pet+".MaxExp")*2);
			 data.save();
		 } else {
			 data.set(pet+".Exp", data.getInt(pet+".Exp") + exp);
			 data.save();
		 }
		 
	}
	public void removePet(Player player,String pet) {
		String p = player.getName();
		ArrayList<String> pets = new ArrayList<String>();
		 Config data = new Config(plugin.getDataFolder() + "/pets/"+p+".yml", Config.YAML);
		 data.getAll().forEach((name, location) -> {
			 pets.add(name);
	     });
	     if (pets.contains(pet)) {
	    	 data.remove(pet);
	    	 data.save();
	    	 data.reload();
	    	 player.sendMessage(" §caP§ee§bt  §aคุณได้ขายสัตว์เลี้ยงสำเร็จแล้ว");
	    	 return;
	     } else {
	    	 player.sendMessage("Pet Error432$this->removePet() Failapi git-39853");
	     }
	}
	public static class Type {
        public static final String 
        		DOG_PET = "Dog_Pet",
        		CAT_PET = "Cat_Pet",
        		PANDA_PET = "Panda_Pet",
                HORSE_PET = "Horse_Pet",
                POLARBEAR_PET = "PolarBear_Pet";
    }
	public Object[] PetList(String p) {
        ArrayList<String> pets = new ArrayList<String>();
        Config data = new Config(plugin.getDataFolder() + "/pets/"+p+".yml", Config.YAML);
        data.getAll().forEach((name, pet) -> {
        	pets.add(name);
        });
        return pets.toArray();
    }
	public void SoldPet(String p,String pet) {
		if(pet.equals(Type.PANDA_PET)) {
			RandomId random = new RandomId();
			EcoAPI eco = new EcoAPI(plugin);
			Config data = new Config(plugin.getDataFolder() + "/pets/"+p+".yml", Config.YAML);
			int level = data.getInt(pet+".Level");
			double price = random.rand(1000, 3000);
			double realprice = price*level;
			eco.addMoney(p, realprice);
			return;
		}
	}
	public void setProcess(String p,String pet, String pettype) {
		Config data1 = new Config(plugin.getDataFolder() + "/pets/procces.yml", Config.YAML);
		data1.set(p+".PetName", pet);
		data1.set(p+".PetType", pettype);
		data1.save();
	}
	public void setCalling(String p,String calling) {
		Config data1 = new Config(plugin.getDataFolder() + "/pets/procces.yml", Config.YAML);
		data1.set(p+".Calling", calling);
		data1.save();
	}
	public String getFeed(String pet) {
		String feed = "";
		if(pet.equals("Dog_Pet")) {
			 feed = "Bone(กระดูก)";
		} else {
			if(pet.equals("Cat_Pet")) {
				 feed = "Raw_Fish(ปลาดิบ)";
			} else {
				if(pet.equals("Panda_Pet")) {
					 feed = "Bamboo(ต้นไผ่)";
				} else {
					if(pet.equals("Horse_Pet")) {
						 feed = "Wheat(ข้าวสาลี)";
					} else {
						if(pet.equals("PolarBear_Pet")) {
							 feed = "Raw_Fish(ปลาดิบ)";
						}
					}
				}
			}
		}
		return feed;
	}
	public int getPrice(String pet) {
		int price = 0;
		if(pet.equals("Dog_Pet")) {
			price = 2000;
		} else {
			if(pet.equals("Cat_Pet")) {
				price = 5000;
			} else {
				if(pet.equals("Panda_Pet")) {
					price = 10000;
				} else {
					if(pet.equals("Horse_Pet")) {
						price = 25000;
					} else {
						if(pet.equals("PolarBear_Pet")) {
							price = 50000;
						}
					}
				}
			}
		}
		return price; 
	}
	public int getLevel(String player,String pet) {
		Config data = new Config(plugin.getDataFolder() + "/pets/"+player+".yml", Config.YAML);
		return data.getInt(pet+".Level");
	}
	public int getExp(String player,String pet) {
		Config data = new Config(plugin.getDataFolder() + "/pets/"+player+".yml", Config.YAML);
		return data.getInt(pet+".Exp");
	}
	public int getMaxExp(String player,String pet) {
		Config data = new Config(plugin.getDataFolder() + "/pets/"+player+".yml", Config.YAML);
		return data.getInt(pet+".MaxExp");
	}
	public String getPet(String p,String pet) {
		ArrayList<String> pets = new ArrayList<String>();
		 Config data = new Config(plugin.getDataFolder() + "/pets/"+p+".yml", Config.YAML);
		 data.getAll().forEach((name, location) -> {
			 pets.add(name);
	     });
		 String bool = "";
	     if (pets.contains(pet)) {
	    	 bool = "true";
	     } else {
	    	 bool = "false";
	     }
	     return bool;
	}
	
	public String getProcessName(String p) {
		Config data1 = new Config(plugin.getDataFolder() + "/pets/procces.yml", Config.YAML);
		return data1.getString(p+".PetName");
	}
	public String getProcessType(String p) {
		Config data1 = new Config(plugin.getDataFolder() + "/pets/procces.yml", Config.YAML);
		return data1.getString(p+".PetType");
	}
	public String getCalling(String p) {
		Config data1 = new Config(plugin.getDataFolder() + "/pets/procces.yml", Config.YAML);
		return data1.getString(p+".Calling");
	}
}
