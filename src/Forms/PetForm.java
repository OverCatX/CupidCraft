package Forms;

import API.EcoAPI;
import API.PetAPI;
import CupidCraft.CupidCraft;
import Pets.PetEntity;
import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.level.Level;

public class PetForm implements Listener{
	
	private CupidCraft plugin;
	
	private static int Pet = 0x2102094;
	private static int Pet_SHOP = 0x2102095;
	private static int Pet_TREASURE = 0x2102096;
	private static int Pet_TREASURE_FORM = 0x2102097;
	
	public PetForm(CupidCraft plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
    public void ResponsePet(PlayerFormRespondedEvent event) {
        if (event.wasClosed()) return;
        Player player = event.getPlayer();
        PetAPI api = new PetAPI(plugin);
        EcoAPI eco = new EcoAPI(plugin);
        if (event.getWindow() instanceof FormWindowSimple) {
            int button = ((FormWindowSimple) event.getWindow()).getResponse().getClickedButtonId();
            String buttonString = ((FormWindowSimple) event.getWindow()).getResponse().getClickedButton().getText();
            if(event.getFormID() == Pet){
                if(button == 0){
                    Petshop(player);
                }
                if(button == 1){
                	Treasure(player);
                }
            }
            if(event.getFormID() == Pet_TREASURE){
            	for(Object pets : api.PetList(player.getName())) {
            		String pet = pets.toString();
            		if(buttonString.equals(pets.toString())) {
            			PetTreasure(player, pet, 
    			    			api.getFeed(pet), 
    			    			api.getPrice(pet), 
    			    			api.getLevel(player.getName(),pet), 
    			    			api.getExp(player.getName(), pet), 
    			    			api.getMaxExp(player.getName(), pet));
            		}
            	}
            }
            if(event.getFormID() == Pet_SHOP){
            	if(button == 0) {
            		if(eco.myMoney(player.getName()) >= 2000) {
            			eco.reduceMoney(player.getName(), 2000);
            			if(api.getPet(player.getName(), PetAPI.Type.DOG_PET).equals("true")) {
            				player.sendMessage(" §cP§ee§bt  §cคุณมีสัตว์เลี้ยงตัวนี้อยู่แล้วไม่สามารถซื้อได้");
            				return;
            			}
            			api.addPet(player, PetAPI.Type.DOG_PET, "Bone");
            			Bought(player,PetAPI.Type.DOG_PET,"Bone(กระดูก)",2000);
            		} else {
            			player.sendMessage(" §cP§ee§bt  §cเงินของท่านไม่เพียงพอในการซื้อสัตว์เลี้ยงตัวนี้");
            		}
            	}
            	if(button == 1) {
            		if(eco.myMoney(player.getName()) >= 5000) {
            			eco.reduceMoney(player.getName(), 5000);
            			if(api.getPet(player.getName(), PetAPI.Type.CAT_PET).equals("true")) {
            				player.sendMessage(" §cP§ee§bt  §cคุณมีสัตว์เลี้ยงตัวนี้อยู่แล้วไม่สามารถซื้อได้");
            				return;
            			}
            			api.addPet(player, PetAPI.Type.CAT_PET, "Raw_Fish(ปลาดิบ)");
            			Bought(player,PetAPI.Type.CAT_PET,"Raw_Fish(ปลาดิบ)",5000);
            		} else {
            			player.sendMessage(" §cP§ee§bt  §cเงินของท่านไม่เพียงพอในการซื้อสัตว์เลี้ยงตัวนี้");
            		}
            	}
            	if(button == 2) {
            		if(eco.myMoney(player.getName()) >= 10000) {
            			eco.reduceMoney(player.getName(), 10000);
            			if(api.getPet(player.getName(), PetAPI.Type.PANDA_PET).equals("true")) {
            				player.sendMessage(" §cP§ee§bt  §cคุณมีสัตว์เลี้ยงตัวนี้อยู่แล้วไม่สามารถซื้อได้");
            				return;
            			}
            			api.addPet(player, PetAPI.Type.PANDA_PET, "Bamboo(ต้นไผ่)");
            			Bought(player,PetAPI.Type.PANDA_PET,"Bamboo(ต้นไผ่)",10000);
            		} else {
            			player.sendMessage(" §cP§ee§bt  §cเงินของท่านไม่เพียงพอในการซื้อสัตว์เลี้ยงตัวนี้");
            		}
            	}
            	if(button == 3) {
            		if(eco.myMoney(player.getName()) >= 25000) {
            			eco.reduceMoney(player.getName(), 25000);
            			if(api.getPet(player.getName(), PetAPI.Type.HORSE_PET).equals("true")) {
            				player.sendMessage(" §cP§ee§bt  §cคุณมีสัตว์เลี้ยงตัวนี้อยู่แล้วไม่สามารถซื้อได้");
            				return;
            			}
            			api.addPet(player, PetAPI.Type.HORSE_PET, "Wheat");
            			Bought(player,PetAPI.Type.HORSE_PET,"Wheat(ข้าวสาลี)",25000);
            		} else {
            			player.sendMessage(" §cP§ee§bt  §cเงินของท่านไม่เพียงพอในการซื้อสัตว์เลี้ยงตัวนี้");
            		}
            	}
            	if(button == 4) {
            		if(eco.myMoney(player.getName()) >= 50000) {
            			eco.reduceMoney(player.getName(), 50000);
            			if(api.getPet(player.getName(), PetAPI.Type.POLARBEAR_PET).equals("true")) {
            				player.sendMessage(" §cP§ee§bt  §cคุณมีสัตว์เลี้ยงตัวนี้อยู่แล้วไม่สามารถซื้อได้");
            				return;
            			}
            			api.addPet(player, PetAPI.Type.POLARBEAR_PET, "Raw_Fish");
            			Bought(player,PetAPI.Type.POLARBEAR_PET,"Raw_Fish(ปลาดิบ)",50000);
            		} else {
            			player.sendMessage(" §cP§ee§bt  §cเงินของท่านไม่เพียงพอในการซื้อสัตว์เลี้ยงตัวนี้");
            		}
            	}
            }
            if(event.getFormID() == Pet_TREASURE_FORM){
                if(button == 0){
                	PetEntity pet = (PetEntity) PetEntity.createEntity(api.getCalling(player.getName()), player);
    				if(!api.getProcessName(player.getName()).equals("")) {
    					//player.sendTip("\n\n\nPasss 1");
    					for (Level level : plugin.getServer().getLevels().values()) {
    						//player.sendTip("\n\n\nPasss 2");
    						if(level.getEntities().length == 0) {
    							((PetEntity) pet).setOwner(player);
                 				pet.follow(player);
                 				pet.spawnToAll();
                 				api.setProcess(player.getName(), pet.getNameTag(),api.getCalling(player.getName()));
                 				api.setCalling(player.getName(), "");
                                player.sendMessage(" §cP§ee§bt  §aคุณ§bได้§eเรียก§3สัตว์§dเลี้ยง  §6"+api.getCalling(player.getName()));
                                return;
    						}
                            for (Entity entity : level.getEntities()) {
                            	//player.sendTip("\n\n\nPasss 3");
                                if (entity instanceof PetEntity) {
                                	String nametag = entity.getNameTag();
                                    if (nametag.equals("§c[§fสัตว์เลี้ยง§c] §d"+player.getName())) {
                                        entity.close();
                                        ((PetEntity) pet).setOwner(player);
                        				pet.follow(player);
                        				pet.spawnToAll();
                        				api.setProcess(player.getName(), pet.getNameTag(),api.getCalling(player.getName()));
                        				api.setCalling(player.getName(), "");
                                        player.sendMessage(" §cP§ee§bt  §aคุณ§bได้§eเรียก§3สัตว์§dเลี้ยง  §6"+api.getCalling(player.getName()));
                                        return;
                                    }
                                }
                            }
    					}
    					return;
    				}
    				((PetEntity) pet).setOwner(player);
    				pet.follow(player);
    				pet.spawnToAll();
   					api.setProcess(player.getName(), pet.getNameTag(),api.getCalling(player.getName()));
   					api.setCalling(player.getName(), "");
   					player.sendMessage(" §cP§ee§bt  §aคุณ§bได้§eเรียก§3สัตว์§dเลี้ยง  §6"+api.getCalling(player.getName()));
                }
                if(button == 1){
                	   
                }
            }
        }
    }
	
	public void Pet(Player player) {
		PetAPI api = new PetAPI(plugin);
		String buy = "§cซื้อสัตว์เลี้ยง";
		String treasure = "§6คลังสัตว์เลี้ยง";
		FormWindowSimple form = new FormWindowSimple("§l§cP§ee§bt", "§bสัตว์§3เลี้ยง§aที่§6คุณ§dครอบ§eครอง§f: §6");
		form.addButton(new ElementButton("§l§aBuy §l§cP§ee§bt\n"+buy));
		form.addButton(new ElementButton("§l§cTrea§2sure\n"+treasure));
		player.showFormWindow(form,Pet);
	}
	
	public void Treasure(Player player) {
		PetAPI api = new PetAPI(plugin);
		FormWindowSimple form = new FormWindowSimple("§l§cT§er§be§da§2s§3u§5r§6e", "§l§aคลัง§bสัตว์§3เลี้ยง§dของ§6ท่าน");
		for(Object treasure : api.PetList(player.getName())) {
			form.addButton(new ElementButton(treasure.toString()));
		}
		player.showFormWindow(form,Pet_TREASURE);
	}
	
	public void Petshop(Player player) {
		FormWindowSimple form = new FormWindowSimple("§cP§ee§bt §eS§3h§ao§6p", "§bร้าน§cค้า§dสัตว์§eเลี้ยง\n§fราคาสัตว์เลี้ยงแต่ละตัว"
				+ "\n§7Dog §f2,000"
				+ "\n§7Cat §f5,000"
				+ "\n§7Panda §f10,000"
				+ "\n§7Horse §f25,000"
				+ "\n§7PolarBear §f50,000");
		form.addButton(new ElementButton("§fDog Pet\n§bสุนัข"));
		form.addButton(new ElementButton("§fCat Pet\n§bแมว"));
		form.addButton(new ElementButton("§fPanda Pet\n§bแพนด้า"));
		form.addButton(new ElementButton("§fHorse Pet\n§bม้า"));
		form.addButton(new ElementButton("§fPolarBear Pet\n§bหมีขั่วโลก"));
		player.showFormWindow(form,Pet_SHOP);
	}
	public void Bought(Player player,String pet,String feed,int price) {
		FormWindowSimple form = new FormWindowSimple("Bought", "ซื้อสำเร็จ\n\n"
				+ "สัตว์เลี้ยง : "+pet+"\n\n"
						+ "อาหารของสัตว์เลี้ยง : "+feed+"\n\n"
								+ "ราคาที่คุณซื้อ : "+price);
		player.showFormWindow(form);
	}
	public void Petme(Player player,String pet,String feed,int price,int level,int exp,int maxexp) {
		FormWindowSimple form = new FormWindowSimple(pet, "Status สัตว์เลี้ยงของท่าน\n\n"
				+ "สัตว์เลี้ยง : "+pet+"\n\n"
						+ "อาหารของสัตว์เลี้ยง : "+feed+"\n\n"
								+ "ราคาที่คุณซื้อ : "+price);
		player.showFormWindow(form);
	}
	public void PetTreasure(Player player,String pet,String feed,int price,int level,int exp,int maxexp) {
		FormWindowSimple form = new FormWindowSimple(pet, "Status สัตว์เลี้ยงของท่าน\n"
				+ "สัตว์เลี้ยง :"+pet+"\n"
						+ "อาหารของสัตว์เลี้ยง :"+feed+"\n"
								+ "ราคาที่คุณซื้อ :"+price);
		PetAPI api = new PetAPI(plugin);
		api.setCalling(player.getName(), pet);
		form.addButton(new ElementButton("Called Pet\nเรียกสัตว์เลี้ยงของท่าน"));
		form.addButton(new ElementButton("Feeding Pet\nให้อาหารสัตว์เลี้ยงของท่าน"));
		player.showFormWindow(form,Pet_TREASURE_FORM);
	}
}
