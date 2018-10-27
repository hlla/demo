package android.support.f;

import android.animation.Animator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class bh
  extends z
{
  private static final String[] r = { "android:visibility:visibility", "android:visibility:parent" };
  public int q = 3;
  
  private static bk b(ap paramap1, ap paramap2)
  {
    bk localbk = new bk();
    localbk.f = false;
    localbk.c = false;
    if ((paramap1 != null) && (paramap1.b.containsKey("android:visibility:visibility"))) {
      localbk.e = ((Integer)paramap1.b.get("android:visibility:visibility")).intValue();
    }
    for (localbk.d = ((ViewGroup)paramap1.b.get("android:visibility:parent"));; localbk.d = null)
    {
      if ((paramap2 != null) && (paramap2.b.containsKey("android:visibility:visibility"))) {
        localbk.b = ((Integer)paramap2.b.get("android:visibility:visibility")).intValue();
      }
      for (localbk.a = ((ViewGroup)paramap2.b.get("android:visibility:parent"));; localbk.a = null)
      {
        if (paramap1 == null) {
          if ((paramap1 == null) && (localbk.b == 0))
          {
            localbk.c = true;
            localbk.f = true;
          }
        }
        for (;;)
        {
          return localbk;
          if ((paramap2 == null) && (localbk.e == 0))
          {
            localbk.c = false;
            localbk.f = true;
            continue;
            if (paramap2 == null) {
              break;
            }
            int i = localbk.e;
            int j = localbk.b;
            if ((i == j) && (localbk.d == localbk.a)) {
              break label320;
            }
            if (i == j)
            {
              if (localbk.a == null)
              {
                localbk.c = false;
                localbk.f = true;
              }
              else if (localbk.d == null)
              {
                localbk.c = true;
                localbk.f = true;
              }
            }
            else if (i == 0)
            {
              localbk.c = false;
              localbk.f = true;
            }
            else if (j == 0)
            {
              localbk.c = true;
              localbk.f = true;
            }
          }
        }
        label320:
        return localbk;
        localbk.b = -1;
      }
      localbk.e = -1;
    }
  }
  
  private static void d(ap paramap)
  {
    int i = paramap.c.getVisibility();
    paramap.b.put("android:visibility:visibility", Integer.valueOf(i));
    paramap.b.put("android:visibility:parent", paramap.c.getParent());
    int[] arrayOfInt = new int[2];
    paramap.c.getLocationOnScreen(arrayOfInt);
    paramap.b.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  public Animator a(View paramView, ap paramap)
  {
    return null;
  }
  
  public Animator a(ViewGroup paramViewGroup, ap paramap1, int paramInt1, ap paramap2, int paramInt2)
  {
    if (((this.q & 0x1) == 1) && (paramap2 != null))
    {
      if (paramap1 == null)
      {
        paramViewGroup = (View)paramap2.c.getParent();
        if (b(b(paramViewGroup, false), a(paramViewGroup, false)).f) {}
      }
      else
      {
        return a(paramap2.c, paramap1);
      }
      return null;
    }
    return null;
  }
  
  public final Animator a(ViewGroup paramViewGroup, ap paramap1, ap paramap2)
  {
    bk localbk = b(paramap1, paramap2);
    if ((localbk.f) && ((localbk.d != null) || (localbk.a != null)))
    {
      if (localbk.c) {
        return a(paramViewGroup, paramap1, localbk.e, paramap2, localbk.b);
      }
      return b(paramViewGroup, paramap1, localbk.e, paramap2, localbk.b);
    }
    return null;
  }
  
  public void a(ap paramap)
  {
    d(paramap);
  }
  
  public final boolean a(ap paramap1, ap paramap2)
  {
    if (paramap1 != null) {}
    while (paramap2 != null)
    {
      if (paramap1 == null) {}
      while ((paramap2 == null) || (paramap2.b.containsKey("android:visibility:visibility") == paramap1.b.containsKey("android:visibility:visibility")))
      {
        paramap1 = b(paramap1, paramap2);
        if (paramap1.f)
        {
          if (paramap1.e == 0) {}
        }
        else {
          return paramap1.b == 0;
        }
        return true;
      }
      return false;
    }
    return false;
  }
  
  public final String[] a()
  {
    return r;
  }
  
  public Animator b(View paramView, ap paramap)
  {
    return null;
  }
  
  public Animator b(ViewGroup paramViewGroup, ap paramap1, int paramInt1, ap paramap2, int paramInt2)
  {
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if ((this.q & 0x2) == 2) {
      if (paramap1 == null) {
        break label677;
      }
    }
    label294:
    label677:
    for (localObject2 = paramap1.c;; localObject2 = null)
    {
      if (paramap2 != null) {}
      for (Object localObject1 = paramap2.c;; localObject1 = null)
      {
        if ((localObject1 != null) && (((View)localObject1).getParent() != null)) {
          if (paramInt2 == 4) {
            paramap2 = null;
          }
        }
        for (;;)
        {
          if (paramap2 == null) {}
          while (paramap1 == null)
          {
            localObject2 = localObject3;
            if (localObject1 != null)
            {
              paramInt1 = ((View)localObject1).getVisibility();
              ba.a((View)localObject1, 0);
              localObject2 = b((View)localObject1, paramap1);
              if (localObject2 != null)
              {
                paramViewGroup = new bj((View)localObject1, paramInt2);
                ((Animator)localObject2).addListener(paramViewGroup);
                if (Build.VERSION.SDK_INT >= 19) {
                  ((Animator)localObject2).addPauseListener(paramViewGroup);
                }
                a(paramViewGroup);
              }
            }
            else
            {
              return (Animator)localObject2;
            }
            ba.a((View)localObject1, paramInt1);
            return (Animator)localObject2;
          }
          localObject1 = (int[])paramap1.b.get("android:visibility:screenLocation");
          paramInt1 = localObject1[0];
          paramInt2 = localObject1[1];
          localObject1 = new int[2];
          paramViewGroup.getLocationOnScreen((int[])localObject1);
          paramap2.offsetLeftAndRight(paramInt1 - localObject1[0] - paramap2.getLeft());
          paramap2.offsetTopAndBottom(paramInt2 - localObject1[1] - paramap2.getTop());
          if (Build.VERSION.SDK_INT >= 18)
          {
            paramViewGroup = new as(paramViewGroup);
            paramViewGroup.a(paramap2);
            paramap1 = b(paramap2, paramap1);
            if (paramap1 == null)
            {
              paramViewGroup.b(paramap2);
              return paramap1;
            }
            paramap1.addListener(new bi(paramViewGroup, paramap2));
            return paramap1;
          }
          localObject1 = paramViewGroup;
          if (localObject1 != null) {
            if ((((View)localObject1).getId() != 16908290) || (!(localObject1 instanceof ViewGroup))) {}
          }
          for (localObject1 = (ViewGroup)localObject1;; localObject1 = null)
          {
            if (localObject1 != null)
            {
              paramInt2 = ((ViewGroup)localObject1).getChildCount();
              paramInt1 = 0;
              while (paramInt1 < paramInt2)
              {
                localObject2 = ((ViewGroup)localObject1).getChildAt(paramInt1);
                if (!(localObject2 instanceof az)) {
                  paramInt1 += 1;
                } else {
                  paramViewGroup = ((az)localObject2).a;
                }
              }
            }
            for (;;)
            {
              paramViewGroup = (ar)paramViewGroup;
              break;
              paramViewGroup = new ar(((ViewGroup)localObject1).getContext(), (ViewGroup)localObject1, paramViewGroup);
              continue;
              paramViewGroup = null;
            }
            if (!(((View)localObject1).getParent() instanceof ViewGroup)) {
              break label294;
            }
            localObject1 = (ViewGroup)((View)localObject1).getParent();
            break label294;
          }
          if (localObject2 == localObject1)
          {
            paramap2 = null;
          }
          else if (!this.a)
          {
            paramap2 = ao.a(paramViewGroup, (View)localObject2, (View)((View)localObject2).getParent());
            localObject1 = null;
          }
          else
          {
            localObject1 = null;
            paramap2 = (ap)localObject2;
            continue;
            if (localObject1 != null)
            {
              paramap2 = (ap)localObject1;
              localObject1 = null;
            }
            else if (localObject2 == null)
            {
              localObject1 = null;
              paramap2 = null;
            }
            else if (((View)localObject2).getParent() != null)
            {
              if ((((View)localObject2).getParent() instanceof View))
              {
                paramap2 = (View)((View)localObject2).getParent();
                if (!b(a(paramap2, true), b(paramap2, true)).f) {
                  paramap2 = ao.a(paramViewGroup, (View)localObject2, paramap2);
                }
                for (;;)
                {
                  localObject1 = null;
                  break;
                  if (paramap2.getParent() == null)
                  {
                    paramInt1 = paramap2.getId();
                    if (paramInt1 != -1)
                    {
                      if (paramViewGroup.findViewById(paramInt1) != null)
                      {
                        if (!this.a) {
                          paramap2 = null;
                        } else {
                          paramap2 = (ap)localObject2;
                        }
                      }
                      else {
                        paramap2 = null;
                      }
                    }
                    else {
                      paramap2 = null;
                    }
                  }
                  else
                  {
                    paramap2 = null;
                  }
                }
              }
              localObject1 = null;
              paramap2 = null;
            }
            else
            {
              localObject1 = null;
              paramap2 = (ap)localObject2;
            }
          }
        }
      }
    }
  }
  
  public final void b(ap paramap)
  {
    d(paramap);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */