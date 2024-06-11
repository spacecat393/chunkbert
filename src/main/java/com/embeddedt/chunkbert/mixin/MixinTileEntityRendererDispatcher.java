package com.embeddedt.chunkbert.mixin;

import com.embeddedt.chunkbert.ChunkbertConfig;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TileEntityRendererDispatcher.class)
public abstract class MixinTileEntityRendererDispatcher
{
    @Redirect(method = "render(Lnet/minecraft/tileentity/TileEntity;FI)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/tileentity/TileEntity;getDistanceSq(DDD)D"))
    private double render(TileEntity instance, double x, double y, double z)
    {
        return ChunkbertConfig.noBlockEntities ? instance.getDistanceSq(x, y, z) : -1.0D;
    }
}
