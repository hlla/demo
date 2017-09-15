package com.tencent.mm.u;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.x;

public final class v
{
  private c hlx;
  
  public v(c paramc)
  {
    GMTrace.i(687194767360L, 5120);
    this.hlx = paramc;
    GMTrace.o(687194767360L, 5120);
  }
  
  static int a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 3;
    GMTrace.i(687328985088L, 5121);
    x localx2 = c.wR().Rb(paramString);
    x localx1 = localx2;
    if (localx2 == null) {
      localx1 = new x();
    }
    if ((int)localx1.gTG == 0)
    {
      localx1.setUsername(paramString);
      localx1.tc();
      x(localx1);
      if (paramBoolean2) {
        i = 4;
      }
      localx1.dh(i);
      localx1.tl();
      c.wR().R(localx1);
      GMTrace.o(687328985088L, 5121);
      return 1;
    }
    if (paramBoolean1)
    {
      localx1.tl();
      c.wR().a(paramString, localx1);
      GMTrace.o(687328985088L, 5121);
      return 2;
    }
    GMTrace.o(687328985088L, 5121);
    return 3;
  }
  
  public static void w(x paramx)
  {
    GMTrace.i(687463202816L, 5122);
    x localx = paramx;
    if (paramx == null) {
      localx = new x();
    }
    if ((int)localx.gTG == 0)
    {
      localx.setUsername("filehelper");
      ap.yY();
      if (c.wW().Rl(localx.field_username) != null) {
        break label89;
      }
      localx.td();
    }
    for (;;)
    {
      localx.dh(3);
      ap.yY();
      c.wR().Q(localx);
      GMTrace.o(687463202816L, 5122);
      return;
      label89:
      localx.tc();
    }
  }
  
  static void x(x paramx)
  {
    GMTrace.i(687597420544L, 5123);
    String str = paramx.field_username;
    Context localContext = aa.getContext();
    if (str.equals("qqsync"))
    {
      paramx.bR(localContext.getString(R.l.erI));
      paramx.bS(localContext.getString(R.l.erJ));
      paramx.bT(localContext.getString(R.l.erK));
    }
    if (str.equals("floatbottle"))
    {
      paramx.bR(localContext.getString(R.l.eqR));
      paramx.bS(localContext.getString(R.l.eqS));
      paramx.bT(localContext.getString(R.l.eqT));
    }
    if (str.equals("shakeapp"))
    {
      paramx.bR(localContext.getString(R.l.erP));
      paramx.bS(localContext.getString(R.l.erQ));
      paramx.bT(localContext.getString(R.l.erR));
    }
    if (str.equals("lbsapp"))
    {
      paramx.bR(localContext.getString(R.l.erj));
      paramx.bS(localContext.getString(R.l.erk));
      paramx.bT(localContext.getString(R.l.erl));
    }
    if (str.equals("medianote"))
    {
      paramx.bR(localContext.getString(R.l.ers));
      paramx.bS(localContext.getString(R.l.ert));
      paramx.bT(localContext.getString(R.l.eru));
    }
    if (str.equals("newsapp"))
    {
      paramx.bR(localContext.getString(R.l.erL));
      paramx.bS(localContext.getString(R.l.erM));
      paramx.bT(localContext.getString(R.l.erN));
    }
    if (str.equals("facebookapp"))
    {
      paramx.bR(localContext.getString(R.l.eqX));
      paramx.bS(localContext.getString(R.l.eqY));
      paramx.bT(localContext.getString(R.l.eqZ));
    }
    if (str.equals("qqfriend"))
    {
      paramx.bR(localContext.getString(R.l.erC));
      paramx.bS(localContext.getString(R.l.erD));
      paramx.bT(localContext.getString(R.l.erE));
    }
    if (str.equals("masssendapp"))
    {
      paramx.bR(localContext.getString(R.l.erp));
      paramx.bS(localContext.getString(R.l.erq));
      paramx.bT(localContext.getString(R.l.err));
    }
    if (str.equals("feedsapp"))
    {
      paramx.bR(localContext.getString(R.l.era));
      paramx.bS(localContext.getString(R.l.erb));
      paramx.bT(localContext.getString(R.l.erc));
    }
    if (str.equals("fmessage"))
    {
      paramx.bR(localContext.getString(R.l.erd));
      paramx.bS(localContext.getString(R.l.ere));
      paramx.bT(localContext.getString(R.l.erf));
    }
    if (str.equals("voipapp"))
    {
      paramx.bR(localContext.getString(R.l.erW));
      paramx.bS(localContext.getString(R.l.erX));
      paramx.bT(localContext.getString(R.l.erY));
    }
    if (str.equals("officialaccounts"))
    {
      paramx.bR(localContext.getString(R.l.erz));
      paramx.bS(localContext.getString(R.l.erA));
      paramx.bT(localContext.getString(R.l.erB));
    }
    if (str.equals("helper_entry"))
    {
      paramx.bR(localContext.getString(R.l.erg));
      paramx.bS(localContext.getString(R.l.erh));
      paramx.bT(localContext.getString(R.l.eri));
    }
    if (str.equals("cardpackage"))
    {
      paramx.bR(localContext.getString(R.l.eqU));
      paramx.bS(localContext.getString(R.l.eqV));
      paramx.bT(localContext.getString(R.l.eqW));
    }
    if (str.equals("voicevoipapp"))
    {
      paramx.bR(localContext.getString(R.l.erZ));
      paramx.bS(localContext.getString(R.l.esa));
      paramx.bT(localContext.getString(R.l.esb));
    }
    if (str.equals("voiceinputapp"))
    {
      paramx.bR(localContext.getString(R.l.erT));
      paramx.bS(localContext.getString(R.l.erU));
      paramx.bT(localContext.getString(R.l.erV));
    }
    if (str.equals("qqmail"))
    {
      paramx.bR(localContext.getString(R.l.erF));
      paramx.bS(localContext.getString(R.l.erG));
      paramx.bT(localContext.getString(R.l.erH));
    }
    if (str.equals("linkedinplugin"))
    {
      paramx.bR(localContext.getString(R.l.erm));
      paramx.bS(localContext.getString(R.l.ern));
      paramx.bT(localContext.getString(R.l.ero));
    }
    if (str.equals("notifymessage"))
    {
      paramx.bR(localContext.getString(R.l.erw));
      paramx.bS(localContext.getString(R.l.erx));
      paramx.bT(localContext.getString(R.l.ery));
    }
    if (str.equals("appbrandcustomerservicemsg"))
    {
      paramx.bR(localContext.getString(R.l.eqO));
      paramx.bS(localContext.getString(R.l.eqP));
      paramx.bT(localContext.getString(R.l.eqQ));
    }
    GMTrace.o(687597420544L, 5123);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */