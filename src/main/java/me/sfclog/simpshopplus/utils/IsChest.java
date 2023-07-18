package me.sfclog.simpshopplus.utils;

import org.bukkit.inventory.ItemStack;

public class IsChest {


    public static boolean is_chest(ItemStack item) {
        if(item != null && item.getType() != null) {
            if(item.getType().name().contains("CHEST")) {
                return true;
            }
            if(item.getType().name().contains("BOX")) {
                return true;
            }
            if(item.getType().name().contains("BARREL")) {
                return true;
            }
        }
        return false;
    }
}
