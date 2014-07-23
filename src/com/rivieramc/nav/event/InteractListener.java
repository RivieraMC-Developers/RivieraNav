package com.rivieramc.nav.event;
 
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.rivieramc.nav.NebulaNav;
 
public class InteractListener implements Listener {
       
        @EventHandler
        public void onClick(PlayerInteractEvent event){
                Player player = event.getPlayer();
                Action action = event.getAction();
                if (action==Action.RIGHT_CLICK_BLOCK || action==Action.RIGHT_CLICK_AIR){
               
                        ItemStack hand = player.getItemInHand();
                        if (hand!=null&&hand.getType()==Material.COMPASS && hand == NebulaNav.compassItemStack); {
                                player.openInventory(NebulaNav.getCompassInventory());
                        }
                }
        }
}