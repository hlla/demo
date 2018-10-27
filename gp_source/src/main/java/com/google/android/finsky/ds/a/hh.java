package com.google.android.finsky.ds.a;

public final class hh
{
  public static int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3))
    {
      StringBuilder localStringBuilder = new StringBuilder(62);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid enum NotificationCenterMessageState");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */