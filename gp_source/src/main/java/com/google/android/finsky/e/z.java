package com.google.android.finsky.e;

import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.a.b.a.a.bm;
import com.google.wireless.android.a.b.a.a.bt;
import java.util.ArrayList;
import java.util.List;

public final class z
{
  public bt a;
  public aq b;
  private final bm c = u.e();
  private aq d;
  
  public final z a(int paramInt)
  {
    if (this.b != null) {
      FinskyLog.e("Already called setRootNode", new Object[0]);
    }
    bt localbt = this.a;
    if (localbt == null) {
      this.a = u.a(paramInt);
    }
    while (paramInt == 0) {
      return this;
    }
    localbt.b(paramInt);
    return this;
  }
  
  public final z a(long paramLong)
  {
    if (paramLong != 0L)
    {
      bm localbm = this.c;
      localbm.a |= 0x1;
      localbm.b = paramLong;
    }
    return this;
  }
  
  public final z a(aq paramaq)
  {
    if (this.d != null) {
      FinskyLog.e("Already set leaf node", new Object[0]);
    }
    if (paramaq != null) {
      this.b = paramaq;
    }
    return this;
  }
  
  public final z a(byte[] paramArrayOfByte)
  {
    if (this.b != null) {
      FinskyLog.e("Already called setRootNode", new Object[0]);
    }
    if (paramArrayOfByte != null)
    {
      if (this.a == null) {
        this.a = u.a(0);
      }
      this.a.a(paramArrayOfByte);
    }
    return this;
  }
  
  public final bm a()
  {
    if (this.b != null)
    {
      localObject1 = u.a(0);
      u.b(this.b.getPlayStoreUiElement(), (bt)localObject1);
      localObject2 = this.c;
      ((bm)localObject2).d = ((bt)localObject1);
      return (bm)localObject2;
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = this.a;
    if (localObject1 != null) {
      ((List)localObject2).add(localObject1);
    }
    for (localObject1 = this.d; localObject1 != null; localObject1 = ((aq)localObject1).getParentNode()) {
      ((List)localObject2).add(((aq)localObject1).getPlayStoreUiElement());
    }
    if (((List)localObject2).isEmpty()) {
      FinskyLog.e("Encountered empty tree.", new Object[0]);
    }
    for (;;)
    {
      return this.c;
      this.c.d = u.a((List)localObject2);
    }
  }
  
  public final z b(aq paramaq)
  {
    if (this.b != null) {
      FinskyLog.e("Already called setRootNode", new Object[0]);
    }
    if (paramaq != null) {
      this.d = paramaq;
    }
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */