package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class aj
{
  public String fFN;
  public String hZN;
  public boolean hZO;
  public long time;
  public boolean uHA;
  public String uHB;
  
  public aj(String paramString)
  {
    GMTrace.i(1590077423616L, 11847);
    this.fFN = "-1";
    this.uHB = "";
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
      GMTrace.o(1590077423616L, 11847);
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject;
        if (paramString.endsWith("\n"))
        {
          localObject = paramString.substring(0, paramString.length() - 1);
          localObject = ((String)localObject).split(":", 6);
          if ((localObject.length == 4) && (x.eO(localObject[0])))
          {
            i = 1;
            if (localObject.length > i) {
              this.hZN = localObject[i];
            }
            if (localObject.length > i + 1) {
              this.time = bf.getLong(localObject[(i + 1)], 0L);
            }
            if (localObject.length > i + 2) {
              this.hZO = localObject[(i + 2)].equals("1");
            }
            if (localObject.length > i + 3) {
              this.fFN = localObject[(i + 3)];
            }
            if (localObject.length > i + 4) {
              this.uHB = localObject[(i + 4)].replace("*#*", ":");
            }
            if (localObject.length > i + 5) {
              this.uHA = localObject[(i + 5)].equals("1");
            }
            GMTrace.o(1590077423616L, 11847);
          }
        }
        else
        {
          this.uHB = paramString.replace(":", "*#*");
          localObject = paramString;
          continue;
        }
        int i = 0;
      }
      catch (Exception localException)
      {
        this.time = 0L;
        v.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", new Object[] { paramString, bf.g(localException) });
        GMTrace.o(1590077423616L, 11847);
        return;
      }
    }
  }
  
  public static aj RC(String paramString)
  {
    GMTrace.i(1590211641344L, 11848);
    paramString = new aj(paramString);
    GMTrace.o(1590211641344L, 11848);
    return paramString;
  }
  
  public static String a(String paramString1, long paramLong, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3)
  {
    int j = 1;
    GMTrace.i(1589808988160L, 11845);
    paramString3 = paramString3.replace(":", "*#*");
    paramString1 = new StringBuilder().append(paramString1).append(":").append(paramLong).append(":");
    if (paramBoolean1)
    {
      i = 1;
      paramString1 = paramString1.append(i).append(":").append(paramString2).append(":").append(paramString3).append(":");
      if (!paramBoolean2) {
        break label129;
      }
    }
    label129:
    for (int i = j;; i = 0)
    {
      paramString1 = i + "\n";
      GMTrace.o(1589808988160L, 11845);
      return paramString1;
      i = 0;
      break;
    }
  }
  
  public final String bLG()
  {
    int j = 1;
    GMTrace.i(1589943205888L, 11846);
    Object localObject = new StringBuilder().append(this.hZN).append(":").append(this.time).append(":");
    if (this.hZO)
    {
      i = 1;
      localObject = ((StringBuilder)localObject).append(i).append(":").append(this.fFN).append(":").append(this.uHB).append(":");
      if (!this.uHA) {
        break label126;
      }
    }
    label126:
    for (int i = j;; i = 0)
    {
      localObject = i + "\n";
      GMTrace.o(1589943205888L, 11846);
      return (String)localObject;
      i = 0;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */