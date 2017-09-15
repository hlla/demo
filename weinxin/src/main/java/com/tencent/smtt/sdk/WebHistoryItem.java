package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem
{
  private IX5WebHistoryItem wUt = null;
  private android.webkit.WebHistoryItem wUu = null;
  
  static WebHistoryItem a(android.webkit.WebHistoryItem paramWebHistoryItem)
  {
    if (paramWebHistoryItem == null) {
      return null;
    }
    WebHistoryItem localWebHistoryItem = new WebHistoryItem();
    localWebHistoryItem.wUu = paramWebHistoryItem;
    return localWebHistoryItem;
  }
  
  static WebHistoryItem a(IX5WebHistoryItem paramIX5WebHistoryItem)
  {
    if (paramIX5WebHistoryItem == null) {
      return null;
    }
    WebHistoryItem localWebHistoryItem = new WebHistoryItem();
    localWebHistoryItem.wUt = paramIX5WebHistoryItem;
    return localWebHistoryItem;
  }
  
  public Bitmap getFavicon()
  {
    if (this.wUt != null) {
      return this.wUt.getFavicon();
    }
    return this.wUu.getFavicon();
  }
  
  public String getOriginalUrl()
  {
    if (this.wUt != null) {
      return this.wUt.getOriginalUrl();
    }
    return this.wUu.getOriginalUrl();
  }
  
  public String getTitle()
  {
    if (this.wUt != null) {
      return this.wUt.getTitle();
    }
    return this.wUu.getTitle();
  }
  
  public String getUrl()
  {
    if (this.wUt != null) {
      return this.wUt.getUrl();
    }
    return this.wUu.getUrl();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/WebHistoryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */