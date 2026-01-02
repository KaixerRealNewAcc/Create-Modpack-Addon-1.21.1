package net.kaixer.createexpertengineering.block;

import net.kaixer.createexpertengineering.CreateExpertEngineering;
import net.kaixer.createexpertengineering.Item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;



public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CreateExpertEngineering.MOD_ID);

    public static final DeferredBlock<Block> ANDESITE_MACHINE = registerBlock("andesite_machine",
            () -> new Block(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> COPPER_MACHINE = registerBlock("copper_machine",
            () -> new Block(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER)));

    public static final DeferredBlock<Block> BRASS_MACHINE = registerBlock("brass_machine",
            () -> new Block(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
