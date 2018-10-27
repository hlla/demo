package android.support.v7.preference;

import android.content.Context;
import android.support.v4.content.a.o;
import android.util.AttributeSet;

public final class PreferenceScreen
  extends PreferenceGroup
{
  public boolean d = true;
  
  public PreferenceScreen(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, o.a(paramContext, 2130969440, 16842891), (byte)0);
  }
  
  protected final void e()
  {
    if ((this.q == null) && (this.l == null) && (g() != 0))
    {
      ak localak = this.y.c;
      if (localak != null) {
        localak.R();
      }
    }
  }
  
  protected final boolean q()
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/PreferenceScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */