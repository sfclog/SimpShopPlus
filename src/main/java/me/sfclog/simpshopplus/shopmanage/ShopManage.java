package me.sfclog.simpshopplus.shopmanage;

import me.sfclog.simpshopplus.Main;

import java.io.File;
import java.util.HashSet;

public class ShopManage {

    public static File loc = new File("plugins/SimpShopPlus/Shop");

    public static HashSet<File> configshop = new HashSet<>();


    public static void reload() {
        configshop.clear();
        load();
    }


    public static void load() {
        if(!loc.mkdir()) {
            loc.mkdir();
        }
        for(File file : loc.getAbsoluteFile().listFiles()) {
            if(file != null && file.getName() != null && file.getName().contains(".yml")) {
                Main.sendlog("&7(&dSimpShopPlus&7) §aLoad shop config §f" + file.getName() + " §a!");
                add(file);
            }
        }
        if(configshop.isEmpty()) {
            Main.sendlog("&7(&dSimpShopPlus&7) §eLoad shop config default !");
            DefaultConfig.loadconfig();
        }

        ShopGuiManage.load_config_and_setup_item_in_shop();
    }

    public static HashSet<File> getConfigShop() {
        return configshop;
    }
    public static void add(File file) {
        configshop.add(file);
    }
}
