package me.sfclog.simpshopplus.utils;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConfigGet {

	
	   public static ArrayList<String> getList(File locate , String s) {
		FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);  
		ArrayList<String> list = new ArrayList<String>();
		for(String ar : DataFile.getConfigurationSection(s).getKeys(false)) {
			if(ar != null) {
				list.add(ar);
			}
		}
		return list;
	   }
	   public static List<String> getarray(File locate , String s) {
		    FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		List<String> ss = new ArrayList<String>();
	    		for(String ok : DataFile.getStringList(s)) {
	    			ss.add(Color.tran(ok));
	    		}
	    		return ss;
	    	}
	    	return null;
	    }
	   
	   public static List<String> getarray_low(File locate , String s) {
		    FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		List<String> ss = new ArrayList<String>();
	    		for(String ok : DataFile.getStringList(s)) {
	    			ss.add(Color.tran(ok.toLowerCase()));
	    		}
	    		return ss;
	    	}
	    	return null;
	    }
	   
	   public static List<String> getarray(Player p ,File locate , String s) {
		    FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		List<String> ss = new ArrayList<String>();
	    		for(String ok : DataFile.getStringList(s)) {
	    			ss.add(Color.tran(PlaceholderAPITran.tran(p,ok)));
	    		}
	    		return ss;
	    	}
	    	return null;
	    }
	   
	   
	   
	    public static boolean hash(File locate , String s) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		return true;
	    	}
	    	return false;
	    }
	   
	    public static int getint(File locate , String s) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		return DataFile.getInt(s);
	    	}
	    	return 0;
	    }
	    public static double getdoubl(File locate , String s) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		return DataFile.getDouble(s);
	    	}
	    	return 0;
	    }
	    public static boolean getb(File locate , String s) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		return DataFile.getBoolean(s);
	    	}
	    	return false;
	    }
	    public static String getlang(File locate ,String s) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		return Color.tran(DataFile.getString(s));
	    	}
	    	return s;
	    }
	    
	    public static String getlang_nosafe(File locate ,String s) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		return Color.tran(DataFile.getString(s));
	    	}
	    	return null;
	    }
	    
	    public static String getlang(Player p ,File locate ,String s) {
	    	FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		return Color.tran(PlaceholderAPITran.tran(p,DataFile.getString(s)));
	    	}
	    	return s;
	    }
	    
	    
	    public static String getlang_nosafe(Player p ,File locate ,String s) {
	    	FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(DataFile.contains(s)) {
	    		return Color.tran(PlaceholderAPITran.tran(p,DataFile.getString(s)));
	    	}
	    	return null;
	    }
	    
		
	    public static void addlang(File locate ,String s , double s2) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(!DataFile.contains(s)) {
	    	DataFile.set(s, s2);
	    	}
	    }
	    public static void addlang(File locate ,String s , Boolean s2) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(!DataFile.contains(s)) {
	    	DataFile.set(s, s2);
	    	}
	    }
	    public static void addlang(File locate ,String s , List<String> s2) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(!DataFile.contains(s)) {
	    	DataFile.set(s, s2);
	    	}
	    }
	    public static void setforcelang(File locate ,String s , String s2) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	DataFile.set(s, s2);
	    }
		public static void setforcelang(File locate ,String s, double x) {
			 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
			DataFile.set(s, x);
		}
	    public static void addlang(File locate ,String s , String s2) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(!DataFile.contains(s)) {
	    	DataFile.set(s, s2);
	    	}
	    }
	    public static void addlang(File locate ,String s , int s2) {
	    	 FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(locate);
	    	if(!DataFile.contains(s)) {
	    	DataFile.set(s, s2);
	    	}
	    }


	public static ConfigurationSection getData(File file) {
		FileConfiguration DataFile = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
		return DataFile;
	}
}
