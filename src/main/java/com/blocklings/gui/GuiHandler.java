package com.blocklings.gui;

import com.blocklings.entity.entities.EntityBlockling;
import com.blocklings.gui.containers.ContainerEquipmentBlockling;
import com.blocklings.gui.screens.GuiBlocklingEquipment;
import com.blocklings.gui.screens.GuiBlocklingStats;
import com.blocklings.gui.screens.GuiBlocklingTasks;
import com.blocklings.util.Tab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Container getServerGuiElement(int id, EntityPlayer player, World world, int entityID, int unused1, int unused2)
    {
        Entity entity = world.getEntityByID(entityID);

        if (entity != null && entity instanceof EntityBlockling)
        {
            EntityBlockling blockling = (EntityBlockling) entity;

            if (id == Tab.EQUIPMENT.ordinal()) return new ContainerEquipmentBlockling(blockling, player.inventory, blockling.getInv());
            else if (id == Tab.INVENTORY.ordinal()) return new ContainerEquipmentBlockling(blockling, player.inventory, blockling.getInv());
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int entityID, int unused1, int unused2)
    {
        Entity entity = world.getEntityByID(entityID);

        if (entity != null && entity instanceof EntityBlockling)
        {
            EntityBlockling blockling = (EntityBlockling) entity;

            if (id == Tab.STATS.ordinal()) return new GuiBlocklingStats(blockling, player);
            else if (id == Tab.TASKS.ordinal()) return new GuiBlocklingTasks(blockling, player);
            else if (id == Tab.EQUIPMENT.ordinal()) return new GuiBlocklingEquipment(blockling, player);
            else if (id == Tab.INVENTORY.ordinal()) return new GuiBlocklingStats(blockling, player);
            else if (id == Tab.GENERAL.ordinal()) return new GuiBlocklingStats(blockling, player);
            else if (id == Tab.COMBAT.ordinal()) return new GuiBlocklingStats(blockling, player);
            else if (id == Tab.MINING.ordinal()) return new GuiBlocklingStats(blockling, player);
            else if (id == Tab.WOODCUTTING.ordinal()) return new GuiBlocklingStats(blockling, player);
            else if (id == Tab.FARMING.ordinal()) return new GuiBlocklingStats(blockling, player);
        }

        return null;
    }
}
