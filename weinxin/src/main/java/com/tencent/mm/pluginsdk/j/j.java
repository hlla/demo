package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;

public final class j
  extends b
{
  public j(Activity paramActivity)
  {
    super(paramActivity);
    GMTrace.i(702495588352L, 5234);
    GMTrace.o(702495588352L, 5234);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(702629806080L, 5235);
    v.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    GMTrace.o(702629806080L, 5235);
  }
  
  public final boolean b(p paramp)
  {
    GMTrace.i(702764023808L, 5236);
    v.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(702764023808L, 5236);
    return true;
  }
  
  public final boolean c(p paramp)
  {
    GMTrace.i(702898241536L, 5237);
    v.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(702898241536L, 5237);
    return true;
  }
  
  public final boolean d(p paramp)
  {
    GMTrace.i(703032459264L, 5238);
    v.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(703032459264L, 5238);
    return true;
  }
  
  public final boolean e(p paramp)
  {
    GMTrace.i(703166676992L, 5239);
    v.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(703166676992L, 5239);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/j/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */