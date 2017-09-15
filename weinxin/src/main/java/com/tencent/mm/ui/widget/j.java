package com.tencent.mm.ui.widget;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<WeakReference<a>> wvv;
  
  static
  {
    GMTrace.i(1647522611200L, 12275);
    wvv = new LinkedList();
    GMTrace.o(1647522611200L, 12275);
  }
  
  public static void a(a parama)
  {
    GMTrace.i(1646985740288L, 12271);
    v.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", new Object[] { Integer.valueOf(wvv.size()), parama });
    parama = new WeakReference(parama);
    wvv.add(0, parama);
    GMTrace.o(1646985740288L, 12271);
  }
  
  public static void ax(float paramFloat)
  {
    GMTrace.i(1647254175744L, 12273);
    if (wvv.size() <= 0)
    {
      v.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      GMTrace.o(1647254175744L, 12273);
      return;
    }
    a locala = (a)((WeakReference)wvv.get(0)).get();
    if (locala == null)
    {
      v.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      GMTrace.o(1647254175744L, 12273);
      return;
    }
    locala.O(paramFloat);
    v.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", new Object[] { Float.valueOf(paramFloat), locala });
    GMTrace.o(1647254175744L, 12273);
  }
  
  public static boolean b(a parama)
  {
    GMTrace.i(1647119958016L, 12272);
    int j = wvv.size();
    v.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", new Object[] { Integer.valueOf(j), parama });
    if (parama == null)
    {
      GMTrace.o(1647119958016L, 12272);
      return true;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    for (;;)
    {
      if (i < wvv.size())
      {
        if (parama == ((WeakReference)wvv.get(i)).get())
        {
          wvv.remove(i);
          v.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        if ((parama.VC()) || (localLinkedList.size() != j)) {
          break;
        }
        v.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
        GMTrace.o(1647119958016L, 12272);
        return false;
      }
      localLinkedList.add(0, Integer.valueOf(i));
      i += 1;
    }
    Iterator localIterator = localLinkedList.iterator();
    if (localIterator.hasNext())
    {
      parama = (Integer)localIterator.next();
      parama = (WeakReference)wvv.remove(parama.intValue());
      if (parama != null) {}
      for (parama = parama.get();; parama = "NULL-CALLBACK")
      {
        v.d("MicroMsg.SwipeBackHelper", "popCallback, popup %s", new Object[] { parama });
        break;
      }
    }
    boolean bool = localLinkedList.isEmpty();
    GMTrace.o(1647119958016L, 12272);
    return bool;
  }
  
  public static void u(boolean paramBoolean, int paramInt)
  {
    GMTrace.i(1647388393472L, 12274);
    if (wvv.size() <= 0)
    {
      v.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      GMTrace.o(1647388393472L, 12274);
      return;
    }
    a locala = (a)((WeakReference)wvv.get(0)).get();
    if (locala == null)
    {
      v.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      GMTrace.o(1647388393472L, 12274);
      return;
    }
    locala.d(paramBoolean, paramInt);
    v.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), locala });
    GMTrace.o(1647388393472L, 12274);
  }
  
  public static abstract interface a
  {
    public abstract void O(float paramFloat);
    
    public abstract boolean VC();
    
    public abstract void d(boolean paramBoolean, int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */