package android.support.v4.app;

import android.content.ComponentName;
import android.content.Intent;

abstract class bs
{
  public final ComponentName a;
  private boolean b;
  private int c;
  
  bs(ComponentName paramComponentName)
  {
    this.a = paramComponentName;
  }
  
  public void a() {}
  
  final void a(int paramInt)
  {
    if (!this.b)
    {
      this.b = true;
      this.c = paramInt;
    }
    while (this.c == paramInt) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Given job ID ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is different than previous ");
    localStringBuilder.append(this.c);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  abstract void a(Intent paramIntent);
  
  public void b() {}
  
  public void c() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */