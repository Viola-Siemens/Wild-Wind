package org.polaris2023.wild_wind.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.polaris2023.wild_wind.WildWind;
import org.polaris2023.wild_wind.common.entity.Firefly;

public class FireflyRenderer extends EntityRenderer<Firefly> {

    private static final ResourceLocation FIREFLY_LOCATION = WildWind.location("textures/entity/firefly.png");

    protected FireflyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);

    }

    /**
     * Returns the location of an entity's texture.
     *
     * @param pEntity {@link  Firefly}
     */
    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Firefly pEntity) {
        return FIREFLY_LOCATION;
    }

    @Override
    public void render(
            @NotNull Firefly pEntity,
            float pEntityYaw,
            float pPartialTick,
            @NotNull PoseStack pPoseStack,
            @NotNull MultiBufferSource pBufferSource,
            int pPackedLight
    ) {
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBufferSource, pPackedLight);
    }
}
