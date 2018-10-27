package com.google.android.finsky.bc.a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.android.finsky.be.y;
import com.google.wireless.android.finsky.dfe.e.a.eb;

final class ao
  implements OnItemSelectedListener
{
  private final d a;
  private Integer b;
  private final eb c;
  private final w d;
  private final y e;
  
  ao(d paramd, w paramw, eb parameb, y paramy, Integer paramInteger)
  {
    this.a = paramd;
    this.d = paramw;
    this.c = parameb;
    this.e = paramy;
    this.b = paramInteger;
  }
  
  public final void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.c;
    if ((paramAdapterView.a & 0x1) != 0)
    {
      paramAdapterView = this.d.b(paramAdapterView.d);
      paramView = this.d;
      eb localeb = this.c;
      paramView.a(localeb.d, localeb.e[paramInt]);
      this.e.a(new String[] { paramAdapterView, this.c.e[paramInt] });
    }
    paramAdapterView = this.b;
    if ((paramAdapterView != null) && (paramAdapterView.intValue() != paramInt))
    {
      paramAdapterView = this.c.b;
      if (paramAdapterView != null) {
        this.a.a(paramAdapterView);
      }
    }
    this.b = Integer.valueOf(paramInt);
  }
  
  public final void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */