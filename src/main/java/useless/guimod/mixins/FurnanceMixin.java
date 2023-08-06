package useless.guimod.mixins;

import net.minecraft.client.gui.GuiContainer;
import net.minecraft.core.block.entity.TileEntityFurnace;
import net.minecraft.client.gui.GuiFurnace;
import net.minecraft.core.player.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import useless.guimod.GUIMod;

@Mixin(value = GuiFurnace.class, remap = false)
public class FurnanceMixin extends GuiContainer {

    // Required for mixin to function
    public FurnanceMixin(Container container) {
        super(container);
    }

    @Shadow
    private TileEntityFurnace furnaceInventory;
    @Shadow
    protected void drawGuiContainerBackgroundLayer(float f) {}

    // Allows for color change on gui text
    /**
     * @author Useless
     * @reason Modify hardcoded strings and their colors
     */
    @Overwrite
    public void drawGuiContainerForegroundLayer() {
        if (this.furnaceInventory instanceof net.minecraft.core.block.entity.TileEntityBlastFurnace) {
            this.fontRenderer.drawString("Blast Furnace", 60, 6, GUIMod.GuiTextColor);
        } else {
            this.fontRenderer.drawString("Furnace", 60, 6, GUIMod.GuiTextColor);
        }
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, GUIMod.GuiTextColor);
    }
}
