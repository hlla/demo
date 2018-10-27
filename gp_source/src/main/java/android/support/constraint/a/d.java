package android.support.constraint.a;

import java.util.ArrayList;

public final class d
{
  public ArrayList a = new ArrayList();
  
  public final void a(e parame)
  {
    this.a.clear();
    int i = 1;
    h localh1;
    int j;
    if (i < parame.c)
    {
      localh1 = parame.a.b[i];
      j = 0;
      for (;;)
      {
        if (j >= 6)
        {
          localh1.h[localh1.g] = 1.0F;
          if (localh1.f == i.a) {
            this.a.add(localh1);
          }
          i += 1;
          break;
        }
        localh1.h[j] = 0.0F;
        j += 1;
      }
    }
    int m = this.a.size();
    i = 0;
    while (i < m)
    {
      localh1 = (h)this.a.get(i);
      j = localh1.b;
      if (j != -1)
      {
        a locala = parame.e[j].d;
        int n = locala.a;
        j = 0;
        if (j < n)
        {
          h localh2 = locala.a(j);
          if (localh2 != null)
          {
            float f = locala.b(j);
            int k = 0;
            while (k < 6)
            {
              float[] arrayOfFloat = localh2.h;
              arrayOfFloat[k] += localh1.h[k] * f;
              k += 1;
            }
            if (!this.a.contains(localh2)) {
              break label258;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            label258:
            this.a.add(localh2);
          }
        }
        j = 0;
        while (j < 6)
        {
          localh1.h[j] = 0.0F;
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  public final String toString()
  {
    int k = this.a.size();
    int i = 0;
    Object localObject = "Goal: ";
    while (i < k)
    {
      h localh = (h)this.a.get(i);
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append((String)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localh);
      ((StringBuilder)localObject).append("[");
      localObject = ((StringBuilder)localObject).toString();
      int j = 0;
      if (j < localh.h.length)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append((String)localObject);
        localStringBuilder2.append(localh.h[j]);
        localObject = localStringBuilder2.toString();
        if (j < localh.h.length - 1)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append((String)localObject);
          localStringBuilder2.append(", ");
        }
        for (localObject = localStringBuilder2.toString();; localObject = localStringBuilder2.toString())
        {
          j += 1;
          break;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append((String)localObject);
          localStringBuilder2.append("] ");
        }
      }
      localStringBuilder1.append((String)localObject);
      localObject = localStringBuilder1.toString();
      i += 1;
    }
    return (String)localObject;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */