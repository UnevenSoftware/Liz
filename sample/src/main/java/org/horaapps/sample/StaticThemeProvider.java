package org.horaapps.sample;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;

import org.horaapps.liz.Theme;
import org.horaapps.liz.ThemeHelper;

public class StaticThemeProvider extends ThemeHelper {

    private Context context;

    public StaticThemeProvider(Context context) {
        this.context = context;
    }

    @Override
    public int getPrimaryColor() {
        return getColor(org.horaapps.liz.R.color.md_indigo_500);
    }

    @Override
    public int getAccentColor() {
        return getColor(org.horaapps.liz.R.color.md_light_blue_500);
    }

    @Override
    public Theme getBaseTheme() {
        return Theme.LIGHT;
    }

    @Override
    public int getBackgroundColor() {
        return getColor(org.horaapps.liz.R.color.md_light_background);
    }

    @Override
    public int getInvertedBackgroundColor() {
        return 0;
    }

    @Override
    public int getTextColor() {
        return getColor(org.horaapps.liz.R.color.md_grey_800);
    }

    @Override
    public int getSubTextColor() {
        return getColor(org.horaapps.liz.R.color.md_grey_600);
    }

    @Override
    public int getCardBackgroundColor() {
        return getColor(org.horaapps.liz.R.color.md_light_cards);
    }

    @Override
    public int getIconColor() {
        return getColor(org.horaapps.liz.R.color.md_light_primary_icon);
    }

    public int getColor(@ColorRes int color) {
        return ContextCompat.getColor(context, color);
    }
}
