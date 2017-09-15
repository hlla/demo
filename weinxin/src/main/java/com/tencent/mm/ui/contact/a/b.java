package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.e.b.af;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;

public final class b
  extends e
{
  public String aIO;
  public int roM;
  private boolean vYo;
  
  public b(int paramInt)
  {
    super(paramInt);
    GMTrace.i(1768318566400L, 13175);
    this.roM = 0;
    GMTrace.o(1768318566400L, 13175);
  }
  
  public final void br(Context paramContext)
  {
    GMTrace.i(1768452784128L, 13176);
    if ((this.roM != 0) && (this.aIO != null))
    {
      this.vYy = this.roM;
      this.vYx = this.aIO;
      GMTrace.o(1768452784128L, 13176);
      return;
    }
    x localx = this.jht;
    if (!this.vYo)
    {
      ap.yY();
      localx = c.wR().Rb(this.username);
      this.jht = localx;
      this.vYo = true;
    }
    if (localx == null)
    {
      this.ioW = "";
      GMTrace.o(1768452784128L, 13176);
      return;
    }
    this.ioW = h.c(paramContext, n.c(localx), com.tencent.mm.bg.a.T(paramContext, R.f.aXH));
    this.username = localx.field_username;
    GMTrace.o(1768452784128L, 13176);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */