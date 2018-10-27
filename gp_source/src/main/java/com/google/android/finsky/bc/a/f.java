package com.google.android.finsky.bc.a;

import android.widget.CompoundButton;
import com.google.android.finsky.be.z;

final class f
  implements z
{
  private final CompoundButton a;
  private final e b;
  
  f(CompoundButton paramCompoundButton, e parame)
  {
    this.a = paramCompoundButton;
    this.b = parame;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.setOnCheckedChangeListener(null);
    this.a.setChecked(paramBoolean);
    this.a.setOnCheckedChangeListener(this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */