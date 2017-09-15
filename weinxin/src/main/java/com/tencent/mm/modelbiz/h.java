package com.tencent.mm.modelbiz;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends i<f>
{
  public static final String[] gUn;
  public com.tencent.mm.sdk.e.e gUp;
  
  static
  {
    GMTrace.i(4530519408640L, 33755);
    gUn = new String[] { i.a(f.gTF, "BizKF") };
    GMTrace.o(4530519408640L, 33755);
  }
  
  public h(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, f.gTF, "BizKF", null);
    GMTrace.i(4529579884544L, 33748);
    this.gUp = parame;
    parame.eE("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
    parame.eE("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
    GMTrace.o(4529579884544L, 33748);
  }
  
  public static boolean a(f paramf)
  {
    GMTrace.i(4529848320000L, 33750);
    if (paramf != null)
    {
      if (System.currentTimeMillis() - paramf.field_updateTime >= 86400000L)
      {
        GMTrace.o(4529848320000L, 33750);
        return true;
      }
      GMTrace.o(4529848320000L, 33750);
      return false;
    }
    GMTrace.o(4529848320000L, 33750);
    return false;
  }
  
  private boolean b(f paramf)
  {
    GMTrace.i(4529982537728L, 33751);
    if ((paramf == null) || (bf.mA(paramf.field_openId)) || (bf.mA(paramf.field_brandUsername)))
    {
      v.w("MicroMsg.BizKFStorage", "wrong argument");
      GMTrace.o(4529982537728L, 33751);
      return false;
    }
    ContentValues localContentValues = paramf.pv();
    if (this.gUp.replace("BizKF", f.gTF.uvq, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", new Object[] { paramf.field_openId, paramf.field_brandUsername, Boolean.valueOf(bool) });
      GMTrace.o(4529982537728L, 33751);
      return bool;
    }
  }
  
  public final int d(LinkedList<f> paramLinkedList)
  {
    GMTrace.i(4530250973184L, 33753);
    if (paramLinkedList.size() <= 0)
    {
      v.e("MicroMsg.BizKFStorage", "null kfs");
      GMTrace.o(4530250973184L, 33753);
      return 0;
    }
    if ((this.gUp instanceof g)) {}
    for (long l = ((g)this.gUp).cs(Thread.currentThread().getId());; l = 0L)
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      if (paramLinkedList.hasNext())
      {
        f localf = (f)paramLinkedList.next();
        if ((localf == null) || (!b(localf))) {
          break label156;
        }
        i += 1;
      }
      label156:
      for (;;)
      {
        break;
        if ((this.gUp instanceof g)) {
          com.tencent.mm.kernel.h.vI().gXW.aD(l);
        }
        v.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(i) });
        GMTrace.o(4530250973184L, 33753);
        return i;
      }
    }
  }
  
  public final f ig(String paramString)
  {
    GMTrace.i(4529714102272L, 33749);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(4529714102272L, 33749);
      return null;
    }
    Cursor localCursor = this.gUp.a("BizKF", null, "openId=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      v.w("MicroMsg.BizKFStorage", "get null with openId:" + paramString);
      localCursor.close();
      GMTrace.o(4529714102272L, 33749);
      return null;
    }
    paramString = new f();
    paramString.b(localCursor);
    localCursor.close();
    GMTrace.o(4529714102272L, 33749);
    return paramString;
  }
  
  public final f ih(String paramString)
  {
    GMTrace.i(4530116755456L, 33752);
    if (bf.mA(paramString))
    {
      GMTrace.o(4530116755456L, 33752);
      return null;
    }
    Cursor localCursor = this.gUp.a("BizKF", null, "brandUsername = ? order by kfType desc ", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      v.w("MicroMsg.BizKFStorage", "get null with brandUsername:" + paramString);
      localCursor.close();
      GMTrace.o(4530116755456L, 33752);
      return null;
    }
    paramString = new f();
    paramString.b(localCursor);
    localCursor.close();
    GMTrace.o(4530116755456L, 33752);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */