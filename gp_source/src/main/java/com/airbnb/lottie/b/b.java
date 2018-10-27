package com.airbnb.lottie.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.c;
import com.airbnb.lottie.r;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  public final Context a;
  public c b;
  private final Map c = new HashMap();
  private final Map d;
  private String e;
  
  public b(Drawable.Callback paramCallback, String paramString, c paramc, Map paramMap)
  {
    this.e = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.e;
      if (paramString.charAt(paramString.length() - 1) != '/')
      {
        paramString = new StringBuilder();
        paramString.append(this.e);
        paramString.append('/');
        this.e = paramString.toString();
      }
    }
    if (!(paramCallback instanceof View))
    {
      Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
      this.d = new HashMap();
      this.a = null;
      return;
    }
    this.a = ((View)paramCallback).getContext();
    this.d = paramMap;
    this.b = paramc;
  }
  
  public final Bitmap a(String paramString)
  {
    Object localObject2 = (Bitmap)this.c.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (r)this.d.get(paramString);
      if (localObject1 == null) {
        break label174;
      }
      localObject2 = this.b;
      if (localObject2 == null) {
        break label76;
      }
      localObject2 = ((c)localObject2).a();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.c.put(paramString, localObject2);
        localObject1 = localObject2;
      }
    }
    return (Bitmap)localObject1;
    try
    {
      label76:
      if (TextUtils.isEmpty(this.e)) {
        break label188;
      }
      localObject2 = this.a.getAssets();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append(((r)localObject1).a);
      localObject1 = ((AssetManager)localObject2).open(localStringBuilder.toString());
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inScaled = true;
      ((BitmapFactory.Options)localObject2).inDensity = 160;
      localObject1 = BitmapFactory.decodeStream((InputStream)localObject1, null, (BitmapFactory.Options)localObject2);
      this.c.put(paramString, localObject1);
      return (Bitmap)localObject1;
    }
    catch (IOException paramString)
    {
      label174:
      Log.w("LOTTIE", "Unable to open asset.", paramString);
      return null;
    }
    return null;
    label188:
    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
  }
  
  public final void a()
  {
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ((Bitmap)((Map.Entry)localIterator.next()).getValue()).recycle();
      localIterator.remove();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */