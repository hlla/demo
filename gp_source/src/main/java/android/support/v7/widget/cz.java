package android.support.v7.widget;

import android.util.Pair;
import java.lang.reflect.Array;
import java.util.ArrayList;

final class cz
  extends ArrayList
{
  private final Class a;
  private final Class b;
  
  private cz(Class paramClass1, Class paramClass2)
  {
    this.a = paramClass1;
    this.b = paramClass2;
  }
  
  public static cz a(Class paramClass1, Class paramClass2)
  {
    return new cz(paramClass1, paramClass2);
  }
  
  public final dg a()
  {
    int j = size();
    Object[] arrayOfObject1 = (Object[])Array.newInstance(this.a, j);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(this.b, j);
    int i = 0;
    while (i < j)
    {
      arrayOfObject1[i] = ((Pair)get(i)).first;
      arrayOfObject2[i] = ((Pair)get(i)).second;
      i += 1;
    }
    return new dg(arrayOfObject1, arrayOfObject2);
  }
  
  public final void a(Object paramObject1, Object paramObject2)
  {
    add(Pair.create(paramObject1, paramObject2));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */