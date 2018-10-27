package android.support.v7.widget;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

final class dg
{
  public final Object[] a;
  public final Object[] b;
  private final int[] c;
  
  dg(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    int j = paramArrayOfObject1.length;
    int[] arrayOfInt = new int[j];
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfObject1[i];
      Integer localInteger2 = (Integer)localHashMap.get(localObject);
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null)
      {
        localInteger1 = Integer.valueOf(localHashMap.size());
        localHashMap.put(localObject, localInteger1);
      }
      arrayOfInt[i] = localInteger1.intValue();
      i += 1;
    }
    this.c = arrayOfInt;
    this.a = a(paramArrayOfObject1, this.c);
    this.b = a(paramArrayOfObject2, this.c);
  }
  
  private static Object[] a(Object[] paramArrayOfObject, int[] paramArrayOfInt)
  {
    int j = paramArrayOfObject.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), GridLayout.a(paramArrayOfInt, -1) + 1);
    int i = 0;
    while (i < j)
    {
      arrayOfObject[paramArrayOfInt[i]] = paramArrayOfObject[i];
      i += 1;
    }
    return arrayOfObject;
  }
  
  public final Object a(int paramInt)
  {
    return this.b[this.c[paramInt]];
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */