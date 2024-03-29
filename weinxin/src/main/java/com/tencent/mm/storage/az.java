package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class az
  extends j
  implements f.a, com.tencent.mm.plugin.messenger.foundation.a.a.f
{
  public static final String[] gUn;
  private e gUp;
  
  static
  {
    GMTrace.i(13201789943808L, 98361);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )" };
    GMTrace.o(13201789943808L, 98361);
  }
  
  public az(g paramg)
  {
    GMTrace.i(13200045113344L, 98348);
    this.gUp = null;
    this.gUp = paramg;
    GMTrace.o(13200045113344L, 98348);
  }
  
  private ay RU(String paramString)
  {
    Object localObject = null;
    GMTrace.i(13200581984256L, 98352);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ay localay = new ay();
      Cursor localCursor = this.gUp.a("role_info", null, "name= ?", new String[] { paramString }, null, null, null, 2);
      paramString = (String)localObject;
      if (localCursor.moveToFirst())
      {
        localay.b(localCursor);
        paramString = localay;
      }
      localCursor.close();
      GMTrace.o(13200581984256L, 98352);
      return paramString;
    }
  }
  
  private void a(ay paramay)
  {
    GMTrace.i(13200850419712L, 98354);
    paramay.fRM = 135;
    paramay = paramay.pv();
    if ((paramay.size() > 0) && (this.gUp.insert("role_info", "id", paramay) != 0L)) {
      doNotify();
    }
    GMTrace.o(13200850419712L, 98354);
  }
  
  private void b(ay paramay)
  {
    GMTrace.i(13201521508352L, 98359);
    ContentValues localContentValues = paramay.pv();
    if (localContentValues.size() > 0)
    {
      int i = this.gUp.update("role_info", localContentValues, "name like ?", new String[] { paramay.name });
      v.d("MicroMsg.RoleStorage", "update role info, name=" + paramay.name + ", res:" + i);
      if (i > 0) {
        doNotify();
      }
    }
    GMTrace.o(13201521508352L, 98359);
  }
  
  public final ay AF(String paramString)
  {
    Object localObject = null;
    GMTrace.i(13200447766528L, 98351);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13200447766528L, 98351);
      return null;
    }
    ay localay = new ay();
    Cursor localCursor = this.gUp.a("role_info", null, "name LIKE ?", new String[] { "%" + paramString }, null, null, null, 2);
    paramString = (String)localObject;
    if (localCursor.moveToFirst())
    {
      localay.b(localCursor);
      paramString = localay;
    }
    localCursor.close();
    GMTrace.o(13200447766528L, 98351);
    return paramString;
  }
  
  public final int a(com.tencent.mm.bj.f paramf)
  {
    GMTrace.i(13200179331072L, 98349);
    if (paramf != null) {
      this.gUp = paramf;
    }
    GMTrace.o(13200179331072L, 98349);
    return 0;
  }
  
  public final List<ay> aKd()
  {
    GMTrace.i(13200716201984L, 98353);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = this.gUp.a("role_info", null, "int_reserved1=1", null, null, null, null, 2);
    while (localCursor.moveToNext())
    {
      ay localay = new ay();
      localay.b(localCursor);
      localLinkedList.add(localay);
    }
    localCursor.close();
    GMTrace.o(13200716201984L, 98353);
    return localLinkedList;
  }
  
  public final void ab(String paramString, boolean paramBoolean)
  {
    GMTrace.i(13201253072896L, 98357);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      GMTrace.o(13201253072896L, 98357);
      return;
    }
    ay localay = RU(paramString);
    if (localay == null)
    {
      a(new ay(paramString, paramBoolean, 2));
      v.d("MicroMsg.RoleStorage", "insert new role, user=" + paramString);
      GMTrace.o(13201253072896L, 98357);
      return;
    }
    localay.fc(paramBoolean);
    localay.fRM = 4;
    b(localay);
    GMTrace.o(13201253072896L, 98357);
  }
  
  public final void bo(String paramString, int paramInt)
  {
    GMTrace.i(13201118855168L, 98356);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      GMTrace.o(13201118855168L, 98356);
      return;
    }
    if (RU(paramString) == null)
    {
      a(new ay(paramString, true, paramInt));
      v.d("MicroMsg.RoleStorage", "insert new role, user=" + paramString);
    }
    GMTrace.o(13201118855168L, 98356);
  }
  
  public final void c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    GMTrace.i(13201387290624L, 98358);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
      GMTrace.o(13201387290624L, 98358);
      return;
    }
    ay localay = RU(paramString);
    if (localay == null)
    {
      a(new ay(paramString, paramBoolean1, 2));
      v.d("MicroMsg.RoleStorage", "insert new role, user=" + paramString);
      GMTrace.o(13201387290624L, 98358);
      return;
    }
    localay.fc(paramBoolean1);
    int j;
    if (paramBoolean2)
    {
      j = localay.status;
      if (!paramBoolean2) {}
    }
    for (localay.status = (i | j);; localay.status &= 0xFFFFFFFD)
    {
      localay.fRM = 4;
      b(localay);
      GMTrace.o(13201387290624L, 98358);
      return;
      i = 0;
      break;
    }
  }
  
  public final String getTableName()
  {
    GMTrace.i(13200313548800L, 98350);
    GMTrace.o(13200313548800L, 98350);
    return "role_info";
  }
  
  public final void hP(String paramString)
  {
    GMTrace.i(13201655726080L, 98360);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      int i = this.gUp.delete("role_info", "name=?", new String[] { paramString });
      v.d("MicroMsg.RoleStorage", "delete name name :" + paramString + ", res:" + i);
      if (i > 0) {
        doNotify();
      }
      GMTrace.o(13201655726080L, 98360);
      return;
    }
  }
  
  public final boolean has(String paramString)
  {
    GMTrace.i(13200984637440L, 98355);
    ay localay = AF(new ay.a(paramString).RT(""));
    if ((localay != null) && (paramString.equals(localay.name)))
    {
      GMTrace.o(13200984637440L, 98355);
      return true;
    }
    GMTrace.o(13200984637440L, 98355);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */