package com.tencent.mm.plugin.photoedit.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.photoedit.c.c;
import com.tencent.mm.plugin.photoedit.f.d.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public final class d
  implements c<com.tencent.mm.plugin.photoedit.f.d>
{
  private Stack<com.tencent.mm.plugin.photoedit.f.d> ojp;
  private Stack<com.tencent.mm.plugin.photoedit.f.d> ojq;
  private SparseArray<String> ojs;
  private HashMap<String, Bitmap> ojt;
  
  public d()
  {
    GMTrace.i(9973585149952L, 74309);
    GMTrace.o(9973585149952L, 74309);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean, Object... paramVarArgs)
  {
    GMTrace.i(9974256238592L, 74314);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.ojp.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.photoedit.f.d)((Iterator)localObject).next()).a(paramCanvas, paramVarArgs);
      }
      GMTrace.o(9974256238592L, 74314);
      return;
    }
    if ((this.ojp != null) && (this.ojp.size() > 0)) {}
    for (Object localObject = (com.tencent.mm.plugin.photoedit.f.d)this.ojp.peek();; localObject = null)
    {
      if ((localObject != null) && (((com.tencent.mm.plugin.photoedit.f.d)localObject).oji == d.a.okX)) {
        ((com.tencent.mm.plugin.photoedit.f.d)localObject).a(paramCanvas, paramVarArgs);
      }
      GMTrace.o(9974256238592L, 74314);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.photoedit.f.d paramd)
  {
    GMTrace.i(9974927327232L, 74319);
    if (this.ojp != null) {
      this.ojp.push(paramd);
    }
    GMTrace.o(9974927327232L, 74319);
  }
  
  public final void aSb()
  {
    GMTrace.i(9974122020864L, 74313);
    v.i("MicroMsg.MosaicCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.ojp.size()) });
    this.ojp.clear();
    if (this.ojq != null)
    {
      v.i("MicroMsg.MosaicCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.ojq.size()) });
      this.ojp.addAll(this.ojq);
    }
    GMTrace.o(9974122020864L, 74313);
  }
  
  public final Bitmap aSd()
  {
    GMTrace.i(9974658891776L, 74317);
    String str = (String)this.ojs.get(gf(true));
    if (bf.mA(str))
    {
      v.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
      GMTrace.o(9974658891776L, 74317);
      return null;
    }
    v.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", new Object[] { str, Integer.valueOf(gf(true)) });
    if (this.ojt.containsKey(str)) {}
    for (Bitmap localBitmap1 = (Bitmap)this.ojt.get(str);; localBitmap1 = null)
    {
      Bitmap localBitmap2;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (!localBitmap1.isRecycled()) {}
      }
      else
      {
        v.i("MicroMsg.MosaicCache", "");
        localBitmap2 = com.tencent.mm.sdk.platformtools.d.Pf(str);
        v.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
      }
      if (localBitmap2 == null)
      {
        v.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", new Object[] { str });
        GMTrace.o(9974658891776L, 74317);
        return null;
      }
      localBitmap1 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
      localBitmap2.recycle();
      GMTrace.o(9974658891776L, 74317);
      return localBitmap1;
    }
  }
  
  public final boolean aSe()
  {
    GMTrace.i(9974793109504L, 74318);
    if (gf(true) > 0)
    {
      GMTrace.o(9974793109504L, 74318);
      return true;
    }
    GMTrace.o(9974793109504L, 74318);
    return false;
  }
  
  public final void ge(boolean paramBoolean)
  {
    GMTrace.i(9973987803136L, 74312);
    v.i("MicroMsg.MosaicCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.ojp.size()) });
    if (this.ojq != null) {
      this.ojq.clear();
    }
    this.ojq = ((Stack)this.ojp.clone());
    if (paramBoolean) {
      this.ojp.clear();
    }
    GMTrace.o(9973987803136L, 74312);
  }
  
  public final int gf(boolean paramBoolean)
  {
    GMTrace.i(9975061544960L, 74320);
    int i;
    if (paramBoolean)
    {
      if (this.ojp != null)
      {
        i = this.ojp.size();
        GMTrace.o(9975061544960L, 74320);
        return i;
      }
      GMTrace.o(9975061544960L, 74320);
      return 0;
    }
    if (this.ojq != null)
    {
      i = this.ojq.size();
      GMTrace.o(9975061544960L, 74320);
      return i;
    }
    GMTrace.o(9975061544960L, 74320);
    return 0;
  }
  
  public final void h(Canvas paramVarArgs)
  {
    GMTrace.i(9974390456320L, 74315);
    Bitmap localBitmap = aSd();
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramVarArgs.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
    GMTrace.o(9974390456320L, 74315);
  }
  
  public final void onCreate()
  {
    GMTrace.i(9973719367680L, 74310);
    v.i("MicroMsg.MosaicCache", "[onCreate]");
    this.ojp = new Stack();
    this.ojs = new SparseArray();
    this.ojt = new HashMap();
    GMTrace.o(9973719367680L, 74310);
  }
  
  public final void onDestroy()
  {
    GMTrace.i(9973853585408L, 74311);
    v.i("MicroMsg.MosaicCache", "[onDestroy]");
    if (this.ojp != null)
    {
      localIterator = this.ojp.iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        com.tencent.mm.plugin.photoedit.f.d.clear();
      }
      this.ojp.clear();
    }
    if (this.ojq != null)
    {
      localIterator = this.ojq.iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        com.tencent.mm.plugin.photoedit.f.d.clear();
      }
      this.ojq.clear();
    }
    int i = 0;
    while (i < this.ojs.size())
    {
      FileOp.deleteFile((String)this.ojs.valueAt(i));
      i += 1;
    }
    this.ojs.clear();
    Iterator localIterator = this.ojt.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
    }
    this.ojt.clear();
    GMTrace.o(9973853585408L, 74311);
  }
  
  public final void v(final Bitmap paramBitmap)
  {
    GMTrace.i(9974524674048L, 74316);
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    final String str1 = com.tencent.mm.plugin.photoedit.g.a.Cv(com.tencent.mm.plugin.photoedit.b.a.ohN.toString());
    v.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[] { str1, Integer.valueOf(gf(true)) });
    String str2 = (String)this.ojs.get(gf(true));
    if (!bf.mA(str2))
    {
      FileOp.deleteFile(str2);
      this.ojs.remove(gf(true));
    }
    this.ojs.put(gf(true), str1);
    this.ojt.put(str1, paramBitmap);
    e.bKi();
    e.a(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(9977074810880L, 74335);
        try
        {
          com.tencent.mm.sdk.platformtools.d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, str1, true);
          GMTrace.o(9977074810880L, 74335);
          return;
        }
        catch (IOException localIOException)
        {
          v.printErrStackTrace("MicroMsg.MosaicCache", localIOException, "", new Object[0]);
          GMTrace.o(9977074810880L, 74335);
        }
      }
    }, "[saveCacheToLocal] mosaic path:" + str1);
    GMTrace.o(9974524674048L, 74316);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/cache/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */