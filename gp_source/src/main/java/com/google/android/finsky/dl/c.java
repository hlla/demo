package com.google.android.finsky.dl;

import java.util.ArrayList;
import java.util.List;

public final class c
{
  public final boolean a;
  public final int b;
  public final b[] c;
  
  public c(b[] paramArrayOfb, int paramInt, boolean paramBoolean)
  {
    this.c = paramArrayOfb;
    this.b = paramInt;
    this.a = paramBoolean;
  }
  
  public final List a()
  {
    ArrayList localArrayList = new ArrayList();
    b[] arrayOfb = this.c;
    int j = arrayOfb.length;
    int i = 0;
    if (i < j)
    {
      b localb = arrayOfb[i];
      if (localb == null) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localb);
      }
    }
    return localArrayList;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dl/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */