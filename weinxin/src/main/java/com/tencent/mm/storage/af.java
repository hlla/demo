package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.b.f;
import com.tencent.mm.bj.g;
import com.tencent.mm.bn.a.a;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class af
  extends com.tencent.mm.sdk.e.m
  implements c.a, as
{
  public static final String[] gUn;
  private final com.tencent.mm.sdk.e.e gUp;
  private as.b uHg;
  private d uHh;
  private a uHi;
  private k<as.a, ae> uHj;
  private k<as.a, ae> uHk;
  
  static
  {
    GMTrace.i(13197494976512L, 98329);
    gUn = new String[] { i.a(com.tencent.mm.k.a.gTF, "rconversation"), i.a(com.tencent.mm.k.a.gTF, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "DROP INDEX IF EXISTS rconversation_unreadcount_index ", "DROP INDEX IF EXISTS multi_index ", "CREATE INDEX IF NOT EXISTS rconversation_multi_index ON  rconversation ( unReadCount,parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )" };
    GMTrace.o(13197494976512L, 98329);
  }
  
  public af(com.tencent.mm.sdk.e.e parame)
  {
    GMTrace.i(13188502388736L, 98262);
    this.uHi = new a();
    this.uHj = new k() {};
    this.uHk = new k() {};
    Assert.assertTrue(parame instanceof g);
    Object localObject = parame.a("PRAGMA table_info( rconversation)", null, 2);
    int i = ((Cursor)localObject).getColumnIndex("name");
    do
    {
      if (!((Cursor)localObject).moveToNext()) {
        break;
      }
    } while ((i < 0) || (!"flag".equalsIgnoreCase(((Cursor)localObject).getString(i))));
    for (i = 1;; i = 0)
    {
      ((Cursor)localObject).close();
      localObject = i.a(com.tencent.mm.k.a.gTF, "rconversation", parame);
      ((List)localObject).addAll(i.a(com.tencent.mm.k.a.gTF, "rbottleconversation", parame));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        parame.eE("rconversation", (String)((Iterator)localObject).next());
      }
      if (i == 0) {
        parame.eE("rconversation", "update rconversation set flag = conversationTime");
      }
      this.gUp = parame;
      GMTrace.o(13188502388736L, 98262);
      return;
    }
  }
  
  private static String Rj(String paramString)
  {
    GMTrace.i(13188636606464L, 98263);
    v.v("MicroMsg.ConversationStorage", "talker :" + paramString);
    if (x.eO(paramString))
    {
      GMTrace.o(13188636606464L, 98263);
      return "rbottleconversation";
    }
    GMTrace.o(13188636606464L, 98263);
    return "rconversation";
  }
  
  private long bLw()
  {
    GMTrace.i(13192394702848L, 98291);
    long l2 = System.currentTimeMillis();
    long l1 = 0L;
    Cursor localCursor = this.gUp.a("select max(conversationTime) as conversationTime from rconversation", null, 2);
    while (localCursor.moveToNext()) {
      l1 = localCursor.getLong(0);
    }
    localCursor.close();
    v.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", new Object[] { Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
    GMTrace.o(13192394702848L, 98291);
    return l1;
  }
  
  private static long c(ae paramae)
  {
    GMTrace.i(13189978783744L, 98273);
    if (paramae != null)
    {
      l = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramae, paramae.field_conversationTime);
      GMTrace.o(13189978783744L, 98273);
      return l;
    }
    long l = bf.NA();
    GMTrace.o(13189978783744L, 98273);
    return l & 0xFFFFFFFFFFFFFF;
  }
  
  private static void e(ae paramae)
  {
    GMTrace.i(13192260485120L, 98290);
    if (paramae == null)
    {
      GMTrace.o(13192260485120L, 98290);
      return;
    }
    if (paramae.field_unReadCount > 0)
    {
      v.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
      if ((paramae.field_attrflag & 0x100000) != 0)
      {
        paramae.dt(paramae.field_unReadCount - 1);
        paramae.dy(paramae.field_attrflag & 0xFFEFFFFF);
      }
    }
    GMTrace.o(13192260485120L, 98290);
  }
  
  public final boolean An(String paramString)
  {
    GMTrace.i(13190515654656L, 98277);
    v.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", new Object[] { paramString, ag.bJe() });
    boolean bool = this.gUp.eE("rconversation", "delete from " + Rj(paramString) + " where username like '%" + paramString + "'");
    if (bool) {
      b(5, this, paramString);
    }
    GMTrace.o(13190515654656L, 98277);
    return bool;
  }
  
  protected final boolean Fd()
  {
    GMTrace.i(13196958105600L, 98325);
    if ((this.gUp == null) || (this.gUp.bKd()))
    {
      if (this.gUp == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.gUp.bKd()))
      {
        v.w("MicroMsg.ConversationStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        GMTrace.o(13196958105600L, 98325);
        return false;
      }
    }
    GMTrace.o(13196958105600L, 98325);
    return true;
  }
  
  public final void RA(String paramString)
  {
    GMTrace.i(13197226541056L, 98327);
    int i = this.gUp.delete(Rj(paramString), "username=? or parentRef =?", new String[] { paramString, paramString });
    v.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", new Object[] { paramString, Integer.valueOf(i) });
    if (i != 0) {
      b(5, this, paramString);
    }
    GMTrace.o(13197226541056L, 98327);
  }
  
  public final int RB(String paramString)
  {
    int i = -1;
    GMTrace.i(13197360758784L, 98328);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13197360758784L, 98328);
      return -1;
    }
    paramString = "select msgCount from rconversation where username=" + g.dP(paramString);
    paramString = this.gUp.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    GMTrace.o(13197360758784L, 98328);
    return i;
  }
  
  public final void Rk(String paramString)
  {
    GMTrace.i(13190113001472L, 98274);
    v.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", new Object[] { paramString, ag.bJe() });
    if (this.gUp.delete(Rj(paramString), "username=?", new String[] { paramString }) != 0) {
      b(5, this, paramString);
    }
    GMTrace.o(13190113001472L, 98274);
  }
  
  public final ae Rl(String paramString)
  {
    GMTrace.i(13190649872384L, 98278);
    Cursor localCursor = this.gUp.a(Rj(paramString), null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      v.w("MicroMsg.ConversationStorage", "get null with username:" + paramString);
      localCursor.close();
      GMTrace.o(13190649872384L, 98278);
      return null;
    }
    paramString = new ae();
    paramString.b(localCursor);
    localCursor.close();
    GMTrace.o(13190649872384L, 98278);
    return paramString;
  }
  
  public final void Rm(String paramString)
  {
    GMTrace.i(13191455178752L, 98284);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.gUp.update("rconversation", localContentValues, "username=?", new String[] { paramString });
    GMTrace.o(13191455178752L, 98284);
  }
  
  public final boolean Rn(String paramString)
  {
    GMTrace.i(13191589396480L, 98285);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      v.e("MicroMsg.ConversationStorage", "update conversation failed");
      GMTrace.o(13191589396480L, 98285);
      return false;
    }
    Object localObject = Rl(paramString);
    if (localObject == null)
    {
      GMTrace.o(13191589396480L, 98285);
      return true;
    }
    if ((((aj)localObject).field_unReadCount == 0) && (((aj)localObject).field_unReadMuteCount == 0) && (paramString.equals(((aj)localObject).field_username)))
    {
      b(paramString, 1048576, false, ((aj)localObject).field_attrflag);
      localObject = new ContentValues();
      ((ContentValues)localObject).put("UnReadInvite", Integer.valueOf(0));
      if (this.gUp.update(Rj(paramString), (ContentValues)localObject, "username= ?", new String[] { bf.my(paramString) }) > 0) {
        b(3, this, paramString);
      }
      GMTrace.o(13191589396480L, 98285);
      return true;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("unReadCount", Integer.valueOf(0));
    localContentValues.put("unReadMuteCount", Integer.valueOf(0));
    localContentValues.put("UnReadInvite", Integer.valueOf(0));
    localContentValues.put("atCount", Integer.valueOf(0));
    localContentValues.put("attrflag", Integer.valueOf(((aj)localObject).field_attrflag & 0xFFEFFFFF));
    int i = this.gUp.update(Rj(paramString), localContentValues, "username= ?", new String[] { bf.my(paramString) });
    if (i > 0) {
      b(3, this, paramString);
    }
    if (i > 0)
    {
      GMTrace.o(13191589396480L, 98285);
      return true;
    }
    GMTrace.o(13191589396480L, 98285);
    return false;
  }
  
  public final boolean Ro(String paramString)
  {
    GMTrace.i(13191723614208L, 98286);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      v.e("MicroMsg.ConversationStorage", "update conversation failed");
      GMTrace.o(13191723614208L, 98286);
      return false;
    }
    ae localae = Rl(paramString);
    if ((localae == null) || ((localae.field_unReadCount > 0) && (paramString.equals(localae.field_username))))
    {
      GMTrace.o(13191723614208L, 98286);
      return true;
    }
    boolean bool = this.gUp.eE("rconversation", "update " + Rj(paramString) + " set unReadCount = 1, atCount" + " = 0, attrflag = " + (localae.field_attrflag | 0x100000) + " where username = \"" + bf.my(paramString) + "\"");
    if (bool) {
      b(3, this, paramString);
    }
    GMTrace.o(13191723614208L, 98286);
    return bool;
  }
  
  public final boolean Rp(String paramString)
  {
    GMTrace.i(13192528920576L, 98292);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      v.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
      GMTrace.o(13192528920576L, 98292);
      return false;
    }
    paramString = Rl(paramString);
    if (paramString == null)
    {
      v.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
      GMTrace.o(13192528920576L, 98292);
      return false;
    }
    boolean bool = this.gUp.eE("rconversation", "update " + Rj(paramString.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 1, bLw() + 1L) + " where username = \"" + bf.my(paramString.field_username) + "\"");
    if (bool) {
      b(3, this, paramString.field_username);
    }
    GMTrace.o(13192528920576L, 98292);
    return bool;
  }
  
  public final boolean Rq(String paramString)
  {
    GMTrace.i(13192663138304L, 98293);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      v.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
      GMTrace.o(13192663138304L, 98293);
      return false;
    }
    if (Rl(paramString) == null)
    {
      ae localae = new ae(paramString);
      localae.s(System.currentTimeMillis());
      d(localae);
      v.i("MicroMsg.ConversationStorage", "setPlacedTop username = " + paramString);
    }
    paramString = Rl(paramString);
    if (paramString == null)
    {
      GMTrace.o(13192663138304L, 98293);
      return false;
    }
    boolean bool = this.gUp.eE("rconversation", "update " + Rj(paramString.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramString, 2, 0L) + " where username = \"" + bf.my(paramString.field_username) + "\"");
    if (bool) {
      b(3, this, paramString.field_username);
    }
    GMTrace.o(13192663138304L, 98293);
    return bool;
  }
  
  public final boolean Rr(String paramString)
  {
    GMTrace.i(13192797356032L, 98294);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      v.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
      GMTrace.o(13192797356032L, 98294);
      return false;
    }
    boolean bool = f(Rl(paramString));
    GMTrace.o(13192797356032L, 98294);
    return bool;
  }
  
  public final boolean Rs(String paramString)
  {
    GMTrace.i(13193065791488L, 98296);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      v.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
      GMTrace.o(13193065791488L, 98296);
      return false;
    }
    boolean bool = g(Rl(paramString));
    GMTrace.o(13193065791488L, 98296);
    return bool;
  }
  
  public final Cursor Rt(String paramString)
  {
    GMTrace.i(13194005315584L, 98303);
    paramString = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + bf.mz(paramString) + " order by flag desc, conversationTime" + " desc";
    paramString = this.gUp.rawQuery(paramString, null);
    GMTrace.o(13194005315584L, 98303);
    return paramString;
  }
  
  public final Cursor Ru(String paramString)
  {
    GMTrace.i(13194810621952L, 98309);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT username, unReadCount");
    localStringBuilder.append(" FROM rconversation");
    localStringBuilder.append(" WHERE username LIKE '%@chatroom' ");
    localStringBuilder.append(bf.mz(paramString));
    localStringBuilder.append(" AND unReadCount > 0");
    paramString = localStringBuilder.toString();
    paramString = this.gUp.rawQuery(paramString, null);
    GMTrace.o(13194810621952L, 98309);
    return paramString;
  }
  
  public final int Rv(String paramString)
  {
    int i = 0;
    int j = 0;
    GMTrace.i(13195750146048L, 98316);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM rconversation");
    localStringBuilder.append(" WHERE parentRef = '").append(paramString).append("'");
    paramString = localStringBuilder.toString();
    v.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", new Object[] { paramString });
    paramString = this.gUp.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    GMTrace.o(13195750146048L, 98316);
    return i;
  }
  
  public final String Rw(String paramString)
  {
    GMTrace.i(13195884363776L, 98317);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = '").append(paramString).append("'");
    ((StringBuilder)localObject).append(" ORDER BY conversationTime DESC, conversationTime").append(" DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    paramString = ((StringBuilder)localObject).toString();
    v.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", new Object[] { paramString });
    paramString = this.gUp.a(paramString, null, 2);
    if (paramString != null)
    {
      if (paramString.moveToFirst())
      {
        localObject = paramString.getString(0);
        paramString.close();
        GMTrace.o(13195884363776L, 98317);
        return (String)localObject;
      }
      paramString.close();
    }
    GMTrace.o(13195884363776L, 98317);
    return null;
  }
  
  public final ae Rx(String paramString)
  {
    GMTrace.i(13196421234688L, 98321);
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().c(o.hkZ, null, paramString);
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        paramString = new ae();
        paramString.b(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      GMTrace.o(13196421234688L, 98321);
      return paramString;
      paramString = null;
      break;
      paramString = null;
    }
  }
  
  public final int Ry(String paramString)
  {
    int i = 0;
    int j = 0;
    GMTrace.i(13196689670144L, 98323);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(atCount) from rconversation");
    localStringBuilder.append(" where unReadCount > 0");
    if (!bf.mA(paramString)) {
      localStringBuilder.append(" and username = '").append(paramString).append("'");
    }
    paramString = localStringBuilder.toString();
    v.d("MicroMsg.ConversationStorage", "query sql: %s", new Object[] { paramString });
    paramString = this.gUp.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    GMTrace.o(13196689670144L, 98323);
    return i;
  }
  
  public final void Rz(String paramString)
  {
    GMTrace.i(13197092323328L, 98326);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Update rconversation");
    ((StringBuilder)localObject).append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + bf.my(paramString) + "\"");
    localObject = ((StringBuilder)localObject).toString();
    v.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", new Object[] { localObject });
    if (this.gUp.eE("rconversation", (String)localObject)) {
      b(3, this, paramString);
    }
    GMTrace.o(13197092323328L, 98326);
  }
  
  public final void X(au paramau)
  {
    GMTrace.i(13190784090112L, 98279);
    String str = paramau.field_talker;
    int i = 0;
    ae localae2 = Rl(str);
    if ((localae2 != null) && (localae2.field_conversationTime > paramau.field_createTime) && (localae2.field_conversationTime != Long.MAX_VALUE))
    {
      v.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      GMTrace.o(13190784090112L, 98279);
      return;
    }
    ae localae1 = localae2;
    if (localae2 == null)
    {
      localae1 = new ae(str);
      i = 1;
    }
    localae1.dw(paramau.field_isSend);
    localae1.dt(localae1.field_unReadCount);
    localae1.W(paramau);
    localae1.ct(Integer.toString(paramau.field_type));
    localae1.t(localae1.field_flag & 0x4000000000000000 | paramau.field_createTime & 0xFFFFFFFFFFFFFF);
    if (i != 0)
    {
      d(localae1);
      GMTrace.o(13190784090112L, 98279);
      return;
    }
    a(localae1, str, true);
    GMTrace.o(13190784090112L, 98279);
  }
  
  public final int a(ae paramae, String paramString)
  {
    GMTrace.i(13191992049664L, 98288);
    int i = a(paramae, paramString, true);
    GMTrace.o(13191992049664L, 98288);
    return i;
  }
  
  public final int a(ae paramae, String paramString, boolean paramBoolean)
  {
    GMTrace.i(13192126267392L, 98289);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      v.e("MicroMsg.ConversationStorage", "update conversation failed");
      GMTrace.o(13192126267392L, 98289);
      return 0;
    }
    if (paramBoolean) {
      paramae.t(c(paramae));
    }
    e(paramae);
    int i = this.gUp.update(Rj(paramString), paramae.pv(), "username=?", new String[] { paramString });
    if (i != 0) {
      b(3, this, paramString);
    }
    for (;;)
    {
      GMTrace.o(13192126267392L, 98289);
      return i;
      v.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", new Object[] { Rj(paramString) });
    }
  }
  
  public final Cursor a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean)
  {
    GMTrace.i(13193602662400L, 98300);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
    localStringBuilder.append(" from rconversation where ");
    if (com.tencent.mm.k.a.gTI == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bf.mz(paramString1));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (String)paramString1.next();
        localStringBuilder.append(" and rconversation.username").append(" != '").append(paramList).append("'");
      }
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(bf.my(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc");
    v.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + localStringBuilder.toString());
    paramString1 = this.gUp;
    paramList = localStringBuilder.toString();
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      paramString1 = paramString1.a(paramList, null, i);
      GMTrace.o(13193602662400L, 98300);
      return paramString1;
    }
  }
  
  public final Cursor a(ArrayList<String> paramArrayList, String paramString1, List<String> paramList, String paramString2)
  {
    GMTrace.i(13193736880128L, 98301);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
    localStringBuilder.append(" from rconversation where (");
    int i = 0;
    if (i < paramArrayList.size())
    {
      if (i != paramArrayList.size() - 1) {
        localStringBuilder.append("username = '" + (String)paramArrayList.get(i) + "' OR ");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("username = '" + (String)paramArrayList.get(i) + "'");
      }
    }
    localStringBuilder.append(") and ");
    if (com.tencent.mm.k.a.gTI == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bf.mz(paramString1));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramArrayList = paramList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString1 = (String)paramArrayList.next();
        localStringBuilder.append(" and rconversation.username").append(" != '").append(paramString1).append("'");
      }
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(bf.my(paramString2)).append("' ");
      }
    }
    v.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql " + localStringBuilder.toString());
    paramArrayList = this.gUp.rawQuery(localStringBuilder.toString(), null);
    GMTrace.o(13193736880128L, 98301);
    return paramArrayList;
  }
  
  public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.e parame)
  {
    GMTrace.i(13189173477376L, 98267);
    parame = this.uHi.bI(parame);
    GMTrace.o(13189173477376L, 98267);
    return parame;
  }
  
  public final void a(c paramc, c.c paramc1)
  {
    GMTrace.i(13189844566016L, 98272);
    if (paramc1 == null)
    {
      v.f("MicroMsg.ConversationStorage", "null notifyInfo");
      GMTrace.o(13189844566016L, 98272);
      return;
    }
    Object localObject2 = paramc1.fJC;
    Object localObject1 = Rl((String)localObject2);
    au localau = paramc.Ag((String)localObject2);
    if (localObject1 == null)
    {
      paramc = new ae((String)localObject2);
      if (x.eO((String)localObject2)) {
        paramc.du(1);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.uHi.a(localau, paramc, bool, paramc1);
      v.i("MicroMsg.ConversationStorage", "dkevent user:%s func:%s cnt:%d ", new Object[] { paramc1.fJC, paramc1.nxn, Integer.valueOf(paramc1.nxp) });
      long l1;
      long l2;
      long l3;
      if ((localau != null) && (localau.field_msgId != 0L))
      {
        if ((paramc1.nxp == 1) && (((au)paramc1.nxo.get(0)).field_msgId != localau.field_msgId)) {
          v.w("MicroMsg.ConversationStorage", "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d", new Object[] { Long.valueOf(localau.field_msgId), Long.valueOf(((au)paramc1.nxo.get(0)).field_msgId) });
        }
        i = localau.field_flag;
        l1 = paramc.field_lastSeq;
        l2 = localau.field_msgSeq;
        l3 = paramc.field_UnDeliverCount;
        v.i("MicroMsg.ConversationStorage", "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
        if (((!paramc1.nxn.equals("insert")) || (paramc1.nxp <= 0)) && ((!paramc1.nxn.equals("update")) || (paramc.field_unReadCount + paramc1.nxp < 0))) {
          break label632;
        }
        paramc.dt(paramc.field_unReadCount + paramc1.nxp);
        if (l2 > l1)
        {
          v.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq[%d]", new Object[] { Long.valueOf(l2) });
          if ((l3 <= 0L) || ((i & 0x2) != 0)) {
            break label623;
          }
          v.i("MicroMsg.ConversationStorage", "summerbadcr insert or update reset lastseq but undeliver flag not match[%d, %d, %d, %d]", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), Integer.valueOf(i) });
        }
        if ((localau.bMc()) && (localau.field_isSend == 1))
        {
          paramc.field_sightTime = localau.field_createTime;
          paramc.glg = true;
        }
      }
      label513:
      Object localObject3;
      if ((paramc1.nxn.equals("insert")) && (paramc1.nxo.size() > 0) && (o.dH(paramc1.fJC)))
      {
        localObject1 = com.tencent.mm.u.m.xL();
        localObject2 = paramc1.nxo.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label835;
          }
          localObject3 = (au)((Iterator)localObject2).next();
          if (((ce)localObject3).field_isSend != 1) {
            if (!((au)localObject3).bMa())
            {
              if (((ce)localObject3).field_type != 503316529) {
                break label784;
              }
              i = 1;
              label565:
              if (i == 0) {}
            }
            else
            {
              if (!((au)localObject3).RD((String)localObject1)) {
                break label789;
              }
              paramc.dz(paramc.field_atCount + 1);
            }
          }
          for (;;)
          {
            localObject3 = f.q(((ce)localObject3).field_content, "sysmsg");
            if (!au.af((Map)localObject3)) {
              break label812;
            }
            paramc.dC(paramc.field_UnReadInvite + 1);
            break label513;
            label623:
            paramc.u(l2);
            break;
            label632:
            if ((paramc1.nxr <= 0) || (l2 >= l1) || (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().y(paramc.field_username, l1).field_msgId != 0L)) {
              break;
            }
            l3 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().AC(paramc.field_username);
            v.i("MicroMsg.ConversationStorage", "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
            paramc.u(l2);
            if (l1 <= l3) {
              break;
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).xC().v(paramc.field_username, l3);
            break;
            label784:
            i = 0;
            break label565;
            label789:
            if (((au)localObject3).bMr()) {
              paramc.dz(paramc.field_atCount + 4096);
            }
          }
          label812:
          if (au.ag((Map)localObject3)) {
            paramc.dC(paramc.field_UnReadInvite + 4096);
          }
        }
      }
      label835:
      int k = 0;
      int i = 0;
      localObject2 = paramc1.fJC;
      int j = k;
      if (paramc1 != null)
      {
        j = k;
        if (paramc1.nxn.equals("delete"))
        {
          if (paramc1.nxr > 0) {
            i = paramc1.nxr;
          }
          v.i("MicroMsg.ConversationStorage", "notify delete count %d ", new Object[] { Integer.valueOf(paramc1.nxr) });
          j = i;
        }
      }
      if ((paramc1 != null) && (paramc1.nxn.equals("insert"))) {
        if (paramc1.nxq > 0)
        {
          i = paramc1.nxq;
          v.i("MicroMsg.ConversationStorage", "notify insert all count %d ", new Object[] { Integer.valueOf(paramc1.nxq) });
        }
      }
      for (;;)
      {
        if (localau != null) {}
        for (l1 = localau.field_msgSeq;; l1 = -1L)
        {
          v.i("MicroMsg.ConversationStorage", "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d]", new Object[] { localObject2, Long.valueOf(l1), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Thread.currentThread().getId()) });
          this.uHj.by(paramc);
          this.uHj.doNotify();
          if (localObject2 != null) {
            break;
          }
          v.e("MicroMsg.ConversationStorage", "talker == null");
          GMTrace.o(13189844566016L, 98272);
          return;
        }
        if (!((String)localObject2).equals(paramc.field_username))
        {
          v.e("MicroMsg.ConversationStorage", "process message for conversation failed: inconsist username");
          GMTrace.o(13189844566016L, 98272);
          return;
        }
        if ((localau != null) && (localau.field_msgId != 0L))
        {
          v.v("MicroMsg.ConversationStorage", "onNotifyChange   msgId:" + localau.field_msgId);
          paramc.W(localau);
          if (this.uHg != null)
          {
            localObject1 = new PString();
            localObject3 = new PString();
            PInt localPInt = new PInt();
            this.uHg.a(localau, (PString)localObject1, (PString)localObject3, localPInt, paramc.eC(2097152));
            v.d("MicroMsg.ConversationStorage", "oreh onNotifyChange genDigest: pDigestUser.value=%s", new Object[] { ((PString)localObject3).value });
            paramc.cu(((PString)localObject1).value);
            paramc.cv(((PString)localObject3).value);
            paramc.dx(localPInt.value);
            paramc.ct(Integer.toString(localau.field_type));
            if (this.uHh != null) {
              this.uHh.a(localau, paramc);
            }
            paramc.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramc, 1, localau.field_createTime));
            if (!bool) {
              break label1525;
            }
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb((String)localObject2);
            if ((localObject1 != null) && (!bf.mA(((com.tencent.mm.e.b.af)localObject1).field_username)) && (((x)localObject1).tG())) {
              paramc.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramc, 2, 0L));
            }
            a(paramc, j, i);
            if (!localau.bMc()) {
              break label1515;
            }
            paramc.s(localau.field_createTime);
            label1393:
            d(paramc);
          }
        }
        label1515:
        label1525:
        label1597:
        do
        {
          for (;;)
          {
            this.uHk.by(paramc);
            this.uHk.doNotify();
            this.uHi.b(localau, paramc, bool, paramc1);
            GMTrace.o(13189844566016L, 98272);
            return;
            localObject1 = az(localau.field_type, paramc.field_content);
            localObject3 = bf.mz(paramc.field_digest);
            if (bf.mA((String)localObject1)) {}
            for (localObject1 = "";; localObject1 = " " + bf.mz((String)localObject1))
            {
              paramc.cu(((String)localObject3).concat((String)localObject1));
              break;
            }
            paramc.s(bf.NA());
            break label1393;
            a(paramc, j, i);
            a(paramc, (String)localObject2, true);
            continue;
            v.i("MicroMsg.ConversationStorage", "update null conversation with talker " + (String)localObject2);
            if (bool) {
              break label1597;
            }
            paramc.bLr();
            a(paramc, j, i);
            a(paramc, (String)localObject2, true);
          }
        } while (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Av((String)localObject2) <= 0);
        if (localau.bMc()) {
          paramc.s(localau.field_createTime);
        }
        for (;;)
        {
          a(paramc, j, i);
          d(paramc);
          break;
          paramc.s(bf.NA());
        }
        i = 0;
        break;
        i = 0;
      }
      paramc = (c)localObject1;
    }
  }
  
  public final void a(d paramd)
  {
    GMTrace.i(13189039259648L, 98266);
    this.uHh = paramd;
    GMTrace.o(13189039259648L, 98266);
  }
  
  public final void a(ae paramae, int paramInt1, int paramInt2)
  {
    GMTrace.i(13191186743296L, 98282);
    String str = paramae.field_username;
    if (!((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Aw(str))
    {
      GMTrace.o(13191186743296L, 98282);
      return;
    }
    if (bf.mz(paramae.field_username).length() <= 0)
    {
      v.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
      GMTrace.o(13191186743296L, 98282);
      return;
    }
    if (paramae.field_msgCount == 0)
    {
      str = paramae.field_username;
      paramae.ds(((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ax(str));
      v.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      v.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(paramae.field_msgCount), paramae.field_username, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      GMTrace.o(13191186743296L, 98282);
      return;
      if (paramInt1 > 0)
      {
        paramae.ds(paramae.field_msgCount - paramInt1);
        if (paramae.field_msgCount < 0)
        {
          v.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
          paramae.ds(0);
        }
      }
      else if (paramInt2 > 0)
      {
        paramae.ds(paramae.field_msgCount + paramInt2);
      }
    }
  }
  
  public final void a(as.a parama)
  {
    GMTrace.i(13189441912832L, 98269);
    this.uHk.remove(parama);
    GMTrace.o(13189441912832L, 98269);
  }
  
  public final void a(as.a parama, Looper paramLooper)
  {
    GMTrace.i(13189307695104L, 98268);
    this.uHk.a(parama, paramLooper);
    GMTrace.o(13189307695104L, 98268);
  }
  
  public final void a(as.b paramb)
  {
    GMTrace.i(13188770824192L, 98264);
    this.uHg = paramb;
    GMTrace.o(13188770824192L, 98264);
  }
  
  public final void aw(LinkedList<String> paramLinkedList)
  {
    GMTrace.i(13194139533312L, 98304);
    v.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", new Object[] { ag.bJe() });
    if (paramLinkedList.isEmpty())
    {
      v.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
      GMTrace.o(13194139533312L, 98304);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = (String)paramLinkedList.poll();
    localStringBuilder.append("delete from rconversation where ");
    localStringBuilder.append("username='").append(str).append('\'');
    while (!paramLinkedList.isEmpty())
    {
      str = (String)paramLinkedList.poll();
      localStringBuilder.append(" or username='").append(str).append('\'');
    }
    v.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", new Object[] { localStringBuilder.toString() });
    this.gUp.eE("rconversation", localStringBuilder.toString());
    GMTrace.o(13194139533312L, 98304);
  }
  
  public final String az(int paramInt, String paramString)
  {
    GMTrace.i(13196823887872L, 98324);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bf.mA(paramString)) {
      switch (paramInt)
      {
      default: 
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      GMTrace.o(13196823887872L, 98324);
      return (String)localObject1;
      paramString = bg.q(paramString, "msg");
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = (String)paramString.get(".msg.appmsg.title");
        v.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { localObject1 });
      }
    }
  }
  
  public final Cursor b(String paramString1, List<String> paramList, boolean paramBoolean, String paramString2)
  {
    GMTrace.i(13193871097856L, 98302);
    String str2 = " ";
    String str1 = str2;
    if (paramString2 != null)
    {
      str1 = str2;
      if (paramString2.length() > 0) {
        str1 = " and rconversation.username = rcontact.username ";
      }
    }
    str2 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + " " + " where rconversation.username" + " = rcontact.username" + str1 + bf.mz(paramString1);
    str1 = "";
    paramString1 = str1;
    if (paramList != null)
    {
      paramString1 = str1;
      if (paramList.size() > 0)
      {
        paramList = paramList.iterator();
        for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + " and rconversation.username != '" + str1 + "'") {
          str1 = (String)paramList.next();
        }
      }
    }
    paramList = str2 + paramString1;
    paramString1 = paramList;
    if (paramBoolean) {
      paramString1 = paramList + " and ( verifyFlag & 8 ) = 0";
    }
    paramList = paramString1;
    if (paramString2 != null)
    {
      paramList = paramString1;
      if (paramString2.length() > 0) {
        paramList = paramString1 + new StringBuilder(" and ( rconversation.username like '%").append(paramString2).append("%' or content like '%").append(paramString2).append("%' or rcontact.nickname").append(" like '%").append(paramString2).append("%' or rcontact.alias").append(" like '%").append(paramString2).append("%' or rcontact.pyInitial").append(" like '%").append(paramString2).append("%' or rcontact.quanPin").append(" like '%").append(paramString2).append("%' or rcontact.conRemark").append(" like '%").append(paramString2).append("%'  ) ").toString();
      }
    }
    if ((paramString2 == null) || (paramString2.equals(""))) {}
    for (paramString1 = paramList + " order by flag desc, conversationTime desc";; paramString1 = paramList + " order by rconversation.username like \"%@chatroom\" asc")
    {
      v.d("MicroMsg.ConversationStorage", "getSearchCursor sql " + paramString1);
      paramString1 = this.gUp.rawQuery(paramString1, null);
      GMTrace.o(13193871097856L, 98302);
      return paramString1;
    }
  }
  
  public final void b(as.a parama)
  {
    GMTrace.i(13189576130560L, 98270);
    this.uHj.a(parama, null);
    GMTrace.o(13189576130560L, 98270);
  }
  
  public final boolean b(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    GMTrace.i(13191857831936L, 98287);
    if (bf.mA(paramString))
    {
      GMTrace.o(13191857831936L, 98287);
      return false;
    }
    if (Rl(paramString) == null)
    {
      GMTrace.o(13191857831936L, 98287);
      return true;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2 | paramInt1; paramInt1 == paramInt2; paramInt1 = (paramInt1 ^ 0xFFFFFFFF) & paramInt2)
    {
      GMTrace.o(13191857831936L, 98287);
      return false;
    }
    paramBoolean = this.gUp.eE("rconversation", "update " + Rj(paramString) + " set attrflag = " + paramInt1 + " where username = \"" + bf.my(paramString) + "\"");
    if (paramBoolean) {
      b(3, this, paramString);
    }
    GMTrace.o(13191857831936L, 98287);
    return paramBoolean;
  }
  
  public final int bLA()
  {
    int i = 0;
    int j = 0;
    GMTrace.i(13195481710592L, 98314);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT SUM(rconversation.unReadCount").append(")");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts").append("'");
    localObject = ((StringBuilder)localObject).toString();
    v.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", new Object[] { localObject });
    localObject = this.gUp.a((String)localObject, null, 2);
    if (localObject != null)
    {
      i = j;
      if (((Cursor)localObject).moveToFirst()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
    }
    GMTrace.o(13195481710592L, 98314);
    return i;
  }
  
  public final String bLB()
  {
    GMTrace.i(13195615928320L, 98315);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT rconversation.username");
    ((StringBuilder)localObject).append(" FROM rconversation");
    ((StringBuilder)localObject).append(" WHERE parentRef = 'officialaccounts").append("'");
    ((StringBuilder)localObject).append(" ORDER BY flag DESC, conversationTime").append(" DESC ");
    ((StringBuilder)localObject).append(" LIMIT 1 ");
    localObject = ((StringBuilder)localObject).toString();
    v.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", new Object[] { localObject });
    localObject = this.gUp.a((String)localObject, null, 2);
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst())
      {
        String str = ((Cursor)localObject).getString(0);
        ((Cursor)localObject).close();
        GMTrace.o(13195615928320L, 98315);
        return str;
      }
      ((Cursor)localObject).close();
    }
    GMTrace.o(13195615928320L, 98315);
    return null;
  }
  
  public final Cursor bLC()
  {
    GMTrace.i(13196018581504L, 98318);
    v.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", new Object[] { "select count(*) from rbottleconversation where unReadCount > 0" });
    Cursor localCursor = this.gUp.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
    GMTrace.o(13196018581504L, 98318);
    return localCursor;
  }
  
  public final ae bLD()
  {
    GMTrace.i(13196287016960L, 98320);
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().c(o.hkZ, null, "officialaccounts");
    ae localae;
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        localae = new ae();
        localae.b(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      GMTrace.o(13196287016960L, 98320);
      return localae;
      localae = null;
      break;
      localae = null;
    }
  }
  
  public final boolean bLs()
  {
    GMTrace.i(13190247219200L, 98275);
    boolean bool1 = this.gUp.eE("rconversation", "delete from rconversation");
    boolean bool2 = this.gUp.eE("rconversation", "delete from rbottleconversation");
    if ((bool1) || (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      if (bool1) {
        b(5, this, "");
      }
      GMTrace.o(13190247219200L, 98275);
      return bool1;
    }
  }
  
  public final boolean bLt()
  {
    GMTrace.i(13190381436928L, 98276);
    v.w("MicroMsg.ConversationStorage", "deleteBottleConversation stack:%s", new Object[] { ag.bJe() });
    boolean bool = this.gUp.eE("rconversation", "delete from rbottleconversation");
    if (bool) {
      b(5, this, "");
    }
    GMTrace.o(13190381436928L, 98276);
    return bool;
  }
  
  public final HashMap<String, Long> bLu()
  {
    GMTrace.i(13190918307840L, 98280);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    Cursor localCursor = this.gUp.a("rconversation", new String[] { "username", "conversationTime" }, null, null, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      GMTrace.o(13190918307840L, 98280);
      return localHashMap;
    }
    int i;
    if (localCursor == null) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label173;
      }
      localHashMap.put(localCursor.getString(0), Long.valueOf(localCursor.getLong(1)));
      localCursor.moveToNext();
      break;
      if ((localCursor.isClosed()) || (localCursor.isBeforeFirst()) || (localCursor.isAfterLast())) {
        i = 0;
      } else {
        i = 1;
      }
    }
    label173:
    localCursor.close();
    v.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - l));
    GMTrace.o(13190918307840L, 98280);
    return localHashMap;
  }
  
  public final void bLv()
  {
    GMTrace.i(13191320961024L, 98283);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msgCount", Integer.valueOf(0));
    this.gUp.update("rconversation", localContentValues, null, null);
    GMTrace.o(13191320961024L, 98283);
  }
  
  public final List<String> bLx()
  {
    GMTrace.i(13193468444672L, 98299);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select rconversation.username from rconversation").append(",rcontact where ");
    ((StringBuilder)localObject).append("rconversation.username = rcontact.username");
    ((StringBuilder)localObject).append(bf.mz(bf.mz(o.hkZ)));
    ((StringBuilder)localObject).append(" and ( verifyFlag & 8 ) = 0");
    ((StringBuilder)localObject).append(" and ( rconversation.parentRef is null  or ").append("rconversation.parentRef = '' ) ");
    String[] arrayOfString = o.hlg;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ((StringBuilder)localObject).append(" and rconversation.username != '").append(str).append("'");
      i += 1;
    }
    ((StringBuilder)localObject).append(" order by sightTime desc, flag").append(" desc, conversationTime desc");
    localObject = this.gUp.a(((StringBuilder)localObject).toString(), null, 2);
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        do
        {
          localArrayList.add(((Cursor)localObject).getString(0));
        } while (((Cursor)localObject).moveToNext());
      }
      ((Cursor)localObject).close();
    }
    v.d("MicroMsg.ConversationStorage", "user list:%s", new Object[] { localArrayList });
    GMTrace.o(13193468444672L, 98299);
    return localArrayList;
  }
  
  public final List<String> bLy()
  {
    GMTrace.i(13194273751040L, 98305);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = "select username from rconversation";
    int i = 0;
    if (i < localArrayList2.size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
      if (i > 0) {}
      for (localObject = " and ";; localObject = " where ")
      {
        localObject = (String)localObject + "username != \"" + bf.my((String)localArrayList2.get(i)) + "\"";
        i += 1;
        break;
      }
    }
    localObject = (String)localObject + " order by flag desc, conversationTime desc";
    localObject = this.gUp.rawQuery((String)localObject, null);
    i = ((Cursor)localObject).getColumnIndex("username");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList1.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    GMTrace.o(13194273751040L, 98305);
    return localArrayList1;
  }
  
  public final Cursor bLz()
  {
    GMTrace.i(13194542186496L, 98307);
    Cursor localCursor = this.gUp.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    GMTrace.o(13194542186496L, 98307);
    return localCursor;
  }
  
  public final Cursor c(String paramString1, List<String> paramList, String paramString2)
  {
    GMTrace.i(13193334226944L, 98298);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from rconversation where ");
    if (com.tencent.mm.k.a.gTI == paramString2) {
      localStringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(bf.mz(paramString1));
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (String)paramString1.next();
        localStringBuilder.append(" and rconversation.username").append(" != '").append(paramList).append("'");
      }
      if ("*".equals(paramString2)) {
        localStringBuilder.append(" 1 = 1 ");
      } else {
        localStringBuilder.append("parentRef = '").append(bf.my(paramString2)).append("' ");
      }
    }
    localStringBuilder.append(" order by flag desc, conversationTime").append(" desc");
    paramString1 = this.gUp.rawQuery(localStringBuilder.toString(), null);
    GMTrace.o(13193334226944L, 98298);
    return paramString1;
  }
  
  public final void c(as.a parama)
  {
    GMTrace.i(13189710348288L, 98271);
    this.uHj.remove(parama);
    GMTrace.o(13189710348288L, 98271);
  }
  
  public final Cursor cG(String paramString, int paramInt)
  {
    GMTrace.i(13195347492864L, 98313);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT rconversation.username");
    localStringBuilder.append(" FROM rconversation, rcontact");
    localStringBuilder.append(" WHERE unReadCount > 0");
    localStringBuilder.append(" AND rconversation.username = rcontact.username");
    localStringBuilder.append(bf.mz(paramString));
    localStringBuilder.append(" AND ( type & 512").append(" ) == 0");
    localStringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.k.a.gTI).append(" or parentRef = '' ) ");
    localStringBuilder.append(" AND rcontact.username").append(" != 'officialaccounts')");
    localStringBuilder.append(" ORDER BY flag DESC, conversationTime").append(" DESC ");
    if (paramInt > 0) {
      localStringBuilder.append(" LIMIT ").append(String.valueOf(paramInt));
    }
    paramString = localStringBuilder.toString();
    v.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[] { paramString });
    paramString = this.gUp.rawQuery(paramString, null);
    GMTrace.o(13195347492864L, 98313);
    return paramString;
  }
  
  public final long d(ae paramae)
  {
    GMTrace.i(13191052525568L, 98281);
    String str = bf.mz(paramae.field_username);
    if (str.length() <= 0)
    {
      v.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
      GMTrace.o(13191052525568L, 98281);
      return -1L;
    }
    paramae.t(c(paramae));
    e(paramae);
    long l = this.gUp.insert(Rj(str), null, paramae.pv());
    if (l != -1L) {
      b(2, this, paramae.field_username);
    }
    for (;;)
    {
      GMTrace.o(13191052525568L, 98281);
      return l;
      v.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", new Object[] { Rj(str) });
    }
  }
  
  public final void e(String[] paramArrayOfString, String paramString)
  {
    GMTrace.i(13196555452416L, 98322);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Update rconversation");
    localStringBuilder.append(" set parentRef = '").append(bf.mz(paramString)).append("' where 1 != 1 ");
    int i = 0;
    while (i <= 0)
    {
      paramString = paramArrayOfString[0];
      localStringBuilder.append(" or username = '").append(paramString).append("'");
      i += 1;
    }
    paramString = localStringBuilder.toString();
    v.d("MicroMsg.ConversationStorage", "update sql: %s", new Object[] { paramString });
    if (this.gUp.eE("rconversation", paramString))
    {
      i = 0;
      while (i <= 0)
      {
        b(3, this, paramArrayOfString[0]);
        i += 1;
      }
    }
    GMTrace.o(13196555452416L, 98322);
  }
  
  public final Cursor eK(String paramString1, String paramString2)
  {
    GMTrace.i(13194944839680L, 98310);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select unReadCount");
    localStringBuilder.append(" from rconversation where username").append(" = '").append(paramString1).append("' AND ( parentRef is ").append(com.tencent.mm.k.a.gTI).append(" or parentRef = '' ) ").append(bf.mz(paramString2));
    paramString1 = localStringBuilder.toString();
    paramString1 = this.gUp.rawQuery(paramString1, null);
    GMTrace.o(13194944839680L, 98310);
    return paramString1;
  }
  
  public final boolean f(ae paramae)
  {
    GMTrace.i(13192931573760L, 98295);
    if (paramae == null)
    {
      v.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
      GMTrace.o(13192931573760L, 98295);
      return false;
    }
    boolean bool = this.gUp.eE("rconversation", "update " + Rj(paramae.field_username) + " set flag = " + com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramae, 3, paramae.field_conversationTime) + " where username = \"" + bf.my(paramae.field_username) + "\"");
    if (bool) {
      b(3, this, paramae.field_username);
    }
    GMTrace.o(13192931573760L, 98295);
    return bool;
  }
  
  public final int fM(String paramString)
  {
    int i = 0;
    GMTrace.i(13196152799232L, 98319);
    paramString = "select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + bf.mz(paramString);
    paramString = this.gUp.a(paramString, null, 2);
    if (paramString.moveToFirst()) {
      i = paramString.getInt(0);
    }
    paramString.close();
    GMTrace.o(13196152799232L, 98319);
    return i;
  }
  
  public final boolean g(ae paramae)
  {
    GMTrace.i(13193200009216L, 98297);
    if (paramae == null)
    {
      v.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
      GMTrace.o(13193200009216L, 98297);
      return false;
    }
    if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(paramae, 4, 0L) != 0L)
    {
      GMTrace.o(13193200009216L, 98297);
      return true;
    }
    GMTrace.o(13193200009216L, 98297);
    return false;
  }
  
  public final Cursor j(List<String> paramList, int paramInt)
  {
    GMTrace.i(13194407968768L, 98306);
    String str = "select username from rconversation";
    int i = 0;
    if (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      if (i > 0) {}
      for (str = " and ";; str = " where ")
      {
        str = str + "username != \"" + bf.my((String)paramList.get(i)) + "\"";
        i += 1;
        break;
      }
    }
    paramList = str + " order by flag desc, conversationTime desc limit 50 offset " + paramInt;
    paramList = this.gUp.rawQuery(paramList, null);
    GMTrace.o(13194407968768L, 98306);
    return paramList;
  }
  
  public final as.b oG()
  {
    GMTrace.i(13188905041920L, 98265);
    as.b localb = this.uHg;
    GMTrace.o(13188905041920L, 98265);
    return localb;
  }
  
  public final Cursor p(String paramString, List<String> paramList)
  {
    GMTrace.i(13195079057408L, 98311);
    v.i("MicroMsg.ConversationStorage", "getTotalUnreadCursor filter[%s] [%s]", new Object[] { paramString, bf.bJP() });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select sum(unReadCount) from rconversation").append(", rcontact");
    localStringBuilder.append(" where rconversation.unReadCount").append(" > 0 AND (rconversation.parentRef").append(" is ").append(com.tencent.mm.k.a.gTI).append(" or parentRef = '' ) AND ").append("rconversation.username = ").append("rcontact.username").append(bf.mz(paramString)).append(" AND ( type & 512").append(" ) == 0 AND rcontact.").append("username != 'officialaccounts'");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        localStringBuilder.append(" AND rconversation.username").append(" != '").append(paramList).append("'");
      }
    }
    paramString = localStringBuilder.toString();
    v.v("MicroMsg.ConversationStorage", "get total unread with black list, sql is %s", new Object[] { paramString });
    paramString = this.gUp.rawQuery(paramString, null);
    GMTrace.o(13195079057408L, 98311);
    return paramString;
  }
  
  public final Cursor q(String paramString, List<String> paramList)
  {
    GMTrace.i(13195213275136L, 98312);
    paramList = new StringBuilder();
    paramList.append("SELECT COUNT(rconversation.username)");
    paramList.append(" FROM rconversation, rcontact");
    paramList.append(" WHERE unReadCount > 0");
    paramList.append(" AND rconversation.username = rcontact.username");
    paramList.append(bf.mz(paramString));
    paramList.append(" AND ( type & 512").append(" ) == 0");
    paramList.append(" AND ( attrflag & 2097152 ) == 0");
    paramList.append(" AND ( ( parentRef is ").append(com.tencent.mm.k.a.gTI).append(" or parentRef = '' ) ");
    paramList.append(" AND rcontact.username").append(" != 'officialaccounts')");
    paramString = paramList.toString();
    v.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", new Object[] { paramString });
    paramString = this.gUp.rawQuery(paramString, null);
    GMTrace.o(13195213275136L, 98312);
    return paramString;
  }
  
  public final boolean wR(String paramString)
  {
    GMTrace.i(13194676404224L, 98308);
    paramString = this.gUp.a(Rj(paramString), null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.close();
      GMTrace.o(13194676404224L, 98308);
      return bool;
    }
  }
  
  private static final class a
    extends com.tencent.mm.bn.a<com.tencent.mm.plugin.messenger.foundation.a.e>
    implements com.tencent.mm.plugin.messenger.foundation.a.e
  {
    public a()
    {
      GMTrace.i(13197629194240L, 98330);
      GMTrace.o(13197629194240L, 98330);
    }
    
    public final void a(final au paramau, final ae paramae, final boolean paramBoolean, final c.c paramc)
    {
      GMTrace.i(13197763411968L, 98331);
      a(new a.a() {});
      GMTrace.o(13197763411968L, 98331);
    }
    
    public final void b(final au paramau, final ae paramae, final boolean paramBoolean, final c.c paramc)
    {
      GMTrace.i(13197897629696L, 98332);
      a(new a.a() {});
      GMTrace.o(13197897629696L, 98332);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */