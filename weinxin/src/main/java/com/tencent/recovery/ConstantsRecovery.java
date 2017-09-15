package com.tencent.recovery;

import com.tencent.recovery.config.Express;
import com.tencent.recovery.config.ExpressItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.option.ProcessOptions.Builder;
import java.util.ArrayList;
import java.util.List;

public class ConstantsRecovery
{
  public static final class DefaultCommonOptions
  {
    public static final CommonOptions wNG;
    
    static
    {
      CommonOptions.Builder localBuilder = new CommonOptions.Builder();
      localBuilder.mpX = "";
      localBuilder.clientVersion = "";
      localBuilder.wOk = "";
      localBuilder.wOo = "";
      localBuilder.wOp = "";
      wNG = localBuilder.cdq();
    }
  }
  
  public static final class DefaultExpress
  {
    public static final Express wNH = new Express();
    public static final Express wNI;
    public static final Express wNJ;
    
    static
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(17, 1114112));
      wNH.cX(localArrayList);
      wNI = new Express();
      localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(1, 1118208));
      wNI.cX(localArrayList);
      wNJ = new Express();
      localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(1, 1114112));
      wNJ.cX(localArrayList);
    }
  }
  
  public static final class DefaultProcessOptions
  {
    public static final ProcessOptions wNK;
    public static final ProcessOptions wNL;
    public static final ProcessOptions wNM;
    
    static
    {
      ProcessOptions.Builder localBuilder = new ProcessOptions.Builder();
      localBuilder.wOu = ConstantsRecovery.DefaultExpress.wNH;
      localBuilder.cds();
      wNK = localBuilder.cdt();
      localBuilder = new ProcessOptions.Builder();
      localBuilder.wOu = ConstantsRecovery.DefaultExpress.wNI;
      localBuilder.cds();
      wNL = localBuilder.cdt();
      localBuilder = new ProcessOptions.Builder();
      localBuilder.wOu = ConstantsRecovery.DefaultExpress.wNJ;
      localBuilder.cds();
      wNM = localBuilder.cdt();
    }
  }
  
  public static final class IntentAction {}
  
  public static final class IntentKeys {}
  
  public static final class Message {}
  
  public static final class ProcessStage {}
  
  public static final class ProcessStartFlag {}
  
  public static final class ProcessStatus {}
  
  public static final class ReportType {}
  
  public static final class SpKeys {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/ConstantsRecovery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */