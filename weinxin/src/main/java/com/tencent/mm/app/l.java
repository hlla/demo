package com.tencent.mm.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bn;
import com.tencent.mm.u.d.a.4;
import com.tencent.mm.u.d.b;
import com.tencent.mm.u.d.b.1;
import com.tencent.mm.u.d.c;
import com.tencent.mm.u.d.c.1;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.ui.i;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class l
{
  public static l fwI;
  public boolean fwJ;
  public ad fwK;
  
  public l()
  {
    GMTrace.i(12962211299328L, 96576);
    this.fwK = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(13042876153856L, 97177);
        super.handleMessage(paramAnonymousMessage);
        Object localObject3;
        if (paramAnonymousMessage.what == 63537)
        {
          if (!l.this.fwJ)
          {
            paramAnonymousMessage = LauncherUI.bPy();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.uQa))
            {
              paramAnonymousMessage.uPX.SC("tab_main");
              Object localObject1 = paramAnonymousMessage.uPX;
              if (((HomeUI)localObject1).uOf)
              {
                ((HomeUI)localObject1).uOl = true;
                ((HomeUI)localObject1).uOF.setBackgroundDrawable(null);
                localObject1 = ((HomeUI)localObject1).uOF;
                ((VoiceSearchLayout)localObject1).sJR.setBackgroundDrawable(null);
                ((VoiceSearchLayout)localObject1).sJV.setBackgroundDrawable(null);
                ((VoiceSearchLayout)localObject1).sJW = null;
              }
              for (;;)
              {
                try
                {
                  localObject1 = aa.getContext().getResources();
                  if (localObject1 != null) {}
                }
                catch (Exception localException1)
                {
                  v.printErrStackTrace("MicroMsg.ActivityResourceRecycler", localException1, "", new Object[0]);
                  continue;
                  localObject3 = localException1.getClass().getDeclaredField("mColorStateListCache");
                  ((Field)localObject3).setAccessible(true);
                  Object localObject2 = ((Field)localObject3).get(localException1);
                  if ((localObject2 instanceof SparseArray))
                  {
                    ((SparseArray)localObject2).clear();
                    continue;
                  }
                }
                try
                {
                  localObject1 = aa.getContext().getResources();
                  if (localObject1 != null) {
                    break;
                  }
                }
                catch (Exception localException2)
                {
                  v.printErrStackTrace("MicroMsg.ActivityResourceRecycler", localException2, "", new Object[0]);
                  continue;
                  ((LongSparseArray)localException2).clear();
                  continue;
                  localObject3 = localException2.getClass().getDeclaredField("mColorDrawableCache");
                  ((Field)localObject3).setAccessible(true);
                  ((LongSparseArray)((Field)localObject3).get(localException2)).clear();
                  localObject3 = localException2.getClass().getDeclaredField("sPreloadedColorDrawables");
                  ((Field)localObject3).setAccessible(true);
                  ((LongSparseArray)((Field)localObject3).get(localException2)).clear();
                  continue;
                }
                try
                {
                  if (Build.VERSION.SDK_INT >= 16)
                  {
                    localObject1 = aa.getContext().getResources();
                    if (localObject1 != null) {
                      break label326;
                    }
                  }
                }
                catch (Exception localException3)
                {
                  v.printErrStackTrace("MicroMsg.ActivityResourceRecycler", localException3, "", new Object[0]);
                  continue;
                }
                localObject1 = m.pOY;
                if (localObject1 != null) {
                  ((e)localObject1).bdp();
                }
                paramAnonymousMessage = paramAnonymousMessage.uPX.uPl.values().iterator();
                if (!paramAnonymousMessage.hasNext()) {
                  break label397;
                }
                localObject1 = (Fragment)paramAnonymousMessage.next();
                if (!(localObject1 instanceof j))
                {
                  ((i)localObject1).bOk();
                  continue;
                  localObject3 = localObject1.getClass().getDeclaredField("mDrawableCache");
                  ((Field)localObject3).setAccessible(true);
                  ((LongSparseArray)((Field)localObject3).get(localObject1)).clear();
                }
              }
            }
            label326:
            label397:
            System.gc();
            GMTrace.o(13042876153856L, 97177);
          }
        }
        else if (paramAnonymousMessage.what == 62537)
        {
          if (l.this.fwJ)
          {
            GMTrace.o(13042876153856L, 97177);
            return;
          }
          paramAnonymousMessage = LauncherUI.bPy();
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = paramAnonymousMessage.uPX;
            if (paramAnonymousMessage.uPl.containsKey(Integer.valueOf(0))) {
              ((i)paramAnonymousMessage.uPl.get(Integer.valueOf(0))).bOk();
            }
          }
          if (h.vG().uV())
          {
            paramAnonymousMessage = ap.yR().gs("plugin.emoji");
            if (paramAnonymousMessage != null) {
              paramAnonymousMessage.eD(0);
            }
            if ((n)ap.yR().gs(n.class.getName()) != null) {
              n.GZ();
            }
            paramAnonymousMessage = b.AG();
            com.tencent.mm.u.d.a locala = com.tencent.mm.u.d.a.AC();
            localObject3 = c.AI();
            ap.vL().D(new b.1(paramAnonymousMessage));
            ap.vL().D(new a.4(locala));
            ((c)localObject3).a(paramAnonymousMessage);
            ((c)localObject3).a(locala);
            ap.vL().D(new c.1((c)localObject3));
          }
          System.gc();
        }
        GMTrace.o(13042876153856L, 97177);
      }
    };
    GMTrace.o(12962211299328L, 96576);
  }
  
  public static l os()
  {
    GMTrace.i(12962345517056L, 96577);
    if (fwI == null) {
      fwI = new l();
    }
    l locall = fwI;
    GMTrace.o(12962345517056L, 96577);
    return locall;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */