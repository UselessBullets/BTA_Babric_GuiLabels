package useless.guimod;

import turniplabs.halplibe.util.ConfigHandler;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class GUIMod implements ModInitializer {
    public static final String MOD_ID = "guimod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ConfigHandler config;
    static {
        Properties props = new Properties();
        props.setProperty("GuiLabelColor", "FFFFFF");
        config = new ConfigHandler(MOD_ID, props);
    }

    public static final int labelColor = Integer.decode("0X" + config.getString("GuiLabelColor"));

    @Override
    public void onInitialize() {
        LOGGER.info("guimod initialized.");
    }
}
