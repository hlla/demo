package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public abstract class b
  extends SecurityImage.b
{
  public SecurityImage uSI;
  public k uVo;
  
  public b()
  {
    GMTrace.i(2689320615936L, 20037);
    this.uSI = null;
    this.uVo = null;
    GMTrace.o(2689320615936L, 20037);
  }
  
  public abstract k a(k paramk, String paramString);
  
  public final void bQy()
  {
    GMTrace.i(2689589051392L, 20039);
    ap.vd().a(a(this.uVo, ""), 0);
    GMTrace.o(2689589051392L, 20039);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */