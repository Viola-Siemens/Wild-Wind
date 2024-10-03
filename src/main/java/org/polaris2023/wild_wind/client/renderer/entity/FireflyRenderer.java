package org.polaris2023.wild_wind.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.polaris2023.wild_wind.WildWind;
import org.polaris2023.wild_wind.common.entity.Firefly;

public class FireflyRenderer extends EntityRenderer<Firefly> {
    private static final ResourceLocation FIREFLY_LOCATION = WildWind.location("textures/entity/firefly.png");

    protected FireflyRenderer(EntityRendererProvider.Context context) {
        super(context);

    }

    @Override
    public ResourceLocation getTextureLocation(Firefly entity) {
        return FIREFLY_LOCATION;
    }

    @Override
    public void render(
            Firefly entity,
            float yaw,
            float partialTick,
            PoseStack transform,
            MultiBufferSource bufferSource,
            int packedLight
    ) {
        super.render(entity, yaw, partialTick, transform, bufferSource, packedLight);
    }
}
