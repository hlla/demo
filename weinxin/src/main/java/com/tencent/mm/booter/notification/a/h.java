package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.bi.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.p;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.c;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import junit.framework.Assert;

public final class h
{
  private static WeakReference<TextPaint> gMn;
  private static int gMo;
  private static int gMp;
  public String gMl;
  public String gMm;
  public String mTitle;
  
  static
  {
    GMTrace.i(527744106496L, 3932);
    gMo = 0;
    gMp = 0;
    GMTrace.o(527744106496L, 3932);
  }
  
  public h()
  {
    GMTrace.i(525193969664L, 3913);
    this.gMl = "";
    this.mTitle = "";
    this.gMm = "";
    GMTrace.o(525193969664L, 3913);
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext)
  {
    GMTrace.i(525865058304L, 3918);
    paramString1 = bf.mz(a(null, paramInt1, paramString1, paramString2, paramInt2, paramContext, new PString(), new PString(), new PInt(), false, false));
    GMTrace.o(525865058304L, 3918);
    return paramString1;
  }
  
  private static String a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, PString paramPString1, PString paramPString2)
  {
    GMTrace.i(526133493760L, 3920);
    String str3 = "";
    String str2;
    String str1;
    int i;
    if ((o.fa(paramString1)) || (o.fc(paramString1)))
    {
      str2 = str3;
      str1 = paramString2;
      if (paramString2 != null)
      {
        i = paramString2.indexOf(":");
        str2 = str3;
        str1 = paramString2;
        if (i >= 0)
        {
          str2 = str3;
          str1 = paramString2;
          if (i < paramString2.length())
          {
            paramString1 = paramString2.substring(0, i);
            if (!x.QL(paramString1))
            {
              str2 = str3;
              str1 = paramString2;
              if (!x.QN(paramString1)) {}
            }
            else
            {
              str2 = com.tencent.mm.u.n.eK(paramString1);
              paramPString2.value = paramString1;
              str1 = paramString2.substring(i + 1);
            }
          }
        }
      }
      if (bf.mz(str2).length() > 0) {
        break label325;
      }
      if (paramString3 != null) {
        break label318;
      }
    }
    for (;;)
    {
      paramPString1.value = str1;
      paramContext = paramPString1.value;
      GMTrace.o(526133493760L, 3920);
      return paramContext;
      if (!x.QL(paramString1))
      {
        str2 = str3;
        str1 = paramString2;
        if (!x.QN(paramString1)) {
          break;
        }
      }
      com.tencent.mm.u.n.eK(paramString1);
      paramPString2.value = paramString1;
      if (paramInt == 1)
      {
        paramContext = new StringBuilder().append(paramContext.getString(R.l.elE, new Object[] { "" }));
        if (paramString3 == null) {}
        for (;;)
        {
          paramPString1.value = paramString2;
          paramPString2.value = "";
          paramContext = paramPString1.value;
          GMTrace.o(526133493760L, 3920);
          return paramContext;
          paramString2 = paramString3;
        }
      }
      if (paramString3 == null) {}
      for (;;)
      {
        paramPString1.value = paramString2;
        paramPString2.value = "";
        paramContext = paramPString1.value;
        GMTrace.o(526133493760L, 3920);
        return paramContext;
        paramString2 = paramString3;
      }
      label318:
      str1 = paramString3;
    }
    label325:
    paramString1 = new StringBuilder();
    if (paramInt == 1)
    {
      i = R.l.elE;
      paramString2 = paramString1.append(paramContext.getString(i));
      if (paramString3 != null) {
        break label445;
      }
      paramString1 = str1;
      label362:
      paramPString1.value = paramString1;
      paramString1 = new StringBuilder();
      if (paramInt != 1) {
        break label451;
      }
      paramInt = R.l.elE;
      label392:
      paramContext = paramString1.append(paramContext.getString(paramInt, new Object[] { str2 }));
      if (paramString3 != null) {
        break label458;
      }
    }
    for (;;)
    {
      paramContext = str1;
      GMTrace.o(526133493760L, 3920);
      return paramContext;
      i = R.l.elO;
      break;
      label445:
      paramString1 = paramString3;
      break label362;
      label451:
      paramInt = R.l.elO;
      break label392;
      label458:
      str1 = paramString3;
    }
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    GMTrace.i(527475671040L, 3930);
    if (paramBoolean)
    {
      String str = b.bKo().Qx(paramString);
      paramString = str;
      if (paramInt3 > 1) {
        paramString = paramContext.getResources().getQuantityString(R.j.dso, paramInt3, new Object[] { Integer.valueOf(paramInt3) }) + str;
      }
      GMTrace.o(527475671040L, 3930);
      return paramString;
    }
    paramContext = paramContext.getResources().getQuantityString(R.j.dsp, paramInt1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    GMTrace.o(527475671040L, 3930);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(16432410656768L, 122431);
    paramContext = a(0, paramString2, paramString1, paramInt, paramContext);
    paramContext = com.tencent.mm.pluginsdk.ui.d.h.Ne(b.bKo().Qx(paramContext));
    GMTrace.o(16432410656768L, 122431);
    return paramContext;
  }
  
  private static String a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, Context paramContext, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(525999276032L, 3919);
    boolean bool;
    label38:
    int i;
    if (paramContext != null)
    {
      bool = true;
      Assert.assertTrue("context is null", bool);
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label97;
      }
      bool = true;
      Assert.assertTrue("username is null", bool);
      if (paramBoolean1) {
        break label164;
      }
      if ((!o.fa(paramString2)) || (m.yd())) {
        break label103;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label164;
      }
      paramString1 = paramContext.getString(R.l.eTq);
      GMTrace.o(525999276032L, 3919);
      return paramString1;
      bool = false;
      break;
      label97:
      bool = false;
      break label38;
      label103:
      if (o.fc(paramString2))
      {
        if ((m.xP() & 0x40) != 0) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label139;
          }
          i = 1;
          break;
        }
      }
      label139:
      if ((o.fg(paramString2)) && (!m.yg())) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label164:
    if (o.fg(paramString2))
    {
      if (paramBoolean1)
      {
        GMTrace.o(525999276032L, 3919);
        return "";
      }
      paramBoolean1 = m.yg();
      ap.yY();
      long l = bf.a((Long)com.tencent.mm.u.c.vr().get(65793, null), 0L);
      if (!paramBoolean1)
      {
        paramString1 = paramContext.getString(R.l.eTq);
        GMTrace.o(525999276032L, 3919);
        return paramString1;
      }
      if (l == 0L)
      {
        paramString1 = paramContext.getString(R.l.elC);
        GMTrace.o(525999276032L, 3919);
        return paramString1;
      }
      if (bf.az(l) * 1000L > 1209600000L)
      {
        paramString1 = paramContext.getString(R.l.elB, new Object[] { Long.valueOf(bf.az(l) * 1000L / 86400000L) });
        GMTrace.o(525999276032L, 3919);
        return paramString1;
      }
      GMTrace.o(525999276032L, 3919);
      return "";
    }
    if ((paramString3 != null) && (paramBoolean1)) {
      paramString3 = dk(paramString3);
    }
    for (int k = 1;; k = 0)
    {
      paramPString1.value = paramString3;
      String str1;
      String str2;
      Object localObject2;
      if ((paramInt1 == 0) && (o.dH(paramString2)))
      {
        i = ay.gh(paramString3);
        if (i > 0)
        {
          str1 = paramString3.substring(0, i).trim();
          str2 = com.tencent.mm.u.n.E(str1, paramString2);
          localObject2 = (paramString3 + " ").substring(i + 1);
        }
      }
      for (;;)
      {
        i = 0;
        Object localObject1;
        int j;
        if ((o.fu(paramString2)) || (o.fD(paramString2)))
        {
          i = paramString3.indexOf(":");
          localObject1 = paramString3;
          if (i != -1)
          {
            paramPString2.value = paramString3.substring(0, i);
            localObject1 = paramString3.substring(i + 1);
          }
          j = 0;
          paramString3 = (String)localObject1;
        }
        for (;;)
        {
          switch (paramInt2)
          {
          default: 
            paramString1 = paramString3;
          case 3: 
          case 23: 
          case 33: 
          case 47: 
          case 1048625: 
          case 13: 
          case 39: 
          case 11: 
          case 36: 
          case 34: 
          case 43: 
          case 62: 
          case 12299999: 
          case -1879048191: 
          case -1879048190: 
          case -1879048189: 
          case 50: 
          case 53: 
          case 52: 
          case -1879048188: 
          case 37: 
          case 40: 
          case 35: 
          case 42: 
          case 48: 
            label886:
            label895:
            label1051:
            label1087:
            label1400:
            label1566:
            do
            {
              localObject1 = null;
              i = 0;
              paramString3 = "";
              for (;;)
              {
                if (!o.fb(paramString2)) {
                  break label6667;
                }
                if (1 != paramInt1) {
                  break label6373;
                }
                if (bf.mA(paramString3)) {
                  break label6318;
                }
                paramPString1.value = paramString3;
                GMTrace.o(525999276032L, 3919);
                return paramString3;
                ap.yY();
                localObject1 = com.tencent.mm.u.c.wW().Rl(paramString2);
                if (((localObject1 == null) || (!((ae)localObject1).eC(2097152))) && (!paramBoolean2)) {
                  break label7271;
                }
                i = 1;
                j = paramString3.indexOf(":");
                if (j == -1) {
                  break label7271;
                }
                paramPString2.value = paramString3.substring(0, j);
                paramString3 = paramString3.substring(j + 1);
                j = 1;
                break;
                localObject2 = paramContext.getString(R.l.dIa);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if (str1.length() <= 0) {
                    break label1087;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  i = 0;
                  localObject1 = null;
                  paramString3 = (String)localObject2;
                  break;
                  paramString1 = "";
                  break label1051;
                }
                localObject2 = aj.RC(paramString3);
                localObject1 = ((aj)localObject2).hZN + ": ";
                if ((paramString1 != null) && (paramString1.length() == 32)) {}
                for (paramString3 = paramString1;; paramString3 = paramContext.getString(R.l.dGD))
                {
                  paramPString1.value = "";
                  paramPString2.value = ((aj)localObject2).hZN;
                  i = 0;
                  paramString1 = (String)localObject1;
                  localObject1 = null;
                  break;
                }
                paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(R.l.dIa), paramPString1, paramPString2);
                i = 0;
                paramString3 = "";
                localObject1 = null;
                continue;
                paramString1 = a(paramContext, paramInt1, paramString2, paramString3, null, paramPString1, paramPString2);
                i = 0;
                paramString3 = "";
                localObject1 = null;
                continue;
                if ((x.QL(paramString2)) || (x.QN(paramString2)) || (o.fa(paramString2)) || (o.fc(paramString2)))
                {
                  paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(R.l.dIQ), paramPString1, paramPString2);
                  i = 0;
                  paramString3 = "";
                  localObject1 = null;
                }
                else
                {
                  paramString1 = paramString3;
                  if (paramString3 != null)
                  {
                    paramString1 = paramString3;
                    if (paramString3.length() > 0)
                    {
                      paramString1 = paramString3;
                      if (!o.fb(paramString2))
                      {
                        if (!o.dH(paramString2)) {
                          break label1400;
                        }
                        paramString3 = new com.tencent.mm.modelvoice.n(paramString3);
                        paramString1 = paramString3.hZN + ": ";
                        paramPString1.value = "%s:";
                        paramPString2.value = paramString3.hZN;
                      }
                    }
                  }
                  for (;;)
                  {
                    paramString3 = paramContext.getString(R.l.dIQ);
                    i = 0;
                    localObject1 = null;
                    break;
                    paramString1 = "";
                  }
                  if ((x.QL(paramString2)) || (x.QN(paramString2)) || (o.fa(paramString2)) || (o.fc(paramString2)))
                  {
                    paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(R.l.dIP), paramPString1, paramPString2);
                    i = 0;
                    paramString3 = "";
                    localObject1 = null;
                  }
                  else
                  {
                    paramString1 = paramString3;
                    if (paramString3 != null)
                    {
                      paramString1 = paramString3;
                      if (paramString3.length() > 0)
                      {
                        paramString1 = paramString3;
                        if (!o.fb(paramString2))
                        {
                          if (!o.dH(paramString2)) {
                            break label1566;
                          }
                          paramString3 = new p(paramString3);
                          paramString1 = paramString3.hZN + ": ";
                          paramPString1.value = "%s:";
                          paramPString2.value = paramString3.hZN;
                        }
                      }
                    }
                    for (;;)
                    {
                      paramString3 = paramContext.getString(R.l.dIP);
                      i = 0;
                      localObject1 = null;
                      break;
                      paramString1 = "";
                    }
                    paramString1 = "";
                    paramString3 = paramContext.getString(R.l.dIT);
                    i = 0;
                    localObject1 = null;
                    continue;
                    paramString1 = "";
                    paramString3 = paramContext.getString(R.l.dIS);
                    i = 0;
                    localObject1 = null;
                    continue;
                    if (paramString3.equals(au.uIc))
                    {
                      paramString1 = "";
                      paramString3 = paramContext.getString(R.l.dIT);
                      i = 0;
                      localObject1 = null;
                    }
                    else
                    {
                      paramString1 = paramString3;
                      if (!paramString3.equals(au.uIb)) {
                        break label886;
                      }
                      paramString1 = "";
                      paramString3 = paramContext.getString(R.l.dIU);
                      i = 0;
                      localObject1 = null;
                      continue;
                      paramString1 = "";
                      paramString3 = paramContext.getString(R.l.dIT);
                      i = 0;
                      localObject1 = null;
                      continue;
                      paramString1 = "";
                      paramString3 = paramContext.getString(R.l.dIU);
                      i = 0;
                      localObject1 = null;
                      continue;
                      paramString1 = paramString3;
                      if (paramString3 == null) {
                        break label886;
                      }
                      paramString1 = paramString3;
                      if (paramString3.length() <= 0) {
                        break label886;
                      }
                      localObject1 = au.d.RH(paramString3);
                      paramString1 = paramString3;
                      if (((au.d)localObject1).rTh != null)
                      {
                        paramString1 = paramString3;
                        if (((au.d)localObject1).rTh.length() <= 0) {}
                      }
                      switch (((au.d)localObject1).scene)
                      {
                      case 19: 
                      case 20: 
                      case 21: 
                      default: 
                        paramString1 = paramContext.getString(R.l.elX, new Object[] { ((au.d)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        localObject1 = null;
                        i = 0;
                        paramString3 = "";
                        break;
                      case 18: 
                        paramString1 = paramContext.getString(R.l.elH, new Object[] { ((au.d)localObject1).getDisplayName() });
                        i = 0;
                        paramString3 = "";
                        localObject1 = null;
                        break;
                      case 22: 
                      case 23: 
                      case 24: 
                      case 26: 
                      case 27: 
                      case 28: 
                      case 29: 
                        paramString1 = paramContext.getString(R.l.elR, new Object[] { ((au.d)localObject1).getDisplayName() });
                        i = 0;
                        paramString3 = "";
                        localObject1 = null;
                        break;
                      case 25: 
                        paramString1 = paramContext.getString(R.l.ela, new Object[] { ((au.d)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        i = 0;
                        paramString3 = "";
                        localObject1 = null;
                        continue;
                        paramString1 = paramString3;
                        if (paramString3 == null) {
                          break label886;
                        }
                        paramString1 = paramString3;
                        if (paramString3.length() <= 0) {
                          break label886;
                        }
                        localObject1 = au.a.RE(paramString3);
                        paramString1 = paramString3;
                        if (((au.a)localObject1).rTh != null)
                        {
                          paramString1 = paramString3;
                          if (((au.a)localObject1).rTh.length() > 0)
                          {
                            paramString1 = paramContext.getString(R.l.elq, new Object[] { ((au.a)localObject1).getDisplayName() });
                            paramPString1.value = paramString1;
                          }
                        }
                        localObject1 = null;
                        i = 0;
                        paramString3 = "";
                        continue;
                        paramString1 = paramString3;
                        if (bf.mz(paramString3).length() <= 0) {
                          break label886;
                        }
                        ap.yY();
                        paramString1 = com.tencent.mm.u.c.wT().Ar(paramString3);
                        paramString1 = paramContext.getString(R.l.elA, new Object[] { paramString1.hRv, paramString1.title });
                        paramPString1.value = paramString1;
                        i = 0;
                        paramString3 = "";
                        localObject1 = null;
                        continue;
                        paramString1 = paramString3;
                        if (bf.mz(paramString3).length() <= 0) {
                          break label886;
                        }
                        if (o.dH(paramString2))
                        {
                          localObject1 = ay.gi(paramString3);
                          paramString1 = (String)localObject1;
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
                        }
                        else
                        {
                          paramString1 = paramString2;
                        }
                        ap.yY();
                        localObject2 = com.tencent.mm.u.c.wT().At(paramString3);
                        ap.yY();
                        localObject1 = com.tencent.mm.u.c.wR().Rb(paramString1).tL();
                        paramString3 = (String)localObject1;
                        if (o.dH((String)localObject1)) {
                          paramString3 = com.tencent.mm.u.j.s(com.tencent.mm.u.j.eD((String)localObject1));
                        }
                        if (paramInt1 == 1)
                        {
                          paramString3 = paramContext.getString(R.l.elb, new Object[] { paramString3, ((au.a)localObject2).getDisplayName() });
                          paramPString1.value = paramContext.getString(R.l.elb, new Object[] { "%s", ((au.a)localObject2).getDisplayName() });
                          paramPString2.value = paramString1;
                          localObject1 = null;
                          i = 0;
                          localObject2 = "";
                          paramString1 = paramString3;
                          paramString3 = (String)localObject2;
                        }
                        else
                        {
                          paramString3 = paramContext.getString(R.l.elc, new Object[] { paramString3, ((au.a)localObject2).getDisplayName() });
                          paramPString1.value = paramContext.getString(R.l.elc, new Object[] { "%s", ((au.a)localObject2).getDisplayName() });
                          paramPString2.value = paramString1;
                          localObject1 = null;
                          i = 0;
                          localObject2 = "";
                          paramString1 = paramString3;
                          paramString3 = (String)localObject2;
                        }
                        break;
                      }
                    }
                  }
                }
              }
              paramString1 = paramString3;
            } while (bf.mz(paramString3).length() <= 0);
            if (o.dH(paramString2))
            {
              i = ay.gh(paramString3);
              if (i != -1)
              {
                paramString1 = paramString3.substring(0, i).trim();
                label2428:
                ay.gj(paramString3);
              }
            }
            break;
          }
          for (;;)
          {
            if (paramInt1 == 1)
            {
              paramString1 = paramContext.getString(R.l.ewh);
              paramPString1.value = paramString1;
              i = 0;
              paramString3 = "";
              localObject1 = null;
              break label895;
            }
            localObject1 = paramContext.getString(R.l.ewh);
            paramPString1.value = paramContext.getString(R.l.ewh);
            paramPString2.value = paramString1;
            i = 0;
            paramString3 = "";
            paramString1 = (String)localObject1;
            localObject1 = null;
            break label895;
            paramString1 = f.a.ek(bf.PW((String)localObject2));
            if (paramString1.hhB != 0) {
              if (paramString1.hhB == 1) {
                paramString1 = paramContext.getString(R.l.ePa);
              }
            }
            for (;;)
            {
              localObject2 = "";
              paramPString2.value = str1;
              paramPString1.value = "";
              i = 0;
              paramString3 = paramString1;
              localObject1 = null;
              paramString1 = (String)localObject2;
              break;
              if (paramString1.hhB == 2) {
                paramString1 = paramContext.getString(R.l.ePc);
              } else if (paramString1.hhB == 3) {
                paramString1 = paramContext.getString(R.l.ePb);
              } else {
                paramString1 = paramContext.getString(R.l.ePd);
              }
            }
            localObject1 = bf.PW((String)localObject2);
            paramString3 = "";
            paramString1 = "";
            localObject1 = f.a.ek((String)localObject1);
            if (localObject1 != null)
            {
              paramPString1.value = (paramContext.getString(R.l.ePl) + bf.mz(((f.a)localObject1).title));
              paramString1 = paramPString1.value;
            }
            paramPString2.value = str1;
            i = 0;
            localObject1 = null;
            break label895;
            localObject1 = bf.PW((String)localObject2);
            paramString3 = "";
            paramString1 = "";
            localObject1 = f.a.ek((String)localObject1);
            if (localObject1 != null)
            {
              if (paramInt1 != 1) {
                break label2815;
              }
              i = 1;
              label2743:
              switch (((f.a)localObject1).hii)
              {
              case 2: 
              default: 
                paramPString1.value = bf.mz(((f.a)localObject1).title);
              }
            }
            for (;;)
            {
              paramString1 = paramPString1.value;
              paramPString2.value = str1;
              i = 0;
              localObject1 = null;
              break;
              label2815:
              i = 0;
              break label2743;
              if (i != 0)
              {
                paramPString1.value = paramContext.getString(R.l.dIZ);
              }
              else
              {
                paramPString1.value = paramContext.getString(R.l.dJc);
                continue;
                if (i != 0)
                {
                  paramPString1.value = paramContext.getString(R.l.dJa);
                }
                else
                {
                  paramPString1.value = paramContext.getString(R.l.dIX);
                  continue;
                  if (i != 0) {
                    paramPString1.value = paramContext.getString(R.l.dJb);
                  } else {
                    paramPString1.value = paramContext.getString(R.l.dIY);
                  }
                }
              }
            }
            localObject1 = bf.PW((String)localObject2);
            paramString3 = "";
            paramString1 = "";
            localObject1 = f.a.ek((String)localObject1);
            if (localObject1 != null)
            {
              if (paramInt1 != 1) {
                break label3044;
              }
              i = 1;
              label2965:
              if (i == 0) {
                break label3050;
              }
              paramPString1.value = ("[" + ((f.a)localObject1).hiJ + "]" + ((f.a)localObject1).hiG);
            }
            for (;;)
            {
              paramString1 = paramPString1.value;
              if ((o.fu(paramString2)) || (j != 0)) {
                break label7252;
              }
              paramPString2.value = str1;
              i = 0;
              localObject1 = null;
              break;
              label3044:
              i = 0;
              break label2965;
              label3050:
              if (!bf.mA(str2)) {
                paramPString1.value = (bf.mz(str2) + ": [" + ((f.a)localObject1).hiJ + "]" + ((f.a)localObject1).hiF);
              } else {
                paramPString1.value = ("[" + ((f.a)localObject1).hiJ + "]" + ((f.a)localObject1).hiF);
              }
            }
            switch (f.a.ek(bf.PW((String)localObject2)).hhB)
            {
            default: 
              paramString1 = paramContext.getString(R.l.dIc);
              label3201:
              if (str1.length() <= 0) {
                break;
              }
            }
            for (paramString3 = str1 + ": ";; paramString3 = "")
            {
              if ((!o.fu(paramString2)) && (j == 0)) {
                paramPString2.value = str1;
              }
              paramPString1.value = "";
              localObject2 = paramString1;
              paramString1 = paramString3;
              localObject1 = null;
              i = 0;
              paramString3 = (String)localObject2;
              break;
              paramString1 = paramContext.getString(R.l.dId);
              break label3201;
              paramString1 = paramContext.getString(R.l.dIf);
              break label3201;
            }
            paramString3 = f.a.ek(bf.PW((String)localObject2));
            if (paramString3 == null)
            {
              v.e("MicroMsg.Notification.Wording", "decode msg content failed");
              GMTrace.o(525999276032L, 3919);
              return "";
            }
            localObject2 = "";
            localObject1 = paramContext.getString(R.l.dRn);
            if (str1.length() > 0)
            {
              paramString1 = str1 + ": " + (String)localObject1 + paramString3.title;
              label3394:
              if ((!o.fu(paramString2)) && (j == 0)) {
                paramPString2.value = str1;
              }
              if (str1.length() <= 0) {
                break label3491;
              }
            }
            label3491:
            for (paramString3 = "%s: " + (String)localObject1 + paramString3.title;; paramString3 = (String)localObject1 + paramString3.title)
            {
              paramPString1.value = paramString3;
              i = 0;
              localObject1 = null;
              paramString3 = (String)localObject2;
              break;
              paramString1 = (String)localObject1 + paramString3.title;
              break label3394;
            }
            paramString1 = f.a.ek(bf.PW((String)localObject2));
            if (paramString1 == null)
            {
              v.e("MicroMsg.Notification.Wording", "decode msg content failed");
              GMTrace.o(525999276032L, 3919);
              return "";
            }
            localObject2 = "";
            paramString3 = paramContext.getString(R.l.dRn);
            if (paramInt1 == 1)
            {
              paramString1 = paramString3 + paramString1.hiw;
              if (str1.length() > 0) {}
              for (paramString3 = "%s: " + paramString1;; paramString3 = paramString1)
              {
                paramPString1.value = paramString3;
                paramString3 = paramString1;
                if (o.fu(paramString2)) {
                  break label7234;
                }
                paramString3 = paramString1;
                if (j != 0) {
                  break label7234;
                }
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                paramString3 = (String)localObject2;
                break;
              }
            }
            paramString1 = paramString3 + paramString1.hiv;
            if (str1.length() > 0) {}
            for (paramString3 = "%s: " + paramString1;; paramString3 = paramString1)
            {
              paramPString1.value = paramString3;
              break;
            }
            paramString3 = f.a.ek(bf.PW((String)localObject2));
            if (paramString3 == null)
            {
              v.e("MicroMsg.Notification.Wording", "decode msg content failed");
              GMTrace.o(525999276032L, 3919);
              return "";
            }
            localObject2 = "";
            if (str1.length() > 0)
            {
              paramString1 = str1 + ": " + paramString3.title;
              label3800:
              if ((!o.fu(paramString2)) && (j == 0)) {
                paramPString2.value = str1;
              }
              if (str1.length() <= 0) {
                break label3874;
              }
            }
            label3874:
            for (paramString3 = "%s: " + paramString3.title;; paramString3 = paramString3.title)
            {
              paramPString1.value = paramString3;
              i = 0;
              localObject1 = null;
              paramString3 = (String)localObject2;
              break;
              paramString1 = paramString3.title;
              break label3800;
            }
            localObject2 = paramContext.getString(R.l.dDe);
            if (str1.length() > 0)
            {
              paramString1 = str1 + ": ";
              label3922:
              if ((!o.fu(paramString2)) && (j == 0)) {
                paramPString2.value = str1;
              }
              if (str1.length() <= 0) {
                break label3977;
              }
            }
            label3977:
            for (paramString3 = "%s: ";; paramString3 = "")
            {
              paramPString1.value = paramString3;
              i = 0;
              localObject1 = null;
              paramString3 = (String)localObject2;
              break;
              paramString1 = "";
              break label3922;
            }
            paramString1 = bf.PW((String)localObject2);
            f.a locala = f.a.ek(paramString1);
            if (locala == null)
            {
              v.e("MicroMsg.Notification.Wording", "decode msg content failed");
              GMTrace.o(525999276032L, 3919);
              return "";
            }
            switch (locala.type)
            {
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 18: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 35: 
            case 37: 
            case 38: 
            case 39: 
            default: 
              paramString3 = paramContext.getString(R.l.dDe);
              paramString1 = "";
              i = 0;
              localObject1 = null;
              break;
            case 1: 
              localObject2 = "";
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": " + locala.title;
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4339;
                }
              }
              for (paramString3 = "%s: " + locala.title;; paramString3 = locala.title)
              {
                paramPString1.value = paramString3;
                i = 0;
                localObject1 = null;
                paramString3 = (String)localObject2;
                break;
                paramString1 = locala.title;
                break label4263;
              }
            case 2: 
              localObject2 = paramContext.getString(R.l.dIa);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4443;
                }
              }
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                i = 0;
                localObject1 = null;
                paramString3 = (String)localObject2;
                break;
                paramString1 = "";
                break label4388;
              }
            case 3: 
              localObject2 = paramContext.getString(R.l.dHA);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4548;
                }
              }
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                localObject1 = locala.title;
                i = 1;
                paramString3 = (String)localObject2;
                break;
                paramString1 = "";
                break label4489;
              }
            case 4: 
              localObject2 = paramContext.getString(R.l.dIP);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4653;
                }
              }
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                localObject1 = locala.title;
                i = 1;
                paramString3 = (String)localObject2;
                break;
                paramString1 = "";
                break label4594;
              }
            case 6: 
              localObject2 = paramContext.getString(R.l.dHf);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4758;
                }
              }
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                localObject1 = locala.title;
                i = 1;
                paramString3 = (String)localObject2;
                break;
                paramString1 = "";
                break label4699;
              }
            case 7: 
              localObject2 = paramContext.getString(R.l.dDe);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4859;
                }
              }
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                i = 0;
                localObject1 = null;
                paramString3 = (String)localObject2;
                break;
                paramString1 = "";
                break label4804;
              }
            case 5: 
              localObject2 = paramContext.getString(R.l.dIM);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                if ((!o.fu(paramString2)) && (j == 0) && (!o.fD(paramString2))) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label4971;
                }
              }
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                localObject1 = locala.getTitle();
                i = 1;
                paramString3 = (String)localObject2;
                break;
                paramString1 = "";
                break label4905;
              }
            case 33: 
            case 36: 
              localObject2 = "";
              paramString3 = paramContext.getString(R.l.dDH);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": " + paramString3 + locala.title;
                if ((!o.fu(paramString2)) && (j == 0) && (!o.fD(paramString2))) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label5136;
                }
              }
              for (paramString3 = "%s: " + paramString3 + locala.title;; paramString3 = paramString3 + locala.title)
              {
                paramPString1.value = paramString3;
                i = 0;
                localObject1 = null;
                paramString3 = (String)localObject2;
                break;
                paramString1 = paramString3 + locala.title;
                break label5032;
              }
            case 8: 
              paramString3 = paramContext.getString(R.l.dGE);
              if (str1.length() > 0) {}
              for (paramString1 = str1 + ": ";; paramString1 = "")
              {
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                paramPString1.value = "";
                i = 0;
                localObject1 = null;
                break;
              }
            case 15: 
            case 26: 
            case 27: 
              paramString3 = paramContext.getString(R.l.dGF);
              if (str1.length() > 0) {}
              for (paramString1 = str1 + ": ";; paramString1 = "")
              {
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                paramPString1.value = "";
                i = 0;
                localObject1 = null;
                break;
              }
            case 25: 
              paramString3 = paramContext.getString(R.l.dGv);
              if (str1.length() > 0) {}
              for (paramString1 = str1 + ": ";; paramString1 = "")
              {
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                paramPString1.value = "";
                i = 0;
                localObject1 = null;
                break;
              }
            case 17: 
              localObject2 = "";
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": " + locala.title;
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label5520;
                }
              }
              for (paramString3 = "%s: " + locala.title;; paramString3 = locala.title)
              {
                paramPString1.value = paramString3;
                i = 0;
                localObject1 = null;
                paramString3 = (String)localObject2;
                break;
                paramString1 = locala.title;
                break label5444;
              }
            case 19: 
              localObject2 = paramContext.getString(R.l.dIj);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label5624;
                }
              }
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                i = 0;
                localObject1 = null;
                paramString3 = (String)localObject2;
                break;
                paramString1 = "";
                break label5569;
              }
            case 24: 
              localObject2 = paramContext.getString(R.l.ejJ);
              if (str1.length() > 0)
              {
                paramString1 = str1 + ": ";
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                if (str1.length() <= 0) {
                  break label5725;
                }
              }
              for (paramString3 = "%s: ";; paramString3 = "")
              {
                paramPString1.value = paramString3;
                i = 0;
                localObject1 = null;
                paramString3 = (String)localObject2;
                break;
                paramString1 = "";
                break label5670;
              }
            case 16: 
              localObject2 = "";
              localObject1 = paramContext.getString(R.l.dRn);
              if (str1.length() > 0) {}
              for (paramString1 = str1 + ": " + (String)localObject1 + locala.title;; paramString1 = (String)localObject1 + locala.title)
              {
                if ((!o.fu(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                paramString3 = (String)localObject1;
                if (str1.length() > 0) {
                  paramString3 = "%s: " + (String)localObject1;
                }
                paramPString1.value = paramString3;
                i = 0;
                localObject1 = null;
                paramString3 = (String)localObject2;
                break;
              }
            case 34: 
              localObject2 = "";
              paramString1 = paramContext.getString(R.l.dRn);
              if (paramInt1 == 1)
              {
                paramString1 = paramString1 + locala.hiw;
                if (str1.length() > 0) {}
                for (paramString3 = "%s: " + paramString1;; paramString3 = paramString1)
                {
                  paramPString1.value = paramString3;
                  paramString3 = paramString1;
                  if (o.fu(paramString2)) {
                    break label7234;
                  }
                  paramString3 = paramString1;
                  if (j != 0) {
                    break label7234;
                  }
                  paramPString2.value = str1;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject2;
                  break;
                }
              }
              paramString1 = paramString1 + locala.hiv;
              if (str1.length() > 0) {}
              for (paramString3 = "%s: " + paramString1;; paramString3 = paramString1)
              {
                paramPString1.value = paramString3;
                break;
              }
            case 40: 
              label4263:
              label4339:
              label4388:
              label4443:
              label4489:
              label4548:
              label4594:
              label4653:
              label4699:
              label4758:
              label4804:
              label4859:
              label4905:
              label4971:
              label5032:
              label5136:
              label5444:
              label5520:
              label5569:
              label5624:
              label5670:
              label5725:
              if (com.tencent.mm.t.j.eo(paramString1).hkf == 19)
              {
                localObject2 = paramContext.getString(R.l.dIj);
                i = 0;
                localObject1 = null;
                paramString1 = paramString3;
                paramString3 = (String)localObject2;
                break;
              }
              localObject2 = paramContext.getString(R.l.dDe);
              i = 0;
              localObject1 = null;
              paramString1 = paramString3;
              paramString3 = (String)localObject2;
              break;
              paramString1 = paramString3;
              if (k != 0) {
                paramString1 = dl(paramString3);
              }
              paramString1 = dk(((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rQ(paramString1));
              paramPString1.value = paramString1;
              i = 0;
              paramString3 = "";
              localObject1 = null;
              break;
              paramPString1.value = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rP(paramString3);
              localObject2 = paramPString1.value;
              i = 0;
              localObject1 = null;
              paramString1 = paramString3;
              paramString3 = (String)localObject2;
              break;
              paramString1 = com.tencent.mm.aa.a.b(a.a.iH(paramString3));
              paramPString1.value = paramString1;
              i = 0;
              paramString3 = "";
              localObject1 = null;
              break;
              paramString3 = "";
              localObject1 = f.a.ek((String)localObject2);
              paramString1 = paramString3;
              if (localObject1 == null) {
                break label886;
              }
              paramString1 = paramString3;
              try
              {
                paramString3 = URLDecoder.decode(((f.a)localObject1).content, "UTF-8");
                paramString1 = paramString3;
                paramString3 = com.tencent.mm.pluginsdk.ui.d.h.Ne(paramString3);
                paramString1 = paramString3;
              }
              catch (Exception paramString3)
              {
                try
                {
                  paramPString1.value = paramString1;
                  i = 0;
                  paramString3 = "";
                  localObject1 = null;
                }
                catch (Exception paramString3)
                {
                  for (;;)
                  {
                    continue;
                    continue;
                    paramString2 = paramString1;
                  }
                }
                paramString3 = paramString3;
              }
              v.printErrStackTrace("MicroMsg.Notification.Wording", paramString3, "", new Object[0]);
              i = 0;
              paramString3 = "";
              localObject1 = null;
              break;
              label6318:
              paramString1 = paramString1.split("@bottle:");
              if (paramString1.length > 1)
              {
                paramPString1.value = paramString1[1];
                paramString1 = paramString1[1];
                GMTrace.o(525999276032L, 3919);
                return paramString1;
              }
              paramPString1.value = "";
              GMTrace.o(525999276032L, 3919);
              return null;
              label6373:
              paramString2 = null;
              paramPString2 = null;
              paramContext = paramString1.split(":");
              if ((paramContext == null) || (paramContext.length <= 0))
              {
                paramPString1.value = "";
                GMTrace.o(525999276032L, 3919);
                return null;
              }
              paramContext = paramContext[0];
              if (!bf.mA(paramContext))
              {
                ap.yY();
                paramPInt = com.tencent.mm.u.c.wR().Rb(paramContext);
                paramContext = paramPString2;
                if (paramPInt != null)
                {
                  paramContext = paramPString2;
                  if (paramPInt.getCity() != null) {
                    paramContext = paramPInt.getCity();
                  }
                }
                if (paramContext != null)
                {
                  paramString2 = paramContext;
                  if (paramContext.length() > 0) {}
                }
                else
                {
                  paramString2 = paramPInt.getProvince();
                }
              }
              if (!bf.mA(paramString3))
              {
                paramPString1.value = (paramString2 + ": " + paramString3);
                paramString1 = paramString2 + ": " + paramString3;
                GMTrace.o(525999276032L, 3919);
                return paramString1;
              }
              paramString1 = paramString1.split("@bottle:");
              if (paramString1.length > 1)
              {
                paramPString1.value = (paramString2 + ": " + paramString1[1]);
                paramString1 = paramString2 + ": " + paramString1[1];
                GMTrace.o(525999276032L, 3919);
                return paramString1;
              }
              paramPString1.value = paramString2;
              GMTrace.o(525999276032L, 3919);
              return paramString2;
              label6667:
              if (bf.mA(paramString1)) {
                paramPString1.value = "";
              }
              if (!bf.mA(str1))
              {
                paramString2 = paramString1;
                if (str2 != null)
                {
                  paramString2 = paramString1;
                  if (str2.length() > 0) {
                    paramString2 = i(paramString1, str1, str2);
                  }
                }
                if (bf.mA(paramPString2.value))
                {
                  paramPString1.value = i(paramPString1.value, str1, "%s");
                  paramPString2.value = str1;
                }
                paramString1 = com.tencent.mm.compatible.util.n.dz(paramString2);
                paramPString1.value = com.tencent.mm.compatible.util.n.dz(paramPString1.value);
                paramString1 = paramString1 + paramString3;
                paramPString1.value += paramString3;
                if (paramBoolean1)
                {
                  if ((paramPString1.value.length() != 32) || ((paramInt2 != 47) && (paramInt2 != 1048625))) {
                    break label6918;
                  }
                  paramPString1.value = paramString1;
                }
                label6918:
                for (paramInt1 = 1;; paramInt1 = 0)
                {
                  if (paramInt1 == 0) {
                    a(paramInt2, paramPString1, paramPString2, paramPInt);
                  }
                  if (i == 0) {
                    break;
                  }
                  paramString1 = paramString1.concat(" " + bf.mz((String)localObject1));
                  paramString1 = bf.mz(paramString1);
                  GMTrace.o(525999276032L, 3919);
                  return paramString1;
                }
              }
              if ((o.fu(paramString2)) || (j != 0) || (o.fD(paramString2)))
              {
                paramString2 = paramString1;
                if (paramString3 != null)
                {
                  paramString2 = paramString1;
                  if (paramString3.length() > 0) {
                    paramString2 = paramString3;
                  }
                }
                if (bf.mA(paramString2))
                {
                  paramPString1.value = "";
                  paramPString2.value = "";
                  GMTrace.o(525999276032L, 3919);
                  return "";
                }
                if (paramInt1 == 0)
                {
                  paramPString1.value = ("%s:" + paramString2);
                  if (!paramBoolean1) {
                    break label7135;
                  }
                  a(paramInt2, paramPString1, paramPString2, paramPInt);
                  paramString1 = paramString2;
                }
              }
              for (;;)
              {
                if ((i == 0) || (localObject1 == null)) {
                  break label7223;
                }
                paramString1 = paramString1.concat(" " + (String)localObject1);
                paramString2 = paramString1;
                if (k != 0) {
                  paramString2 = dl(paramString1);
                }
                paramString1 = bf.mz(paramString2);
                GMTrace.o(525999276032L, 3919);
                return paramString1;
                paramPString1.value = (paramContext.getString(R.l.dHu) + ":" + paramString2);
                break;
                label7135:
                paramString1 = com.tencent.mm.u.n.eK(paramPString2.value) + ":" + paramString2;
                GMTrace.o(525999276032L, 3919);
                return paramString1;
                if ((paramString3 == null) || (paramString3.length() <= 0)) {
                  break label7226;
                }
                paramPString1.value = paramString3;
                paramString2 = paramString3;
                paramString1 = paramString2;
                if (paramBoolean1)
                {
                  a(paramInt2, paramPString1, paramPString2, paramPInt);
                  paramString1 = paramString2;
                }
              }
              label7223:
              label7226:
              label7234:
              localObject2 = "";
              localObject1 = null;
              paramString1 = paramString3;
              i = 0;
              paramString3 = (String)localObject2;
              break;
              label7252:
              i = 0;
              localObject1 = null;
              break;
              paramString1 = paramString2;
              break label2428;
              paramString1 = paramString2;
            }
          }
          label7271:
          j = i;
        }
        localObject2 = paramString3;
        str2 = "";
        str1 = "";
      }
    }
  }
  
  private static void a(int paramInt, PString paramPString1, PString paramPString2, PInt paramPInt)
  {
    int i = 150;
    GMTrace.i(526804582400L, 3925);
    if ((paramPString1.value.length() == 32) && ((paramInt == 47) || (paramInt == 1048625)))
    {
      GMTrace.o(526804582400L, 3925);
      return;
    }
    String str;
    if (paramPString1.value.length() >= 150)
    {
      localObject = paramPString1.value;
      str = paramPString1.value;
      paramInt = i;
      if (paramInt >= str.length()) {
        break label165;
      }
      if (str.charAt(paramInt) != '%') {
        label97:
        paramPString1.value = ((String)localObject).substring(0, paramInt);
      }
    }
    else
    {
      if (gMn != null) {
        break label174;
      }
    }
    label165:
    label174:
    for (Object localObject = null;; localObject = (TextPaint)gMn.get())
    {
      if ((!paramPString1.value.replace("%%", "").contains("%s")) && (localObject != null)) {
        break label188;
      }
      paramPInt.value = 0;
      GMTrace.o(526804582400L, 3925);
      return;
      paramInt += 1;
      break;
      paramInt = str.length();
      break label97;
    }
    try
    {
      label188:
      paramPString2 = String.format(paramPString1.value, new Object[] { paramPString2.value });
      if (gMo > 0)
      {
        paramInt = gMo;
        paramPString1.value = TextUtils.ellipsize(paramPString2, (TextPaint)localObject, paramInt, TextUtils.TruncateAt.END).toString();
        paramPInt.value = 1;
        GMTrace.o(526804582400L, 3925);
        return;
      }
    }
    catch (Exception paramPString2)
    {
      for (;;)
      {
        paramPString2 = paramPString1.value;
        continue;
        paramInt = BackwardSupportUtil.b.a(aa.getContext(), 200.0F);
      }
    }
  }
  
  public static void a(TextPaint paramTextPaint)
  {
    GMTrace.i(527207235584L, 3928);
    if ((gMn == null) || (gMn.get() == null)) {
      gMn = new WeakReference(paramTextPaint);
    }
    GMTrace.o(527207235584L, 3928);
  }
  
  public static String b(au paramau, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    GMTrace.i(525730840576L, 3917);
    if (paramau.bLW()) {}
    for (String str = paramau.bMs();; str = paramau.field_content)
    {
      str = com.tencent.mm.pluginsdk.ui.d.h.Ne(str);
      paramau = bf.mz(a(paramau.field_imgPath, paramau.field_isSend, paramau.field_talker, str, paramau.field_type, aa.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean));
      GMTrace.o(525730840576L, 3917);
      return paramau;
    }
  }
  
  public static String b(x paramx)
  {
    GMTrace.i(525596622848L, 3916);
    Object localObject = aa.getContext();
    if (paramx == null)
    {
      paramx = ((Context)localObject).getString(R.l.dPx);
      GMTrace.o(525596622848L, 3916);
      return paramx;
    }
    if (RegionCodeDecoder.RQ(paramx.getCountryCode()))
    {
      localObject = paramx.getCity();
      if (!bf.mA((String)localObject))
      {
        GMTrace.o(525596622848L, 3916);
        return (String)localObject;
      }
      localObject = com.tencent.mm.u.n.eM(paramx.getProvince());
      if (!bf.mA((String)localObject))
      {
        GMTrace.o(525596622848L, 3916);
        return (String)localObject;
      }
      RegionCodeDecoder.bMF();
      paramx = RegionCodeDecoder.getLocName(paramx.getCountryCode());
      GMTrace.o(525596622848L, 3916);
      return paramx;
    }
    paramx = com.tencent.mm.u.n.eM(paramx.getProvince());
    if (!bf.mA(paramx))
    {
      GMTrace.o(525596622848L, 3916);
      return paramx;
    }
    paramx = ((Context)localObject).getString(R.l.dPx);
    GMTrace.o(525596622848L, 3916);
    return paramx;
  }
  
  public static String c(Context paramContext, String paramString, boolean paramBoolean)
  {
    GMTrace.i(527341453312L, 3929);
    paramString = b.bKo().Qx(paramString);
    if (paramBoolean)
    {
      GMTrace.o(527341453312L, 3929);
      return paramString;
    }
    paramContext = paramContext.getString(R.l.esz);
    GMTrace.o(527341453312L, 3929);
    return paramContext;
  }
  
  public static String d(Context paramContext, String paramString, boolean paramBoolean)
  {
    GMTrace.i(527609888768L, 3931);
    if (paramBoolean)
    {
      paramContext = b.bKo().Qx(paramString);
      GMTrace.o(527609888768L, 3931);
      return paramContext;
    }
    paramContext = paramContext.getString(R.l.eEv);
    GMTrace.o(527609888768L, 3931);
    return paramContext;
  }
  
  public static void dX(int paramInt)
  {
    GMTrace.i(526938800128L, 3926);
    gMo = paramInt;
    GMTrace.o(526938800128L, 3926);
  }
  
  public static void dY(int paramInt)
  {
    GMTrace.i(527073017856L, 3927);
    gMp = paramInt;
    GMTrace.o(527073017856L, 3927);
  }
  
  private static String dk(String paramString)
  {
    GMTrace.i(526267711488L, 3921);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("%", "%%");
      GMTrace.o(526267711488L, 3921);
      return paramString;
    }
    GMTrace.o(526267711488L, 3921);
    return paramString;
  }
  
  private static String dl(String paramString)
  {
    GMTrace.i(526536146944L, 3923);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("%%", "%");
      GMTrace.o(526536146944L, 3923);
      return paramString;
    }
    GMTrace.o(526536146944L, 3923);
    return paramString;
  }
  
  public static String dm(String paramString)
  {
    GMTrace.i(526670364672L, 3924);
    if (paramString == null)
    {
      GMTrace.o(526670364672L, 3924);
      return "";
    }
    if (paramString.length() < 150)
    {
      GMTrace.o(526670364672L, 3924);
      return paramString;
    }
    paramString = paramString.substring(0, 150) + "...";
    GMTrace.o(526670364672L, 3924);
    return paramString;
  }
  
  public static String f(Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(525462405120L, 3915);
    if (o.dH(paramString1))
    {
      paramString2 = ay.gi(paramString2);
      if (paramString2 != null) {
        paramString2 = com.tencent.mm.u.n.eK(paramString2.trim());
      }
    }
    while (paramString1.contains("@bottle"))
    {
      paramContext = paramContext.getResources().getQuantityString(R.j.dsn, 1, new Object[] { Integer.valueOf(1) });
      GMTrace.o(525462405120L, 3915);
      return paramContext;
      paramString2 = com.tencent.mm.u.n.eK(paramString1);
      continue;
      paramString2 = com.tencent.mm.u.n.eK(paramString1);
    }
    String str = paramString2;
    if (bf.mA(paramString2))
    {
      str = paramString2;
      if (o.dH(paramString1)) {
        str = paramContext.getString(R.l.dVj);
      }
    }
    paramContext = b.bKo().Qx(str);
    GMTrace.o(525462405120L, 3915);
    return paramContext;
  }
  
  private static String i(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(526401929216L, 3922);
    if ((bf.mA(paramString1)) || (bf.mA(paramString2)) || (bf.mA(paramString3)))
    {
      GMTrace.o(526401929216L, 3922);
      return paramString1;
    }
    int i = paramString1.indexOf(paramString2);
    if (i < 0)
    {
      GMTrace.o(526401929216L, 3922);
      return paramString1;
    }
    paramString1 = paramString1.substring(0, i) + paramString3 + paramString1.substring(i + paramString2.length());
    GMTrace.o(526401929216L, 3922);
    return paramString1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/notification/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */