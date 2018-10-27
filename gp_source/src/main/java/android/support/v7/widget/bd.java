package android.support.v7.widget;

import android.view.View;

public final class bd
  extends fz
{
  public bd(View paramView)
  {
    super(paramView);
  }
  
  public final String toString()
  {
    String str1 = super.toString();
    String str2 = Integer.toString(this.g);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 12 + String.valueOf(str2).length());
    localStringBuilder.append(str1);
    localStringBuilder.append(" ViewResId: ");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */