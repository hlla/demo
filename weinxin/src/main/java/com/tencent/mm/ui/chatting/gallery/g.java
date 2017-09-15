package com.tencent.mm.ui.chatting.gallery;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Iterator;

public final class g
{
  public ArrayList<au> vOh;
  public boolean vPI;
  ArrayList<b> vPJ;
  
  public g()
  {
    GMTrace.i(2471485243392L, 18414);
    this.vOh = new ArrayList();
    this.vPI = false;
    this.vPJ = new ArrayList();
    GMTrace.o(2471485243392L, 18414);
  }
  
  private void bWH()
  {
    GMTrace.i(2472424767488L, 18421);
    Iterator localIterator = this.vPJ.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).bWG();
    }
    GMTrace.o(2472424767488L, 18421);
  }
  
  private au eR(long paramLong)
  {
    GMTrace.i(2471753678848L, 18416);
    Iterator localIterator = this.vOh.iterator();
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      if (localau.field_msgId == paramLong)
      {
        GMTrace.o(2471753678848L, 18416);
        return localau;
      }
    }
    GMTrace.o(2471753678848L, 18416);
    return null;
  }
  
  public final void a(b paramb)
  {
    GMTrace.i(14964739801088L, 111496);
    if (paramb == null)
    {
      GMTrace.o(14964739801088L, 111496);
      return;
    }
    this.vPJ.remove(paramb);
    this.vPJ.add(paramb);
    GMTrace.o(14964739801088L, 111496);
  }
  
  public final void bh(au paramau)
  {
    GMTrace.i(2471619461120L, 18415);
    if (paramau == null)
    {
      GMTrace.o(2471619461120L, 18415);
      return;
    }
    v.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[] { Long.valueOf(paramau.field_msgId) });
    this.vOh.remove(paramau);
    this.vOh.remove(eR(paramau.field_msgId));
    this.vOh.add(paramau);
    bWH();
    GMTrace.o(2471619461120L, 18415);
  }
  
  public final void bi(au paramau)
  {
    GMTrace.i(2471887896576L, 18417);
    if (paramau == null)
    {
      GMTrace.o(2471887896576L, 18417);
      return;
    }
    v.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[] { Long.valueOf(paramau.field_msgId) });
    this.vOh.remove(paramau);
    this.vOh.remove(eR(paramau.field_msgId));
    bWH();
    GMTrace.o(2471887896576L, 18417);
  }
  
  public final boolean bj(au paramau)
  {
    GMTrace.i(2472290549760L, 18420);
    if (paramau == null)
    {
      GMTrace.o(2472290549760L, 18420);
      return false;
    }
    Iterator localIterator = this.vOh.iterator();
    while (localIterator.hasNext()) {
      if (((au)localIterator.next()).field_msgId == paramau.field_msgId)
      {
        GMTrace.o(2472290549760L, 18420);
        return true;
      }
    }
    GMTrace.o(2472290549760L, 18420);
    return false;
  }
  
  public final void clear()
  {
    GMTrace.i(2472022114304L, 18418);
    v.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
    this.vOh.clear();
    Iterator localIterator = this.vPJ.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).clear();
    }
    GMTrace.o(2472022114304L, 18418);
  }
  
  public final void detach()
  {
    GMTrace.i(2472156332032L, 18419);
    this.vPJ.clear();
    clear();
    this.vPI = false;
    GMTrace.o(2472156332032L, 18419);
  }
  
  private static final class a
  {
    public static final g vPK;
    
    static
    {
      GMTrace.i(2470679937024L, 18408);
      vPK = new g();
      GMTrace.o(2470679937024L, 18408);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bWG();
    
    public abstract void clear();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */