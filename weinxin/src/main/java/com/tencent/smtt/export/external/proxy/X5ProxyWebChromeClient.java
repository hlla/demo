package com.tencent.smtt.export.external.proxy;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;

public abstract class X5ProxyWebChromeClient
  extends ProxyWebChromeClient
{
  public X5ProxyWebChromeClient(WebViewWizardBase paramWebViewWizardBase)
  {
    this.mWebChromeClient = ((IX5WebChromeClient)paramWebViewWizardBase.newInstance("com.tencent.smtt.webkit.WebChromeClient"));
  }
  
  public X5ProxyWebChromeClient(IX5WebChromeClient paramIX5WebChromeClient)
  {
    setWebChromeClient(paramIX5WebChromeClient);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/export/external/proxy/X5ProxyWebChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */