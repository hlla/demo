package com.airbnb.lottie.c;

import java.util.List;

public final class g
{
  public final List a;
  public final double b;
  private final char c;
  private final String d;
  private final String e;
  
  public g(List paramList, char paramChar, double paramDouble, String paramString1, String paramString2)
  {
    this.a = paramList;
    this.c = paramChar;
    this.b = paramDouble;
    this.e = paramString1;
    this.d = paramString2;
  }
  
  public static int a(char paramChar, String paramString1, String paramString2)
  {
    return (paramChar * '\037' + paramString1.hashCode()) * 31 + paramString2.hashCode();
  }
  
  public final int hashCode()
  {
    return a(this.c, this.d, this.e);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */