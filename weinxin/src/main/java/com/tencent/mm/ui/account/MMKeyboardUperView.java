package com.tencent.mm.ui.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.gmtrace.GMTrace;

public class MMKeyboardUperView
  extends ScrollView
{
  private int defaultHeight;
  private View uXA;
  private Runnable uXB;
  private Runnable uXC;
  
  public MMKeyboardUperView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2780051800064L, 20713);
    this.defaultHeight = -1;
    this.uXB = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2642210193408L, 19686);
        MMKeyboardUperView.this.fullScroll(130);
        MMKeyboardUperView.a(MMKeyboardUperView.this).setVisibility(4);
        GMTrace.o(2642210193408L, 19686);
      }
    };
    this.uXC = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2567450918912L, 19129);
        MMKeyboardUperView.a(MMKeyboardUperView.this).setVisibility(0);
        GMTrace.o(2567450918912L, 19129);
      }
    };
    GMTrace.o(2780051800064L, 20713);
  }
  
  public MMKeyboardUperView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(2779917582336L, 20712);
    this.defaultHeight = -1;
    this.uXB = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2642210193408L, 19686);
        MMKeyboardUperView.this.fullScroll(130);
        MMKeyboardUperView.a(MMKeyboardUperView.this).setVisibility(4);
        GMTrace.o(2642210193408L, 19686);
      }
    };
    this.uXC = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2567450918912L, 19129);
        MMKeyboardUperView.a(MMKeyboardUperView.this).setVisibility(0);
        GMTrace.o(2567450918912L, 19129);
      }
    };
    GMTrace.o(2779917582336L, 20712);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/MMKeyboardUperView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */