package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class ay
{
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      boolean bool = paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
      return bool;
    }
    catch (AbstractMethodError paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ViewParent ");
      localStringBuilder.append(paramViewParent);
      localStringBuilder.append(" does not implement interface ");
      localStringBuilder.append("method onNestedPreFling");
      Log.e("ViewParentCompat", localStringBuilder.toString(), paramView);
    }
    if ((paramViewParent instanceof v)) {
      return ((v)paramViewParent).onNestedPreFling(paramView, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      paramBoolean = paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      return paramBoolean;
    }
    catch (AbstractMethodError paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ViewParent ");
      localStringBuilder.append(paramViewParent);
      localStringBuilder.append(" does not implement interface ");
      localStringBuilder.append("method onNestedFling");
      Log.e("ViewParentCompat", localStringBuilder.toString(), paramView);
    }
    if ((paramViewParent instanceof v)) {
      return ((v)paramViewParent).onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    }
    return false;
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof w)) {
      return ((w)paramViewParent).a(paramView1, paramView2, paramInt1, paramInt2);
    }
    if (paramInt2 == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {}
      try
      {
        boolean bool = paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt1);
        return bool;
      }
      catch (AbstractMethodError paramView1)
      {
        paramView2 = new StringBuilder();
        paramView2.append("ViewParent ");
        paramView2.append(paramViewParent);
        paramView2.append(" does not implement interface ");
        paramView2.append("method onStartNestedScroll");
        Log.e("ViewParentCompat", paramView2.toString(), paramView1);
      }
      if ((paramViewParent instanceof v)) {
        return ((v)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt1);
      }
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */