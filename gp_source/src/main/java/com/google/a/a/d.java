package com.google.a.a;

import com.google.a.c;
import com.google.common.base.q;
import com.google.common.base.r;
import com.google.common.base.x;
import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

public class d
  extends com.google.a.a
{
  private final Object a = new byte[0];
  private Map b;
  private a c;
  
  protected d()
  {
    this(null);
  }
  
  @Deprecated
  public d(a parama)
  {
    String str;
    if (parama != null)
    {
      this.c = parama;
      str = String.valueOf("Bearer ");
      parama = String.valueOf(parama.a);
      if (parama.length() != 0) {
        break label64;
      }
    }
    label64:
    for (parama = new String(str);; parama = str.concat(parama))
    {
      this.b = Collections.singletonMap("Authorization", Collections.singletonList(parama));
      return;
    }
  }
  
  private final boolean b()
  {
    return this.b == null;
  }
  
  public final Map a()
  {
    synchronized (this.a)
    {
      if (!b())
      {
        Map localMap = (Map)x.a(this.b, "requestMetadata");
        return localMap;
      }
    }
    synchronized (this.a)
    {
      this.b = null;
      this.c = null;
      throw new IllegalStateException("OAuth2Credentials instance does not support refreshing the access token. An instance with a new access token should be used, or a derived type that supports refreshing.");
    }
  }
  
  public final void a(URI paramURI, Executor paramExecutor, c paramc)
  {
    synchronized (this.a)
    {
      if (!b())
      {
        paramURI = (Map)x.a(this.b, "cached requestMetadata");
        paramc.a(paramURI);
        return;
      }
      super.a(paramURI, paramExecutor, paramc);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      bool1 = bool2;
      if (Objects.equals(this.b, ((d)paramObject).b))
      {
        bool1 = bool2;
        if (Objects.equals(this.c, ((d)paramObject).c)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.b, this.c });
  }
  
  public String toString()
  {
    return q.a(this).a("requestMetadata", this.b).a("temporaryAccess", this.c).toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */