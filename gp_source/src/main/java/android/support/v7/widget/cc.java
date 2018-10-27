package android.support.v7.widget;

final class cc
  extends fm
{
  cc(ca paramca) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    ca localca = this.a;
    paramInt1 = paramRecyclerView.computeHorizontalScrollOffset();
    paramInt2 = paramRecyclerView.computeVerticalScrollOffset();
    int i = localca.f.computeVerticalScrollRange();
    int j = localca.g;
    boolean bool;
    if (i - j > 0) {
      if (j >= localca.i) {
        bool = true;
      }
    }
    for (;;)
    {
      localca.e = bool;
      int k = localca.f.computeHorizontalScrollRange();
      int m = localca.h;
      if (k - m > 0) {
        if (m >= localca.i) {
          bool = true;
        }
      }
      for (;;)
      {
        localca.d = bool;
        bool = localca.e;
        if (bool)
        {
          float f;
          if (bool)
          {
            f = j;
            localca.l = ((int)(f * (paramInt2 + f / 2.0F) / i));
            localca.n = Math.min(j, j * j / i);
          }
          if (localca.d)
          {
            f = m;
            localca.b = ((int)(f * (paramInt1 + f / 2.0F) / k));
            localca.c = Math.min(m, m * m / k);
          }
          paramInt1 = localca.k;
          if (paramInt1 == 0) {
            label227:
            localca.a(1);
          }
        }
        do
        {
          do
          {
            return;
          } while (paramInt1 != 1);
          break label227;
          if (localca.d) {
            break;
          }
        } while (localca.k == 0);
        localca.a(0);
        return;
        bool = false;
        continue;
        bool = false;
      }
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */