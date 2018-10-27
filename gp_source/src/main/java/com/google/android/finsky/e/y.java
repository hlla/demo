package com.google.android.finsky.e;

import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.a.b.a.a.bt;
import com.google.wireless.android.a.b.a.a.bu;

public class y
  implements aq
{
  public bt a;
  private aq b;
  
  public y(int paramInt)
  {
    this(paramInt, null);
  }
  
  public y(int paramInt, aq paramaq)
  {
    this(paramInt, null, paramaq);
  }
  
  public y(int paramInt, byte[] paramArrayOfByte, aq paramaq)
  {
    a(paramInt, paramArrayOfByte, paramaq);
  }
  
  public void a()
  {
    aq localaq = this.b;
    if (localaq == null)
    {
      FinskyLog.e("Cannot log impression because null parent. Type=%d", new Object[] { Integer.valueOf(this.a.e) });
      return;
    }
    localaq.a(this);
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, aq paramaq)
  {
    this.a = u.a(paramInt);
    u.a(this.a, paramArrayOfByte);
    this.b = paramaq;
  }
  
  public void a(aq paramaq)
  {
    u.a(this, paramaq);
  }
  
  public final void a(bu parambu)
  {
    this.a.c = parambu;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    u.a(this.a, paramArrayOfByte);
  }
  
  public aq getParentNode()
  {
    return this.b;
  }
  
  public bt getPlayStoreUiElement()
  {
    return this.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */