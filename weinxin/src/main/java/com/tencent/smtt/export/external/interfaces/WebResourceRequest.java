package com.tencent.smtt.export.external.interfaces;

import android.net.Uri;
import java.util.Map;

public abstract interface WebResourceRequest
{
  public abstract String getMethod();
  
  public abstract Map<String, String> getRequestHeaders();
  
  public abstract Uri getUrl();
  
  public abstract boolean hasGesture();
  
  public abstract boolean isForMainFrame();
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/export/external/interfaces/WebResourceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */