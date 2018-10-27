package android.support.f;

import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class al
  extends z
{
  public int q;
  public boolean r = false;
  public ArrayList s = new ArrayList();
  private int t = 0;
  private boolean u = true;
  
  public final al a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid parameter for TransitionSet ordering: ");
      localStringBuilder.append(paramInt);
      throw new AndroidRuntimeException(localStringBuilder.toString());
    case 0: 
      this.u = true;
      return this;
    }
    this.u = false;
    return this;
  }
  
  public final al a(z paramz)
  {
    this.s.add(paramz);
    paramz.i = this;
    long l = this.c;
    if (l >= 0L) {
      paramz.a(l);
    }
    if ((this.t & 0x1) == 0) {}
    for (;;)
    {
      if ((this.t & 0x2) == 0) {}
      for (;;)
      {
        if ((this.t & 0x4) == 0) {}
        for (;;)
        {
          if ((this.t & 0x8) != 0) {
            paramz.a(this.f);
          }
          return this;
          paramz.a(this.j);
        }
        paramz.a(this.k);
      }
      paramz.a(this.g);
    }
  }
  
  public final z a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.s.size())
    {
      ((z)this.s.get(i)).a(paramString, paramBoolean);
      i += 1;
    }
    return super.a(paramString, paramBoolean);
  }
  
  final String a(String paramString)
  {
    Object localObject = super.a(paramString);
    int i = 0;
    while (i < this.s.size())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("\n");
      localObject = (z)this.s.get(i);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("  ");
      localStringBuilder1.append(((z)localObject).a(localStringBuilder2.toString()));
      localObject = localStringBuilder1.toString();
      i += 1;
    }
    return (String)localObject;
  }
  
  public final void a(ae paramae)
  {
    super.a(paramae);
    this.t |= 0x8;
    int j = this.s.size();
    int i = 0;
    while (i < j)
    {
      ((z)this.s.get(i)).a(paramae);
      i += 1;
    }
  }
  
  public final void a(ak paramak)
  {
    super.a(paramak);
    this.t |= 0x2;
    int j = this.s.size();
    int i = 0;
    while (i < j)
    {
      ((z)this.s.get(i)).a(paramak);
      i += 1;
    }
  }
  
  public final void a(ap paramap)
  {
    if (a(paramap.c))
    {
      ArrayList localArrayList = this.s;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        z localz = (z)localArrayList.get(i);
        if (localz.a(paramap.c))
        {
          localz.a(paramap);
          paramap.a.add(localz);
        }
        i += 1;
      }
    }
  }
  
  public final void a(v paramv)
  {
    super.a(paramv);
    this.t |= 0x4;
    int i = 0;
    while (i < this.s.size())
    {
      ((z)this.s.get(i)).a(paramv);
      i += 1;
    }
  }
  
  protected final void a(ViewGroup paramViewGroup, aq paramaq1, aq paramaq2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    long l1 = this.l;
    int j = this.s.size();
    int i = 0;
    if (i < j)
    {
      z localz = (z)this.s.get(i);
      if (l1 > 0L) {
        if (!this.u) {
          break label110;
        }
      }
      for (;;)
      {
        long l2 = localz.l;
        if (l2 > 0L) {
          localz.b(l2 + l1);
        }
        label110:
        do
        {
          for (;;)
          {
            localz.a(paramViewGroup, paramaq1, paramaq2, paramArrayList1, paramArrayList2);
            i += 1;
            break;
            localz.b(l1);
          }
        } while (i != 0);
      }
    }
  }
  
  public final z b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.s.size())) {
      return (z)this.s.get(paramInt);
    }
    return null;
  }
  
  public final void b(ap paramap)
  {
    if (a(paramap.c))
    {
      ArrayList localArrayList = this.s;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        z localz = (z)localArrayList.get(i);
        if (localz.a(paramap.c))
        {
          localz.b(paramap);
          paramap.a.add(localz);
        }
        i += 1;
      }
    }
  }
  
  final void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    int j = this.s.size();
    int i = 0;
    while (i < j)
    {
      ((z)this.s.get(i)).b(paramBoolean);
      i += 1;
    }
  }
  
  protected final void c()
  {
    if (this.s.isEmpty())
    {
      d();
      e();
    }
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = new an(this);
        ArrayList localArrayList = this.s;
        int j = localArrayList.size();
        i = 0;
        while (i < j)
        {
          ((z)localArrayList.get(i)).a((af)localObject);
          i += 1;
        }
        this.q = this.s.size();
        if (!this.u) {
          break;
        }
        localObject = this.s;
        j = ((ArrayList)localObject).size();
        i = 0;
        while (i < j)
        {
          ((z)((ArrayList)localObject).get(i)).c();
          i += 1;
        }
      }
      int i = 1;
      while (i < this.s.size())
      {
        ((z)this.s.get(i - 1)).a(new am((z)this.s.get(i)));
        i += 1;
      }
      localObject = (z)this.s.get(0);
    } while (localObject == null);
    ((z)localObject).c();
  }
  
  final void c(ap paramap)
  {
    super.c(paramap);
    int j = this.s.size();
    int i = 0;
    while (i < j)
    {
      ((z)this.s.get(i)).c(paramap);
      i += 1;
    }
  }
  
  public final void d(View paramView)
  {
    super.d(paramView);
    int j = this.s.size();
    int i = 0;
    while (i < j)
    {
      ((z)this.s.get(i)).d(paramView);
      i += 1;
    }
  }
  
  public final void e(View paramView)
  {
    super.e(paramView);
    int j = this.s.size();
    int i = 0;
    while (i < j)
    {
      ((z)this.s.get(i)).e(paramView);
      i += 1;
    }
  }
  
  public final z f()
  {
    al localal = (al)super.f();
    localal.s = new ArrayList();
    int j = this.s.size();
    int i = 0;
    while (i < j)
    {
      localal.a((z)((z)this.s.get(i)).clone());
      i += 1;
    }
    return localal;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */