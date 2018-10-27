package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.widget.ListView;

public class AlertController$RecycleListView
  extends ListView
{
  public final int a;
  public final int b;
  
  public AlertController$RecycleListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AlertController$RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.cc);
    this.a = paramContext.getDimensionPixelOffset(a.cd, -1);
    this.b = paramContext.getDimensionPixelOffset(a.ce, -1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/AlertController$RecycleListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */