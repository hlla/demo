package com.tencent.smtt.export.external.interfaces;

public abstract interface MediaAccessPermissionsCallback
{
  public static final long ALLOW_AUDIO_CAPTURE = 4L;
  public static final long ALLOW_VIDEO_CAPTURE = 2L;
  public static final long BITMASK_RESOURCE_AUDIO_CAPTURE = 4L;
  public static final long BITMASK_RESOURCE_VIDEO_CAPTURE = 2L;
  
  public abstract void invoke(String paramString, long paramLong, boolean paramBoolean);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/export/external/interfaces/MediaAccessPermissionsCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */