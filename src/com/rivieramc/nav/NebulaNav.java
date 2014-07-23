package com.rivieramc.nav;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.rivieramc.nav.event.ClickListener;
import com.rivieramc.nav.event.InteractListener;
import com.rivieramc.nav.event.JoinListener;
 
public class NebulaNav extends JavaPlugin {
       
        private static Location targetPoint = null;
        public HashMap<String, Location> teleportPoints;
        public static ItemStack compassItemStack;
       
        @Override
        public void onEnable(){
                getServer().getPluginManager().registerEvents(new InteractListener(), this);
                getServer().getPluginManager().registerEvents(new ClickListener(), this);
                getServer().getPluginManager().registerEvents(new JoinListener(), this);
                teleportPoints = new HashMap<String, Location>();
                compassItemStack = new ItemStack(Material.COMPASS, 1);
                ItemMeta compassMeta = compassItemStack.getItemMeta();
                compassMeta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Game Selection");
                List<String> compassLore = new ArrayList<String>();
                compassLore.add("§7Compass navigation tool.");
                compassItemStack.setItemMeta(compassMeta);
                
        }
       
        @Override
        public void onDisable(){
               
        }
       
        public static Inventory getCompassInventory(){
               
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Game Selection");
               
        {
                ItemStack item1 = new ItemStack(Material.GOLD_BOOTS, 1);
                ItemMeta meta1 = item1.getItemMeta();
                meta1.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Nebula Z-Run");
                List<String> lore1 = new ArrayList<String>();
                lore1.add("§7Displays the " + ChatColor.AQUA + "" + ChatColor.BOLD + "Z-Run" + ChatColor.RESET + "" + ChatColor.GRAY + " mingame selection menu.");
                meta1.setLore(lore1);
                item1.setItemMeta(meta1);
                inv.setItem(2, item1);
        }
        {
                ItemStack item2 = new ItemStack(Material.IRON_SWORD, 1);
                ItemMeta meta2 = item2.getItemMeta();
                meta2.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Survival Games");
                List<String> lore2 = new ArrayList<String>();
                lore2.add("§7Displays the " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Survival Games" + ChatColor.RESET + "" + ChatColor.GRAY + " mingame selection menu.");
                meta2.setLore(lore2);
                item2.setItemMeta(meta2);
                inv.setItem(3, item2);
        }
        {
                ItemStack item3 = new ItemStack(Material.BEACON, 1);
                ItemMeta meta3 = item3.getItemMeta();
                meta3.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "set tp location");
                List<String> lore3 = new ArrayList<String>();
                lore3.add("§7sets teleport location");
                meta3.setLore(lore3);
                item3.setItemMeta(meta3);
                inv.setItem(4, item3);
        }
        {
                ItemStack item4 = new ItemStack(Material.BEACON, 1);
                ItemMeta meta4 = item4.getItemMeta();
                meta4.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "set teleport location");
                List<String> lore4 = new ArrayList<String>();
                lore4.add("§Sends you a \"Hello World\" chat message!");
                meta4.setLore(lore4);
                item4.setItemMeta(meta4);
                inv.setItem(5, item4);
       
        }
        {
            ItemStack item5 = new ItemStack(Material.BEACON, 1);
            ItemMeta meta5 = item5.getItemMeta();
            meta5.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "set teleport location");
            List<String> lore5 = new ArrayList<String>();
            lore5.add("§Sends you a \"Hello World\" chat message!");
            meta5.setLore(lore5);
            item5.setItemMeta(meta5);
            inv.setItem(6, item5);
        }
 
        return inv;
       
        }
       
        public static Location getTarget(){
                return targetPoint;
               
        }
       
        public static void setTarget(Location loc){
                NebulaNav.targetPoint=loc;
       
        }
}