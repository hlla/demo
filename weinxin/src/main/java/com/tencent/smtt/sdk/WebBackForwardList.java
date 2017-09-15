package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList
{
  private IX5WebBackForwardList wUr = null;
  private android.webkit.WebBackForwardList wUs = null;
  
  static WebBackForwardList a(android.webkit.WebBackForwardList paramWebBackForwardList)
  {
    if (paramWebBackForwardList == null) {
      return null;
    }
    WebBackForwardList localWebBackForwardList = new WebBackForwardList();
    localWebBackForwardList.wUs = paramWebBackForwardList;
    return localWebBackForwardList;
  }
  
  static WebBackForwardList a(IX5WebBackForwardList paramIX5WebBackForwardList)
  {
    if (paramIX5WebBackForwardList == null) {
      return null;
    }
    WebBackForwardList localWebBackForwardList = new WebBackForwardList();
    localWebBackForwardList.wUr = paramIX5WebBackForwardList;
    return localWebBackForwardList;
  }
  
  public int getCurrentIndex()
  {
    if (this.wUr != null) {
      return this.wUr.getCurrentIndex();
    }
    return this.wUs.getCurrentIndex();
  }
  
  public WebHistoryItem getCurrentItem()
  {
    if (this.wUr != null) {
      return WebHistoryItem.a(this.wUr.getCurrentItem());
    }
    return WebHistoryItem.a(this.wUs.getCurrentItem());
  }
  
  public WebHistoryItem getItemAtIndex(int paramInt)
  {
    if (this.wUr != null) {
      return WebHistoryItem.a(this.wUr.getItemAtIndex(paramInt));
    }
    return WebHistoryItem.a(this.wUs.getItemAtIndex(paramInt));
  }
  
  public int getSize()
  {
    if (this.wUr != null) {
      return this.wUr.getSize();
    }
    return this.wUs.getSize();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/WebBackForwardList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */