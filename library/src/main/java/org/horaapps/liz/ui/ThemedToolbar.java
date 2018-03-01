package org.horaapps.liz.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import org.horaapps.liz.R;
import org.horaapps.liz.ThemeHelper;
import org.horaapps.liz.Themed;

/**
 * Created by dnld on 01/03/18.
 */

public class ThemedToolbar extends Toolbar implements Themed {

    public ThemedToolbar(Context context) {
        super(context, null, R.style.ToolbarTheme);
    }

    public ThemedToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context);
    }

    public ThemedToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context);
    }

    @Override
    public void refreshTheme(ThemeHelper themeHelper) {
        setBackgroundColor(themeHelper.getPrimaryColor());
    }
}
