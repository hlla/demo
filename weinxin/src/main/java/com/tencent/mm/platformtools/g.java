package com.tencent.mm.platformtools;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import junit.framework.Assert;

public final class g
{
  public static SparseArray<a> ihk;
  
  static
  {
    GMTrace.i(13455461449728L, 100251);
    ihk = new SparseArray();
    GMTrace.o(13455461449728L, 100251);
  }
  
  public static final a a(int paramInt, String paramString, HashMap<Integer, g.c> paramHashMap, boolean paramBoolean)
  {
    GMTrace.i(13455193014272L, 100249);
    if ((!bf.mA(paramString)) && (paramHashMap != null)) {}
    int i;
    a locala;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      i = paramString.hashCode();
      locala = (a)ihk.get(i);
      if (locala != null) {
        break label178;
      }
      locala = new a(paramString, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      h.vG();
      if (locala.a("", paramString, "", a.uH(), p.rA(), paramHashMap, true)) {
        break label128;
      }
      throw new b((byte)0);
    }
    if (!locala.b(paramString, paramHashMap, true, false)) {
      throw new b((byte)0);
    }
    label128:
    ihk.put(i, locala);
    for (paramString = locala;; paramString = locala)
    {
      v.d("MicroMsg.GeneralDBHelper", "addRef %d", new Object[] { Integer.valueOf(paramInt) });
      paramString.ihm.put(paramInt, true);
      GMTrace.o(13455193014272L, 100249);
      return paramString;
      label178:
      if (paramBoolean == locala.ihl) {
        paramBoolean = true;
      }
      long l;
      for (;;)
      {
        Assert.assertTrue(paramBoolean);
        l = locala.cs(-1L);
        paramString = paramHashMap.values().iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            paramHashMap = ((g.c)paramString.next()).pP();
            int j = paramHashMap.length;
            i = 0;
            label244:
            if (i < j)
            {
              String str = paramHashMap[i];
              v.d("MicroMsg.GeneralDBHelper", "init sql:" + str);
              try
              {
                locala.eE(null, str);
                i += 1;
                break label244;
                paramBoolean = false;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Assert.assertTrue("CreateTable failed:[" + str + "][" + localException.getMessage() + "]", false);
                }
              }
            }
          }
        }
      }
      locala.aD(l);
    }
  }
  
  public static final class a
    extends com.tencent.mm.bj.g
  {
    public final boolean ihl;
    SparseBooleanArray ihm;
    private final String path;
    
    public a(String paramString, boolean paramBoolean)
    {
      GMTrace.i(13451703353344L, 100223);
      this.ihm = new SparseBooleanArray();
      v.d("MicroMsg.GeneralDBHelper", "create db %s", new Object[] { paramString });
      this.ihl = paramBoolean;
      this.path = paramString;
      GMTrace.o(13451703353344L, 100223);
    }
    
    @Deprecated
    public final void cQ(String paramString)
    {
      GMTrace.i(13452106006528L, 100226);
      v.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
      if (this.ihm.size() <= 1) {
        super.cQ(paramString);
      }
      GMTrace.o(13452106006528L, 100226);
    }
    
    public final void gZ(int paramInt)
    {
      GMTrace.i(13451837571072L, 100224);
      v.d("MicroMsg.GeneralDBHelper", "try close db %d", new Object[] { Integer.valueOf(paramInt) });
      this.ihm.delete(paramInt);
      if (this.ihm.size() <= 0)
      {
        v.d("MicroMsg.GeneralDBHelper", "close db %d succ", new Object[] { Integer.valueOf(paramInt) });
        super.wL();
        g.ihk.remove(this.path.hashCode());
      }
      GMTrace.o(13451837571072L, 100224);
    }
    
    @Deprecated
    public final void wL()
    {
      GMTrace.i(13451971788800L, 100225);
      v.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", new Object[] { bf.bJP() });
      if (this.ihm.size() <= 1) {
        super.wL();
      }
      GMTrace.o(13451971788800L, 100225);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/platformtools/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */