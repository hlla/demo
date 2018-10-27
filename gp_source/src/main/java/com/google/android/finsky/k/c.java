package com.google.android.finsky.k;

import java.util.List;

final class c
  implements Runnable
{
  private final String a;
  
  c(a parama, String paramString)
  {
    this.a = paramString;
  }
  
  public final void run()
  {
    Object localObject = this.b.c;
    localObject = (b[])((List)localObject).toArray(new b[((List)localObject).size()]);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].a(this.a);
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/k/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */