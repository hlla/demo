package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;

public final class h
  extends b
{
  public h(Activity paramActivity)
  {
    super(paramActivity);
    GMTrace.i(699811233792L, 5214);
    GMTrace.o(699811233792L, 5214);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(699945451520L, 5215);
    v.i("MicroMsg.ErrorConfirmProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    GMTrace.o(699945451520L, 5215);
  }
  
  public final boolean b(p paramp)
  {
    GMTrace.i(700079669248L, 5216);
    v.d("MicroMsg.ErrorConfirmProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(700079669248L, 5216);
    return true;
  }
  
  public final boolean c(p paramp)
  {
    GMTrace.i(700213886976L, 5217);
    v.d("MicroMsg.ErrorConfirmProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(700213886976L, 5217);
    return true;
  }
  
  public final boolean d(p paramp)
  {
    GMTrace.i(700348104704L, 5218);
    v.d("MicroMsg.ErrorConfirmProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(700348104704L, 5218);
    return true;
  }
  
  public final boolean e(p paramp)
  {
    GMTrace.i(700482322432L, 5219);
    v.d("MicroMsg.ErrorConfirmProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(700482322432L, 5219);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/j/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */