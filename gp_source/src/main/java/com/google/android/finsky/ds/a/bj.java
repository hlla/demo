package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;

public final class bj
  extends b
{
  public bj()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2))
    {
      StringBuilder localStringBuilder = new StringBuilder(34);
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid enum Id");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof bj))
      {
        paramObject = (bj)paramObject;
        d locald = this.unknownFieldData;
        if ((locald == null) || (locald.a())) {
          paramObject = ((bj)paramObject).unknownFieldData;
        }
      }
      else
      {
        return (paramObject == null) || (((d)paramObject).a());
      }
      return this.unknownFieldData.equals(((bj)paramObject).unknownFieldData);
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */