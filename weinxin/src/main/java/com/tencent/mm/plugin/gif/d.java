package com.tencent.mm.plugin.gif;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class d
{
  public final int[] mHN;
  
  public d(String paramString)
  {
    GMTrace.i(12893626040320L, 96065);
    this.mHN = new int[6];
    try
    {
      MMGIFJNI.recycle(MMGIFJNI.openByFilePath(paramString, this.mHN));
      v.i("MMGIFInfo", "width:%d height:%d", new Object[] { Integer.valueOf(this.mHN[0]), Integer.valueOf(this.mHN[1]) });
      GMTrace.o(12893626040320L, 96065);
      return;
    }
    catch (MMGIFException paramString)
    {
      v.e("MMGIFInfo", bf.g(paramString));
      GMTrace.o(12893626040320L, 96065);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gif/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */