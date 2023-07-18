package me.sfclog.simpshopplus.shopmanage;

import me.sfclog.simpshopplus.Main;
import me.sfclog.simpshopplus.utils.ConfigGet;
import me.sfclog.simpshopplus.utils.MaterialAutoDetect;
import org.bukkit.Material;

import java.io.File;
import java.util.*;

public class ShopGuiManage {


    public static HashSet<Shop> listshop = new HashSet<>();

    public static HashSet<String> listshopname = new HashSet<String>();


    public static HashSet<Shop> getAllShop() {
        return listshop;
    }

    public static Collection<Shop> getAllShop_PE() {
        HashMap<Integer,Shop> map = new HashMap<>();
        for(Shop blank : listshop) {
            map.put(blank.getSlotPE(), blank);
        }
        Map<Integer, Shop> treeMap = new TreeMap<Integer, Shop>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                 }

         });


        treeMap.putAll(map);
        return treeMap.values();
    }


    public static boolean have_item(Material m) {
     for(Shop shop : listshop) {
         if(shop != null) {
            for(ItemBuy item : shop.getListItem()) {
                if(item != null) {
                    if(item.getType() != null && item.getType() == m) {
                        return  true;
                    }
                }
            }
         }
     }
     return false;
    }


    public static ItemBuy get_item(Material m) {
        for (Shop shop : listshop) {
            if (shop != null) {
                for (ItemBuy item : shop.getListItem()) {
                    if (item != null) {
                        if (item.getType() != null && item.getType() == m) {
                            return item;
                        }
                    }
                }
            }
        }
        return null;
    }


    public static void load_config_and_setup_item_in_shop() {
        listshop.clear();
        listshopname.clear();


        for(File file : ShopManage.getConfigShop()) {
            if(file != null) {

                //lấy tên , thông tin và slot id
                String shopname = ConfigGet.getlang(file,"Shop.Name");
                listshopname.add(shopname);

                String shopinfo = ConfigGet.getlang(file,"Shop.Info");

                String shopicon = ConfigGet.getlang(file,"Shop.Icon");

                int slotpc = ConfigGet.getint(file,"Shop.SlotPC");

                int slotpe = ConfigGet.getint(file,"Shop.SlotPE");


                //khởi tạo hàm shop
                Shop shop = new Shop(shopname,shopicon,shopinfo,slotpc,slotpe);

                //thêm vật phẩm vào mảng shop

                int ite = 0;
                if (ConfigGet.getData(file).getConfigurationSection("Items") != null) {
                    for (String item : ConfigGet.getData(file).getConfigurationSection("Items").getKeys(false)) {
                        String name = ConfigGet.getlang(file,"Items."+item+".Name");
                        Material type = MaterialAutoDetect.get(ConfigGet.getlang(file, "Items." + item + ".Material").toUpperCase());
                        SellType pricetype = SellType.valueOf(ConfigGet.getlang(file,"Items."+item+".PriceType").toUpperCase());
                        int i = ConfigGet.getint(file,"Items."+item+".Amount");
                        double pricesell = ConfigGet.getdoubl(file,"Items."+item+".PriceSell");
                        double pricebuy = ConfigGet.getdoubl(file,"Items."+item+".PriceBuy");
                        ItemBuy itemb = new ItemBuy(name,type,i,pricetype,pricesell,pricebuy);
                        shop.add(itemb);
                        ite++;
                    }
                }
                Main.sendlog("&7(&dSimpShopPlus&7) §aLoad &f"+ ite +" item &afrom shop config §f" + file.getName() + " §a!");

                listshop.add(shop);
            }
        }
    }

    public static boolean have(String title) {
        if(listshopname.contains(title)) {
            return true;
        }
        return false;
    }


}
