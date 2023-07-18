package me.sfclog.simpshopplus.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ShopItemSellEvent extends Event {


    private static final HandlerList handlers = new HandlerList();

    public Player p;
    public double money;

    public ShopItemSellEvent(Player p, double money) {
       this.p = p;
       this.money = money;
    }

    public double getMoney() {
        return this.money;
    }


    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
