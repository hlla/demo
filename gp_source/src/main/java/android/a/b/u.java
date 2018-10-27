package android.a.b;

final class u
  implements Runnable
{
  u(t paramt) {}
  
  public final void run()
  {
    synchronized (this.a.d)
    {
      Object localObject2 = this.a.e;
      this.a.e = t.a;
      this.a.a(localObject2);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */