package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.ui.widget.celltextview.CellTextView;
import com.tencent.mm.ui.widget.celltextview.e.a;

public final class ev
  extends a
{
  private k xog;
  
  public ev(k paramk)
  {
    GMTrace.i(17907463487488L, 133421);
    this.xog = paramk;
    GMTrace.o(17907463487488L, 133421);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GMTrace.i(17907597705216L, 133422);
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    paramView.setTag(R.h.cJn, new int[] { i, j });
    if ((paramView instanceof CellTextView))
    {
      CellTextView localCellTextView = (CellTextView)paramView;
      if (localCellTextView.wwc)
      {
        bool = this.xog.onTouch(localCellTextView.wwb, paramMotionEvent);
        GMTrace.o(17907597705216L, 133422);
        return bool;
      }
    }
    boolean bool = super.onTouch(paramView, paramMotionEvent);
    GMTrace.o(17907597705216L, 133422);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */