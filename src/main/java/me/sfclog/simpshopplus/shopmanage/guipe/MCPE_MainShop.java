package me.sfclog.simpshopplus.shopmanage.guipe;

import me.sfclog.simpshopplus.lang.Lang;
import me.sfclog.simpshopplus.shopmanage.Shop;
import me.sfclog.simpshopplus.shopmanage.ShopGuiManage;
import me.sfclog.simpshopplus.utils.TranItem;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.geysermc.cumulus.form.SimpleForm;
import org.geysermc.cumulus.util.FormImage;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MCPE_MainShop {

    public static void open_shoppe(Player p) {
        p.playSound(p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN,100,1);
        if(p != null) {

            List<Shop> listshop = new ArrayList<>();

            FloodgatePlayer player = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
            if(player != null) {
                SimpleForm.Builder form = SimpleForm.builder();

                form.title(Lang.getlang("Shop.GuiPE.Title"));
                form.content(Lang.getlang("Shop.GuiPE.Info"));
                for(Shop shop :  Fix(ShopGuiManage.getAllShop_PE())) {
                    if(shop != null) {
                        ItemStack item = TranItem.getIcon(shop.getBase());
                        if(item != null && item.getType() != null) {
                            String url = "https://minecraftitemids.com/item/64/"+item.getType().name()+".png";
                            form.button(shop.getShopName(), FormImage.Type.URL, url);
                        }
                        listshop.add(shop);
                    }

                }
                form.validResultHandler(response -> MCPE_ListItem.open_list_item(p,listshop.get(response.clickedButtonId())));
                player.sendForm(form);
            }

        }

    }

    private static List<Shop> Fix(Collection<Shop> allShop_pe) {
        List<Shop> shop = new ArrayList<>();
        for(Shop ok : allShop_pe) {
            shop.add(ok);
        }
        Collections.reverse(shop);
        return  shop;

    }


}
