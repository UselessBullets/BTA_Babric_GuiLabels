package useless.guimod.mixins;

import net.minecraft.client.gui.GuiContainer;
import net.minecraft.client.gui.GuiInventory;
import net.minecraft.core.player.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import useless.config.ModMenuConfigManager;
import useless.guimod.GUIMod;

@Mixin(value = GuiInventory.class, remap = false)
public class InventoryMixin extends GuiContainer {

    // Required for mixin to function
    public InventoryMixin(Container container) {
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
        this.fontRenderer.drawString("Crafting", 86, 16, ModMenuConfigManager.getConfig().getLabelColor());
    }

}