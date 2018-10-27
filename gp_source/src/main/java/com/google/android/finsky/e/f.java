package com.google.android.finsky.e;

import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.a.b.a.a.bh;
import com.google.wireless.android.a.b.a.a.bt;
import com.google.wireless.android.a.b.a.a.bu;
import java.util.ArrayList;

public final class f
{
  public final aq a;
  private final bh b;
  private bt c;
  
  public f(aq paramaq)
  {
    this.a = paramaq;
    this.b = u.d();
  }
  
  public final f a(int paramInt)
  {
    bt localbt = this.c;
    if (localbt == null) {
      this.c = u.a(paramInt);
    }
    while (paramInt == 0) {
      return this;
    }
    localbt.b(paramInt);
    return this;
  }
  
  public final f a(bu parambu)
  {
    if (parambu != null)
    {
      if (this.c == null) {
        this.c = u.a(0);
      }
      this.c.c = parambu;
    }
    return this;
  }
  
  public final f a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (this.c == null) {
        this.c = u.a(0);
      }
      this.c.a(paramArrayOfByte);
    }
    return this;
  }
  
  public final bh a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.c;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    for (localObject = this.a;; localObject = ((aq)localObject).getParentNode())
    {
      bt localbt;
      if (localObject != null)
      {
        localbt = ((aq)localObject).getPlayStoreUiElement();
        if (localbt == null) {
          FinskyLog.c("Unexpected null PlayStoreUiElement from node %s", new Object[] { localObject });
        }
      }
      else
      {
        localObject = this.b;
        ((bh)localObject).a = ((bt[])localArrayList.toArray(((bh)localObject).a));
        return this.b;
      }
      localArrayList.add(u.a(localbt));
    }
  }
  
  public final boolean b()
  {
    return (this.c == null) && (this.a == null);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */