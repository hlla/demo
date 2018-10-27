package android.support.v7.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class UnPressableLinearLayout
  extends LinearLayout
{
  public UnPressableLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public UnPressableLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/UnPressableLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */