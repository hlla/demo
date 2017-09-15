package com.tencent.wework.api.util;

import java.lang.reflect.Constructor;

public final class ReflecterHelper
{
  public static Object newInstance(String paramString)
  {
    paramString = Class.forName(paramString).getDeclaredConstructor(null);
    paramString.setAccessible(true);
    return paramString.newInstance(null);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wework/api/util/ReflecterHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */