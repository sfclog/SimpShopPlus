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

public class GuiBuyItem {


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


            form.button(Lang.getlang("Shop.GuiPE.Button.BuyX1").replace("<price>",SellType.getPrice(item.getSellType(),item.getPriceBuy())), FormImage.Type.URL, "https://cdn-icons-png.flaticon.com/512/4106/4106462.png");
            form.button(Lang.getlang("Shop.GuiPE.Button.BuyX16").replace("<price>",SellType.getPrice(item.getSellType(),item.getPriceBuy() * 16)), FormImage.Type.URL, "https://cdn-icons-png.flaticon.com/512/4106/4106462.png");
            form.button(Lang.getlang("Shop.GuiPE.Button.BuyX32").replace("<price>",SellType.getPrice(item.getSellType(),item.getPriceBuy() * 32)), FormImage.Type.URL, "https://cdn-icons-png.flaticon.com/512/4106/4106462.png");
            form.button(Lang.getlang("Shop.GuiPE.Button.BuyX64").replace("<price>",SellType.getPrice(item.getSellType(),item.getPriceBuy() * 64)), FormImage.Type.URL, "https://cdn-icons-png.flaticon.com/512/4106/4106462.png");
            form.button(Lang.getlang("Shop.GuiPE.Button.BuyCustom"), FormImage.Type.URL, "https://cdn-icons-png.flaticon.com/128/3523/3523887.png");


            form.content(BuildInfo.build(list));

            form.closedOrInvalidResultHandler(() ->  MCPE_ListItem.open_list_item(p,shop));
            form.validResultHandler(response -> action(p,response.clickedButtonId(),item,shop));

            player.sendForm(form);

        }

    }

    private static void action(Player p , int id,ItemBuy itembuy , Shop shop) {
        if(id == 0) {
            TakeAndGive.give_item(p,itembuy,1);
            build_pe(p,shop,itembuy);
        }
        if(id == 1) {
            TakeAndGive.give_item(p,itembuy,16);
            build_pe(p,shop,itembuy);
        }
        if(id == 2) {
            TakeAndGive.give_item(p,itembuy,32);
            build_pe(p,shop,itembuy);
        }
        if(id == 3) {
            TakeAndGive.give_item(p,itembuy,64);
            build_pe(p,shop,itembuy);
        }

        if(id == 4) {
            MCPE_GuiCustomBuyItem.build(p,itembuy,shop,false);
        }

    }

    public static void build(Player p, ItemBuy item) {
        p.playSound(p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN,100,1);
        Inventory inv = Bukkit.createInventory(null, 45, Lang.getlang("Shop.GuiPC.Buy"));

        ItemStack info = new ItemStack(item.getType(),item.getAmount());
        ItemMeta metaìno = info.getItemMeta();
        metaìno.setDisplayName(item.getName());
        info.setItemMeta(metaìno);
        inv.setItem(4,info);


        ItemStack itembuyx1 = TranItem.getIcon(Lang.getlang("Shop.GuiPC.BuyItemX1.Type"));
        ItemMeta metabuyx1 = itembuyx1.getItemMeta();
        metabuyx1.setDisplayName(Lang.getlang("Shop.GuiPC.BuyItemX1.Name"));
        List<String> lorebuyx1 = Lang.getarray("Shop.GuiPC.BuyItemX1.Lore");

        lorebuyx1.replaceAll(a -> a.replace("<buy_price>", SellType.getPrice(item.getSellType(),item.getPriceBuy())));
        lorebuyx1.replaceAll(a -> a.replace("<amount>",String.valueOf(item.getAmount())));
        lorebuyx1.replaceAll(a -> a.replace("<sum_price>",SellType.getPrice(item.getSellType(),item.getPriceBuy())));

        metabuyx1.setLore(lorebuyx1);
        itembuyx1.setItemMeta(metabuyx1);

        inv.setItem(20,itembuyx1);



        ItemStack itembuyX16 = TranItem.getIcon(Lang.getlang("Shop.GuiPC.BuyItemX16.Type"));
        itembuyX16.setAmount(16);
        ItemMeta metabuyX16 = itembuyX16.getItemMeta();
        metabuyX16.setDisplayName(Lang.getlang("Shop.GuiPC.BuyItemX16.Name"));
        List<String> lorebuyX16 = Lang.getarray("Shop.GuiPC.BuyItemX16.Lore");

        lorebuyX16.replaceAll(a -> a.replace("<buy_price>", SellType.getPrice(item.getSellType(),item.getPriceBuy())));
        lorebuyX16.replaceAll(a -> a.replace("<amount>",String.valueOf(item.getAmount() * 16)));
        lorebuyX16.replaceAll(a -> a.replace("<sum_price>",SellType.getPrice(item.getSellType(),item.getPriceBuy() * 16)));

        metabuyX16.setLore(lorebuyX16);
        itembuyX16.setItemMeta(metabuyX16);

        inv.setItem(21,itembuyX16);



        ItemStack itembuyX32 = TranItem.getIcon(Lang.getlang("Shop.GuiPC.BuyItemX32.Type"));
        itembuyX32.setAmount(32);
        ItemMeta metabuyX32 = itembuyX32.getItemMeta();
        metabuyX32.setDisplayName(Lang.getlang("Shop.GuiPC.BuyItemX32.Name"));
        List<String> lorebuyX32 = Lang.getarray("Shop.GuiPC.BuyItemX32.Lore");

        lorebuyX32.replaceAll(a -> a.replace("<buy_price>", SellType.getPrice(item.getSellType(),item.getPriceBuy())));
        lorebuyX32.replaceAll(a -> a.replace("<amount>",String.valueOf(item.getAmount() * 32)));
        lorebuyX32.replaceAll(a -> a.replace("<sum_price>",SellType.getPrice(item.getSellType(),item.getPriceBuy() * 32)));

        metabuyX32.setLore(lorebuyX32);
        itembuyX32.setItemMeta(metabuyX32);

        inv.setItem(22,itembuyX32);



        ItemStack itembuyX64 = TranItem.getIcon(Lang.getlang("Shop.GuiPC.BuyItemX64.Type"));
        itembuyX64.setAmount(64);
        ItemMeta metabuyX64 = itembuyX64.getItemMeta();
        metabuyX64.setDisplayName(Lang.getlang("Shop.GuiPC.BuyItemX64.Name"));
        List<String> lorebuyX64 = Lang.getarray("Shop.GuiPC.BuyItemX64.Lore");

        lorebuyX64.replaceAll(a -> a.replace("<buy_price>", SellType.getPrice(item.getSellType(),item.getPriceBuy())));
        lorebuyX64.replaceAll(a -> a.replace("<amount>",String.valueOf(item.getAmount() * 64)));
        lorebuyX64.replaceAll(a -> a.replace("<sum_price>",SellType.getPrice(item.getSellType(),item.getPriceBuy() * 64)));

        metabuyX64.setLore(lorebuyX64);
        itembuyX64.setItemMeta(metabuyX64);

        inv.setItem(23,itembuyX64);


        ItemStack itembuyCustom = TranItem.getIcon(Lang.getlang("Shop.GuiPC.BuyItemCustom.Type"));
        ItemMeta metabuyCustom = itembuyCustom.getItemMeta();
        metabuyCustom.setDisplayName(Lang.getlang("Shop.GuiPC.BuyItemCustom.Name"));
        List<String> lorebuyCustom = Lang.getarray("Shop.GuiPC.BuyItemCustom.Lore");
        metabuyCustom.setLore(lorebuyCustom);
        itembuyCustom.setItemMeta(metabuyCustom);

        inv.setItem(24,itembuyCustom);


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

