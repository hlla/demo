package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  private static final boolean GT(String paramString)
  {
    GMTrace.i(1764023599104L, 13143);
    String[] arrayOfString = o.hlg;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        GMTrace.o(1764023599104L, 13143);
        return false;
      }
      i += 1;
    }
    if (o.dH(paramString))
    {
      GMTrace.o(1764023599104L, 13143);
      return false;
    }
    if (o.eV(paramString))
    {
      GMTrace.o(1764023599104L, 13143);
      return false;
    }
    GMTrace.o(1764023599104L, 13143);
    return true;
  }
  
  static final List<String> cL(List<String> paramList)
  {
    GMTrace.i(1763889381376L, 13142);
    ArrayList localArrayList = new ArrayList();
    ap.yY();
    paramList = c.wW().b(o.hkZ, paramList, true, null);
    if (paramList.moveToFirst())
    {
      int i = 0;
      do
      {
        ae localae = new ae();
        localae.b(paramList);
        int j = i;
        if (GT(localae.field_username))
        {
          localArrayList.add(localae.field_username);
          j = i + 1;
          if (j >= 4) {
            break;
          }
        }
        i = j;
      } while (paramList.moveToNext());
    }
    paramList.close();
    GMTrace.o(1763889381376L, 13142);
    return localArrayList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */