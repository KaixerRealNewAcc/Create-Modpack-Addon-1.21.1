package net.kaixer.createexpertengineering.Item;

import net.kaixer.createexpertengineering.CreateExpertEngineering;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateExpertEngineering.MOD_ID);

    public static final DeferredItem<Item> KINETIC_MECHANISM = ITEMS.register("kinetic_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SEALED_MECHANISM = ITEMS.register("sealed_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STURDY_MECHANISM = ITEMS.register("sturdy_mechanism",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
