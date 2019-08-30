package com.blocklings.network.messages;

import com.blocklings.Blocklings;
import com.blocklings.entity.entities.EntityBlockling;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CombatLevelMessage implements IMessage
{
    int value;
    int entityId;

    public CombatLevelMessage()
    {
    }

    public CombatLevelMessage(int value, int entityID)
    {
        this.value = value;
        this.entityId = entityID;
    }

    public void fromBytes(ByteBuf buf)
    {
        this.value = buf.readInt();
        this.entityId = buf.readInt();
    }

    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.value);
        buf.writeInt(this.entityId);
    }

    public static class Handler implements net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler<CombatLevelMessage, IMessage>
    {
        public IMessage onMessage(CombatLevelMessage msg, MessageContext ctx)
        {
            EntityPlayer player = Blocklings.proxy.getPlayer(ctx);
            if (player == null)
            {
                return null;
            }

            Entity entity = Blocklings.proxy.getPlayer(ctx).world.getEntityByID(msg.entityId);
            if (entity instanceof EntityBlockling)
            {
                EntityBlockling blockling = (EntityBlockling) entity;
                blockling.getBlocklingStats().setCombatLevel(msg.value, ctx.side.isServer());
            }

            return null;
        }
    }
}