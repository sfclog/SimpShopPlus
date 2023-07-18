package me.sfclog.simpshopplus.shopmanage.guipe;

import me.sfclog.simpshopplus.lang.Lang;
import me.sfclog.simpshopplus.shopmanage.ItemBuy;
import me.sfclog.simpshopplus.shopmanage.SellType;
import me.sfclog.simpshopplus.shopmanage.Shop;
import me.sfclog.simpshopplus.shopmanage.gui.GuiBuyItem;
import me.sfclog.simpshopplus.shopmanage.gui.GuiSellAndBuy;
import me.sfclog.simpshopplus.shopmanage.takeandgive.TakeAndGive;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.form.CustomForm;
import org.geysermc.cumulus.form.SimpleForm;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.List;

public class MCPE_GuiCustomBuyItem {


    public static void build(Player p, ItemBuy item, Shop shop, boolean b) {

        p.playSound(p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN,100,1);

        FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());

        if(player != null) {

            CustomForm.Builder form = CustomForm.builder();
            form.title(Lang.getlang("Shop.Gui.CustomBuyItem.Title"));

            List<String> list = Lang.getarray("Shop.Gui.CustomBuyItem.Info");

            list.replaceAll(a -> a.replace("<sell_price>", SellType.getPrice(item.getSellType(),item.getPriceSell() / item.getAmount())));
            list.replaceAll(a -> a.replace("<buy_price>", SellType.getPrice(item.getSellType(),item.getPriceBuy() / item.getAmount())));
            list.replaceAll(a -> a.replace("<name>", item.getName()));
            for(String info : list) {
                form.label(info);
            }
            form.input(Lang.getlang("Shop.Gui.CustomBuyItem.InputTitle"),Lang.getlang("Shop.Gui.CustomBuyItem.InputSub"));
            form.validResultHandler(response -> check_seller_amount(p,item,response.asInput()));
            form.closedOrInvalidResultHandler(() -> re_open(p,shop,item,b));
            player.sendForm(form);



        }

    }

    private static void re_open(Player p, Shop shop, ItemBuy item, boolean b) {
        if(b) {
        GuiSellAndBuy.build_pe(p, shop, item);
        } else {
        GuiBuyItem.build_pe(p, shop, item);
        }
    }


    private static void check_seller_amount(Player p, ItemBuy item, String text) {
        int i = text.matches("[0-9]+") ? Integer.parseInt(text) : 64;
        TakeAndGive.give_amount_item(p,item,i);
    }
}
