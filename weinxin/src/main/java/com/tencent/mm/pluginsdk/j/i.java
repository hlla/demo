package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;

public final class i
  extends b
{
  public i(Activity paramActivity)
  {
    super(paramActivity);
    GMTrace.i(697529532416L, 5197);
    GMTrace.o(697529532416L, 5197);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(697663750144L, 5198);
    v.i("MicroMsg.ErrorLabelProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    GMTrace.o(697663750144L, 5198);
  }
  
  public final boolean b(p paramp)
  {
    GMTrace.i(697797967872L, 5199);
    v.d("MicroMsg.ErrorLabelProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(697797967872L, 5199);
    return true;
  }
  
  public final boolean c(p paramp)
  {
    GMTrace.i(697932185600L, 5200);
    v.d("MicroMsg.ErrorLabelProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(697932185600L, 5200);
    return true;
  }
  
  public final boolean d(p paramp)
  {
    GMTrace.i(698066403328L, 5201);
    v.d("MicroMsg.ErrorLabelProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(698066403328L, 5201);
    return true;
  }
  
  public final boolean e(p paramp)
  {
    GMTrace.i(698200621056L, 5202);
    v.d("MicroMsg.ErrorLabelProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(698200621056L, 5202);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/j/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */