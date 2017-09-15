package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.sdk.platformtools.bf;

final class c
  extends k
{
  private final boolean fEy;
  final String fFN;
  final long fileSize;
  volatile boolean rUz;
  volatile byte[] sDZ;
  final long sDz;
  
  private c(String paramString1, int paramInt1, String paramString2, boolean paramBoolean, long paramLong1, String paramString3, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    super(paramString1, i.Mo(paramString1), String.valueOf(paramInt1), "CheckResUpdate", paramString3, "GET", paramInt2, paramInt3, paramInt4);
    GMTrace.i(843155767296L, 6282);
    this.fFN = paramString2;
    this.sDz = paramLong1;
    this.fEy = paramBoolean;
    this.fileSize = paramLong2;
    GMTrace.o(843155767296L, 6282);
  }
  
  static c b(q paramq)
  {
    GMTrace.i(843692638208L, 6286);
    paramq = new c(paramq.field_urlKey, bf.getInt(paramq.field_fileVersion, 0), paramq.field_md5, bf.mz(paramq.field_groupId2).equals("NewXml"), paramq.field_reportId, paramq.field_url, paramq.field_maxRetryTimes, paramq.field_fileSize, paramq.field_networkType, paramq.field_priority);
    GMTrace.o(843692638208L, 6286);
    return paramq;
  }
  
  public final String Qo()
  {
    GMTrace.i(843558420480L, 6285);
    GMTrace.o(843558420480L, 6285);
    return "CheckResUpdate";
  }
  
  public final boolean bDk()
  {
    GMTrace.i(843289985024L, 6283);
    GMTrace.o(843289985024L, 6283);
    return true;
  }
  
  public final String getFilePath()
  {
    GMTrace.i(843424202752L, 6284);
    String str = i.Mo(this.sDr);
    GMTrace.o(843424202752L, 6284);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */