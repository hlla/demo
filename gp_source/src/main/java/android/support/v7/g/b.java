package android.support.v7.g;

public final class b
  implements j
{
  private int a = -1;
  private Object b = null;
  private int c = -1;
  private int d = 0;
  private final j e;
  
  public b(j paramj)
  {
    this.e = paramj;
  }
  
  public final void a()
  {
    int i = this.d;
    if (i != 0) {
      switch (i)
      {
      }
    }
    for (;;)
    {
      this.b = null;
      this.d = 0;
      return;
      this.e.a(this.c, this.a, this.b);
      continue;
      this.e.a(this.c, this.a);
      continue;
      this.e.b(this.c, this.a);
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (this.d == 1)
    {
      int i = this.c;
      if (paramInt1 >= i)
      {
        int j = this.a;
        if (paramInt1 <= i + j)
        {
          this.a = (j + paramInt2);
          this.c = Math.min(paramInt1, i);
          return;
        }
      }
    }
    a();
    this.c = paramInt1;
    this.a = paramInt2;
    this.d = 1;
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.d == 3)
    {
      int i = this.c;
      int j = this.a + i;
      if (paramInt1 <= j)
      {
        int k = paramInt1 + paramInt2;
        if ((k >= i) && (this.b == paramObject))
        {
          this.c = Math.min(paramInt1, i);
          this.a = (Math.max(j, k) - this.c);
          return;
        }
      }
    }
    a();
    this.c = paramInt1;
    this.a = paramInt2;
    this.b = paramObject;
    this.d = 3;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    if (this.d == 2)
    {
      int i = this.c;
      if ((i >= paramInt1) && (i <= paramInt1 + paramInt2)) {}
    }
    else
    {
      a();
      this.c = paramInt1;
      this.a = paramInt2;
      this.d = 2;
      return;
    }
    this.a += paramInt2;
    this.c = paramInt1;
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    a();
    this.e.c(paramInt1, paramInt2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */