package com.tencent.recovery.option;

public class CommonOptions
{
  public String clientVersion;
  public String mpX;
  public String wOk;
  public String wOo;
  public String wOp;
  public boolean wOq;
  public long wOr;
  public long wOs;
  
  public static final class Builder
  {
    public String clientVersion;
    public String mpX;
    public String wOk;
    public String wOo;
    public String wOp;
    public boolean wOq;
    public long wOr;
    public long wOs;
    
    public final CommonOptions cdq()
    {
      CommonOptions localCommonOptions = new CommonOptions();
      localCommonOptions.wOo = this.wOo;
      localCommonOptions.wOp = this.wOp;
      localCommonOptions.clientVersion = this.clientVersion;
      localCommonOptions.wOk = this.wOk;
      localCommonOptions.mpX = this.mpX;
      localCommonOptions.wOq = this.wOq;
      localCommonOptions.wOr = this.wOr;
      localCommonOptions.wOs = this.wOs;
      return localCommonOptions;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/option/CommonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */