package useless.guimod;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import useless.config.ModMenuConfig;
import useless.config.ModMenuConfigManager;


public class GUIMod implements ModInitializer {
    public static final Gson GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
    public static final String MOD_ID = "guimod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModMenuConfigManager.initializeConfig();
        LOGGER.info("guimod initialized.");
    }

}
