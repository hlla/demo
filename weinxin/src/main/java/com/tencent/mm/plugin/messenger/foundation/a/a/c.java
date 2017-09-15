package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.storage.au.c;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public abstract interface c
  extends f
{
  public abstract List<au> A(String paramString, long paramLong);
  
  public abstract long AA(String paramString);
  
  public abstract long AB(String paramString);
  
  public abstract long AC(String paramString);
  
  public abstract au AD(String paramString);
  
  public abstract int AE(String paramString);
  
  public abstract void Ac(String paramString);
  
  public abstract void Ad(String paramString);
  
  public abstract Cursor Ae(String paramString);
  
  public abstract au Af(String paramString);
  
  public abstract au Ag(String paramString);
  
  public abstract au Ah(String paramString);
  
  public abstract au Ai(String paramString);
  
  public abstract List<au> Aj(String paramString);
  
  public abstract Cursor Ak(String paramString);
  
  public abstract void Al(String paramString);
  
  public abstract int Am(String paramString);
  
  public abstract boolean An(String paramString);
  
  public abstract int Ao(String paramString);
  
  public abstract Cursor Ap(String paramString);
  
  public abstract Cursor Aq(String paramString);
  
  public abstract au.c Ar(String paramString);
  
  public abstract au.d As(String paramString);
  
  public abstract au.a At(String paramString);
  
  public abstract au.b Au(String paramString);
  
  public abstract int Av(String paramString);
  
  public abstract boolean Aw(String paramString);
  
  public abstract int Ax(String paramString);
  
  public abstract int Ay(String paramString);
  
  public abstract String Az(String paramString);
  
  public abstract Cursor B(String paramString1, String paramString2, int paramInt);
  
  public abstract List<au> B(String paramString, long paramLong);
  
  public abstract boolean C(String paramString, long paramLong);
  
  public abstract long D(String paramString, long paramLong);
  
  public abstract List<au> D(String paramString, int paramInt1, int paramInt2);
  
  public abstract int E(String paramString, long paramLong);
  
  public abstract Cursor E(String paramString, int paramInt1, int paramInt2);
  
  public abstract int F(String paramString, long paramLong);
  
  public abstract int G(String paramString, long paramLong);
  
  public abstract String H(String paramString, long paramLong);
  
  public abstract au I(String paramString, long paramLong);
  
  public abstract long J(String paramString, long paramLong);
  
  public abstract void J(ArrayList<Long> paramArrayList);
  
  public abstract int K(au paramau);
  
  public abstract long K(String paramString, long paramLong);
  
  public abstract long L(au paramau);
  
  public abstract void M(au paramau);
  
  public abstract int N(au paramau);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, au paramau);
  
  public abstract void a(g paramg, String paramString);
  
  public abstract void a(a parama);
  
  public abstract void a(a parama, Looper paramLooper);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(e parame);
  
  public abstract boolean a(long paramLong, String paramString1, String paramString2, String paramString3);
  
  public abstract g aJS();
  
  public abstract void aJT();
  
  public abstract void aJU();
  
  public abstract void aJV();
  
  public abstract ArrayList<au> aJW();
  
  public abstract List<au> aJX();
  
  public abstract Cursor aJY();
  
  public abstract Cursor aJZ();
  
  public abstract String aKa();
  
  public abstract String aKb();
  
  public abstract long b(au paramau, boolean paramBoolean);
  
  public abstract void b(long paramLong, au paramau);
  
  public abstract void b(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract List<au> bd(String paramString, int paramInt);
  
  public abstract List<au> be(String paramString, int paramInt);
  
  public abstract Cursor bf(String paramString, int paramInt);
  
  public abstract Cursor bg(String paramString, int paramInt);
  
  public abstract int bh(String paramString, int paramInt);
  
  public abstract Cursor bi(String paramString, int paramInt);
  
  public abstract Cursor bj(String paramString, int paramInt);
  
  public abstract Cursor bk(String paramString, int paramInt);
  
  public abstract int bl(String paramString, int paramInt);
  
  public abstract Cursor bm(String paramString, int paramInt);
  
  public abstract au[] bn(String paramString, int paramInt);
  
  public abstract int c(String paramString, long paramLong, int paramInt);
  
  public abstract List<au> c(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract au cA(long paramLong);
  
  public abstract int cB(long paramLong);
  
  public abstract boolean cC(long paramLong);
  
  public abstract boolean cD(long paramLong);
  
  public abstract void cE(long paramLong);
  
  public abstract au cN(String paramString1, String paramString2);
  
  public abstract Cursor cO(String paramString1, String paramString2);
  
  public abstract int cP(String paramString1, String paramString2);
  
  public abstract LinkedList<au> cQ(String paramString1, String paramString2);
  
  public abstract Cursor e(String paramString, long paramLong1, long paramLong2);
  
  public abstract int f(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor f(String paramString, int paramInt, long paramLong);
  
  public abstract int g(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor g(String paramString, int paramInt, long paramLong);
  
  public abstract Cursor h(String paramString, long paramLong1, long paramLong2);
  
  public abstract int i(String paramString, long paramLong1, long paramLong2);
  
  public abstract Cursor j(String paramString, long paramLong1, long paramLong2);
  
  public abstract au ph(int paramInt);
  
  public abstract void w(String paramString, long paramLong);
  
  public abstract au x(String paramString, long paramLong);
  
  public abstract au y(String paramString, long paramLong);
  
  public abstract au z(String paramString, long paramLong);
  
  public static abstract interface a
  {
    public abstract void a(c paramc, c.c paramc1);
  }
  
  public static final class b
  {
    public long hEO;
    public String name;
    public a[] nxj;
    public int nxk;
    
    public b(int paramInt, String paramString, a[] paramArrayOfa)
    {
      GMTrace.i(13370635845632L, 99619);
      if (paramString.length() > 0)
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        this.name = paramString;
        if (paramArrayOfa.length != 2) {
          break label157;
        }
        bool1 = true;
        label44:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[0].nxm < paramArrayOfa[0].nxl) {
          break label163;
        }
        bool1 = true;
        label68:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].nxm < paramArrayOfa[1].nxl) {
          break label169;
        }
        bool1 = true;
        label92:
        Assert.assertTrue(bool1);
        if (paramArrayOfa[1].nxl < paramArrayOfa[0].nxm) {
          break label175;
        }
      }
      label157:
      label163:
      label169:
      label175:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Assert.assertTrue(bool1);
        this.nxj = paramArrayOfa;
        this.nxk = paramInt;
        this.hEO = paramArrayOfa[0].nxl;
        GMTrace.o(13370635845632L, 99619);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label44;
        bool1 = false;
        break label68;
        bool1 = false;
        break label92;
      }
    }
    
    public static a[] a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      GMTrace.i(13371038498816L, 99622);
      a locala1 = new a();
      locala1.nxl = paramLong1;
      locala1.nxm = paramLong2;
      a locala2 = new a();
      locala2.nxl = paramLong3;
      locala2.nxm = paramLong4;
      GMTrace.o(13371038498816L, 99622);
      return new a[] { locala1, locala2 };
    }
    
    /* Error */
    public final void aKc()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc2_w 69
      //   5: ldc 71
      //   7: invokestatic 32	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   10: aload_0
      //   11: getfield 54	com/tencent/mm/plugin/messenger/foundation/a/a/c$b:nxj	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/c$b$a;
      //   14: iconst_0
      //   15: aaload
      //   16: astore_1
      //   17: aload_0
      //   18: getfield 58	com/tencent/mm/plugin/messenger/foundation/a/a/c$b:hEO	J
      //   21: aload_1
      //   22: getfield 49	com/tencent/mm/plugin/messenger/foundation/a/a/c$b$a:nxm	J
      //   25: lcmp
      //   26: ifne +68 -> 94
      //   29: aload_0
      //   30: aload_0
      //   31: getfield 54	com/tencent/mm/plugin/messenger/foundation/a/a/c$b:nxj	[Lcom/tencent/mm/plugin/messenger/foundation/a/a/c$b$a;
      //   34: iconst_1
      //   35: aaload
      //   36: getfield 52	com/tencent/mm/plugin/messenger/foundation/a/a/c$b$a:nxl	J
      //   39: putfield 58	com/tencent/mm/plugin/messenger/foundation/a/a/c$b:hEO	J
      //   42: getstatic 77	com/tencent/mm/plugin/report/c:oRz	Lcom/tencent/mm/plugin/report/c;
      //   45: ldc2_w 78
      //   48: ldc2_w 80
      //   51: lconst_1
      //   52: iconst_0
      //   53: invokevirtual 84	com/tencent/mm/plugin/report/c:a	(JJJZ)V
      //   56: invokestatic 90	com/tencent/mm/sdk/a/b:bIm	()Z
      //   59: ifne +24 -> 83
      //   62: ldc 92
      //   64: ldc 94
      //   66: iconst_1
      //   67: anewarray 4	java/lang/Object
      //   70: dup
      //   71: iconst_0
      //   72: aload_0
      //   73: getfield 58	com/tencent/mm/plugin/messenger/foundation/a/a/c$b:hEO	J
      //   76: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   79: aastore
      //   80: invokestatic 105	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   83: ldc2_w 69
      //   86: ldc 71
      //   88: invokestatic 61	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   91: aload_0
      //   92: monitorexit
      //   93: return
      //   94: aload_0
      //   95: aload_0
      //   96: getfield 58	com/tencent/mm/plugin/messenger/foundation/a/a/c$b:hEO	J
      //   99: lconst_1
      //   100: ladd
      //   101: putfield 58	com/tencent/mm/plugin/messenger/foundation/a/a/c$b:hEO	J
      //   104: goto -48 -> 56
      //   107: astore_1
      //   108: aload_0
      //   109: monitorexit
      //   110: aload_1
      //   111: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	112	0	this	b
      //   16	6	1	locala	a
      //   107	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	56	107	finally
      //   56	83	107	finally
      //   83	91	107	finally
      //   94	104	107	finally
    }
    
    public final boolean cF(long paramLong)
    {
      boolean bool = true;
      GMTrace.i(13370904281088L, 99621);
      a[] arrayOfa = this.nxj;
      int k = arrayOfa.length;
      int i = 0;
      int j;
      if (i < k)
      {
        a locala = arrayOfa[i];
        if ((paramLong >= locala.nxl) && (paramLong <= locala.nxm))
        {
          j = 1;
          label59:
          if (j == 0) {
            break label81;
          }
        }
      }
      for (;;)
      {
        GMTrace.o(13370904281088L, 99621);
        return bool;
        j = 0;
        break label59;
        label81:
        i += 1;
        break;
        bool = false;
      }
    }
    
    private static final class a
    {
      public long nxl;
      public long nxm;
      
      public a()
      {
        GMTrace.i(13370367410176L, 99617);
        GMTrace.o(13370367410176L, 99617);
      }
    }
  }
  
  public static final class c
  {
    public String fJC;
    public long jZq;
    public String nxn;
    public ArrayList<au> nxo;
    public int nxp;
    public int nxq;
    public int nxr;
    public long nxs;
    
    public c(String paramString1, String paramString2, int paramInt)
    {
      this(paramString1, paramString2, null, 0);
      GMTrace.i(13369562103808L, 99611);
      this.nxr = paramInt;
      GMTrace.o(13369562103808L, 99611);
    }
    
    public c(String paramString1, String paramString2, au paramau)
    {
      this(paramString1, paramString2, paramau, 0);
      GMTrace.i(13369293668352L, 99609);
      GMTrace.o(13369293668352L, 99609);
    }
    
    public c(String paramString1, String paramString2, au paramau, int paramInt)
    {
      GMTrace.i(13369427886080L, 99610);
      this.nxo = new ArrayList();
      this.nxq = 0;
      this.nxr = 0;
      this.nxs = 0L;
      this.jZq = -1L;
      this.fJC = paramString1;
      this.nxn = paramString2;
      this.nxp = paramInt;
      if (paramau != null) {
        l = paramau.field_bizChatId;
      }
      this.jZq = l;
      if (paramau != null) {
        this.nxo.add(paramau);
      }
      GMTrace.o(13369427886080L, 99610);
    }
    
    public static boolean O(au paramau)
    {
      GMTrace.i(13369696321536L, 99612);
      if ((paramau != null) && (paramau.field_isSend == 0) && (paramau.field_status == 3))
      {
        GMTrace.o(13369696321536L, 99612);
        return true;
      }
      GMTrace.o(13369696321536L, 99612);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/foundation/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */