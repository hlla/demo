package com.tencent.map.geolocation;

public class TencentLocationManagerOptions
{
  private static boolean a = true;
  private static boolean b = true;
  
  public static boolean isGpsFilterEnabled()
  {
    return b;
  }
  
  public static boolean isLoadLibraryEnabled()
  {
    return a;
  }
  
  public static void setGpsFilterEnabled(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static void setLoadLibraryEnabled(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/map/geolocation/TencentLocationManagerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */