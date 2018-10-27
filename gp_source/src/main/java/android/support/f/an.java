package android.support.f;

final class an
  extends ag
{
  private al a;
  
  an(al paramal)
  {
    this.a = paramal;
  }
  
  public final void a(z paramz)
  {
    al localal = this.a;
    localal.q -= 1;
    if (localal.q == 0)
    {
      localal.r = false;
      localal.e();
    }
    paramz.b(this);
  }
  
  public final void c()
  {
    al localal = this.a;
    if (!localal.r)
    {
      localal.d();
      this.a.r = true;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */