package com.google.ads.a.a;

public final class e
{
  public static int a(int paramInt)
  {
    if (paramInt < 0) {}
    while (paramInt > 2)
    {
      if ((paramInt >= 1000) && (paramInt <= 1000)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder(43);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid enum EnumBoolean");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public static int b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2))
    {
      StringBuilder localStringBuilder = new StringBuilder(41);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid enum ProtoName");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public static int c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3))
    {
      StringBuilder localStringBuilder = new StringBuilder(48);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid enum EncryptionMethod");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */