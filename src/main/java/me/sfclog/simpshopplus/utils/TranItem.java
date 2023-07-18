package me.sfclog.simpshopplus.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TranItem {

    public static ItemStack getIcon(String base) {
        if(base.contains("=")) {
            return GetHead.getHead(base);
        } else if(Material.valueOf(base.toUpperCase()) != null) {
            return new ItemStack(Material.valueOf(base.toUpperCase()));
        }
        return new ItemStack(Material.AIR);
    }
}
