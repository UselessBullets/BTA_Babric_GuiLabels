package useless.guimod.mixins;

import net.minecraft.client.render.FontRenderer;
import net.minecraft.client.gui.GuiFurnace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import useless.guimod.GUIMod;

@Mixin(value = GuiFurnace.class, remap = false)
public class FurnaceMixin{
    @Redirect(method = "drawGuiContainerForegroundLayer()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/FontRenderer;drawString(Ljava/lang/String;III)V"))
    private void changeColor(FontRenderer instance, String text, int x, int y, int color) {
        instance.drawString(text,x,y, GUIMod.labelColor);
    }
}
