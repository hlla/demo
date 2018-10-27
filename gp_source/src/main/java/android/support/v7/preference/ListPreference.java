package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v4.content.a.o;
import android.text.TextUtils;
import android.util.AttributeSet;

public class ListPreference
  extends DialogPreference
{
  private String C;
  private boolean D;
  public CharSequence[] g;
  public CharSequence[] h;
  public String i;
  
  public ListPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, o.a(paramContext, 2130968848, 16842897));
  }
  
  public ListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ap.u, paramInt1, paramInt2);
    this.g = o.d(localTypedArray, ap.x, ap.v);
    this.h = o.d(localTypedArray, ap.y, ap.w);
    localTypedArray.recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ap.E, paramInt1, paramInt2);
    this.C = o.b(paramContext, ap.aw, ap.af);
    paramContext.recycle();
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getString(paramInt);
  }
  
  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(ListPreference.SavedState.class)))
    {
      super.a(paramParcelable);
      return;
    }
    paramParcelable = (ListPreference.SavedState)paramParcelable;
    super.a(paramParcelable.getSuperState());
    a(paramParcelable.a);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    super.a(paramCharSequence);
    if ((paramCharSequence == null) && (this.C != null)) {
      this.C = null;
    }
    while ((paramCharSequence == null) || (paramCharSequence.equals(this.C))) {
      return;
    }
    this.C = paramCharSequence.toString();
  }
  
  protected final void a(Object paramObject)
  {
    a(d((String)paramObject));
  }
  
  public final void a(String paramString)
  {
    boolean bool = TextUtils.equals(this.i, paramString) ^ true;
    if ((bool) || (!this.D))
    {
      this.i = paramString;
      this.D = true;
      c(paramString);
      if (bool) {
        b_();
      }
    }
  }
  
  public void a(CharSequence[] paramArrayOfCharSequence)
  {
    this.g = paramArrayOfCharSequence;
  }
  
  public final int b(String paramString)
  {
    if (paramString != null)
    {
      CharSequence[] arrayOfCharSequence = this.h;
      if (arrayOfCharSequence != null)
      {
        int j = arrayOfCharSequence.length - 1;
        while (j >= 0)
        {
          k = j;
          if (this.h[j].equals(paramString)) {
            return k;
          }
          j -= 1;
        }
      }
    }
    int k = -1;
    return k;
  }
  
  public Parcelable d()
  {
    Object localObject = super.d();
    if (!this.x)
    {
      localObject = new ListPreference.SavedState((Parcelable)localObject);
      ((ListPreference.SavedState)localObject).a = this.i;
      return (Parcelable)localObject;
    }
    return (Parcelable)localObject;
  }
  
  public final CharSequence f()
  {
    CharSequence localCharSequence = g();
    String str = this.C;
    if (str == null) {
      return super.f();
    }
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    return String.format(str, new Object[] { localObject });
  }
  
  public final CharSequence g()
  {
    int j = b(this.i);
    if (j >= 0)
    {
      CharSequence[] arrayOfCharSequence = this.g;
      if (arrayOfCharSequence != null) {
        return arrayOfCharSequence[j];
      }
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/ListPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */