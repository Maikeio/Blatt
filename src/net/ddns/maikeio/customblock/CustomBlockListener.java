package net.ddns.maikeio.customblock;

import org.bukkit.event.Listener;

class CustomBlockListener implements Listener {
	
	CustomBlockHandler handler;

	public CustomBlockListener(CustomBlockHandler handler) {
		this.handler = handler;
	}

}
