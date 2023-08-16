package useless.config;


import io.github.prospector.modmenu.util.HardcodedUtil;
import net.fabricmc.loader.api.ModContainer;

import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class ModMenuConfig {
	private String labelColor = "FFFFFF";
	public void setLabelColor(String hexColor) {
		this.labelColor = hexColor;
		ModMenuConfigManager.save();
	}
	public int getLabelColor() {
		return Integer.decode("0X" + labelColor);
	}

}
