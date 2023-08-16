package useless.config;


import useless.guimod.GUIMod;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;

public class ModMenuConfigManager {
	private static File file;
	private static ModMenuConfig config;

	private static void prepareBiomeConfigFile() {
		if (file != null) {
			return;
		}
		file = new File(FabricLoader.getInstance().getConfigDirectory(), GUIMod.MOD_ID + ".json");
	}

	public static ModMenuConfig initializeConfig() {
		if (config != null) {
			return config;
		}

		config = new ModMenuConfig();
		load();

		return config;
	}

	private static void load() {
		prepareBiomeConfigFile();

		try {
			if (!file.exists()) {
				save();
			}
			if (file.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(file));

				config = GUIMod.GSON.fromJson(br, ModMenuConfig.class);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't load GuiLabel configuration file; reverting to defaults");
			e.printStackTrace();
		}
	}

	public static void save() {
		prepareBiomeConfigFile();

		String jsonString = GUIMod.GSON.toJson(config);

		try (FileWriter fileWriter = new FileWriter(file)) {
			fileWriter.write(jsonString);
		} catch (IOException e) {
			System.err.println("Couldn't save GuiLabel configuration file");
			e.printStackTrace();
		}
	}

	public static ModMenuConfig getConfig() {
		return config;
	}
}
