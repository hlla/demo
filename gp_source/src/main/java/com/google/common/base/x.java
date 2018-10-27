package com.google.common.base;

public final class x
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      if (paramInt1 >= 0) {
        break label46;
      }
    }
    for (Object localObject = ak.a("%s (%s) must not be negative", new Object[] { "index", Integer.valueOf(paramInt1) });; localObject = ak.a("%s (%s) must be less than size (%s)", new Object[] { "index", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }))
    {
      throw new IndexOutOfBoundsException((String)localObject);
      if (paramInt1 >= paramInt2) {
        break;
      }
      return paramInt1;
      label46:
      if (paramInt2 < 0)
      {
        localObject = new StringBuilder(26);
        ((StringBuilder)localObject).append("negative size: ");
        ((StringBuilder)localObject).append(paramInt2);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static Object a(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    return paramObject;
  }
  
  public static Object a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      throw new NullPointerException(String.valueOf(paramObject2));
    }
    return paramObject1;
  }
  
  public static Object a(Object paramObject, String paramString, int paramInt)
  {
    if (paramObject == null) {
      throw new NullPointerException(ak.a(paramString, new Object[] { Integer.valueOf(paramInt) }));
    }
    return paramObject;
  }
  
  public static Object a(Object paramObject1, String paramString, Object paramObject2)
  {
    if (paramObject1 == null) {
      throw new NullPointerException(ak.a(paramString, new Object[] { paramObject2 }));
    }
    return paramObject1;
  }
  
  static String a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 < 0) {
      return ak.a("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 < 0)
    {
      paramString = new StringBuilder(26);
      paramString.append("negative size: ");
      paramString.append(paramInt2);
      throw new IllegalArgumentException(paramString.toString());
    }
    return ak.a("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    label8:
    String str;
    if (paramInt1 < 0)
    {
      if (paramInt1 >= 0) {
        break label36;
      }
      str = a(paramInt1, paramInt3, "start index");
    }
    for (;;)
    {
      throw new IndexOutOfBoundsException(str);
      if ((paramInt2 < paramInt1) || (paramInt2 > paramInt3)) {
        break;
      }
      return;
      label36:
      if (paramInt1 > paramInt3) {
        break label8;
      }
      if (paramInt2 < 0) {}
      while (paramInt2 > paramInt3)
      {
        str = a(paramInt2, paramInt3, "end index");
        break;
      }
      str = ak.a("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException();
    }
  }
  
  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, char paramChar)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(ak.a(paramString, new Object[] { Character.valueOf(paramChar) }));
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(ak.a(paramString, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(ak.a(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(ak.a(paramString, new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(ak.a(paramString, new Object[] { paramObject }));
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(ak.a(paramString, new Object[] { paramObject1, paramObject2 }));
    }
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt2)) {
      throw new IndexOutOfBoundsException(a(paramInt1, paramInt2, "index"));
    }
    return paramInt1;
  }
  
  public static void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void b(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.valueOf(paramObject));
    }
  }
  
  public static void b(boolean paramBoolean, String paramString, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(ak.a(paramString, new Object[] { paramObject }));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/common/base/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */