package android.support.f;

import android.view.View;
import android.view.WindowId;

final class bm
{
  private final WindowId a;
  
  bm(View paramView)
  {
    this.a = paramView.getWindowId();
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bm)) && (((bm)paramObject).a.equals(this.a));
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */