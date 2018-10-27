package android.support.f;

import android.graphics.Rect;
import android.support.v4.app.bf;
import android.support.v4.view.ac;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class p
  extends bf
{
  private static boolean a(z paramz)
  {
    return (!a(paramz.o)) || (!a(null)) || (!a(null));
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    al localal = new al();
    if (paramObject1 != null) {
      localal.a((z)paramObject1);
    }
    if (paramObject2 != null) {
      localal.a((z)paramObject2);
    }
    if (paramObject3 != null) {
      localal.a((z)paramObject3);
    }
    return localal;
  }
  
  public final void a(ViewGroup paramViewGroup, Object paramObject)
  {
    z localz = (z)paramObject;
    if ((!ah.d.contains(paramViewGroup)) && (ac.I(paramViewGroup)))
    {
      ah.d.add(paramViewGroup);
      paramObject = localz;
      if (localz == null) {
        paramObject = ah.c;
      }
      paramObject = (z)((z)paramObject).clone();
      ah.b(paramViewGroup, (z)paramObject);
      paramViewGroup.setTag(2131429557, null);
      ah.a(paramViewGroup, (z)paramObject);
    }
  }
  
  public final void a(Object paramObject, Rect paramRect)
  {
    if (paramObject != null) {
      ((z)paramObject).a(new t());
    }
  }
  
  public final void a(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (z)paramObject;
      a(paramView, new Rect());
      ((z)paramObject).a(new q());
    }
  }
  
  public final void a(Object paramObject, View paramView, ArrayList paramArrayList)
  {
    paramObject = (al)paramObject;
    ArrayList localArrayList = ((z)paramObject).p;
    localArrayList.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      a(localArrayList, (View)paramArrayList.get(i));
      i += 1;
    }
    localArrayList.add(paramView);
    paramArrayList.add(paramView);
    a(paramObject, paramArrayList);
  }
  
  public final void a(Object paramObject1, Object paramObject2, ArrayList paramArrayList1, Object paramObject3, ArrayList paramArrayList2, Object paramObject4, ArrayList paramArrayList3)
  {
    ((z)paramObject1).a(new s(this, paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3));
  }
  
  public final void a(Object paramObject, ArrayList paramArrayList)
  {
    int i = 0;
    paramObject = (z)paramObject;
    if (paramObject != null)
    {
      int j;
      if ((paramObject instanceof al))
      {
        paramObject = (al)paramObject;
        j = ((al)paramObject).s.size();
        while (i < j)
        {
          a(((al)paramObject).b(i), paramArrayList);
          i += 1;
        }
      }
      if ((!a((z)paramObject)) && (a(((z)paramObject).p)))
      {
        j = paramArrayList.size();
        i = 0;
        while (i < j)
        {
          ((z)paramObject).b((View)paramArrayList.get(i));
          i += 1;
        }
      }
    }
  }
  
  public final void a(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramObject = (al)paramObject;
    if (paramObject != null)
    {
      ((z)paramObject).p.clear();
      ((z)paramObject).p.addAll(paramArrayList2);
      b(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public final boolean a(Object paramObject)
  {
    return paramObject instanceof z;
  }
  
  public final Object b(Object paramObject)
  {
    if (paramObject != null) {
      return (z)((z)paramObject).clone();
    }
    return null;
  }
  
  public final void b(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((z)paramObject).b(paramView);
    }
  }
  
  public final void b(Object paramObject, View paramView, ArrayList paramArrayList)
  {
    ((z)paramObject).a(new r(paramView, paramArrayList));
  }
  
  public final void b(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    int j = 0;
    int i = 0;
    paramObject = (z)paramObject;
    if ((paramObject instanceof al))
    {
      paramObject = (al)paramObject;
      j = ((al)paramObject).s.size();
      while (i < j)
      {
        b(((al)paramObject).b(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!a((z)paramObject))
    {
      ArrayList localArrayList = ((z)paramObject).p;
      if ((localArrayList.size() == paramArrayList1.size()) && (localArrayList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 != null) {
          i = paramArrayList2.size();
        }
        for (;;)
        {
          if (j < i)
          {
            ((z)paramObject).b((View)paramArrayList2.get(j));
            j += 1;
          }
          else
          {
            i = paramArrayList1.size() - 1;
            while (i >= 0)
            {
              ((z)paramObject).c((View)paramArrayList1.get(i));
              i -= 1;
            }
            i = 0;
          }
        }
      }
    }
  }
  
  public final Object c(Object paramObject)
  {
    if (paramObject != null)
    {
      al localal = new al();
      localal.a((z)paramObject);
      return localal;
    }
    return null;
  }
  
  public final void c(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((z)paramObject).c(paramView);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */