package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class kz
  extends b
{
  public kz()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2))
    {
      StringBuilder localStringBuilder = new StringBuilder(49);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid enum CompressionFormat");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public static int b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 5))
    {
      StringBuilder localStringBuilder = new StringBuilder(43);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid enum PatchFormat");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public static int c(int paramInt)
  {
    if (paramInt < 0) {}
    while (paramInt > 0)
    {
      if (paramInt < 50) {}
      while (paramInt > 50)
      {
        if (paramInt < 100) {}
        while (paramInt > 100)
        {
          if (paramInt < 200) {}
          while (paramInt > 200)
          {
            if ((paramInt >= 300) && (paramInt <= 300)) {
              break;
            }
            StringBuilder localStringBuilder = new StringBuilder(39);
            localStringBuilder.append(paramInt);
            localStringBuilder.append(" is not a valid enum TrackId");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          return paramInt;
        }
        return paramInt;
      }
      return paramInt;
    }
    return paramInt;
  }
  
  public static int d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3))
    {
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid enum ApkInstallLocation");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof kz))
      {
        paramObject = (kz)paramObject;
        d locald = this.unknownFieldData;
        if ((locald == null) || (locald.a())) {
          paramObject = ((kz)paramObject).unknownFieldData;
        }
      }
      else
      {
        return (paramObject == null) || (((d)paramObject).a());
      }
      return this.unknownFieldData.equals(((kz)paramObject).unknownFieldData);
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    d locald = this.unknownFieldData;
    int i = j;
    if (locald != null)
    {
      i = j;
      if (!locald.a()) {
        i = this.unknownFieldData.hashCode();
      }
    }
    return i + (k + 527) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/kz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */