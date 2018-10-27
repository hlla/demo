package com.google.android.finsky.bc.a;

import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.android.finsky.be.r;
import com.google.android.finsky.be.s;
import com.google.android.finsky.be.t;
import com.google.android.finsky.be.w;
import com.google.wireless.android.finsky.dfe.e.a.du;
import com.google.wireless.android.finsky.dfe.e.a.dv;
import java.util.List;
import java.util.Map;

final class ak
  implements OnCheckedChangeListener
{
  private final t a;
  private final w b;
  private final du c = paramdv.d[paramInt1];
  private final r d;
  private final int e;
  private final String f;
  private final String g;
  
  ak(dv paramdv, int paramInt1, w paramw, t paramt, r paramr, int paramInt2)
  {
    this.g = paramdv.e;
    this.b = paramw;
    this.d = paramr;
    this.a = paramt;
    this.f = paramdv.c;
    this.e = paramInt2;
  }
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j;
    int i;
    if ((!TextUtils.isEmpty(this.g)) && (paramBoolean))
    {
      this.b.a(this.g, this.c.h);
      paramCompoundButton = this.d;
      String str = this.g;
      j = this.e;
      if (paramCompoundButton.a.containsKey(str))
      {
        paramCompoundButton = (List)paramCompoundButton.a.get(str);
        i = 0;
        if (i < paramCompoundButton.size()) {
          break label113;
        }
      }
      if (!TextUtils.isEmpty(this.f)) {
        this.a.a(this.f, true);
      }
    }
    return;
    label113:
    if (i == j) {}
    for (;;)
    {
      i += 1;
      break;
      ((s)paramCompoundButton.get(i)).a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */