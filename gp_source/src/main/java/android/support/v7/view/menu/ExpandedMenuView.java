package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.hf;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public final class ExpandedMenuView
  extends ListView
  implements ah, r, AdapterView.OnItemClickListener
{
  private static final int[] a = { 16842964, 16843049 };
  private p b;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    paramContext = hf.a(paramContext, paramAttributeSet, a, paramInt, 0);
    if (paramContext.g(0)) {
      setBackgroundDrawable(paramContext.a(0));
    }
    if (paramContext.g(1)) {
      setDivider(paramContext.a(1));
    }
    paramContext.c.recycle();
  }
  
  public final void a(p paramp)
  {
    this.b = paramp;
  }
  
  public final boolean a(t paramt)
  {
    return this.b.a(paramt, null, 0);
  }
  
  public final int getWindowAnimations()
  {
    return 0;
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a((t)getAdapter().getItem(paramInt));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/ExpandedMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */