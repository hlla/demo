package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.a.k;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class p
  extends q
{
  private String fRC;
  private ad handler;
  private Cursor ips;
  private String jZw;
  private m.a vWf;
  private List<String> vWy;
  
  public p(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, 0);
    GMTrace.i(1840527704064L, 13713);
    this.handler = new ad(Looper.getMainLooper());
    this.vWy = null;
    this.jZw = paramString;
    v.i("MicroMsg.MMSearchContactAdapter", "Create!");
    Of();
    GMTrace.o(1840527704064L, 13713);
  }
  
  private void Of()
  {
    GMTrace.i(1840930357248L, 13716);
    v.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.fRC = null;
    clearCache();
    GMTrace.o(1840930357248L, 13716);
  }
  
  public final void a(m.a parama)
  {
    GMTrace.i(1840661921792L, 13714);
    this.vWf = parama;
    GMTrace.o(1840661921792L, 13714);
  }
  
  public final void aZ(String paramString, boolean paramBoolean)
  {
    GMTrace.i(1840796139520L, 13715);
    if (this.vWf != null) {
      this.vWf.r(paramString, getCount(), paramBoolean);
    }
    GMTrace.o(1840796139520L, 13715);
  }
  
  protected final boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    GMTrace.i(1841467228160L, 13720);
    GMTrace.o(1841467228160L, 13720);
    return true;
  }
  
  public final void finish()
  {
    GMTrace.i(1841333010432L, 13719);
    super.finish();
    v.i("MicroMsg.MMSearchContactAdapter", "finish!");
    Of();
    GMTrace.o(1841333010432L, 13719);
  }
  
  public final int getCount()
  {
    GMTrace.i(1841064574976L, 13717);
    if (this.ips == null)
    {
      GMTrace.o(1841064574976L, 13717);
      return 0;
    }
    int i = this.ips.getCount();
    GMTrace.o(1841064574976L, 13717);
    return i;
  }
  
  protected final com.tencent.mm.ui.contact.a.a hf(int paramInt)
  {
    GMTrace.i(1841198792704L, 13718);
    Object localObject = null;
    com.tencent.mm.ui.bizchat.a locala;
    c localc;
    if ((paramInt >= 0) && (this.ips.moveToPosition(paramInt)))
    {
      locala = new com.tencent.mm.ui.bizchat.a(paramInt);
      localc = new c();
      localc.b(this.ips);
      localObject = locala;
      if (locala.jZq == -1L)
      {
        locala.jZq = localc.field_bizChatLocalId;
        if (!localc.DV()) {
          break label178;
        }
        locala.ioW = localc.field_chatName;
        locala.vtv = localc.field_headImageUrl;
        locala.username = localc.field_brandUserName;
        if (bf.J(locala.ioW)) {
          locala.ioW = this.vWg.getActivity().getResources().getString(R.l.eMt);
        }
        localObject = locala;
        if (bf.mA(locala.username))
        {
          locala.username = localc.field_brandUserName;
          localObject = locala;
        }
      }
    }
    for (;;)
    {
      GMTrace.o(1841198792704L, 13718);
      return (com.tencent.mm.ui.contact.a.a)localObject;
      label178:
      localObject = w.DL().iE(localc.field_bizChatServId);
      if (localObject == null) {
        break;
      }
      locala.ioW = ((j)localObject).field_userName;
      locala.vtv = ((j)localObject).field_headImageUrl;
      locala.username = ((j)localObject).field_brandUserName;
      break;
      v.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */