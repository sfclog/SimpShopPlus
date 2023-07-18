package me.sfclog.simpshopplus.shopmanage;

import me.sfclog.simpshopplus.Main;
import org.bukkit.Material;

public class ItemBuy {

    public Material m;
    double moneysell,moneybuy;

    int amount;

    public String name;

    public SellType selltype;

    public ItemBuy(String name , Material m , int amount  , SellType selltype , double moneysell , double moneybuy) {
        this.name = name;
        this.m = m;
        this.amount = amount;
        this.selltype = selltype;
        this.moneysell = moneysell;
        this.moneybuy = moneybuy;
    }


    public String getName() {
        return name;
    }
    public Material getType() {
        return  m;
    }
    public int getAmount() {
        return amount;
    }

    public double getPriceBuy() {
        return this.moneybuy <= 0 ? 0 : moneybuy;
    }
    public double getPriceSell() {
        return this.moneysell <= 0 ? 0 : moneysell;
    }



    public SellType getSellType() {
        return selltype;
    }
}
