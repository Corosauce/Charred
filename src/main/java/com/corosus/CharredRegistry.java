package com.corosus;

import com.corosus.block.CharredLogBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CharredRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Charred.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Charred.MODID);

    public static final RegistryObject<Block> BLOCK_CHARRED_LOG = BLOCKS.register("charred_log", () -> new CharredLogBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F)));
    public static final RegistryObject<Item> ITEM_CHARRED_LOG = ITEMS.register("charred_log", () -> new BlockItem(CharredRegistry.BLOCK_CHARRED_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

}
