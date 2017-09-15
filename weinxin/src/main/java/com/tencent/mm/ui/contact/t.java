package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.b;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.g;
import java.util.List;

public final class t
  extends o
  implements m.b
{
  private Cursor ips;
  private int oQp;
  private List<String> vXi;
  private int vXj;
  private boolean vXk;
  private int vXl;
  
  public t(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList)
  {
    this(paramMMBaseSelectContactUI, paramList, true, false, false, 0);
    GMTrace.i(1812744634368L, 13506);
    GMTrace.o(1812744634368L, 13506);
  }
  
  public t(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    GMTrace.i(1812878852096L, 13507);
    this.vXl = 0;
    v.i("MicroMsg.RecentConversationAdapter", "create!");
    this.vXk = paramBoolean3;
    this.vXl = paramInt;
    atX();
    ap.yY();
    c.wW().a(this);
    GMTrace.o(1812878852096L, 13507);
  }
  
  private void atX()
  {
    int j = 0;
    GMTrace.i(1813013069824L, 13508);
    v.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.ips != null)
    {
      this.ips.close();
      this.ips = null;
    }
    if (s.ee(this.vXl, 4))
    {
      ap.yY();
      this.ips = c.wW().b(com.tencent.mm.u.o.hld, this.jzO, this.vWx, "");
      if (!this.vXk) {
        break label210;
      }
    }
    label210:
    for (int i = 2;; i = 0)
    {
      if (this.vXi != null) {
        j = this.vXi.size();
      }
      this.vXj = j;
      this.oQp = (i + this.vXj);
      clearCache();
      GMTrace.o(1813013069824L, 13508);
      return;
      if (s.ee(this.vXl, 16))
      {
        ap.yY();
        this.ips = c.wW().b(com.tencent.mm.u.o.hlf, this.jzO, this.vWx, "");
        break;
      }
      ap.yY();
      this.ips = c.wW().b(com.tencent.mm.u.o.hkZ, this.jzO, this.vWx, "");
      break;
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    GMTrace.i(1813549940736L, 13512);
    atX();
    notifyDataSetChanged();
    GMTrace.o(1813549940736L, 13512);
  }
  
  public final void finish()
  {
    GMTrace.i(1813415723008L, 13511);
    super.finish();
    v.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.ips != null)
    {
      this.ips.close();
      this.ips = null;
    }
    ap.yY();
    c.wW().b(this);
    GMTrace.o(1813415723008L, 13511);
  }
  
  public final int getCount()
  {
    GMTrace.i(1813147287552L, 13509);
    int i = this.ips.getCount();
    int j = this.oQp;
    GMTrace.o(1813147287552L, 13509);
    return i + j + 1;
  }
  
  protected final a hf(int paramInt)
  {
    ae localae = null;
    GMTrace.i(1813281505280L, 13510);
    Object localObject;
    if (this.oQp > this.vXj) {
      if (paramInt == this.vXj)
      {
        localObject = new g(paramInt);
        ((g)localObject).mbB = this.vWg.getActivity().getResources().getString(R.l.dCA);
      }
    }
    for (;;)
    {
      if (paramInt == this.oQp)
      {
        localObject = new g(paramInt);
        ((g)localObject).mbB = this.vWg.getActivity().getResources().getString(R.l.eQl);
      }
      for (;;)
      {
        GMTrace.o(1813281505280L, 13510);
        return (a)localObject;
        if (paramInt != this.vXj + 1) {
          break label366;
        }
        localObject = new b(paramInt);
        String str = this.vWg.getActivity().getResources().getString(R.l.dCA);
        ((b)localObject).roM = R.k.dwl;
        ((b)localObject).aIO = str;
        break;
        if (paramInt < this.vXj)
        {
          localObject = localae;
          if (this.vXi != null)
          {
            localObject = localae;
            if (paramInt >= 0)
            {
              localObject = localae;
              if (paramInt < this.vXi.size())
              {
                localObject = new b(paramInt);
                ((b)localObject).username = ((String)this.vXi.get(paramInt));
              }
            }
          }
        }
        else if ((paramInt > this.oQp) && (this.ips.moveToPosition(paramInt - this.oQp - 1)))
        {
          localObject = new e(paramInt);
          localae = new ae();
          localae.b(this.ips);
          ap.yY();
          ((a)localObject).jht = c.wR().QW(localae.field_username);
          if (((a)localObject).jht == null)
          {
            ap.yY();
            ((a)localObject).jht = c.wR().Ra(localae.field_username);
          }
          ((a)localObject).vWh = bcI();
        }
        else
        {
          v.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
      label366:
      localObject = null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */