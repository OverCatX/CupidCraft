package CupidCraft;

import API.PetAPI;
import Commands.admin;
import Commands.clan;
import Commands.crytocurrency;
import Commands.eco;
import Commands.island;
import Commands.message;
import Commands.pet;
import Commands.playerdata;
import Commands.rank;
import Commands.report;
import Events.PetDamageEvent;
import Events.QuitEvent;
import Events.dropitemEvent;
import Events.joinEvent;
import Forms.PetForm;
import Forms.cryptoForm;
import Forms.jobForm;
import Forms.playerdataForm;
import Forms.reportForm;
import Pets.Entities.CatPet;
import Pets.Entities.DogPet;
import Pets.Entities.HorsePet;
import Pets.Entities.PandaPet;
import Pets.Entities.PolarBearPet;
import Tasks.Autosave;
import Tasks.Broadcast;
import Tasks.CryptoCurrencyTask;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;

public class CupidCraft extends PluginBase implements Listener{
	
	
	/* Forms */
	private playerdataForm playerForm;
	private reportForm reportForms;
	private jobForm JobForm;
	private PetForm petForm;
	private cryptoForm CrytoForm;
	/*\/\/\/\*/
	
	private static CupidCraft instance;
	
    public static CupidCraft getInstance() {
        return instance;
    }
	
	@Override
	public void onEnable() {
		getServer().getLogger().info("Enable"); 
		getDataFolder().mkdirs();
		registerCommands();
		registerEvents();
		registerTasks();
		registerEntities();
		this.playerForm = new playerdataForm(this);
        this.reportForms = new reportForm(this);
        this.JobForm = new jobForm(this);
        this.petForm = new PetForm(this);
        this.CrytoForm = new cryptoForm(this);
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(this.playerForm, this);
        getServer().getPluginManager().registerEvents(this.reportForms, this);
        getServer().getPluginManager().registerEvents(this.JobForm, this);
        getServer().getPluginManager().registerEvents(this.petForm, this);
        getServer().getPluginManager().registerEvents(this.CrytoForm, this);
	}

	private void registerCommands() {
		getServer().getCommandMap().register("admin", new admin("admin",this));
		getServer().getCommandMap().register("eco", new eco("eco",this));
		getServer().getCommandMap().register("setmessage", new message("setmessage",this));
		getServer().getCommandMap().register("rank", new rank("rank",this));
		getServer().getCommandMap().register("clan", new clan("clan",this));
		getServer().getCommandMap().register("playerdataaaaa", new playerdata("playerdataaaaa",this));
		getServer().getCommandMap().register("reportsdawda", new report("reportsdawda",this));
		getServer().getCommandMap().register("island", new island("island",this));
		getServer().getCommandMap().register("petwdadawsdawaedw", new pet("petwdadawsdawaedw",this));
		getServer().getCommandMap().register("crypto", new crytocurrency("crypto",this));
	}
	private void registerEvents() {
		//Events
		getServer().getPluginManager().registerEvents(new joinEvent(this),this);
		getServer().getPluginManager().registerEvents(new dropitemEvent(),this);
		getServer().getPluginManager().registerEvents(new PetDamageEvent(this),this);
		getServer().getPluginManager().registerEvents(new QuitEvent(this),this);
	}
	private void registerTasks() {
		getServer().getScheduler().scheduleRepeatingTask(new CryptoCurrencyTask(this), 20*30);
		getServer().getScheduler().scheduleRepeatingTask(new Broadcast(this), 20 * 300);
		getServer().getScheduler().scheduleRepeatingTask(new Autosave(this), 20 * 600);
	}
	
	private void registerEntities() {
		Entity.registerEntity(PetAPI.Type.PANDA_PET, PandaPet.class);
		Entity.registerEntity(PetAPI.Type.DOG_PET, DogPet.class);
		Entity.registerEntity(PetAPI.Type.CAT_PET, CatPet.class);
		Entity.registerEntity(PetAPI.Type.HORSE_PET, HorsePet.class);
		Entity.registerEntity(PetAPI.Type.POLARBEAR_PET, PolarBearPet.class);
	}
}
