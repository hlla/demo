package android.support.v7.widget;

import android.support.v4.os.c;
import android.support.v4.view.ac;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class fp
{
  public final ArrayList a = new ArrayList();
  public final ArrayList b = new ArrayList();
  public ArrayList c = null;
  public fn d;
  public int e = 2;
  public final List f = Collections.unmodifiableList(this.a);
  public fx g;
  private int i = 2;
  
  public fp(RecyclerView paramRecyclerView) {}
  
  private final void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int j = paramViewGroup.getChildCount() - 1;
    if (j >= 0)
    {
      View localView = paramViewGroup.getChildAt(j);
      if (!(localView instanceof ViewGroup)) {}
      for (;;)
      {
        j -= 1;
        break;
        a((ViewGroup)localView, true);
      }
    }
    if (paramBoolean)
    {
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
      }
    }
    else {
      return;
    }
    j = paramViewGroup.getVisibility();
    paramViewGroup.setVisibility(4);
    paramViewGroup.setVisibility(j);
  }
  
  public final fz a(int paramInt, long paramLong)
  {
    if ((paramInt < 0) || (paramInt >= this.h.G.a()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid item position ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("). Item count:");
      ((StringBuilder)localObject1).append(this.h.G.a());
      ((StringBuilder)localObject1).append(this.h.a());
      throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
    }
    int k;
    int j;
    Object localObject2;
    if (this.h.G.e)
    {
      localObject1 = this.c;
      if (localObject1 != null)
      {
        k = ((ArrayList)localObject1).size();
        if (k != 0)
        {
          j = 0;
          if (j < k)
          {
            localObject1 = (fz)this.c.get(j);
            if (((fz)localObject1).g()) {}
            while (((fz)localObject1).c() != paramInt)
            {
              j += 1;
              break;
            }
            ((fz)localObject1).c(32);
            if (localObject1 != null)
            {
              k = 1;
              localObject2 = localObject1;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      j = k;
      int m;
      Object localObject3;
      if (localObject2 == null)
      {
        m = this.a.size();
        j = 0;
        if (j < m) {
          break label2322;
        }
        localObject2 = this.h.k;
        m = ((be)localObject2).c.size();
        j = 0;
        if (j >= m) {
          break label2316;
        }
        localObject1 = (View)((be)localObject2).c.get(j);
        localObject3 = ((be)localObject2).b.b((View)localObject1);
        if (((fz)localObject3).c() != paramInt) {}
        while ((((fz)localObject3).j()) || (((fz)localObject3).l()))
        {
          j += 1;
          break;
        }
        label340:
        if (localObject1 == null) {
          break label2238;
        }
        localObject2 = RecyclerView.b((View)localObject1);
        localObject3 = this.h.k;
        j = ((be)localObject3).b.a((View)localObject1);
        if (j < 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("view is not a child, cannot hide ");
          ((StringBuilder)localObject2).append(localObject1);
          throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
        }
        if (!((be)localObject3).a.c(j))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("trying to unhide a view that was not hidden");
          ((StringBuilder)localObject2).append(localObject1);
          throw new RuntimeException(((StringBuilder)localObject2).toString());
        }
        ((be)localObject3).a.b(j);
        ((be)localObject3).b((View)localObject1);
        j = this.h.k.c((View)localObject1);
        if (j == -1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("layout index should not be -1 after unhiding a view:");
          ((StringBuilder)localObject1).append(localObject2);
          ((StringBuilder)localObject1).append(this.h.a());
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
        this.h.k.d(j);
        c((View)localObject1);
        ((fz)localObject2).c(8224);
        localObject1 = localObject2;
      }
      long l1;
      for (;;)
      {
        if (localObject1 == null) {
          j = k;
        }
        for (;;)
        {
          label877:
          label936:
          long l2;
          if (localObject1 == null)
          {
            int n = this.h.h.a(paramInt, 0);
            if ((n < 0) || (n >= this.h.g.c()))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Inconsistency detected. Invalid item position ");
              ((StringBuilder)localObject1).append(paramInt);
              ((StringBuilder)localObject1).append("(offset:");
              ((StringBuilder)localObject1).append(n);
              ((StringBuilder)localObject1).append(").");
              ((StringBuilder)localObject1).append("state:");
              ((StringBuilder)localObject1).append(this.h.G.a());
              ((StringBuilder)localObject1).append(this.h.a());
              throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
            }
            m = this.h.g.c(n);
            localObject2 = this.h.g;
            if (((eu)localObject2).a)
            {
              l1 = ((eu)localObject2).b(n);
              k = this.a.size() - 1;
              if (k >= 0)
              {
                localObject1 = (fz)this.a.get(k);
                if (((fz)localObject1).f != l1) {}
                for (;;)
                {
                  k -= 1;
                  break;
                  if (!((fz)localObject1).g())
                  {
                    if (m == ((fz)localObject1).g) {
                      break label877;
                    }
                    this.a.remove(k);
                    this.h.removeDetachedView(((fz)localObject1).c, false);
                    b(((fz)localObject1).c);
                  }
                }
                ((fz)localObject1).c(32);
                if (((fz)localObject1).l()) {
                  if (!this.h.G.e)
                  {
                    ((fz)localObject1).a(2, 14);
                    localObject2 = localObject1;
                    if (localObject1 != null)
                    {
                      ((fz)localObject1).l = n;
                      j = 1;
                      localObject2 = localObject1;
                    }
                    localObject1 = localObject2;
                    if (localObject2 == null)
                    {
                      localObject3 = this.g;
                      localObject1 = localObject2;
                      if (localObject3 != null)
                      {
                        localObject3 = ((fx)localObject3).a();
                        localObject1 = localObject2;
                        if (localObject3 != null)
                        {
                          localObject1 = this.h.a((View)localObject3);
                          if (localObject1 == null)
                          {
                            localObject1 = new StringBuilder();
                            ((StringBuilder)localObject1).append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            ((StringBuilder)localObject1).append(this.h.a());
                            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                          }
                          if (((fz)localObject1).b()) {
                            break label2581;
                          }
                        }
                      }
                    }
                    localObject2 = localObject1;
                    if (localObject1 == null)
                    {
                      localObject1 = d().b(m);
                      localObject2 = localObject1;
                      if (localObject1 != null)
                      {
                        ((fz)localObject1).p();
                        localObject2 = localObject1;
                        if (RecyclerView.c)
                        {
                          localObject3 = ((fz)localObject1).c;
                          localObject2 = localObject1;
                          if ((localObject3 instanceof ViewGroup))
                          {
                            a((ViewGroup)localObject3, false);
                            localObject2 = localObject1;
                          }
                        }
                      }
                    }
                    if (localObject2 == null)
                    {
                      l1 = RecyclerView.q();
                      if (paramLong != Long.MAX_VALUE)
                      {
                        l2 = this.d.c(m).b;
                        if (l2 != 0L) {}
                      }
                      else
                      {
                        label1160:
                        localObject1 = this.h;
                        localObject1 = ((RecyclerView)localObject1).g.b((ViewGroup)localObject1, m);
                        if (RecyclerView.b)
                        {
                          localObject2 = RecyclerView.g(((fz)localObject1).c);
                          if (localObject2 != null) {
                            ((fz)localObject1).h = new WeakReference(localObject2);
                          }
                        }
                        l2 = RecyclerView.q();
                        localObject2 = this.d.c(m);
                        ((fo)localObject2).b = fn.a(((fo)localObject2).b, l2 - l1);
                      }
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            if (j == 0) {}
            for (;;)
            {
              if ((!this.h.G.e) || ((((fz)localObject1).d & 0x1) == 0)) {
                if ((((fz)localObject1).d & 0x1) == 0)
                {
                  k = this.h.h.a(paramInt, 0);
                  ((fz)localObject1).j = this.h;
                  m = ((fz)localObject1).g;
                  l1 = RecyclerView.q();
                  if (paramLong != Long.MAX_VALUE)
                  {
                    l2 = this.d.c(m).a;
                    if (l2 != 0L) {}
                  }
                  else
                  {
                    label1351:
                    localObject2 = this.h.g;
                    ((fz)localObject1).l = k;
                    if (!((eu)localObject2).a)
                    {
                      label1375:
                      ((fz)localObject1).a(1, 519);
                      c.a("RV OnBindView");
                      ((fz)localObject1).o();
                      ((eu)localObject2).a((fz)localObject1, k);
                      ((fz)localObject1).n();
                      localObject2 = ((fz)localObject1).c.getLayoutParams();
                      if ((localObject2 instanceof fj)) {
                        ((fj)localObject2).b = true;
                      }
                      c.a();
                      paramLong = RecyclerView.q();
                      localObject2 = this.d.c(((fz)localObject1).g);
                      ((fo)localObject2).a = fn.a(((fo)localObject2).a, paramLong - l1);
                      if (this.h.l())
                      {
                        localObject2 = ((fz)localObject1).c;
                        if (ac.f((View)localObject2) == 0) {
                          ac.b((View)localObject2, 1);
                        }
                        if (!ac.c((View)localObject2))
                        {
                          ((fz)localObject1).c(16384);
                          ac.a((View)localObject2, this.h.e.a());
                        }
                      }
                      if (this.h.G.e)
                      {
                        ((fz)localObject1).m = paramInt;
                        paramInt = 1;
                      }
                    }
                  }
                }
              }
              for (;;)
              {
                localObject2 = ((fz)localObject1).c.getLayoutParams();
                if (localObject2 == null)
                {
                  localObject2 = (fj)this.h.generateDefaultLayoutParams();
                  ((fz)localObject1).c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                }
                for (;;)
                {
                  ((fj)localObject2).d = ((fz)localObject1);
                  boolean bool;
                  if (j == 0) {
                    bool = false;
                  }
                  for (;;)
                  {
                    ((fj)localObject2).c = bool;
                    return (fz)localObject1;
                    if (paramInt != 0) {
                      bool = true;
                    } else {
                      bool = false;
                    }
                  }
                  if (!this.h.checkLayoutParams((ViewGroup.LayoutParams)localObject2))
                  {
                    localObject2 = (fj)this.h.generateLayoutParams((ViewGroup.LayoutParams)localObject2);
                    ((fz)localObject1).c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                  }
                  else
                  {
                    localObject2 = (fj)localObject2;
                  }
                }
                paramInt = 1;
                continue;
                ((fz)localObject1).f = ((eu)localObject2).b(k);
                break label1375;
                if (l2 + l1 < paramLong) {
                  break label1351;
                }
                paramInt = 0;
                continue;
                if ((((fz)localObject1).k()) || (((fz)localObject1).j())) {
                  break;
                }
                paramInt = 0;
                continue;
                ((fz)localObject1).m = paramInt;
                paramInt = 0;
              }
              if ((!this.h.G.e) && (((fz)localObject1).b(8192)))
              {
                ((fz)localObject1).a(0, 8192);
                if (this.h.G.k)
                {
                  k = ez.buildAdapterChangeFlagsForAnimations((fz)localObject1);
                  localObject2 = this.h;
                  localObject2 = ((RecyclerView)localObject2).q.recordPreLayoutInformation(((RecyclerView)localObject2).G, (fz)localObject1, k | 0x1000, ((fz)localObject1).o());
                  this.h.a((fz)localObject1, (fc)localObject2);
                }
              }
            }
            if (l2 + l1 < paramLong) {
              break label1160;
            }
            return null;
            localObject1 = localObject2;
            continue;
            break;
            break;
            k = this.b.size() - 1;
            for (;;)
            {
              if (k >= 0)
              {
                localObject1 = (fz)this.b.get(k);
                if (((fz)localObject1).f != l1)
                {
                  k -= 1;
                }
                else
                {
                  if (m != ((fz)localObject1).g)
                  {
                    a(k);
                    localObject1 = null;
                    break;
                  }
                  this.b.remove(k);
                  break;
                }
              }
            }
            localObject1 = null;
            break;
            localObject2 = localObject1;
            break label936;
          }
          if (!((fz)localObject1).l()) {
            break;
          }
          if (!this.h.G.e)
          {
            label2000:
            ((fz)localObject1).c(4);
            if (((fz)localObject1).e())
            {
              this.h.removeDetachedView(((fz)localObject1).c, false);
              ((fz)localObject1).f();
            }
            for (;;)
            {
              a((fz)localObject1);
              localObject1 = null;
              j = k;
              break;
              if (((fz)localObject1).g()) {
                ((fz)localObject1).h();
              }
            }
          }
          j = 1;
        }
        j = ((fz)localObject1).l;
        if ((j < 0) || (j >= this.h.g.c()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Inconsistency detected. Invalid view holder adapter position");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(this.h.a());
          throw new IndexOutOfBoundsException(((StringBuilder)localObject2).toString());
        }
        localObject2 = this.h;
        if (((RecyclerView)localObject2).G.e) {}
        for (;;)
        {
          localObject2 = this.h.g;
          if (((eu)localObject2).a)
          {
            if (((fz)localObject1).f != ((eu)localObject2).b(((fz)localObject1).l)) {
              break label2000;
            }
            j = 1;
            break;
          }
          j = 1;
          break;
          if (((RecyclerView)localObject2).g.c(((fz)localObject1).l) != ((fz)localObject1).g) {
            break label2000;
          }
        }
        label2238:
        m = this.b.size();
        j = 0;
        if (j < m)
        {
          localObject1 = (fz)this.b.get(j);
          if (((fz)localObject1).j()) {}
          while (((fz)localObject1).c() != paramInt)
          {
            j += 1;
            break;
          }
          this.b.remove(j);
        }
        else
        {
          localObject1 = null;
          continue;
          label2316:
          localObject1 = null;
          break label340;
          label2322:
          localObject1 = (fz)this.a.get(j);
          if (((fz)localObject1).g()) {}
          while ((((fz)localObject1).c() != paramInt) || (((fz)localObject1).j()) || ((!this.h.G.e) && (((fz)localObject1).l())))
          {
            j += 1;
            break;
          }
          ((fz)localObject1).c(32);
        }
      }
      k = 0;
      localObject2 = localObject1;
      continue;
      localObject1 = this.h;
      if (((RecyclerView)localObject1).g.a)
      {
        j = ((RecyclerView)localObject1).h.a(paramInt, 0);
        if (j > 0)
        {
          if (j < this.h.g.c())
          {
            l1 = this.h.g.b(j);
            j = 0;
            if (j < k)
            {
              localObject1 = (fz)this.c.get(j);
              if (((fz)localObject1).g()) {}
              while (((fz)localObject1).f != l1)
              {
                j += 1;
                break;
              }
              ((fz)localObject1).c(32);
              break;
            }
            localObject1 = null;
            break;
          }
          localObject1 = null;
          break;
        }
        localObject1 = null;
        break;
      }
      localObject1 = null;
      break;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
      k = 0;
      localObject2 = null;
    }
    label2581:
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
    ((StringBuilder)localObject1).append(this.h.a());
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public final void a()
  {
    this.a.clear();
    c();
  }
  
  final void a(int paramInt)
  {
    a((fz)this.b.get(paramInt), true);
    this.b.remove(paramInt);
  }
  
  final void a(fz paramfz)
  {
    int n = 0;
    Object localObject;
    if ((paramfz.e()) || (paramfz.c.getParent() != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Scrapped or attached views may not be recycled. isScrap:");
      ((StringBuilder)localObject).append(paramfz.e());
      ((StringBuilder)localObject).append(" isAttached:");
      if (paramfz.c.getParent() == null) {
        break label501;
      }
    }
    label336:
    label345:
    label501:
    for (boolean bool = true;; bool = false)
    {
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(this.h.a());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      if (paramfz.m())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
        ((StringBuilder)localObject).append(paramfz);
        ((StringBuilder)localObject).append(this.h.a());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      if (paramfz.b())
      {
        paramfz = new StringBuilder();
        paramfz.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        paramfz.append(this.h.a());
        throw new IllegalArgumentException(paramfz.toString());
      }
      int k;
      if ((paramfz.d & 0x10) == 0) {
        if (ac.d(paramfz.c)) {
          k = 1;
        }
      }
      for (;;)
      {
        localObject = this.h.g;
        if (localObject == null) {}
        int m;
        while ((k == 0) || (!((eu)localObject).Y_()))
        {
          if (paramfz.q()) {
            break;
          }
          m = 0;
          this.h.M.d(paramfz);
          if ((m == 0) && (n == 0) && (k != 0)) {
            paramfz.j = null;
          }
          return;
        }
        int j;
        if (this.i > 0) {
          if (!paramfz.b(526))
          {
            m = this.b.size();
            if (m < this.i)
            {
              j = m;
              if (!RecyclerView.b)
              {
                m = j;
                this.b.add(m, paramfz);
                j = 1;
              }
            }
          }
        }
        for (;;)
        {
          m = j;
          if (j != 0) {
            break;
          }
          a(paramfz, true);
          n = 1;
          m = j;
          break;
          m = j;
          if (j <= 0) {
            break label345;
          }
          m = j;
          if (this.h.A.a(paramfz.l)) {
            break label345;
          }
          j -= 1;
          while (j >= 0)
          {
            m = ((fz)this.b.get(j)).l;
            if (!this.h.A.a(m)) {
              break;
            }
            j -= 1;
          }
          m = j + 1;
          break label345;
          j = m;
          if (m <= 0) {
            break label336;
          }
          a(0);
          j = m - 1;
          break label336;
          j = 0;
          continue;
          j = 0;
        }
        k = 0;
        continue;
        k = 0;
      }
    }
  }
  
  final void a(fz paramfz, boolean paramBoolean)
  {
    RecyclerView.b(paramfz);
    if (paramfz.b(16384))
    {
      paramfz.a(0, 16384);
      ac.a(paramfz.c, null);
    }
    if (paramBoolean)
    {
      Object localObject = this.h.C;
      if (localObject != null) {
        ((fq)localObject).a();
      }
      localObject = this.h.g;
      if (localObject != null) {
        ((eu)localObject).a(paramfz);
      }
      localObject = this.h;
      if (((RecyclerView)localObject).G != null) {
        ((RecyclerView)localObject).M.d(paramfz);
      }
    }
    paramfz.j = null;
    d().a(paramfz);
  }
  
  public final void a(View paramView)
  {
    fz localfz = RecyclerView.b(paramView);
    if (localfz.m()) {
      this.h.removeDetachedView(paramView, false);
    }
    if (localfz.e()) {
      localfz.f();
    }
    for (;;)
    {
      a(localfz);
      return;
      if (localfz.g()) {
        localfz.h();
      }
    }
  }
  
  public final void b()
  {
    ff localff = this.h.u;
    if (localff != null) {}
    for (int j = localff.k;; j = 0)
    {
      this.i = (j + this.e);
      j = this.b.size() - 1;
      while ((j >= 0) && (this.b.size() > this.i))
      {
        a(j);
        j -= 1;
      }
    }
  }
  
  final void b(fz paramfz)
  {
    if (paramfz.e) {
      this.c.remove(paramfz);
    }
    for (;;)
    {
      paramfz.n = null;
      paramfz.e = false;
      paramfz.h();
      return;
      this.a.remove(paramfz);
    }
  }
  
  final void b(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    paramView.n = null;
    paramView.e = false;
    paramView.h();
    a(paramView);
  }
  
  final void c()
  {
    int j = this.b.size() - 1;
    while (j >= 0)
    {
      a(j);
      j -= 1;
    }
    this.b.clear();
    if (RecyclerView.b) {
      this.h.A.a();
    }
  }
  
  final void c(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    if ((!paramView.b(12)) && (paramView.r()))
    {
      ez localez = this.h.q;
      if ((localez != null) && (!localez.canReuseUpdatedViewHolder(paramView, paramView.o()))) {}
    }
    else
    {
      if ((paramView.j()) && (!paramView.l()) && (!this.h.g.a)) {
        break label122;
      }
      paramView.a(this, false);
      this.a.add(paramView);
      return;
    }
    if (this.c == null) {
      this.c = new ArrayList();
    }
    paramView.a(this, true);
    this.c.add(paramView);
    return;
    label122:
    paramView = new StringBuilder();
    paramView.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
    paramView.append(this.h.a());
    throw new IllegalArgumentException(paramView.toString());
  }
  
  final fn d()
  {
    if (this.d == null) {
      this.d = new fn();
    }
    return this.d;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/fp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */