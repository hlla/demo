package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

final class e
  implements ViewPager.e
{
  private static int mScreenHeight;
  private static int mScreenWidth;
  private static long vPA;
  public ad hgD;
  private aq hvL;
  SparseArray<WeakReference<ImageView>> mfo;
  public HashMap<String, Integer> mfp;
  SparseArray<String> mfq;
  public SparseArray<Bitmap> mfr;
  protected com.tencent.mm.a.f<String, Bitmap> mfs;
  protected SparseIntArray mft;
  public boolean mfv;
  private int mfz;
  private LinkedList<String> ta;
  public LinkedList<Integer> vPB;
  public a vPy;
  protected com.tencent.mm.a.f<Integer, Bitmap> vPz;
  private int xV;
  
  static
  {
    GMTrace.i(2430683054080L, 18110);
    mScreenWidth = 0;
    mScreenHeight = 0;
    vPA = 0L;
    GMTrace.o(2430683054080L, 18110);
  }
  
  public e(a parama)
  {
    GMTrace.i(2427864481792L, 18089);
    this.hvL = new aq(1, "chatting-image-gallery-lazy-loader");
    this.mfo = new SparseArray();
    this.mfp = new HashMap();
    this.mfq = new SparseArray();
    this.mfr = new SparseArray();
    this.xV = 0;
    this.mfz = -1;
    this.vPz = new com.tencent.mm.a.f(40, new f.b() {});
    this.mfs = new com.tencent.mm.a.f(5, new f.b() {});
    this.vPB = new LinkedList();
    this.mft = new SparseIntArray();
    this.ta = new LinkedList();
    this.hgD = new ad();
    this.mfv = false;
    this.vPy = parama;
    GMTrace.o(2427864481792L, 18089);
  }
  
  private void ni(int paramInt)
  {
    GMTrace.i(2428669788160L, 18095);
    if (this.mfq.get(paramInt) != null)
    {
      String str = (String)this.mfq.get(paramInt);
      this.mfo.remove(paramInt);
      this.mfq.remove(paramInt);
      this.mfp.remove(str);
      this.mfr.remove(paramInt);
    }
    GMTrace.o(2428669788160L, 18095);
  }
  
  private void nj(final int paramInt)
  {
    GMTrace.i(2428401352704L, 18093);
    if (this.vPz.aV(Integer.valueOf(paramInt)))
    {
      GMTrace.o(2428401352704L, 18093);
      return;
    }
    ap.vL().e(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2446520745984L, 18228);
        if (e.this.vPy == null)
        {
          v.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
          GMTrace.o(2446520745984L, 18228);
          return;
        }
        final Bitmap localBitmap = e.this.vPy.Bv(paramInt);
        if (localBitmap == null)
        {
          GMTrace.o(2446520745984L, 18228);
          return;
        }
        e.this.hgD.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2445581221888L, 18221);
            e.this.vPz.put(Integer.valueOf(e.5.this.kA), localBitmap);
            GMTrace.o(2445581221888L, 18221);
          }
        });
        GMTrace.o(2446520745984L, 18228);
      }
    }, 300L);
    GMTrace.o(2428401352704L, 18093);
  }
  
  public final void V(int paramInt)
  {
    GMTrace.i(2428267134976L, 18092);
    if (!((d)this.vPy).vNV.vNX.vOo)
    {
      GMTrace.o(2428267134976L, 18092);
      return;
    }
    if (this.mfz == -1)
    {
      int i = 0;
      if (i == 0) {
        nj(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label144;
        }
        if (paramInt + i <= paramInt + 3) {
          nj(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          nj(paramInt - i);
        }
      }
    }
    if (this.mfz > paramInt) {
      nj(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label144:
      this.mfz = paramInt;
      GMTrace.o(2428267134976L, 18092);
      return;
      if (this.mfz < paramInt) {
        nj(paramInt + 3);
      }
    }
  }
  
  public final void W(int paramInt)
  {
    int j = 0;
    GMTrace.i(2428132917248L, 18091);
    this.xV = paramInt;
    if (ayQ())
    {
      int[] arrayOfInt = new int[this.mfr.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.mfr.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        a(i, (Bitmap)this.mfr.get(i));
        paramInt += 1;
      }
    }
    GMTrace.o(2428132917248L, 18091);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    GMTrace.i(2429340876800L, 18100);
    GMTrace.o(2429340876800L, 18100);
  }
  
  public final void a(int paramInt, Bitmap paramBitmap)
  {
    GMTrace.i(2428804005888L, 18096);
    if (this.mfo.get(paramInt) == null)
    {
      GMTrace.o(2428804005888L, 18096);
      return;
    }
    ImageView localImageView = (ImageView)((WeakReference)this.mfo.get(paramInt)).get();
    this.mfq.get(paramInt);
    this.vPy.c(localImageView, paramBitmap);
    ni(paramInt);
    GMTrace.o(2428804005888L, 18096);
  }
  
  public final void aj(Map<String, Bitmap> paramMap)
  {
    GMTrace.i(2427730264064L, 18088);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)paramMap.get(str);
      if (localBitmap != null)
      {
        this.mfs.put(str, localBitmap);
        this.vPB.push(Integer.valueOf(localBitmap.hashCode()));
        v.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[] { str, Integer.valueOf(localBitmap.hashCode()) });
      }
      else
      {
        v.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
      }
    }
    GMTrace.o(2427730264064L, 18088);
  }
  
  final void ayP()
  {
    GMTrace.i(2427998699520L, 18090);
    this.vPz.a(new com.tencent.mm.a.f.a() {});
    this.mfs.a(new com.tencent.mm.a.f.a() {});
    GMTrace.o(2427998699520L, 18090);
  }
  
  public final boolean ayQ()
  {
    GMTrace.i(2428535570432L, 18094);
    if (this.xV == 0)
    {
      GMTrace.o(2428535570432L, 18094);
      return true;
    }
    GMTrace.o(2428535570432L, 18094);
    return false;
  }
  
  public final void ayR()
  {
    GMTrace.i(2429206659072L, 18099);
    if (this.mfv)
    {
      GMTrace.o(2429206659072L, 18099);
      return;
    }
    if (this.ta.size() == 0)
    {
      GMTrace.o(2429206659072L, 18099);
      return;
    }
    final Object localObject = (String)this.ta.removeLast();
    if (!this.mfp.containsKey(localObject))
    {
      GMTrace.o(2429206659072L, 18099);
      return;
    }
    this.mfv = true;
    localObject = new aq.a()
    {
      private Bitmap mfx;
      
      public final boolean Bn()
      {
        GMTrace.i(2483564838912L, 18504);
        if ((e.this.vPy == null) || (TextUtils.isEmpty(localObject)))
        {
          GMTrace.o(2483564838912L, 18504);
          return false;
        }
        try
        {
          this.mfx = e.this.vPy.TI(localObject);
          GMTrace.o(2483564838912L, 18504);
          return true;
        }
        catch (Exception localException)
        {
          v.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[] { localException.getMessage() });
          this.mfx = null;
          GMTrace.o(2483564838912L, 18504);
        }
        return false;
      }
      
      public final boolean Bo()
      {
        GMTrace.i(2483430621184L, 18503);
        e.this.mfv = false;
        if (e.this.mfp.containsKey(localObject))
        {
          i = ((Integer)e.this.mfp.get(localObject)).intValue();
          if (e.this.ayQ()) {
            break label154;
          }
          e.this.mfr.put(i, this.mfx);
        }
        Bitmap localBitmap;
        int j;
        for (;;)
        {
          e.this.t(localObject, this.mfx);
          localBitmap = this.mfx;
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            break;
          }
          j = 0;
          v.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", new Object[] { Integer.valueOf(j) });
          this.mfx = null;
          e.this.ayR();
          GMTrace.o(2483430621184L, 18503);
          return false;
          label154:
          e.this.a(i, this.mfx);
        }
        if (Build.VERSION.SDK_INT >= 12) {}
        for (int i = localBitmap.getByteCount();; i = localBitmap.getRowBytes() * localBitmap.getHeight())
        {
          j = i;
          if (i >= 0) {
            break;
          }
          throw new IllegalStateException("Negative size: " + localBitmap);
        }
      }
    };
    this.hvL.c((aq.a)localObject);
    GMTrace.o(2429206659072L, 18099);
  }
  
  public final boolean b(ImageView paramImageView, int paramInt)
  {
    GMTrace.i(2428938223616L, 18097);
    v.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[] { Integer.valueOf(paramInt) });
    Bitmap localBitmap = (Bitmap)this.vPz.get(Integer.valueOf(paramInt));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.vPy.c(paramImageView, localBitmap);
      GMTrace.o(2428938223616L, 18097);
      return true;
    }
    GMTrace.o(2428938223616L, 18097);
    return false;
  }
  
  public final void q(ImageView paramImageView, String paramString)
  {
    GMTrace.i(2429072441344L, 18098);
    if (this.ta.contains(paramString))
    {
      GMTrace.o(2429072441344L, 18098);
      return;
    }
    int i = paramImageView.hashCode();
    ni(i);
    this.mfp.put(paramString, Integer.valueOf(i));
    this.mfq.put(i, paramString);
    this.mfo.put(i, new WeakReference(paramImageView));
    this.ta.add(paramString);
    ayR();
    GMTrace.o(2429072441344L, 18098);
  }
  
  protected final void t(String paramString, Bitmap paramBitmap)
  {
    GMTrace.i(2427596046336L, 18087);
    if (paramBitmap != null)
    {
      long l = paramBitmap.getWidth() * paramBitmap.getHeight();
      if ((mScreenHeight == 0) || (mScreenWidth == 0))
      {
        mScreenWidth = aa.getContext().getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = aa.getContext().getResources().getDisplayMetrics().heightPixels;
        vPA = mScreenWidth * vPA;
      }
      if (l <= vPA * 2L) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      v.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
      GMTrace.o(2427596046336L, 18087);
      return;
    }
    this.mfs.k(paramString, paramBitmap);
    if (f.a.vPH.mfs.aV(paramString))
    {
      v.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
      try
      {
        f.a.vPH.mfs.k(paramString, paramBitmap);
        GMTrace.o(2427596046336L, 18087);
        return;
      }
      catch (Exception paramString)
      {
        v.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", paramString, "update preload cache failed", new Object[0]);
      }
    }
    GMTrace.o(2427596046336L, 18087);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap Bv(int paramInt);
    
    public abstract Bitmap TI(String paramString);
    
    public abstract void c(ImageView paramImageView, Bitmap paramBitmap);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */