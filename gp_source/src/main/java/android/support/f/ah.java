package android.support.f;

import android.support.v4.g.a;
import android.support.v4.g.v;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class ah
{
  public static z c = new b();
  public static ArrayList d = new ArrayList();
  private static ThreadLocal e = new ThreadLocal();
  public a a = new a();
  public a b = new a();
  
  static a a()
  {
    Object localObject1 = (WeakReference)e.get();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (a)((WeakReference)localObject1).get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = new a();
      localObject2 = new WeakReference(localObject1);
      e.set(localObject2);
    }
    return (a)localObject1;
  }
  
  public static void a(ViewGroup paramViewGroup, z paramz)
  {
    if ((paramz != null) && (paramViewGroup != null))
    {
      paramz = new ai(paramz, paramViewGroup);
      paramViewGroup.addOnAttachStateChangeListener(paramz);
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramz);
    }
  }
  
  public static void b(ViewGroup paramViewGroup, z paramz)
  {
    ArrayList localArrayList = (ArrayList)a().get(paramViewGroup);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((z)localArrayList.get(i)).d(paramViewGroup);
        i += 1;
      }
    }
    if (paramz == null) {}
    for (;;)
    {
      paramViewGroup = y.a(paramViewGroup);
      if (paramViewGroup != null) {
        y.a(paramViewGroup.c);
      }
      return;
      paramz.a(paramViewGroup, true);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */