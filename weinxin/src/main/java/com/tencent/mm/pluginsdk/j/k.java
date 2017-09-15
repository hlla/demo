package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class k
  extends b
{
  public k(Activity paramActivity)
  {
    super(paramActivity);
    GMTrace.i(699005927424L, 5208);
    GMTrace.o(699005927424L, 5208);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(699140145152L, 5209);
    v.i("MicroMsg.ErrorTextStripleProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    GMTrace.o(699140145152L, 5209);
  }
  
  public final boolean b(p paramp)
  {
    GMTrace.i(699274362880L, 5210);
    v.d("MicroMsg.ErrorTextStripleProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(699274362880L, 5210);
    return true;
  }
  
  public final boolean c(p paramp)
  {
    GMTrace.i(699408580608L, 5211);
    v.d("MicroMsg.ErrorTextStripleProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(699408580608L, 5211);
    return true;
  }
  
  public final boolean d(p paramp)
  {
    GMTrace.i(699542798336L, 5212);
    v.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(699542798336L, 5212);
    return true;
  }
  
  public final boolean e(p paramp)
  {
    GMTrace.i(699677016064L, 5213);
    v.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(699677016064L, 5213);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/j/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */