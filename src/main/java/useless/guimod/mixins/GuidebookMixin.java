package useless.guimod.mixins;

import net.minecraft.client.gui.GuiContainer;
import net.minecraft.client.gui.GuiGuidebook;
import net.minecraft.core.player.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import useless.config.ModMenuConfigManager;
import useless.guimod.GUIMod;

@Mixin(value = GuiGuidebook.class, remap = false)
public class GuidebookMixin extends GuiContainer {
    @Shadow
    protected String pageString = "1/1";

    public GuidebookMixin(Container container) {super(container);}

    @Shadow
    protected void drawGuiContainerBackgroundLayer(float f) {}

    /**
     * @author Useless
     * @reason Modify hardcoded strings and their colors
     */
    @Overwrite
    public void drawGuiContainerForegroundLayer() {
        drawStringNoShadow(this.fontRenderer, "Guidebook", -58, -15, ModMenuConfigManager.getConfig().getLabelColor());
        drawStringNoShadow(this.fontRenderer, this.pageString, 304 - this.fontRenderer.getStringWidth(this.pageString) - 70, -15, ModMenuConfigManager.getConfig().getLabelColor());
    }
}
