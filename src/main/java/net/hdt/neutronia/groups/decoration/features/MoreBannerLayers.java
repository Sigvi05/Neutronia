package net.hdt.neutronia.groups.decoration.features;

import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.groups.GroupLoader;

public class MoreBannerLayers extends Component {

	public static int layers;
	
	@Override
	public void setupConfig() {
		layers = loadPropInt("Survival Layer Count", "", 16);
	}
	
	public static int getLayerCount() {
		return GroupLoader.isFeatureEnabled(MoreBannerLayers.class) ? layers : 6;
	}
	

}
