package com.tencent.recovery.option;

import com.tencent.recovery.config.Express;

public class ProcessOptions
{
  public int jaz;
  public Express wOu;
  
  public static final class Builder
  {
    private int jaz;
    public Express wOu;
    
    public final Builder cds()
    {
      this.jaz = 10000;
      return this;
    }
    
    public final ProcessOptions cdt()
    {
      ProcessOptions localProcessOptions = new ProcessOptions();
      localProcessOptions.jaz = this.jaz;
      localProcessOptions.wOu = this.wOu;
      return localProcessOptions;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/option/ProcessOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */