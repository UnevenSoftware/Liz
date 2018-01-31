package org.horaapps.sample;

import android.app.Application;
import com.orhanobut.hawk.Hawk;

/**
 * Created by Jibo on 16/10/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }
}