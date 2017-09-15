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
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public final class b
  implements c<com.tencent.mm.plugin.photoedit.f.b>
{
  public Stack<com.tencent.mm.plugin.photoedit.f.b> ojp;
  private Stack<com.tencent.mm.plugin.photoedit.f.b> ojq;
  private SparseArray<String> ojs;
  private HashMap<String, Bitmap> ojt;
  public float oju;
  
  public b()
  {
    GMTrace.i(9977209028608L, 74336);
    this.oju = 0.0F;
    GMTrace.o(9977209028608L, 74336);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean, Object... paramVarArgs)
  {
    GMTrace.i(9977880117248L, 74341);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      paramVarArgs = this.ojp.iterator();
      while (paramVarArgs.hasNext()) {
        ((com.tencent.mm.plugin.photoedit.f.b)paramVarArgs.next()).j(paramCanvas);
      }
      GMTrace.o(9977880117248L, 74341);
      return;
    }
    if ((this.ojp != null) && (this.ojp.size() > 0)) {}
    for (paramVarArgs = (com.tencent.mm.plugin.photoedit.f.b)this.ojp.peek();; paramVarArgs = null)
    {
      if (paramVarArgs != null) {
        paramVarArgs.j(paramCanvas);
      }
      GMTrace.o(9977880117248L, 74341);
      return;
    }
  }
  
  public final void aSb()
  {
    GMTrace.i(9977745899520L, 74340);
    v.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.ojp.size()) });
    this.ojp.clear();
    if (this.ojq != null)
    {
      v.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.ojq.size()) });
      this.ojp.addAll(this.ojq);
    }
    GMTrace.o(9977745899520L, 74340);
  }
  
  public final Bitmap aSd()
  {
    GMTrace.i(9978282770432L, 74344);
    String str = (String)this.ojs.get(gf(true));
    if (bf.mA(str))
    {
      v.w("MicroMsg.DoodleCache", "[getCacheFromLocal] path is null");
      GMTrace.o(9978282770432L, 74344);
      return null;
    }
    v.i("MicroMsg.DoodleCache", "[getCacheFromLocal] path:%s size:%s", new Object[] { str, Integer.valueOf(gf(true)) });
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
        v.i("MicroMsg.DoodleCache", "");
        localBitmap2 = d.Pf(str);
        v.i("MicroMsg.DoodleCache", "[getCacheFromLocal] get from local!");
      }
      if (localBitmap2 == null)
      {
        v.e("MicroMsg.DoodleCache", "[getCacheFromLocal] null == bitmap path:%s", new Object[] { str });
        GMTrace.o(9978282770432L, 74344);
        return null;
      }
      localBitmap1 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
      localBitmap2.recycle();
      GMTrace.o(9978282770432L, 74344);
      return localBitmap1;
    }
  }
  
  public final boolean aSe()
  {
    GMTrace.i(9978416988160L, 74345);
    if (gf(true) > 0)
    {
      GMTrace.o(9978416988160L, 74345);
      return true;
    }
    GMTrace.o(9978416988160L, 74345);
    return false;
  }
  
  public final void ge(boolean paramBoolean)
  {
    GMTrace.i(9977611681792L, 74339);
    v.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.ojp.size()) });
    if (this.ojq != null) {
      this.ojq.clear();
    }
    this.ojq = ((Stack)this.ojp.clone());
    if (paramBoolean) {
      this.ojp.clear();
    }
    GMTrace.o(9977611681792L, 74339);
  }
  
  public final int gf(boolean paramBoolean)
  {
    GMTrace.i(9978551205888L, 74346);
    int i;
    if (paramBoolean)
    {
      if (this.ojp != null)
      {
        i = this.ojp.size();
        GMTrace.o(9978551205888L, 74346);
        return i;
      }
      GMTrace.o(9978551205888L, 74346);
      return 0;
    }
    if (this.ojq != null)
    {
      i = this.ojq.size();
      GMTrace.o(9978551205888L, 74346);
      return i;
    }
    GMTrace.o(9978551205888L, 74346);
    return 0;
  }
  
  public final void h(Canvas paramVarArgs)
  {
    GMTrace.i(9978014334976L, 74342);
    Iterator localIterator = this.ojp.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.photoedit.f.b)localIterator.next()).j(paramVarArgs);
    }
    GMTrace.o(9978014334976L, 74342);
  }
  
  public final void onCreate()
  {
    GMTrace.i(9977343246336L, 74337);
    this.ojp = new Stack();
    this.ojs = new SparseArray();
    this.ojt = new HashMap();
    GMTrace.o(9977343246336L, 74337);
  }
  
  public final void onDestroy()
  {
    GMTrace.i(9977477464064L, 74338);
    v.i("MicroMsg.DoodleCache", "[onDestroy]");
    if (this.ojp != null)
    {
      localIterator = this.ojp.iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        com.tencent.mm.plugin.photoedit.f.b.clear();
      }
      this.ojp.clear();
    }
    if (this.ojq != null)
    {
      localIterator = this.ojq.iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        com.tencent.mm.plugin.photoedit.f.b.clear();
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
    GMTrace.o(9977477464064L, 74338);
  }
  
  public final void v(final Bitmap paramBitmap)
  {
    GMTrace.i(9978148552704L, 74343);
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    final String str1 = com.tencent.mm.plugin.photoedit.g.a.Cv(com.tencent.mm.plugin.photoedit.b.a.ohM.toString());
    v.i("MicroMsg.DoodleCache", "[saveCacheToLocal] path:%s size:%s", new Object[] { str1, Integer.valueOf(gf(true)) });
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
        GMTrace.i(9976537939968L, 74331);
        try
        {
          d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, str1, true);
          GMTrace.o(9976537939968L, 74331);
          return;
        }
        catch (IOException localIOException)
        {
          v.printErrStackTrace("MicroMsg.DoodleCache", localIOException, "", new Object[0]);
          GMTrace.o(9976537939968L, 74331);
        }
      }
    }, "[saveCacheToLocal] mosaic path:" + str1);
    GMTrace.o(9978148552704L, 74343);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/cache/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */