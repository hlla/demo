package com.tencent.mm.ui.contact;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.u.o;
import java.util.HashSet;

public final class s
{
  public static final int vWO;
  public static final int vWP;
  public static final int vWQ;
  public static final int vWR;
  public static final int vWS;
  public static final int vWT;
  public static final int vWU;
  public static final int vWV;
  public static final int vWW;
  
  static
  {
    GMTrace.i(1729395425280L, 12885);
    vWO = q(new int[] { 256, 16, 1, 2, 4 });
    vWP = q(new int[] { 16, 1, 2, 4, 64, 16384 });
    vWQ = q(new int[] { 16, 1, 2, 4, 64, 4096 });
    vWR = q(new int[] { vWO, 64, 16384, 4096 });
    vWS = q(new int[] { 16, 2, 16384, 4 });
    vWT = q(new int[] { vWO, 16384, 64, 4096 });
    vWU = q(new int[] { vWO, 16384, 64, 131072, 8192 });
    vWV = q(new int[] { 16, 32, 1, 4, 2, 64 });
    vWW = q(new int[] { vWP, 131072 });
    GMTrace.o(1729395425280L, 12885);
  }
  
  public static HashSet<String> bYb()
  {
    GMTrace.i(1728590118912L, 12879);
    HashSet localHashSet = new HashSet();
    localHashSet.add("weixin");
    GMTrace.o(1728590118912L, 12879);
    return localHashSet;
  }
  
  public static HashSet<String> bYc()
  {
    GMTrace.i(1728858554368L, 12881);
    HashSet localHashSet = new HashSet();
    localHashSet.add("officialaccounts");
    localHashSet.add("newsapp");
    String[] arrayOfString = o.hlg;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(arrayOfString[i]);
      i += 1;
    }
    localHashSet.add("weibo");
    localHashSet.add("qqmail");
    localHashSet.add("fmessage");
    localHashSet.add("tmessage");
    localHashSet.add("floatbottle");
    localHashSet.add("lbsapp");
    localHashSet.add("shakeapp");
    localHashSet.add("medianote");
    localHashSet.add("qqfriend");
    localHashSet.add("readerapp");
    localHashSet.add("newsapp");
    localHashSet.add("blogapp");
    localHashSet.add("facebookapp");
    localHashSet.add("masssendapp");
    localHashSet.add("meishiapp");
    localHashSet.add("feedsapp");
    localHashSet.add("voipapp");
    localHashSet.add("filehelper");
    localHashSet.add("officialaccounts");
    localHashSet.add("helper_entry");
    localHashSet.add("pc_share");
    localHashSet.add("cardpackage");
    localHashSet.add("voicevoipapp");
    localHashSet.add("voiceinputapp");
    localHashSet.add("linkedinplugin");
    localHashSet.add("appbrandcustomerservicemsg");
    GMTrace.o(1728858554368L, 12881);
    return localHashSet;
  }
  
  public static boolean ee(int paramInt1, int paramInt2)
  {
    GMTrace.i(1728992772096L, 12882);
    if ((paramInt1 & paramInt2) > 0)
    {
      GMTrace.o(1728992772096L, 12882);
      return true;
    }
    GMTrace.o(1728992772096L, 12882);
    return false;
  }
  
  public static int ef(int paramInt1, int paramInt2)
  {
    GMTrace.i(1729126989824L, 12883);
    GMTrace.o(1729126989824L, 12883);
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
  
  public static void f(HashSet<String> paramHashSet)
  {
    GMTrace.i(1728724336640L, 12880);
    paramHashSet.remove("filehelper");
    GMTrace.o(1728724336640L, 12880);
  }
  
  public static int q(int... paramVarArgs)
  {
    int i = 0;
    GMTrace.i(1729261207552L, 12884);
    int k = paramVarArgs.length;
    int j = 0;
    while (i < k)
    {
      j |= paramVarArgs[i];
      i += 1;
    }
    GMTrace.o(1729261207552L, 12884);
    return j;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */