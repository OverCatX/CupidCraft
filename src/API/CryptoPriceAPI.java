package API;

import CupidCraft.CupidCraft;
import cn.nukkit.utils.Config;

public class CryptoPriceAPI {
	private CupidCraft plugin;

    public CryptoPriceAPI(CupidCraft plugin) {
        this.plugin = plugin;
    }
	
	public void CreateCpypto(double btc,double eth,double doge,double percentbtc,double percenteth,double percentdoge) {
        Config data = new Config(plugin.getDataFolder() + "/Crypto/price/crypto.yml", Config.YAML);
        if (!data.exists("Crypto.")) {
            data.set("Crypto.THB_BTC", btc);
            data.set("Crypto.THB_ETH", eth);
            data.set("Crypto.THB_DOGE", doge);
            data.set("Percent.THB_BTC", percentbtc);
            data.set("Percent.THB_ETH", percenteth);
            data.set("Percent.THB_DOGE", percentdoge);
            data.save();
        }
    }
	
	public void CreateData(String p) {
        Config data = new Config(plugin.getDataFolder() + "/Crypto/"+p+".yml", Config.YAML);
        Config data1 = new Config(plugin.getDataFolder() + "/Crypto/process/process.yml", Config.YAML);
        if (!data.exists("Coins.")) {
            data.set("Coins.THB_BTC", 0);
            data.set("Coins.THB_ETH", 0);
            data.set("Coins.THB_DOGE", 0);
            data.save();
        }
        if (!data1.exists(p+".")) {
            data1.set(p+".Coin", "");
            data1.set(p+".pay", 0);
            data1.set(p+".price", 0);
            data1.set(p+".Reward", 0);
            data1.save();
        }
    }
	public void setProcess(String p,String coin,double pay,double price) {
		Config data1 = new Config(plugin.getDataFolder() + "/Crypto/process/process.yml", Config.YAML);
		data1.set(p+".Coin", coin);
        data1.set(p+".pay", pay);
        data1.set(p+".price", price);
        data1.save();
    }
	public void setReward(String p,double reward) {
		Config data1 = new Config(plugin.getDataFolder() + "/Crypto/process/process.yml", Config.YAML);
        data1.set(p+".Reward", reward);
        data1.save();
    }
	public void addCoin(String p,String coin, double amount) {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/"+p+".yml", Config.YAML);
		data.set("Coins."+coin, data.getDouble("Coins."+coin) + amount);
        data.save();
    }
	public void reduceCoin(String p,String coin, double amount) {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/"+p+".yml", Config.YAML);
		data.set("Coins."+coin, data.getDouble("Coins."+coin) - amount);
        data.save();
    }
	public void setCpyptoPrice(double btc,double eth,double doge,double percentbtc,double percenteth,double percentdoge) {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/price/crypto.yml", Config.YAML);
		data.set("Crypto.THB_BTC", btc);
        data.set("Crypto.THB_ETH", eth);
        data.set("Crypto.THB_DOGE", doge);
        data.set("Percent.THB_BTC", percentbtc);
        data.set("Percent.THB_ETH", percenteth);
        data.set("Percent.THB_DOGE", percentdoge);
        data.save();
    }
	public double PriceBTC() {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/price/crypto.yml", Config.YAML);
        return data.getDouble("Crypto.THB_BTC");
    }
	public double PriceETH() {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/price/crypto.yml", Config.YAML);
        return data.getDouble("Crypto.THB_ETH");
    }
	public double PriceDOGE() {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/price/crypto.yml", Config.YAML);
        return data.getDouble("Crypto.THB_DOGE");
    }
	public double PercentBTC() {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/price/crypto.yml", Config.YAML);
        return data.getDouble("Percent.THB_BTC");
    }
	public double PercentETH() {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/price/crypto.yml", Config.YAML);
        return data.getDouble("Percent.THB_ETH");
    }
	public double PercentDOGE() {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/price/crypto.yml", Config.YAML);
        return data.getDouble("Percent.THB_DOGE");
    }
	public double getPay(String p) {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/process/process.yml", Config.YAML);
        return data.getDouble(p+".pay");
    }
	public String getCoin(String p) {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/process/process.yml", Config.YAML);
        return data.getString(p+".Coin");
    }
	public double getPrice(String p) {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/process/process.yml", Config.YAML);
        return data.getDouble(p+".price");
    }
	public double getReward(String p) {
		Config data = new Config(plugin.getDataFolder() + "/Crypto/process/process.yml", Config.YAML);
        return data.getDouble(p+".Reward");
    }
}
