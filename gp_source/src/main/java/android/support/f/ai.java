package android.support.f;

import android.animation.Animator;
import android.support.v4.g.a;
import android.support.v4.g.h;
import android.support.v4.g.v;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Collection;

final class ai
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  public ViewGroup a;
  private z b;
  
  ai(z paramz, ViewGroup paramViewGroup)
  {
    this.b = paramz;
    this.a = paramViewGroup;
  }
  
  private final void a()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    this.a.removeOnAttachStateChangeListener(this);
  }
  
  public final boolean onPreDraw()
  {
    a();
    if (ah.d.remove(this.a))
    {
      a locala = ah.a();
      Object localObject2 = (ArrayList)locala.get(this.a);
      Object localObject1;
      if (localObject2 == null)
      {
        localObject2 = new ArrayList();
        locala.put(this.a, localObject2);
        localObject1 = null;
      }
      for (;;)
      {
        ((ArrayList)localObject2).add(this.b);
        this.b.a(new aj(this, locala));
        this.b.a(this.a, false);
        int j;
        int i;
        if (localObject1 != null)
        {
          j = ((ArrayList)localObject1).size();
          i = 0;
        }
        for (;;)
        {
          if (i >= j)
          {
            localObject1 = this.b;
            localObject2 = this.a;
            ((z)localObject1).n = new ArrayList();
            ((z)localObject1).e = new ArrayList();
            Object localObject4 = ((z)localObject1).m;
            Object localObject5 = ((z)localObject1).d;
            Object localObject3 = new a(((aq)localObject4).d);
            locala = new a(((aq)localObject5).d);
            i = 0;
            Object localObject6 = ((z)localObject1).h;
            Object localObject7;
            Object localObject8;
            if (i < localObject6.length)
            {
              switch (localObject6[i])
              {
              default: 
              case 4: 
              case 3: 
              case 2: 
                int k;
                View localView;
                ap localap1;
                ap localap2;
                do
                {
                  do
                  {
                    do
                    {
                      i += 1;
                      break;
                      localObject6 = ((aq)localObject4).b;
                      localObject7 = ((aq)localObject5).b;
                      k = ((h)localObject6).a();
                      j = 0;
                    } while (j >= k);
                    localObject8 = (View)((h)localObject6).b(j);
                    if (localObject8 == null) {}
                    for (;;)
                    {
                      j += 1;
                      break;
                      if (((z)localObject1).a((View)localObject8))
                      {
                        localView = (View)((h)localObject7).a(((h)localObject6).a(j), null);
                        if ((localView != null) && (((z)localObject1).a(localView)))
                        {
                          localap1 = (ap)((v)localObject3).get(localObject8);
                          localap2 = (ap)locala.get(localView);
                          if ((localap1 != null) && (localap2 != null))
                          {
                            ((z)localObject1).n.add(localap1);
                            ((z)localObject1).e.add(localap2);
                            ((v)localObject3).remove(localObject8);
                            locala.remove(localView);
                          }
                        }
                      }
                    }
                    localObject6 = ((aq)localObject4).a;
                    localObject7 = ((aq)localObject5).a;
                    k = ((SparseArray)localObject6).size();
                    j = 0;
                  } while (j >= k);
                  localObject8 = (View)((SparseArray)localObject6).valueAt(j);
                  if (localObject8 == null) {}
                  for (;;)
                  {
                    j += 1;
                    break;
                    if (((z)localObject1).a((View)localObject8))
                    {
                      localView = (View)((SparseArray)localObject7).get(((SparseArray)localObject6).keyAt(j));
                      if ((localView != null) && (((z)localObject1).a(localView)))
                      {
                        localap1 = (ap)((v)localObject3).get(localObject8);
                        localap2 = (ap)locala.get(localView);
                        if ((localap1 != null) && (localap2 != null))
                        {
                          ((z)localObject1).n.add(localap1);
                          ((z)localObject1).e.add(localap2);
                          ((v)localObject3).remove(localObject8);
                          locala.remove(localView);
                        }
                      }
                    }
                  }
                  localObject6 = ((aq)localObject4).c;
                  localObject7 = ((aq)localObject5).c;
                  k = ((v)localObject6).size();
                  j = 0;
                } while (j >= k);
                localObject8 = (View)((v)localObject6).c(j);
                if (localObject8 == null) {}
                for (;;)
                {
                  j += 1;
                  break;
                  if (((z)localObject1).a((View)localObject8))
                  {
                    localView = (View)((v)localObject7).get(((v)localObject6).b(j));
                    if ((localView != null) && (((z)localObject1).a(localView)))
                    {
                      localap1 = (ap)((v)localObject3).get(localObject8);
                      localap2 = (ap)locala.get(localView);
                      if ((localap1 != null) && (localap2 != null))
                      {
                        ((z)localObject1).n.add(localap1);
                        ((z)localObject1).e.add(localap2);
                        ((v)localObject3).remove(localObject8);
                        locala.remove(localView);
                      }
                    }
                  }
                }
              }
              j = ((v)localObject3).size() - 1;
              label766:
              if (j >= 0)
              {
                localObject6 = (View)((v)localObject3).b(j);
                if (localObject6 != null) {
                  break label793;
                }
              }
              for (;;)
              {
                j -= 1;
                break label766;
                break;
                label793:
                if (((z)localObject1).a((View)localObject6))
                {
                  localObject6 = (ap)locala.remove(localObject6);
                  if (localObject6 != null)
                  {
                    localObject7 = ((ap)localObject6).c;
                    if ((localObject7 != null) && (((z)localObject1).a((View)localObject7)))
                    {
                      localObject7 = (ap)((v)localObject3).d(j);
                      ((z)localObject1).n.add(localObject7);
                      ((z)localObject1).e.add(localObject6);
                    }
                  }
                }
              }
            }
            i = 0;
            while (i < ((v)localObject3).size())
            {
              localObject4 = (ap)((v)localObject3).c(i);
              if (((z)localObject1).a(((ap)localObject4).c))
              {
                ((z)localObject1).n.add(localObject4);
                ((z)localObject1).e.add(null);
              }
              i += 1;
            }
            i = 0;
            while (i < locala.size())
            {
              localObject3 = (ap)locala.c(i);
              if (((z)localObject1).a(((ap)localObject3).c))
              {
                ((z)localObject1).e.add(localObject3);
                ((z)localObject1).n.add(null);
              }
              i += 1;
            }
            locala = z.b();
            i = locala.size();
            localObject3 = ba.a((View)localObject2);
            i -= 1;
            if (i >= 0)
            {
              localObject4 = (Animator)locala.b(i);
              if (localObject4 != null)
              {
                localObject5 = (ad)locala.get(localObject4);
                if (localObject5 != null) {
                  break label1070;
                }
              }
              label1070:
              label1186:
              for (;;)
              {
                i -= 1;
                break;
                if ((((ad)localObject5).d != null) && (localObject3.equals(((ad)localObject5).e)))
                {
                  localObject6 = ((ad)localObject5).c;
                  localObject8 = ((ad)localObject5).d;
                  localObject7 = ((z)localObject1).a((View)localObject8, true);
                  localObject8 = ((z)localObject1).b((View)localObject8, true);
                  if (localObject7 != null) {}
                  for (;;)
                  {
                    if (!((ad)localObject5).b.a((ap)localObject6, (ap)localObject8)) {
                      break label1186;
                    }
                    if ((((Animator)localObject4).isRunning()) || (((Animator)localObject4).isStarted()))
                    {
                      ((Animator)localObject4).cancel();
                      break;
                    }
                    locala.remove(localObject4);
                    break;
                    if (localObject8 == null) {
                      break;
                    }
                  }
                }
              }
            }
            ((z)localObject1).a((ViewGroup)localObject2, ((z)localObject1).m, ((z)localObject1).d, ((z)localObject1).n, ((z)localObject1).e);
            ((z)localObject1).c();
            return true;
          }
          ((z)((ArrayList)localObject1).get(i)).e(this.a);
          i += 1;
        }
        if (((ArrayList)localObject2).size() > 0) {
          localObject1 = new ArrayList((Collection)localObject2);
        } else {
          localObject1 = null;
        }
      }
    }
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    a();
    ah.d.remove(this.a);
    paramView = (ArrayList)ah.a().get(this.a);
    if ((paramView != null) && (paramView.size() > 0))
    {
      int j = paramView.size();
      int i = 0;
      while (i < j)
      {
        ((z)paramView.get(i)).e(this.a);
        i += 1;
      }
    }
    this.b.a(true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */