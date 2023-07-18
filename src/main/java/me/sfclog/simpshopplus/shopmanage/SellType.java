package me.sfclog.simpshopplus.shopmanage;

import me.sfclog.simpshopplus.lang.Lang;

public enum SellType {

    MONEY,COIN,EXP;

    public static String getPrice(SellType type , double d) {

        if(type == SellType.MONEY) {
            return  Lang.getlang("Shop.Price.Money").replace("<price>",String.valueOf(d));
        } else  if(type == SellType.COIN) {
            return Lang.getlang("Shop.Price.Coin").replace("<price>",String.valueOf((int)d));
        }
        return Lang.getlang("Shop.Price.Exp").replace("<price>",String.valueOf(d));
    }

}
