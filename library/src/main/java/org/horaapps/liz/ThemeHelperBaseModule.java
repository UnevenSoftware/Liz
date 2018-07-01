package org.horaapps.liz;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ThemeHelperBaseModule {

    @Provides @Singleton public ThemeHelper provideThemeHelper() {
        return getThemeHelper();
    }

    public ThemeHelper getThemeHelper() {
        throw new RuntimeException("You must override `ThemeHelperBaseModule.getThemeHelper()`");
    }
}
