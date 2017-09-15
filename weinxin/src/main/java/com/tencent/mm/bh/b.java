package com.tencent.mm.bh;

import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.InputStream;

public final class b
{
  public byte[] jPm;
  public SparseArray<a> unG;
  
  private b(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    GMTrace.i(368159227904L, 2743);
    this.unG = paramSparseArray;
    this.jPm = paramArrayOfByte;
    GMTrace.o(368159227904L, 2743);
  }
  
  public static b a(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    GMTrace.i(368293445632L, 2744);
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        v.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new b(paramSparseArray, arrayOfByte);
      GMTrace.o(368293445632L, 2744);
      return paramSparseArray;
    }
    catch (IOException paramSparseArray)
    {
      v.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", new Object[] { bf.g(paramSparseArray) });
      GMTrace.o(368293445632L, 2744);
    }
    return null;
  }
  
  public final String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    GMTrace.i(368427663360L, 2745);
    try
    {
      j = this.unG.indexOfKey(paramInt1);
      if (j < 0)
      {
        GMTrace.o(368427663360L, 2745);
        return null;
      }
      localObject1 = (a)this.unG.valueAt(j);
      k = ((a)localObject1).unI.length;
      paramInt1 = 0;
      i = 0;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        int j;
        int k;
        int i;
        Object localObject1 = null;
        v.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", new Object[] { bf.g(paramVarArgs) });
        Object localObject2 = localObject1;
        continue;
        paramInt1 += 1;
      }
    }
    if (paramInt1 < k)
    {
      if (localObject1.unI[paramInt1] == paramInt2) {
        i = paramInt1;
      }
    }
    else
    {
      if (j <= this.unG.size() - 1) {
        if (i >= k - 1)
        {
          localObject2 = (a)this.unG.valueAt(j + 1);
          localObject1 = new String(this.jPm, localObject1.unJ[i], localObject2.unJ[0] - localObject1.unJ[i]);
        }
      }
      for (;;)
      {
        try
        {
          if (!bf.mA((String)localObject1))
          {
            localObject2 = localObject1;
            if (paramVarArgs == null) {}
          }
          else
          {
            localObject2 = String.format((String)localObject1, paramVarArgs);
          }
          GMTrace.o(368427663360L, 2745);
          return (String)localObject2;
        }
        catch (Exception paramVarArgs)
        {
          continue;
        }
        localObject1 = new String(this.jPm, localObject1.unJ[i], localObject1.unJ[(i + 1)] - localObject1.unJ[i]);
        continue;
        if (i >= k - 1) {
          localObject1 = new String(this.jPm, localObject1.unJ[i], this.jPm.length - localObject1.unJ[i]);
        } else {
          localObject1 = new String(this.jPm, localObject1.unJ[i], localObject1.unJ[(i + 1)] - localObject1.unJ[i]);
        }
      }
    }
  }
  
  static final class a
  {
    public final int unH;
    public final int[] unI;
    public final int[] unJ;
    
    public a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      GMTrace.i(372051542016L, 2772);
      this.unH = paramInt;
      this.unI = paramArrayOfInt1;
      this.unJ = paramArrayOfInt2;
      GMTrace.o(372051542016L, 2772);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bh/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */