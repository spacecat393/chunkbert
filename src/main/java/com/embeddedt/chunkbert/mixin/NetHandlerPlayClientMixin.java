//package com.embeddedt.chunkbert.mixin;
//
//import net.minecraft.client.multiplayer.WorldClient;
//import net.minecraft.client.network.NetHandlerPlayClient;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//
//@Mixin(NetHandlerPlayClient.class)
//public class NetHandlerPlayClientMixin {
//    @Shadow private WorldClient world;
//
//    @Inject(method = "handleChunkData", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/play/server/SPacketChunkData;isFullChunk()Z", ordinal = 0))
//    private void bobbyUnloadFakeChunk(SPacketChunkData data, CallbackInfo ci) {
//        FakeChunkManager bobbyChunkManager = ((IChunkProviderClient)(world.getChunkProvider())).getBobbyChunkManager();
//        if (bobbyChunkManager == null) {
//            return;
//        }
//
//        // This needs to be called unconditionally because even if there is no chunk loaded at the moment,
//        // we might already have one queued which we need to cancel as otherwise it will overwrite the real one later.
//        bobbyChunkManager.unload(data.getChunkX(), data.getChunkZ(), true);
//    }
//}
