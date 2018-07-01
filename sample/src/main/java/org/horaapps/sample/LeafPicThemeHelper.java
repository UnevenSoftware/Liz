package org.horaapps.sample;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.orhanobut.hawk.Hawk;

import org.horaapps.liz.ColorPalette;
import org.horaapps.liz.Theme;
import org.horaapps.liz.ThemeHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by dnld on 02/08/16.
 */

public class LeafPicThemeHelper extends ThemeHelper {

    private Context context;

    private Theme baseTheme;
    private int primaryColor;
    private int accentColor;

    public LeafPicThemeHelper(Context context) {
        this.context = context;
    }

    public static LeafPicThemeHelper getInstance(Context context) {
        return new LeafPicThemeHelper(context);
    }

    public static LeafPicThemeHelper getInstanceLoaded(Context context) {
        LeafPicThemeHelper instance = getInstance(context);
        instance.updateTheme();
        return instance;
    }

    public void updateTheme(){
        this.primaryColor = Hawk.get(context.getString(org.horaapps.liz.R.string.preference_primary_color),
                getColor(org.horaapps.liz.R.color.md_indigo_500));
        this.accentColor = Hawk.get(context.getString(org.horaapps.liz.R.string.preference_accent_color),
                getColor(org.horaapps.liz.R.color.md_light_blue_500));
        baseTheme = Theme.fromValue(Hawk.get(context.getString(org.horaapps.liz.R.string.preference_base_theme), 1));
    }

    public int getPrimaryColor() {
        return primaryColor;
    }

    public int getAccentColor() {
        return accentColor;
    }

    public Theme getBaseTheme(){ return baseTheme; }

    public void setBaseTheme(Theme baseTheme) {
        this.baseTheme = baseTheme;
        Hawk.put(context.getString(org.horaapps.liz.R.string.preference_base_theme), getBaseTheme().getValue());
    }

    public static int getPrimaryColor(Context context) {
        return Hawk.get(context.getString(org.horaapps.liz.R.string.preference_primary_color),
                ContextCompat.getColor(context, org.horaapps.liz.R.color.md_indigo_500));
    }


    public boolean isPrimaryEqualAccent(){return (this.primaryColor == this.accentColor);}

    public static int getAccentColor(Context context) {
        return Hawk.get(context.getString(org.horaapps.liz.R.string.preference_accent_color),
                ContextCompat.getColor(context, org.horaapps.liz.R.color.md_light_blue_500));
    }

    public static Theme getBaseTheme(Context context) {
        return Theme.fromValue(Hawk.get(context.getString(org.horaapps.liz.R.string.preference_base_theme), Theme.LIGHT.getValue()));
    }

    public int getColor(@ColorRes int color) {
        return ContextCompat.getColor(context, color);
    }

    private static int getColor(Context context, @ColorRes int color) {
        return ContextCompat.getColor(context, color);
    }

    public void themeSeekBar(SeekBar bar) {
        bar.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(getAccentColor(), PorterDuff.Mode.SRC_IN));
        bar.getThumb().setColorFilter(new PorterDuffColorFilter(getAccentColor(),PorterDuff.Mode.SRC_IN));
    }

    public int getBackgroundColor(){
        switch (baseTheme){
            case DARK:
                return getColor(org.horaapps.liz.R.color.md_dark_background);
            case AMOLED:
                return getColor(org.horaapps.liz.R.color.md_black_1000);
            case LIGHT:
            default:
                return getColor(org.horaapps.liz.R.color.md_light_background);
        }
    }

    public int getInvertedBackgroundColor(){
        switch (baseTheme){
            case DARK:
            case AMOLED:
                return getColor(org.horaapps.liz.R.color.md_light_background);
            case LIGHT: default: return getColor(org.horaapps.liz.R.color.md_dark_background);
        }
    }

    public int getTextColor(){
        switch (baseTheme){
            case DARK:
            case AMOLED:
                return getColor(org.horaapps.liz.R.color.md_grey_200);
            case LIGHT:
            default:
                return getColor(org.horaapps.liz.R.color.md_grey_800);
        }
    }

    public int getSubTextColor(){
        switch (baseTheme){
            case DARK:
            case AMOLED:
                return getColor(org.horaapps.liz.R.color.md_grey_400);
            case LIGHT:
            default:
                return getColor(org.horaapps.liz.R.color.md_grey_600);
        }
    }

    public int getCardBackgroundColor(){
        switch (baseTheme){
            case DARK:
                return getColor(org.horaapps.liz.R.color.md_dark_cards);
            case AMOLED:
                return getColor(org.horaapps.liz.R.color.md_black_1000);
            case LIGHT:
            default:
                return getColor(org.horaapps.liz.R.color.md_light_cards);
        }
    }

    public int getIconColor(){
        if (!(Hawk.get(this.context.getString(org.horaapps.liz.R.string.preference_custom_icon_color), false))) {
            switch (baseTheme){
                case DARK:
                case AMOLED:
                    return getColor(org.horaapps.liz.R.color.md_white_1000);
                case LIGHT:
                default:
                    return getColor(org.horaapps.liz.R.color.md_light_primary_icon);
            }
        } else return getAccentColor();
    }

    public int getButtonBackgroundColor(){
        switch (baseTheme){
            case DARK: return getColor(org.horaapps.liz.R.color.md_grey_700);
            case AMOLED: return getColor(org.horaapps.liz.R.color.md_grey_900);
            case LIGHT: default: return getColor(org.horaapps.liz.R.color.md_grey_200);
        }
    }

    public IconicsDrawable getToolbarIcon(IIcon icon) {
        return new IconicsDrawable(context).icon(icon).color(Color.WHITE).sizeDp(18);
    }

    public static IconicsDrawable getToolbarIcon(Context context, IIcon icon) {
        return new IconicsDrawable(context).icon(icon).color(Color.WHITE).sizeDp(18);
    }

    public IconicsDrawable getIcon(IIcon icon) {
        return new IconicsDrawable(context).icon(icon).color(getIconColor());
    }


    public int getDrawerBackground(){
        switch (baseTheme){
            case DARK:
                return getColor(org.horaapps.liz.R.color.md_dark_cards);
            case AMOLED:
                return getColor(org.horaapps.liz.R.color.md_black_1000);
            case LIGHT:
            default:
                return getColor(org.horaapps.liz.R.color.md_light_cards);
        }
    }

    public Drawable getPlaceHolder(){
        switch (baseTheme){
            case DARK:
                return ContextCompat.getDrawable(context, org.horaapps.liz.R.drawable.ic_empty);
            case AMOLED:
                return ContextCompat.getDrawable(context, org.horaapps.liz.R.drawable.ic_empty_amoled);
            case LIGHT:
                return ContextCompat.getDrawable(context, org.horaapps.liz.R.drawable.ic_empty_white);
        }
        return null;
    }

	/*public CardViewStyle getCardViewStyle() {
		return CardViewStyle.fromValue(Hawk.get("card_view_style", CardViewStyle.MATERIAL.getValue()));
	}*/

    public static Drawable getPlaceHolder(Context context){
        switch (getBaseTheme(context)){
            case DARK:
                return ContextCompat.getDrawable(context, org.horaapps.liz.R.drawable.ic_empty);
            case AMOLED:
                return ContextCompat.getDrawable(context, org.horaapps.liz.R.drawable.ic_empty_amoled);
            case LIGHT:
                return ContextCompat.getDrawable(context, org.horaapps.liz.R.drawable.ic_empty_white);
        }
        return null;
    }

    public int getDialogStyle(){
        switch (baseTheme){
            case DARK: return org.horaapps.liz.R.style.AlertDialog_Dark;
            case AMOLED: return org.horaapps.liz.R.style.AlertDialog_Dark_Amoled;
            case LIGHT: default: return org.horaapps.liz.R.style.AlertDialog_Light;
        }
    }

    public int getPopupToolbarStyle(){
        switch (baseTheme){
            case DARK: return org.horaapps.liz.R.style.DarkActionBarMenu;
            case AMOLED: return org.horaapps.liz.R.style.AmoledDarkActionBarMenu;
            case LIGHT: default: return org.horaapps.liz.R.style.LightActionBarMenu;
        }
    }

    public ArrayAdapter<String> getSpinnerAdapter(ArrayList<String> items) {
        switch (baseTheme){
            case AMOLED: case DARK: return new ArrayAdapter<>(context, org.horaapps.liz.R.layout.spinner_item_light, items);
            case LIGHT: default: return new ArrayAdapter<>(context, org.horaapps.liz.R.layout.spinner_item_dark, items);
        }
    }

    public int getDefaultThemeToolbarColor3th(){
        switch (baseTheme){
            case DARK:
                return getColor(org.horaapps.liz.R.color.md_black_1000);
            case LIGHT:
            default:
            case AMOLED:
                return getColor(org.horaapps.liz.R.color.md_blue_grey_800);
        }
    }

    public ColorStateList getTintList(){
        return new ColorStateList(
                new int[][]{
                        new int[]{ -android.R.attr.state_enabled }, //disabled
                        new int[]{ android.R.attr.state_enabled } //enabled
                }, new int[] { getTextColor(), getAccentColor() });
    }

    public void themeRadioButton(RadioButton radioButton) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            radioButton.setButtonTintList(getTintList());
            radioButton.setTextColor(getTextColor());
        }
    }

    public void themeCheckBox(CheckBox chk) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            chk.setButtonTintList(getTintList());
            chk.setTextColor(getTextColor());
        }
    }

    public void themeButton(Button btn){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btn.setTextColor(getTextColor());
            btn.setBackgroundColor(getButtonBackgroundColor());
        }
    }

    public void setSwitchCompactColor(SwitchCompat sw, int color){
        /** SWITCH HEAD **/
        sw.getThumbDrawable().setColorFilter(
                sw.isChecked() ? color :
                        (baseTheme.equals(Theme.LIGHT) ? getColor(org.horaapps.liz.R.color.md_grey_200) : getColor(org.horaapps.liz.R.color.md_grey_600)),
                PorterDuff.Mode.MULTIPLY);
        /** SWITCH BODY **/
        sw.getTrackDrawable().setColorFilter(
                sw.isChecked() ? ColorPalette.getTransparentColor(color, 100):
                        (baseTheme.equals(Theme.LIGHT) ? getColor(org.horaapps.liz.R.color.md_grey_400) : getColor(org.horaapps.liz.R.color.md_grey_900)),
                PorterDuff.Mode.MULTIPLY);
    }

    public void setTextViewColor(TextView txt, int color){
        txt.setTextColor(color);
    }

    public void setScrollViewColor(ScrollView scr){
        try
        {
            Field mScrollCacheField = View.class.getDeclaredField("mScrollCache");
            mScrollCacheField.setAccessible(true);
            Object mScrollCache = mScrollCacheField.get(scr); // scr is your Scroll View

            Field scrollBarField = mScrollCache.getClass().getDeclaredField("scrollBar");
            scrollBarField.setAccessible(true);
            Object scrollBar = scrollBarField.get(mScrollCache);

            Method method = scrollBar.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
            method.setAccessible(true);

            ColorDrawable ColorDraw = new ColorDrawable(getPrimaryColor());
            method.invoke(scrollBar, ColorDraw);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setColorScrollBarDrawable(Drawable drawable) {
        drawable.setColorFilter(new PorterDuffColorFilter(getPrimaryColor(), PorterDuff.Mode.SRC_ATOP));
    }

    public static void setCursorColor(EditText editText, int color) {
        try {
            Field fCursorDrawableRes =
                    TextView.class.getDeclaredField("mCursorDrawableRes");
            fCursorDrawableRes.setAccessible(true);
            int mCursorDrawableRes = fCursorDrawableRes.getInt(editText);
            Field fEditor = TextView.class.getDeclaredField("mEditor");
            fEditor.setAccessible(true);
            Object editor = fEditor.get(editText);
            Class<?> clazz = editor.getClass();
            Field fCursorDrawable = clazz.getDeclaredField("mCursorDrawable");
            fCursorDrawable.setAccessible(true);

            Drawable[] drawables = new Drawable[2];
            drawables[0] = ContextCompat.getDrawable(editText.getContext(), mCursorDrawableRes);
            drawables[1] = ContextCompat.getDrawable(editText.getContext(), mCursorDrawableRes);
            drawables[0].setColorFilter(color, PorterDuff.Mode.SRC_IN);
            drawables[1].setColorFilter(color, PorterDuff.Mode.SRC_IN);
            fCursorDrawable.set(editor, drawables);
        } catch (final Throwable ignored) {  }
    }
}
