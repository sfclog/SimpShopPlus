package me.sfclog.simpshopplus;

import me.sfclog.simpshopplus.commands.ShopCommand;
import me.sfclog.simpshopplus.commands.ShopSellGui;
import me.sfclog.simpshopplus.commands.SimpShopPlus;
import me.sfclog.simpshopplus.lang.Lang;
import me.sfclog.simpshopplus.shopmanage.ShopGui;
import me.sfclog.simpshopplus.shopmanage.ShopManage;
import me.sfclog.simpshopplus.shopmanage.gui.GuiSell;
import me.sfclog.simpshopplus.utils.Color;
import net.milkbowl.vault.economy.Economy;
import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Plugin pl;



    public static PlayerPointsAPI ppAPI;

    public static void sendlog(String s) {
        Bukkit.getConsoleSender().sendMessage(Color.tran(s));
    }

    public static Economy econ = null;

    @Override
    public void onEnable() {

        pl = this;
        Lang.loadlang();
        ShopManage.load();


        getServer().getPluginManager().registerEvents(new ShopGui(),this);
        getServer().getPluginManager().registerEvents(new GuiSell(),this);



        this.getCommand("simpshopplus").setExecutor(new SimpShopPlus());



        this.getCommand("shop").setExecutor(new ShopCommand());
        this.getCommand("shop").setTabCompleter(new ShopCommand());

        this.getCommand("sellgui").setExecutor(new ShopSellGui());


        if (Bukkit.getPluginManager().isPluginEnabled("PlayerPoints")) {
            this.ppAPI = PlayerPoints.getInstance().getAPI();
        }

        if (!setupEconomy() ) {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

    }


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    @Override
    public void onDisable() {
        pl = null;
    }
}
