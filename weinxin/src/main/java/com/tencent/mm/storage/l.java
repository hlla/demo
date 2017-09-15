package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.HashSet;

public final class l
  extends i<k>
{
  public static final String[] gUn;
  private e gUp;
  
  static
  {
    GMTrace.i(17949473636352L, 133734);
    gUn = new String[] { i.a(k.gTF, "BackupRecoverMsgListDataId") };
    GMTrace.o(17949473636352L, 133734);
  }
  
  public l(g paramg)
  {
    super(paramg, k.gTF, "BackupRecoverMsgListDataId", null);
    GMTrace.i(17948534112256L, 133727);
    this.gUp = paramg;
    GMTrace.o(17948534112256L, 133727);
  }
  
  public final String QF(String paramString)
  {
    GMTrace.i(17948668329984L, 133728);
    Object localObject = "SELECT * FROM BackupRecoverMsgListDataId WHERE msgListDataId = \"" + paramString + "\" ";
    v.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId:" + (String)localObject);
    localObject = this.gUp.rawQuery((String)localObject, null);
    if (localObject == null)
    {
      v.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getSessionNameByMsgListDataId failed, msgListDataId:%s", new Object[] { paramString });
      GMTrace.o(17948668329984L, 133728);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new k();
      paramString.b((Cursor)localObject);
      ((Cursor)localObject).close();
      paramString = paramString.field_sessionName;
      GMTrace.o(17948668329984L, 133728);
      return paramString;
    }
    ((Cursor)localObject).close();
    GMTrace.o(17948668329984L, 133728);
    return null;
  }
  
  public final HashMap<String, String> bKD()
  {
    GMTrace.i(17948802547712L, 133729);
    HashMap localHashMap = new HashMap();
    Cursor localCursor = Kl();
    if (localCursor == null)
    {
      v.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
      GMTrace.o(17948802547712L, 133729);
      return localHashMap;
    }
    while (localCursor.moveToNext())
    {
      k localk = new k();
      localk.b(localCursor);
      localHashMap.put(localk.field_msgListDataId, localk.field_sessionName);
    }
    localCursor.close();
    GMTrace.o(17948802547712L, 133729);
    return localHashMap;
  }
  
  public final boolean bKE()
  {
    GMTrace.i(17948936765440L, 133730);
    v.d("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist:" + "SELECT * FROM BackupRecoverMsgListDataId");
    Cursor localCursor = this.gUp.rawQuery("SELECT * FROM BackupRecoverMsgListDataId", null);
    if (localCursor == null)
    {
      v.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "isMsgListDataIdExist failed.");
      GMTrace.o(17948936765440L, 133730);
      return false;
    }
    if (localCursor.getCount() <= 0)
    {
      v.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "No data in BackupRecoverMsgListDataIdStorage.");
      localCursor.close();
      GMTrace.o(17948936765440L, 133730);
      return false;
    }
    localCursor.close();
    GMTrace.o(17948936765440L, 133730);
    return true;
  }
  
  public final HashSet<String> bKF()
  {
    GMTrace.i(17949070983168L, 133731);
    HashSet localHashSet = new HashSet();
    Cursor localCursor = Kl();
    if (localCursor == null)
    {
      v.e("MicroMsg.BackupRecoverMsgListDataIdStorage", "getAllData failed.");
      GMTrace.o(17949070983168L, 133731);
      return localHashSet;
    }
    while (localCursor.moveToNext())
    {
      k localk = new k();
      localk.b(localCursor);
      localHashSet.add(localk.field_sessionName);
    }
    localCursor.close();
    GMTrace.o(17949070983168L, 133731);
    return localHashSet;
  }
  
  public final boolean bKG()
  {
    GMTrace.i(17949205200896L, 133732);
    boolean bool = this.gUp.eE("BackupRecoverMsgListDataId", "delete from BackupRecoverMsgListDataId");
    v.i("MicroMsg.BackupRecoverMsgListDataIdStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    GMTrace.o(17949205200896L, 133732);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */