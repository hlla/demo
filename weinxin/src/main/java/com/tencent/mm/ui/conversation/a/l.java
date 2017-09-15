package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.m.5;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.s.a.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class l
  extends b
  implements s.a
{
  public ViewGroup pu;
  public Map<String, Long> wdn;
  public Map<Long, b> wdo;
  
  public l(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(14510547009536L, 108112);
    this.wdn = new HashMap();
    this.wdo = new HashMap();
    o.KW().a(this, Looper.getMainLooper());
    this.pu = ((ViewGroup)this.view);
    GMTrace.o(14510547009536L, 108112);
  }
  
  private void WM()
  {
    GMTrace.i(14510949662720L, 108115);
    v.i("MicroMsg.MassSightBanner", "call update status");
    a locala = new a();
    locala.wdp = new WeakReference(this);
    ap.vL().D(locala);
    GMTrace.o(14510949662720L, 108115);
  }
  
  public final void a(s.a.a parama)
  {
    GMTrace.i(14511083880448L, 108116);
    parama = parama.fyw;
    Long localLong = (Long)this.wdn.get(parama);
    if (localLong == null)
    {
      v.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[] { parama });
      if (bf.ap(parama, "").startsWith("DELETE_")) {
        WM();
      }
      GMTrace.o(14511083880448L, 108116);
      return;
    }
    b localb = (b)this.wdo.get(localLong);
    if (localb == null)
    {
      v.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[] { localLong });
      GMTrace.o(14511083880448L, 108116);
      return;
    }
    r localr = t.lI(parama);
    if (localr == null)
    {
      v.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", new Object[] { parama, localLong });
      GMTrace.o(14511083880448L, 108116);
      return;
    }
    if (localr.status == 199)
    {
      v.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", new Object[] { parama, localLong });
      WM();
      GMTrace.o(14511083880448L, 108116);
      return;
    }
    c.a(localb, localr);
    GMTrace.o(14511083880448L, 108116);
  }
  
  public final void destroy()
  {
    GMTrace.i(14510815444992L, 108114);
    o.KW().a(this);
    GMTrace.o(14510815444992L, 108114);
  }
  
  public final int getLayoutId()
  {
    GMTrace.i(14510681227264L, 108113);
    int i = R.i.die;
    GMTrace.o(14510681227264L, 108113);
    return i;
  }
  
  private static final class a
    implements Runnable
  {
    WeakReference<l> wdp;
    
    public a()
    {
      GMTrace.i(14497125236736L, 108012);
      GMTrace.o(14497125236736L, 108012);
    }
    
    public final void run()
    {
      GMTrace.i(14497259454464L, 108013);
      List localList1 = o.KW().Ln();
      List localList2 = o.KW().Lo();
      Object localObject = (l)this.wdp.get();
      if (localObject == null)
      {
        v.w("MicroMsg.MassSightBanner", "try to load date, but banner ref is null");
        GMTrace.o(14497259454464L, 108013);
        return;
      }
      v.i("MicroMsg.MassSightBanner", "ViewCount %d, unfinish size %d, fail size %d", new Object[] { Integer.valueOf(((l)localObject).pu.getChildCount()), Integer.valueOf(localList1.size()), Integer.valueOf(localList2.size()) });
      if ((((l)localObject).pu.getChildCount() == 0) && (localList1.isEmpty()) && (localList2.isEmpty()))
      {
        GMTrace.o(14497259454464L, 108013);
        return;
      }
      localObject = new l.c();
      ((l.c)localObject).wdp = new WeakReference(this.wdp.get());
      ((l.c)localObject).wdy = localList1;
      ((l.c)localObject).wdz = localList2;
      ae.v((Runnable)localObject);
      GMTrace.o(14497259454464L, 108013);
    }
  }
  
  private static final class b
  {
    ProgressBar kWs;
    long wdq;
    boolean wdr;
    View wds;
    com.tencent.mm.plugin.sight.decode.a.a wdt;
    ImageView wdu;
    TextView wdv;
    ImageButton wdw;
    
    public b()
    {
      GMTrace.i(14505983606784L, 108078);
      this.wdq = 0L;
      this.wdr = false;
      this.wds = null;
      this.wdt = null;
      this.wdu = null;
      this.wdv = null;
      this.kWs = null;
      this.wdw = null;
      GMTrace.o(14505983606784L, 108078);
    }
  }
  
  private static final class c
    implements Runnable
  {
    WeakReference<l> wdp;
    List<r> wdy;
    List<r> wdz;
    
    public c()
    {
      GMTrace.i(14502628163584L, 108053);
      GMTrace.o(14502628163584L, 108053);
    }
    
    private static int a(String paramString, l paraml, List<r> paramList, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(14502762381312L, 108054);
      Iterator localIterator = paramList.iterator();
      r localr;
      label195:
      l.b localb;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localr = (r)localIterator.next();
          paraml.wdn.put(localr.getFileName(), Long.valueOf(localr.hYm));
          if (paraml.wdo.containsKey(Long.valueOf(localr.hYm)))
          {
            v.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[] { paramString, Long.valueOf(localr.hYm), localr.getFileName() });
          }
          else if (paramInt1 < paramInt2)
          {
            paramList = paraml.pu;
            int i = paramInt1 + 1;
            paramList = paramList.getChildAt(paramInt1);
            v.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(localr.hYm) });
            paramInt1 = i;
            localb = (l.b)paramList.getTag();
            if (localb != null) {
              break label713;
            }
            localb = new l.b();
          }
        }
      }
      label444:
      label677:
      label713:
      for (;;)
      {
        String str1;
        if (localb.wdq != localr.hYm)
        {
          v.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[] { Long.valueOf(localb.wdq), Long.valueOf(localr.hYm), Integer.valueOf(paramInt3) });
          localb.wdq = localr.hYm;
          localb.wds = paramList;
          localb.wdt = ((com.tencent.mm.plugin.sight.decode.a.a)paramList.findViewById(R.h.bXd));
          localb.wdu = ((ImageView)paramList.findViewById(R.h.cGo));
          localb.kWs = ((ProgressBar)paramList.findViewById(R.h.progress));
          localb.wdw = ((ImageButton)paramList.findViewById(R.h.bvD));
          localb.wdv = ((TextView)paramList.findViewById(R.h.bXw));
          localb.wdt.sB(paramList.getResources().getDimensionPixelSize(R.f.aXA));
          localb.wds.setTag(localb);
          localb.wdw.setTag(Long.valueOf(localb.wdq));
          localb.wds.setOnClickListener(new l.b.1(localb));
          localb.wdw.setOnClickListener(new l.b.2(localb));
          o.KW();
          str1 = s.lw(localr.getFileName());
          o.KW();
          String str2 = s.lx(localr.getFileName());
          paramList = n.GT().a(str2, com.tencent.mm.bg.a.getDensity(paramList.getContext()), paramList.getContext());
          localb.wdt.y(paramList);
          if (paramInt3 <= 3) {
            break label677;
          }
          localb.wdt.clear();
          localb.wdu.setVisibility(0);
        }
        for (;;)
        {
          a(localb, localr);
          paraml.wdo.put(Long.valueOf(localr.hYm), localb);
          break;
          paramList = LayoutInflater.from(paraml.pu.getContext()).inflate(R.i.dif, paraml.pu, false);
          paraml.pu.addView(paramList);
          v.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramList.hashCode()), Long.valueOf(localr.hYm) });
          break label195;
          v.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[] { Long.valueOf(localb.wdq), Integer.valueOf(paramInt3) });
          break label444;
          localb.wdt.ak(str1, false);
          localb.wdu.setVisibility(8);
        }
        GMTrace.o(14502762381312L, 108054);
        return paramInt1;
      }
    }
    
    public static void a(l.b paramb, r paramr)
    {
      boolean bool = true;
      GMTrace.i(14502896599040L, 108055);
      v.v("MicroMsg.MassSightBanner", "info status %d", new Object[] { Integer.valueOf(paramr.status) });
      if ((paramr.status == 198) || (paramr.status == 197) || (paramr.status == 196))
      {
        paramb.kWs.setVisibility(4);
        paramb.wdv.setVisibility(0);
        paramb.wdw.setEnabled(true);
        paramb.wdr = true;
        GMTrace.o(14502896599040L, 108055);
        return;
      }
      float f = paramr.hYB / paramr.hrb;
      paramb.kWs.setVisibility(0);
      paramb.wdv.setVisibility(4);
      paramb.kWs.setProgress((int)(paramb.kWs.getMax() * f));
      paramr = paramb.wdw;
      if (Float.compare(0.99F, f) > 0) {}
      for (;;)
      {
        paramr.setEnabled(bool);
        paramb.wdr = false;
        GMTrace.o(14502896599040L, 108055);
        return;
        bool = false;
      }
    }
    
    public final void run()
    {
      GMTrace.i(14503030816768L, 108056);
      l locall = (l)this.wdp.get();
      if (locall == null)
      {
        v.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
        GMTrace.o(14503030816768L, 108056);
        return;
      }
      int k = locall.pu.getChildCount();
      locall.wdo.clear();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.wdy.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((r)localIterator.next()).hYm));
      }
      localIterator = this.wdz.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(Long.valueOf(((r)localIterator.next()).hYm));
      }
      int i = localHashSet.size();
      int j = a("update unfinish", locall, this.wdy, 0, k, i);
      j = a("update fail", locall, this.wdz, j, k, i);
      i = j;
      while (i < k)
      {
        locall.pu.removeViewAt(j);
        i += 1;
      }
      GMTrace.o(14503030816768L, 108056);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */