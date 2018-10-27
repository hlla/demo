package android.a.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  private static Map a = new HashMap();
  private static Map b = new HashMap();
  
  private static h a(Constructor paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (h)paramConstructor.newInstance(new Object[] { paramObject });
      return paramConstructor;
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  static i a(Object paramObject)
  {
    if ((paramObject instanceof e)) {
      return new f((e)paramObject);
    }
    if ((paramObject instanceof i)) {
      return (i)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (b((Class)localObject) == 2)
    {
      localObject = (List)b.get(localObject);
      if (((List)localObject).size() == 1) {
        return new ad(a((Constructor)((List)localObject).get(0), paramObject));
      }
      h[] arrayOfh = new h[((List)localObject).size()];
      int i = 0;
      while (i < ((List)localObject).size())
      {
        arrayOfh[i] = a((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new d(arrayOfh);
    }
    return new ab(paramObject);
  }
  
  private static Constructor a(Class paramClass)
  {
    try
    {
      Object localObject1 = paramClass.getPackage();
      Object localObject3 = paramClass.getCanonicalName();
      if (localObject1 == null) {}
      for (localObject1 = "";; localObject1 = ((Package)localObject1).getName())
      {
        Object localObject2 = localObject3;
        if (!((String)localObject1).isEmpty()) {
          localObject2 = ((String)localObject3).substring(((String)localObject1).length() + 1);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((String)localObject2).replace(".", "_"));
        ((StringBuilder)localObject3).append("_LifecycleAdapter");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject2 = localObject3;
        if (!((String)localObject1).isEmpty())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(".");
          ((StringBuilder)localObject2).append((String)localObject3);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        paramClass = Class.forName((String)localObject2).getDeclaredConstructor(new Class[] { paramClass });
        if (paramClass.isAccessible()) {
          break;
        }
        paramClass.setAccessible(true);
        return paramClass;
      }
      return paramClass;
    }
    catch (ClassNotFoundException paramClass)
    {
      return null;
    }
    catch (NoSuchMethodException paramClass)
    {
      throw new RuntimeException(paramClass);
    }
  }
  
  private static int b(Class paramClass)
  {
    int j = 0;
    if (a.containsKey(paramClass)) {
      return ((Integer)a.get(paramClass)).intValue();
    }
    Object localObject1;
    int i;
    if (paramClass.getCanonicalName() != null)
    {
      localObject1 = a(paramClass);
      if (localObject1 != null)
      {
        b.put(paramClass, Collections.singletonList(localObject1));
        i = 2;
      }
    }
    for (;;)
    {
      a.put(paramClass, Integer.valueOf(i));
      return i;
      localObject1 = a.b;
      if (((a)localObject1).a.containsKey(paramClass)) {
        if (((Boolean)((a)localObject1).a.get(paramClass)).booleanValue()) {}
      }
      for (;;)
      {
        localObject1 = paramClass.getSuperclass();
        if (c((Class)localObject1)) {
          if (b((Class)localObject1) == 1) {}
        }
        for (localObject1 = new ArrayList((Collection)b.get(localObject1));; localObject1 = null)
        {
          localObject2 = paramClass.getInterfaces();
          k = localObject2.length;
          i = j;
          if (i < k)
          {
            Class localClass = localObject2[i];
            if (c(localClass))
            {
              if (b(localClass) == 1)
              {
                i = 1;
                break;
              }
              if (localObject1 == null)
              {
                localObject1 = new ArrayList();
                label224:
                ((List)localObject1).addAll((Collection)b.get(localClass));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              break label224;
            }
          }
          if (localObject1 != null)
          {
            b.put(paramClass, localObject1);
            i = 2;
            break;
          }
          i = 1;
          break;
          i = 1;
          break;
        }
        i = 1;
        break;
        Object localObject2 = a.a(paramClass);
        int k = localObject2.length;
        i = 0;
        for (;;)
        {
          if (i < k) {
            if ((aa)localObject2[i].getAnnotation(aa.class) == null)
            {
              i += 1;
            }
            else
            {
              ((a)localObject1).a(paramClass, (Method[])localObject2);
              i = 1;
              break;
            }
          }
        }
        ((a)localObject1).a.put(paramClass, Boolean.valueOf(false));
      }
      i = 1;
    }
  }
  
  private static boolean c(Class paramClass)
  {
    return (paramClass != null) && (m.class.isAssignableFrom(paramClass));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */