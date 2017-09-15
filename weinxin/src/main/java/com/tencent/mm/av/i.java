package com.tencent.mm.av;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.bz;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.x.b;
import java.util.ArrayList;

public final class i
  extends com.tencent.mm.sdk.e.i<h>
{
  public static final String[] gUn;
  public e gUp;
  
  static
  {
    GMTrace.i(1415997030400L, 10550);
    gUn = new String[] { com.tencent.mm.sdk.e.i.a(h.gTF, "LBSVerifyMessage") };
    GMTrace.o(1415997030400L, 10550);
  }
  
  public i(e parame)
  {
    super(parame, h.gTF, "LBSVerifyMessage", bz.gaA);
    GMTrace.i(1413849546752L, 10534);
    this.gUp = parame;
    GMTrace.o(1413849546752L, 10534);
  }
  
  public static long li(String paramString)
  {
    Object localObject = null;
    GMTrace.i(1415728594944L, 10548);
    long l2 = 0L;
    long l1 = l2;
    Cursor localCursor;
    if (paramString != null)
    {
      paramString = l.KA();
      localCursor = paramString.gUp.a("SELECT * FROM " + paramString.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
      if (localCursor != null) {
        break label103;
      }
      paramString = (String)localObject;
    }
    for (;;)
    {
      l1 = l2;
      if (paramString != null) {
        l1 = paramString.field_createtime + 1L;
      }
      l2 = bf.Nz();
      if (l1 <= l2) {
        break;
      }
      GMTrace.o(1415728594944L, 10548);
      return l1;
      label103:
      if (!localCursor.moveToFirst())
      {
        localCursor.close();
        paramString = (String)localObject;
      }
      else
      {
        paramString = new h();
        paramString.b(localCursor);
        localCursor.close();
      }
    }
    GMTrace.o(1415728594944L, 10548);
    return l2;
  }
  
  public final h[] F(String paramString, int paramInt)
  {
    GMTrace.i(1415594377216L, 10547);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
      GMTrace.o(1415594377216L, 10547);
      return null;
    }
    paramString = "select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + bf.my(paramString) + "' or sayhiencryptuser = '" + bf.my(paramString) + "') order by createTime DESC limit " + paramInt;
    paramString = this.gUp.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      h localh = new h();
      localh.b(paramString);
      localArrayList.add(localh);
    }
    paramString.close();
    paramString = (h[])localArrayList.toArray(new h[localArrayList.size()]);
    GMTrace.o(1415594377216L, 10547);
    return paramString;
  }
  
  public final int Ks()
  {
    GMTrace.i(1413983764480L, 10535);
    Cursor localCursor = this.gUp.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      GMTrace.o(1413983764480L, 10535);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    GMTrace.o(1413983764480L, 10535);
    return i;
  }
  
  public final h Kt()
  {
    GMTrace.i(1414252199936L, 10537);
    Cursor localCursor = this.gUp.a("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
    if (localCursor == null)
    {
      GMTrace.o(1414252199936L, 10537);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      GMTrace.o(1414252199936L, 10537);
      return null;
    }
    h localh = new h();
    localh.b(localCursor);
    localCursor.close();
    GMTrace.o(1414252199936L, 10537);
    return localh;
  }
  
  public final void Ku()
  {
    GMTrace.i(1414386417664L, 10538);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(4));
    if (this.gUp.update(getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
      doNotify();
    }
    GMTrace.o(1414386417664L, 10538);
  }
  
  public final void Kv()
  {
    GMTrace.i(1414789070848L, 10541);
    this.gUp.delete(getTableName(), null, null);
    GMTrace.o(1414789070848L, 10541);
  }
  
  public final void a(bu parambu, au.d paramd)
  {
    GMTrace.i(1414923288576L, 10542);
    v.d("MicroMsg.LBSVerifyMessageStorage", "saveToVerifyStg, cmdAM, status = " + parambu.jLP + ", id = " + parambu.tdE);
    h localh = new h();
    localh.field_content = n.a(parambu.tdz);
    localh.field_createtime = bf.Nz();
    localh.field_imgpath = "";
    localh.field_sayhicontent = paramd.content;
    localh.field_sayhiuser = paramd.rTh;
    localh.field_scene = paramd.scene;
    if (parambu.jLP > 3) {}
    for (int i = parambu.jLP;; i = 3)
    {
      localh.field_status = i;
      localh.field_svrid = parambu.tdE;
      localh.field_talker = n.a(parambu.tdx);
      localh.field_type = parambu.mrC;
      localh.field_isSend = 0;
      localh.field_sayhiencryptuser = paramd.uIu;
      localh.field_ticket = paramd.orn;
      localh.field_flag = 1;
      a(localh);
      b.u(localh.field_sayhiencryptuser, 3);
      GMTrace.o(1414923288576L, 10542);
      return;
    }
  }
  
  public final boolean a(h paramh)
  {
    GMTrace.i(1415057506304L, 10543);
    if (paramh == null)
    {
      v.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
      GMTrace.o(1415057506304L, 10543);
      return false;
    }
    if (super.b(paramh))
    {
      Qq(paramh.uvp);
      GMTrace.o(1415057506304L, 10543);
      return true;
    }
    GMTrace.o(1415057506304L, 10543);
    return false;
  }
  
  public final int getCount()
  {
    int i = 0;
    GMTrace.i(1414117982208L, 10536);
    Cursor localCursor = this.gUp.a("select count(*) from " + getTableName(), null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    GMTrace.o(1414117982208L, 10536);
    return i;
  }
  
  public final void ld(String paramString)
  {
    GMTrace.i(1414520635392L, 10539);
    paramString = "svrid = '" + paramString + "'";
    int i = this.gUp.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    v.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = " + i);
    GMTrace.o(1414520635392L, 10539);
  }
  
  public final void le(String paramString)
  {
    GMTrace.i(1414654853120L, 10540);
    paramString = "sayhiuser = '" + paramString + "' or sayhiencryptuser='" + paramString + "'";
    int i = this.gUp.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    v.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = " + i);
    GMTrace.o(1414654853120L, 10540);
  }
  
  public final h[] lf(String paramString)
  {
    GMTrace.i(1415191724032L, 10544);
    v.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where sayhiuser = '" + bf.my(paramString) + "' or sayhiencryptuser = '" + bf.my(paramString) + "' order by createtime DESC limit 3";
    paramString = this.gUp.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      h localh = new h();
      localh.b(paramString);
      localArrayList.add(localh);
    }
    paramString.close();
    paramString = (h[])localArrayList.toArray(new h[localArrayList.size()]);
    GMTrace.o(1415191724032L, 10544);
    return paramString;
  }
  
  public final h lg(String paramString)
  {
    Object localObject = null;
    GMTrace.i(1415325941760L, 10545);
    v.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + bf.my(paramString) + "' or sayhiencryptuser = '" + bf.my(paramString) + "') and flag=1 order by createtime DESC limit 1";
    Cursor localCursor = this.gUp.a(paramString, null, 2);
    if (localCursor.moveToFirst())
    {
      paramString = new h();
      paramString.b(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      GMTrace.o(1415325941760L, 10545);
      return paramString;
      v.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
      paramString = (String)localObject;
    }
  }
  
  public final h lh(String paramString)
  {
    GMTrace.i(1415460159488L, 10546);
    paramString = F(paramString, 1);
    if (paramString != null)
    {
      paramString = paramString[0];
      GMTrace.o(1415460159488L, 10546);
      return paramString;
    }
    GMTrace.o(1415460159488L, 10546);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/av/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */