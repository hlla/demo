package com.google.android.finsky.be;

import android.os.Bundle;
import com.google.android.finsky.utils.ParcelableProto;
import com.google.wireless.android.finsky.dfe.e.a.an;

public final class v
{
  public final Bundle a = new Bundle();
  
  public v(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("DialogScreenMapModel"))) {
      this.a.putAll(paramBundle.getBundle("DialogScreenMapModel"));
    }
  }
  
  public final void a(boolean paramBoolean, an[] paramArrayOfan)
  {
    if (paramBoolean) {
      this.a.clear();
    }
    if (paramArrayOfan != null)
    {
      int j = paramArrayOfan.length;
      int i = 0;
      while (i < j)
      {
        an localan = paramArrayOfan[i];
        this.a.putParcelable(localan.b, ParcelableProto.a(localan.c));
        i += 1;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */