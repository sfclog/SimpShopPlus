package me.sfclog.simpshopplus.commands;

import me.sfclog.simpshopplus.Main;
import me.sfclog.simpshopplus.shopmanage.ShopGui;
import me.sfclog.simpshopplus.shopmanage.ShopManage;
import me.sfclog.simpshopplus.shopmanage.guipe.MCPE_MainShop;
import me.sfclog.simpshopplus.utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;

import java.util.ArrayList;
import java.util.List;

public class ShopCommand implements TabExecutor, CommandExecutor {


    @Override
    public List<String> onTabComplete(CommandSender arg0, org.bukkit.command.Command arg1, String arg2, String[] arg3) {
        ArrayList<String> s = new ArrayList<String>();
        s.add("reload");

        return s;
    }

    @Override
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
        if (arg3.length < 1) {
            if (arg0 instanceof Player) {
                Player p = (Player) arg0;
                if (p != null) {
                    if (FloodgateApi.getInstance().isFloodgatePlayer(p.getUniqueId())) {
                        MCPE_MainShop.open_shoppe(p);
                    } else {
                        ShopGui.open_shop(p);
                    }
                }
            } else {
                arg0.sendMessage(Color.tran("&7(&5SimpShopPlus&7) &cDùng /shop reload để tải lại plugin !"));
            }
            } else if (arg3[0].equalsIgnoreCase("reload")) {
            if (!(arg0 instanceof Player)) {
                ShopManage.reload();
                arg0.sendMessage(Color.tran("&7(&5SimpShopPlus&7) &aĐã tải lại toàn bộ config !"));
            } else {

                if (arg0 instanceof Player) {
                    Player p = (Player) arg0;

                    if(p.isOp() || p.hasPermission("*")) {
                        ShopManage.reload();
                        arg0.sendMessage(Color.tran("&7(&5SimpShopPlus&7) &aĐã tải lại toàn bộ config !"));
                    } else {
                        arg0.sendMessage(Color.tran("&7(&5SimpShopPlus&7) &cBạn không có quyền !"));
                    }
                }

            }
        }
        return true;
    }


}
