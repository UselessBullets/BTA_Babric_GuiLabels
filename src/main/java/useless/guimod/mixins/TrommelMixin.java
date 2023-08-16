package useless.guimod.mixins;

import net.minecraft.client.gui.GuiContainer;
import net.minecraft.client.gui.GuiTrommel;
import net.minecraft.core.player.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import useless.config.ModMenuConfigManager;
import useless.guimod.GUIMod;

@Mixin(value = GuiTrommel.class, remap = false)
public class TrommelMixin extends GuiContainer {

    public TrommelMixin(Container container) {super(container);}

    @Shadow
    protected void drawGuiContainerBackgroundLayer(float f) {}

    // Allows for color change on gui text
    /**
     * @author Useless
     * @reason Modify hardcoded strings and their colors
     */
    @Overwrite
    public void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString("Trommel", 60, 6, ModMenuConfigManager.getConfig().getLabelColor());
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, ModMenuConfigManager.getConfig().getLabelColor());
    }
}
