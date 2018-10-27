package android.support.design.internal;

import android.content.Context;
import android.support.v4.view.ac;
import android.support.v7.widget.al;
import android.util.AttributeSet;
import android.widget.Checkable;

public class CheckableImageButton
  extends al
  implements Checkable
{
  private static final int[] a = { 16842912 };
  private boolean b;
  
  public CheckableImageButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969013);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ac.a(this, new a(this));
  }
  
  public boolean isChecked()
  {
    return this.b;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.b) {
      return mergeDrawableStates(super.onCreateDrawableState(a.length + paramInt), a);
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
  }
  
  public void toggle()
  {
    setChecked(this.b ^ true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/CheckableImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */