package me.sfclog.simpshopplus.shopmanage.gui;

import me.sfclog.simpshopplus.lang.Lang;
import me.sfclog.simpshopplus.shopmanage.ItemBuy;
import me.sfclog.simpshopplus.shopmanage.SellType;
import me.sfclog.simpshopplus.shopmanage.ShopGuiManage;
import me.sfclog.simpshopplus.shopmanage.takeandgive.TakeAndGive;
import me.sfclog.simpshopplus.utils.IsChest;
import me.sfclog.simpshopplus.utils.Send;
import me.sfclog.simpshopplus.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.List;

public class GuiSell implements Listener {

    @EventHandler
    public void close(InventoryClickEvent e) {
        if (e.getInventory() != null && e.getView() != null && e.getView().getTitle() != null && e.getView().getTitle().equals(Lang.getlang("Shop.Gui.SellGui"))) {
            ItemStack item = e.getCurrentItem();
            if(IsChest.is_chest(item)) {
               e.setCancelled(true);
           }
        }
    }


    @EventHandler
    public void close(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        if (e.getInventory() != null && e.getView() != null && e.getView().getTitle() != null && e.getView().getTitle().equals(Lang.getlang("Shop.Gui.SellGui"))) {
            double endprice = 0;
            double exp = 0;
            double coin = 0;
            for (ItemStack item : e.getInventory()) {
                if (item != null) {
                    if (Util.check_custome_item(item) && ShopGuiManage.have_item(item.getType())) {
                        ItemBuy itembuy = ShopGuiManage.get_item(item.getType());
                        if (itembuy != null) {
                            double pricesell = itembuy.getPriceSell();
                            if (!(pricesell <= 0)) {
                                if (itembuy.getSellType() == SellType.MONEY) {
                                    double price = pricesell / itembuy.getAmount();
                                    double done = price * item.getAmount();
                                    if (!(done <= 0)) {
                                        endprice = endprice + done;
                                    }
                                } else if (itembuy.getSellType() == SellType.COIN) {
                                    coin = coin + pricesell;
                                } else if (itembuy.getSellType() == SellType.EXP) {
                                    exp = exp + pricesell;
                                }
                            }
                        }
                    } else {
                        add_to_player(p, item);
                    }
                }
            }
            if (!(endprice <= 0)) {
                Send.send(p, Lang.getlang("Shop.Msg.SellGui").replace("<price>", SellType.getPrice(SellType.MONEY, endprice)));
                TakeAndGive.give(p, SellType.MONEY, endprice);
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 100, 1);
            } else
            if (!(coin <= 0)) {
                Send.send(p, Lang.getlang("Shop.Msg.SellGui").replace("<price>", SellType.getPrice(SellType.COIN, coin)));
                TakeAndGive.give(p, SellType.COIN, coin);
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 100, 1);
            } else
            if (!(exp <= 0)) {
                Send.send(p, Lang.getlang("Shop.Msg.SellGui").replace("<price>", SellType.getPrice(SellType.EXP, exp)));
                TakeAndGive.give(p, SellType.EXP, exp);
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 100, 1);
            } else {
                Send.send(p, Lang.getlang("Shop.Msg.SellGuiDeny"));
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
            }

        }
    }

    //import me.sfclog.simpshopplus.shopmanage.ShopGuiManage;
    //import me.sfclog.simpshopplus.shopmanage.ItemBuy;

    // ItemBuy itembuy = ShopGuiManage.get_item(item.getType());
    // double price_sell = itembuy.getPriceSell();

    // double money = price_sell * item.getAmount();




    public static void sell_api(Player p , Chest chest) {
        double endprice = 0;
        double exp = 0;
        double coin = 0;
        for (ItemStack item : chest.getInventory().getContents()) {
                if (item != null && Util.check_custome_item(item) && ShopGuiManage.have_item(item.getType())) {
                ItemBuy itembuy = ShopGuiManage.get_item(item.getType());

                if (itembuy != null) {
                    double pricesell = itembuy.getPriceSell();
                    if (!(pricesell <= 0)) {
                        if (itembuy.getSellType() == SellType.MONEY) {
                            double price = pricesell / itembuy.getAmount();
                            double done = price * item.getAmount();
                            if (!(done <= 0)) {
                                endprice = endprice + done;
                                item.setAmount(0);
                            }
                        } else if (itembuy.getSellType() == SellType.COIN) {
                            coin = coin + pricesell;
                            item.setAmount(0);
                        } else if (itembuy.getSellType() == SellType.EXP) {
                            exp = exp + pricesell;
                            item.setAmount(0);
                        }

                    }
                }
            }
        }


        if (!(endprice <= 0)) {
            Send.send(p, Lang.getlang("Shop.Msg.SellGui").replace("<price>", SellType.getPrice(SellType.MONEY, endprice)));
            TakeAndGive.give(p,SellType.MONEY,endprice);
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES,100,1);

        }
        if (!(coin <= 0)) {
            Send.send(p, Lang.getlang("Shop.Msg.SellGui").replace("<price>", SellType.getPrice(SellType.COIN, coin)));
            TakeAndGive.give(p,SellType.COIN,coin);
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES,100,1);
        }
        if (!(exp <= 0)) {
            Send.send(p, Lang.getlang("Shop.Msg.SellGui").replace("<price>", SellType.getPrice(SellType.EXP, exp)));
            TakeAndGive.give(p,SellType.EXP,exp);
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES,100,1);
        }


    }





    public static void add_to_player(Player p , ItemStack item) {
        if(p.getInventory().firstEmpty() != -1) {
          p.getInventory().addItem(item);
        } else {
           p.getWorld().dropItem(p.getLocation(),item);
        }
    }

    public static void send(Player p) {
        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE,100,1);
        Inventory inv = Bukkit.createInventory(null,getPerm(p), Lang.getlang("Shop.Gui.SellGui"));
        p.openInventory(inv);
    }

    public static int getPerm(Player p) {
        if(p.hasPermission("simpshopplus.sellgui.6")) {
            return 9 * 6;
        }
        if(p.hasPermission("simpshopplus.sellgui.5")) {
            return 9 * 5;
        }
        if(p.hasPermission("simpshopplus.sellgui.4")) {
            return 9 * 4;
        }
        if(p.hasPermission("simpshopplus.sellgui.3")) {
            return 9 * 3;
        }
        if(p.hasPermission("simpshopplus.sellgui.2")) {
            return 9 * 2;
        }
        if(p.hasPermission("simpshopplus.sellgui.1")) {
            return 9 * 1;
        }
        return 9;
    }
}
