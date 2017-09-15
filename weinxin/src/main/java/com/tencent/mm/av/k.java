package com.tencent.mm.av;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.x.b;
import java.util.ArrayList;

public final class k
  extends i<j>
{
  public static final String[] gUn;
  public static final String[] gaA;
  public e gUp;
  
  static
  {
    GMTrace.i(1420963086336L, 10587);
    gUn = new String[] { i.a(j.gTF, "shakeverifymessage") };
    gaA = new String[] { "CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )" };
    GMTrace.o(1420963086336L, 10587);
  }
  
  public k(e parame)
  {
    super(parame, j.gTF, "shakeverifymessage", gaA);
    GMTrace.i(1419218255872L, 10574);
    this.gUp = parame;
    GMTrace.o(1419218255872L, 10574);
  }
  
  public static long li(String paramString)
  {
    GMTrace.i(1420694650880L, 10585);
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      paramString = l.KB().Kw();
      l1 = l2;
      if (paramString != null) {
        l1 = paramString.field_createtime + 1L;
      }
    }
    l2 = bf.Nz();
    if (l1 > l2)
    {
      GMTrace.o(1420694650880L, 10585);
      return l1;
    }
    GMTrace.o(1420694650880L, 10585);
    return l2;
  }
  
  public final j[] G(String paramString, int paramInt)
  {
    GMTrace.i(1420426215424L, 10583);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
      GMTrace.o(1420426215424L, 10583);
      return null;
    }
    paramString = "select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + bf.my(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.gUp.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      j localj = new j();
      localj.b(paramString);
      localArrayList.add(localj);
    }
    paramString.close();
    if (localArrayList.size() == 0)
    {
      GMTrace.o(1420426215424L, 10583);
      return null;
    }
    paramString = (j[])localArrayList.toArray(new j[localArrayList.size()]);
    GMTrace.o(1420426215424L, 10583);
    return paramString;
  }
  
  public final int Ks()
  {
    GMTrace.i(1419352473600L, 10575);
    Cursor localCursor = this.gUp.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      GMTrace.o(1419352473600L, 10575);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    if (i > 0)
    {
      GMTrace.o(1419352473600L, 10575);
      return i;
    }
    GMTrace.o(1419352473600L, 10575);
    return 0;
  }
  
  public final void Kv()
  {
    GMTrace.i(1419889344512L, 10579);
    this.gUp.delete(getTableName(), null, null);
    GMTrace.o(1419889344512L, 10579);
  }
  
  public final j Kw()
  {
    GMTrace.i(1419620909056L, 10577);
    Cursor localCursor = this.gUp.a("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
    if (localCursor == null)
    {
      GMTrace.o(1419620909056L, 10577);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      GMTrace.o(1419620909056L, 10577);
      return null;
    }
    j localj = new j();
    localj.b(localCursor);
    localCursor.close();
    GMTrace.o(1419620909056L, 10577);
    return localj;
  }
  
  public final void a(bu parambu, au.d paramd)
  {
    GMTrace.i(1420023562240L, 10580);
    v.d("MicroMsg.ShakeVerifyMessageStorage", "saveToVerifyStg, cmdAM, status = " + parambu.jLP + ", id = " + parambu.tdE);
    j localj = new j();
    localj.field_content = n.a(parambu.tdz);
    localj.field_createtime = bf.Nz();
    localj.field_imgpath = "";
    localj.field_sayhicontent = paramd.content;
    localj.field_sayhiuser = paramd.rTh;
    localj.field_scene = paramd.scene;
    if (parambu.jLP > 3) {}
    for (int i = parambu.jLP;; i = 3)
    {
      localj.field_status = i;
      localj.field_svrid = parambu.tdE;
      localj.field_talker = n.a(parambu.tdx);
      localj.field_type = parambu.mrC;
      localj.field_isSend = 0;
      a(localj);
      b.u(localj.field_sayhiuser, 3);
      GMTrace.o(1420023562240L, 10580);
      return;
    }
  }
  
  public final boolean a(j paramj)
  {
    GMTrace.i(1420157779968L, 10581);
    if (paramj == null)
    {
      v.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
      GMTrace.o(1420157779968L, 10581);
      return false;
    }
    if (super.b(paramj))
    {
      Qq(paramj.uvp);
      GMTrace.o(1420157779968L, 10581);
      return true;
    }
    GMTrace.o(1420157779968L, 10581);
    return false;
  }
  
  public final int getCount()
  {
    GMTrace.i(1419486691328L, 10576);
    Cursor localCursor = this.gUp.a("select count(*) from " + getTableName(), null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      GMTrace.o(1419486691328L, 10576);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    if (i > 0)
    {
      GMTrace.o(1419486691328L, 10576);
      return i;
    }
    GMTrace.o(1419486691328L, 10576);
    return 0;
  }
  
  public final void ld(String paramString)
  {
    GMTrace.i(1419755126784L, 10578);
    paramString = "svrid = '" + paramString + "'";
    int i = this.gUp.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    v.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = " + i);
    GMTrace.o(1419755126784L, 10578);
  }
  
  public final j lj(String paramString)
  {
    GMTrace.i(1420291997696L, 10582);
    paramString = G(paramString, 1);
    if (paramString != null)
    {
      paramString = paramString[0];
      GMTrace.o(1420291997696L, 10582);
      return paramString;
    }
    GMTrace.o(1420291997696L, 10582);
    return null;
  }
  
  public final j[] lk(String paramString)
  {
    GMTrace.i(1420560433152L, 10584);
    v.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
    paramString = "select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + bf.my(paramString) + "' order by createtime DESC limit 3";
    paramString = this.gUp.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      j localj = new j();
      localj.b(paramString);
      localArrayList.add(localj);
    }
    paramString.close();
    if (localArrayList.size() == 0)
    {
      GMTrace.o(1420560433152L, 10584);
      return null;
    }
    paramString = (j[])localArrayList.toArray(new j[localArrayList.size()]);
    GMTrace.o(1420560433152L, 10584);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/av/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */