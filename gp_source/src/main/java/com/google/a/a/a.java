package com.google.a.a;

import com.google.common.base.q;
import com.google.common.base.r;
import java.io.Serializable;
import java.util.Objects;

public final class a
  implements Serializable
{
  public final String a;
  
  public a(String paramString)
  {
    this.a = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (Objects.equals(this.a, ((a)paramObject).a))
      {
        bool1 = bool2;
        if (Objects.equals(null, null)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return Objects.hash(new Object[] { this.a, null });
  }
  
  public final String toString()
  {
    return q.a(this).a("tokenValue", this.a).a("expirationTimeMillis", null).toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */