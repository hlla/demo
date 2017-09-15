package com.tencent.mm.plugin.subapp.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bip;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class a
  extends k
  implements j
{
  public final com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  private ai hqz;
  public int qRn;
  
  public a()
  {
    GMTrace.i(5759819579392L, 42914);
    this.qRn = 0;
    this.hqz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(5760624885760L, 42920);
        if (a.this.qRn < 0)
        {
          GMTrace.o(5760624885760L, 42920);
          return false;
        }
        acj localacj = (acj)a.this.gUq.hrT.hsa;
        try
        {
          Object localObject1 = (bip)localacj.tGA.get(a.this.qRn);
          if ((localObject1 != null) && (((bip)localObject1).ugL != null) && (((bip)localObject1).ugK != null))
          {
            v.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + localacj.jMp + " idx:" + a.this.qRn + " id:" + Integer.toHexString(((bip)localObject1).fxf) + " size:" + ((bip)localObject1).ugK.tXB + " hdsize:" + ((bip)localObject1).ugL.tXB);
            a.a(((bip)localObject1).fxf, true, ((bip)localObject1).ugL.tXD.toByteArray());
            a.a(((bip)localObject1).fxf, false, ((bip)localObject1).ugK.tXD.toByteArray());
          }
          localObject1 = a.this;
          ((a)localObject1).qRn -= 1;
          GMTrace.o(5760624885760L, 42920);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + a.this.qRn + " not Found");
            Object localObject2 = null;
          }
        }
      }
    }, true);
    ap.yY();
    int j = bf.f((Integer)c.vr().get(66052, null));
    if (ag.a.hlC.fa(j))
    {
      ap.yY();
      i = bf.f((Integer)c.vr().get(66053, null));
    }
    Object localObject = new StringBuilder("init: allfileid:").append(Integer.toBinaryString(j)).append(" inver:");
    ap.yY();
    v.d("MicroMsg.NetSceneGetVUserInfo", bf.f((Integer)c.vr().get(66053, null)) + " reqver:" + i);
    localObject = new b.a();
    ((b.a)localObject).hrV = new aci();
    ((b.a)localObject).hrW = new acj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getvuserinfo";
    ((b.a)localObject).hrU = 167;
    ((b.a)localObject).hrX = 60;
    ((b.a)localObject).hrY = 1000000060;
    this.gUq = ((b.a)localObject).BE();
    ((aci)this.gUq.hrS.hsa).jMp = i;
    GMTrace.o(5759819579392L, 42914);
  }
  
  /* Error */
  public static boolean a(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc2_w 176
    //   3: ldc -78
    //   5: invokestatic 29	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: new 180	java/io/FileOutputStream
    //   11: dup
    //   12: getstatic 74	com/tencent/mm/u/ag$a:hlC	Lcom/tencent/mm/u/ag$c;
    //   15: iload_0
    //   16: iload_1
    //   17: invokeinterface 184 3 0
    //   22: invokespecial 185	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: aload_2
    //   33: invokevirtual 189	java/io/FileOutputStream:write	([B)V
    //   36: aload 4
    //   38: astore_3
    //   39: aload 4
    //   41: invokevirtual 192	java/io/FileOutputStream:close	()V
    //   44: aload 4
    //   46: invokevirtual 192	java/io/FileOutputStream:close	()V
    //   49: ldc2_w 176
    //   52: ldc -78
    //   54: invokestatic 170	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   57: iconst_1
    //   58: ireturn
    //   59: astore 5
    //   61: aconst_null
    //   62: astore_2
    //   63: aload_2
    //   64: astore_3
    //   65: ldc 100
    //   67: aload 5
    //   69: ldc -62
    //   71: iconst_0
    //   72: anewarray 196	java/lang/Object
    //   75: invokestatic 200	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 192	java/io/FileOutputStream:close	()V
    //   86: ldc2_w 176
    //   89: ldc -78
    //   91: invokestatic 170	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   94: iconst_0
    //   95: ireturn
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_3
    //   99: aload_3
    //   100: ifnull +7 -> 107
    //   103: aload_3
    //   104: invokevirtual 192	java/io/FileOutputStream:close	()V
    //   107: aload_2
    //   108: athrow
    //   109: astore_2
    //   110: goto -61 -> 49
    //   113: astore_2
    //   114: goto -28 -> 86
    //   117: astore_3
    //   118: goto -11 -> 107
    //   121: astore_2
    //   122: goto -23 -> 99
    //   125: astore 5
    //   127: aload 4
    //   129: astore_2
    //   130: goto -67 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramInt	int
    //   0	133	1	paramBoolean	boolean
    //   0	133	2	paramArrayOfByte	byte[]
    //   29	75	3	localObject	Object
    //   117	1	3	localException1	Exception
    //   25	103	4	localFileOutputStream	java.io.FileOutputStream
    //   59	9	5	localException2	Exception
    //   125	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   8	27	59	java/lang/Exception
    //   8	27	96	finally
    //   44	49	109	java/lang/Exception
    //   82	86	113	java/lang/Exception
    //   103	107	117	java/lang/Exception
    //   30	36	121	finally
    //   39	44	121	finally
    //   65	78	121	finally
    //   30	36	125	java/lang/Exception
    //   39	44	125	java/lang/Exception
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(5759953797120L, 42915);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(5759953797120L, 42915);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(5760222232576L, 42917);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneGetVUserInfo", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5760222232576L, 42917);
      return;
    }
    paramp = (acj)((com.tencent.mm.y.b)paramp).hrT.hsa;
    paramArrayOfByte = new StringBuilder("onGYNetEnd new version:").append(paramp.jMp).append(" old version:");
    ap.yY();
    v.d("MicroMsg.NetSceneGetVUserInfo", bf.f((Integer)c.vr().get(66053, null)) + " Count:" + paramp.tGA.size());
    ap.yY();
    c.vr().set(66053, Integer.valueOf(paramp.jMp));
    if (paramp.tGA.size() <= 0)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5760222232576L, 42917);
      return;
    }
    int i = 0;
    paramInt1 = 0;
    while (paramInt1 < paramp.tGA.size())
    {
      i |= ((bip)paramp.tGA.get(paramInt1)).fxf;
      paramInt1 += 1;
    }
    ap.yY();
    c.vr().set(66052, Integer.valueOf(i));
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    this.qRn = (paramp.tGA.size() - 1);
    this.hqz.v(50L, 50L);
    GMTrace.o(5760222232576L, 42917);
  }
  
  public final int getType()
  {
    GMTrace.i(5760088014848L, 42916);
    GMTrace.o(5760088014848L, 42916);
    return 167;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */