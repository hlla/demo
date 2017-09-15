package com.tencent.mm.modelvoice;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.x;

public final class n
{
  public String hZN;
  public boolean hZO;
  public long time;
  
  public n(String paramString)
  {
    GMTrace.i(551366426624L, 4108);
    String str = paramString;
    for (;;)
    {
      try
      {
        if (paramString.endsWith("\n")) {
          str = paramString.substring(0, paramString.length() - 1);
        }
        paramString = str.split(":");
        if ((paramString.length == 4) && (x.eO(paramString[0])))
        {
          i = 1;
          if (paramString.length > i) {
            this.hZN = paramString[i];
          }
          if (paramString.length > i + 1) {
            this.time = bf.getLong(paramString[(i + 1)], 0L);
          }
          if (paramString.length > i + 2) {
            this.hZO = paramString[(i + 2)].equals("1");
          }
          GMTrace.o(551366426624L, 4108);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (this.hZN == null) {
          this.hZN = "";
        }
        this.hZO = false;
        this.time = 0L;
        v.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
        GMTrace.o(551366426624L, 4108);
        return;
      }
      int i = 0;
    }
  }
  
  public static String b(String paramString, long paramLong, boolean paramBoolean)
  {
    GMTrace.i(551232208896L, 4107);
    paramString = new StringBuilder().append(paramString).append(":").append(paramLong).append(":");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString = i + "\n";
      GMTrace.o(551232208896L, 4107);
      return paramString;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */