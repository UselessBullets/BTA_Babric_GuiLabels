package useless.guimod.mixins;

import net.minecraft.client.gui.GuiContainer;
import net.minecraft.core.block.entity.TileEntityFurnace;
import net.minecraft.client.gui.GuiFurnace;
import net.minecraft.core.player.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import useless.config.ModMenuConfigManager;

@Mixin(value = GuiFurnace.class, remap = false)
public class FurnaceMixin extends GuiContainer {

    // Required for mixin to function
    public FurnaceMixin(Container container) {
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
            this.fontRenderer.drawString("Blast Furnace", 60, 6, ModMenuConfigManager.getConfig().getLabelColor());
        } else {
            this.fontRenderer.drawString("Furnace", 60, 6, ModMenuConfigManager.getConfig().getLabelColor());
        }
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, ModMenuConfigManager.getConfig().getLabelColor());
    }
}
