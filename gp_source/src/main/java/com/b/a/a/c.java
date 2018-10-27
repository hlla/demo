package com.b.a.a;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class c
  extends f
{
  private Logger a;
  
  public c(String paramString)
  {
    this.a = Logger.getLogger(paramString);
  }
  
  public final void a(String paramString)
  {
    this.a.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/b/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */