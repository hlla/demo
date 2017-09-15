package com.tencent.mm.c.b;

import android.os.Build;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public class g
{
  public static final String fAA;
  public static final String fAz;
  
  static
  {
    GMTrace.i(4475221704704L, 33343);
    fAz = com.tencent.mm.compatible.util.e.hgk + "test.wav";
    fAA = com.tencent.mm.compatible.util.e.hgk + "test.pcm";
    GMTrace.o(4475221704704L, 33343);
  }
  
  public g()
  {
    GMTrace.i(4474953269248L, 33341);
    GMTrace.o(4474953269248L, 33341);
  }
  
  public static int j(String paramString, int paramInt)
  {
    GMTrace.i(4475087486976L, 33342);
    try
    {
      int i = bf.getInt(((a)h.h(a.class)).sV().getValue(paramString), paramInt);
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: " + paramString);
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        v.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: " + paramString);
      }
    }
    GMTrace.o(4475087486976L, 33342);
    return paramInt;
  }
  
  public static final class a
  {
    public byte[] buf;
    public int fAB;
    public boolean fAC;
    
    public a(byte[] paramArrayOfByte, int paramInt)
    {
      GMTrace.i(4481261502464L, 33388);
      this.fAB = 0;
      this.fAC = false;
      this.buf = paramArrayOfByte;
      this.fAB = paramInt;
      this.fAC = false;
      GMTrace.o(4481261502464L, 33388);
    }
    
    public a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    {
      GMTrace.i(18682570866688L, 139196);
      this.fAB = 0;
      this.fAC = false;
      this.buf = paramArrayOfByte;
      this.fAB = paramInt;
      this.fAC = paramBoolean;
      GMTrace.o(18682570866688L, 139196);
    }
  }
  
  public static final class b
  {
    private static boolean fAD;
    private static boolean fAE;
    
    static
    {
      GMTrace.i(4484885381120L, 33415);
      fAD = false;
      fAE = false;
      int i = l.rl();
      v.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", new Object[] { Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(i) });
      if ((!bf.mA(Build.CPU_ABI)) && (!Build.CPU_ABI.contains("armeabi")) && (!bf.mA(Build.CPU_ABI2)) && (!Build.CPU_ABI2.contains("armeabi")))
      {
        v.i("MicroMsg.RecorderUtil", "don't contains armeabi");
        k.b("wechatvoicesilk_v5", g.class.getClassLoader());
        fAD = true;
        fAE = false;
      }
      for (;;)
      {
        v.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", new Object[] { Boolean.valueOf(fAD), Boolean.valueOf(fAE) });
        GMTrace.o(4484885381120L, 33415);
        return;
        if ((i & 0x400) != 0)
        {
          try
          {
            k.b("wechatvoicesilk_v7a", g.class.getClassLoader());
            fAD = true;
            fAE = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            v.e("MicroMsg.RecorderUtil", "load library failed!");
            fAD = false;
            fAE = false;
          }
        }
        else if ((i & 0x200) != 0)
        {
          k.b("wechatvoicesilk", g.class.getClassLoader());
          fAD = true;
          fAE = true;
        }
        else
        {
          k.b("wechatvoicesilk_v5", g.class.getClassLoader());
          fAD = true;
          fAE = false;
        }
      }
    }
    
    public b()
    {
      GMTrace.i(4484616945664L, 33413);
      GMTrace.o(4484616945664L, 33413);
    }
    
    public static boolean pk()
    {
      GMTrace.i(4484751163392L, 33414);
      boolean bool = fAE;
      GMTrace.o(4484751163392L, 33414);
      return bool;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/c/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */