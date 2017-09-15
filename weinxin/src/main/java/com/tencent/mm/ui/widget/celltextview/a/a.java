package com.tencent.mm.ui.widget.celltextview.a;

import android.graphics.Paint;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.celltextview.c.b;
import com.tencent.mm.ui.widget.celltextview.c.c;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static Paint wwg;
  public String jpC;
  public float mFg;
  public ArrayList<d> wvY;
  public LinkedList<b> wvZ;
  public ArrayList<c> wwe;
  public float wwf;
  
  static
  {
    GMTrace.i(18744982110208L, 139661);
    wwg = new Paint();
    GMTrace.o(18744982110208L, 139661);
  }
  
  public a(String paramString, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(18744311021568L, 139656);
    this.jpC = paramString;
    this.mFg = paramFloat1;
    this.wwf = paramFloat2;
    GMTrace.o(18744311021568L, 139656);
  }
  
  private int caJ()
  {
    GMTrace.i(18744847892480L, 139660);
    Iterator localIterator = this.wvY.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((d)localIterator.next()).caO() + i) {}
    GMTrace.o(18744847892480L, 139660);
    return i;
  }
  
  public final void al(ArrayList<d> paramArrayList)
  {
    GMTrace.i(18744445239296L, 139657);
    if (paramArrayList == null)
    {
      GMTrace.o(18744445239296L, 139657);
      return;
    }
    if (this.wvY == null) {
      this.wvY = new ArrayList();
    }
    this.wvY.addAll(paramArrayList);
    GMTrace.o(18744445239296L, 139657);
  }
  
  public final boolean equals(Object paramObject)
  {
    GMTrace.i(18744713674752L, 139659);
    if (this == paramObject)
    {
      GMTrace.o(18744713674752L, 139659);
      return true;
    }
    if (getClass() == paramObject.getClass())
    {
      paramObject = (a)paramObject;
      if ((this.wwf == ((a)paramObject).wwf) && (this.mFg == ((a)paramObject).mFg) && (this.jpC.equals(((a)paramObject).jpC)) && (caJ() == ((a)paramObject).caJ()))
      {
        GMTrace.o(18744713674752L, 139659);
        return true;
      }
      GMTrace.o(18744713674752L, 139659);
      return false;
    }
    GMTrace.o(18744713674752L, 139659);
    return false;
  }
  
  public final int hashCode()
  {
    GMTrace.i(18744579457024L, 139658);
    wwg.setTextSize(this.mFg);
    if (this.jpC != null) {}
    for (int i = (int)wwg.measureText(this.jpC);; i = 0)
    {
      int j = caJ();
      v.d("CellTextCache", "width:%s hash:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      GMTrace.o(18744579457024L, 139658);
      return i + j;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */