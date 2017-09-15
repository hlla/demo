package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ht;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;

public final class b
  implements com.tencent.mm.pluginsdk.b.a
{
  static
  {
    GMTrace.i(418759311360L, 3120);
    com.tencent.mm.pluginsdk.b.b.a(new b(), new String[] { "//hotpatch" });
    GMTrace.o(418759311360L, 3120);
  }
  
  public b()
  {
    GMTrace.i(418356658176L, 3117);
    GMTrace.o(418356658176L, 3117);
  }
  
  public static void init()
  {
    GMTrace.i(418490875904L, 3118);
    GMTrace.o(418490875904L, 3118);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    GMTrace.i(418625093632L, 3119);
    if (v.getLogLevel() > 1)
    {
      GMTrace.o(418625093632L, 3119);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      GMTrace.o(418625093632L, 3119);
      return true;
    }
    paramContext = paramArrayOfString[1];
    int i = -1;
    switch (paramContext.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        GMTrace.o(418625093632L, 3119);
        return true;
        if (paramContext.equals("apply"))
        {
          i = 0;
          continue;
          if (paramContext.equals("info"))
          {
            i = 1;
            continue;
            if (paramContext.equals("clear"))
            {
              i = 2;
              continue;
              if (paramContext.equals("check")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    if (paramArrayOfString.length < 3) {}
    for (paramContext = "/data/local/tmp/test.apk";; paramContext = paramArrayOfString[2])
    {
      v.d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", new Object[] { paramContext });
      paramArrayOfString = new ht();
      paramArrayOfString.fNe.fNj = paramContext;
      com.tencent.mm.sdk.b.a.uql.m(paramArrayOfString);
      GMTrace.o(418625093632L, 3119);
      return true;
    }
    v.d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", new Object[] { getClass().getClassLoader() });
    GMTrace.o(418625093632L, 3119);
    return true;
    v.d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
    paramContext = new ht();
    paramContext.fNe.fEx = 1;
    com.tencent.mm.sdk.b.a.uql.m(paramContext);
    GMTrace.o(418625093632L, 3119);
    return true;
    if (paramArrayOfString.length < 3)
    {
      GMTrace.o(418625093632L, 3119);
      return true;
    }
    paramArrayOfString = paramArrayOfString[2];
    paramContext = paramArrayOfString;
    if (!paramArrayOfString.startsWith("/")) {
      paramContext = "/data/data/com.tencent.mm/app_dex/" + paramArrayOfString;
    }
    v.i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", new Object[] { paramContext });
    v.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    v.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    v.i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", new Object[] { Boolean.valueOf(SharePatchFileUtil.VQ(paramContext)) });
    v.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
    GMTrace.o(418625093632L, 3119);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/console/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */