package me.sfclog.simpshopplus.commands;

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

public class SimpShopPlus implements CommandExecutor {




    @Override
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {

            send(arg0," ");
            send(arg0,"&5SimpShopPlus &f- &eCửa Hàng Máy Chủ");
            send(arg0," ");
            send(arg0,"&fAuthor: &bSmallFCraft Studio");
            send(arg0," ");
            send(arg0,"&6Bản quyền thuộc về &cSimpMC@2022");
            send(arg0," ");


        return true;
    }

    private void send(CommandSender arg0, String s) {
        arg0.sendMessage(Color.tran(s));
    }


}
