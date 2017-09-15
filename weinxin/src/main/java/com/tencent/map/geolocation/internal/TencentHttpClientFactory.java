package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Bundle;
import ct.b.a;
import ct.cb;

public abstract class TencentHttpClientFactory
{
  private static TencentHttpClientFactory sCustFact;
  
  public static TencentHttpClientFactory getInstance()
  {
    new TencentHttpClientFactory()
    {
      public final Bundle getParams()
      {
        return null;
      }
    };
  }
  
  public static void setTencentHttpClientFactory(TencentHttpClientFactory paramTencentHttpClientFactory)
  {
    sCustFact = paramTencentHttpClientFactory;
  }
  
  public abstract Bundle getParams();
  
  public TencentHttpClient getTencentHttpClient(Context paramContext, Bundle paramBundle)
  {
    if (sCustFact != null) {
      return (TencentHttpClient)b.a.b(sCustFact.getTencentHttpClient(paramContext, sCustFact.getParams()), "http client should NOT be null");
    }
    return new cb(paramContext, paramBundle.getString("channelId"));
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/map/geolocation/internal/TencentHttpClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */