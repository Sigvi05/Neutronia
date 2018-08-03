package net.hdt.neutronia.base.network.message;

import net.hdt.neutronia.base.network.NetworkMessage;
import net.hdt.neutronia.groups.tweaks.features.ImprovedSleeping;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageUpdateAfk extends NetworkMessage {

	public boolean afk;
	
	public MessageUpdateAfk() { }

	public MessageUpdateAfk(boolean afk) { 
		this.afk = afk;
	}
	
	@Override
	public IMessage handleMessage(MessageContext context) {
		ImprovedSleeping.updateAfk(context.getServerHandler().player, afk);
		return null;
	}

}
