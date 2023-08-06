package useless.guimod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GUIMod implements ModInitializer {

    public static int GuiTextColor = 0XFFFFFF;
    public static final String MOD_ID = "guimod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("guimod initialized.");
    }
}
