package org.horaapps.liz;

import javax.inject.Inject;

import dagger.Lazy;

public class ThemeHelperWrapperBecauseDaggerDontLikeGenerics {
    @Inject Lazy<ThemeHelper> themeHelperLazy;

    public ThemeHelper getThemeHelper() {
        return themeHelperLazy.get();
    }
}
