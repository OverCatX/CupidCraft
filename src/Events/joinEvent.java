package Events;

import API.EcoAPI;
import API.LevelAPI;
import API.PetAPI;
import API.PlayerAPI;
import API.RankAPI;
import API.SkyBlockAPI;
import CupidCraft.CupidCraft;
import Pets.PetEntity;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import de.lucgameshd.scoreboard.network.Scoreboard;
import de.lucgameshd.scoreboard.network.ScoreboardDisplay;

public class joinEvent implements Listener{
	private CupidCraft plugin;
	
	private Scoreboard scoreboard;
	private ScoreboardDisplay scoreboardDisplay;
	
	public joinEvent(CupidCraft plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		EcoAPI eco = new EcoAPI(plugin);
		RankAPI rank = new RankAPI(plugin);
		LevelAPI level = new LevelAPI(plugin);
		PlayerAPI playerdata = new PlayerAPI(plugin);
		SkyBlockAPI skyblock = new SkyBlockAPI(plugin);
		
		//CreateData
		skyblock.CreateIsland(player.getName(), player.getName()+"1");
		rank.CreateData(player.getName());
		eco.CreateAccount(player.getName());
		level.CreateData(player.getName());
		playerdata.CreateAccount(player.getName());
		event.setJoinMessage(" §b"+player.getName()+" §l§aได้§5เข้า§2ร่วม§3เซิฟ§4เวอร์§6แล้ว §eขอ§dให้§bสนุก§aกับ§2เซิฟ§4เวอร์§6นะ§5ครับ");
		
		//Pet
		PetAPI api = new PetAPI(plugin);
		if(!api.getProcessName(player.getName()).equals("")) {
			PetEntity pet = (PetEntity) PetEntity.createEntity(api.getProcessType(player.getName()), player);
			((PetEntity) pet).setOwner(player);
			pet.follow(player);
			pet.spawnToAll();
			api.setProcess(player.getName(), pet.getNameTag(),api.getProcessType(player.getName()));
		}
		//Scoreboard
		/*Scoreboard scoreboard = ScoreboardAPI.createScoreboard();
		ScoreboardDisplay scoreboardDisplay = scoreboard.addDisplay( DisplaySlot.SIDEBAR, "objectivename", "title" );
		scoreboardDisplay.addLine( "This is a line in a score", 0 );
		scoreboardDisplay.addLine( "§a", 1 ); //free space
		scoreboardDisplay.addLine( "Name: " + player.getName(), 2 );
		scoreboardDisplay.addLine( "§b", 3); //free space*/
	}

}
