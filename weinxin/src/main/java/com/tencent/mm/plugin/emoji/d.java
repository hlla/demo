package com.tencent.mm.plugin.emoji;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.af.a;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.u.l;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends l
  implements b
{
  private static d kFA;
  
  private d()
  {
    super(a.class);
    GMTrace.i(16406909288448L, 122241);
    GMTrace.o(16406909288448L, 122241);
  }
  
  public static d akN()
  {
    try
    {
      GMTrace.i(16407043506176L, 122242);
      if (kFA == null) {
        kFA = new d();
      }
      d locald = kFA;
      GMTrace.o(16407043506176L, 122242);
      return locald;
    }
    finally {}
  }
  
  public static String akO()
  {
    GMTrace.i(16407311941632L, 122244);
    String str = h.vI().gXV + "emoji/";
    GMTrace.o(16407311941632L, 122244);
    return str;
  }
  
  public final List<String> collectStoragePaths()
  {
    GMTrace.i(16407177723904L, 122243);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "emoji/" });
    GMTrace.o(16407177723904L, 122243);
    return localLinkedList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/emoji/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */