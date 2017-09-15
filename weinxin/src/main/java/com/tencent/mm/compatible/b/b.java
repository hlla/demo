package com.tencent.mm.compatible.b;

import com.tencent.gmtrace.GMTrace;

public final class b
{
  public static enum a
  {
    static
    {
      GMTrace.i(13815567613952L, 102934);
      gMY = new a("PCM", 0);
      gMZ = new a("AMR", 1);
      gNa = new a("SILK", 2);
      gNb = new a("SPEEX", 3);
      gNc = new a("UNKNOWN", 4);
      gNd = new a[] { gMY, gMZ, gNa, gNb, gNc };
      GMTrace.o(13815567613952L, 102934);
    }
    
    private a()
    {
      GMTrace.i(13815433396224L, 102933);
      GMTrace.o(13815433396224L, 102933);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */