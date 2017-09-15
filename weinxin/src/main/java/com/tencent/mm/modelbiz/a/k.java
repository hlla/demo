package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k
  extends i<j>
{
  public static final String[] gUn;
  public e gUp;
  final com.tencent.mm.sdk.e.k<a, k.a.b> htP;
  Map<String, String> hwq;
  
  static
  {
    GMTrace.i(4570113638400L, 34050);
    gUn = new String[] { i.a(j.gTF, "BizChatUserInfo") };
    GMTrace.o(4570113638400L, 34050);
  }
  
  public k(e parame)
  {
    super(parame, j.gTF, "BizChatUserInfo", null);
    GMTrace.i(4568905678848L, 34041);
    this.hwq = new HashMap();
    this.htP = new com.tencent.mm.sdk.e.k() {};
    this.gUp = parame;
    parame.eE("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
    this.hwq.clear();
    GMTrace.o(4568905678848L, 34041);
  }
  
  public static String a(String[] paramArrayOfString, List<String> paramList)
  {
    GMTrace.i(4569845202944L, 34048);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      GMTrace.o(4569845202944L, 34048);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(" 1=1 ");
    String str = "";
    Object localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.size() > 0)
      {
        localObject = paramList.iterator();
        for (paramList = ""; ((Iterator)localObject).hasNext(); paramList = paramList + " and userId != '" + str + "'") {
          str = (String)((Iterator)localObject).next();
        }
        localObject = paramList;
      }
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" and ");
    localStringBuilder.append("userId in(");
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(" '").append(paramArrayOfString[i]).append("' ");
      i += 1;
    }
    localStringBuilder.append(" )");
    paramArrayOfString = localStringBuilder.toString();
    GMTrace.o(4569845202944L, 34048);
    return paramArrayOfString;
  }
  
  public final boolean a(j paramj)
  {
    GMTrace.i(4569174114304L, 34043);
    v.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
    if (paramj == null)
    {
      v.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
      GMTrace.o(4569174114304L, 34043);
      return false;
    }
    boolean bool = super.b(paramj);
    if (bool)
    {
      k.a.b localb = new k.a.b();
      localb.userId = paramj.field_userId;
      localb.hxa = k.a.a.hwW;
      localb.hxb = paramj;
      this.htP.by(localb);
      this.htP.doNotify();
    }
    GMTrace.o(4569174114304L, 34043);
    return bool;
  }
  
  public final boolean b(j paramj)
  {
    GMTrace.i(4569308332032L, 34044);
    v.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
    if (paramj == null)
    {
      v.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
      GMTrace.o(4569308332032L, 34044);
      return false;
    }
    if ((paramj == null) || (bf.mA(paramj.field_userName))) {
      v.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool = super.a(paramj);
      if (bool)
      {
        k.a.b localb = new k.a.b();
        localb.userId = paramj.field_userId;
        localb.hxa = k.a.a.hwY;
        localb.hxb = paramj;
        this.htP.by(localb);
        this.htP.doNotify();
      }
      GMTrace.o(4569308332032L, 34044);
      return bool;
      paramj.field_userNamePY = c.mq(paramj.field_userName);
    }
  }
  
  public final void c(j paramj)
  {
    GMTrace.i(4569710985216L, 34047);
    v.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
    j localj = iE(paramj.field_userId);
    if (localj != null)
    {
      if ((!bf.mA(paramj.field_userName)) && (!paramj.field_userName.equals(localj.field_userName)))
      {
        localj.field_userName = paramj.field_userName;
        b(localj);
        GMTrace.o(4569710985216L, 34047);
      }
    }
    else {
      a(paramj);
    }
    GMTrace.o(4569710985216L, 34047);
  }
  
  public final j iE(String paramString)
  {
    GMTrace.i(4569039896576L, 34042);
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
      GMTrace.o(4569039896576L, 34042);
      return null;
    }
    j localj = new j();
    localj.field_userId = paramString;
    super.b(localj, new String[0]);
    GMTrace.o(4569039896576L, 34042);
    return localj;
  }
  
  public final j iF(String paramString)
  {
    GMTrace.i(4569442549760L, 34045);
    if (paramString == null)
    {
      v.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
      GMTrace.o(4569442549760L, 34045);
      return null;
    }
    paramString = iG(paramString);
    if (paramString == null)
    {
      v.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
      GMTrace.o(4569442549760L, 34045);
      return null;
    }
    paramString = iE(paramString);
    GMTrace.o(4569442549760L, 34045);
    return paramString;
  }
  
  public final String iG(String paramString)
  {
    GMTrace.i(4569576767488L, 34046);
    if (paramString == null)
    {
      v.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
      GMTrace.o(4569576767488L, 34046);
      return null;
    }
    v.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", new Object[] { paramString });
    if ((this.hwq.containsKey(paramString)) && (this.hwq.get(paramString) != null))
    {
      paramString = (String)this.hwq.get(paramString);
      GMTrace.o(4569576767488L, 34046);
      return paramString;
    }
    f localf = w.DM().iC(paramString);
    if (localf != null)
    {
      v.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", new Object[] { paramString, localf.field_userId });
      this.hwq.put(paramString, localf.field_userId);
      paramString = localf.field_userId;
      GMTrace.o(4569576767488L, 34046);
      return paramString;
    }
    v.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", new Object[] { paramString });
    GMTrace.o(4569576767488L, 34046);
    return null;
  }
  
  public static abstract interface a
  {
    public static enum a
    {
      static
      {
        GMTrace.i(4577361395712L, 34104);
        hwW = 1;
        hwX = 2;
        hwY = 3;
        hwZ = new int[] { hwW, hwX, hwY };
        GMTrace.o(4577361395712L, 34104);
      }
    }
    
    public static final class b
    {
      public int hxa;
      public j hxb;
      public String userId;
      
      public b()
      {
        GMTrace.i(4573469081600L, 34075);
        GMTrace.o(4573469081600L, 34075);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */