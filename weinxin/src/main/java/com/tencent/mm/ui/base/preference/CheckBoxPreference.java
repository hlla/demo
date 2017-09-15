package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class CheckBoxPreference
  extends Preference
{
  private TextView rAd;
  private int rAe;
  private String rAf;
  private int rAg;
  private MMSwitchBtn srx;
  public boolean vox;
  
  public CheckBoxPreference(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(3217735811072L, 23974);
    GMTrace.o(3217735811072L, 23974);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(3217870028800L, 23975);
    GMTrace.o(3217870028800L, 23975);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3218004246528L, 23976);
    this.vox = false;
    this.rAe = -1;
    this.rAf = "";
    this.rAg = 8;
    setLayoutResource(a.h.her);
    GMTrace.o(3218004246528L, 23976);
  }
  
  public void bW(String paramString, int paramInt)
  {
    GMTrace.i(3218541117440L, 23980);
    this.rAe = paramInt;
    this.rAf = paramString;
    if (this.rAd != null)
    {
      if (paramInt > 0) {
        this.rAd.setBackgroundResource(this.rAe);
      }
      if (!TextUtils.isEmpty(this.rAf)) {
        this.rAd.setText(this.rAf);
      }
    }
    GMTrace.o(3218541117440L, 23980);
  }
  
  public final boolean isChecked()
  {
    GMTrace.i(3218272681984L, 23978);
    if (this.srx != null)
    {
      bool = this.srx.wuu;
      GMTrace.o(3218272681984L, 23978);
      return bool;
    }
    boolean bool = this.vox;
    GMTrace.o(3218272681984L, 23978);
    return bool;
  }
  
  public final void kU(boolean paramBoolean)
  {
    GMTrace.i(3218406899712L, 23979);
    if (this.srx != null)
    {
      this.vox = paramBoolean;
      this.srx.lP(paramBoolean);
    }
    GMTrace.o(3218406899712L, 23979);
  }
  
  public void onBindView(View paramView)
  {
    GMTrace.i(3218138464256L, 23977);
    super.onBindView(paramView);
    this.srx = ((MMSwitchBtn)paramView.findViewById(a.g.checkbox));
    this.srx.wuy = new MMSwitchBtn.a()
    {
      public final void bK(boolean paramAnonymousBoolean)
      {
        GMTrace.i(3234513027072L, 24099);
        CheckBoxPreference.this.callChangeListener(Boolean.valueOf(paramAnonymousBoolean));
        GMTrace.o(3234513027072L, 24099);
      }
    };
    this.srx.lP(this.vox);
    if (!isEnabled())
    {
      this.srx.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(a.d.aSV));
    }
    this.rAd = ((TextView)paramView.findViewById(a.g.cID));
    bW(this.rAf, this.rAe);
    vq(this.rAg);
    GMTrace.o(3218138464256L, 23977);
  }
  
  public void vq(int paramInt)
  {
    GMTrace.i(3218675335168L, 23981);
    this.rAg = paramInt;
    if (this.rAd != null) {
      this.rAd.setVisibility(this.rAg);
    }
    GMTrace.o(3218675335168L, 23981);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/preference/CheckBoxPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */