package me.sfclog.simpshopplus.shopmanage;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class ShopCache {

    public HashMap<Integer,Shop> map;

    public ShopCache() {
        this.map = new HashMap<>();
    }
    public void add(int i , Shop shop) {
        this.map.put(i,shop);
    }

    public Shop get(int i) {
        if(this.map.containsKey(i)) {
            return this.map.get(i);
        }
        return null;
    }

    public boolean have(int slot) {
        if(this.map.containsKey(slot)) {
            return  true;
        }
        return false;
    }
}
