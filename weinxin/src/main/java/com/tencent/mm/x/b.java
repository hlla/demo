package com.tencent.mm.x;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;

public final class b
{
  private static String P(long paramLong)
  {
    GMTrace.i(391647330304L, 2918);
    String str = new o(paramLong) + "@qqim";
    GMTrace.o(391647330304L, 2918);
    return str;
  }
  
  public static Bitmap Q(long paramLong)
  {
    GMTrace.i(392184201216L, 2922);
    Bitmap localBitmap = a(P(paramLong), false, -1);
    GMTrace.o(392184201216L, 2922);
    return localBitmap;
  }
  
  public static String Q(String paramString1, String paramString2)
  {
    GMTrace.i(390842023936L, 2912);
    paramString1 = paramString1 + "?access_token=" + paramString2;
    GMTrace.o(390842023936L, 2912);
    return paramString1;
  }
  
  public static Bitmap a(String paramString, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(392586854400L, 2925);
    if ((bf.mA(paramString)) || (!com.tencent.mm.kernel.h.vG().uV()))
    {
      GMTrace.o(392586854400L, 2925);
      return null;
    }
    if (!com.tencent.mm.kernel.h.vI().vu())
    {
      paramString = n.Bl().aS(aa.getContext());
      GMTrace.o(392586854400L, 2925);
      return paramString;
    }
    String str = paramString;
    if (x.eO(paramString)) {
      str = x.QQ(paramString);
    }
    paramString = n.Bz().b(str, paramBoolean, paramInt);
    GMTrace.o(392586854400L, 2925);
    return paramString;
  }
  
  public static h a(String paramString, amb paramamb)
  {
    GMTrace.i(392989507584L, 2928);
    h localh = new h();
    localh.fRM = -1;
    localh.username = paramString;
    localh.hrj = paramamb.tow;
    localh.hrk = paramamb.tov;
    v.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.Bs(), localh.Bt() });
    boolean bool;
    if (paramamb.tOU != 0)
    {
      bool = true;
      localh.aV(bool);
      if ((paramamb.tOP != 3) && (paramamb.tOP != 4)) {
        break label129;
      }
      localh.gkg = paramamb.tOP;
    }
    for (;;)
    {
      GMTrace.o(392989507584L, 2928);
      return localh;
      bool = false;
      break;
      label129:
      if (paramamb.tOP == 2)
      {
        localh.gkg = 3;
        if (!m.xL().equals(paramString))
        {
          n.Bl();
          d.s(paramString, false);
          n.Bl();
          d.s(paramString, true);
          n.Bz().hf(paramString);
        }
      }
    }
  }
  
  public static Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(392452636672L, 2924);
    if ((bf.mA(paramString)) || (!com.tencent.mm.kernel.h.vG().uV()))
    {
      GMTrace.o(392452636672L, 2924);
      return null;
    }
    n.Bl();
    v.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bf.mA(paramString)) {}
    for (Object localObject = null; localObject == null; localObject = com.tencent.mm.sdk.platformtools.d.a(d.r(paramString, true), paramInt1, paramInt2, null, 0, new int[] { 0, 1 }))
    {
      localObject = new e();
      ((e)localObject).a(paramString, new e.b()
      {
        public final int aM(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          GMTrace.i(381983653888L, 2846);
          this.hqq.Bp();
          v.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          GMTrace.o(381983653888L, 2846);
          return 0;
        }
      });
      paramString = a(paramString, false, paramInt3);
      GMTrace.o(392452636672L, 2924);
      return paramString;
    }
    paramString = (String)localObject;
    if (paramInt3 > 5) {
      paramString = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, false, paramInt3);
    }
    GMTrace.o(392452636672L, 2924);
    return paramString;
  }
  
  public static boolean d(long paramLong, int paramInt)
  {
    GMTrace.i(391915765760L, 2920);
    if (paramInt != 3)
    {
      GMTrace.o(391915765760L, 2920);
      return false;
    }
    boolean bool = hc(P(paramLong));
    GMTrace.o(391915765760L, 2920);
    return bool;
  }
  
  public static Bitmap gW(String paramString)
  {
    GMTrace.i(390976241664L, 2913);
    paramString = a(paramString + "@google", false, -1);
    GMTrace.o(390976241664L, 2913);
    return paramString;
  }
  
  private static String gX(String paramString)
  {
    GMTrace.i(391110459392L, 2914);
    paramString = "http://graph.facebook.com/" + paramString + "/picture";
    GMTrace.o(391110459392L, 2914);
    return paramString;
  }
  
  public static void gY(String paramString)
  {
    GMTrace.i(391244677120L, 2915);
    if (bf.mA(paramString))
    {
      GMTrace.o(391244677120L, 2915);
      return;
    }
    String str = paramString + "@fb";
    h localh2 = n.Bm().hs(str);
    if ((localh2 != null) && (str.equals(localh2.getUsername())) && (3 == localh2.gkg))
    {
      GMTrace.o(391244677120L, 2915);
      return;
    }
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = new h();
    }
    localh1.username = str;
    localh1.gkg = 3;
    localh1.hrk = gX(paramString);
    localh1.hrj = gX(paramString);
    localh1.aV(true);
    localh1.fRM = 31;
    n.Bm().a(localh1);
    GMTrace.o(391244677120L, 2915);
  }
  
  public static Bitmap gZ(String paramString)
  {
    GMTrace.i(391378894848L, 2916);
    paramString = a(paramString + "@fb", false, -1);
    GMTrace.o(391378894848L, 2916);
    return paramString;
  }
  
  public static long ha(String paramString)
  {
    GMTrace.i(391513112576L, 2917);
    if (!x.QO(paramString))
    {
      GMTrace.o(391513112576L, 2917);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bf.getLong(paramString[0], -1L);
      GMTrace.o(391513112576L, 2917);
      return l;
    }
    catch (Exception paramString)
    {
      GMTrace.o(391513112576L, 2917);
    }
    return -1L;
  }
  
  public static long hb(String paramString)
  {
    GMTrace.i(391781548032L, 2919);
    if (!x.QN(paramString))
    {
      GMTrace.o(391781548032L, 2919);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bf.getLong(paramString[0], -1L);
      GMTrace.o(391781548032L, 2919);
      return l;
    }
    catch (Exception paramString)
    {
      GMTrace.o(391781548032L, 2919);
    }
    return -1L;
  }
  
  public static boolean hc(String paramString)
  {
    GMTrace.i(392049983488L, 2921);
    if (paramString == null)
    {
      v.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      GMTrace.o(392049983488L, 2921);
      return false;
    }
    if (!paramString.endsWith("@qqim"))
    {
      v.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      GMTrace.o(392049983488L, 2921);
      return false;
    }
    h localh = new h();
    localh.username = paramString;
    localh.gkg = 3;
    localh.fRM = 3;
    boolean bool = n.Bm().a(localh);
    GMTrace.o(392049983488L, 2921);
    return bool;
  }
  
  public static String hd(String paramString)
  {
    GMTrace.i(392721072128L, 2926);
    if ((bf.mA(paramString)) || (!com.tencent.mm.kernel.h.vG().uV()))
    {
      GMTrace.o(392721072128L, 2926);
      return null;
    }
    if (!com.tencent.mm.kernel.h.vI().vu())
    {
      GMTrace.o(392721072128L, 2926);
      return null;
    }
    if (x.eO(paramString))
    {
      n.Bl();
      paramString = d.r(x.QQ(paramString), false);
      GMTrace.o(392721072128L, 2926);
      return paramString;
    }
    n.Bl();
    paramString = d.r(paramString, false);
    GMTrace.o(392721072128L, 2926);
    return paramString;
  }
  
  public static void he(String paramString)
  {
    GMTrace.i(392855289856L, 2927);
    h localh = n.Bm().hs(paramString);
    if (localh == null)
    {
      GMTrace.o(392855289856L, 2927);
      return;
    }
    if (!paramString.equals(localh.getUsername()))
    {
      GMTrace.o(392855289856L, 2927);
      return;
    }
    localh.hrm = 0;
    localh.fRM = 64;
    n.Bm().a(localh);
    GMTrace.o(392855289856L, 2927);
  }
  
  public static boolean u(String paramString, int paramInt)
  {
    GMTrace.i(392318418944L, 2923);
    if (bf.mA(paramString))
    {
      GMTrace.o(392318418944L, 2923);
      return false;
    }
    h localh2 = n.Bm().hs(paramString);
    if ((localh2 != null) && (paramString.equals(localh2.getUsername())) && (paramInt == localh2.gkg))
    {
      GMTrace.o(392318418944L, 2923);
      return true;
    }
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = new h();
    }
    localh1.username = paramString;
    localh1.gkg = paramInt;
    localh1.fRM = 3;
    boolean bool = n.Bm().a(localh1);
    GMTrace.o(392318418944L, 2923);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */