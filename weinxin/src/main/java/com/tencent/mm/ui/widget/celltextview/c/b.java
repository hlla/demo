package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.RectF;
import android.text.style.ClickableSpan;
import com.tencent.gmtrace.GMTrace;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public int abH;
  public int jjm;
  public int wd;
  public ClickableSpan wwl;
  public LinkedList<RectF> wwm;
  
  public b(ClickableSpan paramClickableSpan, int paramInt1, int paramInt2)
  {
    GMTrace.i(18755316875264L, 139738);
    this.abH = paramInt1;
    this.wd = paramInt2;
    this.jjm = -5908174;
    this.wwl = paramClickableSpan;
    GMTrace.o(18755316875264L, 139738);
  }
  
  public final boolean es(int paramInt1, int paramInt2)
  {
    GMTrace.i(18755451092992L, 139739);
    Iterator localIterator = this.wwm.iterator();
    while (localIterator.hasNext()) {
      if (((RectF)localIterator.next()).contains(paramInt1, paramInt2))
      {
        GMTrace.o(18755451092992L, 139739);
        return true;
      }
    }
    GMTrace.o(18755451092992L, 139739);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */