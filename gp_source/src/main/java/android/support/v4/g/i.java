package android.support.v4.g;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class i
{
  private int a;
  private int b;
  private final LinkedHashMap c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public i(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.d = paramInt;
    this.c = new LinkedHashMap(0, 0.75F, true);
  }
  
  private final int c(Object paramObject1, Object paramObject2)
  {
    int i = b(paramObject1, paramObject2);
    if (i < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Negative size: ");
      localStringBuilder.append(paramObject1);
      localStringBuilder.append("=");
      localStringBuilder.append(paramObject2);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    return i;
  }
  
  public final Object a(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      paramObject = this.c.get(paramObject);
      if (paramObject == null)
      {
        this.e += 1;
        return null;
      }
      this.b += 1;
      return paramObject;
    }
    finally {}
  }
  
  public final Object a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.f += 1;
      this.g += c(paramObject1, paramObject2);
      Object localObject = this.c.put(paramObject1, paramObject2);
      if (localObject != null) {
        this.g -= c(paramObject1, localObject);
      }
      if (localObject != null) {
        a(false, paramObject1, localObject, paramObject2);
      }
      a(this.d);
      return localObject;
    }
    finally {}
  }
  
  public final void a(int paramInt)
  {
    try
    {
      if (this.g < 0)
      {
        label9:
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getClass().getName());
        localStringBuilder.append(".sizeOf() is reporting inconsistent results!");
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    finally {}
    if (!this.c.isEmpty()) {}
    for (;;)
    {
      if ((this.g > paramInt) && (!this.c.isEmpty()))
      {
        Object localObject3 = (Map.Entry)this.c.entrySet().iterator().next();
        Object localObject2 = ((Map.Entry)localObject3).getKey();
        localObject3 = ((Map.Entry)localObject3).getValue();
        this.c.remove(localObject2);
        this.g -= c(localObject2, localObject3);
        this.a += 1;
        a(true, localObject2, localObject3, null);
        break;
      }
      return;
      int i = this.g;
      if (i != 0) {
        break label9;
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  public int b(Object paramObject1, Object paramObject2)
  {
    return 1;
  }
  
  public final Object b(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Object localObject = this.c.remove(paramObject);
      if (localObject != null) {
        this.g -= c(paramObject, localObject);
      }
      if (localObject != null) {
        a(false, paramObject, localObject, null);
      }
      return localObject;
    }
    finally {}
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.b;
      int k = this.e + j;
      if (k != 0) {
        i = j * 100 / k;
      }
      String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.b), Integer.valueOf(this.e), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */