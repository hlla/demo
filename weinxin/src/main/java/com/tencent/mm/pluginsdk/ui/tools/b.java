package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public static boolean Nh(String paramString)
  {
    GMTrace.i(1105148772352L, 8234);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
      GMTrace.o(1105148772352L, 8234);
      return false;
    }
    t localt = h.vI().vr();
    if (localt == null)
    {
      v.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
      GMTrace.o(1105148772352L, 8234);
      return false;
    }
    a locala = new a();
    locala.DD((String)localt.get(69121, null));
    if (!locala.qSM.contains(paramString)) {
      locala.qSM.add(paramString);
    }
    localt.set(69121, locala.bGq());
    GMTrace.o(1105148772352L, 8234);
    return true;
  }
  
  public static boolean Ni(String paramString)
  {
    GMTrace.i(1105282990080L, 8235);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
      GMTrace.o(1105282990080L, 8235);
      return false;
    }
    t localt = h.vI().vr();
    if (localt == null)
    {
      v.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
      GMTrace.o(1105282990080L, 8235);
      return false;
    }
    a locala = new a();
    locala.DD((String)localt.get(69121, null));
    if (locala.qSM.contains(paramString)) {
      locala.qSM.remove(paramString);
    }
    localt.set(69121, locala.bGq());
    GMTrace.o(1105282990080L, 8235);
    return true;
  }
  
  private static final class a
  {
    List<String> qSM;
    
    public a()
    {
      GMTrace.i(1061528010752L, 7909);
      this.qSM = new ArrayList();
      GMTrace.o(1061528010752L, 7909);
    }
    
    final void DD(String paramString)
    {
      GMTrace.i(1061796446208L, 7911);
      this.qSM = new ArrayList();
      if ((paramString == null) || (paramString.length() == 0))
      {
        GMTrace.o(1061796446208L, 7911);
        return;
      }
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        this.qSM.add(localObject);
        i += 1;
      }
      GMTrace.o(1061796446208L, 7911);
    }
    
    final String bGq()
    {
      GMTrace.i(1061662228480L, 7910);
      if ((this.qSM == null) || (this.qSM.size() == 0))
      {
        GMTrace.o(1061662228480L, 7910);
        return "";
      }
      Object localObject = new StringBuffer();
      Iterator localIterator = this.qSM.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuffer)localObject).append((String)localIterator.next());
        ((StringBuffer)localObject).append(";");
      }
      localObject = ((StringBuffer)localObject).toString();
      GMTrace.o(1061662228480L, 7910);
      return (String)localObject;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */