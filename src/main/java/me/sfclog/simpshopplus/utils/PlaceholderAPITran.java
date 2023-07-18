package me.sfclog.simpshopplus.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class PlaceholderAPITran {

	public static String tran(Player p ,String s) {
		if(PlaceholderAPI.setPlaceholders(p, s) != null) {
			return PlaceholderAPI.setPlaceholders(p, s);
		}
		return s;
		
	}
}
