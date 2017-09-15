package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import junit.framework.Assert;

public final class av
  extends com.tencent.mm.sdk.e.j
  implements com.tencent.mm.plugin.messenger.foundation.a.a.c
{
  public static final String[] gUn;
  private final g hnp;
  private final long uHy;
  private ar uIA;
  private final List<e> uIB;
  private List<c.b> uIC;
  private final f<Integer, au.c> uID;
  private final f<Integer, au.d> uIE;
  private final f<Integer, au.a> uIF;
  private final f<Integer, au.b> uIG;
  private final f<Integer, Object> uIH;
  private final f<String, Long> uII;
  private ah uIJ;
  private final k<c.a, c.c> uIK;
  private Map<String, c.c> uIL;
  private boolean uIM;
  private String uIN;
  private long uIO;
  private boolean uIy;
  private as uIz;
  
  static
  {
    GMTrace.i(13230109884416L, 98572);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId" + " INTEGER , type INT, status" + " INT, isSend INT, isShowTimer" + " INTEGER, createTime INTEGER, talker" + " TEXT, content TEXT, imgPath" + " TEXT, reserved TEXT, lvbuffer" + " BLOB, transContent TEXT,transBrandWording" + " TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId" + " TEXT, msgSeq INTEGER, flag" + " INT) " };
    GMTrace.o(13230109884416L, 98572);
  }
  
  public av(g paramg, ar paramar, as paramas)
  {
    GMTrace.i(13216553893888L, 98471);
    this.uIy = false;
    this.uIB = new CopyOnWriteArrayList();
    this.uID = new f(100);
    this.uIE = new f(100);
    this.uIF = new f(100);
    this.uIG = new f(100);
    this.uIH = new f(100);
    this.uII = new f(100);
    this.uIJ = new ah();
    this.uIK = new k() {};
    this.uIL = new HashMap();
    this.uIM = false;
    this.uIN = "";
    this.uIO = 0L;
    this.uHy = 86400L;
    this.hnp = paramg;
    this.uIA = paramar;
    this.uIz = paramas;
    h.vJ();
    if (((Integer)h.vI().vr().get(348169, Integer.valueOf(0))).intValue() == 0)
    {
      v.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", new Object[] { Integer.valueOf(this.hnp.delete("message", "msgId> ? ", new String[] { "80000000" })) });
      h.vJ();
      h.vI().vr().set(348169, Integer.valueOf(1));
    }
    a(paramg, "message");
    bMD();
    if (this.uIC == null) {
      this.uIC = new LinkedList();
    }
    this.uIC.clear();
    a(new c.b(1, "message", c.b.a(1L, 1000000L, 10000000L, 90000000L)));
    GMTrace.o(13216553893888L, 98471);
  }
  
  private String RI(String paramString)
  {
    GMTrace.i(13218164506624L, 98483);
    String str = Az(paramString);
    if ((this.uIy) && (str.equals("message")))
    {
      paramString = " talkerId=" + RJ(paramString) + " ";
      GMTrace.o(13218164506624L, 98483);
      return paramString;
    }
    paramString = " talker= '" + bf.my(paramString) + "' ";
    GMTrace.o(13218164506624L, 98483);
    return paramString;
  }
  
  private long RJ(String paramString)
  {
    GMTrace.i(13218298724352L, 98484);
    long l = this.uIA.Rc(paramString);
    if (l < 0L) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        x localx = new x(paramString);
        localx.setType(2);
        this.uIA.R(localx);
        l = this.uIA.Rc(paramString);
      }
      if (!b.bIm()) {
        v.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", new Object[] { paramString, Long.valueOf(l), Boolean.valueOf(bool), bf.bJP() });
      }
      GMTrace.o(13218298724352L, 98484);
      return l;
    }
  }
  
  private static String RK(String paramString)
  {
    GMTrace.i(13220580425728L, 98501);
    if (bf.mA(paramString))
    {
      GMTrace.o(13220580425728L, 98501);
      return null;
    }
    try
    {
      paramString = bg.q(paramString, "msgsource");
      if (paramString != null)
      {
        boolean bool = paramString.isEmpty();
        if (!bool) {}
      }
      else
      {
        GMTrace.o(13220580425728L, 98501);
        return null;
      }
      paramString = (String)paramString.get(".msgsource.bizmsg.msgcluster");
      GMTrace.o(13220580425728L, 98501);
      return paramString;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.MsgInfoStorage", "exception:%s", new Object[] { bf.g(paramString) });
      v.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", new Object[] { paramString.getMessage() });
      GMTrace.o(13220580425728L, 98501);
    }
    return null;
  }
  
  private String RL(String paramString)
  {
    GMTrace.i(13225680699392L, 98539);
    if ((paramString == null) || (!paramString.equals("message")))
    {
      GMTrace.o(13225680699392L, 98539);
      return "";
    }
    if (this.uIy)
    {
      GMTrace.o(13225680699392L, 98539);
      return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
    }
    GMTrace.o(13225680699392L, 98539);
    return "INDEXED BY messageCreateTaklerTypeTimeIndex";
  }
  
  private String RM(String paramString)
  {
    GMTrace.i(13227022876672L, 98549);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Iterator localIterator = this.uIB.iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = ((e)localIterator.next()).QD(paramString);
      } while (bf.mA(str));
      GMTrace.o(13227022876672L, 98549);
      return str;
    }
    GMTrace.o(13227022876672L, 98549);
    return "message";
  }
  
  private c.b RN(String paramString)
  {
    boolean bool2 = true;
    GMTrace.i(13227157094400L, 98550);
    boolean bool1;
    label52:
    int i;
    if ((paramString != null) && (paramString.length() > 0))
    {
      bool1 = true;
      Assert.assertTrue("username == null", bool1);
      paramString = RM(paramString);
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label127;
      }
      bool1 = bool2;
      Assert.assertTrue("tableName == null", bool1);
      i = 0;
    }
    for (;;)
    {
      if (i >= this.uIC.size()) {
        break label139;
      }
      if (paramString.equals(((c.b)this.uIC.get(i)).name))
      {
        paramString = (c.b)this.uIC.get(i);
        GMTrace.o(13227157094400L, 98550);
        return paramString;
        bool1 = false;
        break;
        label127:
        bool1 = false;
        break label52;
      }
      i += 1;
    }
    label139:
    Assert.assertTrue("no table match", false);
    GMTrace.o(13227157094400L, 98550);
    return null;
  }
  
  private static void Z(au paramau)
  {
    GMTrace.i(13220714643456L, 98502);
    if ((paramau == null) || (!paramau.axH()))
    {
      GMTrace.o(13220714643456L, 98502);
      return;
    }
    try
    {
      String str = paramau.field_content;
      int i = str.indexOf("<msg>");
      Object localObject = str;
      if (i > 0)
      {
        localObject = str;
        if (i < str.length()) {
          localObject = str.substring(i).trim();
        }
      }
      localObject = bg.q((String)localObject, "msg");
      if ((localObject != null) && (((Map)localObject).size() > 0)) {
        paramau.cJ(com.tencent.mm.sdk.platformtools.av.ae((Map)localObject));
      }
      GMTrace.o(13220714643456L, 98502);
      return;
    }
    catch (Exception paramau)
    {
      v.e("MicroMsg.MsgInfoStorage", paramau.getMessage());
      GMTrace.o(13220714643456L, 98502);
    }
  }
  
  private void b(c.b paramb)
  {
    GMTrace.i(13216956547072L, 98474);
    Cursor localCursor = this.hnp.a("select max(msgid) from " + paramb.name, null, 2);
    int i;
    if (localCursor.moveToFirst())
    {
      i = localCursor.getInt(0);
      v.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d", new Object[] { Integer.valueOf(i), Long.valueOf(paramb.hEO) });
      if (i >= paramb.hEO)
      {
        v.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", new Object[] { Long.valueOf(paramb.hEO), Integer.valueOf(i), Long.valueOf(paramb.nxj[0].nxm), Long.valueOf(paramb.nxj[1].nxl), bf.bJP() });
        if ((i <= paramb.nxj[0].nxm) || (i >= paramb.nxj[1].nxl)) {
          break label287;
        }
        v.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", new Object[] { Long.valueOf(paramb.nxj[1].nxl) });
        paramb.hEO = paramb.nxj[1].nxl;
        com.tencent.mm.plugin.report.c.oRz.a(111L, 169L, 1L, false);
      }
    }
    for (;;)
    {
      localCursor.close();
      v.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + paramb.hEO);
      GMTrace.o(13216956547072L, 98474);
      return;
      label287:
      paramb.hEO = i;
    }
  }
  
  private void bMD()
  {
    GMTrace.i(13216285458432L, 98469);
    long l1 = System.currentTimeMillis();
    long l2 = this.hnp.cs(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new String[13];
    arrayOfString[0] = ("CREATE INDEX IF NOT EXISTS " + "message" + "IdIndex ON message ( msgId" + " )");
    arrayOfString[1] = ("CREATE INDEX IF NOT EXISTS " + "message" + "SvrIdIndex ON message ( msgSvrId" + " )");
    arrayOfString[2] = ("CREATE INDEX IF NOT EXISTS " + "message" + "SendCreateTimeIndex ON message ( status" + ",isSend,createTime" + " )");
    arrayOfString[3] = ("CREATE INDEX IF NOT EXISTS " + "message" + "CreateTimeIndex ON message ( createTime" + " )");
    arrayOfString[4] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TaklerIdTypeCreateTimeIndex ON message ( talkerId" + ",type,createTime" + " )");
    arrayOfString[5] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdStatusIndex ON message ( talkerId" + ",status )");
    arrayOfString[6] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdCreateTimeIsSendIndex ON message ( talkerId" + ",isSend,createTime" + " )");
    arrayOfString[7] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdCreateTimeIndex ON message ( talkerId" + ",createTime )");
    arrayOfString[8] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdSvrIdIndex ON message ( talkerId" + ",msgSvrId )");
    arrayOfString[9] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdTypeIndex ON message ( talkerId" + ",type )");
    arrayOfString[10] = ("CREATE INDEX IF NOT EXISTS " + "message" + "TalkerTypeIndex ON message ( talker" + ",type )");
    arrayOfString[11] = ("CREATE INDEX IF NOT EXISTS " + "message" + "messageTalkerMsgSeqIndex ON message ( talker" + ",msgSeq )");
    arrayOfString[12] = ("CREATE INDEX IF NOT EXISTS " + "message" + "messageTalkerFlagMsgSeqIndex ON message ( talker" + ",flag,msgSeq" + " )");
    if (!this.uIy)
    {
      arrayOfString[4] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTypeTimeIndex ON message ( talker,type,createTime )";
      arrayOfString[5] = "CREATE INDEX IF NOT EXISTS  messageTalkerStatusIndex ON message ( talker,status )";
      arrayOfString[6] = "CREATE INDEX IF NOT EXISTS  messageTalkerCreateTimeIsSendIndex ON message ( talker,isSend,createTime )";
      arrayOfString[7] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTimeIndex ON message ( talker,createTime )";
      arrayOfString[8] = "CREATE INDEX IF NOT EXISTS  messageTalkerSvrIdIndex ON message ( talker,msgSvrId )";
    }
    localArrayList.addAll(Arrays.asList(arrayOfString));
    int i = 0;
    while (i < localArrayList.size())
    {
      this.hnp.eE("message", (String)localArrayList.get(i));
      i += 1;
    }
    v.i("MicroMsg.MsgInfoStorage", "build new index last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    this.hnp.aD(l2);
    v.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    GMTrace.o(13216285458432L, 98469);
  }
  
  private String eC(long paramLong)
  {
    GMTrace.i(13227425529856L, 98552);
    if ((paramLong == 0L) || (paramLong == -1L))
    {
      GMTrace.o(13227425529856L, 98552);
      return null;
    }
    au.eB(paramLong);
    int i = 0;
    while (i < this.uIC.size())
    {
      if (((c.b)this.uIC.get(i)).cF(paramLong))
      {
        String str = ((c.b)this.uIC.get(i)).name;
        GMTrace.o(13227425529856L, 98552);
        return str;
      }
      i += 1;
    }
    Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[] { Long.valueOf(paramLong) }), false);
    GMTrace.o(13227425529856L, 98552);
    return null;
  }
  
  public final List<au> A(String paramString, long paramLong)
  {
    GMTrace.i(13217896071168L, 98481);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + Az(paramString) + " Where " + RI(paramString) + " AND createTime < ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 11";
    paramString = this.hnp.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      au localau = new au();
      localau.b(paramString);
      localArrayList.add(localau);
    }
    paramString.close();
    GMTrace.o(13217896071168L, 98481);
    return localArrayList;
  }
  
  public final long AA(String paramString)
  {
    GMTrace.i(13227559747584L, 98553);
    Object localObject = "select createTime from message where" + RI(paramString) + "order by createTime LIMIT 1 OFFSET 0";
    v.d("MicroMsg.MsgInfoStorage", "get first message create time: " + (String)localObject);
    localObject = this.hnp.a((String)localObject, null, 2);
    if (localObject == null)
    {
      v.e("MicroMsg.MsgInfoStorage", "get first message create time failed: " + paramString);
      GMTrace.o(13227559747584L, 98553);
      return -1L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      GMTrace.o(13227559747584L, 98553);
      return l;
    }
    ((Cursor)localObject).close();
    GMTrace.o(13227559747584L, 98553);
    return -1L;
  }
  
  public final long AB(String paramString)
  {
    GMTrace.i(13227693965312L, 98554);
    Object localObject = "select createTime from message where" + RI(paramString) + "order by createTime DESC LIMIT 1 ";
    v.d("MicroMsg.MsgInfoStorage", "get last message create time: " + (String)localObject);
    localObject = this.hnp.a((String)localObject, null, 2);
    if (localObject == null)
    {
      v.e("MicroMsg.MsgInfoStorage", "get last message create time failed " + paramString);
      GMTrace.o(13227693965312L, 98554);
      return -1L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      GMTrace.o(13227693965312L, 98554);
      return l;
    }
    ((Cursor)localObject).close();
    GMTrace.o(13227693965312L, 98554);
    return -1L;
  }
  
  public final long AC(String paramString)
  {
    GMTrace.i(13227828183040L, 98555);
    if (bf.mA(paramString))
    {
      GMTrace.o(13227828183040L, 98555);
      return 0L;
    }
    Object localObject = "select msgSeq from message where" + RI(paramString) + "order by msgSeq DESC LIMIT 1 ";
    v.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: " + (String)localObject);
    localObject = this.hnp.a((String)localObject, null, 2);
    if (localObject == null)
    {
      v.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed " + paramString);
      GMTrace.o(13227828183040L, 98555);
      return 0L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      GMTrace.o(13227828183040L, 98555);
      return l;
    }
    ((Cursor)localObject).close();
    GMTrace.o(13227828183040L, 98555);
    return 0L;
  }
  
  public final au AD(String paramString)
  {
    GMTrace.i(13228096618496L, 98557);
    if (bf.mA(paramString))
    {
      GMTrace.o(13228096618496L, 98557);
      return null;
    }
    v.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", new Object[] { paramString, Boolean.valueOf(false) });
    Object localObject1 = (Long)this.uII.get(paramString);
    if ((localObject1 != null) && (((Long)localObject1).longValue() > 0L))
    {
      v.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", new Object[] { Long.valueOf(((Long)localObject1).longValue()) });
      localObject1 = cA(((Long)localObject1).longValue());
      if ((((ce)localObject1).field_flag & 0x1) != 0)
      {
        GMTrace.o(13228096618496L, 98557);
        return (au)localObject1;
      }
      this.uII.remove(paramString);
      GMTrace.o(13228096618496L, 98557);
      return null;
    }
    v.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
    localObject1 = new au();
    long l = System.currentTimeMillis();
    Object localObject2 = "SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND flag %2 = 1  ORDER BY msgSeq" + " DESC LIMIT 1 ";
    localObject2 = this.hnp.a((String)localObject2, null, 2);
    v.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Long.valueOf(Thread.currentThread().getId()) });
    if (localObject2 == null)
    {
      v.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed " + paramString);
      GMTrace.o(13228096618496L, 98557);
      return (au)localObject1;
    }
    if (((Cursor)localObject2).moveToFirst()) {
      ((au)localObject1).b((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    this.uII.k(paramString, Long.valueOf(((ce)localObject1).field_msgId));
    GMTrace.o(13228096618496L, 98557);
    return (au)localObject1;
  }
  
  public final int AE(String paramString)
  {
    GMTrace.i(13229170360320L, 98565);
    String str = " SELECT COUNT(*) FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND isSend=1";
    Cursor localCursor = this.hnp.a(str, null, 2);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          break label161;
        }
        i = localCursor.getInt(0);
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
      }
      v.d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", new Object[] { paramString, Integer.valueOf(i), str });
      GMTrace.o(13229170360320L, 98565);
      return i;
      label161:
      int i = 0;
    }
  }
  
  public final void Ac(String paramString)
  {
    GMTrace.i(13215748587520L, 98465);
    v.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.uIM), Integer.valueOf(this.uvv.uvy), Integer.valueOf(this.uIK.uvy), Integer.valueOf(this.uIL.size()), this.uIN, Long.valueOf(bf.aA(this.uIO)) });
    if (bf.mA(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (this.uIM)
    {
      v.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", new Object[] { this.uIN, Long.valueOf(bf.aA(this.uIO)) });
      GMTrace.o(13215748587520L, 98465);
      return;
    }
    this.uIN = paramString;
    this.uIO = bf.NA();
    this.uIM = true;
    super.lock();
    this.uIK.lock();
    GMTrace.o(13215748587520L, 98465);
  }
  
  public final void Ad(String paramString)
  {
    GMTrace.i(13215882805248L, 98466);
    v.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", new Object[] { paramString, Boolean.valueOf(this.uIM), Integer.valueOf(this.uvv.uvy), Integer.valueOf(this.uIK.uvy), Integer.valueOf(this.uIL.size()), this.uIN, Long.valueOf(bf.aA(this.uIO)) });
    if (bf.mA(paramString)) {
      Assert.assertTrue("lockForSync, do not call me by null tag.", false);
    }
    if (!this.uIM)
    {
      v.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", new Object[] { paramString, bf.bJP() });
      GMTrace.o(13215882805248L, 98466);
      return;
    }
    if (!paramString.equals(this.uIN))
    {
      v.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", new Object[] { this.uIN, Long.valueOf(bf.aA(this.uIO)), paramString });
      GMTrace.o(13215882805248L, 98466);
      return;
    }
    this.uIM = false;
    this.uIO = 0L;
    this.uIN = "";
    paramString = this.uIL.keySet().iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      a((c.c)this.uIL.get(str));
    }
    this.uIL.clear();
    super.unlock();
    this.uIK.unlock();
    doNotify();
    GMTrace.o(13215882805248L, 98466);
  }
  
  public final Cursor Ae(String paramString)
  {
    GMTrace.i(13217761853440L, 98480);
    g localg = this.hnp;
    String str = Az(paramString);
    paramString = RI(paramString);
    paramString = localg.query(str, new String[] { "createTime", "msgId" }, paramString, null, "createTime", null, "createTime ASC");
    GMTrace.o(13217761853440L, 98480);
    return paramString;
  }
  
  public final au Af(String paramString)
  {
    GMTrace.i(13218969812992L, 98489);
    au localau = new au();
    paramString = this.hnp.a(Az(paramString), null, RI(paramString), null, null, null, "msgSvrId  DESC limit 1 ", 2);
    if (paramString.moveToFirst()) {
      localau.b(paramString);
    }
    paramString.close();
    GMTrace.o(13218969812992L, 98489);
    return localau;
  }
  
  public final au Ag(String paramString)
  {
    GMTrace.i(13219104030720L, 98490);
    if (bf.mA(paramString))
    {
      GMTrace.o(13219104030720L, 98490);
      return null;
    }
    au localau = new au();
    paramString = "select * from " + Az(paramString) + " where" + RI(paramString) + "order by createTime DESC limit 1";
    paramString = this.hnp.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localau.b(paramString);
    }
    paramString.close();
    GMTrace.o(13219104030720L, 98490);
    return localau;
  }
  
  public final au Ah(String paramString)
  {
    GMTrace.i(13219372466176L, 98492);
    if (bf.mA(paramString))
    {
      GMTrace.o(13219372466176L, 98492);
      return null;
    }
    au localau = new au();
    paramString = "select * from " + Az(paramString) + " where" + RI(paramString) + "and isSend = 0" + "  order by createTime DESC limit 1";
    paramString = this.hnp.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      localau.b(paramString);
    }
    paramString.close();
    GMTrace.o(13219372466176L, 98492);
    return localau;
  }
  
  public final au Ai(String paramString)
  {
    GMTrace.i(17856594968576L, 133042);
    if (this.uIC == null)
    {
      v.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      GMTrace.o(17856594968576L, 133042);
      return null;
    }
    au localau = new au();
    if (bf.mA(paramString)) {}
    for (paramString = "";; paramString = paramString.replaceFirst("and", "where"))
    {
      long l1 = 0L;
      int i = 0;
      while (i < this.uIC.size())
      {
        long l2 = l1;
        if ((((c.b)this.uIC.get(i)).nxk & 0x8) != 0)
        {
          Object localObject = "select * from " + ((c.b)this.uIC.get(i)).name + paramString + "  order by createTime DESC limit 1";
          localObject = this.hnp.a((String)localObject, null, 2);
          l2 = l1;
          if (((Cursor)localObject).moveToFirst())
          {
            long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
            l2 = l1;
            if (l1 < l3)
            {
              localau.b((Cursor)localObject);
              l2 = l3;
            }
          }
          ((Cursor)localObject).close();
        }
        i += 1;
        l1 = l2;
      }
    }
    GMTrace.o(17856594968576L, 133042);
    return localau;
  }
  
  public final List<au> Aj(String paramString)
  {
    au localau = null;
    GMTrace.i(13221117296640L, 98505);
    Cursor localCursor = this.hnp.a("select * from " + paramString, null, 2);
    if (localCursor == null)
    {
      GMTrace.o(13221117296640L, 98505);
      return null;
    }
    paramString = localau;
    if (localCursor.moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        localau = new au();
        localau.b(localCursor);
        paramString.add(localau);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    GMTrace.o(13221117296640L, 98505);
    return paramString;
  }
  
  public final Cursor Ak(String paramString)
  {
    GMTrace.i(13221519949824L, 98508);
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      GMTrace.o(13221519949824L, 98508);
      return null;
    }
    Object localObject = Az(paramString);
    paramString = "select * from " + (String)localObject + " " + RL((String)localObject) + " where" + RI(paramString) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by " + "createTime";
    localObject = this.hnp.a(paramString, null, 0);
    v.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
    GMTrace.o(13221519949824L, 98508);
    return (Cursor)localObject;
  }
  
  public final void Al(String paramString)
  {
    GMTrace.i(13221922603008L, 98511);
    b(paramString, "", null);
    if (this.hnp.eE(paramString, "delete from " + paramString))
    {
      Qq("delete_all " + paramString);
      GMTrace.o(13221922603008L, 98511);
      return;
    }
    com.tencent.mm.plugin.report.c.oRz.a(111L, 247L, 1L, false);
    GMTrace.o(13221922603008L, 98511);
  }
  
  public final int Am(String paramString)
  {
    GMTrace.i(13222191038464L, 98513);
    v.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", new Object[] { paramString, ag.bJe() });
    b(Az(paramString), RI(paramString), null);
    int i = this.hnp.delete(Az(paramString), RI(paramString), null);
    if (i != 0)
    {
      Qq("delete_talker " + paramString);
      paramString = new c.c(paramString, "delete", i);
      paramString.nxs = -1L;
      a(paramString);
    }
    GMTrace.o(13222191038464L, 98513);
    return i;
  }
  
  public final boolean An(String paramString)
  {
    GMTrace.i(13222593691648L, 98516);
    v.w("MicroMsg.MsgInfoStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[] { paramString, ag.bJe() });
    b(Az(paramString), " talker like '%" + paramString + "'", null);
    boolean bool = this.hnp.eE(Az(paramString), "delete from " + Az(paramString) + " where talker like '%" + paramString + "'");
    if (bool) {
      doNotify();
    }
    GMTrace.o(13222593691648L, 98516);
    return bool;
  }
  
  public final int Ao(String paramString)
  {
    GMTrace.i(13223264780288L, 98521);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(4));
    int i = this.hnp.update(Az(paramString), localContentValues, RI(paramString) + "AND isSend=? AND status" + "!=? ", new String[] { paramString, "0", "4" });
    if (i != 0)
    {
      doNotify();
      a(new c.c(paramString, "update", null));
    }
    GMTrace.o(13223264780288L, 98521);
    return i;
  }
  
  public final Cursor Ap(String paramString)
  {
    GMTrace.i(13223533215744L, 98523);
    paramString = this.hnp.query(Az(paramString), null, RI(paramString), null, null, null, "createTime ASC ");
    GMTrace.o(13223533215744L, 98523);
    return paramString;
  }
  
  public final Cursor Aq(String paramString)
  {
    GMTrace.i(13224204304384L, 98528);
    paramString = this.hnp.query(Az(paramString), null, "isSend=? AND" + RI(paramString) + "AND status!=?", new String[] { "0", "4" }, null, null, null);
    GMTrace.o(13224204304384L, 98528);
    return paramString;
  }
  
  public final au.c Ar(String paramString)
  {
    GMTrace.i(13224606957568L, 98531);
    au.c localc2 = (au.c)this.uID.get(Integer.valueOf(paramString.hashCode()));
    au.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = au.c.RG(paramString);
      this.uID.k(Integer.valueOf(paramString.hashCode()), localc1);
    }
    GMTrace.o(13224606957568L, 98531);
    return localc1;
  }
  
  public final au.d As(String paramString)
  {
    GMTrace.i(13224741175296L, 98532);
    au.d locald2 = (au.d)this.uIE.get(Integer.valueOf(paramString.hashCode()));
    au.d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = au.d.RH(paramString);
      this.uIE.k(Integer.valueOf(paramString.hashCode()), locald1);
    }
    GMTrace.o(13224741175296L, 98532);
    return locald1;
  }
  
  public final au.a At(String paramString)
  {
    GMTrace.i(13224875393024L, 98533);
    au.a locala1 = null;
    if ((!bf.mA(paramString)) && (this.uIF != null)) {
      locala1 = (au.a)this.uIF.get(Integer.valueOf(paramString.hashCode()));
    }
    for (;;)
    {
      au.a locala2 = locala1;
      if (locala1 == null)
      {
        locala1 = au.a.RE(paramString);
        locala2 = locala1;
        if (this.uIF != null)
        {
          this.uIF.k(Integer.valueOf(bf.ap(paramString, "").hashCode()), locala1);
          locala2 = locala1;
        }
      }
      GMTrace.o(13224875393024L, 98533);
      return locala2;
      v.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", new Object[] { Boolean.valueOf(bf.mA(paramString)) });
      v.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
    }
  }
  
  public final au.b Au(String paramString)
  {
    GMTrace.i(13225009610752L, 98534);
    au.b localb2 = (au.b)this.uIG.get(Integer.valueOf(paramString.hashCode()));
    au.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = au.b.RF(paramString);
      this.uIG.k(Integer.valueOf(paramString.hashCode()), localb1);
    }
    GMTrace.o(13225009610752L, 98534);
    return localb1;
  }
  
  public final int Av(String paramString)
  {
    int i = 0;
    GMTrace.i(13225278046208L, 98536);
    if (Aw(paramString))
    {
      i = this.uIz.RB(paramString);
      if (i > 0)
      {
        v.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", new Object[] { Integer.valueOf(i) });
        GMTrace.o(13225278046208L, 98536);
        return i;
      }
      v.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", new Object[] { paramString });
    }
    while (!"appbrandmessage".equals(Az(paramString)))
    {
      i = Ax(paramString);
      GMTrace.o(13225278046208L, 98536);
      return i;
    }
    paramString = "SELECT COUNT(*) FROM " + Az(paramString) + " WHERE" + RI(paramString);
    paramString = this.hnp.a(paramString, null, 0);
    if (paramString.moveToLast()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    GMTrace.o(13225278046208L, 98536);
    return i;
  }
  
  public final boolean Aw(String paramString)
  {
    GMTrace.i(13225412263936L, 98537);
    boolean bool = "message".equals(Az(paramString));
    GMTrace.o(13225412263936L, 98537);
    return bool;
  }
  
  public final int Ax(String paramString)
  {
    GMTrace.i(13225546481664L, 98538);
    StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ").append(Az(paramString)).append(" ");
    String str;
    if (this.uIy)
    {
      str = "INDEXED BY messageTalkerIdStatusIndex";
      paramString = str + " WHERE" + RI(paramString);
      paramString = this.hnp.a(paramString, null, 2);
      if (!paramString.moveToFirst()) {
        break label122;
      }
    }
    label122:
    for (int i = paramString.getInt(0);; i = 0)
    {
      paramString.close();
      GMTrace.o(13225546481664L, 98538);
      return i;
      str = "INDEXED BY messageTalkerStatusIndex";
      break;
    }
  }
  
  public final int Ay(String paramString)
  {
    int i = 0;
    GMTrace.i(13226217570304L, 98543);
    StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      String str = RN(paramString).name;
      paramString = new StringBuilder().append(str).append("  indexed by  ").append(str).append("TalkerTypeIndex ").toString() + " WHERE talker= '" + bf.my(paramString) + "' AND type IN (3,39,13,43,62,44,268435505)";
      paramString = this.hnp.a(paramString, null, 2);
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
      GMTrace.o(13226217570304L, 98543);
      return i;
    }
  }
  
  public final String Az(String paramString)
  {
    GMTrace.i(13226888658944L, 98548);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username == null", bool);
      paramString = RN(paramString).name;
      GMTrace.o(13226888658944L, 98548);
      return paramString;
    }
  }
  
  public final Cursor B(String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(13228767707136L, 98562);
    String str = " SELECT * FROM " + Az(paramString1) + " WHERE" + RI(paramString1) + "AND content LIKE '" + paramString2 + "%' ORDER BY createTime DESC LIMIT " + paramInt;
    v.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), str });
    paramString1 = this.hnp.a(str, null, 0);
    GMTrace.o(13228767707136L, 98562);
    return paramString1;
  }
  
  public final List<au> B(String paramString, long paramLong)
  {
    GMTrace.i(13218030288896L, 98482);
    ArrayList localArrayList = new ArrayList();
    paramString = "Select * From " + Az(paramString) + " Where " + RI(paramString) + " AND createTime > ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 11" + ";";
    paramString = this.hnp.a(paramString, new String[] { String.valueOf(paramLong) }, 2);
    while (paramString.moveToNext())
    {
      au localau = new au();
      localau.b(paramString);
      localArrayList.add(localau);
    }
    paramString.close();
    GMTrace.o(13218030288896L, 98482);
    return localArrayList;
  }
  
  public final boolean C(String paramString, long paramLong)
  {
    GMTrace.i(13218701377536L, 98487);
    if (z(paramString, paramLong).field_msgId > 0L)
    {
      GMTrace.o(13218701377536L, 98487);
      return true;
    }
    GMTrace.o(13218701377536L, 98487);
    return false;
  }
  
  public final long D(String paramString, long paramLong)
  {
    GMTrace.i(13221251514368L, 98506);
    paramString = "select createTime from " + Az(paramString) + " where msgId = " + paramLong;
    paramLong = 0L;
    paramString = this.hnp.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      paramLong = paramString.getLong(0);
    }
    paramString.close();
    GMTrace.o(13221251514368L, 98506);
    return paramLong;
  }
  
  public final List<au> D(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(13220311990272L, 98499);
    ArrayList localArrayList = new ArrayList();
    paramString = "SELECT * FROM " + Az(paramString) + " WHERE type = 49 ORDER BY createTime" + " DESC LIMIT " + paramInt1 + " , " + paramInt2;
    v.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", new Object[] { paramString });
    paramString = this.hnp.a(paramString, null, 2);
    while (paramString.moveToNext())
    {
      au localau = new au();
      localau.b(paramString);
      if (localau.axH()) {
        localArrayList.add(localau);
      }
    }
    paramString.close();
    GMTrace.o(13220311990272L, 98499);
    return localArrayList;
  }
  
  public final int E(String paramString, long paramLong)
  {
    GMTrace.i(13222056820736L, 98512);
    au localau = x(paramString, paramLong);
    this.uIJ.e((int)(bf.Nz() / 86400L), localau.field_msgSvrId, localau.field_createTime / 1000L);
    int i = this.hnp.delete(Az(paramString), "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      doNotify();
      a(new c.c(paramString, "delete", 1));
    }
    for (;;)
    {
      GMTrace.o(13222056820736L, 98512);
      return i;
      com.tencent.mm.plugin.report.c.oRz.a(111L, 246L, 1L, false);
    }
  }
  
  public final Cursor E(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(15229282942976L, 113467);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      GMTrace.o(15229282942976L, 113467);
      return null;
    }
    String str = Az(paramString);
    paramString = "select * from ( select * from " + str + " where" + RI(paramString) + " AND type IN (3,39,13,43,62,44,268435505)  order by " + "createTime DESC limit " + paramInt2 + " OFFSET " + paramInt1 + ") order by createTime ASC ";
    paramString = this.hnp.a(paramString, null, 2);
    GMTrace.o(15229282942976L, 113467);
    return paramString;
  }
  
  public final int F(String paramString, long paramLong)
  {
    GMTrace.i(13222325256192L, 98514);
    String str = RI(paramString) + " and createTime <= " + paramLong;
    b(Az(paramString), str, null);
    int i = this.hnp.delete(Az(paramString), str, null);
    if (i != 0)
    {
      Qq("delete_talker " + paramString);
      paramString = new c.c(paramString, "delete", i);
      paramString.nxs = -1L;
      a(paramString);
    }
    GMTrace.o(13222325256192L, 98514);
    return i;
  }
  
  public final int G(String paramString, long paramLong)
  {
    int i = 0;
    GMTrace.i(13226351788032L, 98544);
    au localau = cA(paramLong);
    if (localau.field_msgId == 0L)
    {
      v.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      GMTrace.o(13226351788032L, 98544);
      return 0;
    }
    String str = Az(paramString);
    paramString = "SELECT COUNT(*) FROM " + str + " " + RL(str) + " WHERE " + RI(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + localau.field_createTime;
    paramString = this.hnp.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    GMTrace.o(13226351788032L, 98544);
    return i;
  }
  
  public final String H(String paramString, long paramLong)
  {
    int i = 0;
    GMTrace.i(13226486005760L, 98545);
    Object localObject1 = cA(paramLong);
    if (((ce)localObject1).field_msgId == 0L)
    {
      v.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
      GMTrace.o(13226486005760L, 98545);
      return null;
    }
    Object localObject2 = Az(paramString);
    paramString = "EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + (String)localObject2 + " " + RL((String)localObject2) + " WHERE" + RI(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + ((ce)localObject1).field_createTime;
    localObject2 = this.hnp.a(paramString, null, 0);
    paramString = "";
    localObject1 = paramString;
    if (((Cursor)localObject2).moveToFirst()) {
      for (;;)
      {
        localObject1 = paramString;
        if (i >= ((Cursor)localObject2).getColumnCount()) {
          break;
        }
        paramString = paramString + ((Cursor)localObject2).getString(i) + " ";
        i += 1;
      }
    }
    ((Cursor)localObject2).close();
    GMTrace.o(13226486005760L, 98545);
    return (String)localObject1;
  }
  
  public final au I(String paramString, long paramLong)
  {
    GMTrace.i(13227962400768L, 98556);
    if (bf.mA(paramString))
    {
      GMTrace.o(13227962400768L, 98556);
      return null;
    }
    Object localObject = "select * from message where" + RI(paramString) + " and msgSeq > " + paramLong + " order by msgSeq ASC LIMIT 1 ";
    v.i("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq: " + (String)localObject);
    localObject = this.hnp.a((String)localObject, null, 0);
    if (localObject == null)
    {
      v.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed " + paramString);
      GMTrace.o(13227962400768L, 98556);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new au();
      paramString.b((Cursor)localObject);
      GMTrace.o(13227962400768L, 98556);
      return paramString;
    }
    ((Cursor)localObject).close();
    GMTrace.o(13227962400768L, 98556);
    return null;
  }
  
  public final long J(String paramString, long paramLong)
  {
    GMTrace.i(13229304578048L, 98566);
    v.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(18) });
    paramString = "SELECT createTime FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime DESC  LIMIT 18";
    v.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hnp.a(paramString, null, 0);
    if (paramString == null)
    {
      v.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
      GMTrace.o(13229304578048L, 98566);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      v.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      GMTrace.o(13229304578048L, 98566);
      return paramLong;
    }
    paramString.close();
    v.w("MicroMsg.MsgInfoStorage", "get result fail");
    GMTrace.o(13229304578048L, 98566);
    return paramLong;
  }
  
  public final void J(ArrayList<Long> paramArrayList)
  {
    GMTrace.i(13218567159808L, 98486);
    long l1 = this.hnp.cs(-1L);
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        long l2 = ((Long)paramArrayList.next()).longValue();
        au localau = cA(l2);
        localau.dG(localau.gxu | 0x20);
        v.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
        a(l2, localau);
      }
    }
    finally
    {
      this.hnp.aD(l1);
    }
    GMTrace.o(13218567159808L, 98486);
  }
  
  public final int K(au paramau)
  {
    int i = 0;
    GMTrace.i(13220446208000L, 98500);
    if ((paramau == null) || (bf.mA(paramau.field_talker)))
    {
      GMTrace.o(13220446208000L, 98500);
      return 0;
    }
    paramau = "SELECT count(msgId) FROM " + Az(paramau.field_talker) + " WHERE" + RI(paramau.field_talker) + "AND isSend = 0" + " AND msgId >= " + paramau.field_msgId + " ORDER BY createTime DESC";
    paramau = this.hnp.a(paramau, null, 2);
    if (paramau.moveToFirst()) {
      i = paramau.getInt(0);
    }
    paramau.close();
    GMTrace.o(13220446208000L, 98500);
    return i;
  }
  
  public final long K(String paramString, long paramLong)
  {
    GMTrace.i(13229573013504L, 98568);
    v.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(18) });
    paramString = "SELECT createTime FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND createTime > " + paramLong + " ORDER BY createTime ASC  LIMIT 18";
    v.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", new Object[] { paramString });
    paramString = this.hnp.a(paramString, null, 0);
    if (paramString == null)
    {
      v.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
      GMTrace.o(13229573013504L, 98568);
      return paramLong;
    }
    if (paramString.moveToLast())
    {
      paramLong = paramString.getLong(0);
      v.d("MicroMsg.MsgInfoStorage", "result msg create time %d", new Object[] { Long.valueOf(paramLong) });
      paramString.close();
      GMTrace.o(13229573013504L, 98568);
      return paramLong;
    }
    paramString.close();
    v.w("MicroMsg.MsgInfoStorage", "get result fail");
    GMTrace.o(13229573013504L, 98568);
    return paramLong;
  }
  
  public final long L(au paramau)
  {
    GMTrace.i(13220848861184L, 98503);
    long l = b(paramau, false);
    GMTrace.o(13220848861184L, 98503);
    return l;
  }
  
  public final void M(au paramau)
  {
    GMTrace.i(13222996344832L, 98519);
    if ((paramau == null) || (paramau.field_status == 4))
    {
      GMTrace.o(13222996344832L, 98519);
      return;
    }
    paramau.dv(4);
    String str = eC(paramau.field_msgId);
    if ((str != null) && (str.length() > 0)) {
      if (this.hnp.update(str, paramau.pv(), "msgId=?", new String[] { paramau.field_msgId }) != 0)
      {
        doNotify();
        a(new c.c(paramau.field_talker, "update", paramau, -1));
      }
    }
    GMTrace.o(13222996344832L, 98519);
  }
  
  public final int N(au paramau)
  {
    int i = 0;
    GMTrace.i(13223398998016L, 98522);
    if (paramau != null)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("content", paramau.field_content);
      localContentValues.put("status", Integer.valueOf(paramau.field_status));
      int j = this.hnp.update(eC(paramau.field_msgId), localContentValues, "msgId=?", new String[] { String.valueOf(paramau.field_msgId) });
      i = j;
      if (j != 0)
      {
        doNotify();
        a(new c.c(paramau.field_talker, "update", paramau));
        i = j;
      }
    }
    GMTrace.o(13223398998016L, 98522);
    return i;
  }
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    GMTrace.i(13228499271680L, 98560);
    if (paramLong2 == 0L)
    {
      paramString = "SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND createTime > " + paramLong1 + " ORDER BY createTime ASC  LIMIT 50" + " OFFSET " + paramInt;
      v.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
      paramString = this.hnp.a(paramString, null, 0);
      GMTrace.o(13228499271680L, 98560);
      return paramString;
    }
    long l;
    if (paramLong2 < paramLong1)
    {
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      paramString = "SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND createTime > " + l + " AND createTime < " + paramLong2 + " ORDER BY createTime ASC  LIMIT 50" + " OFFSET " + paramInt;
      v.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
      paramString = this.hnp.a(paramString, null, 0);
      GMTrace.o(13228499271680L, 98560);
      return paramString;
      l = paramLong1;
    }
  }
  
  public final Cursor a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    GMTrace.i(17856997621760L, 133045);
    long l;
    if (paramLong2 < paramLong1)
    {
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      paramString = new StringBuilder("SELECT * FROM ").append(Az(paramString)).append(" WHERE").append(RI(paramString)).append("AND createTime >= ").append(l).append(" AND createTime <= ").append(paramLong2).append(" AND isSend=");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramString = i + " LIMIT 1";
        v.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
        paramString = this.hnp.a(paramString, null, 0);
        GMTrace.o(17856997621760L, 133045);
        return paramString;
      }
      l = paramLong1;
    }
  }
  
  public final void a(long paramLong, au paramau)
  {
    GMTrace.i(13222862127104L, 98518);
    if (paramau.bLV())
    {
      String str = RK(paramau.gxv);
      if (o.fA(str))
      {
        v.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
        paramau.cH("notifymessage");
      }
    }
    Z(paramau);
    if (this.hnp.update(eC(paramLong), paramau.pv(), "msgId=?", new String[] { String.valueOf(paramLong) }) != 0)
    {
      doNotify();
      a(new c.c(paramau.field_talker, "update", paramau));
      GMTrace.o(13222862127104L, 98518);
      return;
    }
    com.tencent.mm.plugin.report.c.oRz.a(111L, 244L, 1L, false);
    GMTrace.o(13222862127104L, 98518);
  }
  
  public final void a(g paramg, String paramString)
  {
    GMTrace.i(13216017022976L, 98467);
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    Cursor localCursor = paramg.a("PRAGMA table_info( " + paramString + " )", null, 2);
    int i5 = localCursor.getColumnIndex("name");
    while (localCursor.moveToNext()) {
      if (i5 >= 0)
      {
        String str = localCursor.getString(i5);
        if ("lvbuffer".equalsIgnoreCase(str)) {
          i = 1;
        } else if ("transContent".equalsIgnoreCase(str)) {
          j = 1;
        } else if ("transBrandWording".equalsIgnoreCase(str)) {
          k = 1;
        } else if ("talkerId".equalsIgnoreCase(str)) {
          m = 1;
        } else if ("bizClientMsgId".equalsIgnoreCase(str)) {
          n = 1;
        } else if ("bizChatId".equalsIgnoreCase(str)) {
          i1 = 1;
        } else if ("bizChatUserId".equalsIgnoreCase(str)) {
          i2 = 1;
        } else if ("msgSeq".equalsIgnoreCase(str)) {
          i3 = 1;
        } else if ("flag".equalsIgnoreCase(str)) {
          i4 = 1;
        }
      }
    }
    localCursor.close();
    long l = paramg.cs(Thread.currentThread().getId());
    if (i == 0) {
      paramg.eE(paramString, "Alter table " + paramString + " add lvbuffer BLOB ");
    }
    if (j == 0) {
      paramg.eE(paramString, "Alter table " + paramString + " add transContent TEXT ");
    }
    if (k == 0) {
      paramg.eE(paramString, "Alter table " + paramString + " add transBrandWording TEXT ");
    }
    if (m == 0) {
      paramg.eE(paramString, "Alter table " + paramString + " add talkerId INTEGER ");
    }
    if (n == 0) {
      paramg.eE(paramString, "Alter table " + paramString + " add bizClientMsgId TEXT ");
    }
    if (i1 == 0) {
      paramg.eE(paramString, "Alter table " + paramString + " add bizChatId INTEGER DEFAULT -1");
    }
    if (i2 == 0) {
      paramg.eE(paramString, "Alter table " + paramString + " add bizChatUserId TEXT ");
    }
    if (i3 == 0) {
      paramg.eE(paramString, "Alter table " + paramString + " add msgSeq INTEGER ");
    }
    if (i4 == 0) {
      paramg.eE(paramString, "Alter table " + paramString + " add flag INT DEFAULT 0 ");
    }
    paramg.aD(l);
    GMTrace.o(13216017022976L, 98467);
  }
  
  public final void a(c.a parama)
  {
    GMTrace.i(13215345934336L, 98462);
    this.uIK.remove(parama);
    GMTrace.o(13215345934336L, 98462);
  }
  
  public final void a(c.a parama, Looper paramLooper)
  {
    GMTrace.i(13215211716608L, 98461);
    this.uIK.a(parama, paramLooper);
    GMTrace.o(13215211716608L, 98461);
  }
  
  public final void a(c.b paramb)
  {
    GMTrace.i(13216688111616L, 98472);
    this.uIC.add(paramb);
    b(paramb);
    GMTrace.o(13216688111616L, 98472);
  }
  
  public final void a(c.c paramc)
  {
    GMTrace.i(13215077498880L, 98460);
    if (this.uIK.by(paramc)) {
      this.uIK.doNotify();
    }
    GMTrace.o(13215077498880L, 98460);
  }
  
  public final void a(e parame)
  {
    GMTrace.i(13214809063424L, 98458);
    if (!this.uIB.contains(parame)) {
      this.uIB.add(parame);
    }
    GMTrace.o(13214809063424L, 98458);
  }
  
  public final boolean a(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(13229438795776L, 98567);
    paramString1 = "UPDATE " + RM(paramString1) + " SET transContent = '" + bf.my(paramString2) + "', transBrandWording = '" + bf.my(bf.mz(paramString3)) + "' WHERE msgId = " + paramLong;
    boolean bool = this.hnp.eE(null, paramString1);
    GMTrace.o(13229438795776L, 98567);
    return bool;
  }
  
  public final g aJS()
  {
    GMTrace.i(13214943281152L, 98459);
    g localg = this.hnp;
    GMTrace.o(13214943281152L, 98459);
    return localg;
  }
  
  public final void aJT()
  {
    GMTrace.i(13216419676160L, 98470);
    h.vJ();
    h.vI().vr().set(348167, Integer.valueOf(1));
    GMTrace.o(13216419676160L, 98470);
  }
  
  public final void aJU()
  {
    GMTrace.i(13216822329344L, 98473);
    int i = 0;
    while (i < this.uIC.size())
    {
      b((c.b)this.uIC.get(i));
      i += 1;
    }
    GMTrace.o(13216822329344L, 98473);
  }
  
  public final void aJV()
  {
    GMTrace.i(13217090764800L, 98475);
    if (!this.uIy)
    {
      GMTrace.o(13217090764800L, 98475);
      return;
    }
    Object localObject = "select count(*) from " + "message" + " where talkerId ISNULL ";
    localObject = this.hnp.a((String)localObject, null, 2);
    if (localObject != null) {
      if (!((Cursor)localObject).moveToFirst()) {
        break label309;
      }
    }
    label309:
    for (int i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      if (i > 0)
      {
        v.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", new Object[] { "message" });
        long l = System.currentTimeMillis();
        localObject = "update " + "message" + " set talkerId=(select rowid from rcontact" + " where rcontact.username" + " = " + "message" + ".talker)";
        boolean bool = this.hnp.eE("message", (String)localObject);
        v.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
        if ((bool) && (this.uIy))
        {
          this.hnp.eE("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
          this.hnp.eE("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
          this.hnp.eE("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
          this.hnp.eE("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
          this.hnp.eE("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
          v.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
        }
      }
      GMTrace.o(13217090764800L, 98475);
      return;
    }
  }
  
  public final ArrayList<au> aJW()
  {
    GMTrace.i(13218432942080L, 98485);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.hnp.a("message", null, "createTime>=? AND status=? AND isSend=?", new String[] { String.valueOf(System.currentTimeMillis() - 172800000L), "5", "1" }, null, null, "createTime ASC", 2);
    label152:
    while (localCursor.moveToNext())
    {
      au localau = new au();
      localau.b(localCursor);
      if (!localau.bMl()) {}
      for (int i = 1;; i = 0)
      {
        if (((i & 0x1) == 0) || (x.QL(localau.field_talker)) || (x.QN(localau.field_talker)) || (x.eO(localau.field_talker))) {
          break label152;
        }
        localArrayList.add(localau);
        break;
      }
    }
    localCursor.close();
    GMTrace.o(13218432942080L, 98485);
    return localArrayList;
  }
  
  public final List<au> aJX()
  {
    GMTrace.i(13220043554816L, 98497);
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    Object localObject1;
    int i;
    if (this.uIC != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject1 = new ArrayList();
      i = 0;
    }
    Object localObject2;
    for (;;)
    {
      if (i >= this.uIC.size()) {
        break label210;
      }
      localObject2 = this.hnp.a(((c.b)this.uIC.get(i)).name, null, "status=1 and isSend=1", null, null, null, "createTime DESC ", 2);
      for (;;)
      {
        if (!((Cursor)localObject2).moveToNext()) {
          break label196;
        }
        au localau = new au();
        localau.b((Cursor)localObject2);
        if ((localau.bMa()) || (localau.bLY()) || (localau.bLZ()) || (localau.bMh()))
        {
          if (ay.zn() - localau.field_createTime > 600000L)
          {
            ((List)localObject1).add(localau);
            continue;
            bool = false;
            break;
          }
          localArrayList.add(localau);
        }
      }
      label196:
      ((Cursor)localObject2).close();
      i += 1;
    }
    label210:
    if (((List)localObject1).size() > 0)
    {
      long l = this.hnp.cs(-1L);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (au)((Iterator)localObject1).next();
        v.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", new Object[] { Long.valueOf(((ce)localObject2).field_msgId), Long.valueOf(((ce)localObject2).field_createTime), ((ce)localObject2).field_talker, bf.Qi(((ce)localObject2).field_content) });
        ((au)localObject2).dv(5);
        a(((ce)localObject2).field_msgId, (au)localObject2);
      }
      this.hnp.aD(l);
    }
    GMTrace.o(13220043554816L, 98497);
    return localArrayList;
  }
  
  public final Cursor aJY()
  {
    GMTrace.i(13224472739840L, 98530);
    Cursor localCursor = this.hnp.query("message", new String[] { "talker", "count(*) as unReadCount" }, "isSend=? AND status!=?", new String[] { "0", "4" }, "talker", null, null);
    GMTrace.o(13224472739840L, 98530);
    return localCursor;
  }
  
  public final Cursor aJZ()
  {
    GMTrace.i(13225143828480L, 98535);
    if (this.uIC.size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Cursor localCursor = this.hnp.query(((c.b)this.uIC.get(0)).name, null, "msgId=?", new String[] { "-1" }, null, null, null);
      GMTrace.o(13225143828480L, 98535);
      return localCursor;
    }
  }
  
  public final String aKa()
  {
    GMTrace.i(15660390285312L, 116679);
    GMTrace.o(15660390285312L, 116679);
    return "type IN (3,39,13,43,62,44,268435505)";
  }
  
  public final String aKb()
  {
    GMTrace.i(15660524503040L, 116680);
    GMTrace.o(15660524503040L, 116680);
    return "type IN (3,39,13,43,62,44,49,268435505)";
  }
  
  public final long b(au paramau, boolean paramBoolean)
  {
    GMTrace.i(16003316580352L, 119234);
    if ((paramau == null) || (bf.mA(paramau.field_talker)))
    {
      com.tencent.mm.plugin.report.c.oRz.a(111L, 250L, 1L, false);
      if (paramau == null) {}
      for (localObject1 = "-1";; localObject1 = paramau.field_talker)
      {
        v.e("MicroMsg.MsgInfoStorage", "Error insert message msg:%s talker:%s", new Object[] { paramau, localObject1 });
        GMTrace.o(16003316580352L, 119234);
        return -1L;
      }
    }
    v.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", new Object[] { Boolean.valueOf(this.uIM), Long.valueOf(paramau.field_msgSeq) });
    Object localObject1 = null;
    Object localObject2 = ay.gm(paramau.gxv);
    if (localObject2 != null) {
      localObject1 = ((ay.b)localObject2).hmw;
    }
    if (o.fA((String)localObject1))
    {
      v.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { localObject1 });
      if (paramau.field_type == 436207665)
      {
        v.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
        GMTrace.o(16003316580352L, 119234);
        return -1L;
      }
      paramau.cH("notifymessage");
    }
    localObject1 = RN(paramau.field_talker);
    if (localObject1 == null)
    {
      com.tencent.mm.plugin.report.c.oRz.a(111L, 249L, 1L, false);
      v.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", new Object[] { paramau.field_talker });
      GMTrace.o(16003316580352L, 119234);
      return -1L;
    }
    ((c.b)localObject1).aKc();
    paramau.x(((c.b)localObject1).hEO);
    Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[] { Long.valueOf(paramau.field_msgId), localObject1, eC(paramau.field_msgId) }), ((c.b)localObject1).name.equals(eC(paramau.field_msgId)));
    if (paramau.field_msgSvrId != 0L)
    {
      paramau.gxz = 1;
      paramau.gtq = true;
    }
    Iterator localIterator = this.uIB.iterator();
    while (localIterator.hasNext()) {
      if (!((e)localIterator.next()).a(paramau, (ay.b)localObject2))
      {
        v.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", new Object[] { paramau.field_talker, paramau.gxv });
        GMTrace.o(16003316580352L, 119234);
        return -1L;
      }
    }
    Z(paramau);
    if (((c.b)localObject1).name.equals("message"))
    {
      paramau.field_talkerId = ((int)RJ(paramau.field_talker));
      paramau.gxf = true;
    }
    localObject2 = paramau.pv();
    long l = this.hnp.a(((c.b)localObject1).name, "msgId", (ContentValues)localObject2, paramBoolean);
    v.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", new Object[] { Long.valueOf(l), paramau.field_talker, Long.valueOf(paramau.field_msgId), Integer.valueOf(paramau.field_type), Integer.valueOf(paramau.field_status), Long.valueOf(paramau.field_msgSvrId), Long.valueOf(paramau.field_msgSeq), Integer.valueOf(paramau.field_flag), Long.valueOf(paramau.field_createTime), Integer.valueOf(paramau.field_isSend), this.uIN, Long.valueOf(bf.aA(this.uIO)) });
    if (l == -1L)
    {
      com.tencent.mm.plugin.report.c.oRz.a(111L, 248L, 1L, false);
      v.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", new Object[] { Long.valueOf(paramau.field_msgSvrId), Long.valueOf(l) });
      GMTrace.o(16003316580352L, 119234);
      return -1L;
    }
    if ((this.uIM) && (bf.aA(this.uIO) > 2000L) && (paramau.field_isSend == 1) && (paramau.field_status == 1))
    {
      v.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", new Object[] { this.uIN, Long.valueOf(bf.aA(this.uIO)) });
      Ad(this.uIN);
    }
    if (this.uIM)
    {
      localObject1 = null;
      if (e.uxf != null) {
        localObject1 = e.uxf.F(paramau);
      }
      if (!bf.mA((String)localObject1)) {
        break label989;
      }
    }
    label989:
    for (localObject2 = paramau.field_talker;; localObject2 = localObject1)
    {
      localObject1 = null;
      if (this.uIL.containsKey(localObject2)) {
        localObject1 = (c.c)this.uIL.get(localObject2);
      }
      if (localObject1 == null)
      {
        localObject1 = new c.c(paramau.field_talker, "insert", paramau);
        if (c.c.O(paramau)) {
          ((c.c)localObject1).nxp += 1;
        }
        ((c.c)localObject1).nxq += 1;
        this.uIL.put(localObject2, localObject1);
      }
      for (;;)
      {
        l = paramau.field_msgId;
        GMTrace.o(16003316580352L, 119234);
        return l;
        ((c.c)localObject1).nxo.add(paramau);
        break;
        localObject1 = new c.c(paramau.field_talker, "insert", paramau);
        if (c.c.O(paramau)) {
          ((c.c)localObject1).nxp = 1;
        }
        ((c.c)localObject1).nxq = 1;
        doNotify();
        a((c.c)localObject1);
      }
    }
  }
  
  public final void b(long paramLong, au paramau)
  {
    GMTrace.i(13223130562560L, 98520);
    if (bf.mz(paramau.field_talker).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("no talker set when update by svrid", bool);
      if (paramau.bLV())
      {
        String str = RK(paramau.gxv);
        if (o.fA(str))
        {
          v.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", new Object[] { str });
          paramau.cH("notifymessage");
        }
      }
      Z(paramau);
      if (this.hnp.update(Az(paramau.field_talker), paramau.pv(), "msgSvrId=?", new String[] { String.valueOf(paramLong) }) == 0) {
        break;
      }
      doNotify();
      a(new c.c(paramau.field_talker, "update", paramau));
      GMTrace.o(13223130562560L, 98520);
      return;
    }
    com.tencent.mm.plugin.report.c.oRz.a(111L, 243L, 1L, false);
    GMTrace.o(13223130562560L, 98520);
  }
  
  public final void b(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    GMTrace.i(13221654167552L, 98509);
    long l = bf.Nz();
    Object localObject = "SELECT msgSvrId,createTime FROM " + paramString1 + " WHERE createTime > " + (l - 172800L) * 1000L;
    paramString1 = (String)localObject;
    if (!bf.mA(paramString2)) {
      paramString1 = (String)localObject + " AND " + paramString2;
    }
    paramString2 = new ArrayList();
    localObject = new ArrayList();
    paramString1 = this.hnp.a(paramString1, paramArrayOfString, 2);
    if (paramString1.moveToFirst())
    {
      do
      {
        int i = paramString1.getInt(0);
        l = paramString1.getLong(1) / 1000L;
        paramString2.add(Integer.valueOf(i));
        ((List)localObject).add(Long.valueOf(l));
      } while (paramString1.moveToNext());
      this.uIJ.i(paramString2, (List)localObject);
    }
    paramString1.close();
    GMTrace.o(13221654167552L, 98509);
  }
  
  public final List<au> bd(String paramString, int paramInt)
  {
    GMTrace.i(13219506683904L, 98493);
    ArrayList localArrayList = new ArrayList();
    if (this.uIC != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND status = 3" + " AND type <> 10000" + " ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hnp.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        au localau = new au();
        localau.b(paramString);
        localArrayList.add(localau);
      }
    }
    paramString.close();
    GMTrace.o(13219506683904L, 98493);
    return localArrayList;
  }
  
  public final List<au> be(String paramString, int paramInt)
  {
    GMTrace.i(13220177772544L, 98498);
    ArrayList localArrayList = new ArrayList();
    if (this.uIC != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = "SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND isSend = 0" + " ORDER BY createTime DESC LIMIT " + paramInt;
      paramString = this.hnp.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        au localau = new au();
        localau.b(paramString);
        if (localau.bMa()) {
          localArrayList.add(localau);
        }
      }
    }
    paramString.close();
    GMTrace.o(13220177772544L, 98498);
    return localArrayList;
  }
  
  public final Cursor bf(String paramString, int paramInt)
  {
    GMTrace.i(16692390395904L, 124368);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      GMTrace.o(16692390395904L, 124368);
      return null;
    }
    String str = Az(paramString);
    paramString = "select * from " + str + " where" + RI(paramString) + " AND type = 49  order by createTime" + " DESC limit " + paramInt + " OFFSET 0";
    paramString = this.hnp.a(paramString, null, 2);
    GMTrace.o(16692390395904L, 124368);
    return paramString;
  }
  
  public final Cursor bg(String paramString, int paramInt)
  {
    GMTrace.i(17856729186304L, 133043);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      GMTrace.o(17856729186304L, 133043);
      return null;
    }
    Object localObject = Az(paramString);
    paramString = new StringBuilder("select * from ").append((String)localObject).append(" where").append(RI(paramString)).append(" AND ");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" (type = 49");
    ((StringBuilder)localObject).append(" or type = 553648177").append(") ");
    paramString = ((StringBuilder)localObject).toString() + "  order by createTime DESC limit " + paramInt + " OFFSET 0";
    paramString = this.hnp.a(paramString, null, 2);
    GMTrace.o(17856729186304L, 133043);
    return paramString;
  }
  
  public final int bh(String paramString, int paramInt)
  {
    GMTrace.i(13222459473920L, 98515);
    v.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", new Object[] { paramString, Integer.valueOf(paramInt), ag.bJe() });
    au localau = x(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localau.field_talker));
    b(Az(paramString), "createTime<=? AND" + RI(paramString), new String[] { localau.field_createTime });
    paramInt = this.hnp.delete(Az(paramString), "createTime<=? AND" + RI(paramString), new String[] { localau.field_createTime });
    if (paramInt != 0)
    {
      doNotify();
      a(new c.c(paramString, "delete", paramInt));
    }
    GMTrace.o(13222459473920L, 98515);
    return paramInt;
  }
  
  public final Cursor bi(String paramString, int paramInt)
  {
    GMTrace.i(13222727909376L, 98517);
    au localau = x(paramString, paramInt);
    Assert.assertTrue(paramString.equals(localau.field_talker));
    paramString = this.hnp.query(Az(paramString), null, "createTime<=? AND" + RI(paramString), new String[] { localau.field_createTime }, null, null, null);
    GMTrace.o(13222727909376L, 98517);
    return paramString;
  }
  
  public final Cursor bj(String paramString, int paramInt)
  {
    GMTrace.i(13223935868928L, 98526);
    String str = "SELECT * FROM ( SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC";
    v.i("MicroMsg.MsgInfoStorage", "summerbadcr getInitCursor1 getCursor talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    paramString = this.hnp.a(str, null, 0);
    GMTrace.o(13223935868928L, 98526);
    return paramString;
  }
  
  public final Cursor bk(String paramString, int paramInt)
  {
    GMTrace.i(13224338522112L, 98529);
    paramString = this.hnp.query(Az(paramString), null, "isSend=? AND" + RI(paramString) + "AND status!=?  order by msgId" + " DESC limit " + paramInt, new String[] { "0", "4" }, null, null, null);
    GMTrace.o(13224338522112L, 98529);
    return paramString;
  }
  
  public final int bl(String paramString, int paramInt)
  {
    int i = 0;
    GMTrace.i(13225814917120L, 98540);
    paramString = "SELECT COUNT(*) FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND type = " + paramInt;
    paramString = this.hnp.a(paramString, null, 2);
    paramInt = i;
    if (paramString.moveToFirst()) {
      paramInt = paramString.getInt(0);
    }
    paramString.close();
    GMTrace.o(13225814917120L, 98540);
    return paramInt;
  }
  
  public final Cursor bm(String paramString, int paramInt)
  {
    GMTrace.i(13228901924864L, 98563);
    String str = " SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND isSend=1" + " ORDER BY createTime DESC LIMIT " + paramInt;
    v.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    paramString = this.hnp.a(str, null, 0);
    GMTrace.o(13228901924864L, 98563);
    return paramString;
  }
  
  public final au[] bn(String paramString, int paramInt)
  {
    GMTrace.i(13229707231232L, 98569);
    if ((paramString == null) || (paramString.length() == 0) || (paramInt <= 0))
    {
      v.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + paramString + ", limit = " + paramInt);
      GMTrace.o(13229707231232L, 98569);
      return null;
    }
    Object localObject = "select * from " + Az(paramString) + " where" + RI(paramString) + "order by createTime DESC limit " + paramInt;
    localObject = this.hnp.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        au localau = new au();
        localau.b((Cursor)localObject);
        localArrayList.add(localau);
      } while (((Cursor)localObject).moveToNext());
      ((Cursor)localObject).close();
      v.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + paramString + ", limit = " + paramInt + ", count = " + localArrayList.size());
      Collections.reverse(localArrayList);
      paramString = (au[])localArrayList.toArray(new au[localArrayList.size()]);
      GMTrace.o(13229707231232L, 98569);
      return paramString;
    }
    v.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
    ((Cursor)localObject).close();
    GMTrace.o(13229707231232L, 98569);
    return null;
  }
  
  public final int c(String paramString, long paramLong, int paramInt)
  {
    GMTrace.i(13218835595264L, 98488);
    String str = "SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND createTime < " + paramLong + " ORDER BY createTime ASC LIMIT -1 OFFSET " + paramInt;
    Cursor localCursor = this.hnp.a(str, null, 0);
    paramInt = localCursor.getCount();
    localCursor.close();
    v.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + paramString + " time:" + paramLong + " count " + paramInt + " [" + str + "]");
    GMTrace.o(13218835595264L, 98488);
    return paramInt;
  }
  
  public final List<au> c(String paramString, long paramLong, boolean paramBoolean)
  {
    GMTrace.i(13221385732096L, 98507);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
      GMTrace.o(13221385732096L, 98507);
      return null;
    }
    paramLong = D(paramString, paramLong);
    if (paramLong == 0L)
    {
      v.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
      GMTrace.o(13221385732096L, 98507);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (paramString = "select * from " + Az(paramString) + " where" + RI(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime > " + paramLong + "  order by createTime ASC limit 10";; paramString = "select * from " + Az(paramString) + " where" + RI(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime < " + paramLong + "  order by createTime DESC limit 10")
    {
      paramString = this.hnp.a(paramString, null, 2);
      while (paramString.moveToNext())
      {
        au localau = new au();
        localau.b(paramString);
        localArrayList.add(localau);
      }
    }
    if (!paramBoolean) {
      Collections.reverse(localArrayList);
    }
    paramString.close();
    GMTrace.o(13221385732096L, 98507);
    return localArrayList;
  }
  
  public final au cA(long paramLong)
  {
    GMTrace.i(13217224982528L, 98476);
    au localau = new au();
    Cursor localCursor = this.hnp.a(eC(paramLong), null, "msgId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localau.b(localCursor);
    }
    localCursor.close();
    GMTrace.o(13217224982528L, 98476);
    return localau;
  }
  
  public final int cB(long paramLong)
  {
    GMTrace.i(13220983078912L, 98504);
    au localau = cA(paramLong);
    Object localObject = localau.field_talker;
    this.uIJ.e((int)(bf.Nz() / 86400L), localau.field_msgSvrId, localau.field_createTime / 1000L);
    int i = this.hnp.delete(eC(paramLong), "msgId=?", new String[] { String.valueOf(paramLong) });
    if (i != 0)
    {
      Qq("delete_id " + paramLong);
      localObject = new c.c((String)localObject, "delete", 1);
      ((c.c)localObject).nxs = paramLong;
      ((c.c)localObject).jZq = localau.field_bizChatId;
      a((c.c)localObject);
    }
    for (;;)
    {
      GMTrace.o(13220983078912L, 98504);
      return i;
      com.tencent.mm.plugin.report.c.oRz.a(111L, 245L, 1L, false);
    }
  }
  
  public final boolean cC(long paramLong)
  {
    GMTrace.i(13221788385280L, 98510);
    boolean bool = this.uIJ.eA(paramLong);
    GMTrace.o(13221788385280L, 98510);
    return bool;
  }
  
  public final boolean cD(long paramLong)
  {
    GMTrace.i(13227291312128L, 98551);
    int i = 0;
    while (i < this.uIC.size())
    {
      if (((c.b)this.uIC.get(i)).cF(paramLong))
      {
        GMTrace.o(13227291312128L, 98551);
        return true;
      }
      i += 1;
    }
    GMTrace.o(13227291312128L, 98551);
    return false;
  }
  
  public final void cE(long paramLong)
  {
    GMTrace.i(13229975666688L, 98571);
    this.uIJ.a(0, paramLong, 0L, false);
    GMTrace.o(13229975666688L, 98571);
  }
  
  public final au cN(String paramString1, String paramString2)
  {
    GMTrace.i(13219238248448L, 98491);
    if (bf.mA(paramString1))
    {
      v.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", new Object[] { paramString1 });
      GMTrace.o(13219238248448L, 98491);
      return null;
    }
    au localau = new au();
    paramString2 = "select * from " + Az(paramString1) + " where" + RI(paramString1) + paramString2 + " order by createTime DESC limit 1";
    paramString2 = this.hnp.a(paramString2, null, 2);
    if (paramString2.moveToFirst()) {
      localau.b(paramString2);
    }
    paramString2.close();
    v.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", new Object[] { paramString1, Long.valueOf(localau.field_msgId) });
    GMTrace.o(13219238248448L, 98491);
    return localau;
  }
  
  public final Cursor cO(String paramString1, String paramString2)
  {
    GMTrace.i(13223801651200L, 98525);
    paramString1 = "SELECT * FROM " + Az(paramString1) + " WHERE" + RI(paramString1) + "AND content LIKE '%" + paramString2 + "%' AND type = 1";
    paramString1 = paramString1 + " ORDER BY createTime DESC";
    paramString1 = this.hnp.a(paramString1, null, 0);
    GMTrace.o(13223801651200L, 98525);
    return paramString1;
  }
  
  public final int cP(String paramString1, String paramString2)
  {
    GMTrace.i(13229036142592L, 98564);
    String str = " SELECT COUNT(*) FROM " + Az(paramString1) + " WHERE" + RI(paramString1) + "AND content LIKE '" + paramString2 + "%' ";
    Cursor localCursor = this.hnp.a(str, null, 2);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          break label181;
        }
        i = localCursor.getInt(0);
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.MsgInfoStorage", localException, "", new Object[0]);
        localCursor.close();
        i = 0;
        continue;
      }
      finally
      {
        localCursor.close();
      }
      v.d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(i), str });
      GMTrace.o(13229036142592L, 98564);
      return i;
      label181:
      int i = 0;
    }
  }
  
  public final LinkedList<au> cQ(String paramString1, String paramString2)
  {
    GMTrace.i(13229841448960L, 98570);
    paramString1 = this.hnp.a("message", null, "talker=? AND bizClientMsgId=?", new String[] { paramString1, paramString2 }, null, null, null, 2);
    if ((paramString1 == null) || (!paramString1.moveToFirst()))
    {
      v.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
      GMTrace.o(13229841448960L, 98570);
      return null;
    }
    paramString2 = new LinkedList();
    do
    {
      au localau = new au();
      localau.b(paramString1);
      paramString2.add(localau);
    } while (paramString1.moveToNext());
    paramString1.close();
    GMTrace.o(13229841448960L, 98570);
    return paramString2;
  }
  
  public final Cursor e(String paramString, long paramLong1, long paramLong2)
  {
    GMTrace.i(15229417160704L, 113468);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
      GMTrace.o(15229417160704L, 113468);
      return null;
    }
    String str = Az(paramString);
    paramString = "select * from " + str + " where" + RI(paramString) + "AND type IN (3,39,13,43,62,44,268435505) AND " + "createTime >= " + paramLong1 + " AND createTime< " + paramLong2 + " order by createTime ASC";
    paramString = this.hnp.a(paramString, null, 2);
    GMTrace.o(15229417160704L, 113468);
    return paramString;
  }
  
  public final int f(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    GMTrace.i(17856863404032L, 133044);
    paramString = "SELECT COUNT(*) FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND type = 50" + " AND createTime >= " + paramLong1 + " AND createTime <= " + paramLong2 + " LIMIT 1";
    paramString = this.hnp.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    GMTrace.o(17856863404032L, 133044);
    return i;
  }
  
  public final Cursor f(String paramString, int paramInt, long paramLong)
  {
    GMTrace.i(13223667433472L, 98524);
    paramString = "SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + " AND createTime <= " + paramLong + " order by createTime ASC limit " + paramInt;
    paramString = this.hnp.a(paramString, null, 0);
    GMTrace.o(13223667433472L, 98524);
    return paramString;
  }
  
  public final int g(String paramString, long paramLong1, long paramLong2)
  {
    GMTrace.i(13228230836224L, 98558);
    long l;
    if (paramLong2 < paramLong1)
    {
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      v.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", new Object[] { paramString, Long.valueOf(l), Long.valueOf(paramLong2) });
      paramString = "SELECT COUNT(msgId) FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND createTime >= " + l + " AND createTime <= " + paramLong2;
      v.d("MicroMsg.MsgInfoStorage", "get count sql: " + paramString);
      paramString = this.hnp.a(paramString, null, 2);
      if (paramString == null)
      {
        v.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
        GMTrace.o(13228230836224L, 98558);
        return 0;
      }
      if (paramString.moveToFirst())
      {
        int i = paramString.getInt(0);
        v.d("MicroMsg.MsgInfoStorage", "result msg count %d", new Object[] { Integer.valueOf(i) });
        paramString.close();
        GMTrace.o(13228230836224L, 98558);
        return i;
      }
      paramString.close();
      GMTrace.o(13228230836224L, 98558);
      return 0;
      l = paramLong1;
    }
  }
  
  public final Cursor g(String paramString, int paramInt, long paramLong)
  {
    GMTrace.i(13224070086656L, 98527);
    String str = "SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "ORDER BY createTime DESC LIMIT " + paramInt + ") ORDER BY createTime ASC ) WHERE createTime" + " <= " + paramLong;
    v.i("MicroMsg.MsgInfoStorage", "summerbadcr getInitCursor2 getCursor talk:%s limitCount:%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), str });
    paramString = this.hnp.a(str, null, 0);
    GMTrace.o(13224070086656L, 98527);
    return paramString;
  }
  
  public final Cursor h(String paramString, long paramLong1, long paramLong2)
  {
    GMTrace.i(13228365053952L, 98559);
    long l;
    if (paramLong2 < paramLong1)
    {
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      paramString = "SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND createTime >= " + l + " AND createTime <= " + paramLong2 + " ORDER BY createTime ASC ";
      v.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
      paramString = this.hnp.a(paramString, null, 0);
      GMTrace.o(13228365053952L, 98559);
      return paramString;
      l = paramLong1;
    }
  }
  
  public final int i(String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    GMTrace.i(14895349235712L, 110979);
    long l;
    if (paramLong2 < paramLong1)
    {
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      paramString = "SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND createTime > " + l + " AND createTime < " + paramLong2;
      paramString = this.hnp.a(paramString, null, 2);
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
      GMTrace.o(14895349235712L, 110979);
      return i;
      l = paramLong1;
    }
  }
  
  public final Cursor j(String paramString, long paramLong1, long paramLong2)
  {
    GMTrace.i(13228633489408L, 98561);
    long l;
    if (paramLong2 < paramLong1)
    {
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      paramString = "SELECT * FROM " + Az(paramString) + " WHERE" + RI(paramString) + "AND createTime >= " + l + " AND createTime <= " + paramLong2;
      v.d("MicroMsg.MsgInfoStorage", "get cursor: " + paramString);
      paramString = this.hnp.a(paramString, null, 0);
      GMTrace.o(13228633489408L, 98561);
      return paramString;
      l = paramLong1;
    }
  }
  
  public final void lock()
  {
    GMTrace.i(13215480152064L, 98463);
    Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
    GMTrace.o(13215480152064L, 98463);
  }
  
  public final au ph(int paramInt)
  {
    GMTrace.i(13219640901632L, 98494);
    if (this.uIC == null)
    {
      v.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
      GMTrace.o(13219640901632L, 98494);
      return null;
    }
    au localau = new au();
    long l1 = 0L;
    int i = 0;
    while (i < this.uIC.size())
    {
      long l2 = l1;
      if ((((c.b)this.uIC.get(i)).nxk & paramInt) != 0)
      {
        Object localObject = "select * from " + ((c.b)this.uIC.get(i)).name + "  order by createTime DESC limit 1";
        localObject = this.hnp.a((String)localObject, null, 2);
        l2 = l1;
        if (((Cursor)localObject).moveToFirst())
        {
          long l3 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("createTime"));
          l2 = l1;
          if (l1 < l3)
          {
            localau.b((Cursor)localObject);
            l2 = l3;
          }
        }
        ((Cursor)localObject).close();
      }
      i += 1;
      l1 = l2;
    }
    GMTrace.o(13219640901632L, 98494);
    return localau;
  }
  
  public final void unlock()
  {
    GMTrace.i(13215614369792L, 98464);
    Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    GMTrace.o(13215614369792L, 98464);
  }
  
  public final void w(String paramString, long paramLong)
  {
    GMTrace.i(13216151240704L, 98468);
    c.b localb = RN(paramString);
    long l = localb.hEO;
    Random localRandom = new Random();
    this.hnp.eE("message", "BEGIN;");
    au localau = new au(paramString);
    int i = 0;
    while (i < paramLong)
    {
      localau.z(System.currentTimeMillis());
      localau.setType(1);
      localau.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bf.bJQ());
      localau.x(l);
      localau.dv(localRandom.nextInt(4));
      localau.dw(localRandom.nextInt(1));
      l += 1L;
      localb.hEO += 1L;
      localau.y(System.currentTimeMillis() + bf.bJQ());
      this.hnp.eE("message", "INSERT INTO " + Az(localau.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + localau.field_msgId + "," + localau.field_msgSvrId + "," + localau.field_type + "," + localau.field_status + "," + localau.field_createTime + ",'" + localau.field_talker + "','" + localau.field_content + "'," + RJ(paramString) + ");");
      if (i % 10000 == 0)
      {
        this.hnp.eE("message", "COMMIT;");
        this.hnp.eE("message", "BEGIN;");
      }
      i += 1;
    }
    this.hnp.eE("message", "COMMIT;");
    this.uIz.Rm(paramString);
    localau.x(1L + l);
    L(localau);
    GMTrace.o(13216151240704L, 98468);
  }
  
  public final au x(String paramString, long paramLong)
  {
    GMTrace.i(13217359200256L, 98477);
    au localau = new au();
    paramString = this.hnp.a(Az(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localau.b(paramString);
    }
    paramString.close();
    GMTrace.o(13217359200256L, 98477);
    return localau;
  }
  
  public final au y(String paramString, long paramLong)
  {
    GMTrace.i(13217493417984L, 98478);
    au localau = new au();
    paramString = this.hnp.a(Az(paramString), null, RI(paramString) + " AND msgSeq=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localau.b(paramString);
    }
    paramString.close();
    GMTrace.o(13217493417984L, 98478);
    return localau;
  }
  
  public final au z(String paramString, long paramLong)
  {
    GMTrace.i(13217627635712L, 98479);
    au localau = new au();
    paramString = this.hnp.a(Az(paramString), null, "createTime=? AND" + RI(paramString), new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localau.b(paramString);
    }
    paramString.close();
    GMTrace.o(13217627635712L, 98479);
    return localau;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */