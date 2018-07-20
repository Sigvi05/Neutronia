package net.hdt.neutronia.base.client.gui;

import net.hdt.neutronia.base.lib.LibMisc;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class GuiConfigLink extends GuiConfirmOpenLink {
	
	GuiScreen parent;

	public GuiConfigLink(GuiScreen parentScreenIn) {
		super(parentScreenIn, LibMisc.MOD_WEBSITE, 0, true);
		parent = parentScreenIn;
	}
	
	@Override 
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if(keyCode == 1) // Esc
			returnToParent();
	}
	
	void returnToParent() {
		mc.displayGuiScreen(parent);

		if(mc.currentScreen == null)
			mc.setIngameFocus();
	}

}
