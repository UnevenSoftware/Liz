package org.horaapps.liz;

import android.app.Application;
import android.content.Context;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.NoEncryption;

/**
 * Created by dnld on 6/29/17.
 */

public class App extends Application {


    ThemeHelperComponent themeHelperComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(getApplicationContext()).setEncryption(new NoEncryption()).build();
    }

    public void setupDi(ThemeHelperBaseModule themeHelperBaseModule) {
        themeHelperComponent = DaggerThemeHelperComponent.builder()
                .themeHelperBaseModule(themeHelperBaseModule)
                .build();
    }

    public ThemeHelperComponent getThemeHelperComponent() {
        return themeHelperComponent;
    }

    public static ThemeHelperComponent get(Context context) {
        return ((App) context.getApplicationContext()).getThemeHelperComponent();
    }

}
