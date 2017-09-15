package com.tencent.mm.modelcdntran;

import com.tencent.gmtrace.GMTrace;

public final class i
  extends h
{
  public String fOl;
  public int fOn;
  public long fTG;
  public String filename;
  public String fvf;
  public String host;
  public long hyY;
  public String hyZ;
  public int hza;
  public int hzb;
  public String hzc;
  public int hzd;
  public int hze;
  public long hzf;
  public int hzg;
  public a hzh;
  public String[] iplist;
  public boolean isColdSnsData;
  public String referer;
  public String signalQuality;
  public String snsScene;
  public String url;
  
  public i()
  {
    GMTrace.i(592168615936L, 4412);
    this.hze = 0;
    this.hzf = 0L;
    this.fTG = 0L;
    this.isColdSnsData = false;
    this.signalQuality = "";
    this.snsScene = "";
    this.fvf = "";
    this.hzg = 0;
    GMTrace.o(592168615936L, 4412);
  }
  
  public final boolean Eq()
  {
    GMTrace.i(17503870779392L, 130414);
    if (this.hyW == 3)
    {
      GMTrace.o(17503870779392L, 130414);
      return true;
    }
    GMTrace.o(17503870779392L, 130414);
    return false;
  }
  
  public final String toString()
  {
    GMTrace.i(592437051392L, 4414);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("{");
    ((StringBuffer)localObject).append("isPlayMode: ").append(this.hzb);
    ((StringBuffer)localObject).append(" videoFormat: ").append(this.field_requestVideoFormat);
    ((StringBuffer)localObject).append(" initialDownloadLength : ").append(this.initialDownloadLength);
    ((StringBuffer)localObject).append(" initialDownloadOffset : ").append(this.initialDownloadOffset);
    ((StringBuffer)localObject).append(" videoXmlTotalLen : ").append(this.hza);
    ((StringBuffer)localObject).append(" videoTaskType : ").append(this.hyW);
    ((StringBuffer)localObject).append(" filename : ").append(this.filename);
    int i;
    if (Eo())
    {
      ((StringBuffer)localObject).append(" url : ").append(this.url);
      ((StringBuffer)localObject).append(" host : ").append(this.host);
      ((StringBuffer)localObject).append(" referer : ").append(this.referer);
      StringBuffer localStringBuffer = ((StringBuffer)localObject).append(" ip size : ");
      if (this.iplist != null)
      {
        i = this.iplist.length;
        localStringBuffer.append(i);
        ((StringBuffer)localObject).append(" isColdSnsData : ").append(this.isColdSnsData);
        ((StringBuffer)localObject).append(" signalQuality : ").append(this.signalQuality);
        ((StringBuffer)localObject).append(" snsScene : ").append(this.snsScene);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject).append("fileid : ").append(this.field_fileId);
      ((StringBuffer)localObject).append("fileaeskey: ").append(this.field_aesKey);
      ((StringBuffer)localObject).append("field_preloadRatio:").append(this.field_preloadRatio);
      ((StringBuffer)localObject).append("newmd5: ").append(this.fvf);
      ((StringBuffer)localObject).append("}");
      localObject = ((StringBuffer)localObject).toString();
      GMTrace.o(592437051392L, 4414);
      return (String)localObject;
      i = 0;
      break;
      ((StringBuffer)localObject).append(" field_mediaId : ").append(this.field_mediaId);
    }
  }
  
  public static abstract interface a
  {
    public abstract void f(String paramString, int paramInt1, int paramInt2);
    
    public abstract void onDataAvailable(String paramString, int paramInt1, int paramInt2);
    
    public abstract void onMoovReady(String paramString, int paramInt1, int paramInt2);
    
    public abstract void w(String paramString, int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcdntran/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */