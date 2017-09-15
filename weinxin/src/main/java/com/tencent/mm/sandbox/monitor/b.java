package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.d;

public final class b
{
  static final class a
  {
    public String fEi;
    public final String platform;
    public String tag;
    public long timestamp;
    public boolean uob;
    public String username;
    
    public a(String paramString1, String paramString2, long paramLong, String paramString3, boolean paramBoolean)
    {
      GMTrace.i(3604819738624L, 26858);
      this.platform = (d.DEVICE_TYPE + "_" + d.sXh + "_" + Build.CPU_ABI);
      this.username = paramString1;
      this.tag = paramString2;
      this.timestamp = paramLong;
      this.fEi = paramString3;
      this.uob = false;
      this.uob = paramBoolean;
      GMTrace.o(3604819738624L, 26858);
    }
    
    public final String toString()
    {
      GMTrace.i(3604953956352L, 26859);
      String str = this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.fEi;
      GMTrace.o(3604953956352L, 26859);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/monitor/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */