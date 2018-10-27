package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class aa
{
  public EdgeEffect a;
  
  @Deprecated
  public aa(Context paramContext)
  {
    this.a = new EdgeEffect(paramContext);
  }
  
  public static void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
      return;
    }
    paramEdgeEffect.onPull(paramFloat1);
  }
  
  @Deprecated
  public final void a(int paramInt1, int paramInt2)
  {
    this.a.setSize(paramInt1, paramInt2);
  }
  
  @Deprecated
  public final boolean a()
  {
    this.a.onRelease();
    return this.a.isFinished();
  }
  
  @Deprecated
  public final boolean a(float paramFloat)
  {
    this.a.onPull(paramFloat);
    return true;
  }
  
  @Deprecated
  public final boolean a(Canvas paramCanvas)
  {
    return this.a.draw(paramCanvas);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */