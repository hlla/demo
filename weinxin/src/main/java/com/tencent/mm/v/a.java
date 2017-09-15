package com.tencent.mm.v;

import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.account.h.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class a
  implements h.a, e
{
  public a()
  {
    GMTrace.i(413524819968L, 3081);
    GMTrace.o(413524819968L, 3081);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(413927473152L, 3084);
    if (paramk.getType() != 183)
    {
      GMTrace.o(413927473152L, 3084);
      return;
    }
    ap.vd().b(183, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      v.i("MicroMsg.RefreshTokenListener", "update token success");
      GMTrace.o(413927473152L, 3084);
      return;
    }
    v.e("MicroMsg.RefreshTokenListener", "update token fail");
    GMTrace.o(413927473152L, 3084);
  }
  
  public void m(Bundle paramBundle)
  {
    GMTrace.i(413659037696L, 3082);
    String str = paramBundle.getString("access_token");
    paramBundle = paramBundle.getString("expires");
    v.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + str + ", expires = " + paramBundle);
    if (paramBundle != null)
    {
      ap.yY();
      c.vr().set(65832, paramBundle);
    }
    ap.yY();
    c.vr().set(65830, str);
    ap.yY();
    c.vr().set(65831, Long.valueOf(System.currentTimeMillis()));
    ap.vd().a(183, this);
    paramBundle = new g(2, str);
    ap.vd().a(paramBundle, 0);
    GMTrace.o(413659037696L, 3082);
  }
  
  public void onError(int paramInt, String paramString)
  {
    GMTrace.i(413793255424L, 3083);
    v.e("MicroMsg.RefreshTokenListener", "onError : errType = " + paramInt + ", errMsg = " + paramString);
    GMTrace.o(413793255424L, 3083);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/v/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */