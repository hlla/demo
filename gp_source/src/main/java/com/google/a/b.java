package com.google.a;

import java.net.URI;
import java.util.Map;

final class b
  implements Runnable
{
  b(a parama, URI paramURI, c paramc) {}
  
  public final void run()
  {
    Object localObject = this.a;
    c localc = this.b;
    try
    {
      localObject = ((a)localObject).a();
      localc.a((Map)localObject);
      return;
    }
    finally
    {
      localc.a(localThrowable);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */