package me.sfclog.simpshopplus.utils;

import org.bukkit.Material;

public class MaterialAutoDetect {


    public static Material get(String name) {

        if (name != null) {

            String material = name.toUpperCase();
            if(material != null) {
                Material m = Material.valueOf(material);
                if(m != null) {
                    return m;
                } else {
                    for(Material ma : Material.values()) {
                        if(ma != null && ma.name().contains(name)) {
                            return ma;
                        }
                    }
                }
            }
        }

        return Material.BARRIER;

    }

}
