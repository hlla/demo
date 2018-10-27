package com.google.android.finsky.bc.a;

import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.android.finsky.be.w;
import com.google.android.finsky.be.y;
import com.google.wireless.android.finsky.dfe.e.a.ce;

final class e
  implements OnCheckedChangeListener
{
  private final com.google.android.finsky.be.d a;
  
  e(d paramd, com.google.android.finsky.be.d paramd1)
  {
    this.a = paramd1;
  }
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.b.a.h;
    if (TextUtils.isEmpty(paramCompoundButton)) {}
    for (;;)
    {
      Object localObject = this.b;
      paramCompoundButton = ((d)localObject).c;
      localObject = ((d)localObject).a;
      paramCompoundButton.a(new String[] { ((ce)localObject).e, ((ce)localObject).d });
      paramCompoundButton = this.b.a.b;
      if (paramCompoundButton != null) {
        this.a.a(paramCompoundButton);
      }
      return;
      if (!paramBoolean)
      {
        localObject = this.b;
        if (!((d)localObject).a.i) {
          ((d)localObject).b.a(paramCompoundButton, Boolean.toString(false));
        } else {
          ((d)localObject).b.a(paramCompoundButton);
        }
      }
      else
      {
        this.b.b.a(paramCompoundButton, Boolean.toString(true));
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */