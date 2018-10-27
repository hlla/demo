package android.support.v7.widget;

final class hx
{
  public int a = 0;
  public int b;
  public int c;
  public int d;
  public int e;
  
  private static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt1 != paramInt2) {
      return 4;
    }
    return 2;
  }
  
  final void a(int paramInt)
  {
    this.a |= paramInt;
  }
  
  final boolean a()
  {
    boolean bool2 = false;
    int i = this.a;
    boolean bool1;
    if ((i & 0x7) != 0)
    {
      bool1 = bool2;
      if ((i & a(this.c, this.e)) == 0) {}
    }
    else
    {
      i = this.a;
      if ((i & 0x70) != 0)
      {
        bool1 = bool2;
        if ((i & a(this.c, this.d) << 4) == 0) {}
      }
      else
      {
        i = this.a;
        if ((i & 0x700) != 0)
        {
          bool1 = bool2;
          if ((i & a(this.b, this.e) << 8) == 0) {}
        }
        else
        {
          i = this.a;
          if ((i & 0x7000) != 0)
          {
            bool1 = bool2;
            if ((i & a(this.b, this.d) << 12) == 0) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */