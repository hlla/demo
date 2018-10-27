package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ac;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class bf
{
  public static void a(View paramView, Rect paramRect)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    paramRect.set(i, arrayOfInt[1], paramView.getWidth() + i, arrayOfInt[1] + paramView.getHeight());
  }
  
  public static void a(List paramList, View paramView)
  {
    int k = paramList.size();
    if (!a(paramList, paramView, k))
    {
      paramList.add(paramView);
      int i = k;
      while (i < paramList.size())
      {
        paramView = (View)paramList.get(i);
        if ((paramView instanceof ViewGroup))
        {
          paramView = (ViewGroup)paramView;
          int m = paramView.getChildCount();
          int j = 0;
          if (j < m)
          {
            View localView = paramView.getChildAt(j);
            if (a(paramList, localView, k)) {}
            for (;;)
            {
              j += 1;
              break;
              paramList.add(localView);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  private static boolean a(List paramList, View paramView, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramInt) {
        break label35;
      }
      if (paramList.get(i) == paramView) {
        break;
      }
      i += 1;
    }
    boolean bool1 = true;
    label35:
    return bool1;
  }
  
  public abstract Object a(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void a(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract void a(Object paramObject, Rect paramRect);
  
  public abstract void a(Object paramObject, View paramView);
  
  public abstract void a(Object paramObject, View paramView, ArrayList paramArrayList);
  
  public abstract void a(Object paramObject1, Object paramObject2, ArrayList paramArrayList1, Object paramObject3, ArrayList paramArrayList2, Object paramObject4, ArrayList paramArrayList3);
  
  public abstract void a(Object paramObject, ArrayList paramArrayList);
  
  public abstract void a(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  final void a(ArrayList paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup)) {
        break label113;
      }
      paramView = (ViewGroup)paramView;
      if (Build.VERSION.SDK_INT < 21) {
        break label72;
      }
      if (!paramView.isTransitionGroup()) {
        break label41;
      }
    }
    for (;;)
    {
      paramArrayList.add(paramView);
      label40:
      return;
      label41:
      label72:
      do
      {
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          a(paramArrayList, paramView.getChildAt(i));
          i += 1;
        }
        break label40;
        Boolean localBoolean = (Boolean)paramView.getTag(2131429436);
        if (((localBoolean != null) && (localBoolean.booleanValue())) || (paramView.getBackground() != null)) {
          break;
        }
      } while (ac.v(paramView) == null);
    }
    label113:
    paramArrayList.add(paramView);
  }
  
  final void a(Map paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = ac.v(paramView);
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          a(paramMap, paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  public abstract boolean a(Object paramObject);
  
  public abstract Object b(Object paramObject);
  
  public abstract void b(Object paramObject, View paramView);
  
  public abstract void b(Object paramObject, View paramView, ArrayList paramArrayList);
  
  public abstract void b(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  public abstract Object c(Object paramObject);
  
  public abstract void c(Object paramObject, View paramView);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */