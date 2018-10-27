package android.support.design.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class p
  extends ImageButton
{
  private int a = getVisibility();
  
  public p(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public p(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public p(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    super.setVisibility(paramInt);
    if (paramBoolean) {
      this.a = paramInt;
    }
  }
  
  public final int getUserSetVisibility()
  {
    return this.a;
  }
  
  public void setVisibility(int paramInt)
  {
    a(paramInt, true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */