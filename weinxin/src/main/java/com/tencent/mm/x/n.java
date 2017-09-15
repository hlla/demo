package com.tencent.mm.x;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import com.tencent.mm.u.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class n
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  private i hrB;
  private d hrC;
  private c hrD;
  private g hrE;
  private String hrF;
  private ai hrG;
  
  static
  {
    GMTrace.i(377957122048L, 2816);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(374467461120L, 2790);
        String[] arrayOfString = i.gUn;
        GMTrace.o(374467461120L, 2790);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(386949709824L, 2883);
        String[] arrayOfString = g.gUn;
        GMTrace.o(386949709824L, 2883);
        return arrayOfString;
      }
    });
    GMTrace.o(377957122048L, 2816);
  }
  
  public n()
  {
    GMTrace.i(376078073856L, 2802);
    this.hrG = new ai(h.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(383460048896L, 2857);
        if ((!h.vG().uV()) || (n.Bl() == null))
        {
          v.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", new Object[] { Boolean.valueOf(h.vG().uV()), n.Bl() });
          GMTrace.o(383460048896L, 2857);
          return false;
        }
        if (((Boolean)h.vI().vr().get(90113, Boolean.valueOf(false))).booleanValue())
        {
          n.BA();
          n.BB();
        }
        h.vI().vr().set(90113, Boolean.valueOf(false));
        GMTrace.o(383460048896L, 2857);
        return false;
      }
      
      public final String toString()
      {
        GMTrace.i(383594266624L, 2858);
        String str = super.toString() + "|upAssetsHandler";
        GMTrace.o(383594266624L, 2858);
        return str;
      }
    }, false);
    GMTrace.o(376078073856L, 2802);
  }
  
  public static void BA()
  {
    GMTrace.i(16086128918528L, 119851);
    for (;;)
    {
      try
      {
        Context localContext = aa.getContext();
        Iterator localIterator = d.hqK.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!d.hqK.containsKey(str)) {
            break label148;
          }
          i = ((Integer)d.hqK.get(str)).intValue();
          if (i == 0) {
            continue;
          }
          v.d("MicroMsg.SubCoreAvatar", "updateAssetsAvatar user:%s ", new Object[] { str });
          Bl().d(str, com.tencent.mm.compatible.f.a.decodeResource(localContext.getResources(), i));
          continue;
        }
        GMTrace.o(16086128918528L, 119851);
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.SubCoreAvatar", "exception:%s", new Object[] { bf.g(localException) });
        GMTrace.o(16086128918528L, 119851);
        return;
      }
      return;
      label148:
      int i = 0;
    }
  }
  
  public static boolean BB()
  {
    GMTrace.i(377688686592L, 2814);
    if (bf.b((Boolean)h.vI().vr().get(59, null), false))
    {
      GMTrace.o(377688686592L, 2814);
      return true;
    }
    Bl();
    String str = d.r(m.xL(), false);
    if ((FileOp.aO(str)) || (FileOp.aO(str + ".bm"))) {}
    for (int i = 1; i != 0; i = 0)
    {
      GMTrace.o(377688686592L, 2814);
      return true;
    }
    str = m.xL();
    if (bf.mA(str))
    {
      GMTrace.o(377688686592L, 2814);
      return false;
    }
    Bitmap localBitmap = d.b.hq(b.xb() + "user_" + com.tencent.mm.a.g.n(str.getBytes()) + ".png");
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      GMTrace.o(377688686592L, 2814);
      return false;
    }
    boolean bool = Bl().d(str, localBitmap);
    GMTrace.o(377688686592L, 2814);
    return bool;
  }
  
  public static d Bl()
  {
    GMTrace.i(376480727040L, 2805);
    h.vG().uQ();
    if (Bx().hrC == null) {
      Bx().hrC = new d();
    }
    d locald = Bx().hrC;
    GMTrace.o(376480727040L, 2805);
    return locald;
  }
  
  public static i Bm()
  {
    GMTrace.i(376346509312L, 2804);
    h.vG().uQ();
    if (Bx().hrB == null) {
      Bx().hrB = new i(h.vI().gXW);
    }
    i locali = Bx().hrB;
    GMTrace.o(376346509312L, 2804);
    return locali;
  }
  
  public static n Bx()
  {
    GMTrace.i(376212291584L, 2803);
    n localn = (n)l.o(n.class);
    GMTrace.o(376212291584L, 2803);
    return localn;
  }
  
  public static g By()
  {
    GMTrace.i(376614944768L, 2806);
    h.vG().uQ();
    if (Bx().hrE == null) {
      Bx().hrE = new g(h.vI().gXW);
    }
    g localg = Bx().hrE;
    GMTrace.o(376614944768L, 2806);
    return localg;
  }
  
  public static c Bz()
  {
    GMTrace.i(376749162496L, 2807);
    h.vG().uQ();
    if (Bx().hrD == null) {
      Bx().hrD = new c();
    }
    c localc = Bx().hrD;
    GMTrace.o(376749162496L, 2807);
    return localc;
  }
  
  static Context getContext()
  {
    GMTrace.i(377420251136L, 2812);
    Context localContext = aa.getContext();
    GMTrace.o(377420251136L, 2812);
    return localContext;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(377286033408L, 2811);
    FileOp.km(h.vI().gXV + "sfs");
    this.hrF = com.tencent.mm.plugin.g.a.ZQ();
    FileOp.a(this.hrF, null, new SFSContext.Builder().setDBDirectory(h.vI().cachePath + "sfs").setStoragePath(b.xr()).setName("avatar"));
    if (paramBoolean)
    {
      v.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
      h.vI().vr().set(90113, Boolean.valueOf(true));
    }
    try
    {
      String str = m.xL();
      d locald = Bl();
      d.s(str, false);
      d.s(str, true);
      locald.c(str, null);
      this.hrG.v(10000L, 10000L);
      GMTrace.o(377286033408L, 2811);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.SubCoreAvatar", localException, "Failed to refresh avatar.", new Object[0]);
      }
    }
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(377554468864L, 2813);
    if (this.hrF != null)
    {
      FileOp.kd(this.hrF);
      this.hrF = com.tencent.mm.plugin.g.a.ZQ();
      FileOp.a(this.hrF, null, new SFSContext.Builder().setDBDirectory(h.vI().cachePath + "sfs").setStoragePath(b.xr()).setName("avatar"));
    }
    GMTrace.o(377554468864L, 2813);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(377017597952L, 2809);
    GMTrace.o(377017597952L, 2809);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(376883380224L, 2808);
    this.hrG.KI();
    if (Bx().hrC != null) {
      d.reset();
    }
    Object localObject = Bx().hrD;
    if (localObject != null) {
      h.vd().b(123, (com.tencent.mm.y.e)localObject);
    }
    localObject = Bx().hrB;
    if (localObject != null) {
      ((i)localObject).hrn.clear();
    }
    if (this.hrF != null)
    {
      FileOp.kd(this.hrF);
      this.hrF = null;
    }
    GMTrace.o(376883380224L, 2808);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(377151815680L, 2810);
    HashMap localHashMap = gJh;
    GMTrace.o(377151815680L, 2810);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */