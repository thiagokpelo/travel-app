package dev.thiagokpelo.viagens.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import dev.thiagokpelo.viagens.model.Package;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable getDrawable(Context context, String drawableInText) {
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(drawableInText, DRAWABLE, context.getPackageName());
        return resources.getDrawable(drawableId);
    }

}
