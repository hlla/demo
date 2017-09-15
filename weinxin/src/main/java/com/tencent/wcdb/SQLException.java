package com.tencent.wcdb;

public class SQLException
  extends RuntimeException
{
  public SQLException() {}
  
  public SQLException(String paramString)
  {
    super(paramString);
  }
  
  public SQLException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wcdb/SQLException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */