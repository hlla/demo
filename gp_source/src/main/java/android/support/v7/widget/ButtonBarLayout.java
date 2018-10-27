package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ac;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ButtonBarLayout
  extends LinearLayout
{
  private boolean a;
  private int b = -1;
  
  public ButtonBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.aN);
    this.a = paramContext.getBoolean(a.aO, true);
    paramContext.recycle();
  }
  
  private final int a(int paramInt)
  {
    int j = getChildCount();
    while (paramInt < j)
    {
      i = paramInt;
      if (getChildAt(paramInt).getVisibility() == 0) {
        return i;
      }
      paramInt += 1;
    }
    int i = -1;
    return i;
  }
  
  private final void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  private final boolean a()
  {
    boolean bool = true;
    if (getOrientation() != 1) {
      bool = false;
    }
    return bool;
  }
  
  public int getMinimumHeight()
  {
    return Math.max(0, super.getMinimumHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = View.MeasureSpec.getSize(paramInt1);
    if (this.a)
    {
      if ((i > this.b) && (a())) {
        a(false);
      }
      this.b = i;
    }
    int j;
    if (!a()) {
      if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
      {
        i = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
        j = 1;
      }
    }
    for (;;)
    {
      super.onMeasure(i, paramInt2);
      if ((this.a) && (!a()) && ((getMeasuredWidthAndState() & 0xFF000000) == 16777216)) {
        a(true);
      }
      for (;;)
      {
        super.onMeasure(paramInt1, paramInt2);
        label225:
        do
        {
          i = a(0);
          paramInt1 = k;
          if (i >= 0)
          {
            View localView = getChildAt(i);
            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
            paramInt1 = getPaddingTop();
            paramInt2 = localView.getMeasuredHeight() + paramInt1 + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
            if (!a()) {
              break label225;
            }
            i = a(i + 1);
            paramInt1 = paramInt2;
            if (i < 0) {}
          }
          for (paramInt1 = paramInt2 + (getChildAt(i).getPaddingTop() + (int)(getResources().getDisplayMetrics().density * 16.0F));; paramInt1 = paramInt2 + getPaddingBottom())
          {
            if (ac.s(this) != paramInt1) {
              setMinimumHeight(paramInt1);
            }
            return;
          }
        } while (j == 0);
      }
      i = paramInt1;
      j = 0;
      continue;
      i = paramInt1;
      j = 0;
    }
  }
  
  public void setAllowStacking(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      if ((!this.a) && (getOrientation() == 1)) {
        a(false);
      }
      requestLayout();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ButtonBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */