package android.support.v7.app;

final class ac
  implements Runnable
{
  ac(aa paramaa) {}
  
  public final void run()
  {
    aa localaa = this.a;
    if ((localaa.k & 0x1) != 0) {
      localaa.e(0);
    }
    localaa = this.a;
    if ((localaa.k & 0x1000) != 0) {
      localaa.e(108);
    }
    localaa = this.a;
    localaa.l = false;
    localaa.k = 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */