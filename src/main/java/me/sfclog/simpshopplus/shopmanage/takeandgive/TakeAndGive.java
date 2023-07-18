package me.sfclog.simpshopplus.shopmanage.takeandgive;


import me.sfclog.simpshopplus.Main;
import me.sfclog.simpshopplus.event.ShopItemBuyEvent;
import me.sfclog.simpshopplus.event.ShopItemSellEvent;
import me.sfclog.simpshopplus.lang.Lang;
import me.sfclog.simpshopplus.shopmanage.ItemBuy;
import me.sfclog.simpshopplus.shopmanage.SellType;
import me.sfclog.simpshopplus.utils.ExperienceManager;
import me.sfclog.simpshopplus.utils.Send;
import me.sfclog.simpshopplus.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class TakeAndGive {


    public static void give(Player p, SellType sellType, double money) {
        if(sellType == SellType.MONEY) {
            Main.econ.depositPlayer(p, money);
            ShopItemSellEvent e = new ShopItemSellEvent(p, money);
            Bukkit.getPluginManager().callEvent(e);
        } else  if(sellType == SellType.COIN) {
            Main.ppAPI.give(p.getUniqueId(),(int) money);
        } else  if(sellType == SellType.EXP) {
            ExperienceManager expMan = new ExperienceManager(p);
            expMan.changeExp(money);
        }
    }


    private static boolean take(Player p, SellType sellType, double money) {
        if(sellType == SellType.MONEY) {
            Main.econ.withdrawPlayer(p,money);
            ShopItemBuyEvent e = new ShopItemBuyEvent(p, money);
            Bukkit.getPluginManager().callEvent(e);
            return  true;
        } else  if(sellType == SellType.COIN) {
            if(Main.ppAPI != null && Main.ppAPI.take(p.getUniqueId(),(int) money)) {
                return true;
            }
        } else if(sellType == SellType.EXP) {
            ExperienceManager expMan = new ExperienceManager(p);
            expMan.changeExp(-money);
            return true;
        }
        return false;
    }

    public static void take_all(Player p , ItemBuy itembuy) {
        int amount = Util.getAll(p,itembuy.getType());

        double price = itembuy.getPriceSell() / itembuy.getAmount();

        double money = price * amount;

        if(!(amount <= 0)) {
            Util.removeItems(p, itembuy.getType(), amount);

            give(p,itembuy.getSellType(),money);
            Send.send(p, Lang.getlang("Shop.Msg.SellSuccess")
                    .replace("<price>", SellType.getPrice(itembuy.getSellType(), money))
                    .replace("<amount>", String.valueOf(amount))
                    .replace("<name>", itembuy.getName())
            );
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE,100,1);

            if(itembuy.getSellType() == SellType.MONEY) {

            }
        } else {
            Send.send(p,Lang.getlang("Shop.Msg.SellAllFail"));
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO,100,1);
        }



    }
    public static void take_item(Player p , ItemBuy itembuy, int x) {

        double price = itembuy.getPriceSell() * x;

        int amount = itembuy.getAmount() * x;
        if(Util.hasItem(p,itembuy.getType(),amount)) {
            Util.removeItems(p, itembuy.getType(),amount);

            give(p,itembuy.getSellType(),price);
            Send.send(p, Lang.getlang("Shop.Msg.SellSuccess")
                    .replace("<price>", SellType.getPrice(itembuy.getSellType(),price))
                    .replace("<amount>",String.valueOf(amount))
                    .replace("<name>",itembuy.getName())
            );


            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE,100,1);

        } else {
            Send.send(p, Lang.getlang("Shop.Msg.NotEnoughItem")
                    .replace("<amount>",String.valueOf(amount))
                    .replace("<name>",itembuy.getName())
            );
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO,100,1);
        }

    }


    public static void give_amount_item(Player p, ItemBuy itembuy, int amount) {

        double basicprice = itembuy.getPriceBuy() / itembuy.getAmount();
        double price = basicprice * amount;
        if(check(p,itembuy.getSellType(),price)) {
           if(take(p, itembuy.getSellType(),price)) {
               Util.giveitem(p, itembuy.getType(), amount);
               Send.send(p, Lang.getlang("Shop.Msg.BuySuccess")
                       .replace("<price>", SellType.getPrice(itembuy.getSellType(), price))
                       .replace("<amount>", String.valueOf(amount))
                       .replace("<name>", itembuy.getName())
               );
               p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);



           } else {
               Send.send(p, Lang.getlang("Shop.Msg.NotEnoughMoney")
                       .replace("<price>", SellType.getPrice(itembuy.getSellType(),price))
                       .replace("<amount>",String.valueOf(amount))
                       .replace("<name>",itembuy.getName())
               );
               p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO,100,1);
           }
        } else {
            Send.send(p, Lang.getlang("Shop.Msg.NotEnoughMoney")
                    .replace("<price>", SellType.getPrice(itembuy.getSellType(),price))
                    .replace("<amount>",String.valueOf(amount))
                    .replace("<name>",itembuy.getName())
            );
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO,100,1);
        }
    }

    private static boolean check(Player p, SellType sellType, double price) {

        if(sellType == SellType.MONEY) {
            double money = Main.econ.getBalance(p);
            if (money >= price) {
                return true;
            }
        } else if(sellType == SellType.COIN) {
            if(Main.ppAPI != null) {
                int coin = Main.ppAPI.look(p.getUniqueId());
                if (coin >= (int) price) {
                    return true;
                }
            }
        } else if(sellType == SellType.EXP) {
            ExperienceManager expMan = new ExperienceManager(p);
            if (expMan.hasExp(price)) {
                return true;
            }
        }
        return false;

    }


    public static void give_item(Player p , ItemBuy itembuy , int x) {
        double money = Main.econ.getBalance(p);
        double price = itembuy.getPriceBuy() * x;
        int amount = itembuy.getAmount() * x;
        if(money >= price) {
            if(take(p, itembuy.getSellType(),price)) {
                Util.giveitem(p, itembuy.getType(), amount);
                Send.send(p, Lang.getlang("Shop.Msg.BuySuccess")
                        .replace("<price>", SellType.getPrice(itembuy.getSellType(), price))
                        .replace("<amount>", String.valueOf(amount))
                        .replace("<name>", itembuy.getName())
                );
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);


            } else {
                Send.send(p, Lang.getlang("Shop.Msg.NotEnoughMoney")
                        .replace("<price>", SellType.getPrice(itembuy.getSellType(),price))
                        .replace("<amount>",String.valueOf(amount))
                        .replace("<name>",itembuy.getName())
                );
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO,100,1);
            }
        } else {
            Send.send(p, Lang.getlang("Shop.Msg.NotEnoughMoney")
                    .replace("<price>", SellType.getPrice(itembuy.getSellType(),price))
                    .replace("<amount>",String.valueOf(amount))
                    .replace("<name>",itembuy.getName())
            );
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO,100,1);
        }
    }


}
