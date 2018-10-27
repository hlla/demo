package android.support.v7.widget;

final class eo
  implements Runnable
{
  eo(RecyclerView paramRecyclerView) {}
  
  public final void run()
  {
    RecyclerView localRecyclerView = this.a;
    if ((localRecyclerView.m) && (!localRecyclerView.isLayoutRequested()))
    {
      localRecyclerView = this.a;
      if (!localRecyclerView.p) {
        localRecyclerView.requestLayout();
      }
    }
    else
    {
      return;
    }
    if (localRecyclerView.v)
    {
      localRecyclerView.w = true;
      return;
    }
    localRecyclerView.d();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */