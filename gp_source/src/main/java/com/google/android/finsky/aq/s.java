package com.google.android.finsky.aq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class s
{
  public final StringBuilder a;
  private final List b;
  
  public s()
  {
    this(new StringBuilder("1=1"), new ArrayList());
  }
  
  public s(Object paramObject)
  {
    this("pk", paramObject);
  }
  
  public s(String paramString, Object paramObject)
  {
    this();
    a(paramString, paramObject);
  }
  
  private s(StringBuilder paramStringBuilder, List paramList)
  {
    this.a = paramStringBuilder;
    this.b = paramList;
  }
  
  public static s a(s params1, s params2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    localStringBuilder.append(params1.a.toString());
    localStringBuilder.append(String.format(") %s (", new Object[] { paramString }));
    localStringBuilder.append(params2.a.toString());
    localStringBuilder.append(")");
    params1 = new ArrayList(params1.b);
    params1.addAll(params2.b);
    return new s(localStringBuilder, params1);
  }
  
  private final void a(String paramString1, String paramString2, Object paramObject)
  {
    if (paramObject != null) {}
    for (paramObject = Collections.singletonList(paramObject);; paramObject = null)
    {
      a(paramString1, paramString2, (List)paramObject);
      return;
    }
  }
  
  private final void a(String paramString1, String paramString2, List paramList)
  {
    a(paramString1, paramString2, false, paramList);
  }
  
  private final void a(String paramString1, String paramString2, boolean paramBoolean, List paramList)
  {
    this.a.append(" AND ");
    this.a.append(paramString1);
    this.a.append(" ");
    this.a.append(paramString2);
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        throw new IllegalArgumentException("Empty argument value");
      }
      Iterator localIterator = paramList.iterator();
      paramString1 = null;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = localObject.getClass();
        }
        paramString1 = paramString2;
        if (!paramString2.isInstance(localObject)) {
          throw new IllegalArgumentException("Heterogeneous list of values provided, all objects should be same type");
        }
      }
      this.a.append(" (?");
      int j = paramList.size();
      int i = 0;
      while (i < j - 1)
      {
        this.a.append(", ?");
        i += 1;
      }
      this.a.append(")");
      if (paramBoolean) {
        this.a.append(" ESCAPE '!'");
      }
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = paramString1.next();
        this.b.add(String.valueOf(paramString2));
      }
    }
  }
  
  public final s a(String paramString)
  {
    a(paramString, "is null", null);
    return this;
  }
  
  public final s a(String paramString, Object paramObject)
  {
    if (paramObject != null)
    {
      a(paramString, "=", paramObject);
      return this;
    }
    return a(paramString);
  }
  
  public final s a(String paramString1, String paramString2)
  {
    paramString2 = paramString2.replaceAll("!", "!!").replaceAll("%", "!%").replaceAll("_", "!_");
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 2);
    localStringBuilder.append("%");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("%");
    a(paramString1, "like", true, Collections.singletonList(localStringBuilder.toString()));
    return this;
  }
  
  public final s a(String paramString, List paramList)
  {
    a(paramString, "in", paramList);
    return this;
  }
  
  public final String[] a()
  {
    List localList = this.b;
    if (!localList.isEmpty()) {
      return (String[])localList.toArray(new String[localList.size()]);
    }
    return null;
  }
  
  public final s b(String paramString, Object paramObject)
  {
    if (paramObject != null)
    {
      a(paramString, "<>", paramObject);
      return this;
    }
    a(paramString, "is not null", null);
    return this;
  }
  
  public final s b(String paramString, List paramList)
  {
    a(paramString, "not in", paramList);
    return this;
  }
  
  public final s c(String paramString, Object paramObject)
  {
    a(paramString, ">", paramObject);
    return this;
  }
  
  public final s d(String paramString, Object paramObject)
  {
    a(paramString, "<", paramObject);
    return this;
  }
  
  public final s e(String paramString, Object paramObject)
  {
    a(paramString, ">=", paramObject);
    return this;
  }
  
  public final s f(String paramString, Object paramObject)
  {
    a(paramString, "<=", paramObject);
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aq/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */