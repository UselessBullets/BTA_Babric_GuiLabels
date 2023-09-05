package useless.guimod.mixins;

import net.minecraft.client.gui.GuiGuidebook;
import net.minecraft.client.render.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import useless.guimod.GUIMod;

@Mixin(value = GuiGuidebook.class, remap = false)
public class GuidebookMixin{
    @Redirect(method = "drawGuiContainerForegroundLayer()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGuidebook;drawStringNoShadow(Lnet/minecraft/client/render/FontRenderer;Ljava/lang/String;III)V"))
    public void drawGuiContainerForegroundLayer(GuiGuidebook instance, FontRenderer fontRenderer, String s, int x, int y, int color) {
        instance.drawStringNoShadow(fontRenderer, s, x, y, GUIMod.labelColor);
    }
}
