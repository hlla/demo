package com.tencent.mm.f;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.ui.base.g;

public final class a
{
  public String desc;
  public String fDt;
  private c gMq;
  public int showType;
  public String url;
  
  public a()
  {
    GMTrace.i(1270907666432L, 9469);
    GMTrace.o(1270907666432L, 9469);
  }
  
  public static a dn(String paramString)
  {
    GMTrace.i(1271041884160L, 9470);
    paramString = c.dp(paramString);
    if (paramString != null)
    {
      a locala = new a();
      locala.gMq = paramString;
      locala.url = paramString.url;
      locala.desc = paramString.desc;
      locala.showType = paramString.showType;
      locala.fDt = paramString.fDt;
      GMTrace.o(1271041884160L, 9470);
      return locala;
    }
    GMTrace.o(1271041884160L, 9470);
    return null;
  }
  
  public final boolean a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(1271176101888L, 9471);
    if ((this.showType == 3) || (this.showType == 4))
    {
      String str3 = this.gMq.gMC;
      String str4 = this.gMq.gMD;
      String str1 = str3;
      String str2 = str4;
      int i;
      if (bf.mA(str3))
      {
        str1 = str3;
        str2 = str4;
        if (bf.mA(str4))
        {
          if (this.showType != 3) {
            break label184;
          }
          i = a.g.dIW;
          str1 = paramContext.getString(i);
          if (this.showType != 3) {
            break label192;
          }
          i = a.g.dHI;
          label109:
          str2 = paramContext.getString(i);
        }
      }
      if ((bf.mA(str1)) || (bf.mA(str2)))
      {
        str3 = this.desc;
        str4 = this.fDt;
        if (bf.mA(str1))
        {
          label153:
          if (!bf.mA(str1)) {
            break label207;
          }
          label161:
          g.a(paramContext, str3, str4, str2, paramOnClickListener2);
        }
      }
      for (;;)
      {
        GMTrace.o(1271176101888L, 9471);
        return true;
        label184:
        i = a.g.dHL;
        break;
        label192:
        i = a.g.dGk;
        break label109;
        str2 = str1;
        break label153;
        label207:
        paramOnClickListener2 = paramOnClickListener1;
        break label161;
        g.b(paramContext, this.desc, this.fDt, str1, str2, paramOnClickListener1, paramOnClickListener2);
      }
    }
    if (this.showType == 1)
    {
      g.b(paramContext, this.desc, this.fDt, true);
      GMTrace.o(1271176101888L, 9471);
      return true;
    }
    if (this.showType == 5)
    {
      g.b(paramContext, this.desc, this.fDt, true);
      GMTrace.o(1271176101888L, 9471);
      return true;
    }
    GMTrace.o(1271176101888L, 9471);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */