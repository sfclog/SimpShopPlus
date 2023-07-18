package me.sfclog.simpshopplus.commands;

import me.sfclog.simpshopplus.lang.Lang;
import me.sfclog.simpshopplus.shopmanage.gui.GuiSell;
import me.sfclog.simpshopplus.utils.Send;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopSellGui  implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {

        if (arg0 instanceof Player) {
            Player p = (Player) arg0;
            if(p != null && p.hasPermission("simpshopplus.sellgui")) {
                GuiSell.send(p);
              } else {
                Send.send(p, Lang.getlang("Shop.Msg.SellGuiPerm"));
            }
        }

        return true;
    }


}
