package com.tencent.mm.bh;

import android.util.SparseIntArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class f
{
  SparseIntArray unW;
  byte[] unX;
  
  private f(SparseIntArray paramSparseIntArray, byte[] paramArrayOfByte)
  {
    GMTrace.i(367756574720L, 2740);
    this.unW = paramSparseIntArray;
    this.unX = paramArrayOfByte;
    GMTrace.o(367756574720L, 2740);
  }
  
  public static f a(SparseIntArray paramSparseIntArray, InputStream paramInputStream, int paramInt)
  {
    GMTrace.i(367890792448L, 2741);
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      if (paramInputStream.read(arrayOfByte, 0, arrayOfByte.length) != arrayOfByte.length) {
        v.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
      }
      paramSparseIntArray = new f(paramSparseIntArray, arrayOfByte);
      GMTrace.o(367890792448L, 2741);
      return paramSparseIntArray;
    }
    catch (IOException paramSparseIntArray)
    {
      v.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", new Object[] { bf.g(paramSparseIntArray) });
      GMTrace.o(367890792448L, 2741);
    }
    return null;
  }
  
  public final String getString(int paramInt)
  {
    GMTrace.i(368025010176L, 2742);
    for (;;)
    {
      try
      {
        paramInt = this.unW.indexOfKey(paramInt);
        if (paramInt < 0)
        {
          GMTrace.o(368025010176L, 2742);
          return null;
        }
        i = this.unW.valueAt(paramInt);
        if (paramInt >= this.unW.size() - 1) {
          continue;
        }
        paramInt = this.unW.valueAt(paramInt + 1) - i;
        str = new String(this.unX, i, paramInt, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        int i;
        String str;
        v.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bf.g(localUnsupportedEncodingException) });
        Object localObject1 = null;
        continue;
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", new Object[] { bf.g(localException) });
        Object localObject2 = null;
        continue;
      }
      GMTrace.o(368025010176L, 2742);
      return str;
      paramInt = this.unX.length;
      paramInt -= i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bh/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */