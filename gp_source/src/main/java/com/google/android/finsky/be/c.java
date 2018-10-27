package com.google.android.finsky.be;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  public final List a = new ArrayList();
  
  public c(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int j = paramBundle.getInt("DialogActionContextModel.count", 0);
      if (j >= 0) {
        if (i < j)
        {
          byte[] arrayOfByte = paramBundle.getByteArray(a(i));
          if (arrayOfByte == null) {}
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfByte.length > 0) {
              this.a.add(arrayOfByte);
            }
          }
        }
      }
    }
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(43);
    localStringBuilder.append("DialogActionContextModel..index.");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      this.a.add(paramArrayOfByte);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */