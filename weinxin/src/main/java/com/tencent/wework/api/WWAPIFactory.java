package com.tencent.wework.api;

import android.content.Context;

public class WWAPIFactory
{
  public static IWWAPI hM(Context paramContext)
  {
    return new WWAPIImpl(paramContext);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wework/api/WWAPIFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */