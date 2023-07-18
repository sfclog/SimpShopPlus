package me.sfclog.simpshopplus.utils;


import me.sfclog.simpshopplus.lang.Lang;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Send {

	public static void send(String s , Player p) {
	 p.sendMessage(Lang.getlang("Plugin.Prefix") + Lang.getlang(s));
	}
	public static void send(Player p,String s) {
	p.sendMessage(Lang.getlang("Plugin.Prefix") + Color.tran(s));
	}
	public static void send(String s , Player p,Sound so) {
		 p.sendMessage(Lang.getlang("Plugin.Prefix") + Lang.getlang(s));
		 p.playSound(p.getLocation(), so, 50, 1);
		 
	}
	public static void send_noprefix(String s , Player p) {
	 p.sendMessage(Lang.getlang(s));	
	}
	@SuppressWarnings("deprecation")
	public static void sendtitle(String title , String subtitle,Player p) {
	p.sendTitle(title, subtitle);
	}
}
