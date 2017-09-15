package com.tencent.mm.plugin.g;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.k;
import com.tencent.mm.u.l;
import com.tencent.mm.x.n;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends l
  implements b
{
  private static a jzi;
  
  private a()
  {
    super(n.class);
    GMTrace.i(14604230983680L, 108810);
    GMTrace.o(14604230983680L, 108810);
  }
  
  public static a ZP()
  {
    try
    {
      GMTrace.i(14604365201408L, 108811);
      if (jzi == null) {
        jzi = new a();
      }
      a locala = jzi;
      GMTrace.o(14604365201408L, 108811);
      return locala;
    }
    finally {}
  }
  
  public static String ZQ()
  {
    GMTrace.i(14604633636864L, 108813);
    String str = h.vI().gXV + "avatar/";
    GMTrace.o(14604633636864L, 108813);
    return str;
  }
  
  public final List<String> collectStoragePaths()
  {
    GMTrace.i(14604499419136L, 108812);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "avatar/" });
    GMTrace.o(14604499419136L, 108812);
    return localLinkedList;
  }
  
  public final void eg(String paramString)
  {
    GMTrace.i(14604767854592L, 108814);
    super.eg(paramString);
    if (f.rZ())
    {
      h.vJ();
      if (h.vI().gXU.equals(com.tencent.mm.compatible.util.e.hgk))
      {
        h.vJ();
        com.tencent.mm.sdk.f.e.post(new k(h.vI().cachePath, paramString, "avatar/"), "Account_moveDataFiles_" + "avatar/");
      }
    }
    GMTrace.o(14604767854592L, 108814);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */