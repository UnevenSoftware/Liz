package org.horaapps.sample;

import android.content.Context;

import org.horaapps.liz.ThemeHelper;
import org.horaapps.liz.ThemeHelperBaseModule;

import dagger.Module;

@Module
public class ThemeHelperModule extends ThemeHelperBaseModule {

    private Context context;

    public ThemeHelperModule(Context context) {
        this.context = context;
    }

    @Override
    public ThemeHelper getThemeHelper() {
        return new StaticThemeProvider(context);
    }

}
