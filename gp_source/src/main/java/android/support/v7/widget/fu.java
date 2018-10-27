package android.support.v7.widget;

import android.util.Log;
import android.view.animation.Interpolator;

public final class fu
{
  public boolean a = false;
  public int b = Integer.MIN_VALUE;
  public int c = 0;
  public int d = 0;
  public Interpolator e = null;
  public int f = -1;
  private int g = 0;
  
  public fu()
  {
    this((byte)0);
  }
  
  private fu(byte paramByte) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.b = paramInt3;
    this.e = paramInterpolator;
    this.a = true;
  }
  
  final void a(RecyclerView paramRecyclerView)
  {
    int i = this.f;
    if (i >= 0)
    {
      this.f = -1;
      paramRecyclerView.e(i);
      this.a = false;
      return;
    }
    if (this.a)
    {
      Interpolator localInterpolator = this.e;
      if ((localInterpolator != null) && (this.b <= 0)) {
        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
      }
      i = this.b;
      if (i <= 0) {
        throw new IllegalStateException("Scroll duration must be a positive number");
      }
      if (localInterpolator != null) {
        paramRecyclerView.L.a(this.c, this.d, i, localInterpolator);
      }
      for (;;)
      {
        this.g += 1;
        if (this.g > 10) {
          Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.a = false;
        return;
        if (i == Integer.MIN_VALUE)
        {
          paramRecyclerView = paramRecyclerView.L;
          i = this.c;
          int j = this.d;
          paramRecyclerView.a(i, j, paramRecyclerView.a(i, j));
        }
        else
        {
          paramRecyclerView.L.a(this.c, this.d, i);
        }
      }
    }
    this.g = 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */