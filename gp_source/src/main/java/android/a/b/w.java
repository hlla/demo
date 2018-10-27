package android.a.b;

abstract class w
{
  public boolean a;
  public int b = -1;
  public final z c;
  
  w(t paramt, z paramz)
  {
    this.c = paramz;
  }
  
  final void a(boolean paramBoolean)
  {
    t localt;
    int j;
    if (paramBoolean != this.a)
    {
      this.a = paramBoolean;
      localt = this.d;
      j = localt.b;
      paramBoolean = this.a;
      if (paramBoolean) {
        break label102;
      }
    }
    label102:
    for (int i = -1;; i = 1)
    {
      localt.b = (i + j);
      if (j != 0) {}
      for (;;)
      {
        localt = this.d;
        if ((localt.b == 0) && (!this.a)) {
          localt.b();
        }
        if (this.a) {
          this.d.a(this);
        }
        return;
        if (paramBoolean) {
          localt.a();
        }
      }
    }
  }
  
  abstract boolean a();
  
  boolean a(n paramn)
  {
    return false;
  }
  
  void b() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */