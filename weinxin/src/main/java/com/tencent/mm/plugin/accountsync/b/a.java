package com.tencent.mm.plugin.accountsync.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static a irF;
  private Map<String, String> irG;
  
  static
  {
    GMTrace.i(7849455386624L, 58483);
    irF = new a();
    GMTrace.o(7849455386624L, 58483);
  }
  
  public a()
  {
    GMTrace.i(7849186951168L, 58481);
    GMTrace.o(7849186951168L, 58481);
  }
  
  public final Map<String, String> bs(Context paramContext)
  {
    GMTrace.i(7849321168896L, 58482);
    for (;;)
    {
      int i;
      try
      {
        paramContext = bf.l(paramContext.getAssets().open("config/EmailAddress.xml"));
        boolean bool = bf.mA(paramContext);
        if (bool)
        {
          GMTrace.o(7849321168896L, 58482);
          return null;
        }
        Map localMap = bg.q(paramContext, "config");
        if ((localMap == null) || (localMap.isEmpty()))
        {
          v.d("MicroMsg.EmailFormater", "values null");
          GMTrace.o(7849321168896L, 58482);
          return null;
        }
        if (this.irG == null)
        {
          this.irG = new HashMap();
          i = 0;
          Object localObject = new StringBuilder(".config.format");
          if (i == 0)
          {
            paramContext = "";
            localObject = paramContext;
            if (localMap.get(localObject) == null) {
              continue;
            }
            paramContext = (String)localObject + ".emaildomain";
            localObject = (String)localObject + ".loginpage";
            paramContext = (String)localMap.get(paramContext);
            localObject = (String)localMap.get(localObject);
            if ((bf.mA(paramContext)) || (bf.mA((String)localObject))) {
              break label308;
            }
            this.irG.put(paramContext, localObject);
            break label308;
          }
        }
        else
        {
          paramContext = this.irG;
          GMTrace.o(7849321168896L, 58482);
          return paramContext;
        }
        paramContext = Integer.valueOf(i);
        continue;
        paramContext = this.irG;
        GMTrace.o(7849321168896L, 58482);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        v.e("MicroMsg.EmailFormater", "parse email failed:[%s]", new Object[] { paramContext.getMessage() });
        GMTrace.o(7849321168896L, 58482);
        return null;
      }
      label308:
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/accountsync/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */