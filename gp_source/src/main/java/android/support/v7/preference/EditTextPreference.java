package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v4.content.a.o;
import android.text.TextUtils;
import android.util.AttributeSet;

public class EditTextPreference
  extends DialogPreference
{
  public String g;
  
  public EditTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, o.a(paramContext, 2130968873, 16842898), (byte)0);
  }
  
  private EditTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  private EditTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    this(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getString(paramInt);
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(EditTextPreference.SavedState.class)))
    {
      super.a(paramParcelable);
      return;
    }
    paramParcelable = (EditTextPreference.SavedState)paramParcelable;
    super.a(paramParcelable.getSuperState());
    a(paramParcelable.a);
  }
  
  protected final void a(Object paramObject)
  {
    a(d((String)paramObject));
  }
  
  public final void a(String paramString)
  {
    boolean bool1 = c_();
    this.g = paramString;
    c(paramString);
    boolean bool2 = c_();
    if (bool2 != bool1) {
      a(bool2);
    }
  }
  
  public final boolean c_()
  {
    return (TextUtils.isEmpty(this.g)) || (super.c_());
  }
  
  protected final Parcelable d()
  {
    Object localObject = super.d();
    if (!this.x)
    {
      localObject = new EditTextPreference.SavedState((Parcelable)localObject);
      ((EditTextPreference.SavedState)localObject).a = this.g;
      return (Parcelable)localObject;
    }
    return (Parcelable)localObject;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/EditTextPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */