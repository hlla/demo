package com.tencent.mm.pluginsdk.k.a.d;

import com.tencent.gmtrace.GMTrace;

public abstract class a
{
  public final String fFN;
  private final String filePath;
  private volatile int hNz;
  private final long hUP;
  public final int networkType;
  public final int priority;
  public final int sDB;
  public final String sDr;
  public final String sEK;
  private final String sEL;
  private final String sEM;
  protected volatile int status;
  public final String url;
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt3)
  {
    GMTrace.i(880334077952L, 6559);
    this.status = 0;
    this.url = paramString1;
    this.sDr = paramString2;
    this.sEK = paramString3;
    this.networkType = paramInt1;
    this.sDB = paramInt2;
    this.hNz = this.sDB;
    this.filePath = paramString4;
    this.hUP = paramLong;
    this.sEL = paramString6;
    this.sEM = paramString7;
    this.fFN = paramString5;
    this.priority = paramInt3;
    GMTrace.o(880334077952L, 6559);
  }
  
  public int Mn(String paramString)
  {
    GMTrace.i(880602513408L, 6561);
    GMTrace.o(880602513408L, 6561);
    return 0;
  }
  
  public q bDl()
  {
    GMTrace.i(880468295680L, 6560);
    q localq = new q();
    localq.field_url = this.url;
    localq.field_urlKey = this.sDr;
    localq.field_fileVersion = this.sEK;
    localq.field_networkType = this.networkType;
    localq.field_maxRetryTimes = this.sDB;
    localq.field_retryTimes = this.hNz;
    localq.field_filePath = this.filePath;
    localq.field_status = this.status;
    localq.field_expireTime = this.hUP;
    localq.field_groupId1 = this.sEL;
    localq.field_groupId2 = this.sEM;
    localq.field_md5 = this.fFN;
    localq.field_priority = this.priority;
    GMTrace.o(880468295680L, 6560);
    return localq;
  }
  
  public String toString()
  {
    GMTrace.i(880736731136L, 6562);
    String str = "BaseResDownloadRequest | urlKey='" + this.sDr + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.hUP + ", fileVersion=" + this.sEK + ", maxRetryTimes=" + this.sDB + ", md5='" + this.fFN + '\'' + ", groupId1='" + this.sEL + '\'' + ", groupId2='" + this.sEM + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.hNz + ", status=" + this.status + ", priority=" + this.priority;
    GMTrace.o(880736731136L, 6562);
    return str;
  }
  
  public static abstract class a<T extends a>
  {
    public String fFN;
    public long hUP;
    public int networkType;
    public int priority;
    public int sDB;
    public String sDr;
    public final String url;
    
    public a(String paramString)
    {
      GMTrace.i(872146796544L, 6498);
      this.url = paramString;
      GMTrace.o(872146796544L, 6498);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */