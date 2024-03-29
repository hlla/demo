package com.tencent.wework.api.model;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.SystemClock;

public abstract class WWBaseMessage
  extends BaseMessage
{
  public String appId;
  public String transaction;
  public String xjU;
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    String str = String.valueOf(SystemClock.uptimeMillis());
    this.transaction = str;
    paramBundle.putString("_wwapi_basereq_transaction", str);
    paramBundle.putString("_wwapi_basereq_openid", this.appId);
    paramBundle.putString("_wwapi_basereq_agentid", this.xjU);
    try
    {
      paramBundle.putString("_wwapi_basereq_appbundle", this.mContext.getPackageName());
      paramBundle.putString("_wwapi_basereq_appname", this.mContext.getString(this.mContext.getApplicationInfo().labelRes));
      paramBundle.putInt("_wwobject_sdkVer", 2);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wework/api/model/WWBaseMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */