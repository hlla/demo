package com.google.a;

import java.io.Serializable;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.Executor;

public abstract class a
  implements Serializable
{
  public abstract Map a();
  
  public void a(URI paramURI, Executor paramExecutor, c paramc)
  {
    paramExecutor.execute(new b(this, paramURI, paramc));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */