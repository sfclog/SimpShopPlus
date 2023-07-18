package me.sfclog.simpshopplus.shopmanage;

import me.sfclog.simpshopplus.Main;
import me.sfclog.simpshopplus.lang.Lang;
import me.sfclog.simpshopplus.shopmanage.gui.GuiBuyItem;
import me.sfclog.simpshopplus.shopmanage.gui.GuiSellAndBuy;
import me.sfclog.simpshopplus.shopmanage.gui.GuiSellItem;
import me.sfclog.simpshopplus.shopmanage.listitem.GuiListItem;
import me.sfclog.simpshopplus.shopmanage.takeandgive.TakeAndGive;
import me.sfclog.simpshopplus.utils.NumberCover;
import me.sfclog.simpshopplus.utils.TranItem;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ShopGui implements Listener {


    public static HashMap<String , ShopCache> playercache = new HashMap<String, ShopCache>();
    public static HashMap<String , GuiListItem> playershopcache = new HashMap<String, GuiListItem>();
    public static HashMap<String , ItemBuy> itembuycache = new HashMap<String, ItemBuy>();




    public static void clear_cache(Player p) {
        if(playercache.containsKey(p.getName())) {
            playercache.remove(p.getName());
        }
        if(playershopcache.containsKey(p.getName())) {
            playershopcache.remove(p.getName());
        }
        if(itembuycache.containsKey(p.getName())) {
            itembuycache.remove(p.getName());
        }
    }

    //cache clear////////////////////////

    @EventHandler
    public void quit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(p != null) {
            clear_cache(p);
        }
    }
    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(p != null) {
            clear_cache(p);
        }
    }
    @EventHandler
    public void quit(PlayerChangedWorldEvent e) {
        Player p = e.getPlayer();
        if(p != null) {
            clear_cache(p);
        }
    }
    /////////////////////////////////////////


    @EventHandler
    public void buyclick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory() != null && e.getView() != null && e.getView().getTitle() != null && e.getClickedInventory() != null ) {
            if(e.getCurrentItem() != null) {
            int slot = e.getSlot();
            if (e.getView().getTitle().equals(Lang.getlang("Shop.GuiPC.SellAndBuy"))) {
                e.setCancelled(true);
                  if (slot == 49) {
                      if (playershopcache.containsKey(p.getName())) {
                          GuiListItem gui = playershopcache.get(p.getName());
                          gui.open_shop();
                      }
                  }

                if(itembuycache.containsKey(p.getName())) {

                    ItemBuy item = itembuycache.get(p.getName());
                    if(item != null) {
                        if (slot == 20) {
                            TakeAndGive.give_item(p,item,1);
                        }
                        if (slot == 21) {
                            TakeAndGive.give_item(p,item,16);
                        }
                        if (slot == 22) {
                            TakeAndGive.give_item(p,item,32);
                        }
                        if (slot == 23) {
                            TakeAndGive.give_item(p,item,64);
                        }
                        if (slot == 24) {
                            new AnvilGUI.Builder()
                                    .onClose(player -> {

                                        Bukkit.getScheduler().runTaskLater(Main.pl, new Runnable() {
                                            @Override
                                            public void run() {
                                                GuiSellAndBuy.build(p,item);
                                            }
                                        }, 5L);


                                    })
                                    .onClick((sl, stateSnapshot) -> {
                                        if(sl != AnvilGUI.Slot.OUTPUT) {
                                            return Collections.emptyList();
                                        }
                                        String text = stateSnapshot.getText();
                                        if(text != null) {
                                            int cover = NumberCover.cover(text);
                                            if(cover != -1 && cover > 0) {
                                                TakeAndGive.give_amount_item(p,item,cover);
                                            }
                                        }
                                        return Arrays.asList(AnvilGUI.ResponseAction.close());

                                    })
                                    .text("1")
                                    .itemLeft(new ItemStack(Material.PAPER))
                                    .title(Lang.getlang("Shop.GuiAnvil.Title"))
                                    .plugin(Main.pl)
                                    .open(p);
                        }


                        if (slot == 29) {
                            TakeAndGive.take_item(p,item,1);
                        }
                        if (slot == 30) {
                            TakeAndGive.take_item(p,item,16);
                        }
                        if (slot == 31) {
                            TakeAndGive.take_item(p,item,32);
                        }
                        if (slot == 32) {
                            TakeAndGive.take_item(p,item,64);
                        }
                        if (slot == 33) {
                            TakeAndGive.take_all(p,item);
                        }

                    }
                  }
                }
                if (e.getView().getTitle().equals(Lang.getlang("Shop.GuiPC.Buy"))) {
                    e.setCancelled(true);
                    if (slot == 49) {
                        if (playershopcache.containsKey(p.getName())) {
                            GuiListItem gui = playershopcache.get(p.getName());
                            gui.open_shop();
                        }
                    }

                    if (itembuycache.containsKey(p.getName())) {
                        ItemBuy item = itembuycache.get(p.getName());
                        if (slot == 20) {
                            TakeAndGive.give_item(p,item,1);
                        }
                        if (slot == 21) {
                            TakeAndGive.give_item(p,item,16);
                        }
                        if (slot == 22) {
                            TakeAndGive.give_item(p,item,32);
                        }
                        if (slot == 23) {
                            TakeAndGive.give_item(p,item,64);
                        }
                        if (slot == 24) {
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL,100,1);
                            new AnvilGUI.Builder()
                                    .onClose(player -> {
                                        Bukkit.getScheduler().runTaskLater(Main.pl, new Runnable() {
                                            @Override
                                            public void run() {
                                                GuiBuyItem.build(p,item);
                                            }
                                        }, 5L);
                                    })
                                    .onClick((sl, stateSnapshot) -> {
                                        if(sl != AnvilGUI.Slot.OUTPUT) {
                                            return Collections.emptyList();
                                        }
                                        String text = stateSnapshot.getText();
                                        if(text != null) {
                                            int cover = NumberCover.cover(text);
                                            if(cover != -1 && cover > 0) {
                                                TakeAndGive.give_amount_item(p,item,cover);
                                            }
                                        }
                                        return Arrays.asList(AnvilGUI.ResponseAction.close());

                                    })
                                    .text("1")
                                    .itemLeft(new ItemStack(Material.PAPER))
                                    .title(Lang.getlang("Shop.GuiAnvil.Title"))
                                    .plugin(Main.pl)
                                    .open(p);
                        }
                    }
                    if (slot == 40) {
                        if (playershopcache.containsKey(p.getName())) {
                            GuiListItem gui = playershopcache.get(p.getName());
                            gui.open_shop();
                        }
                    }
                }
                if (e.getView().getTitle().equals(Lang.getlang("Shop.GuiPC.Sell"))) {
                    e.setCancelled(true);
                    if (slot == 49) {
                        if (playershopcache.containsKey(p.getName())) {
                            GuiListItem gui = playershopcache.get(p.getName());
                            gui.open_shop();
                        }
                    }

                    if (itembuycache.containsKey(p.getName())) {
                        ItemBuy item = itembuycache.get(p.getName());

                        if (slot == 20) {
                            TakeAndGive.take_item(p,item,1);
                        }
                        if (slot == 21) {
                            TakeAndGive.take_item(p,item,16);
                        }
                        if (slot == 22) {
                            TakeAndGive.take_item(p,item,32);
                        }
                        if (slot == 23) {
                            TakeAndGive.take_item(p,item,64);
                        }
                        if (slot == 24) {
                            TakeAndGive.take_all(p,item);
                        }
                    }
                    if (slot == 40) {
                        if (playershopcache.containsKey(p.getName())) {
                            GuiListItem gui = playershopcache.get(p.getName());
                            gui.open_shop();

                        }
                    }
                }
            }

        }
    }


    @EventHandler
    public void onInvShopClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory() != null && e.getView() != null && e.getView().getTitle() != null && e.getClickedInventory() != null && ShopGuiManage.have(e.getView().getTitle())) {
            e.setCancelled(true);
            if(e.getCurrentItem() != null) {
                int slot = e.getSlot();
                if (playershopcache.containsKey(p.getName())) {
                    GuiListItem gui = playershopcache.get(p.getName());
                      ItemBuy item =  gui.getItem(slot);;
                      if(item != null) {
                          if(itembuycache.containsKey(p.getName())) {
                              itembuycache.replace(p.getName(),item);
                          } else {
                              itembuycache.put(p.getName(),item);
                          }
                          p.playSound(p.getLocation(), Sound.ENTITY_EGG_THROW,100,1);

                          if(ShopMode.getMode(item) == ShopMode.SELLANDBUY) {
                              GuiSellAndBuy.build(p, item);
                          } else  if(ShopMode.getMode(item) == ShopMode.BUY) {
                              GuiBuyItem.build(p,item);
                          } else  if(ShopMode.getMode(item) == ShopMode.SELL) {
                              GuiSellItem.build(p,item);
                          }

                      }

                    if (gui != null) {
                        if (slot == 48) {
                            gui.back();
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,100,1);
                        }
                        if (slot == 49) {
                            open_shop(p);

                        }
                        if (slot == 50) {
                            gui.next();
                            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,100,1);
                        }

                    }
                }
            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getInventory() != null && e.getView() != null && e.getView().getTitle() != null && e.getClickedInventory() != null && e.getView().getTitle().equals(Lang.getlang("Shop.GuiPC.Title"))) {
            e.setCancelled(true);
            if(e.getCurrentItem() != null) {
                int slot = e.getSlot();
                if (playercache.containsKey(p.getName())) {
                    ShopCache cache = playercache.get(p.getName());
                    if (cache != null && cache.have(slot)) {
                        Shop shop = cache.get(slot);
                        GuiListItem gui = new GuiListItem(p, shop).build();
                        if (playershopcache.containsKey(p.getName())) {
                            playershopcache.replace(p.getName(), gui);
                        } else {
                            playershopcache.put(p.getName(), gui);
                        }
                        gui.open_shop();
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT,100,1);

                    }
                }
                if(slot == 49) {
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE,100,1);
                    p.closeInventory();
                }
            }
        }
    }



    public static void open_shop(Player p) {
        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES,100,1);
        Inventory inv = Bukkit.createInventory(null,Lang.getint("Shop.GuiPC.Size"), Lang.getlang("Shop.GuiPC.Title"));
        ShopCache cache = new ShopCache();
        for(Shop shop : ShopGuiManage.getAllShop()) {
            ItemStack item = TranItem.getIcon(shop.getBase());
            if(item != null && item.getType() != null) {
                if(item.getType() == Material.PLAYER_HEAD) {
                    SkullMeta meta = (SkullMeta) item.getItemMeta();
                    meta.setDisplayName(shop.getShopName());
                    List<String> lore = Lang.getarray("Shop.GuiPC.MainItem.Lore");
                    lore.replaceAll(a -> a.replace("<info>",shop.getShopInfo()));
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                } else {
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(shop.getShopName());
                    List<String> lore = Lang.getarray("Shop.GuiPC.MainItem.Lore");
                    lore.replaceAll(a -> a.replace("<info>",shop.getShopInfo()));
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                }
                inv.setItem(shop.getSlotPC(),item);
                cache.add(shop.getSlotPC(),shop);
            }
            playercache.put(p.getName(),cache);
        }

        inv.setItem(49,add_close_item());
        p.openInventory(inv);

    }

    public static ItemStack add_close_item() {
        ItemStack item = TranItem.getIcon(Lang.getlang("Shop.GuiPC.CloseItem.Type"));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Lang.getlang("Shop.GuiPC.CloseItem.Name"));
        List<String> lore = Lang.getarray("Shop.GuiPC.CloseItem.Lore");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }
}
