package com.tencent.mm.plugin.photoedit.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.photoedit.c.c;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Stack;

public final class a
  implements c<com.tencent.mm.plugin.photoedit.f.a>
{
  public Stack<com.tencent.mm.plugin.photoedit.f.a> ojp;
  private Stack<com.tencent.mm.plugin.photoedit.f.a> ojq;
  public Matrix ojr;
  
  public a()
  {
    GMTrace.i(9971571884032L, 74294);
    this.ojr = new Matrix();
    GMTrace.o(9971571884032L, 74294);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean, Object... paramVarArgs)
  {
    GMTrace.i(9972511408128L, 74301);
    GMTrace.o(9972511408128L, 74301);
  }
  
  public final void a(com.tencent.mm.plugin.photoedit.f.a parama)
  {
    GMTrace.i(9972377190400L, 74300);
    if (this.ojp != null) {
      this.ojp.push(parama);
    }
    GMTrace.o(9972377190400L, 74300);
  }
  
  public final void aSb()
  {
    GMTrace.i(9972108754944L, 74298);
    v.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.ojp.size()) });
    this.ojp.clear();
    if (this.ojq != null)
    {
      v.i("MicroMsg.CropCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.ojq.size()) });
      this.ojp.addAll(this.ojq);
    }
    GMTrace.o(9972108754944L, 74298);
  }
  
  public final com.tencent.mm.plugin.photoedit.f.a aSc()
  {
    GMTrace.i(9972242972672L, 74299);
    if (this.ojp.size() <= 0)
    {
      v.e("MicroMsg.CropCache", "[pop]");
      GMTrace.o(9972242972672L, 74299);
      return null;
    }
    com.tencent.mm.plugin.photoedit.f.a locala = (com.tencent.mm.plugin.photoedit.f.a)this.ojp.pop();
    GMTrace.o(9972242972672L, 74299);
    return locala;
  }
  
  public final Bitmap aSd()
  {
    GMTrace.i(9972914061312L, 74304);
    GMTrace.o(9972914061312L, 74304);
    return null;
  }
  
  public final boolean aSe()
  {
    GMTrace.i(9973048279040L, 74305);
    if (gf(true) > 0)
    {
      GMTrace.o(9973048279040L, 74305);
      return true;
    }
    GMTrace.o(9973048279040L, 74305);
    return false;
  }
  
  public final com.tencent.mm.plugin.photoedit.f.a aSf()
  {
    GMTrace.i(9973182496768L, 74306);
    if ((this.ojp != null) && (this.ojp.size() > 0))
    {
      com.tencent.mm.plugin.photoedit.f.a locala = (com.tencent.mm.plugin.photoedit.f.a)this.ojp.peek();
      GMTrace.o(9973182496768L, 74306);
      return locala;
    }
    GMTrace.o(9973182496768L, 74306);
    return null;
  }
  
  public final void ge(boolean paramBoolean)
  {
    GMTrace.i(9971974537216L, 74297);
    v.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.ojp.size()) });
    if (this.ojq != null) {
      this.ojq.clear();
    }
    this.ojq = ((Stack)this.ojp.clone());
    if (paramBoolean) {
      this.ojp.clear();
    }
    GMTrace.o(9971974537216L, 74297);
  }
  
  public final int gf(boolean paramBoolean)
  {
    GMTrace.i(9973316714496L, 74307);
    int i;
    if (paramBoolean)
    {
      if (this.ojp != null)
      {
        i = this.ojp.size();
        GMTrace.o(9973316714496L, 74307);
        return i;
      }
      GMTrace.o(9973316714496L, 74307);
      return 0;
    }
    if (this.ojq != null)
    {
      i = this.ojq.size();
      GMTrace.o(9973316714496L, 74307);
      return i;
    }
    GMTrace.o(9973316714496L, 74307);
    return 0;
  }
  
  public final void h(Canvas paramVarArgs)
  {
    GMTrace.i(9972645625856L, 74302);
    GMTrace.o(9972645625856L, 74302);
  }
  
  public final void onCreate()
  {
    GMTrace.i(9971706101760L, 74295);
    v.i("MicroMsg.CropCache", "[onCreate]");
    this.ojp = new Stack();
    GMTrace.o(9971706101760L, 74295);
  }
  
  public final void onDestroy()
  {
    GMTrace.i(9971840319488L, 74296);
    if (this.ojp != null) {
      this.ojp.clear();
    }
    if (this.ojq != null) {
      this.ojq.clear();
    }
    this.ojr.reset();
    GMTrace.o(9971840319488L, 74296);
  }
  
  public final void v(Bitmap paramBitmap)
  {
    GMTrace.i(9972779843584L, 74303);
    GMTrace.o(9972779843584L, 74303);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/cache/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */