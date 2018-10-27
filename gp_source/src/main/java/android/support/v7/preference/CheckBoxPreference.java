package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.a.o;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;

public class CheckBoxPreference
  extends TwoStatePreference
{
  private final a c = new a(this);
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, o.a(paramContext, 2130968735, 16842895));
  }
  
  private CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ap.c, paramInt, 0);
    c(o.b(paramContext, ap.i, ap.f));
    d(o.b(paramContext, ap.h, ap.e));
    this.b = o.a(paramContext, ap.g, ap.d, false);
    paramContext.recycle();
  }
  
  private final void c(View paramView)
  {
    boolean bool = paramView instanceof CompoundButton;
    if (bool) {
      ((CompoundButton)paramView).setOnCheckedChangeListener(null);
    }
    if ((paramView instanceof Checkable)) {
      ((Checkable)paramView).setChecked(this.a);
    }
    if (bool) {
      ((CompoundButton)paramView).setOnCheckedChangeListener(this.c);
    }
  }
  
  public final void a(ao paramao)
  {
    super.a(paramao);
    c(paramao.a(16908289));
    b(paramao);
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    if (((AccessibilityManager)this.j.getSystemService("accessibility")).isEnabled())
    {
      c(paramView.findViewById(16908289));
      b(paramView.findViewById(16908304));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/CheckBoxPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */