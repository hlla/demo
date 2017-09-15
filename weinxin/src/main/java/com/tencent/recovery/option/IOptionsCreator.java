package com.tencent.recovery.option;

import android.content.Context;

public abstract interface IOptionsCreator
{
  public abstract CommonOptions createCommonOptions(Context paramContext);
  
  public abstract ProcessOptions createProcessOptions(String paramString, int paramInt);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/option/IOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */