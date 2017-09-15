package com.tencent.mm.ui.d;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.ri;
import com.tencent.mm.e.a.ri.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.LinkedList;

public final class b
{
  public static String SR(String paramString)
  {
    GMTrace.i(17883572731904L, 133243);
    if (TextUtils.isEmpty(paramString))
    {
      GMTrace.o(17883572731904L, 133243);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.i.b)h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(paramString);
    if ((paramString != null) && (paramString.RE() != null))
    {
      paramString = paramString.RE().iFp;
      GMTrace.o(17883572731904L, 133243);
      return paramString;
    }
    v.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    GMTrace.o(17883572731904L, 133243);
    return null;
  }
  
  public static String SS(String paramString)
  {
    GMTrace.i(17883706949632L, 133244);
    if (TextUtils.isEmpty(paramString))
    {
      GMTrace.o(17883706949632L, 133244);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.i.b)h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_nickname;
      GMTrace.o(17883706949632L, 133244);
      return paramString;
    }
    v.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    GMTrace.o(17883706949632L, 133244);
    return null;
  }
  
  public static void j(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    int j = 1;
    GMTrace.i(17883438514176L, 133242);
    Object localObject1 = new ri();
    ((ri)localObject1).fYg.fCA = paramString;
    Object localObject2 = ((ri)localObject1).fYg;
    if (paramBoolean)
    {
      i = 2;
      ((ri.a)localObject2).action = i;
      ((ri)localObject1).fYg.fYi = 2;
      a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new LinkedList();
      localObject2 = new beg();
      ((beg)localObject2).udz = paramString;
      if (!paramBoolean) {
        break label169;
      }
    }
    label169:
    for (int i = j;; i = 0)
    {
      ((beg)localObject2).udy = i;
      ((beg)localObject2).jMq = 3;
      ((LinkedList)localObject1).add(localObject2);
      ap.vd().a(1176, new e()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
        {
          int i = 1;
          GMTrace.i(17883304296448L, 133241);
          ap.vd().b(1176, this);
          v.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(true) });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            s.makeText(this.val$context, R.l.eEO, 0).show();
            paramAnonymousString = new ri();
            paramAnonymousString.fYg.fCA = paramString;
            paramAnonymousk = paramAnonymousString.fYg;
            paramAnonymousInt1 = i;
            if (!paramBoolean) {
              paramAnonymousInt1 = 2;
            }
            paramAnonymousk.action = paramAnonymousInt1;
            paramAnonymousString.fYg.fYi = 2;
            a.uql.m(paramAnonymousString);
            GMTrace.o(17883304296448L, 133241);
            return;
          }
          GMTrace.o(17883304296448L, 133241);
        }
      });
      paramContext = new j((LinkedList)localObject1);
      ap.vd().a(paramContext, 0);
      GMTrace.o(17883438514176L, 133242);
      return;
      i = 1;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */