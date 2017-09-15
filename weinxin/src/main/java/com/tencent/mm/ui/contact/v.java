package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.snackbar.a;
import com.tencent.mm.x.h;
import com.tencent.mm.x.i;
import java.util.Iterator;
import java.util.List;

public final class v
{
  public static String TR(String paramString)
  {
    GMTrace.i(1708457459712L, 12729);
    Object localObject = com.tencent.mm.x.n.Bm().hs(paramString);
    ap.yY();
    x localx = c.wR().Rb(paramString);
    int i = localx.gkg;
    if (localObject != null) {
      i = ((h)localObject).gkg;
    }
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    int j;
    int k;
    int m;
    String str8;
    if (localx.bKU())
    {
      paramString = e.hW(localx.field_username);
      localObject = bf.PV(localx.field_username);
      str1 = bf.PV(localx.tK());
      str2 = bf.PV(localx.pA());
      str3 = bf.PV(localx.tK());
      str4 = bf.PV(localx.pB());
      str5 = bf.PV(localx.getProvince());
      str6 = bf.PV(localx.getCity());
      str7 = bf.PV(localx.signature);
      j = localx.gkq;
      k = localx.gkh;
      m = localx.field_verifyFlag;
      str8 = bf.PV(localx.gkw);
      if (paramString != null) {
        break label308;
      }
    }
    label308:
    for (paramString = "";; paramString = bf.PV(paramString.field_brandIconURL))
    {
      paramString = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", new Object[] { localObject, str1, str2, str3, str4, Integer.valueOf(i), str5, str6, str7, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str8, paramString, bf.PV(localx.gkx) });
      GMTrace.o(1708457459712L, 12729);
      return paramString;
      paramString = null;
      break;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, List<String> paramList)
  {
    GMTrace.i(1708591677440L, 12730);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      j localj = new j(paramString, TR((String)localIterator.next()), 42);
      ap.vd().a(localj, 0);
    }
    a.e(paramActivity, paramActivity.getString(R.l.esd));
    g.oSF.i(11003, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramList.size()) });
    paramActivity.setResult(-1);
    ae.f(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1812341981184L, 13503);
        this.vXO.finish();
        GMTrace.o(1812341981184L, 13503);
      }
    }, 1800L);
    GMTrace.o(1708591677440L, 12730);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */