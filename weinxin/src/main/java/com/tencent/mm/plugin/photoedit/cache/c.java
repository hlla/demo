package com.tencent.mm.plugin.photoedit.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.photoedit.f.e;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class c
  implements com.tencent.mm.plugin.photoedit.c.c<com.tencent.mm.plugin.photoedit.f.c>, Iterable<com.tencent.mm.plugin.photoedit.f.c>
{
  public Stack<com.tencent.mm.plugin.photoedit.f.c> ojp;
  private Stack<com.tencent.mm.plugin.photoedit.f.c> ojq;
  
  public c()
  {
    GMTrace.i(9978819641344L, 74348);
    GMTrace.o(9978819641344L, 74348);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean, Object... paramVarArgs)
  {
    GMTrace.i(9979490729984L, 74353);
    v.i("MicroMsg.EmojiAndTextCache", "[onDrawCache] isOverDraw:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      paramVarArgs = this.ojp.iterator();
      while (paramVarArgs.hasNext())
      {
        com.tencent.mm.plugin.photoedit.f.c localc = (com.tencent.mm.plugin.photoedit.f.c)paramVarArgs.next();
        if (!localc.ksK) {
          localc.draw(paramCanvas);
        }
      }
      GMTrace.o(9979490729984L, 74353);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof com.tencent.mm.plugin.photoedit.f.c)))
    {
      paramVarArgs = (com.tencent.mm.plugin.photoedit.f.c)paramVarArgs[0];
      if (!paramVarArgs.ksK) {
        paramVarArgs.draw(paramCanvas);
      }
    }
    GMTrace.o(9979490729984L, 74353);
  }
  
  public final void a(com.tencent.mm.plugin.photoedit.f.c paramc)
  {
    GMTrace.i(9980564471808L, 74361);
    if (paramc == null)
    {
      GMTrace.o(9980564471808L, 74361);
      return;
    }
    int i = this.ojp.indexOf(paramc);
    this.ojp.remove(i);
    this.ojp.push(paramc);
    GMTrace.o(9980564471808L, 74361);
  }
  
  public final void aSb()
  {
    GMTrace.i(9979356512256L, 74352);
    v.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[] { Integer.valueOf(this.ojp.size()), Boolean.valueOf(false) });
    this.ojp.clear();
    if (this.ojq != null)
    {
      v.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.ojq.size()) });
      this.ojp.addAll(this.ojq);
    }
    v.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[] { Integer.valueOf(this.ojp.size()) });
    Iterator localIterator = this.ojp.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.photoedit.f.c)localIterator.next()).aSy();
    }
    GMTrace.o(9979356512256L, 74352);
  }
  
  public final Bitmap aSd()
  {
    GMTrace.i(9979893383168L, 74356);
    GMTrace.o(9979893383168L, 74356);
    return null;
  }
  
  public final boolean aSe()
  {
    GMTrace.i(9980027600896L, 74357);
    if (this.ojp.size() > 0)
    {
      GMTrace.o(9980027600896L, 74357);
      return true;
    }
    GMTrace.o(9980027600896L, 74357);
    return false;
  }
  
  public final com.tencent.mm.plugin.photoedit.f.c aSg()
  {
    GMTrace.i(9980161818624L, 74358);
    com.tencent.mm.plugin.photoedit.f.c localc = (com.tencent.mm.plugin.photoedit.f.c)this.ojp.pop();
    GMTrace.o(9980161818624L, 74358);
    return localc;
  }
  
  public final com.tencent.mm.plugin.photoedit.f.c aSh()
  {
    GMTrace.i(9980430254080L, 74360);
    if ((this.ojp != null) && (this.ojp.size() > 0))
    {
      com.tencent.mm.plugin.photoedit.f.c localc = (com.tencent.mm.plugin.photoedit.f.c)this.ojp.peek();
      GMTrace.o(9980430254080L, 74360);
      return localc;
    }
    GMTrace.o(9980430254080L, 74360);
    return null;
  }
  
  public final int[] aSi()
  {
    GMTrace.i(9980832907264L, 74363);
    int[] arrayOfInt = new int[2];
    if (this.ojq != null)
    {
      Iterator localIterator = this.ojq.iterator();
      while (localIterator.hasNext()) {
        if (((com.tencent.mm.plugin.photoedit.f.c)localIterator.next() instanceof e)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    GMTrace.o(9980832907264L, 74363);
    return arrayOfInt;
  }
  
  public final ListIterator<com.tencent.mm.plugin.photoedit.f.c> aSj()
  {
    GMTrace.i(9980967124992L, 74364);
    ListIterator localListIterator = this.ojp.listIterator(this.ojp.size());
    GMTrace.o(9980967124992L, 74364);
    return localListIterator;
  }
  
  public final void b(com.tencent.mm.plugin.photoedit.f.c paramc)
  {
    GMTrace.i(9980698689536L, 74362);
    if (this.ojp != null) {
      this.ojp.push(paramc);
    }
    GMTrace.o(9980698689536L, 74362);
  }
  
  public final void ge(boolean paramBoolean)
  {
    GMTrace.i(9979222294528L, 74351);
    v.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[] { Integer.valueOf(this.ojp.size()), Boolean.valueOf(paramBoolean) });
    if (this.ojq != null) {
      this.ojq.clear();
    }
    this.ojq = new Stack();
    Iterator localIterator = this.ojp.iterator();
    com.tencent.mm.plugin.photoedit.f.c localc;
    while (localIterator.hasNext())
    {
      localc = (com.tencent.mm.plugin.photoedit.f.c)localIterator.next();
      this.ojq.push(localc.aSD());
    }
    v.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[] { Integer.valueOf(this.ojq.size()) });
    if (paramBoolean)
    {
      this.ojp.clear();
      localIterator = this.ojq.iterator();
      while (localIterator.hasNext())
      {
        localc = (com.tencent.mm.plugin.photoedit.f.c)localIterator.next();
        v.d("MicroMsg.EmojiItem", "[recycleBitmap]");
        if ((localc.okG != null) && (!localc.okG.isRecycled())) {
          localc.okG.recycle();
        }
      }
    }
    GMTrace.o(9979222294528L, 74351);
  }
  
  public final int gf(boolean paramBoolean)
  {
    GMTrace.i(9980296036352L, 74359);
    int i;
    if (paramBoolean)
    {
      if (this.ojp != null)
      {
        i = this.ojp.size();
        GMTrace.o(9980296036352L, 74359);
        return i;
      }
      GMTrace.o(9980296036352L, 74359);
      return 0;
    }
    if (this.ojq != null)
    {
      i = this.ojq.size();
      GMTrace.o(9980296036352L, 74359);
      return i;
    }
    GMTrace.o(9980296036352L, 74359);
    return 0;
  }
  
  public final void h(Canvas paramVarArgs)
  {
    GMTrace.i(9979624947712L, 74354);
    Iterator localIterator = this.ojp.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.photoedit.f.c localc = (com.tencent.mm.plugin.photoedit.f.c)localIterator.next();
      if (!localc.ksK) {
        localc.draw(paramVarArgs);
      }
    }
    GMTrace.o(9979624947712L, 74354);
  }
  
  public final void onCreate()
  {
    GMTrace.i(9978953859072L, 74349);
    v.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
    this.ojp = new Stack();
    GMTrace.o(9978953859072L, 74349);
  }
  
  public final void onDestroy()
  {
    GMTrace.i(9979088076800L, 74350);
    v.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
    Iterator localIterator;
    if (this.ojp != null)
    {
      localIterator = this.ojp.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.photoedit.f.c)localIterator.next()).clear();
      }
      this.ojp.clear();
    }
    if (this.ojq != null)
    {
      localIterator = this.ojq.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.photoedit.f.c)localIterator.next()).clear();
      }
      this.ojq.clear();
    }
    GMTrace.o(9979088076800L, 74350);
  }
  
  public final void v(Bitmap paramBitmap)
  {
    GMTrace.i(9979759165440L, 74355);
    GMTrace.o(9979759165440L, 74355);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/cache/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */