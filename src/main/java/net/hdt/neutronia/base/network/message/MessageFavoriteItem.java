package net.hdt.neutronia.base.network.message;

import net.hdt.neutronia.base.network.NetworkMessage;
import net.hdt.neutronia.groups.management.features.FavoriteItems;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageFavoriteItem extends NetworkMessage {

    public int index;

    public MessageFavoriteItem() { }

    public MessageFavoriteItem(int index) {
        this.index = index;
    }

    @Override
    public IMessage handleMessage(MessageContext context) {
        FavoriteItems.favoriteItem(context.getServerHandler().player, index);
        return null;
    }

}