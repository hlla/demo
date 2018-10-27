package android.support.v14.preference;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v4.content.a.o;
import android.support.v7.preference.Preference;
import android.support.v7.preference.ai;
import android.support.v7.preference.ap;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import android.util.AttributeSet;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreference
  extends AbstractMultiSelectListPreference
{
  private CharSequence[] g;
  private CharSequence[] h;
  private Set i = new HashSet();
  
  public MultiSelectListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, o.a(paramContext, 2130968848, 16842897), (byte)0);
  }
  
  private MultiSelectListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ap.z, paramInt, 0);
    this.g = o.d(paramContext, ap.C, ap.A);
    this.h = o.d(paramContext, ap.D, ap.B);
    paramContext.recycle();
  }
  
  private MultiSelectListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    this(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    paramTypedArray = paramTypedArray.getTextArray(paramInt);
    HashSet localHashSet = new HashSet();
    int j = paramTypedArray.length;
    paramInt = 0;
    while (paramInt < j)
    {
      localHashSet.add(paramTypedArray[paramInt].toString());
      paramInt += 1;
    }
    return localHashSet;
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(MultiSelectListPreference.SavedState.class)))
    {
      super.a(paramParcelable);
      return;
    }
    paramParcelable = (MultiSelectListPreference.SavedState)paramParcelable;
    super.a(paramParcelable.getSuperState());
    a(paramParcelable.a);
  }
  
  protected final void a(Object paramObject)
  {
    a(b((Set)paramObject));
  }
  
  public final void a(Set paramSet)
  {
    this.i.clear();
    this.i.addAll(paramSet);
    if ((k()) && (!paramSet.equals(b(null))))
    {
      SharedPreferences.Editor localEditor = this.y.c();
      localEditor.putStringSet(this.r, paramSet);
      super.a(localEditor);
    }
  }
  
  public final CharSequence[] a()
  {
    return this.g;
  }
  
  public final CharSequence[] b()
  {
    return this.h;
  }
  
  public final Set c()
  {
    return this.i;
  }
  
  protected final Parcelable d()
  {
    Object localObject = super.d();
    if (!this.x)
    {
      localObject = new MultiSelectListPreference.SavedState((Parcelable)localObject);
      ((MultiSelectListPreference.SavedState)localObject).a = c();
      return (Parcelable)localObject;
    }
    return (Parcelable)localObject;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v14/preference/MultiSelectListPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */