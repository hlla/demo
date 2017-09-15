package com.tencent.mm.bj;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.k;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class a
{
  private static final Pattern uJI;
  String arH;
  private String fOW;
  e uJJ;
  String uJK;
  public boolean uJL;
  private boolean uJM;
  String uJN;
  
  static
  {
    GMTrace.i(13543642497024L, 100908);
    uJI = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    GMTrace.o(13543642497024L, 100908);
  }
  
  public a()
  {
    GMTrace.i(13542300319744L, 100898);
    this.uJK = "";
    this.uJL = false;
    this.uJM = false;
    this.uJN = "";
    this.fOW = "";
    GMTrace.o(13542300319744L, 100898);
  }
  
  private static void a(e parame)
  {
    GMTrace.i(13543239843840L, 100905);
    if (parame.uJS != null) {}
    for (parame = parame.uJS;; parame = parame.uJT)
    {
      parame = parame.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
      if (parame.moveToFirst()) {
        break;
      }
      throw new SQLiteException("Cannot get count for sqlite_master");
    }
    parame.close();
    GMTrace.o(13543239843840L, 100905);
  }
  
  private boolean a(String paramString1, long paramLong, String paramString2, boolean paramBoolean, String paramString3)
  {
    GMTrace.i(18924162777088L, 140996);
    if (this.uJJ != null) {
      throw new AssertionError();
    }
    this.arH = g.n((paramString2 + paramLong).getBytes()).substring(0, 7);
    if (!FileOp.aO(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.uJM = bool;
      try
      {
        this.uJJ = e.r(paramString1, this.arH, paramBoolean);
        a(this.uJJ);
        GMTrace.o(18924162777088L, 140996);
        return true;
      }
      catch (SQLiteException localSQLiteException)
      {
        if (!(localSQLiteException instanceof SQLiteDatabaseCorruptException)) {
          break;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString3 = p.getDeviceID(aa.getContext());
        int j = i;
        if (paramString3 != null)
        {
          j = i;
          if (!paramString3.equals(paramString2))
          {
            j = 0;
            paramString2 = g.n((paramString3 + paramLong).getBytes()).substring(0, 7);
            try
            {
              this.uJJ = e.r(paramString1, paramString2, paramBoolean);
              a(this.uJJ);
              this.arH = paramString2;
              k.rj().set(258, paramString3);
              c.oRz.a(181L, 5L, 1L, false);
              GMTrace.o(18924162777088L, 140996);
              return true;
            }
            catch (SQLiteException paramString2)
            {
              if ((paramString2 instanceof SQLiteDatabaseCorruptException)) {
                j = 1;
              }
            }
          }
        }
        if ((this.uJJ == null) && (j != 0))
        {
          if (paramBoolean) {}
          for (i = 41;; i = 42)
          {
            c.oRz.a(181L, i, 1L, true);
            e.Sr(paramString1);
            try
            {
              this.uJJ = e.r(paramString1, this.arH, paramBoolean);
              a(this.uJJ);
              this.uJM = true;
              c.oRz.a(181L, 6L, 1L, false);
              GMTrace.o(18924162777088L, 140996);
              return true;
            }
            catch (SQLiteException paramString1)
            {
              c.oRz.a(181L, 7L, 1L, false);
            }
          }
        }
      }
      for (;;)
      {
        if (this.uJJ != null)
        {
          this.uJJ.close();
          this.uJJ = null;
        }
        this.arH = null;
        GMTrace.o(18924162777088L, 140996);
        return false;
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          if (!FileOp.aO(paramString3)) {}
          for (bool = true;; bool = false)
          {
            this.uJM = bool;
            try
            {
              this.uJJ = e.r(paramString3, this.arH, paramBoolean);
              a(this.uJJ);
              c.oRz.a(181L, 6L, 1L, false);
              GMTrace.o(18924162777088L, 140996);
              return true;
            }
            catch (SQLiteException paramString1)
            {
              c.oRz.a(181L, 7L, 1L, false);
            }
          }
        }
      }
    }
  }
  
  private boolean a(HashMap<Integer, g.c> paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13543508279296L, 100907);
    if (paramHashMap == null) {}
    Object localObject3;
    for (int i = -1;; i = paramHashMap.size())
    {
      v.d("MicroMsg.DBInit", "createtables checkCreateIni:%b  tables:%d", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(i) });
      localObject1 = "";
      if (!paramBoolean1) {
        break label332;
      }
      this.uJK = (this.uJJ.getPath() + ".ini");
      localObject1 = new StringBuilder();
      if (paramHashMap == null) {
        break;
      }
      localObject2 = paramHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (g.c)((Iterator)localObject2).next();
        if (((g.c)localObject3).pP() == null)
        {
          v.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", new Object[] { localObject3.getClass().toString() });
          Assert.assertTrue("factory.getSQLs() is null:" + localObject3.getClass().toString(), false);
        }
        localObject3 = ((g.c)localObject3).pP();
        j = localObject3.length;
        i = 0;
        while (i < j)
        {
          ((StringBuilder)localObject1).append(localObject3[i].hashCode());
          i += 1;
        }
      }
    }
    Object localObject2 = g.n(((StringBuilder)localObject1).toString().getBytes());
    Object localObject1 = localObject2;
    if (!paramBoolean2)
    {
      localObject3 = com.tencent.mm.sdk.e.a.getValue(this.uJK, "createmd5");
      localObject1 = localObject2;
      if (!bf.mA((String)localObject3))
      {
        localObject1 = localObject2;
        if (((String)localObject2).equals(localObject3))
        {
          v.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", new Object[] { this.uJJ.getPath() });
          GMTrace.o(13543508279296L, 100907);
          return true;
        }
      }
    }
    label332:
    this.uJJ.execSQL("pragma auto_vacuum = 0 ");
    localObject2 = new g.a();
    this.uJJ.beginTransaction();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.values().iterator();
      i = 0;
      String str;
      label566:
      for (;;)
      {
        j = i;
        if (!paramHashMap.hasNext()) {
          break;
        }
        localObject3 = ((g.c)paramHashMap.next()).pP();
        int k = localObject3.length;
        j = 0;
        for (;;)
        {
          if (j >= k) {
            break label566;
          }
          str = localObject3[j];
          try
          {
            this.uJJ.execSQL(str);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Matcher localMatcher = uJI.matcher(str);
              if ((localMatcher != null) && (localMatcher.matches())) {
                Assert.assertTrue("CreateTable failed:[" + str + "][" + localException.getMessage() + "]", false);
              } else {
                v.w("MicroMsg.DBInit", "CreateTable failed:[" + str + "][" + localException.getMessage() + "]");
              }
            }
          }
          j += 1;
        }
      }
    }
    int j = 0;
    long l = ((g.a)localObject2).se();
    this.uJJ.endTransaction();
    v.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", new Object[] { Long.valueOf(l), Long.valueOf(((g.a)localObject2).se()), Integer.valueOf(j) });
    if (paramBoolean1) {
      com.tencent.mm.sdk.e.a.aa(this.uJK, "createmd5", (String)localObject1);
    }
    GMTrace.o(13543508279296L, 100907);
    return true;
  }
  
  private void eO(String paramString1, String paramString2)
  {
    GMTrace.i(13542568755200L, 100900);
    HashSet localHashSet = new HashSet();
    Object localObject = this.uJJ.a("select * from " + paramString1 + " limit 1 ", null, 0);
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      GMTrace.o(13542568755200L, 100900);
      return;
    }
    ((Cursor)localObject).moveToFirst();
    int i = 0;
    while (i < ((Cursor)localObject).getColumnCount())
    {
      localHashSet.add(((Cursor)localObject).getColumnName(i));
      i += 1;
    }
    ((Cursor)localObject).close();
    Cursor localCursor = this.uJJ.a("PRAGMA table_info( " + paramString2 + " )", null, 0);
    localObject = "";
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("name"));
      if (localHashSet.contains(str))
      {
        localObject = (String)localObject + str;
        localObject = (String)localObject + ",";
      }
    }
    localCursor.close();
    localObject = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    paramString1 = "insert into " + paramString2 + "(" + (String)localObject + ") select " + (String)localObject + " from " + paramString1 + ";";
    this.uJJ.execSQL(paramString1);
    GMTrace.o(13542568755200L, 100900);
  }
  
  private boolean eP(String paramString1, String paramString2)
  {
    GMTrace.i(13542702972928L, 100901);
    Cursor localCursor = this.uJJ.a("select DISTINCT  tbl_name from sqlite_master;", null, 0);
    if (localCursor == null)
    {
      GMTrace.o(13542702972928L, 100901);
      return false;
    }
    for (;;)
    {
      try
      {
        if (bf.mA(paramString2))
        {
          this.uJJ.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY ''");
          this.uJJ.beginTransaction();
          int i = 0;
          if (i >= localCursor.getCount()) {
            break label349;
          }
          localCursor.moveToPosition(i);
          paramString1 = this.uJJ.a("select * from old.sqlite_master where tbl_name = '" + localCursor.getString(0) + "'", null, 0);
          if (paramString1 == null) {
            break label384;
          }
          j = paramString1.getCount();
          paramString1.close();
          if (j == 0)
          {
            v.w("MicroMsg.DBInit", "In old db not found :" + localCursor.getString(0));
            i += 1;
            continue;
          }
        }
        else
        {
          this.uJJ.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY '" + paramString2 + "'");
          continue;
        }
        try
        {
          eO("old." + localCursor.getString(0), localCursor.getString(0));
        }
        catch (Exception paramString1)
        {
          v.w("MicroMsg.DBInit", "Insertselect FAILED :" + localCursor.getString(0));
        }
      }
      catch (SQLiteDatabaseCorruptException paramString2)
      {
        v.e("MicroMsg.DBInit", "Attached database is corrupted: " + paramString1);
        FileOp.deleteFile(paramString1);
        throw paramString2;
      }
      continue;
      label349:
      this.uJJ.endTransaction();
      localCursor.close();
      this.uJJ.execSQL("DETACH DATABASE old;");
      GMTrace.o(13542702972928L, 100901);
      return true;
      label384:
      int j = 0;
    }
  }
  
  private boolean eQ(String paramString1, String paramString2)
  {
    GMTrace.i(13543105626112L, 100904);
    if (eP(paramString1, paramString2))
    {
      v.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", new Object[] { paramString1 });
      v.i("MicroMsg.DBInit", "delete result :%b", new Object[] { Boolean.valueOf(b.deleteFile(paramString1)) });
      GMTrace.o(13543105626112L, 100904);
      return true;
    }
    v.i("MicroMsg.DBInit", "system transfer fail path %s", new Object[] { paramString1 });
    GMTrace.o(13543105626112L, 100904);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, HashMap<Integer, g.c> paramHashMap, boolean paramBoolean)
  {
    GMTrace.i(13542971408384L, 100903);
    boolean bool1;
    boolean bool3;
    boolean bool4;
    int i;
    label101:
    label134:
    int j;
    if (!bf.mA(paramString2))
    {
      bool1 = true;
      Assert.assertTrue("create SqliteDB enDbCachePath == null ", bool1);
      this.uJN = (paramString2 + ".errreport");
      if (this.uJJ != null)
      {
        this.uJJ.close();
        this.uJJ = null;
      }
      boolean bool2 = com.tencent.mm.a.e.aO(paramString2);
      bool3 = com.tencent.mm.a.e.aO(paramString1);
      bool4 = com.tencent.mm.a.e.aO(paramString3);
      if ((bool2) || (!bool3)) {
        break label277;
      }
      i = 1;
      this.uJL = a(paramString2, paramLong, paramString4, e.bNC(), paramString3);
      boolean bool5 = this.uJL;
      if (this.uJJ == null) {
        break label283;
      }
      bool1 = true;
      v.i("MicroMsg.DBInit", "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s", new Object[] { paramString2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(true), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Thread.currentThread().getName() });
      if ((this.uJJ == null) || (this.uJJ.getPath().equals(paramString3)) || (!bool4)) {
        break label403;
      }
      j = 1;
      v.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
    }
    for (;;)
    {
      a(paramHashMap, paramBoolean, this.uJM);
      if ((!bool3) && (!bool4))
      {
        GMTrace.o(13542971408384L, 100903);
        return true;
        bool1 = false;
        break;
        label277:
        i = 0;
        break label101;
        label283:
        bool1 = false;
        break label134;
      }
      if (j != 0)
      {
        this.arH = g.n((paramString4 + paramLong).getBytes()).substring(0, 7);
        eQ(paramString3, this.arH);
      }
      if (i != 0)
      {
        System.currentTimeMillis();
        paramBoolean = eQ(paramString1, "");
        System.currentTimeMillis();
        GMTrace.o(13542971408384L, 100903);
        return paramBoolean;
      }
      if (this.uJJ != null)
      {
        GMTrace.o(13542971408384L, 100903);
        return true;
      }
      GMTrace.o(13542971408384L, 100903);
      return false;
      label403:
      j = 0;
    }
  }
  
  public final boolean a(String paramString, HashMap<Integer, g.c> paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13542837190656L, 100902);
    if (this.uJJ != null)
    {
      this.uJJ.close();
      this.uJJ = null;
    }
    boolean bool = com.tencent.mm.a.e.aO(paramString);
    for (;;)
    {
      try
      {
        v.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), paramString });
        this.uJJ = e.aQ(paramString, paramBoolean2);
        if (!bool)
        {
          paramBoolean2 = true;
          a(paramHashMap, paramBoolean1, paramBoolean2);
          GMTrace.o(13542837190656L, 100902);
          return true;
        }
      }
      catch (SQLiteException paramString)
      {
        GMTrace.o(13542837190656L, 100902);
        return false;
      }
      paramBoolean2 = false;
    }
  }
  
  public final String getError()
  {
    GMTrace.i(13542434537472L, 100899);
    if ((bf.mA(this.fOW)) || (bf.mA(this.uJN)))
    {
      GMTrace.o(13542434537472L, 100899);
      return "";
    }
    if (!bf.mA(com.tencent.mm.sdk.e.a.getValue(this.uJN, "Reported")))
    {
      GMTrace.o(13542434537472L, 100899);
      return "";
    }
    com.tencent.mm.sdk.e.a.aa(this.uJN, "Reported", "true");
    String str = this.fOW;
    GMTrace.o(13542434537472L, 100899);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bj/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */