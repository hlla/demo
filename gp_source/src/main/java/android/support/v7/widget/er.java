package android.support.v7.widget;

final class er
  implements ib
{
  er(RecyclerView paramRecyclerView) {}
  
  public final void a(fz paramfz)
  {
    Object localObject2 = this.a;
    Object localObject1 = ((RecyclerView)localObject2).u;
    paramfz = paramfz.c;
    localObject2 = ((RecyclerView)localObject2).B;
    localObject1 = ((ff)localObject1).f;
    int i = ((be)localObject1).b.a(paramfz);
    if (i >= 0)
    {
      if (((be)localObject1).a.d(i)) {
        ((be)localObject1).b(paramfz);
      }
      ((be)localObject1).b.a(i);
    }
    ((fp)localObject2).a(paramfz);
  }
  
  public final void a(fz paramfz, fc paramfc1, fc paramfc2)
  {
    this.a.B.b(paramfz);
    RecyclerView localRecyclerView = this.a;
    localRecyclerView.a(paramfz);
    paramfz.a(false);
    if (localRecyclerView.q.animateDisappearance(paramfz, paramfc1, paramfc2)) {
      localRecyclerView.m();
    }
  }
  
  public final void b(fz paramfz, fc paramfc1, fc paramfc2)
  {
    RecyclerView localRecyclerView = this.a;
    paramfz.a(false);
    if (localRecyclerView.q.animateAppearance(paramfz, paramfc1, paramfc2)) {
      localRecyclerView.m();
    }
  }
  
  public final void c(fz paramfz, fc paramfc1, fc paramfc2)
  {
    paramfz.a(false);
    RecyclerView localRecyclerView = this.a;
    if (localRecyclerView.l) {
      if (localRecyclerView.q.animateChange(paramfz, paramfz, paramfc1, paramfc2)) {
        this.a.m();
      }
    }
    while (!localRecyclerView.q.animatePersistence(paramfz, paramfc1, paramfc2)) {
      return;
    }
    this.a.m();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */