package com.tencent.mm.x;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class m
{
  public static List<String> hrw;
  public static int hrx;
  private static a hry;
  
  static
  {
    GMTrace.i(386681274368L, 2881);
    hrw = null;
    hrx = 0;
    hry = new a(new b());
    GMTrace.o(386681274368L, 2881);
  }
  
  public static void Bw()
  {
    GMTrace.i(386010185728L, 2876);
    hrx = 0;
    hry.KI();
    GMTrace.o(386010185728L, 2876);
  }
  
  public static void g(Runnable paramRunnable)
  {
    GMTrace.i(385875968000L, 2875);
    if (!h.vG().uV())
    {
      GMTrace.o(385875968000L, 2875);
      return;
    }
    Object localObject = n.Bm();
    ArrayList localArrayList = new ArrayList();
    localObject = ((i)localObject).hnp.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(0));
    }
    ((Cursor)localObject).close();
    hrw = localArrayList;
    if (localArrayList.size() <= 0)
    {
      GMTrace.o(385875968000L, 2875);
      return;
    }
    hry.hrz.hrA = paramRunnable;
    hry.v(10L, 10L);
    GMTrace.o(385875968000L, 2875);
  }
  
  static final class a
    extends ai
  {
    final m.b hrz;
    
    public a(m.b paramb)
    {
      super(true);
      GMTrace.i(374199025664L, 2788);
      this.hrz = paramb;
      GMTrace.o(374199025664L, 2788);
    }
  }
  
  static final class b
    implements ai.a
  {
    Runnable hrA;
    
    b()
    {
      GMTrace.i(382923177984L, 2853);
      GMTrace.o(382923177984L, 2853);
    }
    
    public final boolean oQ()
    {
      GMTrace.i(383057395712L, 2854);
      int j = m.hrw.size();
      v.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:" + j);
      if ((j <= 2000) || (m.hrx >= 300))
      {
        if (this.hrA != null) {
          this.hrA.run();
        }
        m.hrx = 0;
        GMTrace.o(383057395712L, 2854);
        return false;
      }
      long l = h.vI().gXW.cs(Thread.currentThread().getId());
      int i = j - 1;
      while (i >= j - 30)
      {
        m.hrx += 1;
        String str = (String)m.hrw.get(i);
        m.hrw.remove(i);
        n.Bl();
        d.s(str, false);
        n.Bl();
        d.s(str, true);
        n.Bm().ht(str);
        i -= 1;
      }
      h.vI().gXW.aD(l);
      GMTrace.o(383057395712L, 2854);
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */