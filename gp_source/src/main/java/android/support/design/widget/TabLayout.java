package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.design.g.c;
import android.support.design.g.k;
import android.support.v4.g.r;
import android.support.v4.g.t;
import android.support.v4.view.am;
import android.util.AttributeSet;

@am
@Deprecated
public class TabLayout
  extends c
{
  private static final r u = new t(16);
  
  public TabLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final boolean a(k paramk)
  {
    return u.a((q)paramk);
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    super.setSelectedTabIndicatorColor(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    super.setSelectedTabIndicatorHeight(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    super.setTabGravity(paramInt);
  }
  
  public void setTabMode(int paramInt)
  {
    super.setTabMode(paramInt);
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    super.setTabTextColors(paramColorStateList);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/widget/TabLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */