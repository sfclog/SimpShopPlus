package me.sfclog.simpshopplus.shopmanage;



public enum ShopMode {

    BUY,SELL,SELLANDBUY;


    public static ShopMode getMode(ItemBuy itembuy) {
        if(itembuy.getPriceSell() <= 0 && itembuy.getPriceBuy() > 0) {
            return  ShopMode.BUY;
        } else if(itembuy.getPriceBuy() <= 0 && itembuy.getPriceSell() > 0) {
            return  ShopMode.SELL;
        }
        return ShopMode.SELLANDBUY;
    }

}
