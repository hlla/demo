package com.tencent.mm.network;

import com.tencent.gmtrace.GMTrace;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class t
{
  public int idK;
  public HttpURLConnection ieF;
  public String ieG;
  private Map<String, List<String>> ieH;
  public URL url;
  
  public t(URL paramURL, int paramInt)
  {
    GMTrace.i(13697321795584L, 102053);
    this.ieH = null;
    this.url = paramURL;
    this.idK = paramInt;
    this.ieF = ((HttpURLConnection)this.url.openConnection());
    if (1 == this.idK) {
      this.ieF.setInstanceFollowRedirects(false);
    }
    GMTrace.o(13697321795584L, 102053);
  }
  
  public final void MB()
  {
    GMTrace.i(13698395537408L, 102061);
    this.ieF.setDoInput(true);
    GMTrace.o(13698395537408L, 102061);
  }
  
  public final void MC()
  {
    GMTrace.i(13698529755136L, 102062);
    this.ieF.setDoOutput(true);
    GMTrace.o(13698529755136L, 102062);
  }
  
  public final void connect()
  {
    GMTrace.i(13697724448768L, 102056);
    if ((1 == this.idK) && (this.ieH == null)) {
      this.ieH = this.ieF.getRequestProperties();
    }
    this.ieF.connect();
    GMTrace.o(13697724448768L, 102056);
  }
  
  public final String getHeaderField(String paramString)
  {
    GMTrace.i(13697992884224L, 102058);
    if ((1 == this.idK) && (this.ieH == null)) {
      this.ieH = this.ieF.getRequestProperties();
    }
    paramString = this.ieF.getHeaderField(paramString);
    GMTrace.o(13697992884224L, 102058);
    return paramString;
  }
  
  public final Map<String, List<String>> getHeaderFields()
  {
    GMTrace.i(13697858666496L, 102057);
    if ((1 == this.idK) && (this.ieH == null)) {
      this.ieH = this.ieF.getRequestProperties();
    }
    Map localMap = this.ieF.getHeaderFields();
    GMTrace.o(13697858666496L, 102057);
    return localMap;
  }
  
  public final InputStream getInputStream()
  {
    GMTrace.i(13698127101952L, 102059);
    if (1 == this.idK)
    {
      if (this.ieH == null) {
        this.ieH = this.ieF.getRequestProperties();
      }
      getResponseCode();
    }
    InputStream localInputStream = this.ieF.getInputStream();
    GMTrace.o(13698127101952L, 102059);
    return localInputStream;
  }
  
  public final OutputStream getOutputStream()
  {
    GMTrace.i(13698261319680L, 102060);
    if (1 == this.idK)
    {
      if (this.ieH == null) {
        this.ieH = this.ieF.getRequestProperties();
      }
      getResponseCode();
    }
    OutputStream localOutputStream = this.ieF.getOutputStream();
    GMTrace.o(13698261319680L, 102060);
    return localOutputStream;
  }
  
  public final int getResponseCode()
  {
    GMTrace.i(13697456013312L, 102054);
    int i;
    for (;;)
    {
      if ((1 == this.idK) && (this.ieH == null)) {
        this.ieH = this.ieF.getRequestProperties();
      }
      i = this.ieF.getResponseCode();
      if ((1 != this.idK) || (302 != i)) {
        break;
      }
      Object localObject = this.ieF.getHeaderField("Location");
      if (localObject == null)
      {
        GMTrace.o(13697456013312L, 102054);
        return i;
      }
      this.url = new URL(this.url, (String)localObject);
      this.ieF = ((HttpURLConnection)this.url.openConnection());
      this.ieF.setInstanceFollowRedirects(false);
      if (this.ieH != null)
      {
        localObject = this.ieH.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((!str.equals("Host")) && (!str.equals("X-Online-Host")))
          {
            List localList = (List)this.ieH.get(str);
            i = 0;
            while (i < localList.size())
            {
              this.ieF.setRequestProperty(str, (String)localList.get(i));
              i += 1;
            }
          }
        }
      }
      this.ieF.setRequestProperty("Host", this.url.getHost());
      this.ieF.setRequestProperty("X-Online-Host", this.url.getHost());
    }
    GMTrace.o(13697456013312L, 102054);
    return i;
  }
  
  public final void mk(String paramString)
  {
    GMTrace.i(13699200843776L, 102067);
    this.ieF.setRequestProperty("Referer", paramString);
    GMTrace.o(13699200843776L, 102067);
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    GMTrace.i(13698932408320L, 102065);
    this.ieF.setConnectTimeout(paramInt);
    GMTrace.o(13698932408320L, 102065);
  }
  
  public final void setReadTimeout(int paramInt)
  {
    GMTrace.i(13699066626048L, 102066);
    this.ieF.setReadTimeout(paramInt);
    GMTrace.o(13699066626048L, 102066);
  }
  
  public final void setRequestMethod(String paramString)
  {
    GMTrace.i(13697590231040L, 102055);
    this.ieF.setRequestMethod(paramString);
    GMTrace.o(13697590231040L, 102055);
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    GMTrace.i(13698663972864L, 102063);
    this.ieF.setRequestProperty(paramString1, paramString2);
    GMTrace.o(13698663972864L, 102063);
  }
  
  public final void setUseCaches(boolean paramBoolean)
  {
    GMTrace.i(13698798190592L, 102064);
    this.ieF.setUseCaches(paramBoolean);
    GMTrace.o(13698798190592L, 102064);
  }
  
  public final String toString()
  {
    GMTrace.i(13699335061504L, 102068);
    String str = this.ieF.toString();
    GMTrace.o(13699335061504L, 102068);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */