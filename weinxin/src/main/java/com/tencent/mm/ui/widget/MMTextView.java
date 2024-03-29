package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.test.suitebuilder.annotation.Suppress;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public class MMTextView
  extends TextView
{
  private long gLu;
  private boolean wuF;
  public b wuG;
  private GestureDetector wuH;
  private boolean wuI;
  private boolean wuJ;
  private boolean wuK;
  private a wuL;
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(13054016225280L, 97260);
    this.wuF = false;
    this.wuG = null;
    this.wuH = null;
    this.wuI = false;
    this.wuJ = false;
    this.wuK = false;
    this.gLu = -1L;
    this.wuL = null;
    init();
    GMTrace.o(13054016225280L, 97260);
  }
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(13054150443008L, 97261);
    this.wuF = false;
    this.wuG = null;
    this.wuH = null;
    this.wuI = false;
    this.wuJ = false;
    this.wuK = false;
    this.gLu = -1L;
    this.wuL = null;
    init();
    GMTrace.o(13054150443008L, 97261);
  }
  
  private void init()
  {
    GMTrace.i(13054284660736L, 97262);
    this.wuH = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(13057640103936L, 97287);
        if (MMTextView.b(MMTextView.this) == null)
        {
          GMTrace.o(13057640103936L, 97287);
          return false;
        }
        boolean bool = MMTextView.b(MMTextView.this).dq(MMTextView.this);
        GMTrace.o(13057640103936L, 97287);
        return bool;
      }
    });
    GMTrace.o(13054284660736L, 97262);
  }
  
  public void cancelLongPress()
  {
    GMTrace.i(13054553096192L, 97264);
    v.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
    this.wuF = true;
    super.cancelLongPress();
    GMTrace.o(13054553096192L, 97264);
  }
  
  public int getBaseline()
  {
    GMTrace.i(13055224184832L, 97269);
    try
    {
      int i = super.getBaseline();
      GMTrace.o(13055224184832L, 97269);
      return i;
    }
    catch (Throwable localThrowable)
    {
      v.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
      GMTrace.o(13055224184832L, 97269);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(13054955749376L, 97267);
    try
    {
      super.onDraw(paramCanvas);
      GMTrace.o(13054955749376L, 97267);
      return;
    }
    catch (Throwable paramCanvas)
    {
      v.printErrStackTrace("MicroMsg.MMTextView", paramCanvas, "", new Object[0]);
      GMTrace.o(13054955749376L, 97267);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(13054821531648L, 97266);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      GMTrace.o(13054821531648L, 97266);
      return;
    }
    catch (Throwable localThrowable)
    {
      v.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
      GMTrace.o(13054821531648L, 97266);
    }
  }
  
  public boolean onPreDraw()
  {
    GMTrace.i(13055089967104L, 97268);
    try
    {
      boolean bool = super.onPreDraw();
      GMTrace.o(13055089967104L, 97268);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      GMTrace.o(13055089967104L, 97268);
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(13054418878464L, 97263);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.wuF)) {}
    for (int i = 1; i != 0; i = 0)
    {
      v.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
      GMTrace.o(13054418878464L, 97263);
      return true;
    }
    if (j == 0) {
      this.wuF = false;
    }
    if ((this.wuG != null) && (this.wuH != null)) {}
    for (boolean bool1 = this.wuH.onTouchEvent(paramMotionEvent);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.onTouchEvent(paramMotionEvent);
      }
      GMTrace.o(13054418878464L, 97263);
      return bool2;
    }
  }
  
  public boolean performLongClick()
  {
    GMTrace.i(13054687313920L, 97265);
    v.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
    this.wuF = true;
    boolean bool = super.performLongClick();
    GMTrace.o(13054687313920L, 97265);
    return bool;
  }
  
  @Suppress
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    GMTrace.i(14903402299392L, 111039);
    super.setText(paramCharSequence, paramBufferType);
    if ((this.wuL != null) && (this.wuI) && ((paramCharSequence instanceof Spannable)) && (((Spannable)paramCharSequence).getSpans(0, paramCharSequence.length(), Object.class) != null)) {
      this.wuL.a(paramCharSequence, this.gLu);
    }
    this.wuJ = false;
    GMTrace.o(14903402299392L, 111039);
  }
  
  public static abstract interface a
  {
    public abstract void a(CharSequence paramCharSequence, long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract boolean dq(View paramView);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/MMTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */