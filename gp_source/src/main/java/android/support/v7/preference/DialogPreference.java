package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.o;
import android.util.AttributeSet;

public class DialogPreference
  extends Preference
{
  public Drawable a;
  public int b;
  public CharSequence c;
  public CharSequence d;
  public CharSequence e;
  public CharSequence f;
  
  public DialogPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, o.a(paramContext, 2130968848, 16842897));
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ap.j, paramInt1, paramInt2);
    this.d = o.b(localTypedArray, ap.r, ap.m);
    if (this.d != null) {}
    for (;;)
    {
      this.c = o.b(localTypedArray, ap.q, ap.l);
      paramAttributeSet = localTypedArray.getDrawable(6);
      paramContext = paramAttributeSet;
      if (paramAttributeSet == null) {
        paramContext = localTypedArray.getDrawable(2);
      }
      this.a = paramContext;
      this.f = o.b(localTypedArray, ap.t, ap.o);
      this.e = o.b(localTypedArray, ap.s, ap.n);
      this.b = o.a(localTypedArray, ap.p, ap.k, 0);
      localTypedArray.recycle();
      return;
      this.d = this.z;
    }
  }
  
  protected void e()
  {
    aj localaj = this.y.b;
    if (localaj != null) {
      localaj.b(this);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/DialogPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */