package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ac;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class e
  extends ImageView
{
  public Animation.AnimationListener a;
  public int b;
  
  e(Context paramContext)
  {
    super(paramContext);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.b = ((int)(3.5F * f));
    if (a())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      ac.g(this, f * 4.0F);
    }
    for (;;)
    {
      paramContext.getPaint().setColor(-328966);
      ac.a(this, paramContext);
      return;
      paramContext = new ShapeDrawable(new f(this, this.b));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.b, j, i, 503316480);
      i = this.b;
      setPadding(i, i, i, i);
    }
  }
  
  private static boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public final void onAnimationEnd()
  {
    super.onAnimationEnd();
    Animation.AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationEnd(getAnimation());
    }
  }
  
  public final void onAnimationStart()
  {
    super.onAnimationStart();
    Animation.AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(getAnimation());
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!a())
    {
      paramInt1 = getMeasuredWidth();
      paramInt2 = this.b;
      int i = getMeasuredHeight();
      int j = this.b;
      setMeasuredDimension(paramInt1 + (paramInt2 + paramInt2), j + j + i);
    }
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */