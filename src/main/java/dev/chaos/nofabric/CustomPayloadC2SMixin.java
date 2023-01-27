package dev.chaos.nofabric;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketCallbacks;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class CustomPayloadC2SMixin {
    @Inject(at = @At("HEAD"), method = "send(Lnet/minecraft/network/Packet;Lnet/minecraft/network/PacketCallbacks;)V", cancellable = true)
    public void send(Packet<?> packet, @Nullable PacketCallbacks callbacks, CallbackInfo ci) {
        if(packet instanceof CustomPayloadC2SPacket) {
            ci.cancel();
        }
    }
}
