package android.a.b;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class a
{
  public static a b = new a();
  public final Map a = new HashMap();
  private final Map c = new HashMap();
  
  private static void a(Map paramMap, c paramc, k paramk, Class paramClass)
  {
    k localk = (k)paramMap.get(paramc);
    if (localk == null) {}
    while (paramk == localk)
    {
      if (localk == null) {
        paramMap.put(paramc, paramk);
      }
      return;
    }
    paramMap = paramc.b;
    paramc = new StringBuilder();
    paramc.append("Method ");
    paramc.append(paramMap.getName());
    paramc.append(" in ");
    paramc.append(paramClass.getName());
    paramc.append(" already declared with different @OnLifecycleEvent value: previous value ");
    paramc.append(localk);
    paramc.append(", new value ");
    paramc.append(paramk);
    throw new IllegalArgumentException(paramc.toString());
  }
  
  static Method[] a(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  final b a(Class paramClass, Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = b((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((b)localObject1).b);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = b(localObject1[i]).b.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (c)((Map.Entry)localObject3).getKey(), (k)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    localObject1 = paramArrayOfMethod;
    if (paramArrayOfMethod == null) {
      localObject1 = a(paramClass);
    }
    int k = localObject1.length;
    j = 0;
    boolean bool = false;
    if (j < k)
    {
      paramArrayOfMethod = localObject1[j];
      localObject3 = (aa)paramArrayOfMethod.getAnnotation(aa.class);
      if (localObject3 != null)
      {
        localObject2 = paramArrayOfMethod.getParameterTypes();
        int m = localObject2.length;
        if (m > 0)
        {
          if (!localObject2[0].isAssignableFrom(n.class)) {
            break label358;
          }
          i = 1;
          label228:
          localObject3 = ((aa)localObject3).a();
          if (m > 1)
          {
            if (!localObject2[1].isAssignableFrom(k.class)) {
              throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
            }
            if (localObject3 != k.a) {
              break label368;
            }
            i = 2;
          }
          if (m > 2) {
            break label378;
          }
          a(localHashMap, new c(i, paramArrayOfMethod), (k)localObject3, paramClass);
          bool = true;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = 0;
        break label228;
      }
    }
    else
    {
      paramArrayOfMethod = new b(localHashMap);
      this.c.put(paramClass, paramArrayOfMethod);
      this.a.put(paramClass, Boolean.valueOf(bool));
      return paramArrayOfMethod;
    }
    label358:
    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    label368:
    throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
    label378:
    throw new IllegalArgumentException("cannot have more than 2 params");
  }
  
  final b b(Class paramClass)
  {
    b localb2 = (b)this.c.get(paramClass);
    b localb1 = localb2;
    if (localb2 == null) {
      localb1 = a(paramClass, null);
    }
    return localb1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */