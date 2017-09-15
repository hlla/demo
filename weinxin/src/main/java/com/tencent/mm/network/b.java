package com.tencent.mm.network;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class b
{
  public static a idJ;
  
  public static int a(t paramt)
  {
    GMTrace.i(13656116953088L, 101746);
    try
    {
      int i = paramt.getResponseCode();
      if (i != 200)
      {
        GMTrace.o(13656116953088L, 101746);
        return -1;
      }
      GMTrace.o(13656116953088L, 101746);
      return 0;
    }
    catch (Exception paramt)
    {
      v.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bf.g(paramt) });
      GMTrace.o(13656116953088L, 101746);
    }
    return -3;
  }
  
  public static int a(boolean paramBoolean, List<String> paramList, String paramString)
  {
    GMTrace.i(13655714299904L, 101743);
    if (idJ == null)
    {
      GMTrace.o(13655714299904L, 101743);
      return -1;
    }
    try
    {
      int i = idJ.vh().a(paramString, paramBoolean, paramList);
      GMTrace.o(13655714299904L, 101743);
      return i;
    }
    catch (Exception paramList)
    {
      v.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bf.g(paramList) });
      GMTrace.o(13655714299904L, 101743);
    }
    return -1;
  }
  
  public static t a(String paramString, b paramb)
  {
    GMTrace.i(13655982735360L, 101745);
    b localb = paramb;
    if (paramb == null) {
      localb = new b(paramString);
    }
    v.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", new Object[] { localb.host, localb.url, localb.ip, Integer.valueOf(localb.idK) });
    paramString = new t(localb.url, localb.idK);
    paramString.ieG = localb.ip;
    if (1 == localb.idK)
    {
      paramString.setRequestProperty("Host", localb.host);
      paramString.setRequestProperty("X-Online-Host", localb.host);
    }
    GMTrace.o(13655982735360L, 101745);
    return paramString;
  }
  
  public static void a(a parama)
  {
    GMTrace.i(13655580082176L, 101742);
    v.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", new Object[] { Boolean.valueOf(false), bf.bJP() });
    idJ = parama;
    GMTrace.o(13655580082176L, 101742);
  }
  
  public static InputStream k(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(13655848517632L, 101744);
    paramString = a(paramString, null);
    paramString.setConnectTimeout(paramInt1);
    paramString.setReadTimeout(paramInt2);
    paramString.setRequestMethod("GET");
    if (a(paramString) != 0)
    {
      GMTrace.o(13655848517632L, 101744);
      return null;
    }
    paramString = paramString.getInputStream();
    GMTrace.o(13655848517632L, 101744);
    return paramString;
  }
  
  public static u mj(String paramString)
  {
    GMTrace.i(13656251170816L, 101747);
    paramString = new u(paramString);
    GMTrace.o(13656251170816L, 101747);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract e vh();
  }
  
  public static final class b
  {
    public String host;
    public int idK;
    private ArrayList<String> idL;
    public String idM;
    public boolean idN;
    private boolean idO;
    public String ip;
    URL url;
    
    public b(String paramString)
    {
      GMTrace.i(13705106423808L, 102111);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.idK = 0;
      this.idL = new ArrayList();
      this.idN = false;
      this.idO = false;
      this.idM = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        Object localObject = new ArrayList();
        if ((b.idJ == null) || (b.idJ.vh() == null))
        {
          if (b.idJ == null) {}
          for (paramString = "-1";; paramString = b.idJ.vh())
          {
            v.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bf.bJP() });
            GMTrace.o(13705106423808L, 102111);
            return;
          }
        }
        this.idK = b.idJ.vh().getHostByName(this.host, (List)localObject);
        v.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", new Object[] { Integer.valueOf(this.idK), this.host, paramString });
        if (((ArrayList)localObject).size() <= 0)
        {
          this.idK = 0;
          GMTrace.o(13705106423808L, 102111);
          return;
        }
        int i = this.idK;
        if (1 != i)
        {
          GMTrace.o(13705106423808L, 102111);
          return;
        }
        localObject = (String)((ArrayList)localObject).get((int)(bf.NA() % ((ArrayList)localObject).size()));
        this.ip = ((String)localObject);
        this.url = new URL(paramString.replaceFirst(this.host, (String)localObject));
        GMTrace.o(13705106423808L, 102111);
        return;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bf.g(paramString) });
        GMTrace.o(13705106423808L, 102111);
      }
    }
    
    public b(String paramString, boolean paramBoolean)
    {
      GMTrace.i(13705240641536L, 102112);
      this.host = null;
      this.url = null;
      this.ip = "";
      this.idK = 0;
      this.idL = new ArrayList();
      this.idN = false;
      this.idO = false;
      this.idN = paramBoolean;
      this.idM = paramString;
      try
      {
        this.url = new URL(paramString);
        this.host = this.url.getHost();
        if ((b.idJ == null) || (b.idJ.vh() == null))
        {
          if (b.idJ == null) {}
          for (paramString = "-1";; paramString = b.idJ.vh())
          {
            v.e("MicroMsg.GprsSetting", "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]", new Object[] { paramString, bf.bJP() });
            GMTrace.o(13705240641536L, 102112);
            return;
          }
        }
        this.idK = b.idJ.vh().a(this.host, paramBoolean, this.idL);
        Random localRandom = new Random();
        localRandom.setSeed(bf.NA());
        Collections.shuffle(this.idL, localRandom);
        v.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", new Object[] { Integer.valueOf(this.idK), this.host, paramString, this.idL });
        if (this.idL.size() <= 0)
        {
          this.idK = 0;
          GMTrace.o(13705240641536L, 102112);
          return;
        }
        int i = this.idK;
        if (1 != i)
        {
          GMTrace.o(13705240641536L, 102112);
          return;
        }
        this.ip = ((String)this.idL.remove(0));
        this.url = new URL(paramString.replaceFirst(this.host, this.ip));
        GMTrace.o(13705240641536L, 102112);
        return;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.GprsSetting", "exception:%s", new Object[] { bf.g(paramString) });
        GMTrace.o(13705240641536L, 102112);
      }
    }
    
    private boolean Mp()
    {
      GMTrace.i(17536083034112L, 130654);
      this.ip = ((String)this.idL.remove(0));
      try
      {
        this.url = new URL(this.idM.replaceFirst(this.host, this.ip));
        GMTrace.o(17536083034112L, 130654);
        return true;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        GMTrace.o(17536083034112L, 130654);
      }
      return false;
    }
    
    public final boolean Mo()
    {
      GMTrace.i(17535948816384L, 130653);
      if (!this.idN)
      {
        if ((!this.idL.isEmpty()) && (Mp()))
        {
          this.idL.clear();
          GMTrace.o(17535948816384L, 130653);
          return true;
        }
        this.idN = true;
        this.idK = b.idJ.vh().a(this.host, this.idN, this.idL);
        Random localRandom = new Random();
        localRandom.setSeed(bf.NA());
        Collections.shuffle(this.idL, localRandom);
      }
      if ((!this.idL.isEmpty()) && (Mp()))
      {
        this.idL.clear();
        GMTrace.o(17535948816384L, 130653);
        return true;
      }
      if (!this.idO)
      {
        this.idO = true;
        try
        {
          this.url = new URL(this.idM);
          GMTrace.o(17535948816384L, 130653);
          return true;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          GMTrace.o(17535948816384L, 130653);
          return false;
        }
      }
      GMTrace.o(17535948816384L, 130653);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */