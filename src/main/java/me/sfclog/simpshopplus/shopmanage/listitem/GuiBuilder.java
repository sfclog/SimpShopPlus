package me.sfclog.simpshopplus.shopmanage.listitem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.sfclog.simpshopplus.lang.Lang;
import me.sfclog.simpshopplus.shopmanage.ItemBuy;
import me.sfclog.simpshopplus.shopmanage.SellType;
import me.sfclog.simpshopplus.shopmanage.Shop;
import me.sfclog.simpshopplus.shopmanage.ShopMode;
import me.sfclog.simpshopplus.utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiBuilder {
    public Player p;

    public Inventory inv;

    public HashMap<Integer, ItemBuy> listitem;

    public List<Integer> blackslot;

    public GuiBuilder(Player p, Shop shop, int number) {
        this.p = p;
        this.inv = Bukkit.createInventory(null, 54, shop.getShopName());
        this.listitem = new HashMap<>();
        this.blackslot = InventoryUtils.getSlot();
    }

    public void add(ItemBuy itembuy) {
        if(!blackslot.isEmpty()) {
            if (ShopMode.getMode(itembuy) == ShopMode.BUY) {
                int sl = blackslot.get(0);
                ItemStack item = new ItemStack(itembuy.getType(), itembuy.getAmount());
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(itembuy.getName());
                List<String> lore = Lang.getarray("Shop.GuiPC.ItemInfoOnlyBuy.Lore");
                lore.replaceAll(a -> a.replace("<amount>", String.valueOf(itembuy.getAmount())).replace("<pricebuy>", SellType.getPrice(itembuy.getSellType(), itembuy.getPriceBuy())));
                meta.setLore(lore);
                item.setItemMeta(meta);
                this.listitem.put(sl, itembuy);
                this.inv.setItem(sl, item);
                blackslot.removeIf(a -> a == sl);
            } else if (ShopMode.getMode(itembuy) == ShopMode.SELL) {
                int sl = blackslot.get(0);
                ItemStack item = new ItemStack(itembuy.getType(), itembuy.getAmount());
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(itembuy.getName());
                List<String> lore = Lang.getarray("Shop.GuiPC.ItemInfoOnlySell.Lore");
                lore.replaceAll(a -> a.replace("<amount>", String.valueOf(itembuy.getAmount()))
                        .replace("<pricebuy>", SellType.getPrice(itembuy.getSellType(), itembuy.getPriceBuy()))
                        .replace("<pricesell>", SellType.getPrice(itembuy.getSellType(), itembuy.getPriceSell())));
                meta.setLore(lore);
                item.setItemMeta(meta);
                this.listitem.put(sl, itembuy);
                this.inv.setItem(sl, item);
                blackslot.removeIf(a -> a == sl);
            } else if (ShopMode.getMode(itembuy) == ShopMode.SELLANDBUY) {
                int sl = blackslot.get(0);
                ItemStack item = new ItemStack(itembuy.getType(), itembuy.getAmount());
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(itembuy.getName());
                List<String> lore = Lang.getarray("Shop.GuiPC.ItemInfo.Lore");
                lore.replaceAll(a -> a.replace("<amount>", String.valueOf(itembuy.getAmount())).replace("<pricebuy>", SellType.getPrice(itembuy.getSellType(), itembuy.getPriceBuy())).replace("<pricesell>", SellType.getPrice(itembuy.getSellType(), itembuy.getPriceSell())));
                meta.setLore(lore);
                item.setItemMeta(meta);
                this.listitem.put(sl, itembuy);
                this.inv.setItem(sl, item);
                blackslot.removeIf(a -> a == sl);
            }
        }
    }

    public Inventory getInventoty() {
        return this.inv;
    }

    public boolean isFull() {
        return this.blackslot.isEmpty();
    }

    public void setItem(int i, ItemStack item) {
        this.inv.setItem(i, item);
    }

    public ItemBuy getItem(int slot) {
        if (this.listitem.containsKey(Integer.valueOf(slot)))
            return this.listitem.get(Integer.valueOf(slot));
        return null;
    }
}
