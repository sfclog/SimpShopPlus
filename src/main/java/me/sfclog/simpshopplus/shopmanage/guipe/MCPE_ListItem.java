package me.sfclog.simpshopplus.shopmanage.guipe;

import me.sfclog.simpshopplus.shopmanage.ItemBuy;
import me.sfclog.simpshopplus.shopmanage.SellType;
import me.sfclog.simpshopplus.shopmanage.Shop;
import me.sfclog.simpshopplus.shopmanage.ShopMode;
import me.sfclog.simpshopplus.shopmanage.gui.GuiBuyItem;
import me.sfclog.simpshopplus.shopmanage.gui.GuiSellAndBuy;
import me.sfclog.simpshopplus.shopmanage.gui.GuiSellItem;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.form.SimpleForm;
import org.geysermc.cumulus.util.FormImage;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.ArrayList;
import java.util.List;

public class MCPE_ListItem {

    public static void open_list_item(Player p, Shop shop) {

        p.playSound(p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN,100,1);



        FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
        List<ItemBuy> list = shop.getListItem();
        if(player != null) {
            SimpleForm.Builder form = SimpleForm.builder();
            form.title(shop.getShopName());
            form.content(shop.getShopInfo());


            for(ItemBuy buy : list) {
                if(buy != null) {
                    String url = "https://minecraftitemids.com/item/64/"+buy.getType().name()+".png";
                    form.button(buy.getName(), FormImage.Type.URL, url);
                }
            }
            form.closedOrInvalidResultHandler(() -> MCPE_MainShop.open_shoppe(p));
            form.validResultHandler(response -> build(p,shop,list.get(response.clickedButtonId())));
            player.sendForm(form);

        }
    }

    private static void build(Player p, Shop shop, ItemBuy itemBuy) {
        if(ShopMode.getMode(itemBuy) == ShopMode.SELLANDBUY) {
            GuiSellAndBuy.build_pe(p, shop, itemBuy);
        } else if(ShopMode.getMode(itemBuy) == ShopMode.SELL) {
            GuiSellItem.build_pe(p,shop,itemBuy);
        } else if(ShopMode.getMode(itemBuy) == ShopMode.BUY) {
            GuiBuyItem.build_pe(p,shop,itemBuy);
        }

    }

}
