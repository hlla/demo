package android.support.v4.g;

import java.util.Iterator;
import java.util.Map.Entry;

final class n
  implements Iterator, Map.Entry
{
  private int a;
  private boolean b = false;
  private int c;
  
  n(j paramj)
  {
    this.a = (paramj.a() - 1);
    this.c = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!this.b) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      return (e.a(((Map.Entry)paramObject).getKey(), this.d.a(this.c, 0))) && (e.a(((Map.Entry)paramObject).getValue(), this.d.a(this.c, 1)));
    }
    return false;
  }
  
  public final Object getKey()
  {
    if (!this.b) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.d.a(this.c, 0);
  }
  
  public final Object getValue()
  {
    if (!this.b) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.d.a(this.c, 1);
  }
  
  public final boolean hasNext()
  {
    return this.c < this.a;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (!this.b) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    Object localObject1 = this.d.a(this.c, 0);
    Object localObject2 = this.d.a(this.c, 1);
    if (localObject1 != null) {}
    for (int i = localObject1.hashCode();; i = 0)
    {
      if (localObject2 != null) {
        j = localObject2.hashCode();
      }
      return j ^ i;
    }
  }
  
  public final void remove()
  {
    if (!this.b) {
      throw new IllegalStateException();
    }
    this.d.a(this.c);
    this.c -= 1;
    this.a -= 1;
    this.b = false;
  }
  
  public final Object setValue(Object paramObject)
  {
    if (!this.b) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.d.a(this.c, paramObject);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getKey());
    localStringBuilder.append("=");
    localStringBuilder.append(getValue());
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */