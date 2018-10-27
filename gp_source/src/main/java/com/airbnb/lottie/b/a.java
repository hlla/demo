package com.airbnb.lottie.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable.Callback;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.b;
import com.airbnb.lottie.c.i;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public final AssetManager a;
  public String b = ".ttf";
  public b c;
  public final Map d = new HashMap();
  public final Map e = new HashMap();
  public final i f = new i();
  
  public a(Drawable.Callback paramCallback, b paramb)
  {
    this.c = paramb;
    if (!(paramCallback instanceof View))
    {
      Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
      this.a = null;
      return;
    }
    this.a = ((View)paramCallback).getContext().getAssets();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */