package com.tencent.mm.kiss.widget.textview.b;

import android.text.Layout;
import android.text.NoCopySpan.Concrete;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kiss.widget.textview.a;

public final class b
{
  private static b hba;
  private static Object hbb;
  
  static
  {
    GMTrace.i(431644213248L, 3216);
    hbb = new NoCopySpan.Concrete();
    GMTrace.o(431644213248L, 3216);
  }
  
  public b()
  {
    GMTrace.i(431107342336L, 3212);
    GMTrace.o(431107342336L, 3212);
  }
  
  public static void a(Spannable paramSpannable)
  {
    GMTrace.i(431375777792L, 3214);
    Selection.removeSelection(paramSpannable);
    paramSpannable.removeSpan(hbb);
    GMTrace.o(431375777792L, 3214);
  }
  
  public static boolean a(View paramView, Layout paramLayout, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    GMTrace.i(431241560064L, 3213);
    int i = paramMotionEvent.getAction();
    if (!(paramView instanceof a))
    {
      GMTrace.o(431241560064L, 3213);
      return false;
    }
    paramView = (a)paramView;
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((j < paramView.vT()) || (j > paramLayout.getWidth() + paramView.vT()))
      {
        GMTrace.o(431241560064L, 3213);
        return false;
      }
      if ((k < paramView.vU()) || (k > paramLayout.getHeight() + paramView.vU()))
      {
        GMTrace.o(431241560064L, 3213);
        return false;
      }
      int m = paramView.vT();
      int n = paramView.vU();
      int i1 = paramView.getScrollX();
      j = paramLayout.getOffsetForHorizontal(paramLayout.getLineForVertical(k - n + paramView.getScrollY()), j - m + i1);
      paramView = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (paramView.length != 0)
      {
        if (i == 1)
        {
          GMTrace.o(431241560064L, 3213);
          return true;
        }
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(paramView[0]), paramSpannable.getSpanEnd(paramView[0]));
        GMTrace.o(431241560064L, 3213);
        return true;
      }
      Selection.removeSelection(paramSpannable);
    }
    GMTrace.o(431241560064L, 3213);
    return false;
  }
  
  public static b wg()
  {
    GMTrace.i(431509995520L, 3215);
    if (hba == null) {
      hba = new b();
    }
    b localb = hba;
    GMTrace.o(431509995520L, 3215);
    return localb;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kiss/widget/textview/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */