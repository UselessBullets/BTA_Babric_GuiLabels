package useless.guimod.mixins;


import net.minecraft.client.gui.GuiChest;
import net.minecraft.client.gui.GuiContainer;
import net.minecraft.client.gui.GuiCrafting;
import net.minecraft.core.block.entity.TileEntityBlastFurnace;
import net.minecraft.core.player.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import useless.config.ModMenuConfigManager;
import useless.guimod.GUIMod;
import net.minecraft.core.player.inventory.IInventory;


@Mixin(value = GuiChest.class, remap = false)
public class ChestMixin extends GuiContainer {

    @Shadow
    private IInventory upperChestInventory;
    @Shadow

    private IInventory lowerChestInventory;

    // Required for mixin to function
    public ChestMixin(Container container) {
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
        this.fontRenderer.drawString(this.lowerChestInventory.getInvName(), 8, 6, ModMenuConfigManager.getConfig().getLabelColor());
        this.fontRenderer.drawString(this.upperChestInventory.getInvName(), 8, this.ySize - 96 + 2, ModMenuConfigManager.getConfig().getLabelColor());
    }
}
