package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s.a.a;
import com.tencent.mm.modelvideo.s.a.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class eh
  extends ag.a
{
  private static SparseArray<String> vMA;
  private static View.OnClickListener vMB;
  public static Map<String, WeakReference<eh>> vwN;
  ImageView qhZ;
  MMPinProgressBtn qwc;
  
  static
  {
    GMTrace.i(2231101292544L, 16623);
    vMA = new SparseArray();
    vwN = new HashMap();
    vMB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2491349467136L, 18562);
        eh.a locala = (eh.a)paramAnonymousView.getTag(R.h.Kd);
        if ((locala == null) || (locala.fTa == null))
        {
          v.w("MicroMsg.ShortVideoItemHolder", "click error");
          GMTrace.o(2491349467136L, 18562);
          return;
        }
        r localr = t.lI(locala.fTa.field_imgPath);
        if (localr == null)
        {
          v.w("MicroMsg.ShortVideoItemHolder", "click %s, msg id %d, but videoinfo is null", new Object[] { locala.fTa.field_imgPath, Long.valueOf(locala.fTa.field_msgId) });
          GMTrace.o(2491349467136L, 18562);
          return;
        }
        if (locala.vwD)
        {
          i = localr.status;
          v.i("MicroMsg.ShortVideoItemHolder", "on Click, info recv status: %d", new Object[] { Integer.valueOf(i) });
          int j = (int)locala.fTa.field_msgId;
          if (i == 199)
          {
            if (locala.vMC.AP(j))
            {
              locala.vMC.vzN.vDb.onClick(paramAnonymousView);
              locala.puN.clear();
              if (locala.vMC.tD())
              {
                locala.qYm.setVisibility(0);
                locala.qYm.setImageResource(R.k.dzp);
                eh.a(paramAnonymousView.getContext(), locala.puN, locala.fTa.field_imgPath);
                locala.puN.gY(false);
                locala.vMC.AQ(j);
                GMTrace.o(2491349467136L, 18562);
              }
            }
            else
            {
              locala.qYm.setVisibility(8);
              eh.a(locala.puN.bbN(), locala.puN, locala.fTa.field_imgPath);
              o.KW();
              paramAnonymousView = s.lw(locala.fTa.field_imgPath);
              locala.puN.gY(true);
              locala.puN.ak(paramAnonymousView, false);
              locala.vMC.AQ(j);
              a.a(a.a.vva, locala.fTa);
            }
            GMTrace.o(2491349467136L, 18562);
            return;
          }
          if ((i != 112) && (i != 196)) {
            if (i == 113)
            {
              t.lE(localr.getFileName());
              locala.puN.gY(true);
              if (!locala.vMC.AP(j))
              {
                locala.vMC.AQ(j);
                GMTrace.o(2491349467136L, 18562);
              }
            }
            else if (i == 198)
            {
              t.lG(localr.getFileName());
              locala.puN.gY(true);
              if (!locala.vMC.AP(j))
              {
                locala.vMC.AQ(j);
                GMTrace.o(2491349467136L, 18562);
              }
            }
            else
            {
              t.lE(locala.fTa.field_imgPath);
              locala.puN.gY(true);
              if (!locala.vMC.AP(j)) {
                locala.vMC.AQ(j);
              }
            }
          }
          GMTrace.o(2491349467136L, 18562);
          return;
        }
        int i = localr.status;
        v.i("MicroMsg.ShortVideoItemHolder", "info send status: %d", new Object[] { Integer.valueOf(i) });
        if ((i == 104) || (i == 103))
        {
          locala.vMC.vzN.vDb.onClick(paramAnonymousView);
          GMTrace.o(2491349467136L, 18562);
          return;
        }
        if (i == 105)
        {
          t.lD(localr.getFileName());
          GMTrace.o(2491349467136L, 18562);
          return;
        }
        if (i == 198)
        {
          t.lH(localr.getFileName());
          GMTrace.o(2491349467136L, 18562);
          return;
        }
        if (i == 106)
        {
          locala.vMC.vzN.vDb.onClick(paramAnonymousView);
          GMTrace.o(2491349467136L, 18562);
          return;
        }
        if (i != 196)
        {
          i = (int)locala.fTa.field_msgId;
          if (locala.vMC.AP(i))
          {
            locala.puN.clear();
            locala.vMC.vzN.vDb.onClick(paramAnonymousView);
            if (locala.vMC.tD())
            {
              locala.qYm.setVisibility(0);
              locala.qYm.setImageResource(R.k.dzp);
              eh.a(paramAnonymousView.getContext(), locala.puN, locala.fTa.field_imgPath);
              locala.puN.gY(false);
              locala.vMC.AQ(i);
              GMTrace.o(2491349467136L, 18562);
            }
          }
          else
          {
            locala.qYm.setVisibility(8);
            eh.a(locala.puN.bbN(), locala.puN, locala.fTa.field_imgPath);
            o.KW();
            paramAnonymousView = s.lw(locala.fTa.field_imgPath);
            locala.puN.gY(true);
            locala.puN.ak(paramAnonymousView, false);
            locala.vMC.AQ(i);
            a.a(a.a.vva, locala.fTa);
          }
        }
        GMTrace.o(2491349467136L, 18562);
      }
    };
    GMTrace.o(2231101292544L, 16623);
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.sight.decode.a.a parama, String paramString)
  {
    GMTrace.i(16015530393600L, 119325);
    ap.yY();
    if (!c.isSDCardAvailable())
    {
      parama.bbL();
      GMTrace.o(16015530393600L, 119325);
      return;
    }
    o.KW();
    paramString = s.lx(paramString);
    paramContext = n.GT().a(paramString, com.tencent.mm.bg.a.getDensity(paramContext), paramContext, -1);
    parama.bbK();
    parama.y(paramContext);
    GMTrace.o(16015530393600L, 119325);
  }
  
  public static boolean b(s.a.a parama)
  {
    GMTrace.i(2230698639360L, 16620);
    if (parama.ial != s.a.b.iap)
    {
      GMTrace.o(2230698639360L, 16620);
      return false;
    }
    r localr = t.lI(parama.fyw);
    if (localr == null)
    {
      v.w("MicroMsg.ShortVideoItemHolder", "update status, filename %s, videoInfo not found", new Object[] { parama.fyw });
      GMTrace.o(2230698639360L, 16620);
      return false;
    }
    if ((localr.status != 112) && (localr.status != 104) && (localr.status != 103))
    {
      GMTrace.o(2230698639360L, 16620);
      return false;
    }
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2156610453504L, 16068);
        Object localObject = (WeakReference)eh.vwN.get(this.vDT.getFileName());
        if (localObject == null)
        {
          v.w("MicroMsg.ShortVideoItemHolder", "update status, filename %s, holder not found", new Object[] { this.vDT.getFileName() });
          GMTrace.o(2156610453504L, 16068);
          return;
        }
        localObject = (eh)((WeakReference)localObject).get();
        if (localObject == null)
        {
          v.w("MicroMsg.ShortVideoItemHolder", "update status, filename %s, holder gc!", new Object[] { this.vDT.getFileName() });
          GMTrace.o(2156610453504L, 16068);
          return;
        }
        ((eh)localObject).qwc.setVisibility(0);
        ((eh)localObject).qhZ.setVisibility(8);
        if (this.vDT.status == 112)
        {
          ((eh)localObject).qwc.setProgress(t.f(this.vDT));
          GMTrace.o(2156610453504L, 16068);
          return;
        }
        ((eh)localObject).qwc.setProgress(t.g(this.vDT));
        GMTrace.o(2156610453504L, 16068);
      }
    });
    GMTrace.o(2230698639360L, 16620);
    return true;
  }
  
  private static final class a
  {
    au fTa;
    com.tencent.mm.plugin.sight.decode.a.a puN;
    ImageView qYm;
    En_5b8fbb1e.a vMC;
    boolean vwD;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */