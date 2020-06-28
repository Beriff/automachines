
package net.beriff.chemistrycraft.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.beriff.chemistrycraft.item.LigninShardItem;
import net.beriff.chemistrycraft.ChemcraftModElements;

@ChemcraftModElements.ModElement.Tag
public class LigninFuelFuel extends ChemcraftModElements.ModElement {
	public LigninFuelFuel(ChemcraftModElements instance) {
		super(instance, 100);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(LigninShardItem.block, (int) (1)).getItem())
			event.setBurnTime(1300);
	}
}
