package android.support.design.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ac;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout
  extends LinearLayout
  implements s
{
  private Button a;
  private int b;
  private int c;
  private TextView d;
  
  public SnackbarContentLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, t.a);
    this.c = paramContext.getDimensionPixelSize(t.b, -1);
    this.b = paramContext.getDimensionPixelSize(t.d, -1);
    paramContext.recycle();
  }
  
  private final boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != getOrientation()) {
      setOrientation(paramInt1);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView;
      if ((this.d.getPaddingTop() != paramInt2) || (this.d.getPaddingBottom() != paramInt3))
      {
        localTextView = this.d;
        if (!ac.B(localTextView)) {
          break label75;
        }
        ac.a(localTextView, ac.n(localTextView), paramInt2, ac.o(localTextView), paramInt3);
      }
      for (;;)
      {
        bool = true;
        return bool;
        label75:
        localTextView.setPadding(localTextView.getPaddingLeft(), paramInt2, localTextView.getPaddingRight(), paramInt3);
      }
    }
  }
  
  public final void a()
  {
    this.d.setAlpha(0.0F);
    this.d.animate().alpha(1.0F).setDuration(180L).setStartDelay(70L).start();
    if (this.a.getVisibility() == 0)
    {
      this.a.setAlpha(0.0F);
      this.a.animate().alpha(1.0F).setDuration(180L).setStartDelay(70L).start();
    }
  }
  
  public final void b()
  {
    this.d.setAlpha(1.0F);
    this.d.animate().alpha(0.0F).setDuration(180L).setStartDelay(0L).start();
    if (this.a.getVisibility() == 0)
    {
      this.a.setAlpha(1.0F);
      this.a.animate().alpha(0.0F).setDuration(180L).setStartDelay(0L).start();
    }
  }
  
  public Button getActionView()
  {
    return this.a;
  }
  
  public TextView getMessageView()
  {
    return this.d;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((TextView)findViewById(2131429269));
    this.a = ((Button)findViewById(2131429268));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (this.c > 0)
    {
      j = getMeasuredWidth();
      k = this.c;
      i = paramInt1;
      if (j > k)
      {
        i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    paramInt1 = getResources().getDimensionPixelSize(2131165574);
    int j = getResources().getDimensionPixelSize(2131165573);
    int k = this.d.getLayout().getLineCount();
    if ((k > 1) && (this.b > 0) && (this.a.getMeasuredWidth() > this.b)) {
      if (a(1, paramInt1, paramInt1 - j)) {
        super.onMeasure(i, paramInt2);
      }
    }
    label153:
    for (;;)
    {
      return;
      if (k <= 1) {
        paramInt1 = j;
      }
      for (;;)
      {
        if (!a(0, paramInt1, paramInt1)) {
          break label153;
        }
        break;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/SnackbarContentLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */