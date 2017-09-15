package com.tencent.mm.bh;

import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.InputStream;

public final class d
{
  public byte[] jPm;
  public SparseArray<a> unL;
  
  private d(SparseArray<a> paramSparseArray, byte[] paramArrayOfByte)
  {
    GMTrace.i(368561881088L, 2746);
    this.unL = paramSparseArray;
    this.jPm = paramArrayOfByte;
    GMTrace.o(368561881088L, 2746);
  }
  
  public static d b(SparseArray<a> paramSparseArray, InputStream paramInputStream, int paramInt)
  {
    GMTrace.i(368696098816L, 2747);
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        v.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
      }
      paramSparseArray = new d(paramSparseArray, arrayOfByte);
      GMTrace.o(368696098816L, 2747);
      return paramSparseArray;
    }
    catch (IOException paramSparseArray)
    {
      v.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", new Object[] { bf.g(paramSparseArray) });
      GMTrace.o(368696098816L, 2747);
    }
    return null;
  }
  
  static final class a
  {
    public final int roM;
    public final int[] unM;
    
    public a(int paramInt, int[] paramArrayOfInt)
    {
      GMTrace.i(371917324288L, 2771);
      this.roM = paramInt;
      this.unM = paramArrayOfInt;
      GMTrace.o(371917324288L, 2771);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bh/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */