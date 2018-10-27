package android.support.v7.widget;

import android.support.v4.g.r;
import android.support.v4.g.s;

final class ia
{
  public static r d = new s(20);
  public int a;
  public fc b;
  public fc c;
  
  static ia a()
  {
    ia localia2 = (ia)d.a();
    ia localia1 = localia2;
    if (localia2 == null) {
      localia1 = new ia();
    }
    return localia1;
  }
  
  static void a(ia paramia)
  {
    paramia.a = 0;
    paramia.c = null;
    paramia.b = null;
    d.a(paramia);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */