package com.tencent.mm.pluginsdk.k.a.d;

import com.tencent.gmtrace.GMTrace;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class k
  implements f.b
{
  private final String filePath;
  private final String groupId;
  protected volatile int jnQ;
  private final String method;
  final int networkType;
  final int priority;
  protected final Map<String, String> requestHeaders;
  final int sDB;
  public final String sDr;
  private final String sEK;
  protected volatile int sFa;
  protected volatile int sFb;
  public final String url;
  
  public k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(865704345600L, 6450);
    this.requestHeaders = new HashMap();
    this.jnQ = 15000;
    this.sFa = 20000;
    this.sFb = 15000;
    this.sDr = paramString1;
    this.filePath = paramString2;
    this.sEK = paramString3;
    this.groupId = paramString4;
    this.url = paramString5;
    this.method = paramString6;
    this.sDB = paramInt1;
    this.networkType = paramInt2;
    this.priority = Math.max(paramInt3, 0);
    GMTrace.o(865704345600L, 6450);
  }
  
  public String Qo()
  {
    GMTrace.i(865972781056L, 6452);
    String str = this.groupId;
    GMTrace.o(865972781056L, 6452);
    return str;
  }
  
  public final String bDh()
  {
    GMTrace.i(866241216512L, 6454);
    String str = this.sDr;
    GMTrace.o(866241216512L, 6454);
    return str;
  }
  
  public boolean bDk()
  {
    GMTrace.i(865838563328L, 6451);
    GMTrace.o(865838563328L, 6451);
    return false;
  }
  
  public final int bDv()
  {
    GMTrace.i(866778087424L, 6458);
    int i = this.sFb;
    GMTrace.o(866778087424L, 6458);
    return i;
  }
  
  public final int getConnectTimeout()
  {
    GMTrace.i(866509651968L, 6456);
    int i = this.jnQ;
    GMTrace.o(866509651968L, 6456);
    return i;
  }
  
  public String getFilePath()
  {
    GMTrace.i(866106998784L, 6453);
    String str = this.filePath;
    GMTrace.o(866106998784L, 6453);
    return str;
  }
  
  public final int getReadTimeout()
  {
    GMTrace.i(866643869696L, 6457);
    int i = this.sFa;
    GMTrace.o(866643869696L, 6457);
    return i;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    GMTrace.i(866375434240L, 6455);
    if (this.requestHeaders.size() == 0)
    {
      GMTrace.o(866375434240L, 6455);
      return null;
    }
    Map localMap = Collections.unmodifiableMap(this.requestHeaders);
    GMTrace.o(866375434240L, 6455);
    return localMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */