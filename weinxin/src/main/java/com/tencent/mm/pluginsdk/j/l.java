package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;

public final class l
  extends b
{
  public l(Activity paramActivity)
  {
    super(paramActivity);
    GMTrace.i(705582596096L, 5257);
    GMTrace.o(705582596096L, 5257);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(705716813824L, 5258);
    v.i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    GMTrace.o(705716813824L, 5258);
  }
  
  public final boolean b(p paramp)
  {
    GMTrace.i(705851031552L, 5259);
    v.d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(705851031552L, 5259);
    return true;
  }
  
  public final boolean c(p paramp)
  {
    GMTrace.i(705985249280L, 5260);
    v.d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(705985249280L, 5260);
    return true;
  }
  
  public final boolean d(p paramp)
  {
    GMTrace.i(706119467008L, 5261);
    v.d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(706119467008L, 5261);
    return true;
  }
  
  public final boolean e(p paramp)
  {
    GMTrace.i(706253684736L, 5262);
    v.d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramp.content, 0).show();
    GMTrace.o(706253684736L, 5262);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/j/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */