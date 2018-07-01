package org.horaapps.liz;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ThemeHelperBaseModule.class)
public interface ThemeHelperComponent {
    void inject(ThemedActivity activity);
    void inject(ThemedFragment fragment);
    void inject(ThemedDialogFragment themedDialogFragment);
    void inject(ThemedAlertDialogBuilder themedAlertDialogBuilder);
    void inject(ThemeHelperWrapperBecauseDaggerDontLikeGenerics themeHelperWrapper);
}
