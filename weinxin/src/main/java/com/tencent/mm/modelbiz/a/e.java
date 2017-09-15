package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.n;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.o;
import com.tencent.mm.u.ay.a;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static String gxv;
  public static final Object hwA;
  
  static
  {
    GMTrace.i(4568771461120L, 34040);
    gxv = null;
    hwA = new Object();
    GMTrace.o(4568771461120L, 34040);
  }
  
  public static c a(c paramc, long paramLong)
  {
    GMTrace.i(4566355542016L, 34022);
    if (paramc == null) {}
    for (long l = -1L;; l = paramc.field_bizChatLocalId)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
      c localc = paramc;
      if (paramc == null)
      {
        paramc = new c();
        paramc.field_bizChatLocalId = paramLong;
        w.DJ().b(paramc);
        localc = w.DJ().aa(paramLong);
      }
      GMTrace.o(4566355542016L, 34022);
      return localc;
    }
  }
  
  public static j a(j paramj, String paramString)
  {
    GMTrace.i(4566489759744L, 34023);
    if (paramj == null) {}
    for (Object localObject = Integer.valueOf(-1);; localObject = paramj.field_userId)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist userId:%s BizChatUserInfo:%s ", new Object[] { paramString, localObject });
      localObject = paramj;
      if (paramj != null) {
        break;
      }
      j localj = new j();
      localj.field_userId = paramString;
      w.DL().b(localj);
      paramj = w.DL().iE(paramString);
      localObject = paramj;
      if (paramj != null) {
        break;
      }
      v.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
      GMTrace.o(4566489759744L, 34023);
      return localj;
    }
    GMTrace.o(4566489759744L, 34023);
    return (j)localObject;
  }
  
  public static boolean a(c paramc, String paramString1, String paramString2, sr paramsr)
  {
    GMTrace.i(4568368807936L, 34037);
    if ((paramString1 != null) && (!bf.mA(paramc.field_brandUserName))) {}
    for (;;)
    {
      int i;
      try
      {
        paramString1 = new JSONArray(paramString1);
        if ((paramString1.length() == 1) && (bf.mA(paramString2)))
        {
          paramString2 = paramString1.getJSONObject(0);
          paramsr = paramString2.getString("id");
          paramString1 = w.DL().iE(paramsr);
          if (paramString1 != null) {
            break label557;
          }
          paramString1 = new j();
          i = 1;
          paramString1.field_userId = paramsr;
          paramString1.field_userName = paramString2.getString("nick_name");
          paramString1.field_headImageUrl = paramString2.getString("head_img_url");
          paramString1.field_profileUrl = paramString2.getString("profile_url");
          paramString1.field_UserVersion = paramString2.getInt("ver");
          if ((paramString1.field_brandUserName == null) || (paramString1.field_brandUserName.length() == 0))
          {
            paramString1.field_brandUserName = paramc.field_brandUserName;
            i = 1;
          }
          if ((paramString1.field_addMemberUrl == null) || (paramString1.field_addMemberUrl.length() == 0))
          {
            paramString1.field_addMemberUrl = paramc.field_addMemberUrl;
            i = 1;
          }
          if (!w.DL().b(paramString1)) {
            w.DL().a(paramString1);
          }
          if (i != 0) {
            w.DN().Y(paramString1.field_userId, paramString1.field_brandUserName);
          }
          paramString2 = new c();
          paramString2.field_bizChatServId = paramString1.field_userId;
          paramString2.field_brandUserName = paramString1.field_brandUserName;
          paramString2.field_chatName = paramString1.field_userName;
          paramString2.field_chatType = 1;
          paramString2 = e(paramString2);
          if (paramString2 != null)
          {
            paramc.field_bizChatLocalId = paramString2.field_bizChatLocalId;
            paramc.field_chatName = paramString1.field_userName;
            GMTrace.o(4568368807936L, 34037);
            return true;
          }
          GMTrace.o(4568368807936L, 34037);
          return false;
        }
        localLinkedList = new LinkedList();
        if (bf.mA(paramString2)) {
          break label563;
        }
        localObject = new gs();
        ((gs)localObject).tjg = paramString2;
        localLinkedList.add(localObject);
      }
      catch (JSONException paramc)
      {
        LinkedList localLinkedList;
        Object localObject;
        v.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", new Object[] { paramc.getMessage() });
        v.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", paramc, "", new Object[0]);
      }
      if (i < paramString1.length())
      {
        paramString2 = new j();
        localObject = paramString1.getJSONObject(i);
        paramString2.field_userId = ((JSONObject)localObject).getString("id");
        paramString2.field_userName = ((JSONObject)localObject).getString("nick_name");
        paramString2.field_brandUserName = paramc.field_brandUserName;
        paramString2.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
        paramString2.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
        paramString2.field_UserVersion = ((JSONObject)localObject).getInt("ver");
        paramString2.field_addMemberUrl = paramc.field_addMemberUrl;
        if (!w.DL().b(paramString2)) {
          w.DL().a(paramString2);
        }
        localObject = new gs();
        ((gs)localObject).tjg = paramString2.field_userId;
        localLinkedList.add(localObject);
        i += 1;
      }
      else
      {
        paramsr.tjh = localLinkedList;
        paramc.field_bizChatLocalId = -1L;
        GMTrace.o(4568368807936L, 34037);
        return true;
        GMTrace.o(4568368807936L, 34037);
        return false;
        label557:
        i = 0;
        continue;
        label563:
        i = 0;
      }
    }
  }
  
  public static int ab(long paramLong)
  {
    GMTrace.i(4565684453376L, 34017);
    List localList = ac(paramLong);
    if (localList != null)
    {
      int i = localList.size();
      GMTrace.o(4565684453376L, 34017);
      return i;
    }
    v.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
    GMTrace.o(4565684453376L, 34017);
    return 0;
  }
  
  public static List<String> ac(long paramLong)
  {
    GMTrace.i(4565818671104L, 34018);
    List localList = w.DJ().aa(paramLong).DU();
    GMTrace.o(4565818671104L, 34018);
    return localList;
  }
  
  public static String ad(long paramLong)
  {
    GMTrace.i(4567563501568L, 34031);
    String str = w.DJ().aa(paramLong).field_bizChatServId;
    GMTrace.o(4567563501568L, 34031);
    return str;
  }
  
  public static boolean c(c paramc)
  {
    GMTrace.i(4565550235648L, 34016);
    if (paramc == null)
    {
      GMTrace.o(4565550235648L, 34016);
      return false;
    }
    List localList = paramc.DU();
    paramc = w.DL().iG(paramc.field_brandUserName);
    if (paramc == null)
    {
      v.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
      GMTrace.o(4565550235648L, 34016);
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if (paramc.equals((String)localIterator.next()))
      {
        GMTrace.o(4565550235648L, 34016);
        return true;
      }
    }
    v.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", new Object[] { paramc });
    v.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", new Object[] { Arrays.toString(localList.toArray()) });
    GMTrace.o(4565550235648L, 34016);
    return false;
  }
  
  public static String d(c paramc)
  {
    GMTrace.i(4567026630656L, 34027);
    if (paramc == null)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
      GMTrace.o(4567026630656L, 34027);
      return null;
    }
    v.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
    if (paramc.field_bizChatServId == null)
    {
      v.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      GMTrace.o(4567026630656L, 34027);
      return null;
    }
    j localj = iw(paramc.field_brandUserName);
    if ((localj == null) || (localj.field_userId == null))
    {
      v.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      GMTrace.o(4567026630656L, 34027);
      return null;
    }
    synchronized (hwA)
    {
      gxv = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id></enterprise_info></msgsource>", new Object[] { Integer.valueOf(1), paramc.field_bizChatServId, Integer.valueOf(paramc.field_chatVersion), localj.field_userId });
      v.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", new Object[] { gxv });
      paramc = gxv;
      GMTrace.o(4567026630656L, 34027);
      return paramc;
    }
  }
  
  public static c e(c paramc)
  {
    GMTrace.i(4567295066112L, 34029);
    if (paramc.field_bizChatServId == null)
    {
      GMTrace.o(4567295066112L, 34029);
      return null;
    }
    c localc2 = w.DJ().ir(paramc.field_bizChatServId);
    c localc1;
    if (localc2 != null)
    {
      if ((paramc.field_chatVersion <= localc2.field_chatVersion) && (!bf.mA(localc2.field_brandUserName))) {
        break label168;
      }
      if (!bf.mA(paramc.field_chatName)) {
        localc2.field_chatName = paramc.field_chatName;
      }
      localc2.field_brandUserName = paramc.field_brandUserName;
      localc2.field_needToUpdate = true;
      localc2.field_chatType = paramc.field_chatType;
      w.DJ().b(localc2);
      localc1 = localc2;
      if (localc1.DW())
      {
        if (!localc1.DV()) {
          break label173;
        }
        w.DN().W(localc1.field_bizChatServId, localc1.field_brandUserName);
      }
    }
    for (;;)
    {
      GMTrace.o(4567295066112L, 34029);
      return localc1;
      paramc.field_needToUpdate = true;
      localc1 = paramc;
      if (w.DJ().a(paramc)) {
        break;
      }
      label168:
      localc1 = localc2;
      break;
      label173:
      w.DN().X(localc1.field_bizChatServId, localc1.field_brandUserName);
    }
  }
  
  public static boolean f(c paramc)
  {
    GMTrace.i(4567429283840L, 34030);
    v.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
    if (paramc == null)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
      GMTrace.o(4567429283840L, 34030);
      return false;
    }
    Object localObject = paramc.DU();
    if (localObject == null)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
      GMTrace.o(4567429283840L, 34030);
      return false;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      j localj = w.DL().iE(str);
      if ((localj != null) && (localj.DW())) {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.size() > 0)
    {
      w.DN().b(localLinkedList, paramc.field_brandUserName);
      GMTrace.o(4567429283840L, 34030);
      return true;
    }
    v.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
    GMTrace.o(4567429283840L, 34030);
    return false;
  }
  
  public static void g(c paramc)
  {
    GMTrace.i(4568503025664L, 34038);
    if (paramc == null)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
      GMTrace.o(4568503025664L, 34038);
      return;
    }
    boolean bool1 = w.DK().X(paramc.field_bizChatLocalId);
    boolean bool2 = paramc.fu(16);
    v.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramc.field_chatName });
    if ((bool2) && (!bool1))
    {
      w.DK().Y(paramc.field_bizChatLocalId);
      GMTrace.o(4568503025664L, 34038);
      return;
    }
    if ((!bool2) && (bool1)) {
      w.DK().Z(paramc.field_bizChatLocalId);
    }
    GMTrace.o(4568503025664L, 34038);
  }
  
  public static void h(c paramc)
  {
    GMTrace.i(4568637243392L, 34039);
    if (paramc == null)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
      GMTrace.o(4568637243392L, 34039);
      return;
    }
    com.tencent.mm.storage.ae localae = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl(paramc.field_brandUserName);
    if (localae == null)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
      GMTrace.o(4568637243392L, 34039);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ag(paramc.field_brandUserName);
    Object localObject2 = ((n)com.tencent.mm.kernel.h.h(n.class)).wU().ac(paramc.field_brandUserName, paramc.field_bizChatLocalId);
    if ((localObject1 != null) && (localObject2 != null) && (((ce)localObject1).field_msgId == ((ce)localObject2).field_msgId))
    {
      localObject2 = localae.field_digest;
      if (localObject2 != null)
      {
        int i = ((String)localObject2).indexOf(":");
        if (i != -1)
        {
          localObject1 = ((String)localObject2).substring(0, i);
          localObject2 = ((String)localObject2).substring(i + 1);
          if ((localObject1 != null) && (!((String)localObject1).equals(paramc.field_chatName)))
          {
            localae.cu(paramc.field_chatName + ":" + (String)localObject2);
            ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().a(localae, localae.field_username);
          }
        }
      }
    }
    GMTrace.o(4568637243392L, 34039);
  }
  
  public static String iA(String paramString)
  {
    GMTrace.i(4568100372480L, 34035);
    String str = paramString;
    if (bf.mA(paramString)) {
      str = "tempConv";
    }
    paramString = new StringBuilder(com.tencent.mm.plugin.n.b.xc());
    paramString.append(com.tencent.mm.a.g.n(str.getBytes())).append("/");
    paramString.append("conv/");
    paramString = paramString.toString();
    GMTrace.o(4568100372480L, 34035);
    return paramString;
  }
  
  public static String iB(String paramString)
  {
    GMTrace.i(4568234590208L, 34036);
    String str = paramString;
    if (bf.mA(paramString)) {
      str = "tempUser";
    }
    paramString = new StringBuilder(com.tencent.mm.plugin.n.b.xc());
    paramString.append(com.tencent.mm.a.g.n(str.getBytes())).append("/");
    paramString.append("user/");
    paramString = paramString.toString();
    GMTrace.o(4568234590208L, 34036);
    return paramString;
  }
  
  public static boolean is(String paramString)
  {
    GMTrace.i(4565281800192L, 34014);
    if (paramString == null)
    {
      GMTrace.o(4565281800192L, 34014);
      return false;
    }
    if ((paramString.endsWith("@qy_u")) || (paramString.endsWith("@qy_g")))
    {
      GMTrace.o(4565281800192L, 34014);
      return true;
    }
    GMTrace.o(4565281800192L, 34014);
    return false;
  }
  
  public static boolean it(String paramString)
  {
    GMTrace.i(4565416017920L, 34015);
    if (paramString == null)
    {
      v.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
      GMTrace.o(4565416017920L, 34015);
      return false;
    }
    boolean bool = paramString.endsWith("@qy_g");
    GMTrace.o(4565416017920L, 34015);
    return bool;
  }
  
  public static String iu(String paramString)
  {
    GMTrace.i(4565952888832L, 34019);
    if (paramString == null)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
      GMTrace.o(4565952888832L, 34019);
      return null;
    }
    paramString = w.DL().iE(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_userName;
      GMTrace.o(4565952888832L, 34019);
      return paramString;
    }
    v.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
    GMTrace.o(4565952888832L, 34019);
    return null;
  }
  
  public static String iv(String paramString)
  {
    GMTrace.i(4566221324288L, 34021);
    paramString = w.DL().iE(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      GMTrace.o(4566221324288L, 34021);
      return paramString;
    }
    GMTrace.o(4566221324288L, 34021);
    return null;
  }
  
  public static j iw(String paramString)
  {
    GMTrace.i(4566623977472L, 34024);
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
      GMTrace.o(4566623977472L, 34024);
      return null;
    }
    paramString = w.DM().iC(paramString);
    if (paramString == null)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
      GMTrace.o(4566623977472L, 34024);
      return null;
    }
    paramString = w.DL().iE(paramString.field_userId);
    if (paramString == null) {
      v.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
    }
    GMTrace.o(4566623977472L, 34024);
    return paramString;
  }
  
  public static String ix(String paramString)
  {
    GMTrace.i(4566758195200L, 34025);
    if (paramString == null)
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
      GMTrace.o(4566758195200L, 34025);
      return null;
    }
    int i = paramString.indexOf("<enterprise_info>") + 17;
    int j = paramString.indexOf("</enterprise_info>");
    if ((i == -1) || (j == -1) || (i >= j))
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      GMTrace.o(4566758195200L, 34025);
      return null;
    }
    String str = paramString.substring(i, j);
    paramString = paramString.replace(str, str.replace("<", "&lt;").replace(">", "&gt;"));
    GMTrace.o(4566758195200L, 34025);
    return paramString;
  }
  
  public static void iy(String paramString)
  {
    GMTrace.i(4567160848384L, 34028);
    synchronized (hwA)
    {
      gxv = paramString;
      GMTrace.o(4567160848384L, 34028);
      return;
    }
  }
  
  public static long iz(String paramString)
  {
    GMTrace.i(4567697719296L, 34032);
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
      GMTrace.o(4567697719296L, 34032);
      return -1L;
    }
    paramString = w.DJ().ir(paramString);
    if (paramString != null)
    {
      long l = paramString.field_bizChatLocalId;
      GMTrace.o(4567697719296L, 34032);
      return l;
    }
    v.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
    GMTrace.o(4567697719296L, 34032);
    return -1L;
  }
  
  public static void l(final String paramString1, String paramString2, final String paramString3)
  {
    GMTrace.i(4567966154752L, 34034);
    v.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(4582998540288L, 34146);
        c localc = w.DJ().ir(this.hwE);
        if (localc == null)
        {
          GMTrace.o(4582998540288L, 34146);
          return;
        }
        if (localc.field_chatVersion < bf.getInt(paramString3, Integer.MAX_VALUE))
        {
          localc.field_needToUpdate = true;
          w.DJ().b(localc);
        }
        if (localc.DV())
        {
          w.DN().W(localc.field_bizChatServId, paramString1);
          GMTrace.o(4582998540288L, 34146);
          return;
        }
        w.DN().X(localc.field_bizChatServId, paramString1);
        GMTrace.o(4582998540288L, 34146);
      }
    });
    GMTrace.o(4567966154752L, 34034);
  }
  
  public static void u(String paramString, final boolean paramBoolean)
  {
    GMTrace.i(4567831937024L, 34033);
    if (bf.mA(paramString))
    {
      v.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
      GMTrace.o(4567831937024L, 34033);
      return;
    }
    v.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(4564342276096L, 34007);
        Object localObject1 = w.DK();
        Object localObject2 = this.hwB;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("delete from BizChatConversation");
        ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
        localObject3 = ((StringBuilder)localObject3).toString();
        boolean bool = ((b)localObject1).gUp.eE("BizChatConversation", (String)localObject3);
        v.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
        Object localObject4;
        if (bool)
        {
          localObject3 = new a();
          localObject4 = new b.a.b();
          ((b.a.b)localObject4).hwo = -1L;
          ((b.a.b)localObject4).fGj = ((String)localObject2);
          ((b.a.b)localObject4).hwn = b.a.a.hwk;
          ((b.a.b)localObject4).hwp = ((a)localObject3);
          ((b)localObject1).htP.by(localObject4);
          ((b)localObject1).htP.doNotify();
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rk(this.hwB);
        localObject1 = w.DJ();
        localObject2 = this.hwB;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("delete from BizChatInfo");
        ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
        localObject3 = ((StringBuilder)localObject3).toString();
        bool = ((d)localObject1).gUp.eE("BizChatInfo", (String)localObject3);
        v.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
        if (bool)
        {
          localObject3 = new c();
          localObject4 = new d.a.b();
          ((d.a.b)localObject4).hwo = -1L;
          ((d.a.b)localObject4).fGj = ((String)localObject2);
          ((d.a.b)localObject4).hwy = d.a.a.hwv;
          ((d.a.b)localObject4).hwz = ((c)localObject3);
          ((d)localObject1).htP.by(localObject4);
          ((d)localObject1).htP.doNotify();
        }
        com.tencent.mm.a.e.d(new File(e.iA(this.hwB)));
        if (paramBoolean)
        {
          localObject1 = w.DL();
          localObject2 = this.hwB;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("delete from BizChatUserInfo");
          ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
          localObject2 = ((StringBuilder)localObject3).toString();
          bool = ((k)localObject1).gUp.eE("BizChatUserInfo", (String)localObject2);
          v.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject2, Boolean.valueOf(bool) });
          if (bool)
          {
            localObject2 = new j();
            localObject3 = new k.a.b();
            ((k.a.b)localObject3).hxa = k.a.a.hwX;
            ((k.a.b)localObject3).hxb = ((j)localObject2);
            ((k)localObject1).htP.by(localObject3);
            ((k)localObject1).htP.doNotify();
          }
          w.DM().iD(this.hwB);
          com.tencent.mm.a.e.d(new File(e.iB(this.hwB)));
        }
        com.tencent.mm.sdk.platformtools.ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(4556960301056L, 33952);
            if (e.1.this.hkT != null) {
              e.1.this.hkT.zr();
            }
            GMTrace.o(4556960301056L, 33952);
          }
        });
        GMTrace.o(4564342276096L, 34007);
      }
      
      public final String toString()
      {
        GMTrace.i(4564476493824L, 34008);
        String str = super.toString() + "|deleteMsgByTalkers";
        GMTrace.o(4564476493824L, 34008);
        return str;
      }
    });
    GMTrace.o(4567831937024L, 34033);
  }
  
  public static String zz()
  {
    GMTrace.i(4566892412928L, 34026);
    synchronized (hwA)
    {
      String str = gxv;
      GMTrace.o(4566892412928L, 34026);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */