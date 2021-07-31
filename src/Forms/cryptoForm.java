package Forms;

import API.CryptoPriceAPI;
import API.EcoAPI;
import API.PetAPI;
import Cryptocurrency.CryptoAPI;
import CupidCraft.CupidCraft;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementDropdown;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;

public class cryptoForm implements Listener{
	
	private CupidCraft plugin;
	
	private static int Crypto_Form = 0x001402;
	private static int Buy_Form = 0x001403;
	//private static int Limit_Form = 0x001404;
	private static int Market_Form = 0x001404;
	private static int Comfirm_Form = 0x001502;
	
	public cryptoForm(CupidCraft plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
    public void ResponseCrypto(PlayerFormRespondedEvent event) {
        if (event.wasClosed()) return;
        Player player = event.getPlayer();
        CryptoPriceAPI api = new CryptoPriceAPI(plugin);
        EcoAPI eco = new EcoAPI(plugin);
        if (event.getWindow() instanceof FormWindowSimple) {
            int button = ((FormWindowSimple) event.getWindow()).getResponse().getClickedButtonId();
            String buttonString = ((FormWindowSimple) event.getWindow()).getResponse().getClickedButton().getText();
            if(event.getFormID() == Crypto_Form){
                if(button == 0){
                	Buy(player);
                }
                if(button == 1){
                	//Wallet(player);
                }
            }
            if(event.getFormID() == Buy_Form){
                if(button == 0){
                	player.sendMessage("Coming soon..");
                }
                if(button == 1) {
                	MarkeyBuy(player);
                }
            }
            if(event.getFormID() == Comfirm_Form) {
            	if(button == 0){
                	if(eco.myMoney(player.getName()) >= api.getPay(player.getName())) {
                		eco.reduceMoney(player.getName(), api.getPay(player.getName()));
                		String coin = "";
                		if(api.getCoin(player.getName()).equals("§eBitcoin")) {
                			coin = "THB_BTC";  			 
                		} else {
                			if(api.getCoin(player.getName()).equals("§8Ethereum")) {
                    			coin = "THB_ETH"; 
                    		} else {
                    			if(api.getCoin(player.getName()).equals("§6D§fO§6G§fE")) {
                        			coin = "THB_DOGE";
                    			}
                    		}
                		}
                		api.addCoin(player.getName(), coin, api.getReward(player.getName()));
                		player.sendMessage("§7Sy§8stem§f: \n§aท่านได้ซื้อเหรียญ "+api.getCoin(player.getName())+"\n§bจำนวน §6"+api.getReward(player.getName())+" §aสำเร็จแล้ว");
                	} else {
                		player.sendMessage("§7Sy§8stem§f: §cเงินของท่านไม่เพียงพอต่อการซื้อเหรียญ");
                	}
                }
                if(button == 1) {
                	
                }
            }
        }
        if (event.getWindow() instanceof FormWindowCustom) {
        	 int dropdown = ((FormWindowCustom) event.getWindow()).getResponse().getDropdownResponse(1).getElementID();
             String pay = ((FormWindowCustom) event.getWindow()).getResponse().getInputResponse(2);
             //String price = ((FormWindowCustom) event.getWindow()).getResponse().getInputResponse(3);
             if(event.getFormID() == Market_Form) {
            	 if(pay.isEmpty()) {
            		 player.sendMessage("§cอย่าเว้นว่าง");
            		 return;
            	 }
            	 if(Integer.parseInt(pay) < 0) {
            		 player.sendMessage("§cโปรดกรอกค่าที่เป็นบวก");
            		 return;
            	 }
            	 if(dropdown == 0) {
            		 Confirm(player,"§eBitcoin",Double.parseDouble(pay),api.PriceBTC(),api.PercentBTC());
            		 api.setProcess(player.getName(), "§eBitcoin", Double.parseDouble(pay), api.PriceBTC());
            	 }
            	 if(dropdown == 1) {
            		 Confirm(player,"§8Ethereum",Double.parseDouble(pay),api.PriceETH(),api.PercentETH());
            		 api.setProcess(player.getName(), "§8Ethereum", Double.parseDouble(pay), api.PriceBTC());
            	 }
            	 if(dropdown == 2) {
            		 Confirm(player,"§6D§fO§6G§fE",Double.parseDouble(pay),api.PriceDOGE(),api.PercentDOGE());
            		 api.setProcess(player.getName(), "§6D§fO§6G§fE", Double.parseDouble(pay), api.PriceBTC());
            	 }
             }
        }
	}
	
	public void CurrencyForm(Player player) {
		CryptoPriceAPI api = new CryptoPriceAPI(plugin);
		FormWindowSimple form = new FormWindowSimple("CryptoCurrency","ราคาเหรียญ cryptocurrency หน่วย(THB)ราคาจริงตามตลาด\n\n§aMarket\n"
				+ "- §eBitcoin§d(§6BTC§d) §f≈ §b"+api.PriceBTC()+" §aTHB\n"
						+ "- §8Ethereum §d(§7ETH§d) §f≈ §b"+api.PriceETH()+" §aTHB\n"
								+ "- §6D§fO§6G§fE §d(§eDOGE§d) §f≈ §b"+api.PriceDOGE()+" §aTHB\n\n"
										+ "§fราคาเหรียญจะถูกเปลี่ยนตามตลาดทุกๆ 30 วินาที\n"
										+ "§fราคาเหรียญอาจจะคลาดเคลื่อนไป 30-40 วินาที(sec)\n\n§dPercent\n"
										+ "- §eBitcoin§d(§6BTC§d) §f≈ §b"+api.PercentBTC()+"\n"
												+ "- §8Ethereum §d(§7ETH§d) §f≈ §b"+api.PercentETH()+"\n"
														+ "- §6D§fO§6G§fE §d(§eDOGE§d) §f≈ §b"+api.PercentDOGE()+"\n\n§fเปอร์เซ็นจะถูกเปลี่ยนตามตลาดทุกๆ 30 วินาที ตามราคาเหรียญ");
		form.addButton(new ElementButton("Buy\nซื้อเหรียญ"));
		form.addButton(new ElementButton("Wallet\nกระเป๋าเงินของท่าน"));
		player.showFormWindow(form,Crypto_Form);
	}
	public void Buy(Player player) {
		FormWindowSimple form = new FormWindowSimple("Buy","ท่านสามารถอ่านคู่มือการซื้อขายได้ใน หมวดคู่มือ\n§fย้ำ§c* §7ระบบการซื้อขายนี้ไม่ส่งผลต่อเงินจริงของท่านใช้แค่เงินในเกมส์เท่านั้น");
		form.addButton(new ElementButton("Limit -Buy\\nซื้อแบบลิมิต"));
		form.addButton(new ElementButton("Market-Buy\nซื้อแบบมาร์เก็ต"));
		player.showFormWindow(form,Buy_Form);
	}
	/*public void LimitBuy(Player player) {
		CryptoPriceAPI api = new CryptoPriceAPI(plugin);
		String crypto = "§6ราคา§bใน§aMarket\n"
				+ "- §eBitcoin§d(§6BTC§d) §f≈ §b"+api.PriceBTC()+" §aTHB\n"
				+ "- §8Ethereum §d(§7ETH§d) §f≈ §b"+api.PriceETH()+" §aTHB\n"
						+ "- §6D§fO§6G§fE §d(§eDOGE§d) §f≈ §b"+api.PriceDOGE()+" §aTHB\n\n"
								+ "§fราคาเหรียญอาจจะคลาดเคลื่อนไป 2-3 วินาที(sec)";
		FormWindowCustom form = new FormWindowCustom("Limit-Buy");
		ElementDropdown drop = new ElementDropdown("โปรดเลือกเหรียญที่ท่านต้องการซื้อ\n");
		drop.addOption("§eBitcoin§d(§6BTC§d)");
		drop.addOption("§8Ethereum §d(§7ETH§d)");
		drop.addOption("§6D§fO§6G§fE §d(§eDOGE§d)");
		form.addElement(new ElementLabel(crypto));
		form.addElement(drop);
		form.addElement(new ElementInput("ราคาที่ท่านจะจ่าย §b[§6เงินในเกมส์§b]"));
		form.addElement(new ElementInput("ราคาที่ท่านจะซื้อ (THB/BTC)\n§fราคาเหรียญในตลาด §b[§8กรอกจำนวนที่ท่านจะซื้อเหรียญได้เลย ราคาตรงนี้จะไม่มีผลต่อเงินของท่าน§b]"));
		player.showFormWindow(form,Limit_Form);
	}*/
	public void MarkeyBuy(Player player) {
		CryptoPriceAPI api = new CryptoPriceAPI(plugin);
		String crypto = "§6ราคา§bใน§aMarket\n"
				+ "- §eBitcoin§d(§6BTC§d) §f≈ §b"+api.PriceBTC()+" §aTHB\n"
				+ "- §8Ethereum §d(§7ETH§d) §f≈ §b"+api.PriceETH()+" §aTHB\n"
						+ "- §6D§fO§6G§fE §d(§eDOGE§d) §f≈ §b"+api.PriceDOGE()+" §aTHB\n\n"
								+ "§fราคาเหรียญจะถูกเปลี่ยนตามตลาดทุกๆ 30 วินาที\n"
								+ "§fราคาเหรียญอาจจะคลาดเคลื่อนไป 30-40 วินาที(sec)\n\n§dPercent\n"
								+ "- §eBitcoin§d(§6BTC§d) §f≈ §b"+api.PercentBTC()+"\n"
								+ "- §8Ethereum §d(§7ETH§d) §f≈ §b"+api.PercentETH()+"\n"
										+ "- §6D§fO§6G§fE §d(§eDOGE§d) §f≈ §b"+api.PercentDOGE()+"\n\n§fเปอร์เซ็นจะถูกเปลี่ยนตามตลาดทุกๆ 30 วินาที ตามราคาเหรียญ";
		FormWindowCustom form = new FormWindowCustom("Market-Buy");
		ElementDropdown drop = new ElementDropdown("โปรดเลือกเหรียญที่ท่านต้องการซื้อ\n§5หากท่านจะซื้อเหรียญในนี้\n§6ราคาเหรียญจะถูกซื้อตามราคาในตลาด");
		drop.addOption("§eBitcoin§d(§6BTC§d)");
		drop.addOption("§8Ethereum §d(§7ETH§d)");
		drop.addOption("§6D§fO§6G§fE §d(§eDOGE§d)");
		form.addElement(new ElementLabel(crypto));
		form.addElement(drop);
		form.addElement(new ElementInput("ราคาที่ท่านจะจ่าย §b[§6เงินในเกมส์§b]"));
		player.showFormWindow(form,Market_Form);
	}
	public void Confirm(Player player,String crypto,double pay,double price,double percent) {
		CryptoPriceAPI api = new CryptoPriceAPI(plugin);
		double cryptoprice = pay/price;
		double per = percent/100;
		double cryptoprices = cryptoprice+per;
		if(cryptoprices < 0) {
			cryptoprices = cryptoprices*-1;
		}
		api.setReward(player.getName(), cryptoprices);
		FormWindowSimple form = new FormWindowSimple(crypto,"เหรียญที่ท่านต้องการจะซื้อ§f: "+crypto+
				"\n§3ราคาที่ท่านจะจ่าย§f: §b"+pay+
				"\n§8ราคาที่ท่านจะซื้อ§f: §d"+price+
				"\n\n§6เหรียญที่ท่านจะได้รับ§f: §e"+cryptoprices);
		form.addButton(new ElementButton("Buy Now!\nซื้อเลย"));
		form.addButton(new ElementButton("Cancel\nยกเลิก"));
		player.showFormWindow(form,Comfirm_Form);
	}
	public void Wallet(Player player) {
		FormWindowSimple form = new FormWindowSimple("Wallet","กระเป๋าเงินของท่าน");
		form.addButton(new ElementButton("Sell\nขายเหรียญ"));
		player.showFormWindow(form);
	}
}
