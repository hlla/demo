package com.google.android.finsky.e;

import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.a.b.a.a.bt;
import com.google.wireless.android.a.b.a.a.bu;

public final class aw
  extends y
{
  private boolean b = false;
  
  public aw(int paramInt, byte[] paramArrayOfByte, aq paramaq)
  {
    super(paramInt, paramArrayOfByte, paramaq);
  }
  
  public final void a()
  {
    if (!this.b)
    {
      FinskyLog.e("Should not be report impressions when not selected", new Object[0]);
      return;
    }
    super.a();
  }
  
  public final void a(aq paramaq)
  {
    if (this.b)
    {
      super.a(paramaq);
      return;
    }
    paramaq = paramaq.getPlayStoreUiElement();
    if (paramaq == null) {
      throw new IllegalArgumentException("childNode has null element");
    }
    u.a(this, paramaq);
  }
  
  public final void a(boolean paramBoolean)
  {
    aq localaq = getParentNode();
    if (paramBoolean)
    {
      u.a(localaq, getPlayStoreUiElement());
      if (getPlayStoreUiElement().b.length > 0) {
        localaq.a(this);
      }
    }
    for (;;)
    {
      this.b = paramBoolean;
      return;
      u.b(localaq);
      u.a(localaq.getPlayStoreUiElement(), getPlayStoreUiElement());
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    bu localbu2 = this.a.c;
    if (!paramBoolean)
    {
      if (localbu2 != null)
      {
        localbu2.h = false;
        localbu2.b &= 0xFFFFFFBF;
        a(localbu2);
      }
      return;
    }
    bu localbu1 = localbu2;
    if (localbu2 == null) {
      localbu1 = new bu();
    }
    localbu1.b |= 0x40;
    localbu1.h = true;
    a(localbu1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */