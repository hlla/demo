package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
{
  public String host;
  public String mZj;
  private int port;
  private int type;
  
  public n()
  {
    GMTrace.i(13588202782720L, 101240);
    this.type = 0;
    this.port = 80;
    this.mZj = "";
    this.host = "";
    GMTrace.o(13588202782720L, 101240);
  }
  
  public n(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    GMTrace.i(13588337000448L, 101241);
    this.type = 0;
    this.port = 80;
    this.mZj = "";
    this.host = "";
    this.type = paramInt1;
    this.mZj = paramString1;
    this.port = paramInt2;
    this.host = paramString2;
    GMTrace.o(13588337000448L, 101241);
  }
  
  private static n NH(String paramString)
  {
    GMTrace.i(13588605435904L, 101243);
    paramString = paramString.split(",");
    if (paramString.length < 4)
    {
      GMTrace.o(13588605435904L, 101243);
      return null;
    }
    n localn = new n();
    try
    {
      localn.type = bf.getInt(paramString[0], 0);
      localn.mZj = bf.mz(paramString[1]);
      localn.port = bf.getInt(paramString[2], 0);
      localn.host = bf.mz(paramString[3]);
      GMTrace.o(13588605435904L, 101243);
      return localn;
    }
    catch (NumberFormatException paramString)
    {
      v.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bf.g(paramString) });
      GMTrace.o(13588605435904L, 101243);
    }
    return null;
  }
  
  public static List<n> NI(String paramString)
  {
    GMTrace.i(13588873871360L, 101245);
    localLinkedList = new LinkedList();
    if (bf.mA(paramString))
    {
      GMTrace.o(13588873871360L, 101245);
      return localLinkedList;
    }
    try
    {
      String[] arrayOfString = paramString.split("\\|");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        n localn = NH(arrayOfString[i]);
        if (localn != null) {
          localLinkedList.add(localn);
        }
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      v.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", new Object[] { paramString });
      v.e("MicroMsg.MMBuiltInIP", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13588873871360L, 101245);
    }
  }
  
  public static String bT(List<n> paramList)
  {
    GMTrace.i(13588739653632L, 101244);
    Iterator localIterator = paramList.iterator();
    n localn;
    for (paramList = ""; localIterator.hasNext(); paramList = paramList + localn.toString() + "|") {
      localn = (n)localIterator.next();
    }
    GMTrace.o(13588739653632L, 101244);
    return paramList;
  }
  
  public static a et(String paramString1, String paramString2)
  {
    GMTrace.i(13589008089088L, 101246);
    v.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
    v.d("MicroMsg.MMBuiltInIP", "ports = " + paramString1);
    v.d("MicroMsg.MMBuiltInIP", "timeouts = " + paramString2);
    int[] arrayOfInt = bf.PT(paramString1);
    paramString2 = bf.PT(paramString2);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length >= 2) {}
    }
    else
    {
      paramString1 = new int[2];
      paramString1[0] = 0;
      paramString1[1] = 0;
      paramString1;
      v.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
    }
    paramString1 = new a(arrayOfInt, (int)(paramString1[0] * 1000L), (int)(paramString1[1] * 1000L));
    GMTrace.o(13589008089088L, 101246);
    return paramString1;
  }
  
  public final String toString()
  {
    GMTrace.i(13588471218176L, 101242);
    String str = this.type + "," + this.mZj + "," + this.port + "," + this.host;
    GMTrace.o(13588471218176L, 101242);
    return str;
  }
  
  public static final class a
  {
    public final int[] sYc;
    public final int[] sYd;
    public final int sYe;
    public final int sYf;
    
    public a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      GMTrace.i(13565922639872L, 101074);
      this.sYc = null;
      this.sYd = paramArrayOfInt;
      this.sYe = paramInt1;
      this.sYf = paramInt2;
      GMTrace.o(13565922639872L, 101074);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */