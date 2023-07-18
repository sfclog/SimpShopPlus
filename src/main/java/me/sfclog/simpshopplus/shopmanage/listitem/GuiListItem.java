package me.sfclog.simpshopplus.shopmanage.listitem;

import java.util.ArrayList;
import java.util.List;
import me.sfclog.simpshopplus.lang.Lang;
import me.sfclog.simpshopplus.shopmanage.ItemBuy;
import me.sfclog.simpshopplus.shopmanage.Shop;
import me.sfclog.simpshopplus.utils.TranItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiListItem {
    public Player p;

    public Shop shop;

    public List<GuiBuilder> inv;

    int i = 0;

    public GuiListItem(Player p, Shop shop) {
        this.p = p;
        this.shop = shop;
        this.inv = new ArrayList<>();
    }

    public ItemBuy getItem(int slot) {
        GuiBuilder gui = this.inv.get(this.i);
        if (gui != null) {
            return gui.getItem(slot);
        }
        return null;
    }

    public GuiListItem build() {
        List<ItemBuy> list = this.shop.getListItem();
        GuiBuilder gui = new GuiBuilder(this.p, this.shop, 0);
        if (list.size() > 22) {
            this.inv.add(gui);
            int i = 1;
            for (ItemBuy item : list) {
                if (item != null) {
                    if (!gui.isFull()) {
                        gui.add(item);
                        continue;
                    }
                    gui = new GuiBuilder(this.p, this.shop, i);
                    this.inv.add(gui);
                    gui.add(item);
                    i++;
                }
            }
        } else {
            for (ItemBuy item : list) {
                if (item != null)
                    gui.add(item);
            }
            this.inv.add(gui);
        }
        return this;
    }

    public void open_shop() {
        if (!this.inv.isEmpty()) {
            GuiBuilder build = this.inv.get(this.i);
            build.setItem(49, add_quit_item());
            build.setItem(50, add_next_item(this.i + 1, this.inv.size()));
            build.setItem(48, add_back_item(this.i + 1, this.inv.size()));
            this.p.openInventory(build.getInventoty());
        } else {
            GuiBuilder build = new GuiBuilder(this.p, this.shop, 1);
            build.setItem(49, add_quit_item());
            build.setItem(50, add_next_item(this.i + 1, this.inv.size()));
            build.setItem(48, add_back_item(this.i + 1, this.inv.size()));
            this.p.openInventory(build.getInventoty());
        }
    }

    public void next() {
        if (!this.inv.isEmpty()) {
            int page = this.i + 1;
            if (page <= this.inv.size() - 1) {
                GuiBuilder build = this.inv.get(page);
                build.setItem(49, add_quit_item());
                build.setItem(50, add_next_item(page + 1, this.inv.size()));
                build.setItem(48, add_back_item(page + 1, this.inv.size()));
                this.i = page;
                this.p.openInventory(build.getInventoty());
            }
        }
    }

    public void back() {
        if (!this.inv.isEmpty()) {
            int page = this.i - 1;
            if (page >= 0) {
                GuiBuilder build = this.inv.get(page);
                build.setItem(49, add_quit_item());
                build.setItem(50, add_next_item(page + 1, this.inv.size()));
                build.setItem(48, add_back_item(page + 1, this.inv.size()));
                this.i = page;
                this.p.openInventory(build.getInventoty());
            }
        }
    }

    public ItemStack add_next_item(int i, int max) {
        ItemStack item = TranItem.getIcon(Lang.getlang("Shop.GuiPC.NextItem.Type"));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Lang.getlang("Shop.GuiPC.NextItem.Name"));
        List<String> lore = Lang.getarray("Shop.GuiPC.NextItem.Lore");
        lore.replaceAll(a -> a.replace("<max>", String.valueOf(max)));
        lore.replaceAll(a -> a.replace("<this>", String.valueOf(i)));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack add_back_item(int i, int max) {
        ItemStack item = TranItem.getIcon(Lang.getlang("Shop.GuiPC.BackItem.Type"));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Lang.getlang("Shop.GuiPC.BackItem.Name"));
        List<String> lore = Lang.getarray("Shop.GuiPC.BackItem.Lore");
        lore.replaceAll(a -> a.replace("<max>", String.valueOf(max)));
        lore.replaceAll(a -> a.replace("<this>", String.valueOf(i)));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack add_quit_item() {
        ItemStack item = TranItem.getIcon(Lang.getlang("Shop.GuiPC.QuitItem.Type"));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Lang.getlang("Shop.GuiPC.QuitItem.Name"));
        List<String> lore = Lang.getarray("Shop.GuiPC.QuitItem.Lore");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
