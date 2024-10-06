package org.polaris2023.wild_wind.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.polaris2023.wild_wind.api.Const;

import java.util.Locale;
import java.util.function.Supplier;

public class TagRegister {
    public enum BlockTags implements Supplier<TagKey<Block>> {
        firefly_roost_block;

        private final TagKey<Block> tagKey;

        BlockTags() {
            this.tagKey = Const.tags(Registries.BLOCK, name().toLowerCase(Locale.ROOT));
        }

        /**
         * Gets a result.
         *
         * @return a result
         */
        @Override
        public TagKey<Block> get() {
            return tagKey;
        }
    }
}
