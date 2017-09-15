package com.tencent.mm.plugin.subapp.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ag.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class b
  implements ag.c
{
  public b()
  {
    GMTrace.i(5760759103488L, 42921);
    GMTrace.o(5760759103488L, 42921);
  }
  
  private String U(int paramInt, boolean paramBoolean)
  {
    int k = 0;
    GMTrace.i(5761161756672L, 42924);
    ap.yY();
    if (!c.isSDCardAvailable())
    {
      GMTrace.o(5761161756672L, 42924);
      return null;
    }
    int i;
    if (paramInt == 0)
    {
      i = -1;
      if (i != -1) {
        break label109;
      }
      paramInt = k;
      label45:
      if (paramInt != 0) {
        break label116;
      }
    }
    label109:
    label116:
    for (String str = null;; str = u(paramInt, paramBoolean))
    {
      if (!com.tencent.mm.a.e.aO(str)) {
        break label127;
      }
      GMTrace.o(5761161756672L, 42924);
      return str;
      i = 0;
      int j = paramInt;
      paramInt = i;
      for (;;)
      {
        i = paramInt;
        if (paramInt >= 32) {
          break;
        }
        j = j >> 1 & 0x7FFFFFFF;
        i = paramInt;
        if (j == 0) {
          break;
        }
        paramInt += 1;
      }
      paramInt = 1 << i;
      break label45;
    }
    label127:
    yJ();
    GMTrace.o(5761161756672L, 42924);
    return null;
  }
  
  public final String eY(int paramInt)
  {
    GMTrace.i(5760893321216L, 42922);
    String str = U(paramInt, true);
    GMTrace.o(5760893321216L, 42922);
    return str;
  }
  
  public final String eZ(int paramInt)
  {
    GMTrace.i(5761027538944L, 42923);
    String str = U(paramInt, false);
    GMTrace.o(5761027538944L, 42923);
    return str;
  }
  
  public final boolean fa(int paramInt)
  {
    GMTrace.i(5761430192128L, 42926);
    if (paramInt == 0)
    {
      GMTrace.o(5761430192128L, 42926);
      return false;
    }
    int i = 0;
    while (i < 32)
    {
      if ((!com.tencent.mm.a.e.aO(u(1 << i & paramInt, false))) || (!com.tencent.mm.a.e.aO(u(1 << i & paramInt, true))))
      {
        GMTrace.o(5761430192128L, 42926);
        return false;
      }
      i += 1;
    }
    GMTrace.o(5761430192128L, 42926);
    return true;
  }
  
  public final String u(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(5761564409856L, 42927);
    if (paramInt == 0)
    {
      GMTrace.o(5761564409856L, 42927);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(com.tencent.mm.compatible.util.e.gSq).append("vuserpic_").append(Integer.toHexString(paramInt));
    if (paramBoolean) {}
    for (String str = "_HD";; str = "")
    {
      str = str + ".png";
      GMTrace.o(5761564409856L, 42927);
      return str;
    }
  }
  
  public final void yJ()
  {
    GMTrace.i(5761295974400L, 42925);
    ap.yY();
    if (!c.isSDCardAvailable())
    {
      GMTrace.o(5761295974400L, 42925);
      return;
    }
    ap.yY();
    long l1 = bf.a((Long)c.vr().get(66051, null), 0L);
    long l2 = bf.NA();
    if (432000000L > l2 - l1)
    {
      GMTrace.o(5761295974400L, 42925);
      return;
    }
    ap.yY();
    c.vr().set(66051, Long.valueOf(l2));
    new a();
    GMTrace.o(5761295974400L, 42925);
  }
  
  private static final class a
    implements com.tencent.mm.y.e
  {
    public a()
    {
      GMTrace.i(5758745837568L, 42906);
      ap.vd().a(167, this);
      a locala = new a();
      ap.vd().a(locala, 0);
      GMTrace.o(5758745837568L, 42906);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
    {
      GMTrace.i(5758880055296L, 42907);
      ap.vd().b(167, this);
      GMTrace.o(5758880055296L, 42907);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */