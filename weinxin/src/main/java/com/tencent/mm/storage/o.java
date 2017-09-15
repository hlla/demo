package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.a.a;
import com.tencent.mm.modelbiz.a.b;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.a.k;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ay.b;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class o
  extends e
{
  public static final String[] gUn;
  
  static
  {
    GMTrace.i(1584440279040L, 11805);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )" };
    GMTrace.o(1584440279040L, 11805);
  }
  
  public o(com.tencent.mm.plugin.messenger.foundation.a.a.c paramc)
  {
    super(paramc);
    GMTrace.i(1581755924480L, 11785);
    a(aJS(), "bizchatmessage");
    a(new c.b(16, "bizchatmessage", c.b.a(2500001L, 3000000L, 99000001L, 102000000L)));
    GMTrace.o(1581755924480L, 11785);
  }
  
  private static String ey(long paramLong)
  {
    GMTrace.i(1582024359936L, 11787);
    String str = " bizChatId= " + paramLong + " ";
    GMTrace.o(1582024359936L, 11787);
    return str;
  }
  
  public final String QD(String paramString)
  {
    GMTrace.i(1581890142208L, 11786);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!com.tencent.mm.modelbiz.e.dr(paramString)) {
        break;
      }
      GMTrace.o(1581890142208L, 11786);
      return "bizchatmessage";
    }
    GMTrace.o(1581890142208L, 11786);
    return null;
  }
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    GMTrace.i(15218008653824L, 113383);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      GMTrace.o(15218008653824L, 113383);
      return null;
    }
    paramString = Az(paramString);
    paramString = "select * from " + paramString + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ey(paramLong1) + "AND " + this.uxe.aKa() + " AND createTime >= " + paramLong2 + " AND createTime< " + paramLong3 + " order by createTime ASC";
    paramString = aJS().a(paramString, null, 0);
    GMTrace.o(15218008653824L, 113383);
    return paramString;
  }
  
  protected final boolean a(au paramau, ay.b paramb)
  {
    GMTrace.i(1582427013120L, 11790);
    if (paramau == null)
    {
      v.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
      GMTrace.o(1582427013120L, 11790);
      return false;
    }
    paramau.A(-1L);
    if (paramb != null)
    {
      if (!com.tencent.mm.modelbiz.e.dr(paramau.field_talker)) {
        break label356;
      }
      if (bf.mA(paramb.hmB))
      {
        v.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", new Object[] { paramau.gxv });
        GMTrace.o(1582427013120L, 11790);
        return false;
      }
      localObject = new com.tencent.mm.modelbiz.a.c();
      ((com.tencent.mm.modelbiz.a.c)localObject).field_bizChatServId = paramb.hmB;
      ((com.tencent.mm.modelbiz.a.c)localObject).field_brandUserName = paramau.field_talker;
      if (!bf.mA(paramb.hmC)) {
        ((com.tencent.mm.modelbiz.a.c)localObject).field_chatVersion = bf.getInt(paramb.hmC, -1);
      }
      if (!bf.mA(paramb.hmA)) {
        ((com.tencent.mm.modelbiz.a.c)localObject).field_chatType = bf.getInt(paramb.hmA, -1);
      }
      v.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", new Object[] { paramb.hmB, paramb.userId });
      localObject = com.tencent.mm.modelbiz.a.e.e((com.tencent.mm.modelbiz.a.c)localObject);
      if (localObject == null) {
        break label337;
      }
      paramau.A(((com.tencent.mm.modelbiz.a.c)localObject).field_bizChatLocalId);
      paramau.field_bizChatUserId = bf.mz(paramb.userId);
      paramau.gxj = true;
      if (paramb.hmE.equals("1")) {
        paramau.dw(1);
      }
      if ((paramau.field_isSend != 1) && (paramb.userId != null))
      {
        localObject = w.DL().iG(paramau.field_talker);
        if (paramb.userId.equals(localObject)) {
          paramau.dw(1);
        }
      }
      if (!bf.mA(paramb.userId))
      {
        localObject = new j();
        ((j)localObject).field_userId = paramb.userId;
        ((j)localObject).field_userName = paramb.hmD;
        ((j)localObject).field_brandUserName = paramau.field_talker;
        w.DL().c((j)localObject);
      }
    }
    label337:
    label356:
    while (bf.mA(paramb.hmB))
    {
      Object localObject;
      GMTrace.o(1582427013120L, 11790);
      return true;
      v.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
      GMTrace.o(1582427013120L, 11790);
      return false;
    }
    v.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
    GMTrace.o(1582427013120L, 11790);
    return false;
  }
  
  public final au ac(String paramString, long paramLong)
  {
    GMTrace.i(1582158577664L, 11788);
    if (bf.mA(paramString))
    {
      GMTrace.o(1582158577664L, 11788);
      return null;
    }
    au localau = new au();
    paramString = "select * from " + Az(paramString) + " where" + ey(paramLong) + "order by createTime DESC limit 1";
    paramString = aJS().a(paramString, null, 0);
    if (paramString.getCount() != 0)
    {
      paramString.moveToFirst();
      localau.b(paramString);
    }
    paramString.close();
    GMTrace.o(1582158577664L, 11788);
    return localau;
  }
  
  public final Cursor ad(String paramString, long paramLong)
  {
    GMTrace.i(1582695448576L, 11792);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      GMTrace.o(1582695448576L, 11792);
      return null;
    }
    paramString = Az(paramString);
    paramString = "select * from " + paramString + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ey(paramLong) + "AND " + this.uxe.aKb() + "  order by createTime";
    Cursor localCursor = aJS().a(paramString, null, 0);
    v.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    GMTrace.o(1582695448576L, 11792);
    return localCursor;
  }
  
  public final int ae(String paramString, long paramLong)
  {
    GMTrace.i(1582829666304L, 11793);
    v.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, ag.bJe() });
    eH(Az(paramString), ey(paramLong));
    int i = aJS().delete(Az(paramString), ey(paramLong), null);
    if (i != 0)
    {
      this.uxe.Qq("delete_talker " + paramString);
      paramString = new c.c(paramString, "delete", i);
      paramString.nxs = -1L;
      a(paramString);
    }
    GMTrace.o(1582829666304L, 11793);
    return i;
  }
  
  public final Cursor af(String paramString, long paramLong)
  {
    GMTrace.i(1582963884032L, 11794);
    paramString = aJS().query(Az(paramString), null, ey(paramLong), null, null, null, "createTime ASC ");
    GMTrace.o(1582963884032L, 11794);
    return paramString;
  }
  
  public final int ag(String paramString, long paramLong)
  {
    GMTrace.i(1583232319488L, 11796);
    if (paramString == null)
    {
      v.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", new Object[] { paramString, Long.valueOf(paramLong) });
      GMTrace.o(1583232319488L, 11796);
      return -1;
    }
    a locala = w.DK().U(paramLong);
    if (locala.field_msgCount != 0)
    {
      i = locala.field_msgCount;
      GMTrace.o(1583232319488L, 11796);
      return i;
    }
    v.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    int i = ah(paramString, paramLong);
    GMTrace.o(1583232319488L, 11796);
    return i;
  }
  
  public final int ah(String paramString, long paramLong)
  {
    int i = 0;
    GMTrace.i(1583366537216L, 11797);
    paramString = "SELECT COUNT(*) FROM " + Az(paramString) + " WHERE " + ey(paramLong);
    v.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", new Object[] { paramString });
    paramString = aJS().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    GMTrace.o(1583366537216L, 11797);
    return i;
  }
  
  public final int ai(String paramString, long paramLong)
  {
    int i = 0;
    GMTrace.i(1583500754944L, 11798);
    paramString = "SELECT COUNT(*) FROM " + this.uxe.Az(paramString) + " WHERE " + ey(paramLong) + "AND " + this.uxe.aKa();
    paramString = aJS().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    GMTrace.o(1583500754944L, 11798);
    return i;
  }
  
  public final long aj(String paramString, long paramLong)
  {
    GMTrace.i(1583769190400L, 11800);
    Object localObject = "select createTime from " + Az(paramString) + " where" + ey(paramLong) + "order by createTime DESC LIMIT 1 ";
    v.d("MicroMsg.BizChatMessageStorage", "get last message create time: " + (String)localObject);
    localObject = aJS().a((String)localObject, null, 0);
    if (localObject == null)
    {
      v.e("MicroMsg.BizChatMessageStorage", "get last message create time failed " + paramString);
      GMTrace.o(1583769190400L, 11800);
      return -1L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramLong = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      GMTrace.o(1583769190400L, 11800);
      return paramLong;
    }
    ((Cursor)localObject).close();
    GMTrace.o(1583769190400L, 11800);
    return -1L;
  }
  
  public final int b(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    GMTrace.i(1583903408128L, 11801);
    long l;
    if (paramLong3 < paramLong2)
    {
      l = paramLong3;
      paramLong3 = paramLong2;
    }
    for (;;)
    {
      v.d("MicroMsg.BizChatMessageStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[] { paramString, Long.valueOf(l), Long.valueOf(paramLong3) });
      paramString = "SELECT COUNT(msgId) FROM " + Az(paramString) + " WHERE" + ey(paramLong1) + "AND createTime >= " + l + " AND createTime <= " + paramLong3;
      v.d("MicroMsg.BizChatMessageStorage", "get count sql: " + paramString);
      paramString = aJS().a(paramString, null, 0);
      if (paramString == null)
      {
        v.w("MicroMsg.BizChatMessageStorage", "get count error, cursor is null");
        GMTrace.o(1583903408128L, 11801);
        return 0;
      }
      if (paramString.moveToFirst())
      {
        int i = paramString.getInt(0);
        v.d("MicroMsg.BizChatMessageStorage", "result msg count %d", new Object[] { Integer.valueOf(i) });
        paramString.close();
        GMTrace.o(1583903408128L, 11801);
        return i;
      }
      paramString.close();
      GMTrace.o(1583903408128L, 11801);
      return 0;
      l = paramLong2;
    }
  }
  
  public final Cursor b(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    GMTrace.i(15217874436096L, 113382);
    System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
      GMTrace.o(15217874436096L, 113382);
      return null;
    }
    paramString = Az(paramString);
    paramString = "select * from ( select * from " + paramString + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ey(paramLong) + "AND " + this.uxe.aKa() + " order by createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = aJS().a(paramString, null, 0);
    GMTrace.o(15217874436096L, 113382);
    return paramString;
  }
  
  public final List<au> b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    GMTrace.i(1582561230848L, 11791);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
      GMTrace.o(1582561230848L, 11791);
      return null;
    }
    paramLong2 = this.uxe.D(paramString, paramLong2);
    if (paramLong2 == 0L)
    {
      v.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
      GMTrace.o(1582561230848L, 11791);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      paramString = "select * from " + Az(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ey(paramLong1) + "AND " + this.uxe.aKa() + " AND createTime > " + paramLong2 + "  order by createTime ASC limit 10";
      paramString = aJS().a(paramString, null, 0);
      if (!paramString.moveToFirst()) {}
    }
    else
    {
      for (;;)
      {
        if (paramString.isAfterLast()) {
          break label329;
        }
        au localau = new au();
        localau.b(paramString);
        paramString.moveToNext();
        if (paramBoolean)
        {
          localArrayList.add(localau);
          continue;
          paramString = "select * from " + Az(paramString) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + ey(paramLong1) + "AND " + this.uxe.aKa() + " AND createTime < " + paramLong2 + "  order by createTime DESC limit 10";
          break;
        }
        localArrayList.add(0, localau);
      }
    }
    label329:
    paramString.close();
    v.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    GMTrace.o(1582561230848L, 11791);
    return localArrayList;
  }
  
  public final Cursor c(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    GMTrace.i(1584037625856L, 11802);
    long l;
    if (paramLong3 < paramLong2)
    {
      l = paramLong3;
      paramLong3 = paramLong2;
    }
    for (;;)
    {
      paramString = "SELECT * FROM " + Az(paramString) + " WHERE" + ey(paramLong1) + "AND createTime >= " + l + " AND createTime <= " + paramLong3 + " ORDER BY createTime ASC ";
      v.d("MicroMsg.BizChatMessageStorage", "get cursor: " + paramString);
      paramString = aJS().a(paramString, null, 0);
      GMTrace.o(1584037625856L, 11802);
      return paramString;
      l = paramLong2;
    }
  }
  
  public final List<au> g(String paramString, long paramLong, int paramInt)
  {
    GMTrace.i(1582292795392L, 11789);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + Az(paramString) + " WHERE" + ey(paramLong) + "AND isSend = 0" + " ORDER BY createTime DESC LIMIT " + paramInt;
    paramString = aJS().a(paramString, null, 0);
    if (paramString.moveToFirst()) {
      while (!paramString.isAfterLast())
      {
        au localau = new au();
        localau.b(paramString);
        paramString.moveToNext();
        if (localau.bMa()) {
          localArrayList.add(localau);
        }
      }
    }
    paramString.close();
    GMTrace.o(1582292795392L, 11789);
    return localArrayList;
  }
  
  public final Cursor h(String paramString, long paramLong, int paramInt)
  {
    GMTrace.i(1583098101760L, 11795);
    String str = "SELECT * FROM ( SELECT * FROM " + Az(paramString) + " WHERE" + ey(paramLong) + "ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
    v.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), str });
    paramString = aJS().a(str, null, 0);
    GMTrace.o(1583098101760L, 11795);
    return paramString;
  }
  
  public final int m(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    GMTrace.i(1583634972672L, 11799);
    au localau = this.uxe.cA(paramLong2);
    if (localau.field_msgId == 0L)
    {
      v.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
      GMTrace.o(1583634972672L, 11799);
      return 0;
    }
    paramString = Az(paramString);
    paramString = "SELECT COUNT(*) FROM " + paramString + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + ey(paramLong1) + "AND " + this.uxe.aKa() + " AND createTime < " + localau.field_createTime;
    paramString = aJS().a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    GMTrace.o(1583634972672L, 11799);
    return i;
  }
  
  public final long n(String paramString, long paramLong1, long paramLong2)
  {
    GMTrace.i(1584171843584L, 11803);
    v.d("MicroMsg.BizChatMessageStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong2), Integer.valueOf(18) });
    paramString = "SELECT createTime FROM " + Az(paramString) + " WHERE" + ey(paramLong1) + "AND createTime < " + paramLong2 + " ORDER BY createTime DESC  LIMIT 18";
    v.d("MicroMsg.BizChatMessageStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = aJS().a(paramString, null, 0);
    if (paramString == null)
    {
      v.w("MicroMsg.BizChatMessageStorage", "get inc msg create time error, cursor is null");
      GMTrace.o(1584171843584L, 11803);
      return paramLong2;
    }
    if (paramString.moveToLast())
    {
      paramLong1 = paramString.getLong(0);
      v.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong1) });
      paramString.close();
      GMTrace.o(1584171843584L, 11803);
      return paramLong1;
    }
    paramString.close();
    v.w("MicroMsg.BizChatMessageStorage", "get result fail");
    GMTrace.o(1584171843584L, 11803);
    return paramLong2;
  }
  
  public final long o(String paramString, long paramLong1, long paramLong2)
  {
    GMTrace.i(1584306061312L, 11804);
    v.d("MicroMsg.BizChatMessageStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong2), Integer.valueOf(18) });
    paramString = "SELECT createTime FROM " + Az(paramString) + " WHERE" + ey(paramLong1) + "AND createTime > " + paramLong2 + " ORDER BY createTime ASC  LIMIT 18";
    v.d("MicroMsg.BizChatMessageStorage", "get down inc msg create time sql: %s", new Object[] { paramString });
    paramString = aJS().a(paramString, null, 0);
    if (paramString == null)
    {
      v.w("MicroMsg.BizChatMessageStorage", "get down inc msg create time error, cursor is null");
      GMTrace.o(1584306061312L, 11804);
      return paramLong2;
    }
    if (paramString.moveToLast())
    {
      paramLong1 = paramString.getLong(0);
      v.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong1) });
      paramString.close();
      GMTrace.o(1584306061312L, 11804);
      return paramLong1;
    }
    paramString.close();
    v.w("MicroMsg.BizChatMessageStorage", "get result fail");
    GMTrace.o(1584306061312L, 11804);
    return paramLong2;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */