package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelbiz.a.b;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.a.k;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;

public final class d
  extends o
  implements m.b
{
  private Cursor ips;
  private String jZw;
  private int oQp;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, false);
    GMTrace.i(2996410777600L, 22325);
    v.i("MicroMsg.RecentConversationAdapter", "create!");
    this.jZw = paramString;
    atX();
    GMTrace.o(2996410777600L, 22325);
  }
  
  private void atX()
  {
    GMTrace.i(2996544995328L, 22326);
    v.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.ips != null)
    {
      this.ips.close();
      this.ips = null;
    }
    this.ips = w.DK().ip(this.jZw);
    this.oQp = 0;
    GMTrace.o(2996544995328L, 22326);
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    GMTrace.i(2997081866240L, 22330);
    atX();
    notifyDataSetChanged();
    GMTrace.o(2997081866240L, 22330);
  }
  
  public final void finish()
  {
    GMTrace.i(2996947648512L, 22329);
    super.finish();
    v.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.ips != null)
    {
      this.ips.close();
      this.ips = null;
    }
    GMTrace.o(2996947648512L, 22329);
  }
  
  public final int getCount()
  {
    GMTrace.i(2996679213056L, 22327);
    int i = this.ips.getCount();
    GMTrace.o(2996679213056L, 22327);
    return i + 1;
  }
  
  protected final com.tencent.mm.ui.contact.a.a hf(int paramInt)
  {
    GMTrace.i(2996813430784L, 22328);
    Object localObject = null;
    if (paramInt == this.oQp)
    {
      localObject = new g(paramInt);
      ((g)localObject).mbB = this.vWg.getActivity().getResources().getString(R.l.eQl);
    }
    for (;;)
    {
      GMTrace.o(2996813430784L, 22328);
      return (com.tencent.mm.ui.contact.a.a)localObject;
      if ((paramInt > this.oQp) && (this.ips.moveToPosition(paramInt - this.oQp - 1)))
      {
        a locala = new a(paramInt);
        com.tencent.mm.modelbiz.a.a locala1 = new com.tencent.mm.modelbiz.a.a();
        locala1.b(this.ips);
        localObject = locala;
        if (locala.jZq == -1L)
        {
          locala.jZq = locala1.field_bizChatId;
          localObject = w.DJ().aa(locala1.field_bizChatId);
          if (((c)localObject).DV())
          {
            locala.ioW = ((c)localObject).field_chatName;
            locala.vtv = ((c)localObject).field_headImageUrl;
            locala.username = ((c)localObject).field_brandUserName;
          }
          for (;;)
          {
            if (bf.J(locala.ioW)) {
              locala.ioW = this.vWg.getActivity().getResources().getString(R.l.eMt);
            }
            localObject = locala;
            if (!bf.mA(locala.username)) {
              break;
            }
            locala.username = locala1.field_brandUserName;
            localObject = locala;
            break;
            localObject = w.DL().iE(((c)localObject).field_bizChatServId);
            if (localObject != null)
            {
              locala.ioW = ((j)localObject).field_userName;
              locala.vtv = ((j)localObject).field_headImageUrl;
              locala.username = ((j)localObject).field_brandUserName;
            }
          }
        }
      }
      else
      {
        v.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bizchat/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */