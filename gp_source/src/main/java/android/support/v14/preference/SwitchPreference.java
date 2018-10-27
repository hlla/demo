package android.support.v14.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.a.o;
import android.support.v7.preference.Preference;
import android.support.v7.preference.TwoStatePreference;
import android.support.v7.preference.ao;
import android.support.v7.preference.ap;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.Switch;

public class SwitchPreference
  extends TwoStatePreference
{
  private final b c = new b(this);
  private CharSequence d;
  private CharSequence e;
  
  public SwitchPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, o.a(paramContext, 2130969600, 16843629), (byte)0);
  }
  
  private SwitchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ap.aF, paramInt, 0);
    c(o.b(paramContext, ap.aY, ap.aT));
    d(o.b(paramContext, ap.aX, ap.aS));
    this.e = o.b(paramContext, ap.ba, ap.aV);
    b_();
    this.d = o.b(paramContext, ap.aZ, ap.aU);
    b_();
    this.b = o.a(paramContext, ap.aW, ap.aR, false);
    paramContext.recycle();
  }
  
  private SwitchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    this(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void c(View paramView)
  {
    boolean bool = paramView instanceof Switch;
    if (bool) {
      ((Switch)paramView).setOnCheckedChangeListener(null);
    }
    if ((paramView instanceof Checkable)) {
      ((Checkable)paramView).setChecked(this.a);
    }
    if (bool)
    {
      paramView = (Switch)paramView;
      paramView.setTextOn(this.e);
      paramView.setTextOff(this.d);
      paramView.setOnCheckedChangeListener(this.c);
    }
  }
  
  public final void a(ao paramao)
  {
    super.a(paramao);
    c(paramao.a(16908352));
    b(paramao);
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    if (((AccessibilityManager)this.j.getSystemService("accessibility")).isEnabled())
    {
      c(paramView.findViewById(16908352));
      b(paramView.findViewById(16908304));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v14/preference/SwitchPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */