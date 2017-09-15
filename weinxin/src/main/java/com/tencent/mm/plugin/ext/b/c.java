package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.gw;
import com.tencent.mm.e.a.gw.b;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private static Map<String, a> lot;
  final e gUt;
  private String lor;
  private boolean los;
  public Context mContext;
  
  static
  {
    GMTrace.i(5713648680960L, 42570);
    lot = null;
    GMTrace.o(5713648680960L, 42570);
  }
  
  public c(Context paramContext, String paramString)
  {
    GMTrace.i(5712172285952L, 42559);
    this.lor = "";
    this.los = false;
    this.mContext = null;
    this.gUt = new e()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
      {
        GMTrace.i(5712038068224L, 42558);
        ap.vd().b(106, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
          paramAnonymousString = ((aa)paramAnonymousk).Jy();
          v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", new Object[] { Integer.valueOf(paramAnonymousString.tCj) });
          if (paramAnonymousString.tCj > 0)
          {
            if (paramAnonymousString.tCk.isEmpty())
            {
              v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
              c.this.b(paramAnonymousString);
            }
            if (paramAnonymousString.tCk.size() > 1) {
              try
              {
                paramAnonymousk = new Intent();
                paramAnonymousk.putExtra("add_more_friend_search_scene", 3);
                paramAnonymousk.putExtra("result", paramAnonymousString.toByteArray());
                v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                com.tencent.mm.plugin.ext.a.imb.x(paramAnonymousk, c.this.mContext);
                GMTrace.o(5712038068224L, 42558);
                return;
              }
              catch (IOException paramAnonymousString)
              {
                v.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", paramAnonymousString, "", new Object[0]);
                GMTrace.o(5712038068224L, 42558);
                return;
              }
            }
            c.this.a((awm)paramAnonymousString.tCk.getFirst());
            GMTrace.o(5712038068224L, 42558);
            return;
          }
          v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
          c.this.a(paramAnonymousString);
          GMTrace.o(5712038068224L, 42558);
          return;
        }
        v.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.this.b(null);
        GMTrace.o(5712038068224L, 42558);
      }
    };
    this.mContext = paramContext;
    this.lor = paramString;
    this.los = true;
    GMTrace.o(5712172285952L, 42559);
  }
  
  private int a(String paramString, awo paramawo, awm paramawm)
  {
    GMTrace.i(5712574939136L, 42562);
    if (this.mContext == null)
    {
      v.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
      GMTrace.o(5712574939136L, 42562);
      return -1;
    }
    if (!bf.mA(paramString))
    {
      ap.yY();
      if (com.tencent.mm.u.c.wR().QX(paramString))
      {
        v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
        vx(paramString);
        GMTrace.o(5712574939136L, 42562);
        return 0;
      }
    }
    if (paramawo != null)
    {
      v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
      a(paramawo);
      GMTrace.o(5712574939136L, 42562);
      return 1;
    }
    if (paramawm != null)
    {
      v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
      a(paramawm);
      GMTrace.o(5712574939136L, 42562);
      return 1;
    }
    v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
    GMTrace.o(5712574939136L, 42562);
    return -1;
  }
  
  private static void a(String paramString, a parama)
  {
    GMTrace.i(5712440721408L, 42561);
    if (bf.mA(paramString))
    {
      v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
      GMTrace.o(5712440721408L, 42561);
      return;
    }
    if (lot == null) {
      lot = new HashMap();
    }
    lot.put(paramString, parama);
    GMTrace.o(5712440721408L, 42561);
  }
  
  private void vx(String paramString)
  {
    GMTrace.i(5712709156864L, 42563);
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", false);
    com.tencent.mm.bb.d.a(this.mContext, ".ui.chatting.En_5b8fbb1e", localIntent);
    GMTrace.o(5712709156864L, 42563);
  }
  
  public final void a(awm paramawm)
  {
    GMTrace.i(5712977592320L, 42565);
    if (paramawm == null)
    {
      v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
      GMTrace.o(5712977592320L, 42565);
      return;
    }
    Object localObject = com.tencent.mm.platformtools.n.a(paramawm.trH);
    if (!bf.mA((String)localObject))
    {
      a(this.lor, new a(com.tencent.mm.platformtools.n.a(paramawm.trH), null, paramawm));
      ap.yY();
      if (com.tencent.mm.u.c.wR().QX((String)localObject))
      {
        v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
        vx((String)localObject);
        GMTrace.o(5712977592320L, 42565);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.pluginsdk.ui.tools.c.a((Intent)localObject, paramawm, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.imb.d((Intent)localObject, this.mContext);
      GMTrace.o(5712977592320L, 42565);
      return;
    }
    v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    GMTrace.o(5712977592320L, 42565);
  }
  
  public final void a(awo paramawo)
  {
    GMTrace.i(5712843374592L, 42564);
    if (paramawo == null)
    {
      v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
      GMTrace.o(5712843374592L, 42564);
      return;
    }
    Object localObject = com.tencent.mm.platformtools.n.a(paramawo.trH);
    if (!bf.mA((String)localObject))
    {
      a(this.lor, new a(com.tencent.mm.platformtools.n.a(paramawo.trH), paramawo, null));
      ap.yY();
      if (com.tencent.mm.u.c.wR().QX((String)localObject))
      {
        v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
        vx((String)localObject);
        GMTrace.o(5712843374592L, 42564);
        return;
      }
      localObject = new Intent();
      com.tencent.mm.pluginsdk.ui.tools.c.a((Intent)localObject, paramawo, 15);
      ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
      com.tencent.mm.plugin.ext.a.imb.d((Intent)localObject, this.mContext);
      GMTrace.o(5712843374592L, 42564);
      return;
    }
    v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
    GMTrace.o(5712843374592L, 42564);
  }
  
  public final int aqL()
  {
    GMTrace.i(5712306503680L, 42560);
    if (this.mContext == null)
    {
      v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
      GMTrace.o(5712306503680L, 42560);
      return -1;
    }
    if (bf.mA(this.lor))
    {
      v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
      GMTrace.o(5712306503680L, 42560);
      return -1;
    }
    String str = am.PA(this.lor);
    if (bf.mA(str))
    {
      v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
      GMTrace.o(5712306503680L, 42560);
      return -1;
    }
    Object localObject = this.lor;
    if (bf.mA((String)localObject)) {
      v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
    }
    int i;
    for (localObject = null; localObject != null; localObject = (a)lot.get(localObject))
    {
      v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
      i = a(((a)localObject).userName, ((a)localObject).lov, ((a)localObject).low);
      GMTrace.o(5712306503680L, 42560);
      return i;
      if (lot == null) {
        lot = new HashMap();
      }
    }
    localObject = new gw();
    ((gw)localObject).fLY.fMa = str;
    com.tencent.mm.sdk.b.a.uql.m((b)localObject);
    localObject = ((gw)localObject).fLZ.userName;
    if (!bf.mA((String)localObject))
    {
      v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[] { localObject });
      i = a((String)localObject, null, null);
      GMTrace.o(5712306503680L, 42560);
      return i;
    }
    v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
    ap.vd().a(106, this.gUt);
    localObject = new aa(com.tencent.mm.plugin.fts.a.d.wU(str), 3);
    ap.vd().a((k)localObject, 0);
    localObject = new Intent();
    ((Intent)localObject).setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
    ((Intent)localObject).setFlags(268435456);
    this.mContext.startActivity((Intent)localObject);
    GMTrace.o(5712306503680L, 42560);
    return 2;
  }
  
  public final void b(awo paramawo)
  {
    GMTrace.i(16027744206848L, 119416);
    Intent localIntent = new Intent();
    localIntent.putExtra("add_more_friend_search_scene", 3);
    if (paramawo != null) {}
    try
    {
      localIntent.putExtra("result", paramawo.toByteArray());
      v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
      com.tencent.mm.plugin.ext.a.imb.x(localIntent, this.mContext);
      GMTrace.o(16027744206848L, 119416);
      return;
    }
    catch (IOException paramawo)
    {
      for (;;)
      {
        v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: IOException: %s", new Object[] { paramawo.toString() });
      }
    }
  }
  
  final class a
  {
    awo lov;
    awm low;
    String userName;
    
    public a(String paramString, awo paramawo, awm paramawm)
    {
      GMTrace.i(5713782898688L, 42571);
      this.userName = "";
      this.lov = null;
      this.low = null;
      this.userName = paramString;
      this.lov = paramawo;
      this.low = paramawm;
      GMTrace.o(5713782898688L, 42571);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ext/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */