package com.tencent.mm.plugin.l;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ap.t;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.u.l;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends l
  implements b
{
  private static a kEj;
  
  private a()
  {
    super(t.class);
    GMTrace.i(14601412411392L, 108789);
    GMTrace.o(14601412411392L, 108789);
  }
  
  public static a akE()
  {
    try
    {
      GMTrace.i(14601546629120L, 108790);
      if (kEj == null) {
        kEj = new a();
      }
      a locala = kEj;
      GMTrace.o(14601546629120L, 108790);
      return locala;
    }
    finally {}
  }
  
  public static String xl()
  {
    GMTrace.i(14601815064576L, 108792);
    Object localObject = new StringBuilder();
    h.vJ();
    localObject = h.vI().gXV + "package/";
    GMTrace.o(14601815064576L, 108792);
    return (String)localObject;
  }
  
  public final List<String> collectStoragePaths()
  {
    GMTrace.i(14601680846848L, 108791);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "package/" });
    GMTrace.o(14601680846848L, 108791);
    return localLinkedList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */