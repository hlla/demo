package android.support.v7.widget;

import android.content.res.Configuration;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;

public final class ge
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  static
  {
    new DecelerateInterpolator();
  }
  
  public final void onAttachedToWindow()
  {
    throw new NoSuchMethodError();
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    throw new NoSuchMethodError();
  }
  
  public final void onDetachedFromWindow()
  {
    throw new NoSuchMethodError();
  }
  
  public final void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    throw new NoSuchMethodError();
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    throw new NoSuchMethodError();
  }
  
  public final void onNothingSelected(AdapterView paramAdapterView)
  {
    throw new NoSuchMethodError();
  }
  
  public final void setAllowCollapse(boolean paramBoolean) {}
  
  public final void setContentHeight(int paramInt)
  {
    requestLayout();
  }
  
  public final void setTabSelected(int paramInt)
  {
    throw new NullPointerException();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */