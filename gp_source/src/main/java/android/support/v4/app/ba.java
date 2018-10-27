package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

final class ba
  extends bf
{
  private static boolean a(Transition paramTransition)
  {
    return (!a(paramTransition.getTargetIds())) || (!a(paramTransition.getTargetNames())) || (!a(paramTransition.getTargetTypes()));
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.addTransition((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.addTransition((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.addTransition((Transition)paramObject3);
    }
    return localTransitionSet;
  }
  
  public final void a(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  public final void a(Object paramObject, Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).setEpicenterCallback(new be(paramRect));
    }
  }
  
  public final void a(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      Rect localRect = new Rect();
      a(paramView, localRect);
      ((Transition)paramObject).setEpicenterCallback(new bb(localRect));
    }
  }
  
  public final void a(Object paramObject, View paramView, ArrayList paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    List localList = ((TransitionSet)paramObject).getTargets();
    localList.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      a(localList, (View)paramArrayList.get(i));
      i += 1;
    }
    localList.add(paramView);
    paramArrayList.add(paramView);
    a(paramObject, paramArrayList);
  }
  
  public final void a(Object paramObject1, Object paramObject2, ArrayList paramArrayList1, Object paramObject3, ArrayList paramArrayList2, Object paramObject4, ArrayList paramArrayList3)
  {
    ((Transition)paramObject1).addListener(new bd(this, paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3));
  }
  
  public final void a(Object paramObject, ArrayList paramArrayList)
  {
    int i = 0;
    paramObject = (Transition)paramObject;
    if (paramObject != null)
    {
      int j;
      if ((paramObject instanceof TransitionSet))
      {
        paramObject = (TransitionSet)paramObject;
        j = ((TransitionSet)paramObject).getTransitionCount();
        while (i < j)
        {
          a(((TransitionSet)paramObject).getTransitionAt(i), paramArrayList);
          i += 1;
        }
      }
      if ((!a((Transition)paramObject)) && (a(((Transition)paramObject).getTargets())))
      {
        j = paramArrayList.size();
        i = 0;
        while (i < j)
        {
          ((Transition)paramObject).addTarget((View)paramArrayList.get(i));
          i += 1;
        }
      }
    }
  }
  
  public final void a(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      ((TransitionSet)paramObject).getTargets().clear();
      ((TransitionSet)paramObject).getTargets().addAll(paramArrayList2);
      b(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public final boolean a(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public final Object b(Object paramObject)
  {
    if (paramObject != null) {
      return ((Transition)paramObject).clone();
    }
    return null;
  }
  
  public final void b(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).addTarget(paramView);
    }
  }
  
  public final void b(Object paramObject, View paramView, ArrayList paramArrayList)
  {
    ((Transition)paramObject).addListener(new bc(paramView, paramArrayList));
  }
  
  public final void b(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    int j = 0;
    int i = 0;
    paramObject = (Transition)paramObject;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = ((TransitionSet)paramObject).getTransitionCount();
      while (i < j)
      {
        b(((TransitionSet)paramObject).getTransitionAt(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!a((Transition)paramObject))
    {
      List localList = ((Transition)paramObject).getTargets();
      if ((localList != null) && (localList.size() == paramArrayList1.size()) && (localList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 != null) {
          i = paramArrayList2.size();
        }
        for (;;)
        {
          if (j < i)
          {
            ((Transition)paramObject).addTarget((View)paramArrayList2.get(j));
            j += 1;
          }
          else
          {
            i = paramArrayList1.size() - 1;
            while (i >= 0)
            {
              ((Transition)paramObject).removeTarget((View)paramArrayList1.get(i));
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
      TransitionSet localTransitionSet = new TransitionSet();
      localTransitionSet.addTransition((Transition)paramObject);
      return localTransitionSet;
    }
    return null;
  }
  
  public final void c(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).removeTarget(paramView);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */