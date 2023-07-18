package me.sfclog.simpshopplus.shopmanage;

import me.sfclog.simpshopplus.utils.Color;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultConfig {

    public static File locate = new File("plugins/SimpShopPlus/Shop", "config_mac_dinh.yml");
    public static FileConfiguration DataFile = (FileConfiguration) YamlConfiguration.loadConfiguration(locate);





    public static void loadconfig() {
        addlang("Shop.Name","&5&lCửa Hàng Thử Nghiệm");
        addlang("Shop.Icon","STONE");
        addlang("Shop.Info","&7&oĐây là config mặc định của &dSimpShopPlus!");
        addlang("Shop.SlotPE",0);
        addlang("Shop.SlotPC",10);

        addlang("Items.Dirt.Name","&6Đất");
        addlang("Items.Dirt.Material","DIRT");
        addlang("Items.Dirt.Amount",64);
        addlang("Items.Dirt.PriceType","money");
        addlang("Items.Dirt.PriceSell",10);
        addlang("Items.Dirt.PriceBuy",100);


        addlang("Items.Stone.Name","&7Dá");
        addlang("Items.Stone.Material","DIRT");
        addlang("Items.Stone.Amount",16);
        addlang("Items.Stone.PriceType","money");
        addlang("Items.Stone.PriceSell",5);
        addlang("Items.Stone.PriceBuy",50);

        try {
            DataFile.save(locate);
            ShopManage.add(locate);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> getarray(String s) {
        if(DataFile.contains(s)) {
            List<String> ss = new ArrayList<String>();
            for(String ok : DataFile.getStringList(s)) {
                ss.add(Color.tran(ok));
            }
            return ss;
        }
        return null;
    }
    public static int getint(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getInt(s);
        }
        return 0;
    }
    public static double getdoubl(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getDouble(s);
        }
        return 0;
    }
    public static boolean getb(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getBoolean(s);
        }
        return false;
    }
    public static String getlang(String s) {
        if(DataFile.contains(s)) {
            return Color.tran(s);
        }
        return s;
    }
    public static void addlang(String s , double s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void addlang(String s , Boolean s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void addlang(String s , List<String> s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void setforcelang(String s , String s2) {
        DataFile.set(s, s2);
    }
    public static void setforcelang(String s, double x) {
        DataFile.set(s, x);
    }
    public static void addlang(String s , String s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void addlang(String s , int s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }


}
