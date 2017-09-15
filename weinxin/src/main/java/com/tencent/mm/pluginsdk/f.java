package com.tencent.mm.pluginsdk;

import android.app.Activity;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.storage.x;

public abstract interface f
  extends a
{
  public abstract void a(BizInfo paramBizInfo, Activity paramActivity, x paramx);
  
  public abstract void a(BizInfo paramBizInfo, Activity paramActivity, x paramx, boolean paramBoolean, Runnable paramRunnable);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */