package android.support.v7.preference;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class TwoStatePreference
  extends Preference
{
  public boolean a;
  public boolean b;
  private boolean c;
  private CharSequence d;
  private CharSequence e;
  
  public TwoStatePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private TwoStatePreference(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TwoStatePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    return Boolean.valueOf(paramTypedArray.getBoolean(paramInt, false));
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(TwoStatePreference.SavedState.class)))
    {
      super.a(paramParcelable);
      return;
    }
    paramParcelable = (TwoStatePreference.SavedState)paramParcelable;
    super.a(paramParcelable.getSuperState());
    d(paramParcelable.a);
  }
  
  protected final void a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = Boolean.valueOf(false);
    }
    for (;;)
    {
      d(c(((Boolean)paramObject).booleanValue()));
      return;
    }
  }
  
  public final void b(ao paramao)
  {
    b(paramao.a(16908304));
  }
  
  public final void b(View paramView)
  {
    int k = 1;
    int j = 0;
    int i;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ((!this.a) || (TextUtils.isEmpty(this.e))) {
        break label99;
      }
      paramView.setText(this.e);
      i = 0;
    }
    for (;;)
    {
      CharSequence localCharSequence;
      if (i != 0)
      {
        localCharSequence = f();
        if (!TextUtils.isEmpty(localCharSequence)) {}
      }
      else if (i == 0)
      {
        i = j;
      }
      for (;;)
      {
        if (i != paramView.getVisibility()) {
          paramView.setVisibility(i);
        }
        return;
        i = 8;
        continue;
        paramView.setText(localCharSequence);
        i = j;
      }
      label99:
      i = k;
      if (!this.a)
      {
        i = k;
        if (!TextUtils.isEmpty(this.d))
        {
          paramView.setText(this.d);
          i = 0;
        }
      }
    }
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    if (this.a) {
      b_();
    }
  }
  
  public final boolean c_()
  {
    if (!this.b) {
      if (!this.a) {}
    }
    for (;;)
    {
      if (super.c_()) {}
      do
      {
        return true;
        return false;
      } while (this.a);
    }
  }
  
  protected final Parcelable d()
  {
    Object localObject = super.d();
    if (!this.x)
    {
      localObject = new TwoStatePreference.SavedState((Parcelable)localObject);
      ((TwoStatePreference.SavedState)localObject).a = this.a;
      return (Parcelable)localObject;
    }
    return (Parcelable)localObject;
  }
  
  public final void d(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    if (!this.a) {
      b_();
    }
  }
  
  public final void d(boolean paramBoolean)
  {
    boolean bool = this.a;
    if ((bool != paramBoolean) || (!this.c))
    {
      this.a = paramBoolean;
      this.c = true;
      if ((k()) && (paramBoolean != c(paramBoolean ^ true)))
      {
        SharedPreferences.Editor localEditor = this.y.c();
        localEditor.putBoolean(this.r, paramBoolean);
        super.a(localEditor);
      }
      if (bool != paramBoolean)
      {
        a(c_());
        b_();
      }
    }
  }
  
  protected final void e()
  {
    super.e();
    d(this.a ^ true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/TwoStatePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */