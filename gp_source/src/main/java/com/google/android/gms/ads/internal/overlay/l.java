package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.u;

@com.google.android.gms.ads.internal.q.a.a
public final class l
  extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton a;
  private final t b;
  
  public l(Context paramContext, m paramm, t paramt)
  {
    super(paramContext);
    this.b = paramt;
    setOnClickListener(this);
    this.a = new ImageButton(paramContext);
    this.a.setImageResource(17301527);
    this.a.setBackgroundColor(0);
    this.a.setOnClickListener(this);
    paramt = this.a;
    com.google.android.gms.ads.internal.util.client.a locala = u.h.a;
    int i = com.google.android.gms.ads.internal.util.client.a.a(paramContext, paramm.b);
    locala = u.h.a;
    int j = com.google.android.gms.ads.internal.util.client.a.a(paramContext, 0);
    locala = u.h.a;
    int k = com.google.android.gms.ads.internal.util.client.a.a(paramContext, paramm.c);
    locala = u.h.a;
    paramt.setPadding(i, j, k, com.google.android.gms.ads.internal.util.client.a.a(paramContext, paramm.a));
    this.a.setContentDescription("Interstitial close button");
    paramt = u.h.a;
    com.google.android.gms.ads.internal.util.client.a.a(paramContext, paramm.d);
    paramt = this.a;
    locala = u.h.a;
    i = com.google.android.gms.ads.internal.util.client.a.a(paramContext, paramm.d + paramm.b + paramm.c);
    locala = u.h.a;
    addView(paramt, new FrameLayout.LayoutParams(i, com.google.android.gms.ads.internal.util.client.a.a(paramContext, paramm.d + paramm.a), 17));
  }
  
  public final void onClick(View paramView)
  {
    paramView = this.b;
    if (paramView != null) {
      paramView.c();
    }
  }
  
  public final void setCustomClose(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */