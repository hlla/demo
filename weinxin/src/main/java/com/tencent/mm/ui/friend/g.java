package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class g
  implements e
{
  private Context context;
  private ProgressDialog kng;
  public String sKp;
  public a wfE;
  private boolean wfF;
  
  public g(Context paramContext, a parama)
  {
    GMTrace.i(2807566434304L, 20918);
    this.wfF = true;
    this.sKp = "";
    this.context = paramContext;
    this.wfE = parama;
    this.wfF = true;
    GMTrace.o(2807566434304L, 20918);
  }
  
  public g(Context paramContext, a parama, byte paramByte)
  {
    GMTrace.i(2807700652032L, 20919);
    this.wfF = true;
    this.sKp = "";
    this.context = paramContext;
    this.wfE = parama;
    this.wfF = false;
    GMTrace.o(2807700652032L, 20919);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2807969087488L, 20921);
    if (paramk.getType() != 116)
    {
      GMTrace.o(2807969087488L, 20921);
      return;
    }
    if (this.kng != null)
    {
      this.kng.dismiss();
      this.kng = null;
    }
    ap.vd().b(116, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      v.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
      if (this.wfF)
      {
        com.tencent.mm.ui.base.g.a(this.context, R.l.esT, R.l.dIG, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2799110717440L, 20855);
            g.this.wfE.k(true, g.this.sKp);
            GMTrace.o(2799110717440L, 20855);
          }
        });
        GMTrace.o(2807969087488L, 20921);
        return;
      }
      this.wfE.k(true, this.sKp);
      GMTrace.o(2807969087488L, 20921);
      return;
    }
    v.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
    this.wfE.k(false, this.sKp);
    GMTrace.o(2807969087488L, 20921);
  }
  
  public final void r(final int[] paramArrayOfInt)
  {
    GMTrace.i(2807834869760L, 20920);
    ap.vd().a(116, this);
    paramArrayOfInt = new ac(paramArrayOfInt);
    ap.vd().a(paramArrayOfInt, 0);
    if (this.wfF)
    {
      Context localContext = this.context;
      this.context.getString(R.l.esW);
      this.kng = com.tencent.mm.ui.base.g.a(localContext, this.context.getString(R.l.esU), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2792265613312L, 20804);
          ap.vd().c(paramArrayOfInt);
          g.this.wfE.k(false, g.this.sKp);
          GMTrace.o(2792265613312L, 20804);
        }
      });
    }
    GMTrace.o(2807834869760L, 20920);
  }
  
  public static abstract interface a
  {
    public abstract void k(boolean paramBoolean, String paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/friend/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */