package com.google.android.finsky.as;

import android.support.v4.g.q;
import java.util.ArrayList;
import java.util.List;

public final class n
{
  public final List a = new ArrayList();
  public int b = -1;
  
  public final List a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.size())
    {
      localArrayList.add((String)((q)this.a.get(i)).a);
      i += 1;
    }
    return localArrayList;
  }
  
  public final void a(String paramString, Object paramObject)
  {
    this.a.add(new q(paramString, paramObject));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/as/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */