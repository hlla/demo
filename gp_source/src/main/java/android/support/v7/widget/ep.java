package android.support.v7.widget;

final class ep
  implements Runnable
{
  ep(RecyclerView paramRecyclerView) {}
  
  public final void run()
  {
    ez localez = this.a.q;
    if (localez != null) {
      localez.runPendingAnimations();
    }
    this.a.z = false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */