package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import java.util.Map;

final class w
{
  private Context wUk = null;
  private Context wUl = null;
  private String wUm = null;
  private String[] wUn = null;
  DexLoader wUo = null;
  private String wUp = "TbsDexOpt";
  private String wUq = null;
  
  public w(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, o paramo)
  {
    TbsLog.i("TbsWizard", "construction start...");
    if ((paramContext1 == null) || ((paramContext2 == null) && (t.ceA() == null)) || (TextUtils.isEmpty(paramString1)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      throw new Exception("TbsWizard paramter error:-1callerContext:" + paramContext1 + "hostcontext" + paramContext2 + "isEmpty" + TextUtils.isEmpty(paramString1) + "dexfileList" + paramArrayOfString);
    }
    this.wUk = paramContext1.getApplicationContext();
    this.wUl = paramContext2;
    this.wUm = paramString1;
    this.wUn = paramArrayOfString;
    this.wUp = paramString2;
    if (paramo != null) {
      paramo.a("load_tbs_dex", (byte)1);
    }
    this.wUo = new DexLoader(paramString3, this.wUk, this.wUn, paramString2, QbSdk.wRu);
    if (paramo != null) {
      paramo.a("load_tbs_dex", (byte)2);
    }
    libwebp.loadWepLibraryIfNeed(paramContext2, this.wUm);
    if ("com.nd.android.pandahome2".equals(this.wUk.getApplicationInfo().packageName))
    {
      paramContext2 = this.wUo;
      paramString1 = this.wUk;
      paramContext2.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[] { Context.class }, new Object[] { paramString1 });
    }
    if (QbSdk.wRu != null)
    {
      paramContext2 = this.wUo;
      paramString1 = QbSdk.wRu;
      paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
    }
    if (paramo != null) {
      paramo.a("init_tbs", (byte)1);
    }
    paramContext2 = this.wUo;
    paramString1 = c.aMq;
    paramString2 = c.wVs;
    paramArrayOfString = c.wVt;
    paramString3 = c.aQl;
    paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[] { Context.class, String.class, String.class, String.class, String.class }, new Object[] { paramContext1, paramString1, paramString2, paramArrayOfString, paramString3 });
    String str1;
    String str2;
    int i;
    if ((this.wUl == null) && (t.ceA() != null))
    {
      paramContext2 = this.wUo;
      paramString1 = Integer.TYPE;
      paramString2 = this.wUl;
      paramArrayOfString = this.wUo;
      paramString3 = this.wUm;
      str1 = this.wUp;
      str2 = QbSdk.cdG();
      String str3 = t.ceA();
      paramContext2 = paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, paramString1, String.class, String.class }, new Object[] { paramContext1, paramString2, paramArrayOfString, paramString3, str1, "3.5.0.1016", Integer.valueOf(43501), str2, str3 });
      paramString1 = paramContext2;
      if (paramContext2 == null)
      {
        this.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[] { String.class }, new Object[] { "3.5.0.1016" });
        this.wUo.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(43501));
        paramContext2 = this.wUo;
        paramString1 = this.wUl;
        paramString2 = this.wUo;
        paramArrayOfString = this.wUm;
        paramString3 = this.wUp;
        paramString1 = paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class }, new Object[] { paramContext1, paramString1, paramString2, paramArrayOfString, paramString3 });
      }
      if (paramString1 != null) {
        break label1042;
      }
      i = -3;
      label746:
      if (i >= 0) {
        break label1099;
      }
      paramContext1 = this.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((paramContext1 instanceof Throwable))
      {
        paramContext2 = (Throwable)paramContext1;
        this.wUq = ("#" + paramContext2.getMessage() + "; cause: " + paramContext2.getCause() + "; th: " + paramContext2);
      }
      if (!(paramContext1 instanceof String)) {}
    }
    label1042:
    label1099:
    for (this.wUq = ((String)paramContext1);; this.wUq = null)
    {
      if (paramo != null) {
        paramo.a("init_tbs", (byte)2);
      }
      if (i >= 0) {
        break label1107;
      }
      throw new Exception("TbsWizard init error: " + i + "; msg: " + this.wUq);
      paramContext2 = this.wUo;
      paramString1 = Integer.TYPE;
      paramString2 = this.wUl;
      paramArrayOfString = this.wUo;
      paramString3 = this.wUm;
      str1 = this.wUp;
      str2 = QbSdk.cdG();
      paramContext2 = paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, paramString1, String.class }, new Object[] { paramContext1, paramString2, paramArrayOfString, paramString3, str1, "3.5.0.1016", Integer.valueOf(43501), str2 });
      break;
      if ((paramString1 instanceof Integer))
      {
        i = ((Integer)paramString1).intValue();
        break label746;
      }
      if ((paramString1 instanceof Throwable))
      {
        i.cdS().a(this.wUk, 328, (Throwable)paramString1);
        i = -5;
        break label746;
      }
      i = -4;
      break label746;
    }
    label1107:
    TbsLog.i("TbsWizard", "construction end...");
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */