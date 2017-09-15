package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;

public final class g
  extends b
{
  public g(Activity paramActivity)
  {
    super(paramActivity);
    GMTrace.i(703300894720L, 5240);
    GMTrace.o(703300894720L, 5240);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(703435112448L, 5241);
    v.i("MicroMsg.ErrorClientProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    GMTrace.o(703435112448L, 5241);
  }
  
  public final boolean b(p paramp)
  {
    GMTrace.i(703569330176L, 5242);
    v.d("MicroMsg.ErrorClientProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(703569330176L, 5242);
    return true;
  }
  
  public final boolean c(p paramp)
  {
    GMTrace.i(703703547904L, 5243);
    v.d("MicroMsg.ErrorClientProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(703703547904L, 5243);
    return true;
  }
  
  public final boolean d(p paramp)
  {
    GMTrace.i(703837765632L, 5244);
    v.d("MicroMsg.ErrorClientProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(703837765632L, 5244);
    return true;
  }
  
  public final boolean e(p paramp)
  {
    GMTrace.i(703971983360L, 5245);
    v.d("MicroMsg.ErrorClientProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(703971983360L, 5245);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/j/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */