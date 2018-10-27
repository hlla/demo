package android.support.v7.widget;

import android.view.View;

final class fd
  implements fb
{
  fd(RecyclerView paramRecyclerView) {}
  
  public final void a(fz paramfz)
  {
    int i = 1;
    paramfz.a(true);
    if ((paramfz.o != null) && (paramfz.p == null)) {
      paramfz.o = null;
    }
    paramfz.p = null;
    RecyclerView localRecyclerView;
    Object localObject;
    be localbe;
    int j;
    if ((paramfz.d & 0x10) == 0)
    {
      localRecyclerView = this.a;
      localObject = paramfz.c;
      localRecyclerView.aD_();
      localbe = localRecyclerView.k;
      j = localbe.b.a((View)localObject);
      if (j != -1) {
        break label154;
      }
      localbe.b((View)localObject);
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = RecyclerView.b((View)localObject);
        localRecyclerView.B.b((fz)localObject);
        localRecyclerView.B.a((fz)localObject);
      }
      localRecyclerView.a(i ^ 0x1);
      if ((i == 0) && (paramfz.m())) {
        this.a.removeDetachedView(paramfz.c, false);
      }
      return;
      label154:
      if (localbe.a.c(j))
      {
        localbe.a.d(j);
        localbe.b((View)localObject);
        localbe.b.a(j);
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */