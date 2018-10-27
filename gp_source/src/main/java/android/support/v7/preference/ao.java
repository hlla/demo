package android.support.v7.preference;

import android.support.v7.widget.fz;
import android.util.SparseArray;
import android.view.View;

public final class ao
  extends fz
{
  public boolean a;
  public boolean b;
  private final SparseArray r = new SparseArray(4);
  
  ao(View paramView)
  {
    super(paramView);
    this.r.put(16908310, paramView.findViewById(16908310));
    this.r.put(16908304, paramView.findViewById(16908304));
    this.r.put(16908294, paramView.findViewById(16908294));
    this.r.put(2131428313, paramView.findViewById(2131428313));
    this.r.put(16908350, paramView.findViewById(16908350));
  }
  
  public final View a(int paramInt)
  {
    View localView2 = (View)this.r.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView2 = this.c.findViewById(paramInt);
      localView1 = localView2;
      if (localView2 != null)
      {
        this.r.put(paramInt, localView2);
        localView1 = localView2;
      }
    }
    return localView1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */