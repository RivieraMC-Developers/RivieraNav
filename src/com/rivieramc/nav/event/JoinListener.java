package com.rivieramc.nav.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.rivieramc.nav.NebulaNav;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		p.getInventory().addItem(NebulaNav.compassItemStack);
	}

}
