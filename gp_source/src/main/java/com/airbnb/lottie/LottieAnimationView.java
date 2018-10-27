package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import com.airbnb.lottie.c.c.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class LottieAnimationView
  extends AppCompatImageView
{
  public static final Map a = new HashMap();
  public static final Map b = new HashMap();
  public a c;
  public final k d = new k();
  private String e;
  private boolean f = false;
  private i g;
  private g h;
  private final s i = new e(this);
  private boolean j = false;
  
  static
  {
    LottieAnimationView.class.getSimpleName();
  }
  
  public LottieAnimationView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public LottieAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public LottieAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private final void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, w.a);
    int k = paramAttributeSet.getInt(1, g.b.ordinal());
    this.h = g.values()[k];
    Object localObject1 = paramAttributeSet.getString(w.e);
    if (isInEditMode()) {}
    for (;;)
    {
      if (paramAttributeSet.getBoolean(w.b, false))
      {
        this.d.b(true);
        this.f = true;
      }
      this.d.a(paramAttributeSet.getBoolean(w.g, false));
      setImageAssetsFolder(paramAttributeSet.getString(w.f));
      setProgress(paramAttributeSet.getFloat(w.h, 0.0F));
      boolean bool = paramAttributeSet.getBoolean(w.d, false);
      localObject1 = this.d;
      if (Build.VERSION.SDK_INT < 19) {
        Log.w(k.a, "Merge paths are not supported pre-Kit Kat.");
      }
      for (;;)
      {
        if (paramAttributeSet.hasValue(w.c))
        {
          localObject1 = new x(paramAttributeSet.getColor(w.c, 0));
          Object localObject2 = this.d;
          new p((ColorFilter)localObject1);
          ((k)localObject2).c.add(new p((ColorFilter)localObject1));
          localObject2 = ((k)localObject2).e;
          if (localObject2 != null) {
            ((com.airbnb.lottie.c.c.a)localObject2).a(null, null, (ColorFilter)localObject1);
          }
        }
        if (paramAttributeSet.hasValue(w.i)) {
          this.d.d(paramAttributeSet.getFloat(w.i, 1.0F));
        }
        paramAttributeSet.recycle();
        if (com.airbnb.lottie.d.h.a(getContext()) == 0.0F)
        {
          paramAttributeSet = this.d;
          paramAttributeSet.n = true;
          paramAttributeSet.b.e = true;
        }
        setLayerType(1, null);
        return;
        ((k)localObject1).f = bool;
        if (((k)localObject1).d != null) {
          ((k)localObject1).b();
        }
      }
      if (localObject1 != null) {
        setAnimation((String)localObject1);
      }
    }
  }
  
  private final void b()
  {
    k localk = this.d;
    if (localk != null) {
      localk.a();
    }
  }
  
  private final void c()
  {
    a locala = this.c;
    if (locala != null)
    {
      locala.a();
      this.c = null;
    }
  }
  
  public final void a()
  {
    this.d.b(true);
    setLayerType(1, null);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    k localk = this.d;
    localk.a(paramInt1);
    localk.b(paramInt2);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }
  
  public long getDuration()
  {
    i locali = this.g;
    if (locali != null) {
      return locali.a();
    }
    return 0L;
  }
  
  public String getImageAssetsFolder()
  {
    return this.d.k;
  }
  
  public t getPerformanceTracker()
  {
    i locali = this.d.d;
    if (locali != null) {
      return locali.l;
    }
    return null;
  }
  
  public float getProgress()
  {
    return this.d.b.d;
  }
  
  public float getScale()
  {
    return this.d.m;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = getDrawable();
    k localk = this.d;
    if (localDrawable == localk)
    {
      super.invalidateDrawable(localk);
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.f) && (this.j)) {
      a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.d.b.isRunning())
    {
      this.d.d();
      setLayerType(1, null);
      this.j = true;
    }
    b();
    super.onDetachedFromWindow();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof LottieAnimationView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (LottieAnimationView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.e = paramParcelable.a;
    if (!TextUtils.isEmpty(this.e)) {
      setAnimation(this.e);
    }
    setProgress(paramParcelable.e);
    a(paramParcelable.d);
    if (paramParcelable.c) {
      a();
    }
    this.d.k = paramParcelable.b;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    LottieAnimationView.SavedState localSavedState = new LottieAnimationView.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.e;
    com.airbnb.lottie.d.c localc = this.d.b;
    localSavedState.e = localc.d;
    localSavedState.c = localc.isRunning();
    if (this.d.b.getRepeatCount() == -1) {}
    for (boolean bool = true;; bool = false)
    {
      localSavedState.d = bool;
      localSavedState.b = this.d.k;
      return localSavedState;
    }
  }
  
  public void setAnimation(String paramString)
  {
    g localg = this.h;
    this.e = paramString;
    if (b.containsKey(paramString))
    {
      locali = (i)((WeakReference)b.get(paramString)).get();
      if (locali != null)
      {
        setComposition(locali);
        return;
      }
    }
    while (!a.containsKey(paramString))
    {
      i locali;
      this.e = paramString;
      this.d.d();
      c();
      this.c = j.a(getContext(), paramString, new f(this, localg, paramString));
      return;
    }
    setComposition((i)a.get(paramString));
  }
  
  public void setAnimation(JSONObject paramJSONObject)
  {
    c();
    com.airbnb.lottie.c.h localh = new com.airbnb.lottie.c.h(getResources(), this.i);
    localh.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
    this.c = localh;
  }
  
  public void setComposition(i parami)
  {
    this.d.setCallback(this);
    boolean bool = this.d.a(parami);
    setLayerType(1, null);
    if (bool)
    {
      setImageDrawable(null);
      setImageDrawable(this.d);
      this.g = parami;
      requestLayout();
    }
  }
  
  public void setFontAssetDelegate(b paramb)
  {
    Object localObject = this.d;
    ((k)localObject).g = paramb;
    localObject = ((k)localObject).h;
    if (localObject != null) {
      ((com.airbnb.lottie.b.a)localObject).c = paramb;
    }
  }
  
  public void setImageAssetDelegate(c paramc)
  {
    Object localObject = this.d;
    ((k)localObject).i = paramc;
    localObject = ((k)localObject).j;
    if (localObject != null) {
      ((com.airbnb.lottie.b.b)localObject).b = paramc;
    }
  }
  
  public void setImageAssetsFolder(String paramString)
  {
    this.d.k = paramString;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    b();
    c();
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != this.d) {
      b();
    }
    c();
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    b();
    c();
    super.setImageResource(paramInt);
  }
  
  public void setMaxFrame(int paramInt)
  {
    this.d.b(paramInt);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    this.d.b(paramFloat);
  }
  
  public void setMinFrame(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.d.a(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    Object localObject = this.d;
    ((k)localObject).l = paramBoolean;
    localObject = ((k)localObject).d;
    if (localObject != null) {
      ((i)localObject).a(paramBoolean);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    Object localObject = this.d;
    ((k)localObject).b.a(paramFloat);
    localObject = ((k)localObject).e;
    if (localObject != null) {
      ((d)localObject).a(paramFloat);
    }
  }
  
  public void setScale(float paramFloat)
  {
    this.d.d(paramFloat);
    if (getDrawable() == this.d)
    {
      setImageDrawable(null);
      setImageDrawable(this.d);
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    this.d.c(paramFloat);
  }
  
  public void setTextDelegate(y paramy)
  {
    this.d.o = paramy;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/LottieAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */