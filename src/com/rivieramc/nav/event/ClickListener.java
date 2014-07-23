package com.rivieramc.nav.event;
 
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.rivieramc.nav.NebulaNav;
 
public class ClickListener implements Listener {
 
        @EventHandler
        public void onClick(InventoryClickEvent event){
                HumanEntity entity = event.getWhoClicked();
                if ((entity instanceof Player)){
                        Player player = (Player)entity;
                       
                        if (event.getInventory().getName().equals(NebulaNav.getCompassInventory().getName())) {
                       
	                        event.setCancelled(true);
	                       
	                        ItemStack clicked = event.getCurrentItem();
	                        
	                        if(event.getSlotType().equals(event.getSlotType().QUICKBAR)) return;
	                        if(event.getSlot() > 8) return;
	                        
	                        if (clicked!=null){
	                               
	                                if (clicked.getType()==Material.PAPER){
	                                       
	                                        player.closeInventory();
	                                        player.sendMessage("You`ve selected.");
	                               
	                                }
	                                else if (clicked.getType()==Material.ENDER_PEARL){
	               
                                        player.closeInventory();
                                        if (NebulaNav.getTarget()!=null){
                                            player.teleport(NebulaNav.getTarget());
                                            player.sendMessage(ChatColor.DARK_AQUA+ "Wooosh!");
                                        }
                                        else{
                                            player.sendMessage(ChatColor.RED+"Point not set yet!");
                                        }
	                                       
	                                }
	                                else if (clicked.getType()==Material.BEACON){
                                            player.closeInventory();
                                            NebulaNav.setTarget(player.getLocation());
                                            player.sendMessage(ChatColor.GOLD+"Teleport location has been updated!");
	                                }
	                        }
                        }
                }
        }
}