package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.tencent.gmtrace.GMTrace;

public abstract class t
{
  public t()
  {
    GMTrace.i(766785880064L, 5713);
    GMTrace.o(766785880064L, 5713);
  }
  
  public abstract boolean LM(String paramString);
  
  public abstract String No();
  
  public String a(Context paramContext, ResolveInfo paramResolveInfo)
  {
    GMTrace.i(767725404160L, 5720);
    paramContext = paramResolveInfo.activityInfo.loadLabel(paramContext.getPackageManager()).toString();
    GMTrace.o(767725404160L, 5720);
    return paramContext;
  }
  
  public abstract String bCs();
  
  public abstract u.a bCt();
  
  public abstract boolean dt(Context paramContext);
  
  public boolean s(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(767054315520L, 5715);
    GMTrace.o(767054315520L, 5715);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */