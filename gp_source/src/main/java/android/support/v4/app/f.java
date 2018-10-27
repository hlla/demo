package android.support.v4.app;

import android.support.v4.view.ac;
import android.view.View;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class f
  extends at
  implements an, w
{
  public boolean a;
  public int b;
  public CharSequence c;
  public int d;
  public CharSequence e;
  public boolean f;
  public int g;
  public int h;
  public int i = -1;
  public final z j;
  public String k;
  public ArrayList l = new ArrayList();
  public int m;
  public int n;
  public boolean o = false;
  public ArrayList p;
  public ArrayList q;
  public int r;
  public int s;
  private boolean t = true;
  
  public f(z paramz)
  {
    this.j = paramz;
  }
  
  private final void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    Object localObject = paramFragment.getClass();
    int i1 = ((Class)localObject).getModifiers();
    if ((((Class)localObject).isAnonymousClass()) || (!Modifier.isPublic(i1)) || ((((Class)localObject).isMemberClass()) && (!Modifier.isStatic(i1))))
    {
      paramFragment = new StringBuilder();
      paramFragment.append("Fragment ");
      paramFragment.append(((Class)localObject).getCanonicalName());
      paramFragment.append(" must be a public static class to be  properly recreated from");
      paramFragment.append(" instance state.");
      throw new IllegalStateException(paramFragment.toString());
    }
    paramFragment.q = this.j;
    if (paramString != null)
    {
      localObject = paramFragment.P;
      if ((localObject != null) && (!paramString.equals(localObject)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Can't change tag of fragment ");
        ((StringBuilder)localObject).append(paramFragment);
        ((StringBuilder)localObject).append(": was ");
        ((StringBuilder)localObject).append(paramFragment.P);
        ((StringBuilder)localObject).append(" now ");
        ((StringBuilder)localObject).append(paramString);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      paramFragment.P = paramString;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 == -1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Can't add fragment ");
        ((StringBuilder)localObject).append(paramFragment);
        ((StringBuilder)localObject).append(" with tag ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" to container view with no id");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      i1 = paramFragment.p;
      if (i1 != 0) {
        break label308;
      }
    }
    label308:
    while (i1 == paramInt1)
    {
      paramFragment.p = paramInt1;
      paramFragment.m = paramInt1;
      a(new g(paramInt2, paramFragment));
      return;
    }
    paramString = new StringBuilder();
    paramString.append("Can't change container ID of fragment ");
    paramString.append(paramFragment);
    paramString.append(": was ");
    paramString.append(paramFragment.p);
    paramString.append(" now ");
    paramString.append(paramInt1);
    throw new IllegalStateException(paramString.toString());
  }
  
  private final int b(boolean paramBoolean)
  {
    if (this.f) {
      throw new IllegalStateException("commit already called");
    }
    this.f = true;
    if (this.a) {}
    for (this.i = this.j.a(this);; this.i = -1)
    {
      this.j.a(this, paramBoolean);
      return this.i;
    }
  }
  
  public final int a()
  {
    return b(false);
  }
  
  public final at a(int paramInt)
  {
    this.r = paramInt;
    return this;
  }
  
  public final at a(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.m = 0;
    this.n = 0;
    return this;
  }
  
  public final at a(int paramInt, Fragment paramFragment)
  {
    a(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public final at a(int paramInt, Fragment paramFragment, String paramString)
  {
    a(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public final at a(Fragment paramFragment)
  {
    a(new g(3, paramFragment));
    return this;
  }
  
  public final at a(Fragment paramFragment, String paramString)
  {
    a(0, paramFragment, paramString, 1);
    return this;
  }
  
  public final at a(View paramView, String paramString)
  {
    if ((au.a != null) || (au.b != null))
    {
      paramView = ac.v(paramView);
      if (paramView == null) {
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
      }
      if (this.p != null) {
        break label80;
      }
      this.p = new ArrayList();
      this.q = new ArrayList();
    }
    label80:
    do
    {
      this.p.add(paramView);
      this.q.add(paramString);
      return this;
      if (this.q.contains(paramString))
      {
        paramView = new StringBuilder();
        paramView.append("A shared element with the target name '");
        paramView.append(paramString);
        paramView.append("' has already been added to the transaction.");
        throw new IllegalArgumentException(paramView.toString());
      }
    } while (!this.p.contains(paramView));
    paramString = new StringBuilder();
    paramString.append("A shared element with the source name '");
    paramString.append(paramView);
    paramString.append(" has already been added to the transaction.");
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public final at a(String paramString)
  {
    if (!this.t) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.a = true;
    this.k = paramString;
    return this;
  }
  
  final void a(g paramg)
  {
    this.l.add(paramg);
    paramg.b = this.g;
    paramg.c = this.h;
    paramg.e = this.m;
    paramg.f = this.n;
  }
  
  final void a(boolean paramBoolean)
  {
    int i1 = this.l.size() - 1;
    Object localObject1;
    if (i1 >= 0)
    {
      localObject1 = (g)this.l.get(i1);
      Object localObject2 = ((g)localObject1).d;
      if (localObject2 != null) {
        ((Fragment)localObject2).a(z.d(this.r), this.s);
      }
      switch (((g)localObject1).a)
      {
      case 2: 
      default: 
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Unknown cmd: ");
        ((StringBuilder)localObject2).append(((g)localObject1).a);
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
      case 1: 
        ((Fragment)localObject2).d(((g)localObject1).f);
        this.j.c((Fragment)localObject2);
      }
      for (;;)
      {
        if (this.o) {}
        for (;;)
        {
          i1 -= 1;
          break;
          if ((((g)localObject1).a != 3) && (localObject2 != null)) {
            this.j.a((Fragment)localObject2);
          }
        }
        this.j.h((Fragment)localObject2);
        continue;
        this.j.h(null);
        continue;
        ((Fragment)localObject2).d(((g)localObject1).f);
        this.j.f((Fragment)localObject2);
        continue;
        ((Fragment)localObject2).d(((g)localObject1).e);
        this.j.g((Fragment)localObject2);
        continue;
        ((Fragment)localObject2).d(((g)localObject1).f);
        z.d((Fragment)localObject2);
        continue;
        ((Fragment)localObject2).d(((g)localObject1).e);
        z.e((Fragment)localObject2);
        continue;
        ((Fragment)localObject2).d(((g)localObject1).e);
        this.j.a((Fragment)localObject2, false);
      }
    }
    if ((!this.o) && (paramBoolean))
    {
      localObject1 = this.j;
      ((z)localObject1).a(((z)localObject1).d, true);
    }
  }
  
  public final boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramArrayList1.add(this);
    paramArrayList2.add(Boolean.valueOf(false));
    if (this.a)
    {
      paramArrayList1 = this.j;
      if (paramArrayList1.b == null) {
        paramArrayList1.b = new ArrayList();
      }
      paramArrayList1.b.add(this);
    }
    return true;
  }
  
  public final int b()
  {
    return b(true);
  }
  
  public final at b(int paramInt, Fragment paramFragment)
  {
    return b(paramInt, paramFragment, null);
  }
  
  public final at b(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    a(paramInt, paramFragment, paramString, 2);
    return this;
  }
  
  public final at b(Fragment paramFragment)
  {
    a(new g(6, paramFragment));
    return this;
  }
  
  final void b(int paramInt)
  {
    if (this.a)
    {
      int i2 = this.l.size();
      int i1 = 0;
      if (i1 < i2)
      {
        Fragment localFragment = ((g)this.l.get(i1)).d;
        if (localFragment == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localFragment.h += paramInt;
        }
      }
    }
  }
  
  public final at c(Fragment paramFragment)
  {
    a(new g(7, paramFragment));
    return this;
  }
  
  public final void c()
  {
    if (this.a) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    this.t = false;
    z localz = this.j;
    localz.a(false);
    if (a(localz.k, localz.j)) {
      localz.e = true;
    }
    try
    {
      localz.a(localz.k, localz.j);
      localz.j();
      localz.l();
      return;
    }
    finally
    {
      localz.j();
    }
  }
  
  final boolean c(int paramInt)
  {
    int i3 = this.l.size();
    int i1 = 0;
    if (i1 < i3)
    {
      Fragment localFragment = ((g)this.l.get(i1)).d;
      if (localFragment != null) {}
      for (int i2 = localFragment.m;; i2 = 0)
      {
        if (i2 == 0) {}
        while (i2 != paramInt)
        {
          i1 += 1;
          break;
        }
        return true;
      }
    }
    return false;
  }
  
  final void d()
  {
    int i2 = this.l.size();
    int i1 = 0;
    Object localObject1;
    if (i1 < i2)
    {
      localObject1 = (g)this.l.get(i1);
      Object localObject2 = ((g)localObject1).d;
      if (localObject2 != null) {
        ((Fragment)localObject2).a(this.r, this.s);
      }
      switch (((g)localObject1).a)
      {
      case 2: 
      default: 
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Unknown cmd: ");
        ((StringBuilder)localObject2).append(((g)localObject1).a);
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
      case 1: 
        ((Fragment)localObject2).d(((g)localObject1).b);
        this.j.a((Fragment)localObject2, false);
      }
      for (;;)
      {
        if (this.o) {}
        for (;;)
        {
          i1 += 1;
          break;
          if ((((g)localObject1).a != 1) && (localObject2 != null)) {
            this.j.a((Fragment)localObject2);
          }
        }
        this.j.h(null);
        continue;
        this.j.h((Fragment)localObject2);
        continue;
        ((Fragment)localObject2).d(((g)localObject1).b);
        this.j.g((Fragment)localObject2);
        continue;
        ((Fragment)localObject2).d(((g)localObject1).c);
        this.j.f((Fragment)localObject2);
        continue;
        ((Fragment)localObject2).d(((g)localObject1).b);
        z.e((Fragment)localObject2);
        continue;
        ((Fragment)localObject2).d(((g)localObject1).c);
        z.d((Fragment)localObject2);
        continue;
        ((Fragment)localObject2).d(((g)localObject1).c);
        this.j.c((Fragment)localObject2);
      }
    }
    if (!this.o)
    {
      localObject1 = this.j;
      ((z)localObject1).a(((z)localObject1).d, true);
    }
  }
  
  public final String e()
  {
    return this.k;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.i >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.i);
    }
    if (this.k != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.k);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */