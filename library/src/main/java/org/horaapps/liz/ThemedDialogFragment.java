package org.horaapps.liz;

import android.content.Context;
import android.support.v4.app.DialogFragment;

import javax.inject.Inject;

/**
 * Created by dnld on 9/9/17.
 */

public class ThemedDialogFragment extends DialogFragment {
    @Inject ThemeHelper themeHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof ThemedActivity)
            themeHelper = ((ThemedActivity) context).getThemeHelper();*/
        App.get(context).inject(this);

    }

    public ThemeHelper getThemeHelper() {
        return themeHelper;
    }

    public int getPrimaryColor() {
        return themeHelper.getPrimaryColor();
    }

    public int getDialogStyle() {
        return themeHelper.getDialogStyle();
    }

    public int getAccentColor() {
        return themeHelper.getAccentColor();
    }

    public Theme getBaseTheme() {
        return themeHelper.getBaseTheme();
    }

    public int getBackgroundColor() {
        return themeHelper.getBackgroundColor();
    }

    public int getCardBackgroundColor() {
        return themeHelper.getCardBackgroundColor();
    }

    public int getIconColor() {
        return themeHelper.getIconColor();
    }

    public int getTextColor() {
        return themeHelper.getTextColor();
    }

    @Override
    public int getTheme() {
        return getDialogStyle();
    }
}
