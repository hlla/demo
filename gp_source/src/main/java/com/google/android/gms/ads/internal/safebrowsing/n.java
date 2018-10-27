package com.google.android.gms.ads.internal.safebrowsing;

import android.annotation.TargetApi;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.common.util.h;
import java.util.HashMap;
import java.util.Map;

@a
@TargetApi(21)
final class n
{
  static
  {
    HashMap localHashMap = new HashMap();
    if (h.c())
    {
      localHashMap.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
      localHashMap.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/safebrowsing/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */