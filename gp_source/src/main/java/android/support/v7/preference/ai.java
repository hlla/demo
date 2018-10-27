package android.support.v7.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class ai
{
  public boolean a;
  public aj b;
  public ak c;
  public al d;
  public PreferenceScreen e;
  private Context f;
  private SharedPreferences.Editor g;
  private long h = 0L;
  private SharedPreferences i;
  private String j;
  
  public ai(Context paramContext)
  {
    this.f = paramContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("_preferences");
    this.j = localStringBuilder.toString();
    this.i = null;
  }
  
  final long a()
  {
    try
    {
      long l = this.h;
      this.h = (1L + l);
      return l;
    }
    finally {}
  }
  
  public final Preference a(CharSequence paramCharSequence)
  {
    PreferenceScreen localPreferenceScreen = this.e;
    if (localPreferenceScreen != null) {
      return localPreferenceScreen.c(paramCharSequence);
    }
    return null;
  }
  
  final void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      SharedPreferences.Editor localEditor = this.g;
      if (localEditor != null) {
        localEditor.apply();
      }
    }
    this.a = paramBoolean;
  }
  
  public final SharedPreferences b()
  {
    if (this.i == null) {
      this.i = this.f.getSharedPreferences(this.j, 0);
    }
    return this.i;
  }
  
  public final SharedPreferences.Editor c()
  {
    if (this.a)
    {
      if (this.g == null) {
        this.g = b().edit();
      }
      return this.g;
    }
    return b().edit();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */