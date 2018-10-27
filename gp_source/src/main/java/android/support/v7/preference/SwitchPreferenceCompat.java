package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.a.o;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;

public class SwitchPreferenceCompat
  extends TwoStatePreference
{
  private final at c = new at(this);
  private CharSequence d;
  private CharSequence e;
  
  public SwitchPreferenceCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private SwitchPreferenceCompat(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    this(paramContext, paramAttributeSet, 2130969599);
  }
  
  private SwitchPreferenceCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, 2130969599);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ap.aG, 2130969599, 0);
    c(o.b(paramContext, ap.aO, ap.aJ));
    d(o.b(paramContext, ap.aN, ap.aI));
    this.e = o.b(paramContext, ap.aQ, ap.aL);
    b_();
    this.d = o.b(paramContext, ap.aP, ap.aK);
    b_();
    this.b = o.a(paramContext, ap.aM, ap.aH, false);
    paramContext.recycle();
  }
  
  private final void c(View paramView)
  {
    boolean bool = paramView instanceof SwitchCompat;
    if (bool) {
      ((SwitchCompat)paramView).setOnCheckedChangeListener(null);
    }
    if ((paramView instanceof Checkable)) {
      ((Checkable)paramView).setChecked(this.a);
    }
    if (bool)
    {
      paramView = (SwitchCompat)paramView;
      paramView.setTextOn(this.e);
      paramView.setTextOff(this.d);
      paramView.setOnCheckedChangeListener(this.c);
    }
  }
  
  public final void a(ao paramao)
  {
    super.a(paramao);
    c(paramao.a(2131429422));
    b(paramao);
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    if (((AccessibilityManager)this.j.getSystemService("accessibility")).isEnabled())
    {
      c(paramView.findViewById(2131429422));
      b(paramView.findViewById(16908304));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/SwitchPreferenceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */