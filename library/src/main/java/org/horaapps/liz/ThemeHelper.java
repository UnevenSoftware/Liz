package org.horaapps.liz;

/**
 * Created by dnld on 02/08/16.
 */

public abstract class ThemeHelper {


	public ThemeHelper() {
	}


	public abstract int getPrimaryColor();

	public abstract int getAccentColor();

	public abstract Theme getBaseTheme();


	public boolean isPrimaryEqualAccent() {
		return getAccentColor() == getPrimaryColor();
	}

	public abstract int getBackgroundColor();

	public abstract int getInvertedBackgroundColor();

	public abstract int getTextColor();

	public abstract int getSubTextColor();

	public abstract int getCardBackgroundColor();

	public abstract int getIconColor();

	public int getDialogStyle() {
		return R.style.AlertDialog_Light;
	}

	public int getPopupToolbarStyle(){
		return R.style.LightActionBarMenu;
	}
}
