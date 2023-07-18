package me.sfclog.simpshopplus.shopmanage;

import me.sfclog.simpshopplus.utils.GetHead;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Shop {


    public String shopname , shopinfo , icon;

    public int slotpc , slotpe;

    public ArrayList<ItemBuy> listitem;


    public Shop(String shopname , String icon , String info , int slotpc , int slotpe) {
        this.shopname = shopname;
        this.shopinfo = info;
        this.icon = icon;
        this.slotpc = slotpc;
        this.slotpe = slotpe;
        this.listitem = new ArrayList<>();
    }


    public String getShopName() {
        return shopname;
    }

    public String getShopInfo() {
        return shopinfo;
    }

    public int getSlotPC() {
        return slotpc;
    }
    public int getSlotPE() {
        return slotpe;
    }


    public void add(ItemBuy item) {
      this.listitem.add(item);
    }


    public String getBase() {
        return this.icon;
    }

    public List<ItemBuy> getListItem() {
        return this.listitem;
    }
}
