package net.kaixer.createexpertengineering.Item;

import com.google.common.eventbus.EventBus;
import net.kaixer.createexpertengineering.CreateExpertEngineering;
import net.kaixer.createexpertengineering.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateExpertEngineering.MOD_ID);

    public static final Supplier<CreativeModeTab> MECHANICS_TAB = CREATIVE_MODE_TAB.register("mechanics_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KINETIC_MECHANISM.get()))
                    .title(Component.translatable("creative.tab.createexpertengineering.mechanics"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.KINETIC_MECHANISM);
                        output.accept(ModItems.SEALED_MECHANISM);
                        output.accept(ModItems.STURDY_MECHANISM);
                    }).build());

    public static final Supplier<CreativeModeTab> MACHINES_TAB = CREATIVE_MODE_TAB.register("machines_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ANDESITE_MACHINE))
                    .title(Component.translatable("creative.tab.createexpertengineering.machines"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ANDESITE_MACHINE);
                        output.accept(ModBlocks.COPPER_MACHINE);
                        output.accept(ModBlocks.BRASS_MACHINE);
                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
