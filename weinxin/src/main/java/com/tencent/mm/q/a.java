package com.tencent.mm.q;

import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class a
{
  static a gUB;
  public b gUC;
  ArrayList<WeakReference<a>> gUD;
  public boolean gUE;
  private final int gUF;
  private final int gUG;
  private ad handler;
  
  public a()
  {
    GMTrace.i(14597385879552L, 108759);
    this.gUC = new b();
    this.gUD = new ArrayList();
    this.gUE = false;
    this.gUF = 0;
    this.gUG = 1;
    this.handler = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(14597251661824L, 108758);
        Object localObject1;
        if ((paramAnonymousMessage.what == 0) && ((paramAnonymousMessage.obj instanceof a.b)))
        {
          localObject1 = (a.b)paramAnonymousMessage.obj;
          if (((a.b)localObject1).gUJ == null) {
            break label245;
          }
          a locala = a.this;
          Object localObject3 = ((a.b)localObject1).gUJ;
          localObject1 = null;
          Iterator localIterator = locala.gUD.iterator();
          Object localObject2;
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null))
            {
              ((a.a)localWeakReference.get()).a((w.a)localObject3);
            }
            else
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new ArrayList();
              }
              ((ArrayList)localObject2).add(localWeakReference);
              localObject1 = localObject2;
            }
          }
          if (localObject1 != null)
          {
            localObject2 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (WeakReference)((Iterator)localObject2).next();
              locala.gUD.remove(localObject3);
            }
            ((ArrayList)localObject1).clear();
          }
        }
        while ((paramAnonymousMessage.what == 1) && ((paramAnonymousMessage.obj instanceof a.c)))
        {
          paramAnonymousMessage = (a.c)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.gUJ != null)
          {
            a.this.ui();
            GMTrace.o(14597251661824L, 108758);
            return;
            label245:
            a.this.eE(((a.b)localObject1).gUI);
          }
          else
          {
            a.this.eF(paramAnonymousMessage.gUK);
          }
        }
        GMTrace.o(14597251661824L, 108758);
      }
    };
    GMTrace.o(14597385879552L, 108759);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(14598056968192L, 108764);
    if (!this.gUE)
    {
      v.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
      GMTrace.o(14598056968192L, 108764);
      return;
    }
    b localb = this.gUC;
    v.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    b.a locala2 = localb.eJ(paramInt1);
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = localb.a(paramInt1, paramInt2, "", "");
      localb.gUM.put(paramInt1, locala1);
      localb.a(locala1);
    }
    locala1.value = paramString;
    locala1.type = paramInt2;
    locala1.fGM = localb.uj();
    localb.a(locala1);
    this.handler.sendMessage(this.handler.obtainMessage(0, new b(paramInt1, paramInt2, paramString)));
    GMTrace.o(14598056968192L, 108764);
  }
  
  private void a(w.a parama, int paramInt, String paramString)
  {
    GMTrace.i(16745003745280L, 124760);
    if (!this.gUE)
    {
      v.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
      GMTrace.o(16745003745280L, 124760);
      return;
    }
    b localb = this.gUC;
    v.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", new Object[] { parama, Integer.valueOf(paramInt), paramString });
    b.a locala2 = localb.e(parama);
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = localb.a(parama, paramInt, "", "");
      localb.gUN.put(parama, locala1);
      localb.a(locala1);
    }
    locala1.value = paramString;
    locala1.type = paramInt;
    locala1.fGM = localb.uj();
    localb.a(locala1);
    this.handler.sendMessage(this.handler.obtainMessage(0, new b(parama, paramInt, paramString)));
    GMTrace.o(16745003745280L, 124760);
  }
  
  public static int parseInt(String paramString)
  {
    GMTrace.i(14598728056832L, 108769);
    if (bf.mA(paramString))
    {
      GMTrace.o(14598728056832L, 108769);
      return 0;
    }
    int i = bf.PX(paramString);
    GMTrace.o(14598728056832L, 108769);
    return i;
  }
  
  public final void a(a parama)
  {
    GMTrace.i(14598862274560L, 108770);
    if (!this.gUE)
    {
      v.w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
      GMTrace.o(14598862274560L, 108770);
      return;
    }
    this.gUD.add(new WeakReference(parama));
    GMTrace.o(14598862274560L, 108770);
  }
  
  public final void a(w.a parama, boolean paramBoolean)
  {
    GMTrace.i(14597788532736L, 108762);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      a(parama, 1, str);
      GMTrace.o(14597788532736L, 108762);
      return;
    }
  }
  
  public final boolean a(w.a parama1, w.a parama2)
  {
    GMTrace.i(14598325403648L, 108766);
    if (!this.gUE)
    {
      v.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
      GMTrace.o(14598325403648L, 108766);
      return false;
    }
    parama1 = this.gUC.a(parama1, parama2, 1);
    if (parama1 == null)
    {
      GMTrace.o(14598325403648L, 108766);
      return false;
    }
    if (parseInt(parama1.value) == 0)
    {
      GMTrace.o(14598325403648L, 108766);
      return false;
    }
    GMTrace.o(14598325403648L, 108766);
    return true;
  }
  
  public final boolean aC(int paramInt1, int paramInt2)
  {
    GMTrace.i(14598191185920L, 108765);
    if (!this.gUE)
    {
      v.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
      GMTrace.o(14598191185920L, 108765);
      return false;
    }
    b.a locala = this.gUC.p(paramInt1, paramInt2, 1);
    if (locala == null)
    {
      GMTrace.o(14598191185920L, 108765);
      return false;
    }
    if (parseInt(locala.value) == 0)
    {
      GMTrace.o(14598191185920L, 108765);
      return false;
    }
    GMTrace.o(14598191185920L, 108765);
    return true;
  }
  
  public final boolean aD(int paramInt1, int paramInt2)
  {
    GMTrace.i(14598459621376L, 108767);
    if (!this.gUE)
    {
      v.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
      GMTrace.o(14598459621376L, 108767);
      return false;
    }
    b.a locala = this.gUC.p(paramInt1, paramInt2, 2);
    if (locala == null)
    {
      GMTrace.o(14598459621376L, 108767);
      return false;
    }
    if (parseInt(locala.value) == 0)
    {
      GMTrace.o(14598459621376L, 108767);
      return false;
    }
    GMTrace.o(14598459621376L, 108767);
    return true;
  }
  
  public final void aE(int paramInt1, int paramInt2)
  {
    GMTrace.i(14598593839104L, 108768);
    if (!this.gUE)
    {
      v.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      GMTrace.o(14598593839104L, 108768);
      return;
    }
    b localb = this.gUC;
    v.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b.a locala = localb.eJ(paramInt1);
    if (locala == null) {
      v.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
    }
    for (;;)
    {
      this.handler.sendMessage(this.handler.obtainMessage(1, new c(paramInt2, paramInt1)));
      GMTrace.o(14598593839104L, 108768);
      return;
      b.b localb2 = localb.eK(paramInt2);
      b.b localb1 = localb2;
      if (localb2 == null)
      {
        v.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
        localb1 = localb.eI(paramInt2);
        localb.gUO.put(paramInt2, localb1);
      }
      localb1.gUU.put(paramInt1, locala.fGM);
      localb.a(localb1);
    }
  }
  
  public final void b(a parama)
  {
    GMTrace.i(14598996492288L, 108771);
    if (!this.gUE)
    {
      v.w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
      GMTrace.o(14598996492288L, 108771);
      return;
    }
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    while (i < this.gUD.size())
    {
      WeakReference localWeakReference = (WeakReference)this.gUD.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        localObject2 = localObject1;
        if (localWeakReference.get() != parama) {}
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localWeakReference);
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      parama = ((ArrayList)localObject1).iterator();
      while (parama.hasNext())
      {
        localObject2 = (WeakReference)parama.next();
        this.gUD.remove(localObject2);
      }
      ((ArrayList)localObject1).clear();
    }
    GMTrace.o(14598996492288L, 108771);
  }
  
  public final void b(w.a parama, boolean paramBoolean)
  {
    GMTrace.i(16744869527552L, 124759);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      a(parama, 2, str);
      GMTrace.o(16744869527552L, 124759);
      return;
    }
  }
  
  public final boolean b(w.a parama1, w.a parama2)
  {
    GMTrace.i(16745137963008L, 124761);
    if (!this.gUE)
    {
      v.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
      GMTrace.o(16745137963008L, 124761);
      return false;
    }
    parama1 = this.gUC.a(parama1, parama2, 2);
    if (parama1 == null)
    {
      GMTrace.o(16745137963008L, 124761);
      return false;
    }
    if (parseInt(parama1.value) == 0)
    {
      GMTrace.o(16745137963008L, 124761);
      return false;
    }
    GMTrace.o(16745137963008L, 124761);
    return true;
  }
  
  public final void c(w.a parama1, w.a parama2)
  {
    GMTrace.i(16745272180736L, 124762);
    if (!this.gUE)
    {
      v.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
      GMTrace.o(16745272180736L, 124762);
      return;
    }
    b localb = this.gUC;
    v.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", new Object[] { parama1, parama2 });
    b.a locala = localb.e(parama1);
    if (locala == null) {
      v.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
    }
    for (;;)
    {
      this.handler.sendMessage(this.handler.obtainMessage(1, new c(parama2, parama1)));
      GMTrace.o(16745272180736L, 124762);
      return;
      b.b localb2 = localb.f(parama2);
      b.b localb1 = localb2;
      if (localb2 == null)
      {
        v.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
        localb1 = localb.d(parama2);
        localb.gUP.put(parama2, localb1);
      }
      localb1.gUV.put(parama1.name(), locala.fGM);
      localb.a(localb1);
    }
  }
  
  public final void eE(int paramInt)
  {
    GMTrace.i(16087471095808L, 119861);
    Object localObject1 = null;
    Object localObject3 = this.gUD.iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject3).next();
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        ((a)localWeakReference.get()).eE(paramInt);
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localWeakReference);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WeakReference)((Iterator)localObject2).next();
        this.gUD.remove(localObject3);
      }
      ((ArrayList)localObject1).clear();
    }
    GMTrace.o(16087471095808L, 119861);
  }
  
  public final void eF(int paramInt)
  {
    GMTrace.i(16087605313536L, 119862);
    Object localObject1 = null;
    Object localObject3 = this.gUD.iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject3).next();
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        ((a)localWeakReference.get()).eF(paramInt);
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localWeakReference);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WeakReference)((Iterator)localObject2).next();
        this.gUD.remove(localObject3);
      }
      ((ArrayList)localObject1).clear();
    }
    GMTrace.o(16087605313536L, 119862);
  }
  
  public final void init()
  {
    GMTrace.i(14597520097280L, 108760);
    this.gUE = true;
    this.gUC.gUR = h.vI().vr();
    GMTrace.o(14597520097280L, 108760);
  }
  
  public final void s(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(14597654315008L, 108761);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      a(paramInt, 1, str);
      GMTrace.o(14597654315008L, 108761);
      return;
    }
  }
  
  public final void t(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(14597922750464L, 108763);
    if (!paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      a(paramInt, 2, str);
      GMTrace.o(14597922750464L, 108763);
      return;
    }
  }
  
  public final void ui()
  {
    GMTrace.i(16087739531264L, 119863);
    Object localObject1 = null;
    Object localObject3 = this.gUD.iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject3).next();
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        localWeakReference.get();
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localWeakReference);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WeakReference)((Iterator)localObject2).next();
        this.gUD.remove(localObject3);
      }
      ((ArrayList)localObject1).clear();
    }
    GMTrace.o(16087739531264L, 119863);
  }
  
  public static abstract interface a
  {
    public abstract void a(w.a parama);
    
    public abstract void eE(int paramInt);
    
    public abstract void eF(int paramInt);
  }
  
  final class b
  {
    int gUI;
    w.a gUJ;
    int type;
    String value;
    
    public b(int paramInt1, int paramInt2, String paramString)
    {
      GMTrace.i(14594433089536L, 108737);
      this.gUI = paramInt1;
      this.type = paramInt2;
      this.value = paramString;
      GMTrace.o(14594433089536L, 108737);
    }
    
    public b(w.a parama, int paramInt, String paramString)
    {
      GMTrace.i(14594567307264L, 108738);
      this.gUJ = parama;
      this.type = paramInt;
      this.value = paramString;
      GMTrace.o(14594567307264L, 108738);
    }
  }
  
  final class c
  {
    int gUI;
    w.a gUJ;
    int gUK;
    w.a gUL;
    
    public c(int paramInt1, int paramInt2)
    {
      GMTrace.i(14594298871808L, 108736);
      this.gUK = paramInt1;
      this.gUI = paramInt2;
      GMTrace.o(14594298871808L, 108736);
    }
    
    public c(w.a parama1, w.a parama2)
    {
      GMTrace.i(16744466874368L, 124756);
      this.gUL = parama1;
      this.gUJ = parama2;
      GMTrace.o(16744466874368L, 124756);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/q/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */