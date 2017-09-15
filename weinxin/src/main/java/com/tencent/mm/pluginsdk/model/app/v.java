package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class v
  implements t
{
  public k fFX;
  public p irp;
  public Context mContext;
  public a sBV;
  
  public v(Context paramContext, a parama)
  {
    GMTrace.i(827854946304L, 6168);
    this.mContext = paramContext;
    this.sBV = parama;
    GMTrace.o(827854946304L, 6168);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, w paramw)
  {
    GMTrace.i(827989164032L, 6169);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    an.aBz().b(7, this);
    if ((this.irp != null) && (this.irp.isShowing()))
    {
      this.irp.dismiss();
      this.irp = null;
    }
    if (this.sBV != null) {
      this.sBV.boi();
    }
    g.bCQ();
    GMTrace.o(827989164032L, 6169);
  }
  
  public static abstract interface a
  {
    public abstract void boi();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */