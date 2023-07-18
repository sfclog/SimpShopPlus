package me.sfclog.simpshopplus.shopmanage.gui;

import me.sfclog.simpshopplus.lang.Lang;
import me.sfclog.simpshopplus.shopmanage.ItemBuy;
import me.sfclog.simpshopplus.shopmanage.SellType;
import me.sfclog.simpshopplus.shopmanage.Shop;
import me.sfclog.simpshopplus.shopmanage.guipe.MCPE_GuiCustomBuyItem;
import me.sfclog.simpshopplus.shopmanage.guipe.MCPE_ListItem;
import me.sfclog.simpshopplus.shopmanage.takeandgive.TakeAndGive;
import me.sfclog.simpshopplus.utils.BuildInfo;
import me.sfclog.simpshopplus.utils.TranItem;
import me.sfclog.simpshopplus.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.geysermc.cumulus.form.SimpleForm;
import org.geysermc.cumulus.util.FormImage;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.List;

public class GuiSellItem {


    public static void build_pe(Player p , Shop shop , ItemBuy item) {

        p.playSound(p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN,100,1);

        FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
        if(player != null) {
            SimpleForm.Builder form = SimpleForm.builder();
            form.title(Lang.getlang("Shop.GuiPE.SellAndBuy.Title"));

            List<String> list = Lang.getarray("Shop.GuiPE.SellAndBuy.Info");

            list.replaceAll(a -> a.replace("<sell_price>", SellType.getPrice(item.getSellType(),item.getPriceSell())));
            list.replaceAll(a -> a.replace("<buy_price>", SellType.getPrice(item.getSellType(),item.getPriceBuy())));
            list.replaceAll(a -> a.replace("<amount>",String.valueOf(item.getAmount())));
            list.replaceAll(a -> a.replace("<name>", item.getName()));

            form.button(Lang.getlang("Shop.GuiPE.Button.SellX1").replace("<price>",SellType.getPrice(item.getSellType(),item.getPriceSell())), FormImage.Type.URL, "https://cdn-icons-png.flaticon.com/128/4106/4106426.png");
            form.button(Lang.getlang("Shop.GuiPE.Button.SellX16").replace("<price>",SellType.getPrice(item.getSellType(),item.getPriceSell() * 16)), FormImage.Type.URL, "https://cdn-icons-png.flaticon.com/128/4106/4106426.png");
            form.button(Lang.getlang("Shop.GuiPE.Button.SellX32").replace("<price>",SellType.getPrice(item.getSellType(),item.getPriceSell() * 32)), FormImage.Type.URL, "https://cdn-icons-png.flaticon.com/128/4106/4106426.png");
            form.button(Lang.getlang("Shop.GuiPE.Button.SellX64").replace("<price>",SellType.getPrice(item.getSellType(),item.getPriceSell() * 64)), FormImage.Type.URL, "https://cdn-icons-png.flaticon.com/128/4106/4106426.png");
            form.button(Lang.getlang("Shop.GuiPE.Button.SellCustom"), FormImage.Type.URL, "https://cdn-icons-png.flaticon.com/128/8064/8064489.png");


            form.content(BuildInfo.build(list));

            form.closedOrInvalidResultHandler(() ->  MCPE_ListItem.open_list_item(p,shop));
            form.validResultHandler(response -> action(p,response.clickedButtonId(),item,shop));

            player.sendForm(form);

        }

    }

    private static void action(Player p , int id,ItemBuy itembuy , Shop shop) {
        if(id == 0) {
            TakeAndGive.take_item(p,itembuy,1);
            build_pe(p,shop,itembuy);
        }
        if(id == 1) {
            TakeAndGive.take_item(p,itembuy,16);
            build_pe(p,shop,itembuy);
        }
        if(id == 2) {
            TakeAndGive.take_item(p,itembuy,32);
            build_pe(p,shop,itembuy);
        }
        if(id == 3) {
            TakeAndGive.take_item(p,itembuy,64);
            build_pe(p,shop,itembuy);
        }
        if(id == 4) {
            TakeAndGive.take_all(p,itembuy);
            build_pe(p,shop,itembuy);
        }

    }


    public static void build(Player p, ItemBuy item) {

        p.playSound(p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN,100,1);

        Inventory inv = Bukkit.createInventory(null, 45, Lang.getlang("Shop.GuiPC.Sell"));

        ItemStack info = new ItemStack(item.getType(),item.getAmount());
        ItemMeta metaìno = info.getItemMeta();
        metaìno.setDisplayName(item.getName());
        info.setItemMeta(metaìno);
        inv.setItem(4,info);



        ItemStack itemsellx1 = TranItem.getIcon(Lang.getlang("Shop.GuiPC.SellItemX1.Type"));
        ItemMeta metasellx1 = itemsellx1.getItemMeta();
        metasellx1.setDisplayName(Lang.getlang("Shop.GuiPC.SellItemX1.Name"));
        List<String> loresellx1 = Lang.getarray("Shop.GuiPC.SellItemX1.Lore");

        loresellx1.replaceAll(a -> a.replace("<sell_price>", SellType.getPrice(item.getSellType(),item.getPriceSell())));
        loresellx1.replaceAll(a -> a.replace("<amount>",String.valueOf(item.getAmount())));
        loresellx1.replaceAll(a -> a.replace("<sum_price>",SellType.getPrice(item.getSellType(),item.getPriceSell())));

        metasellx1.setLore(loresellx1);
        itemsellx1.setItemMeta(metasellx1);

        inv.setItem(20,itemsellx1);



        ItemStack itemsellX16 = TranItem.getIcon(Lang.getlang("Shop.GuiPC.SellItemX16.Type"));
        itemsellX16.setAmount(16);
        ItemMeta metasellX16 = itemsellX16.getItemMeta();
        metasellX16.setDisplayName(Lang.getlang("Shop.GuiPC.SellItemX16.Name"));
        List<String> loresellX16 = Lang.getarray("Shop.GuiPC.SellItemX16.Lore");

        loresellX16.replaceAll(a -> a.replace("<sell_price>", SellType.getPrice(item.getSellType(),item.getPriceSell())));
        loresellX16.replaceAll(a -> a.replace("<amount>",String.valueOf(item.getAmount() * 16)));
        loresellX16.replaceAll(a -> a.replace("<sum_price>",SellType.getPrice(item.getSellType(),item.getPriceSell() * 16)));

        metasellX16.setLore(loresellX16);
        itemsellX16.setItemMeta(metasellX16);

        inv.setItem(21,itemsellX16);



        ItemStack itemsellX32 = TranItem.getIcon(Lang.getlang("Shop.GuiPC.SellItemX32.Type"));
        itemsellX32.setAmount(32);
        ItemMeta metasellX32 = itemsellX32.getItemMeta();
        metasellX32.setDisplayName(Lang.getlang("Shop.GuiPC.SellItemX32.Name"));
        List<String> loresellX32 = Lang.getarray("Shop.GuiPC.SellItemX32.Lore");

        loresellX32.replaceAll(a -> a.replace("<sell_price>", SellType.getPrice(item.getSellType(),item.getPriceSell())));
        loresellX32.replaceAll(a -> a.replace("<amount>",String.valueOf(item.getAmount() * 32)));
        loresellX32.replaceAll(a -> a.replace("<sum_price>",SellType.getPrice(item.getSellType(),item.getPriceSell() * 32)));

        metasellX32.setLore(loresellX32);
        itemsellX32.setItemMeta(metasellX32);

        inv.setItem(22,itemsellX32);



        ItemStack itemsellX64 = TranItem.getIcon(Lang.getlang("Shop.GuiPC.SellItemX64.Type"));
        itemsellX64.setAmount(64);
        ItemMeta metasellX64 = itemsellX64.getItemMeta();
        metasellX64.setDisplayName(Lang.getlang("Shop.GuiPC.SellItemX64.Name"));
        List<String> loresellX64 = Lang.getarray("Shop.GuiPC.SellItemX64.Lore");

        loresellX64.replaceAll(a -> a.replace("<sell_price>", SellType.getPrice(item.getSellType(),item.getPriceSell())));
        loresellX64.replaceAll(a -> a.replace("<amount>",String.valueOf(item.getAmount() * 64)));
        loresellX64.replaceAll(a -> a.replace("<sum_price>",SellType.getPrice(item.getSellType(),item.getPriceSell() * 64)));

        metasellX64.setLore(loresellX64);
        itemsellX64.setItemMeta(metasellX64);

        inv.setItem(23,itemsellX64);


        int amount = Util.getAll(p,item.getType());
        double price = item.getPriceSell() / item.getAmount();
        double money = price * amount;

        ItemStack itemsellCustom = TranItem.getIcon(Lang.getlang("Shop.GuiPC.SellItemCustom.Type"));
        ItemMeta metasellCustom = itemsellCustom.getItemMeta();
        metasellCustom.setDisplayName(Lang.getlang("Shop.GuiPC.SellItemCustom.Name"));
        List<String> loresellCustom = Lang.getarray("Shop.GuiPC.SellItemCustom.Lore");

        loresellCustom.replaceAll(a -> a.replace("<amount>",String.valueOf(amount)));
        loresellCustom.replaceAll(a -> a.replace("<sum_price>", SellType.getPrice(item.getSellType(), money)));

        metasellCustom.setLore(loresellCustom);
        itemsellCustom.setItemMeta(metasellCustom);

        inv.setItem(24,itemsellCustom);





        ItemStack item1 = TranItem.getIcon(Lang.getlang("Shop.GuiPC.QuitItem.Type"));
        ItemMeta meta = item1.getItemMeta();
        meta.setDisplayName(Lang.getlang("Shop.GuiPC.QuitItem.Name"));
        List<String> lore = Lang.getarray("Shop.GuiPC.QuitItem.Lore");
        meta.setLore(lore);
        item1.setItemMeta(meta);

        inv.setItem(40,item1);





        p.openInventory(inv);

    }
}
