package com.tencent.mm.plugin.accountsync.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class b
  implements e, f
{
  public Context context;
  public k fFX;
  private ad handler;
  public p irp;
  public a irq;
  
  public b(Context paramContext, a parama)
  {
    GMTrace.i(7852542394368L, 58506);
    this.handler = new ad(Looper.getMainLooper());
    this.context = paramContext;
    this.irq = parama;
    GMTrace.o(7852542394368L, 58506);
  }
  
  public final void a(final int paramInt1, int paramInt2, k paramk)
  {
    GMTrace.i(7852676612096L, 58507);
    if (paramInt2 != 0) {}
    for (paramInt1 = (int)(paramInt1 * 100L / paramInt2);; paramInt1 = 0)
    {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(7852408176640L, 58505);
          if (b.this.irp != null) {
            b.this.irp.setMessage(b.this.context.getString(R.l.dHs) + paramInt1 + "%");
          }
          GMTrace.o(7852408176640L, 58505);
        }
      });
      GMTrace.o(7852676612096L, 58507);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(7852810829824L, 58508);
    if (paramk.getType() == 139)
    {
      ap.vd().b(139, this);
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label93;
      }
      this.irq.OB();
    }
    for (;;)
    {
      if (this.irp != null) {
        this.irp.dismiss();
      }
      GMTrace.o(7852810829824L, 58508);
      return;
      if (paramk.getType() != 138) {
        break;
      }
      ap.vd().b(138, this);
      break;
      label93:
      v.e("MicroMsg.DoInit", "do init failed, err=" + paramInt1 + "," + paramInt2);
      this.irq.OB();
    }
  }
  
  public static abstract interface a
  {
    public abstract void OB();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/accountsync/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */