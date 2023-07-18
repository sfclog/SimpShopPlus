package me.sfclog.simpshopplus.lang;


import me.sfclog.simpshopplus.Main;
import me.sfclog.simpshopplus.utils.Color;
import me.sfclog.simpshopplus.utils.Send;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Lang {

    public static File locate = new File("plugins/SimpShopPlus/", "config.yml");
    public static FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
    

    public static void loadlang() {
    addlang("Plugin.Prefix","&7(&dSimpShopPlus&7) ");

    addlang("Plugin.Reload","&2Đã tải lại plugin !");
    addlang("Plugin.ReloadFail","&4Có lỗi khi tải lại plugin !");

	addlang("Shop.GuiPE.SellAndBuy.Title","&b&lＭｕａ Ｖà Ｂáｎ Ｖậｔ Ｐｈẩｍ");

	ArrayList<String> info = new ArrayList<>();
	info.add("&fThông tin vật phẩm:");
	info.add(" &fTên: &e<name>");
	info.add(" &fGiá mua: <buy_price>");
	info.add(" &fGiá bán: <sell_price>");
	info.add(" &fSố lượng: &c<amount>");

	addlang("Shop.GuiPE.SellAndBuy.Info",info);


	addlang("Shop.GuiPE.Title","&e&lＣỬＡ ＨÀＮＧ &d&lＭÁＹ ＣＨỦ");
	addlang("Shop.GuiPE.Info","&7&oNơi mua bán các vật phẩm đa dạng và rất cần thiết trong quá trình chơi của bạn.");


	addlang("Shop.Gui.SellGui","&d&lＢÁＮ ＮＨＡＮＨ &7(Bỏ vật phẩm vào để bán)");


	addlang("Shop.Gui.CustomBuyItem.Title","&5&lＭＵＡ ＶỚＩ ＳỐ ＬƯỢＮＧ ＣỤ ＴＨỂ");
	ArrayList<String> info1 = new ArrayList<>();
	info1.add("&7&oDùng để mua vật phẩm với số lượng cụ thể.");
	info1.add("&fThông tin vật phẩm:");
	info1.add(" &fTên: &e<name>");
	info1.add(" &fGiá mua: <buy_price>/x1");
	info1.add(" &fGiá bán: <sell_price>/x1");
	addlang("Shop.Gui.CustomBuyItem.Info",info1);

	addlang("Shop.Gui.CustomBuyItem.InputTitle","&bNhập số lượng vật phẩm:");
	addlang("Shop.Gui.CustomBuyItem.InputSub","&fSố lượng (Vd: 64,128,...)");

	addlang("Shop.GuiPE.Button.BuyX1","&aMua &fx1 &7(<price>&7)");
	addlang("Shop.GuiPE.Button.BuyX16","&aMua &fx16 &7(<price>&7)");
	addlang("Shop.GuiPE.Button.BuyX32","&aMua &fx32 &7(<price>&7)");
	addlang("Shop.GuiPE.Button.BuyX64","&aMua &fx64 &7(<price>&7)");
	addlang("Shop.GuiPE.Button.BuyCustom","&eMua với số lượng cụ thể");


	addlang("Shop.GuiPE.Button.SellX1","&cBán &fx1 &7(<price>&7)");
	addlang("Shop.GuiPE.Button.SellX16","&cBán &fx16 &7(<price>&7)");
	addlang("Shop.GuiPE.Button.SellX32","&cBán &fx32 &7(<price>&7)");
	addlang("Shop.GuiPE.Button.SellX64","&cBán &fx64 &7(<price>&7)");
	addlang("Shop.GuiPE.Button.SellCustom","&eBán toàn bộ vật phẩm");



	addlang("Shop.Price.Money","&a<price>$");
	addlang("Shop.Price.Coin","&e<price> Xu");
	addlang("Shop.Price.Exp","&b<price> EXP");

	addlang("Shop.GuiPC.Title","&e&lＣỬＡ ＨÀＮＧ &d&lＭÁＹ ＣＨỦ");

	addlang("Shop.GuiPC.SellAndBuy","&b&lＭｕａ Ｖà Ｂáｎ Ｖậｔ Ｐｈẩｍ");
	addlang("Shop.GuiPC.Buy","&a&lＭｕａ Ｖậｔ Ｐｈẩｍ");
	addlang("Shop.GuiPC.Sell","&c&lＢáｎ Ｖậｔ Ｐｈẩｍ");



	addlang("Shop.GuiPC.Size",54);


	ArrayList<String> lore = new ArrayList<>();
	lore.add(" ");
	lore.add("&fThông tin:");
	lore.add(" ");
	lore.add(" &7&o<info>");
	lore.add(" ");
	lore.add(" &aClick để mua hoặc bán");
	lore.add(" ");


		addlang("Shop.GuiPC.MainItem.Lore",lore);


		addlang("Shop.GuiPC.BuyItem.Name","&a&lMUA &f&lX<int>");
		addlang("Shop.GuiPC.BuyItem.Type","green_stained_glass");

		ArrayList<String> buylore = new ArrayList<>();
		buylore.add(" ");
		buylore.add(" &fGiá mua&f: &e<buy_price>");
		buylore.add(" &fSố lượng&f: &e<amount>");
		buylore.add(" &fPhải trả&f: &a<price>");
		buylore.add(" ");
		buylore.add(" &aClick để thanh toán");
		buylore.add(" ");
		addlang("Shop.GuiPC.BuyItem.Lore",buylore);

		addlang("Shop.GuiPC.SellItem.Name","&c&lBÁN &f&lX<int>");
		addlang("Shop.GuiPC.SellItem.Type","red_stained_glass");

		ArrayList<String> selllore = new ArrayList<>();
		selllore.add(" ");
		selllore.add(" &fGiá bán&f: &e<sell_price>");
		selllore.add(" &fSố lượng&f: &e<amount>");
		selllore.add(" &fTổng tiền nhận&f: &a<price>");
		selllore.add(" ");
		selllore.add(" &eClick để bán");
		selllore.add(" ");
		addlang("Shop.GuiPC.SellItem.Lore",selllore);



		addlang("Shop.GuiPC.NextItem.Name","&a&lTrang Tiếp Theo");
		addlang("Shop.GuiPC.NextItem.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjVmMDFmYzc1ZjVjMTY1NDEyNzQ3YzQyYzExMDVkMTJiN2JhOTE0NmRiOWExMGExMWQzMzk1NWY2NWM5ODlkYSJ9fX0=");
		ArrayList<String> nextlore = new ArrayList<>();
		nextlore.add(" ");
		nextlore.add(" &fTrang (<this>/<max>)");
		nextlore.add(" ");
		nextlore.add(" &aClick để chuyển trang tiếp");
		nextlore.add(" ");
		addlang("Shop.GuiPC.NextItem.Lore",nextlore);


		addlang("Shop.GuiPC.BackItem.Name","&c&lTrang Trước");
		addlang("Shop.GuiPC.BackItem.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY2Yzk2YWMxYWRjMjFjMTU1YTZmYTE2YTMzZmVhMjdjZDVjNzRjZjdjMzE2YmM4MDJkZjdhM2I5ZWVmMzlmNSJ9fX0=");
		ArrayList<String> backlore = new ArrayList<>();
		backlore.add(" ");
		backlore.add(" &fTrang (<this>/<max>)");
		backlore.add(" ");
		backlore.add(" &eClick để về trang trước");
		backlore.add(" ");
		addlang("Shop.GuiPC.BackItem.Lore",backlore);


		addlang("Shop.GuiPC.QuitItem.Name","&5&lQuay Lại");
		addlang("Shop.GuiPC.QuitItem.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVhOWU4ODVlOTNmOTY0ZTAwNzVhNzVlOWFlMjVjZGFiZGEyZmZhNWQxMmZlZWRmYWIwZjg4OWIzZWRiYmU2YiJ9fX0=");
		ArrayList<String> Quitlore = new ArrayList<>();
		Quitlore.add(" ");
		Quitlore.add(" &7&oDùng để quay lại danh mục");
		Quitlore.add(" &7&ochính của cửa hàng.");
		Quitlore.add(" ");
		Quitlore.add(" &bClick để quay lại");
		Quitlore.add(" ");
		addlang("Shop.GuiPC.QuitItem.Lore",Quitlore);


		addlang("Shop.GuiPC.CloseItem.Name","&5&lThoát");
		addlang("Shop.GuiPC.CloseItem.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVhOWU4ODVlOTNmOTY0ZTAwNzVhNzVlOWFlMjVjZGFiZGEyZmZhNWQxMmZlZWRmYWIwZjg4OWIzZWRiYmU2YiJ9fX0=");
		ArrayList<String> Closelore = new ArrayList<>();
		Closelore.add(" ");
		Closelore.add(" &7&oDùng để thoát khỏi cửa hàng này.");
		Closelore.add(" ");
		Closelore.add(" &bClick để thoát");
		Closelore.add(" ");
		addlang("Shop.GuiPC.CloseItem.Lore",Closelore);



		ArrayList<String> ItemInfolore = new ArrayList<>();
		ItemInfolore.add(" ");
		ItemInfolore.add("&fThông tin vật phẩm:");
		ItemInfolore.add(" ");
		ItemInfolore.add(" &fSố lượng: &c<amount>");
		ItemInfolore.add(" &fGiá bán: <pricesell>");
		ItemInfolore.add(" &fGiá mua: <pricebuy>");
		ItemInfolore.add(" ");
		ItemInfolore.add(" &aClick để mua hoặc bán");
		ItemInfolore.add(" ");
		addlang("Shop.GuiPC.ItemInfo.Lore",ItemInfolore);


		ArrayList<String> ItemInfoOnlyBuylore = new ArrayList<>();
		ItemInfoOnlyBuylore.add(" ");
		ItemInfoOnlyBuylore.add("&fThông tin vật phẩm:");
		ItemInfoOnlyBuylore.add(" ");
		ItemInfoOnlyBuylore.add(" &fSố lượng: &c<amount>");
		ItemInfoOnlyBuylore.add(" &fGiá mua: <pricebuy>");
		ItemInfoOnlyBuylore.add(" ");
		ItemInfoOnlyBuylore.add(" &aClick để mua hoặc bán");
		ItemInfoOnlyBuylore.add(" ");
		addlang("Shop.GuiPC.ItemInfoOnlyBuy.Lore",ItemInfoOnlyBuylore);

		ArrayList<String> ItemInfoOnlySelllore = new ArrayList<>();
		ItemInfoOnlySelllore.add(" ");
		ItemInfoOnlySelllore.add("&fThông tin vật phẩm:");
		ItemInfoOnlySelllore.add(" ");
		ItemInfoOnlySelllore.add(" &fSố lượng: &c<amount>");
		ItemInfoOnlySelllore.add(" &fGiá bán: <pricesell>");
		ItemInfoOnlySelllore.add(" ");
		ItemInfoOnlySelllore.add(" &aClick để mua hoặc bán");
		ItemInfoOnlySelllore.add(" ");
		addlang("Shop.GuiPC.ItemInfoOnlySell.Lore",ItemInfoOnlySelllore);



		addlang("Shop.GuiPC.BuyItemX1.Name","&aMua &fX1");
		addlang("Shop.GuiPC.BuyItemX1.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRiYmM1ODM2MDliNWYwMjUzN2NjM2NjMzZkNDBhNjBlMTM2NmEyMjJkYzU0ZjFlNzYxMTAwMGE4OTViMjMzNyJ9fX0=");
		ArrayList<String> BuyItemX1Lore = new ArrayList<>();
		BuyItemX1Lore.add(" ");
		BuyItemX1Lore.add("&fThông tin:");
		BuyItemX1Lore.add(" ");
		BuyItemX1Lore.add(" &fGiá mua: <buy_price>");
		BuyItemX1Lore.add(" &fSố lượng: &c<amount>");
		BuyItemX1Lore.add(" ");
		BuyItemX1Lore.add(" &fTổng: <sum_price>");
		BuyItemX1Lore.add(" ");
		BuyItemX1Lore.add(" &aClick để mua");
		BuyItemX1Lore.add(" ");
		addlang("Shop.GuiPC.BuyItemX1.Lore",BuyItemX1Lore);

		addlang("Shop.GuiPC.BuyItemX16.Name","&aMua &fX16");
		addlang("Shop.GuiPC.BuyItemX16.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRiYmM1ODM2MDliNWYwMjUzN2NjM2NjMzZkNDBhNjBlMTM2NmEyMjJkYzU0ZjFlNzYxMTAwMGE4OTViMjMzNyJ9fX0=");
		ArrayList<String> BuyItemX16Lore = new ArrayList<>();
		BuyItemX16Lore.add(" ");
		BuyItemX16Lore.add("&fThông tin:");
		BuyItemX16Lore.add(" ");
		BuyItemX16Lore.add(" &fGiá mua: <buy_price>");
		BuyItemX16Lore.add(" &fSố lượng: &c<amount>");
		BuyItemX16Lore.add(" ");
		BuyItemX16Lore.add(" &fTổng: <sum_price>");
		BuyItemX16Lore.add(" ");
		BuyItemX16Lore.add(" &aClick để mua");
		BuyItemX16Lore.add(" ");
		addlang("Shop.GuiPC.BuyItemX16.Lore",BuyItemX16Lore);



		addlang("Shop.GuiPC.BuyItemX32.Name","&aMua &fX32");
		addlang("Shop.GuiPC.BuyItemX32.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRiYmM1ODM2MDliNWYwMjUzN2NjM2NjMzZkNDBhNjBlMTM2NmEyMjJkYzU0ZjFlNzYxMTAwMGE4OTViMjMzNyJ9fX0=");
		ArrayList<String> BuyItemX32Lore = new ArrayList<>();
		BuyItemX32Lore.add(" ");
		BuyItemX32Lore.add("&fThông tin:");
		BuyItemX32Lore.add(" ");
		BuyItemX32Lore.add(" &fGiá mua: <buy_price>");
		BuyItemX32Lore.add(" &fSố lượng: &c<amount>");
		BuyItemX32Lore.add(" ");
		BuyItemX32Lore.add(" &fTổng: <sum_price>");
		BuyItemX32Lore.add(" ");
		BuyItemX32Lore.add(" &aClick để mua");
		BuyItemX32Lore.add(" ");
		addlang("Shop.GuiPC.BuyItemX32.Lore",BuyItemX32Lore);


		addlang("Shop.GuiPC.BuyItemX64.Name","&aMua &fX64");
		addlang("Shop.GuiPC.BuyItemX64.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRiYmM1ODM2MDliNWYwMjUzN2NjM2NjMzZkNDBhNjBlMTM2NmEyMjJkYzU0ZjFlNzYxMTAwMGE4OTViMjMzNyJ9fX0=");
		ArrayList<String> BuyItemX64Lore = new ArrayList<>();
		BuyItemX64Lore.add(" ");
		BuyItemX64Lore.add("&fThông tin:");
		BuyItemX64Lore.add(" ");
		BuyItemX64Lore.add(" &fGiá mua: <buy_price>");
		BuyItemX64Lore.add(" &fSố lượng: &c<amount>");
		BuyItemX64Lore.add(" ");
		BuyItemX64Lore.add(" &fTổng: <sum_price>");
		BuyItemX64Lore.add(" ");
		BuyItemX64Lore.add(" &aClick để mua");
		BuyItemX64Lore.add(" ");
		addlang("Shop.GuiPC.BuyItemX64.Lore",BuyItemX64Lore);


		addlang("Shop.GuiPC.BuyItemCustom.Name","&aMua Với Số Lượng Cụ Thể");
		addlang("Shop.GuiPC.BuyItemCustom.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRiYmM1ODM2MDliNWYwMjUzN2NjM2NjMzZkNDBhNjBlMTM2NmEyMjJkYzU0ZjFlNzYxMTAwMGE4OTViMjMzNyJ9fX0=");
		ArrayList<String> BuyItemCustomLore = new ArrayList<>();
		BuyItemCustomLore.add(" ");
		BuyItemCustomLore.add("&fThông tin:");
		BuyItemCustomLore.add(" ");
		BuyItemCustomLore.add(" &7&oDùng để mua vật phẩm với");
		BuyItemCustomLore.add(" &7&osố lượng cụ thể.");
		BuyItemCustomLore.add(" ");
		BuyItemCustomLore.add(" &aClick để mua ");
		BuyItemCustomLore.add(" ");
		addlang("Shop.GuiPC.BuyItemCustom.Lore",BuyItemCustomLore);



		addlang("Shop.GuiPC.SellItemX1.Name","&cBán &fX1");
		addlang("Shop.GuiPC.SellItemX1.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTkzMmI5Yzc0NGIxYTgwYjEzOTQwYjc0NmM4MTFjMTUwN2Y3YWMyMDJhYTI2OGRhMDFiMzU0ZjU0NmJlYWY0NCJ9fX0=");
		ArrayList<String> SellItemX1Lore = new ArrayList<>();
		SellItemX1Lore.add(" ");
		SellItemX1Lore.add("&fThông tin:");
		SellItemX1Lore.add(" ");
		SellItemX1Lore.add(" &fGiá bán: <sell_price>");
		SellItemX1Lore.add(" &fSố lượng: &c<amount>");
		SellItemX1Lore.add(" ");
		SellItemX1Lore.add(" &fTổng nhận: <sum_price>");
		SellItemX1Lore.add(" ");
		SellItemX1Lore.add(" &eClick để bán");
		SellItemX1Lore.add(" ");
		addlang("Shop.GuiPC.SellItemX1.Lore",SellItemX1Lore);

		addlang("Shop.GuiPC.SellItemX16.Name","&cBán &fX16");
		addlang("Shop.GuiPC.SellItemX16.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTkzMmI5Yzc0NGIxYTgwYjEzOTQwYjc0NmM4MTFjMTUwN2Y3YWMyMDJhYTI2OGRhMDFiMzU0ZjU0NmJlYWY0NCJ9fX0=");
		ArrayList<String> SellItemX16Lore = new ArrayList<>();
		SellItemX16Lore.add(" ");
		SellItemX16Lore.add("&fThông tin:");
		SellItemX16Lore.add(" ");
		SellItemX16Lore.add(" &fGiá bán: <sell_price>");
		SellItemX16Lore.add(" &fSố lượng: &c<amount>");
		SellItemX16Lore.add(" ");
		SellItemX16Lore.add(" &fTổng nhận: <sum_price>");
		SellItemX16Lore.add(" ");
		SellItemX16Lore.add(" &eClick để bán");
		SellItemX16Lore.add(" ");
		addlang("Shop.GuiPC.SellItemX16.Lore",SellItemX16Lore);



		addlang("Shop.GuiPC.SellItemX32.Name","&cBán &fX32");
		addlang("Shop.GuiPC.SellItemX32.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTkzMmI5Yzc0NGIxYTgwYjEzOTQwYjc0NmM4MTFjMTUwN2Y3YWMyMDJhYTI2OGRhMDFiMzU0ZjU0NmJlYWY0NCJ9fX0=");
		ArrayList<String> SellItemX32Lore = new ArrayList<>();
		SellItemX32Lore.add(" ");
		SellItemX32Lore.add("&fThông tin:");
		SellItemX32Lore.add(" ");
		SellItemX32Lore.add(" &fGiá bán: <sell_price>");
		SellItemX32Lore.add(" &fSố lượng: &c<amount>");
		SellItemX32Lore.add(" ");
		SellItemX32Lore.add(" &fTổng nhận: <sum_price>");
		SellItemX32Lore.add(" ");
		SellItemX32Lore.add(" &eClick để bán");
		SellItemX32Lore.add(" ");
		addlang("Shop.GuiPC.SellItemX32.Lore",SellItemX32Lore);


		addlang("Shop.GuiPC.SellItemX64.Name","&cBán &fX64");
		addlang("Shop.GuiPC.SellItemX64.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTkzMmI5Yzc0NGIxYTgwYjEzOTQwYjc0NmM4MTFjMTUwN2Y3YWMyMDJhYTI2OGRhMDFiMzU0ZjU0NmJlYWY0NCJ9fX0=");
		ArrayList<String> SellItemX64Lore = new ArrayList<>();
		SellItemX64Lore.add(" ");
		SellItemX64Lore.add("&fThông tin:");
		SellItemX64Lore.add(" ");
		SellItemX64Lore.add(" &fGiá bán: <sell_price>");
		SellItemX64Lore.add(" &fSố lượng: &c<amount>");
		SellItemX64Lore.add(" ");
		SellItemX64Lore.add(" &fTổng nhận: <sum_price>");
		SellItemX64Lore.add(" ");
		SellItemX64Lore.add(" &eClick để bán");
		SellItemX64Lore.add(" ");
		addlang("Shop.GuiPC.SellItemX64.Lore",SellItemX64Lore);


		addlang("Shop.GuiPC.SellItemCustom.Name","&cBán Toàn Bộ");
		addlang("Shop.GuiPC.SellItemCustom.Type","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTkzMmI5Yzc0NGIxYTgwYjEzOTQwYjc0NmM4MTFjMTUwN2Y3YWMyMDJhYTI2OGRhMDFiMzU0ZjU0NmJlYWY0NCJ9fX0=");
		ArrayList<String> SellItemCustomLore = new ArrayList<>();
		SellItemCustomLore.add(" ");
		SellItemCustomLore.add("&fThông tin:");
		SellItemCustomLore.add(" ");
		SellItemCustomLore.add(" &7&oDùng để bán toàn bộ vật");
		SellItemCustomLore.add(" &7&ophẩm này trong kho đồ của bạn.");
		SellItemCustomLore.add(" ");
		SellItemCustomLore.add(" &fSố lượng đang có: &c<amount>");
		SellItemCustomLore.add(" &fTổng nhận: <sum_price>");
		SellItemCustomLore.add(" ");
		SellItemCustomLore.add(" &eClick để bán tất");
		SellItemCustomLore.add(" ");
		addlang("Shop.GuiPC.SellItemCustom.Lore",SellItemCustomLore);



		addlang("Shop.GuiAnvil.Title","&5Nhập số lượng cần mua:");

		addlang("Shop.Msg.NotEnoughMoney","&cBạn không có đủ <price> &cđể mua &fx<amount> <name> &c!");
		addlang("Shop.Msg.BuySuccess","&aBạn đã mua thành công &fx<amount> <name> &avới số tiền là <price> &a!");

		addlang("Shop.Msg.NotEnoughItem","&cBạn không có đủ &fx<amount> <name> &cđể bán !");
		addlang("Shop.Msg.SellSuccess","&aBạn đã bán thành công &fx<amount> <name> &avà thu về <price> &a!");
		addlang("Shop.Msg.SellAllFail","&cTrong túi đồ của bạn không có vật phẩm nào để bản tất cả !");

		addlang("Shop.Msg.SellGui","&aBạn đã bán thành công toàn bộ vật phẩm trên và thu về &f<price> &a!");
		addlang("Shop.Msg.SellGuiDeny","&cVật phẩm bạn bỏ vào không có giá trị hoặc không hỗ trợ mua bán !");
		addlang("Shop.Msg.SellGuiPerm","&cBạn không có quyền dùng bán nhanh, vui lòng nâng cấp Rank để mở !");
		try {
		DataFile.save(locate);
		Main.sendlog("&7(&dSimpShopPlus&7) &2Load lang config !");
	} catch (IOException e) {
		Main.sendlog("&7(&dSimpShopPlus&7) &4Fail to load lang config !");
		e.printStackTrace();
	}
    	
    }
    public static void save() {
        try {
    		DataFile.save(locate);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    public static List<String> getarray(String s) {
    	if(DataFile.contains(s)) {
    		List<String> ss = new ArrayList<String>();
    		for(String ok : DataFile.getStringList(s)) {
    			ss.add(Color.tran(ok));
    		}
    		return ss;
    	}
    	return null;
    }
    public static int getint(String s) {
    	if(DataFile.contains(s)) {
    		return DataFile.getInt(s);
    	}
    	return 0;
    }
    public static double getdoubl(String s) {
    	if(DataFile.contains(s)) {
    		return DataFile.getDouble(s);
    	}
    	return 0;
    }
    public static boolean getb(String s) {
    	if(DataFile.contains(s)) {
    		return DataFile.getBoolean(s);
    	}
    	return false;
    }
    public static String getlang(String s) {
    	if(DataFile.contains(s)) {
    		return Color.tran(DataFile.getString(s));
    	}
    	return s;
    }
    
	public static String getlang_nocolor(String s) {
	  	if(DataFile.contains(s)) {
    		return DataFile.getString(s);
    	}
    	return null;
	}
	
    public static void addlang(String s , double s2) {
    	if(!DataFile.contains(s)) {
    	DataFile.set(s, s2);
    	}
    }
    public static void addlang(String s , Boolean s2) {
    	if(!DataFile.contains(s)) {
    	DataFile.set(s, s2);
    	}
    }
    public static void reload(Player p) {
    	try {
    		Send.send("Plugin.Reload", p);
			DataFile.load(locate);
		} catch (IOException | InvalidConfigurationException e) {
			Send.send("Plugin.ReloadFail", p);
			e.printStackTrace();
		}
    }
    public static void addlang(String s , List<String> s2) {
    	if(!DataFile.contains(s)) {
    	DataFile.set(s, s2);
    	}
    }
    public static void setforcelang(String s , String s2) {
    	DataFile.set(s, s2);
    }
	public static void setforcelang(String s, double x) {
		DataFile.set(s, x);
	}
    public static void addlang(String s , String s2) {
    	if(!DataFile.contains(s)) {
    	DataFile.set(s, s2);
    	}
    }
    public static void addlang(String s , int s2) {
    	if(!DataFile.contains(s)) {
    	DataFile.set(s, s2);
    	}
    }


}
