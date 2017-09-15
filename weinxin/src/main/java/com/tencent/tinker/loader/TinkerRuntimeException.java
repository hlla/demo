package com.tencent.tinker.loader;

public class TinkerRuntimeException
  extends RuntimeException
{
  public TinkerRuntimeException(String paramString)
  {
    super("Tinker Exception:" + paramString);
  }
  
  public TinkerRuntimeException(String paramString, Throwable paramThrowable)
  {
    super("Tinker Exception:" + paramString, paramThrowable);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/TinkerRuntimeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */