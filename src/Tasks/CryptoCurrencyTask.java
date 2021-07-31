package Tasks;

import API.CryptoPriceAPI;
import Cryptocurrency.CryptoAPI;
import CupidCraft.CupidCraft;
import cn.nukkit.scheduler.PluginTask;

public class CryptoCurrencyTask extends PluginTask<CupidCraft>{

	public CryptoCurrencyTask(CupidCraft owner) {
		super(owner);
	}

	@Override
	public void onRun(int arg0) {
		CryptoPriceAPI api = new CryptoPriceAPI(owner);
		try {
			api.CreateCpypto(CryptoAPI.BitcoinPrice(), CryptoAPI.EthereumPrice(), CryptoAPI.DogePrice(),
					CryptoAPI.BitcoinPercent(),CryptoAPI.DogePercent(),CryptoAPI.EthereumPercent());
			api.setCpyptoPrice(CryptoAPI.BitcoinPrice(), CryptoAPI.EthereumPrice(), CryptoAPI.DogePrice(),
					CryptoAPI.BitcoinPercent(),CryptoAPI.DogePercent(),CryptoAPI.EthereumPercent());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
