package com.embeddedt.chunkbert.mixin;

import com.embeddedt.chunkbert.ext.AnvilChunkLoaderExt;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AnvilChunkLoader.class)
public class AnvilChunkLoaderMixin implements AnvilChunkLoaderExt {
    private boolean chunkbert$loadTes = true;

    @Override
    public void chunkbert$setLoadsTileEntities(boolean b) {
        chunkbert$loadTes = b;
    }

    @Redirect(method = "loadEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NBTTagCompound;getTagList(Ljava/lang/String;I)Lnet/minecraft/nbt/NBTTagList;", ordinal = 1))
    private NBTTagList getTagList_1(NBTTagCompound compound, String key, int type)
    {
        if (!chunkbert$loadTes)
        {
            return new NBTTagList();
        }
        return compound.getTagList(key, type);
    }

    @Redirect(method = "loadEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NBTTagCompound;getTagList(Ljava/lang/String;I)Lnet/minecraft/nbt/NBTTagList;", ordinal = 2))
    private NBTTagList getTagList_2(NBTTagCompound compound, String key, int type)
    {
        if (!chunkbert$loadTes)
        {
            return new NBTTagList();
        }
        return compound.getTagList(key, type);
    }
}
