package com.tencent.mm.af;

import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import java.util.HashMap;

public class a
  implements am
{
  private static HandlerThread hDF;
  private static ad hDG;
  
  static
  {
    GMTrace.i(1425526489088L, 10621);
    hDF = null;
    hDG = null;
    GMTrace.o(1425526489088L, 10621);
  }
  
  public a()
  {
    GMTrace.i(14464107675648L, 107766);
    GMTrace.o(14464107675648L, 107766);
  }
  
  public static boolean a(Runnable paramRunnable, long paramLong)
  {
    boolean bool2 = false;
    GMTrace.i(1424721182720L, 10615);
    if (paramRunnable == null)
    {
      GMTrace.o(1424721182720L, 10615);
      return false;
    }
    boolean bool1;
    if ((hDG == null) || (hDF == null))
    {
      if (hDG != null)
      {
        bool1 = true;
        if (hDF != null) {
          bool2 = true;
        }
        v.w("MicroMsg.GIF.SubCoreGIF", "check decoder thread available fail, handler[%B] thread[%B] stack[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), bf.bJP() });
        if (hDG != null) {
          hDG.removeCallbacksAndMessages(null);
        }
        if (hDF != null) {
          hDF.quit();
        }
        HandlerThread localHandlerThread = e.Qt("GIF-Decoder");
        hDF = localHandlerThread;
        localHandlerThread.start();
        hDG = new ad(hDF.getLooper());
      }
    }
    else
    {
      if (paramLong <= 0L) {
        break label178;
      }
      hDG.postDelayed(paramRunnable, paramLong);
    }
    for (;;)
    {
      GMTrace.o(1424721182720L, 10615);
      return true;
      bool1 = false;
      break;
      label178:
      hDG.post(paramRunnable);
    }
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(1425123835904L, 10618);
    if (hDG != null) {
      hDG.removeCallbacksAndMessages(null);
    }
    GMTrace.o(1425123835904L, 10618);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(1425258053632L, 10619);
    GMTrace.o(1425258053632L, 10619);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(1424989618176L, 10617);
    GMTrace.o(1424989618176L, 10617);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(1425392271360L, 10620);
    if (hDG != null) {
      hDG.removeCallbacksAndMessages(null);
    }
    GMTrace.o(1425392271360L, 10620);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(1424855400448L, 10616);
    GMTrace.o(1424855400448L, 10616);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/af/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */