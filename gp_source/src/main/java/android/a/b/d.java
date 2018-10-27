package android.a.b;

public final class d
  implements i
{
  private final h[] a;
  
  d(h[] paramArrayOfh)
  {
    this.a = paramArrayOfh;
  }
  
  public final void a(n paramn, k paramk)
  {
    int j = 0;
    new x();
    paramn = this.a;
    int k = paramn.length;
    int i = 0;
    for (;;)
    {
      if (i >= k)
      {
        paramn = this.a;
        k = paramn.length;
        i = j;
        while (i < k)
        {
          paramn[i].a();
          i += 1;
        }
      }
      paramn[i].a();
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */