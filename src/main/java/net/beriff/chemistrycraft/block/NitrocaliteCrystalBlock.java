
package net.beriff.chemistrycraft.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.beriff.chemistrycraft.itemgroup.ModTabItemGroup;
import net.beriff.chemistrycraft.item.NitrocaliteItem;
import net.beriff.chemistrycraft.ChemcraftModElements;

import java.util.Random;
import java.util.List;
import java.util.Collections;

@ChemcraftModElements.ModElement.Tag
public class NitrocaliteCrystalBlock extends ChemcraftModElements.ModElement {
	@ObjectHolder("chemcraft:nitrocalite_crystal")
	public static final Block block = null;
	public NitrocaliteCrystalBlock(ChemcraftModElements instance) {
		super(instance, 56);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ModTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1f, 10f).lightValue(0).notSolid());
			setRegistryName("nitrocalite_crystal");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(NitrocaliteItem.block, (int) (2)));
		}
	}
	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new OreFeature(OreFeatureConfig::deserialize) {
				@Override
				public boolean place(IWorld iworld, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
					DimensionType dimensionType = iworld.getDimension().getType();
					boolean dimensionCriteria = false;
					if (dimensionType == DimensionType.OVERWORLD)
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					return super.place(iworld, generator, rand, pos, config);
				}
			}.withConfiguration(
					new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("nitrocalite_crystal", "nitrocalite_crystal", blockAt -> {
						boolean blockCriteria = false;
						if (blockAt.getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
							blockCriteria = true;
						return blockCriteria;
					}), block.getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 64))));
		}
	}
}
