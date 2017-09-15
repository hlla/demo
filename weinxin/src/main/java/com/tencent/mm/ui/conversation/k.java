package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;

public final class k
{
  com.tencent.mm.pluginsdk.ui.d krI;
  public g vZM;
  public ListView vZj;
  public boolean wcl;
  private ae wcm;
  private Runnable wcn;
  public int wco;
  
  public k()
  {
    GMTrace.i(14516318371840L, 108155);
    this.wcl = false;
    this.wco = -1;
    this.krI = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(14480348020736L, 107887);
        GMTrace.o(14480348020736L, 107887);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        GMTrace.i(14480482238464L, 107888);
        if (paramAnonymousInt == 2) {
          com.tencent.mm.bl.d.bNY().cJ(j.class.getName() + ".Listview", 4);
        }
        if (paramAnonymousInt == 0)
        {
          if (k.this.vZj == null)
          {
            GMTrace.o(14480482238464L, 107888);
            return;
          }
          k.this.BK(-1);
          GMTrace.o(14480482238464L, 107888);
          return;
        }
        k.this.bYE();
        GMTrace.o(14480482238464L, 107888);
      }
    });
    GMTrace.o(14516318371840L, 108155);
  }
  
  public final void BK(int paramInt)
  {
    GMTrace.i(16021167538176L, 119367);
    int i = paramInt;
    if (paramInt < 0) {
      i = 300;
    }
    bYE();
    if (this.wcm == null) {
      this.wcm = new ae("pre load mainui avatar");
    }
    this.wcl = false;
    ae localae = this.wcm;
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14475918835712L, 107854);
        if (k.this.wcl)
        {
          GMTrace.o(14475918835712L, 107854);
          return;
        }
        int m = k.this.vZj.getLastVisiblePosition();
        int j = k.this.vZj.getFirstVisiblePosition();
        int k = m - j;
        if (j == k.this.wco)
        {
          GMTrace.o(14475918835712L, 107854);
          return;
        }
        k.this.wco = j;
        v.d("MicroMsg.PreLoadHelper", "Jacks PreLod to Show, fistVisibleItem: %d, visibleItemCout: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        int i = m + 1;
        while ((i < k.this.vZM.getCount()) && (i < k * 1 + m))
        {
          k.this.vZM.BK(i);
          i += 1;
        }
        i = j - 1;
        while ((i >= 0) && (i > j - k * 1))
        {
          k.this.vZM.BK(i);
          i -= 1;
        }
        GMTrace.o(14475918835712L, 107854);
      }
    };
    this.wcn = local3;
    localae.e(local3, i);
    GMTrace.o(16021167538176L, 119367);
  }
  
  public final void bYE()
  {
    GMTrace.i(14516452589568L, 108156);
    if (!this.wcl)
    {
      v.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
      this.wcl = true;
    }
    if ((this.wcm != null) && (this.wcn != null)) {
      this.wcm.bJb().removeCallbacks(this.wcn);
    }
    GMTrace.o(14516452589568L, 108156);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */