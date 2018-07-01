package org.horaapps.liz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

/**
 * Created by dnld on 01/04/17.
 */

public abstract class ThemedAdapter<VH extends ThemedViewHolder>  extends RecyclerView.Adapter<VH> implements Themed {

    @Inject ThemeHelperWrapperBecauseDaggerDontLikeGenerics themeHelperWrapper;

    public ThemedAdapter(Context context) {
        themeHelperWrapper = new ThemeHelperWrapperBecauseDaggerDontLikeGenerics();
        /*this.setThemeHelper(new StaticThemeProvider(context));*/
        App.get(context).inject(themeHelperWrapper);
    }


    public ThemeHelper getThemeHelper() {
        return themeHelperWrapper.getThemeHelper();
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.refreshTheme(getThemeHelper());
    }

    @Override
    public void refreshTheme(ThemeHelper theme) {
        /*setThemeHelper(theme);*/
        notifyDataSetChanged();
    }
}
