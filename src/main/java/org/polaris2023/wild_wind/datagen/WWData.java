package org.polaris2023.wild_wind.datagen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.random.Weight;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.polaris2023.wild_wind.api.Const;
import org.polaris2023.wild_wind.common.registry.EntitiesRegistry;
import org.polaris2023.wild_wind.common.registry.ItemsRegistry;
import org.polaris2023.wild_wind.common.registry.TagRegister;
import org.polaris2023.wild_wind.datagen.loot.EntityTableSubProvider;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static net.neoforged.neoforge.common.world.BiomeModifiers.*;

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
                add(ItemsRegistry.fireflySpawnEgg.get(), "spawn egg[firefly]");
                add(ItemsRegistry.fluorescentPowder.get(), "fluorescent powder");
                add(ItemsRegistry.fluorescentMucus.get(), "fluorescent mucus");
                add(EntitiesRegistry.firefly.get(), "firefly");
            }
        });
        generator.addProvider(includeClient, new LanguageProvider(packOutput, Const.MODID, "zh_cn") {
            @Override
            protected void addTranslations() {
                add(ItemsRegistry.fireflySpawnEgg.get(), "刷怪蛋【萤火虫】");
                add(ItemsRegistry.fluorescentPowder.get(), "荧光粉");
                add(ItemsRegistry.fluorescentMucus.get(), "荧光粘液");
                add(EntitiesRegistry.firefly.get(), "萤火虫");
            }
        });
        generator.addProvider(includeClient, new LanguageProvider(packOutput, Const.MODID, "zh_tw") {
            @Override
            protected void addTranslations() {
                add(ItemsRegistry.fireflySpawnEgg.get(), "刷怪蛋【螢火蟲】");
                add(ItemsRegistry.fluorescentPowder.get(), "螢光粉");
                add(ItemsRegistry.fluorescentMucus.get(), "螢光粘劑");
                add(EntitiesRegistry.firefly.get(), "螢火蟲");
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
        generator.addProvider(includeClient, new ItemModelProvider(packOutput, Const.MODID, existingFileHelper) {
            @Override
            protected void registerModels() {
                basicItem(ItemsRegistry.fireflySpawnEgg.get());
                basicItem(ItemsRegistry.fluorescentPowder.get());
                basicItem(ItemsRegistry.fluorescentMucus.get());
            }
        });
        generator.addProvider(includeServer, new LootTableProvider(
                packOutput,
                Set.of(

                ),
                List.of(
                        new LootTableProvider.SubProviderEntry(
                                EntityTableSubProvider::new,
                                LootContextParamSets.ENTITY
                        )
                ), lookupProvider));
        generator.addProvider(includeServer, new DatapackBuiltinEntriesProvider(packOutput, lookupProvider,
                new RegistrySetBuilder().add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, boostrap -> {
                    HolderGetter<Biome> lookup = boostrap.lookup(Registries.BIOME);
                    boostrap.register(WWBiomeModifiers.fireflyModifier,
                            new AddSpawnsBiomeModifier(
                                    HolderSet.direct(
                                            lookup.getOrThrow(Biomes.JUNGLE),
                                            lookup.getOrThrow(Biomes.BAMBOO_JUNGLE),
                                            lookup.getOrThrow(Biomes.SPARSE_JUNGLE),
                                            lookup.getOrThrow(Biomes.PLAINS),
                                            lookup.getOrThrow(Biomes.SUNFLOWER_PLAINS),
                                            lookup.getOrThrow(Biomes.SWAMP),
                                            lookup.getOrThrow(Biomes.MANGROVE_SWAMP),
                                            lookup.getOrThrow(Biomes.FOREST),
                                            lookup.getOrThrow(Biomes.FLOWER_FOREST),
                                            lookup.getOrThrow(Biomes.DARK_FOREST),
                                            lookup.getOrThrow(Biomes.BIRCH_FOREST),
                                            lookup.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST)
                                    ),
                                    List.of(
                                            new SpawnerData(EntitiesRegistry.firefly.get(), Weight.of(50), 1, 9)
                                    )
                            ));
                }), Set.of(Const.MODID)));

    }

}
