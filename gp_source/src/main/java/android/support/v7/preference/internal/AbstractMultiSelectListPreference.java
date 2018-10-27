package android.support.v7.preference.internal;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;
import java.util.Set;

public abstract class AbstractMultiSelectListPreference
  extends DialogPreference
{
  public AbstractMultiSelectListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbstractMultiSelectListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public abstract void a(Set paramSet);
  
  public abstract CharSequence[] a();
  
  public abstract CharSequence[] b();
  
  public abstract Set c();
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/internal/AbstractMultiSelectListPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */