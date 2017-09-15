package com.tencent.mm.ui.widget.celltextview.e;

import android.os.Handler;
import android.os.Looper;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.celltextview.CellTextView;
import com.tencent.mm.ui.widget.celltextview.b.a.b;
import com.tencent.mm.ui.widget.celltextview.c.b;
import java.util.Iterator;
import java.util.List;

public class a
  implements View.OnTouchListener
{
  private static int sSj;
  private static Handler wwU;
  public boolean sSi;
  private b wwQ;
  public CellTextView wwV;
  private a wwW;
  
  static
  {
    GMTrace.i(18743639932928L, 139651);
    wwU = new Handler(Looper.getMainLooper());
    sSj = ViewConfiguration.getLongPressTimeout();
    GMTrace.o(18743639932928L, 139651);
  }
  
  public a()
  {
    GMTrace.i(18743237279744L, 139648);
    this.sSi = false;
    this.wwW = new a();
    GMTrace.o(18743237279744L, 139648);
  }
  
  private void caU()
  {
    GMTrace.i(18743505715200L, 139650);
    this.sSi = false;
    wwU.removeCallbacks(this.wwW);
    GMTrace.o(18743505715200L, 139650);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GMTrace.i(18743371497472L, 139649);
    if (!(paramView instanceof CellTextView))
    {
      GMTrace.o(18743371497472L, 139649);
      return false;
    }
    this.wwV = ((CellTextView)paramView);
    paramView = this.wwV.caH().caL();
    if ((paramView == null) || (paramView.size() <= 0))
    {
      GMTrace.o(18743371497472L, 139649);
      return false;
    }
    int i = (int)paramMotionEvent.getX() - this.wwV.getPaddingRight();
    int j = (int)paramMotionEvent.getY() - this.wwV.getPaddingTop();
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      GMTrace.o(18743371497472L, 139649);
      return false;
      this.wwQ = null;
      paramView = paramView.iterator();
      while (paramView.hasNext())
      {
        paramMotionEvent = (b)paramView.next();
        if (paramMotionEvent.es(i, j))
        {
          this.wwQ = paramMotionEvent;
          this.wwV.caH().a(paramMotionEvent);
          this.wwV.invalidate();
        }
      }
      if (this.wwV != null)
      {
        wwU.postDelayed(this.wwW, sSj);
        continue;
        if ((this.wwQ != null) && (!this.wwQ.es(i, j)))
        {
          this.wwQ = null;
          this.wwV.caH().a(null);
          this.wwV.invalidate();
          continue;
          if ((!this.sSi) && (this.wwQ != null) && (this.wwQ.es(i, j)))
          {
            paramView = this.wwQ;
            paramMotionEvent = this.wwV;
            paramView.wwl.onClick(paramMotionEvent.getView());
          }
          caU();
          if (this.wwQ != null)
          {
            this.wwV.caH().a(null);
            this.wwV.invalidate();
          }
          this.wwQ = null;
          continue;
          caU();
          if (this.wwQ != null)
          {
            this.wwV.caH().a(null);
            this.wwV.invalidate();
          }
          this.wwQ = null;
        }
      }
    }
  }
  
  final class a
    implements Runnable
  {
    a()
    {
      GMTrace.i(18742968844288L, 139646);
      GMTrace.o(18742968844288L, 139646);
    }
    
    public final void run()
    {
      GMTrace.i(18743103062016L, 139647);
      if ((a.this.wwV != null) && (a.this.wwV.isPressed()))
      {
        v.d("MicroMsg.CellTouchListener", "long pressed timeout");
        a.this.sSi = true;
        a.this.wwV.caH().a(null);
        a.this.wwV.invalidate();
      }
      GMTrace.o(18743103062016L, 139647);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */