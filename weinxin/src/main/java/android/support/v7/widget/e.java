package android.support.v7.widget;

import android.support.v4.e.h.a;
import android.support.v4.e.h.b;
import java.util.ArrayList;
import java.util.List;

final class e
  implements aa.a
{
  private h.a<b> Ub = new h.b(30);
  final ArrayList<b> Uc = new ArrayList();
  final ArrayList<b> Ud = new ArrayList();
  final a Ue;
  Runnable Uf;
  final boolean Ug;
  final aa Uh;
  int Ui = 0;
  
  e(a parama)
  {
    this(parama, (byte)0);
  }
  
  private e(a parama, byte paramByte)
  {
    this.Ue = parama;
    this.Ug = false;
    this.Uh = new aa(this);
  }
  
  private void a(b paramb)
  {
    if ((paramb.ou == 1) || (paramb.ou == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = s(paramb.Uj, paramb.ou);
    int j = paramb.Uj;
    int k;
    int n;
    int m;
    label109:
    int i2;
    switch (paramb.ou)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update." + paramb);
    case 4: 
      k = 1;
      n = 1;
      m = 1;
      if (m >= paramb.Ul) {
        break label294;
      }
      i2 = s(paramb.Uj + k * m, paramb.ou);
      switch (paramb.ou)
      {
      case 3: 
      default: 
        i = 0;
        label170:
        if (i == 0) {}
        break;
      }
      break;
    }
    for (int i = n + 1;; i = n)
    {
      m += 1;
      n = i;
      break label109;
      k = 0;
      break;
      if (i2 == i1 + 1)
      {
        i = 1;
        break label170;
      }
      i = 0;
      break label170;
      if (i2 == i1)
      {
        i = 1;
        break label170;
      }
      i = 0;
      break label170;
      localObject = a(paramb.ou, i1, n, paramb.Uk);
      a((b)localObject, j);
      c((b)localObject);
      i = j;
      if (paramb.ou == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label294:
    Object localObject = paramb.Uk;
    c(paramb);
    if (n > 0)
    {
      paramb = a(paramb.ou, i1, n, localObject);
      a(paramb, j);
      c(paramb);
    }
  }
  
  private void a(b paramb, int paramInt)
  {
    this.Ue.d(paramb);
    switch (paramb.ou)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      this.Ue.u(paramInt, paramb.Ul);
      return;
    }
    this.Ue.a(paramInt, paramb.Ul, paramb.Uk);
  }
  
  private boolean aG(int paramInt)
  {
    int k = this.Ud.size();
    int i = 0;
    while (i < k)
    {
      b localb = (b)this.Ud.get(i);
      if (localb.ou == 8)
      {
        if (t(localb.Ul, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localb.ou == 1)
      {
        int m = localb.Uj;
        int n = localb.Ul;
        int j = localb.Uj;
        while (j < m + n)
        {
          if (t(j, i + 1) == paramInt) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void b(b paramb)
  {
    this.Ud.add(paramb);
    switch (paramb.ou)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for " + paramb);
    case 1: 
      this.Ue.w(paramb.Uj, paramb.Ul);
      return;
    case 8: 
      this.Ue.x(paramb.Uj, paramb.Ul);
      return;
    case 2: 
      this.Ue.v(paramb.Uj, paramb.Ul);
      return;
    }
    this.Ue.a(paramb.Uj, paramb.Ul, paramb.Uk);
  }
  
  private void f(List<b> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      c((b)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  private int s(int paramInt1, int paramInt2)
  {
    int i = this.Ud.size() - 1;
    b localb;
    if (i >= 0)
    {
      localb = (b)this.Ud.get(i);
      int k;
      int j;
      if (localb.ou == 8) {
        if (localb.Uj < localb.Ul)
        {
          k = localb.Uj;
          j = localb.Ul;
          label64:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label195;
          }
          if (k != localb.Uj) {
            break label151;
          }
          if (paramInt2 != 1) {
            break label131;
          }
          localb.Ul += 1;
          label103:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localb.Ul;
        j = localb.Uj;
        break label64;
        label131:
        if (paramInt2 != 2) {
          break label103;
        }
        localb.Ul -= 1;
        break label103;
        label151:
        if (paramInt2 == 1) {
          localb.Uj += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localb.Uj -= 1;
          }
        }
        label195:
        if (paramInt1 < localb.Uj)
        {
          if (paramInt2 == 1)
          {
            localb.Uj += 1;
            localb.Ul += 1;
            continue;
          }
          if (paramInt2 == 2)
          {
            localb.Uj -= 1;
            localb.Ul -= 1;
          }
        }
        continue;
        if (localb.Uj <= paramInt1)
        {
          if (localb.ou == 1) {
            paramInt1 -= localb.Ul;
          } else if (localb.ou == 2) {
            paramInt1 = localb.Ul + paramInt1;
          }
        }
        else if (paramInt2 == 1) {
          localb.Uj += 1;
        } else if (paramInt2 == 2) {
          localb.Uj -= 1;
        }
      }
    }
    paramInt2 = this.Ud.size() - 1;
    if (paramInt2 >= 0)
    {
      localb = (b)this.Ud.get(paramInt2);
      if (localb.ou == 8) {
        if ((localb.Ul == localb.Uj) || (localb.Ul < 0))
        {
          this.Ud.remove(paramInt2);
          c(localb);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localb.Ul <= 0)
        {
          this.Ud.remove(paramInt2);
          c(localb);
        }
      }
    }
    return paramInt1;
  }
  
  public final b a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    b localb = (b)this.Ub.bF();
    if (localb == null) {
      return new b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localb.ou = paramInt1;
    localb.Uj = paramInt2;
    localb.Ul = paramInt3;
    localb.Uk = paramObject;
    return localb;
  }
  
  final boolean aH(int paramInt)
  {
    return (this.Ui & paramInt) != 0;
  }
  
  final int aI(int paramInt)
  {
    return t(paramInt, 0);
  }
  
  public final void c(b paramb)
  {
    if (!this.Ug)
    {
      paramb.Uk = null;
      this.Ub.i(paramb);
    }
  }
  
  final void er()
  {
    aa localaa = this.Uh;
    ArrayList localArrayList = this.Uc;
    int i;
    label24:
    label53:
    int i1;
    b localb2;
    b localb3;
    int k;
    for (;;)
    {
      j = 0;
      i = localArrayList.size() - 1;
      if (i < 0) {
        break label268;
      }
      if (((b)localArrayList.get(i)).ou != 8) {
        break;
      }
      if (j == 0) {
        break label1835;
      }
      j = i;
      if (j == -1) {
        break label1251;
      }
      i1 = j + 1;
      localb2 = (b)localArrayList.get(j);
      localb3 = (b)localArrayList.get(i1);
      switch (localb3.ou)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = 0;
        if (localb2.Ul < localb3.Uj) {
          i = -1;
        }
        k = i;
        if (localb2.Uj < localb3.Uj) {
          k = i + 1;
        }
        if (localb3.Uj <= localb2.Uj) {
          localb2.Uj += localb3.Ul;
        }
        if (localb3.Uj <= localb2.Ul) {
          localb2.Ul += localb3.Ul;
        }
        localb3.Uj = (k + localb3.Uj);
        localArrayList.set(j, localb3);
        localArrayList.set(i1, localb2);
      }
    }
    int j = 1;
    label268:
    label344:
    label369:
    label491:
    label567:
    label655:
    label780:
    label958:
    label1002:
    label1027:
    label1149:
    label1227:
    label1251:
    label1458:
    label1526:
    label1835:
    for (;;)
    {
      i -= 1;
      break label24;
      j = -1;
      break label53;
      b localb1 = null;
      int m = 0;
      int n;
      if (localb2.Uj < localb2.Ul)
      {
        n = 0;
        k = n;
        i = m;
        if (localb3.Uj == localb2.Uj)
        {
          k = n;
          i = m;
          if (localb3.Ul == localb2.Ul - localb2.Uj)
          {
            i = 1;
            k = n;
          }
        }
        if (localb2.Ul >= localb3.Uj) {
          break label491;
        }
        localb3.Uj -= 1;
        if (localb2.Uj > localb3.Uj) {
          break label567;
        }
        localb3.Uj += 1;
      }
      int i2;
      for (;;)
      {
        if (i == 0) {
          break label655;
        }
        localArrayList.set(j, localb3);
        localArrayList.remove(i1);
        localaa.YP.c(localb2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localb3.Uj != localb2.Ul + 1) {
          break label344;
        }
        k = n;
        i = m;
        if (localb3.Ul != localb2.Uj - localb2.Ul) {
          break label344;
        }
        i = 1;
        k = n;
        break label344;
        if (localb2.Ul >= localb3.Uj + localb3.Ul) {
          break label369;
        }
        localb3.Ul -= 1;
        localb2.ou = 2;
        localb2.Ul = 1;
        if (localb3.Ul != 0) {
          break;
        }
        localArrayList.remove(i1);
        localaa.YP.c(localb3);
        break;
        if (localb2.Uj < localb3.Uj + localb3.Ul)
        {
          m = localb3.Uj;
          n = localb3.Ul;
          i2 = localb2.Uj;
          localb1 = localaa.YP.a(2, localb2.Uj + 1, m + n - i2, null);
          localb3.Ul = (localb2.Uj - localb3.Uj);
        }
      }
      if (k != 0)
      {
        if (localb1 != null)
        {
          if (localb2.Uj > localb1.Uj) {
            localb2.Uj -= localb1.Ul;
          }
          if (localb2.Ul > localb1.Uj) {
            localb2.Ul -= localb1.Ul;
          }
        }
        if (localb2.Uj > localb3.Uj) {
          localb2.Uj -= localb3.Ul;
        }
        if (localb2.Ul > localb3.Uj) {
          localb2.Ul -= localb3.Ul;
        }
        localArrayList.set(j, localb3);
        if (localb2.Uj == localb2.Ul) {
          break label958;
        }
        localArrayList.set(i1, localb2);
      }
      while (localb1 != null)
      {
        localArrayList.add(j, localb1);
        break;
        if (localb1 != null)
        {
          if (localb2.Uj >= localb1.Uj) {
            localb2.Uj -= localb1.Ul;
          }
          if (localb2.Ul >= localb1.Uj) {
            localb2.Ul -= localb1.Ul;
          }
        }
        if (localb2.Uj >= localb3.Uj) {
          localb2.Uj -= localb3.Ul;
        }
        if (localb2.Ul < localb3.Uj) {
          break label780;
        }
        localb2.Ul -= localb3.Ul;
        break label780;
        localArrayList.remove(i1);
      }
      localb1 = null;
      Object localObject = null;
      if (localb2.Ul < localb3.Uj)
      {
        localb3.Uj -= 1;
        if (localb2.Uj > localb3.Uj) {
          break label1149;
        }
        localb3.Uj += 1;
        localArrayList.set(i1, localb2);
        if (localb3.Ul <= 0) {
          break label1227;
        }
        localArrayList.set(j, localb3);
      }
      for (;;)
      {
        if (localb1 != null) {
          localArrayList.add(j, localb1);
        }
        if (localObject == null) {
          break;
        }
        localArrayList.add(j, localObject);
        break;
        if (localb2.Ul >= localb3.Uj + localb3.Ul) {
          break label1002;
        }
        localb3.Ul -= 1;
        localb1 = localaa.YP.a(4, localb2.Uj, 1, localb3.Uk);
        break label1002;
        if (localb2.Uj >= localb3.Uj + localb3.Ul) {
          break label1027;
        }
        i = localb3.Uj + localb3.Ul - localb2.Uj;
        localObject = localaa.YP.a(4, localb2.Uj + 1, i, localb3.Uk);
        localb3.Ul -= i;
        break label1027;
        localArrayList.remove(j);
        localaa.YP.c(localb3);
      }
      int i3 = this.Uc.size();
      i1 = 0;
      if (i1 < i3)
      {
        localb1 = (b)this.Uc.get(i1);
        switch (localb1.ou)
        {
        }
        for (;;)
        {
          if (this.Uf != null) {
            this.Uf.run();
          }
          i1 += 1;
          break;
          b(localb1);
          continue;
          int i4 = localb1.Uj;
          i = localb1.Uj;
          k = localb1.Ul + i;
          i2 = -1;
          i = localb1.Uj;
          n = 0;
          if (i < k)
          {
            j = 0;
            m = 0;
            if ((this.Ue.aJ(i) != null) || (aG(i)))
            {
              if (i2 == 0)
              {
                a(a(2, i4, n, null));
                m = 1;
              }
              j = 1;
              if (m == 0) {
                break label1526;
              }
              m = i - n;
              i = k - n;
            }
            for (k = 1;; k = n)
            {
              n = k;
              k = i;
              i = m + 1;
              i2 = j;
              break;
              if (i2 == 1)
              {
                b(a(2, i4, n, null));
                j = 1;
              }
              i2 = 0;
              m = j;
              j = i2;
              break label1458;
              n += 1;
              m = i;
              i = k;
            }
          }
          localObject = localb1;
          if (n != localb1.Ul)
          {
            c(localb1);
            localObject = a(2, i4, n, null);
          }
          if (i2 == 0)
          {
            a((b)localObject);
          }
          else
          {
            b((b)localObject);
            continue;
            k = localb1.Uj;
            i4 = localb1.Uj;
            int i5 = localb1.Ul;
            i = localb1.Uj;
            j = 0;
            i2 = -1;
            if (i < i4 + i5)
            {
              if ((this.Ue.aJ(i) != null) || (aG(i)))
              {
                m = j;
                n = k;
                if (i2 == 0)
                {
                  a(a(4, k, j, localb1.Uk));
                  m = 0;
                  n = i;
                }
                k = n;
              }
              for (j = 1;; j = 0)
              {
                i += 1;
                m += 1;
                i2 = j;
                j = m;
                break;
                m = j;
                n = k;
                if (i2 == 1)
                {
                  b(a(4, k, j, localb1.Uk));
                  m = 0;
                  n = i;
                }
                k = n;
              }
            }
            localObject = localb1;
            if (j != localb1.Ul)
            {
              localObject = localb1.Uk;
              c(localb1);
              localObject = a(4, k, j, localObject);
            }
            if (i2 == 0)
            {
              a((b)localObject);
            }
            else
            {
              b((b)localObject);
              continue;
              b(localb1);
            }
          }
        }
      }
      this.Uc.clear();
      return;
    }
  }
  
  final void es()
  {
    int j = this.Ud.size();
    int i = 0;
    while (i < j)
    {
      this.Ue.e((b)this.Ud.get(i));
      i += 1;
    }
    f(this.Ud);
    this.Ui = 0;
  }
  
  final boolean et()
  {
    return this.Uc.size() > 0;
  }
  
  final void eu()
  {
    es();
    int j = this.Uc.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.Uc.get(i);
      switch (localb.ou)
      {
      }
      for (;;)
      {
        if (this.Uf != null) {
          this.Uf.run();
        }
        i += 1;
        break;
        this.Ue.e(localb);
        this.Ue.w(localb.Uj, localb.Ul);
        continue;
        this.Ue.e(localb);
        this.Ue.u(localb.Uj, localb.Ul);
        continue;
        this.Ue.e(localb);
        this.Ue.a(localb.Uj, localb.Ul, localb.Uk);
        continue;
        this.Ue.e(localb);
        this.Ue.x(localb.Uj, localb.Ul);
      }
    }
    f(this.Uc);
    this.Ui = 0;
  }
  
  final void reset()
  {
    f(this.Uc);
    f(this.Ud);
    this.Ui = 0;
  }
  
  final int t(int paramInt1, int paramInt2)
  {
    int k = this.Ud.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    b localb;
    if (j < k)
    {
      localb = (b)this.Ud.get(j);
      if (localb.ou == 8) {
        if (localb.Uj == paramInt2) {
          paramInt1 = localb.Ul;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localb.Uj < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localb.Ul <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localb.Uj <= paramInt2) {
          if (localb.ou == 2)
          {
            if (paramInt2 < localb.Uj + localb.Ul)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localb.Ul;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localb.ou == 1) {
              paramInt1 = paramInt2 + localb.Ul;
            }
          }
        }
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract RecyclerView.t aJ(int paramInt);
    
    public abstract void d(e.b paramb);
    
    public abstract void e(e.b paramb);
    
    public abstract void u(int paramInt1, int paramInt2);
    
    public abstract void v(int paramInt1, int paramInt2);
    
    public abstract void w(int paramInt1, int paramInt2);
    
    public abstract void x(int paramInt1, int paramInt2);
  }
  
  static final class b
  {
    int Uj;
    Object Uk;
    int Ul;
    int ou;
    
    b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.ou = paramInt1;
      this.Uj = paramInt2;
      this.Ul = paramInt3;
      this.Uk = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          do
          {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
              return false;
            }
            paramObject = (b)paramObject;
            if (this.ou != ((b)paramObject).ou) {
              return false;
            }
          } while ((this.ou == 8) && (Math.abs(this.Ul - this.Uj) == 1) && (this.Ul == ((b)paramObject).Uj) && (this.Uj == ((b)paramObject).Ul));
          if (this.Ul != ((b)paramObject).Ul) {
            return false;
          }
          if (this.Uj != ((b)paramObject).Uj) {
            return false;
          }
          if (this.Uk == null) {
            break;
          }
        } while (this.Uk.equals(((b)paramObject).Uk));
        return false;
      } while (((b)paramObject).Uk == null);
      return false;
    }
    
    public final int hashCode()
    {
      return (this.ou * 31 + this.Uj) * 31 + this.Ul;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
      String str;
      switch (this.ou)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        str = "??";
      }
      for (;;)
      {
        return str + ",s:" + this.Uj + "c:" + this.Ul + ",p:" + this.Uk + "]";
        str = "add";
        continue;
        str = "rm";
        continue;
        str = "up";
        continue;
        str = "mv";
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */