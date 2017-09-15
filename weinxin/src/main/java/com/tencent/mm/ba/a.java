package com.tencent.mm.ba;

import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.f;

public final class a
{
  public static int bCc()
  {
    GMTrace.i(4088674648064L, 30463);
    if (Build.VERSION.SDK_INT < 19)
    {
      i = a.f.bhS;
      GMTrace.o(4088674648064L, 30463);
      return i;
    }
    int i = a.f.bhT;
    GMTrace.o(4088674648064L, 30463);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ba/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */