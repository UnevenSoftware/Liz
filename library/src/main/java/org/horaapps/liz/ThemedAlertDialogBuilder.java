package org.horaapps.liz;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;

import javax.inject.Inject;

/**
 * Created by dnld on 4/16/17.
 */

public class ThemedAlertDialogBuilder extends AlertDialog.Builder {

    @Inject ThemeHelper themeHelper;

    public ThemedAlertDialogBuilder(Context context) {
        super(context);
        App.get(context).inject(this);
    }

    @Override
    public AlertDialog.Builder setView(View view) {
        for (View v : ViewUtil.getAllChildren(view))
            if (v instanceof Themed) ((Themed) v).refreshTheme(themeHelper);
        return super.setView(view);
    }
}
