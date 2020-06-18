package com.pmrelvas.udamatematica.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pmrelvas.udamatematica.MathUGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "U da Matemática";
		config.width = MathUGame.V_WIDTH;
		config.height = MathUGame.V_HEIGHT;
		config.fullscreen = true;

		new LwjglApplication(new MathUGame(), config);
	}
}
