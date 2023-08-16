package useless.guimod.mixins;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiInventory;
import net.minecraft.client.gui.GuiInventoryCreative;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.options.GuiOptionsButton;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.ContainerPlayerCreative;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import useless.config.ModMenuConfigManager;
import useless.guimod.GUIMod;

@Mixin(value = GuiInventoryCreative.class, remap = false)
public class InventoryCreativeMixin extends GuiInventory implements GuiTextField.ITextChangeListener{


    @Shadow
    private String pageString;
    @Shadow
    private GuiButton lastPageButton;
    @Shadow
    private GuiButton nextPageButton;
    @Shadow
    private GuiOptionsButton clearSearchButton;
    @Shadow
    private GuiTextField searchField;
    @Shadow
    private ContainerPlayerCreative container;

    public InventoryCreativeMixin(EntityPlayer player) {super(player);}

    /**
     * @author Useless
     * @reason Modify hardcoded strings and their colors
     */
    @Overwrite
    public void drawGuiContainerForegroundLayer() {
        super.drawGuiContainerForegroundLayer();
        drawStringCenteredNoShadow(this.fontRenderer, this.pageString, 228, 146, ModMenuConfigManager.getConfig().getLabelColor());
    }

    /**
     * @author Useless
     * @reason Modify hardcoded strings and their colors
     */
    @Overwrite
    public void initGui() {
        super.initGui();
        this.controlList.add(this.lastPageButton = new GuiButton(500, 172, 140, 20, 20, "<"));
        this.controlList.add(this.nextPageButton = new GuiButton(501, 262, 140, 20, 20, ">"));
        this.controlList.add(this.clearSearchButton = new GuiOptionsButton(502, 266, 10, 12, 20, "X"));
        this.searchField = new GuiTextField(this, this.fontRenderer, 173, 7, 96, 18, this.container.searchText, "§8Search...");
        this.searchField.drawBackground = false;
        this.searchField.setMaxStringLength(14);
        this.searchField.setTextChangeListener(this);
        updatePageSwitcher();
        Keyboard.enableRepeatEvents(true);
    }

    @Shadow
    private void updatePageSwitcher() {
    }

    @Shadow
    public void textChanged(GuiTextField guiTextField) {

    }
}
