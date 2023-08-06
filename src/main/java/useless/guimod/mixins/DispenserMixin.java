package useless.guimod.mixins;

import net.minecraft.client.gui.GuiContainer;
import net.minecraft.client.gui.GuiDispenser;
import net.minecraft.core.player.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import useless.guimod.GUIMod;

@Mixin(value = GuiDispenser.class, remap = false)
public class DispenserMixin extends GuiContainer {
    // Required for mixin to function
    public DispenserMixin(Container container) {
        super(container);
    }

    @Shadow
    protected void drawGuiContainerBackgroundLayer(float f) {}

    // Allows for color change on gui text
    /**
     * @author Useless
     * @reason Modify hardcoded strings and their colors
     */
    @Overwrite
    public void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString("Dispenser", 60, 6, GUIMod.GuiTextColor);
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, GUIMod.GuiTextColor);
    }
}
