package com.tencent.mm.ui.widget.celltextview.a;

import android.util.LruCache;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ui.widget.celltextview.c.c;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b
{
  private static b wwh;
  private static Object wwj;
  public LruCache<a, a> wwi;
  
  static
  {
    GMTrace.i(18744176803840L, 139655);
    wwj = new Object();
    GMTrace.o(18744176803840L, 139655);
  }
  
  private b()
  {
    GMTrace.i(18743774150656L, 139652);
    this.wwi = new LruCache(200);
    GMTrace.o(18743774150656L, 139652);
  }
  
  public static b caK()
  {
    GMTrace.i(18743908368384L, 139653);
    if (wwh == null) {}
    synchronized (wwj)
    {
      if (wwh == null) {
        wwh = new b();
      }
      ??? = wwh;
      GMTrace.o(18743908368384L, 139653);
      return (b)???;
    }
  }
  
  public final void a(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> paramLinkedList, ArrayList<c> paramArrayList, ArrayList<d> paramArrayList1)
  {
    GMTrace.i(18744042586112L, 139654);
    if (paramCharSequence == null) {}
    for (paramCharSequence = "";; paramCharSequence = paramCharSequence.toString())
    {
      paramCharSequence = new a(paramCharSequence, paramFloat1, paramFloat2);
      if (paramLinkedList != null)
      {
        if (paramCharSequence.wvZ == null) {
          paramCharSequence.wvZ = new LinkedList();
        }
        paramCharSequence.wvZ.addAll(paramLinkedList);
      }
      if (paramArrayList != null)
      {
        if (paramCharSequence.wwe == null) {
          paramCharSequence.wwe = new ArrayList();
        }
        paramCharSequence.wwe.addAll(paramArrayList);
      }
      paramCharSequence.al(paramArrayList1);
      this.wwi.put(paramCharSequence, paramCharSequence);
      GMTrace.o(18744042586112L, 139654);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */