package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class b
{
  private static final a tr = new b();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 15)
    {
      tr = new d();
      return;
    }
    if (i >= 11)
    {
      tr = new c();
      return;
    }
  }
  
  public static Intent makeMainActivity(ComponentName paramComponentName)
  {
    return tr.makeMainActivity(paramComponentName);
  }
  
  static abstract interface a
  {
    public abstract Intent makeMainActivity(ComponentName paramComponentName);
  }
  
  static class b
    implements b.a
  {
    public Intent makeMainActivity(ComponentName paramComponentName)
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.setComponent(paramComponentName);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      return localIntent;
    }
  }
  
  static class c
    extends b.b
  {
    public final Intent makeMainActivity(ComponentName paramComponentName)
    {
      return Intent.makeMainActivity(paramComponentName);
    }
  }
  
  static final class d
    extends b.c
  {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/content/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */