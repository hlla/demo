package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class r
  extends q
{
  private String fRC;
  private ad handler;
  private Map<String, String> vWM;
  private List<String> vWN;
  private m.a vWf;
  private List<String> vWy;
  
  public r(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, String paramString)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean, 0);
    GMTrace.i(1764157816832L, 13144);
    this.vWM = new HashMap();
    this.vWN = new ArrayList();
    this.handler = new ad(Looper.getMainLooper());
    this.vWy = paramList;
    if (!bf.mA(paramString))
    {
      this.vWN = bf.f(paramString.split(","));
      if (this.vWN != null)
      {
        paramMMBaseSelectContactUI = this.vWN.iterator();
        while (paramMMBaseSelectContactUI.hasNext())
        {
          paramList = (String)paramMMBaseSelectContactUI.next();
          paramString = n.eK(paramList);
          if (!bf.mA(paramString)) {
            this.vWM.put(paramString, paramList);
          }
        }
      }
    }
    Of();
    GMTrace.o(1764157816832L, 13144);
  }
  
  private void Of()
  {
    GMTrace.i(1764560470016L, 13147);
    this.fRC = null;
    clearCache();
    GMTrace.o(1764560470016L, 13147);
  }
  
  public final void a(m.a parama)
  {
    GMTrace.i(1764292034560L, 13145);
    this.vWf = parama;
    GMTrace.o(1764292034560L, 13145);
  }
  
  public final void aZ(String paramString, boolean paramBoolean)
  {
    GMTrace.i(1764426252288L, 13146);
    if (this.vWf != null) {
      this.vWf.r(paramString, getCount(), paramBoolean);
    }
    GMTrace.o(1764426252288L, 13146);
  }
  
  protected final boolean c(a parama)
  {
    GMTrace.i(1765097340928L, 13151);
    GMTrace.o(1765097340928L, 13151);
    return true;
  }
  
  public final void finish()
  {
    GMTrace.i(1764963123200L, 13150);
    super.finish();
    Of();
    GMTrace.o(1764963123200L, 13150);
  }
  
  public final int getCount()
  {
    GMTrace.i(1764694687744L, 13148);
    if (this.vWN == null)
    {
      GMTrace.o(1764694687744L, 13148);
      return 0;
    }
    int i = this.vWN.size();
    GMTrace.o(1764694687744L, 13148);
    return i;
  }
  
  protected final a hf(int paramInt)
  {
    GMTrace.i(1764828905472L, 13149);
    d locald = new d(paramInt);
    locald.fRC = this.fRC;
    ap.yY();
    locald.jht = c.wR().QZ((String)this.vWN.get(paramInt));
    locald.vWh = bcI();
    GMTrace.o(1764828905472L, 13149);
    return locald;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */