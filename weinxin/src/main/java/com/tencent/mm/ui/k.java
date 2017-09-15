package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class k<T>
  extends BaseAdapter
  implements j.a, m.b
{
  public Context context;
  public int count;
  private ad oNC;
  private Cursor uKq;
  public T uQW;
  public Map<Integer, T> uQX;
  public a uQY;
  private int uQZ;
  private int uRa;
  private int uRb;
  private Runnable uRc;
  
  public k(Context paramContext, T paramT)
  {
    GMTrace.i(1598667358208L, 11911);
    this.uKq = null;
    this.uQX = null;
    this.oNC = new ad(Looper.getMainLooper());
    this.uQZ = 0;
    this.uRa = 0;
    this.uRb = 0;
    this.uRc = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2534030704640L, 18880);
        if (k.a(k.this) != 0)
        {
          v.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(k.a(k.this)), Integer.valueOf(k.b(k.this)) });
          k.d(k.this).removeCallbacks(k.c(k.this));
          if (20 > k.e(k.this))
          {
            k.d(k.this).postDelayed(k.c(k.this), 100L);
            GMTrace.o(2534030704640L, 18880);
            return;
          }
          v.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(k.a(k.this)), Integer.valueOf(k.e(k.this)) });
        }
        v.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
        k.f(k.this);
        k.g(k.this);
        GMTrace.o(2534030704640L, 18880);
      }
    };
    this.uQW = paramT;
    this.context = paramContext;
    this.count = -1;
    GMTrace.o(1598667358208L, 11911);
  }
  
  private void bPD()
  {
    GMTrace.i(1600412188672L, 11924);
    v.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
    if (this.uQY != null) {
      this.uQY.OJ();
    }
    aEP();
    OL();
    if (this.uQY != null) {
      this.uQY.OI();
    }
    GMTrace.o(1600412188672L, 11924);
  }
  
  public abstract void OL();
  
  public abstract void OM();
  
  public abstract T a(T paramT, Cursor paramCursor);
  
  public void a(int paramInt, m paramm, Object paramObject)
  {
    GMTrace.i(1600143753216L, 11922);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      v.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      GMTrace.o(1600143753216L, 11922);
      return;
    }
    a((String)paramObject, null);
    GMTrace.o(1600143753216L, 11922);
  }
  
  public void a(String paramString, l paraml)
  {
    GMTrace.i(1600277970944L, 11923);
    bPD();
    GMTrace.o(1600277970944L, 11923);
  }
  
  public int aBO()
  {
    GMTrace.i(1600814841856L, 11927);
    GMTrace.o(1600814841856L, 11927);
    return 0;
  }
  
  public T aBP()
  {
    GMTrace.i(1600949059584L, 11928);
    Object localObject = this.uQW;
    GMTrace.o(1600949059584L, 11928);
    return (T)localObject;
  }
  
  public void aEP()
  {
    GMTrace.i(1599606882304L, 11918);
    if (this.uQX != null) {
      this.uQX.clear();
    }
    if (this.uKq != null) {
      this.uKq.close();
    }
    this.count = -1;
    GMTrace.o(1599606882304L, 11918);
  }
  
  public final int ani()
  {
    GMTrace.i(1599875317760L, 11920);
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    int i = this.count;
    GMTrace.o(1599875317760L, 11920);
    return i;
  }
  
  public int getCount()
  {
    GMTrace.i(1599741100032L, 11919);
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    int i = this.count;
    int j = aBO();
    GMTrace.o(1599741100032L, 11919);
    return i + j;
  }
  
  public final Cursor getCursor()
  {
    GMTrace.i(1599070011392L, 11914);
    if ((this.uKq == null) || (this.uKq.isClosed()))
    {
      OM();
      Assert.assertNotNull(this.uKq);
    }
    Cursor localCursor = this.uKq;
    GMTrace.o(1599070011392L, 11914);
    return localCursor;
  }
  
  public T getItem(int paramInt)
  {
    GMTrace.i(1600546406400L, 11925);
    if (nF(paramInt))
    {
      localObject = aBP();
      GMTrace.o(1600546406400L, 11925);
      return (T)localObject;
    }
    if (this.uQX != null)
    {
      localObject = this.uQX.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        GMTrace.o(1600546406400L, 11925);
        return (T)localObject;
      }
    }
    if ((paramInt < 0) || (!getCursor().moveToPosition(paramInt)))
    {
      GMTrace.o(1600546406400L, 11925);
      return null;
    }
    if (this.uQX == null)
    {
      localObject = a(this.uQW, getCursor());
      GMTrace.o(1600546406400L, 11925);
      return (T)localObject;
    }
    Object localObject = a(null, getCursor());
    this.uQX.put(Integer.valueOf(paramInt), localObject);
    GMTrace.o(1600546406400L, 11925);
    return (T)localObject;
  }
  
  public long getItemId(int paramInt)
  {
    GMTrace.i(1600009535488L, 11921);
    GMTrace.o(1600009535488L, 11921);
    return 0L;
  }
  
  public final void kl(boolean paramBoolean)
  {
    GMTrace.i(1599472664576L, 11917);
    if (!paramBoolean)
    {
      if (this.uQX != null)
      {
        this.uQX.clear();
        this.uQX = null;
        GMTrace.o(1599472664576L, 11917);
      }
    }
    else if (this.uQX == null) {
      this.uQX = new HashMap();
    }
    GMTrace.o(1599472664576L, 11917);
  }
  
  public boolean nF(int paramInt)
  {
    GMTrace.i(1600680624128L, 11926);
    if ((paramInt >= this.count) && (paramInt < this.count + aBO()))
    {
      GMTrace.o(1600680624128L, 11926);
      return true;
    }
    GMTrace.o(1600680624128L, 11926);
    return false;
  }
  
  public final void setCursor(Cursor paramCursor)
  {
    GMTrace.i(1599204229120L, 11915);
    this.uKq = paramCursor;
    this.count = -1;
    GMTrace.o(1599204229120L, 11915);
  }
  
  public static abstract interface a
  {
    public abstract void OI();
    
    public abstract void OJ();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */