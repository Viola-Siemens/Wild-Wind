package org.polaris2023.wild_wind.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;
import org.polaris2023.wild_wind.api.Const;
import org.polaris2023.wild_wind.common.registry.EntitiesRegistry;
import org.polaris2023.wild_wind.common.registry.ItemsRegistry;
import org.polaris2023.wild_wind.common.registry.TagRegister;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Const.MODID, bus = EventBusSubscriber.Bus.MOD)
public class WWData {
    @SubscribeEvent
    public static void data(GatherDataEvent event) {

        gen(
                event.getGenerator(),
                event.getGenerator().getPackOutput(),
                event.getLookupProvider(),
                event.getExistingFileHelper(),
                event.includeClient(),
                event.includeServer());
    }

    public static void gen(DataGenerator generator,
                           PackOutput packOutput,
                           CompletableFuture<HolderLookup.Provider> lookupProvider,
                           ExistingFileHelper existingFileHelper,
                           boolean includeClient,
                           boolean includeServer) {
        generator.addProvider(includeClient, new LanguageProvider(packOutput, Const.MODID, "en_us") {
            @Override
            protected void addTranslations() {
                add(ItemsRegistry.fireflyEgg.get(), "firefly spawn egg");
            }
        });
        generator.addProvider(includeServer, new EntityTypeTagsProvider(packOutput, lookupProvider, Const.MODID, existingFileHelper) {
            @Override
            protected void addTags(HolderLookup.@NotNull Provider pProvider) {
                IntrinsicTagAppender<EntityType<?>> tag = tag(EntityTypeTags.ARTHROPOD);
                tag.add(EntitiesRegistry.firefly.get());
            }
        });
        generator.addProvider(includeServer, new BlockTagsProvider(packOutput, lookupProvider, Const.MODID, existingFileHelper) {
            @Override
            protected void addTags(HolderLookup.Provider provider) {
                IntrinsicTagAppender<Block> tag = tag(TagRegister.BlockTags.firefly_roost_block.get());
                tag.add(
                        Blocks.TALL_GRASS,
                        Blocks.SHORT_GRASS,
                        Blocks.FERN,
                        Blocks.LARGE_FERN,
                        Blocks.POTTED_FERN,
                        Blocks.MANGROVE_PROPAGULE,
                        Blocks.POTTED_MANGROVE_PROPAGULE
                );
                tag.addTag(BlockTags.FLOWERS);
            }
        });
    }
}
