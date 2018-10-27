package android.support.constraint.a.a;

import java.util.ArrayList;

public final class m
{
  public ArrayList a = new ArrayList();
  public int b;
  public int c;
  public int d;
  public int e;
  
  public m(f paramf)
  {
    this.d = paramf.aa;
    this.e = paramf.ab;
    this.c = paramf.c();
    this.b = paramf.f();
    paramf = paramf.l();
    int j = paramf.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)paramf.get(i);
      this.a.add(new n(locala));
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */