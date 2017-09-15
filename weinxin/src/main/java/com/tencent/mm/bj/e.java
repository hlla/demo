package com.tencent.mm.bj;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import android.util.Pair;
import android.util.StringBuilderPrinter;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.bj.a.f;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.CursorWrapper;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteCursor;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDebug.IOTraceStats;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteTrace;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
  implements DatabaseErrorHandler, SQLiteTrace
{
  private static final SQLiteCipherSpec kDJ;
  private static Map<String, SQLiteDatabase> uJU;
  private static final SharedPreferences uJV;
  private static SQLiteTrace uJZ;
  private static boolean uKa;
  SQLiteDatabase uJS;
  SQLiteDatabase uJT;
  private boolean uJW;
  private boolean uJX;
  private String uJY;
  
  static
  {
    boolean bool = true;
    GMTrace.i(13546729504768L, 100931);
    uJU = new HashMap();
    kDJ = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    SQLiteDatabase.loadLib();
    SQLiteDebug.setIOTraceFlags(0);
    CursorWindow.windowSize(3145728);
    SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("db_config", 0);
    uJV = localSharedPreferences;
    if (localSharedPreferences.getInt("alter_cursor", 0) != 0) {}
    for (;;)
    {
      uKa = bool;
      GMTrace.o(13546729504768L, 100931);
      return;
      bool = false;
    }
  }
  
  public e()
  {
    GMTrace.i(13543776714752L, 100909);
    this.uJS = null;
    this.uJT = null;
    this.uJW = false;
    this.uJX = false;
    this.uJY = null;
    GMTrace.o(13543776714752L, 100909);
  }
  
  public static void Sr(String paramString)
  {
    int i = 0;
    GMTrace.i(13544179367936L, 100912);
    Object localObject1 = new File(paramString);
    Object localObject2 = new File(((File)localObject1).getParentFile(), "corrupted");
    ((File)localObject2).mkdirs();
    localObject1 = new File((File)localObject2, ((File)localObject1).getName()).getAbsolutePath();
    while (i < 7)
    {
      localObject2 = new String[] { "", "-journal", "-wal", ".bak", ".sm", "-vfslog", "-vfslo1" }[i];
      FileOp.aj(paramString + (String)localObject2, (String)localObject1 + (String)localObject2);
      i += 1;
    }
    GMTrace.o(13544179367936L, 100912);
  }
  
  public static void a(SQLiteTrace paramSQLiteTrace)
  {
    GMTrace.i(14898302025728L, 111001);
    uJZ = paramSQLiteTrace;
    GMTrace.o(14898302025728L, 111001);
  }
  
  public static boolean a(e parame, String paramString)
  {
    GMTrace.i(13546595287040L, 100930);
    if ((parame == null) || (paramString == null))
    {
      if (parame == null) {}
      for (boolean bool = true;; bool = false)
      {
        v.e("MicroMsg.MMDataBase", "[arthurdan.checkTableExist] Notice!!! null == db: %b, table: %s", new Object[] { Boolean.valueOf(bool), paramString });
        GMTrace.o(13546595287040L, 100930);
        return false;
      }
    }
    parame = parame.a("select tbl_name from sqlite_master  where type = \"table\" and tbl_name=\"" + paramString + "\"", null, 0);
    if (parame == null)
    {
      GMTrace.o(13546595287040L, 100930);
      return false;
    }
    int i = parame.getCount();
    parame.close();
    if (i > 0)
    {
      GMTrace.o(13546595287040L, 100930);
      return true;
    }
    GMTrace.o(13546595287040L, 100930);
    return false;
  }
  
  public static e aQ(String paramString, boolean paramBoolean)
  {
    GMTrace.i(13544716238848L, 100916);
    e locale = new e();
    if ((paramString == null) || (paramString.length() == 0))
    {
      locale.uJT = SQLiteDatabase.create(null);
      locale.uJW = true;
      if (locale.uJT == null)
      {
        GMTrace.o(13544716238848L, 100916);
        return null;
      }
      GMTrace.o(13544716238848L, 100916);
      return locale;
    }
    int i = 268435456;
    if (paramBoolean) {
      i = 805306368;
    }
    try
    {
      locale.uJT = SQLiteDatabase.openDatabase(paramString, null, i, locale);
      locale.uJT.setTraceCallback(locale);
      if (BaseBuildInfo.ENABLE_STETHO) {
        uJU.put(locale.getPath(), locale.uJT);
      }
      if (locale.uJT == null)
      {
        GMTrace.o(13544716238848L, 100916);
        return null;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      c.oRz.d("DBCantOpen", "DB (" + new File(paramString).getName() + ") can't open: " + bf.g(localSQLiteException), null);
      throw localSQLiteException;
    }
    GMTrace.o(13544716238848L, 100916);
    return localSQLiteException;
  }
  
  public static void ah(Map<String, ?> paramMap)
  {
    GMTrace.i(18923760123904L, 140993);
    if (uJV.getAll().equals(paramMap))
    {
      GMTrace.o(18923760123904L, 140993);
      return;
    }
    SharedPreferences.Editor localEditor = uJV.edit();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof Integer)) {
        localEditor.putInt(str, ((Integer)localObject).intValue());
      } else if ((localObject instanceof Long)) {
        localEditor.putLong(str, ((Long)localObject).longValue());
      } else if ((localObject instanceof Boolean)) {
        localEditor.putBoolean(str, ((Boolean)localObject).booleanValue());
      } else if ((localObject instanceof String)) {
        localEditor.putString(str, localObject.toString());
      } else if ((localObject instanceof Float)) {
        localEditor.putFloat(str, ((Float)localObject).floatValue());
      }
    }
    localEditor.apply();
    GMTrace.o(18923760123904L, 140993);
  }
  
  public static boolean bNC()
  {
    GMTrace.i(18924028559360L, 140995);
    if (uJV.getInt("wal", 0) != 0)
    {
      GMTrace.o(18924028559360L, 140995);
      return true;
    }
    GMTrace.o(18924028559360L, 140995);
    return false;
  }
  
  public static e r(String paramString1, String paramString2, boolean paramBoolean)
  {
    GMTrace.i(13544984674304L, 100918);
    try
    {
      localFile = new File(paramString1 + "-vfslog");
      localObject = new File(paramString1 + "-vfslo1");
      if ((localFile.exists()) && (localFile.length() > 256L)) {
        localFile.delete();
      }
      if ((((File)localObject).exists()) && (((File)localObject).length() > 256L)) {
        ((File)localObject).delete();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          File localFile;
          int i;
          boolean bool;
          ((e)localObject).uJS = SQLiteDatabase.openDatabase(paramString1, paramString2, localFile, null, i, (DatabaseErrorHandler)localObject);
          ((e)localObject).uJS.setTraceCallback((SQLiteTrace)localObject);
          if (BaseBuildInfo.ENABLE_STETHO) {
            uJU.put(((e)localObject).getPath(), ((e)localObject).uJS);
          }
          if (((e)localObject).uJS != null) {
            break;
          }
          GMTrace.o(13544984674304L, 100918);
          return null;
        }
        catch (SQLiteException paramString2)
        {
          SQLiteCipherSpec localSQLiteCipherSpec;
          c.oRz.d("DBCantOpen", "DB (" + new File(paramString1).getName() + ") can't open: " + bf.g(paramString2), null);
          throw paramString2;
        }
        localThrowable = localThrowable;
        v.printErrStackTrace("MicroMsg.MMDataBase", localThrowable, "", new Object[0]);
        continue;
        continue;
        paramString2 = paramString2.getBytes();
        localSQLiteCipherSpec = kDJ;
      }
    }
    Object localObject = new e();
    i = 268435456;
    if (bf.mA(paramString1))
    {
      paramString1 = ":memory:";
      ((e)localObject).uJW = true;
      if (!bf.mA(paramString2)) {
        break label266;
      }
      localFile = null;
      paramString2 = null;
      bool = bNC();
      if ((paramBoolean) || (bool)) {
        i = 805306368;
      }
    }
    label266:
    GMTrace.o(13544984674304L, 100918);
    return (e)localObject;
  }
  
  public final android.database.Cursor a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    GMTrace.i(13545387327488L, 100921);
    SQLiteDatabase localSQLiteDatabase;
    SQLiteDatabase.CursorFactory localCursorFactory;
    if (this.uJS != null)
    {
      localSQLiteDatabase = this.uJS;
      if (paramInt != 4) {
        break label82;
      }
      localCursorFactory = f.FACTORY;
    }
    for (;;)
    {
      paramArrayOfString = localSQLiteDatabase.rawQueryWithFactory(localCursorFactory, paramString, paramArrayOfString, null);
      if ((paramInt != 0) && (paramInt != 4)) {}
      for (paramString = new a(paramArrayOfString, paramString);; paramString = paramArrayOfString)
      {
        GMTrace.o(13545387327488L, 100921);
        return paramString;
        localSQLiteDatabase = this.uJT;
        break;
        label82:
        if ((!b.bIk()) && (!uKa)) {
          break label175;
        }
        switch (paramInt)
        {
        default: 
          localCursorFactory = null;
          break;
        case 0: 
          localCursorFactory = null;
          break;
        case 1: 
          localCursorFactory = SQLiteCursor.FACTORY;
          break;
        case 2: 
          localCursorFactory = SQLiteDirectCursor.FACTORY;
          break;
        case 3: 
          localCursorFactory = null;
          break;
        case 4: 
          localCursorFactory = f.FACTORY;
          break;
        }
      }
      label175:
      localCursorFactory = null;
    }
  }
  
  public final android.database.Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    GMTrace.i(13545655762944L, 100923);
    SQLiteDatabase localSQLiteDatabase;
    SQLiteDatabase.CursorFactory localCursorFactory;
    if (this.uJS != null)
    {
      localSQLiteDatabase = this.uJS;
      localCursorFactory = null;
      if (paramInt != 4) {
        break label98;
      }
      localCursorFactory = f.FACTORY;
      label36:
      paramArrayOfString1 = localSQLiteDatabase.queryWithFactory(localCursorFactory, false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, null);
      if ((paramInt == 0) || (paramInt == 4)) {
        break label190;
      }
    }
    label98:
    label190:
    for (paramString1 = new a(paramArrayOfString1, paramString1);; paramString1 = paramArrayOfString1)
    {
      GMTrace.o(13545655762944L, 100923);
      return paramString1;
      localSQLiteDatabase = this.uJT;
      break;
      if ((!b.bIk()) && (!uKa)) {
        break label36;
      }
      switch (paramInt)
      {
      default: 
        localCursorFactory = null;
        break;
      case 0: 
        localCursorFactory = null;
        break;
      case 1: 
        localCursorFactory = SQLiteCursor.FACTORY;
        break;
      case 2: 
        localCursorFactory = SQLiteDirectCursor.FACTORY;
        break;
      case 3: 
        localCursorFactory = null;
        break;
      case 4: 
        localCursorFactory = f.FACTORY;
        break;
      }
    }
  }
  
  public final void beginTransaction()
  {
    GMTrace.i(13546326851584L, 100928);
    try
    {
      if (this.uJS != null)
      {
        this.uJS.beginTransaction();
        GMTrace.o(13546326851584L, 100928);
        return;
      }
      this.uJT.beginTransaction();
      GMTrace.o(13546326851584L, 100928);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.MMDataBase", localException, "", new Object[0]);
      GMTrace.o(13546326851584L, 100928);
    }
  }
  
  public final void close()
  {
    GMTrace.i(13545253109760L, 100920);
    try
    {
      if ((this.uJS != null) && (this.uJS.isOpen()))
      {
        this.uJS.close();
        this.uJS = null;
      }
      if ((this.uJT != null) && (this.uJT.isOpen()))
      {
        this.uJT.close();
        this.uJT = null;
      }
      GMTrace.o(13545253109760L, 100920);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.MMDataBase", "exception:%s", new Object[] { bf.g(localException) });
      GMTrace.o(13545253109760L, 100920);
    }
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    GMTrace.i(13546192633856L, 100927);
    if (this.uJS != null)
    {
      i = this.uJS.delete(paramString1, paramString2, paramArrayOfString);
      GMTrace.o(13546192633856L, 100927);
      return i;
    }
    int i = this.uJT.delete(paramString1, paramString2, paramArrayOfString);
    GMTrace.o(13546192633856L, 100927);
    return i;
  }
  
  public final void endTransaction()
  {
    GMTrace.i(13546461069312L, 100929);
    try
    {
      if (this.uJS != null)
      {
        this.uJS.setTransactionSuccessful();
        this.uJS.endTransaction();
        GMTrace.o(13546461069312L, 100929);
        return;
      }
      this.uJT.setTransactionSuccessful();
      this.uJT.endTransaction();
      GMTrace.o(13546461069312L, 100929);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.MMDataBase", localException, "", new Object[0]);
      GMTrace.o(13546461069312L, 100929);
    }
  }
  
  public final void execSQL(String paramString)
  {
    GMTrace.i(13545521545216L, 100922);
    if (this.uJS != null)
    {
      this.uJS.execSQL(paramString);
      GMTrace.o(13545521545216L, 100922);
      return;
    }
    this.uJT.execSQL(paramString);
    GMTrace.o(13545521545216L, 100922);
  }
  
  public final String getPath()
  {
    GMTrace.i(13544850456576L, 100917);
    if (this.uJS != null)
    {
      str = this.uJS.getPath();
      GMTrace.o(13544850456576L, 100917);
      return str;
    }
    String str = this.uJT.getPath();
    GMTrace.o(13544850456576L, 100917);
    return str;
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    GMTrace.i(13545789980672L, 100924);
    if (this.uJS != null)
    {
      l = this.uJS.insert(paramString1, paramString2, paramContentValues);
      GMTrace.o(13545789980672L, 100924);
      return l;
    }
    long l = this.uJT.insert(paramString1, paramString2, paramContentValues);
    GMTrace.o(13545789980672L, 100924);
    return l;
  }
  
  public final boolean isOpen()
  {
    GMTrace.i(13545118892032L, 100919);
    boolean bool;
    if (this.uJS != null)
    {
      bool = this.uJS.isOpen();
      GMTrace.o(13545118892032L, 100919);
      return bool;
    }
    if (this.uJT != null)
    {
      bool = this.uJT.isOpen();
      GMTrace.o(13545118892032L, 100919);
      return bool;
    }
    GMTrace.o(13545118892032L, 100919);
    return false;
  }
  
  public final void onConnectionObtained(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong, boolean paramBoolean)
  {
    GMTrace.i(18923894341632L, 140994);
    int i;
    if ((paramLong > 10L) && (paramSQLiteDatabase.getPath().endsWith("EnMicroMsg.db")))
    {
      if (!paramSQLiteDatabase.isWriteAheadLoggingEnabled()) {
        break label88;
      }
      i = 0;
      if (!paramBoolean) {
        break label94;
      }
    }
    label88:
    label94:
    for (int j = 0;; j = 6)
    {
      i = i + 36 + j;
      c.oRz.c(463, i + 1, i + 2, (int)paramLong, false);
      GMTrace.o(18923894341632L, 140994);
      return;
      i = 3;
      break;
    }
  }
  
  public final void onConnectionPoolBusy(SQLiteDatabase paramSQLiteDatabase, String paramString1, List<String> paramList, String paramString2)
  {
    GMTrace.i(14898704678912L, 111004);
    if ((this.uJY != null) && (this.uJY.equals(paramString1)))
    {
      GMTrace.o(14898704678912L, 111004);
      return;
    }
    this.uJY = paramString1;
    StringBuilder localStringBuilder = new StringBuilder(2048);
    localStringBuilder.append("Waiting SQL: ").append(paramString1).append('\n').append("Running SQL: \n");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localStringBuilder.append("  ").append(str).append('\n');
    }
    paramList = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    try
    {
      paramSQLiteDatabase.dump(new StringBuilderPrinter(localStringBuilder), false);
      paramSQLiteDatabase = new HashMap();
      paramSQLiteDatabase.put("SQL", paramString1);
      paramSQLiteDatabase.put("message", localStringBuilder.toString());
      c.oRz.d("DBPoolBusy", paramList, paramSQLiteDatabase);
      c.oRz.a(463L, 6L, 1L, false);
      GMTrace.o(14898704678912L, 111004);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        localStringBuilder.append(paramSQLiteDatabase.getMessage()).append('\n').append(paramString2);
      }
    }
  }
  
  public final void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    GMTrace.i(14898436243456L, 111002);
    boolean bool = paramSQLiteDatabase.isOpen();
    String str2 = paramSQLiteDatabase.getPath();
    v.e("MicroMsg.MMDataBase", "Database corrupted, isOpen: %s, path: %s", new Object[] { Boolean.toString(bool), str2 });
    List localList = paramSQLiteDatabase.getAttachedDbs();
    int i;
    if (!this.uJX)
    {
      this.uJX = true;
      i = SQLiteDebug.getLastErrorLine();
      localObject1 = SQLiteDebug.getLastIOTraceStats();
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {}
    }
    else
    {
      if (bool) {
        break label707;
      }
      GMTrace.o(14898436243456L, 111002);
      return;
    }
    Object localObject4 = (SQLiteDebug.IOTraceStats)((ArrayList)localObject1).get(0);
    Object localObject1 = "";
    try
    {
      h.vG();
      int j = a.uH();
      localObject2 = p.rA();
      localObject2 = g.n(((String)localObject2 + j).getBytes()).substring(0, 7);
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject2;
        v.printErrStackTrace("MicroMsg.MMDataBase", localException1, "Failed to get hash.", new Object[0]);
        continue;
        v.w("MicroMsg.MMDataBase", "Battery info not present.");
      }
    }
    localObject2 = "";
    try
    {
      localObject3 = aa.getContext().getFilesDir().getAbsolutePath() + "/battery.bin";
      if (!FileOp.aO((String)localObject3)) {
        break label677;
      }
      localObject3 = FileOp.c((String)localObject3, 0, -1);
      localObject5 = Parcel.obtain();
      ((Parcel)localObject5).unmarshall((byte[])localObject3, 0, localObject3.length);
      ((Parcel)localObject5).setDataPosition(0);
      localObject3 = ((Parcel)localObject5).readBundle();
      localObject5 = new StringBuilder(1024);
      ((StringBuilder)localObject5).append("level: ").append(((Bundle)localObject3).getInt("level", -1)).append('\n');
      ((StringBuilder)localObject5).append("scale: ").append(((Bundle)localObject3).getInt("scale", -1)).append('\n');
      ((StringBuilder)localObject5).append("health: ").append(((Bundle)localObject3).getInt("health")).append('\n');
      ((StringBuilder)localObject5).append("status: ").append(((Bundle)localObject3).getInt("status")).append('\n');
      ((StringBuilder)localObject5).append("voltage: ").append(((Bundle)localObject3).getInt("voltage")).append('\n');
      ((StringBuilder)localObject5).append("temperature: ").append(((Bundle)localObject3).getInt("temperature")).append('\n');
      ((StringBuilder)localObject5).append("plugged: ").append(((Bundle)localObject3).getInt("plugged")).append('\n');
      localObject3 = ((StringBuilder)localObject5).toString();
      localObject2 = localObject3;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject5;
        v.printErrStackTrace("MicroMsg.MMDataBase", localException2, "Failed to get battery info.", new Object[0]);
      }
    }
    localObject5 = String.format("DB corrupted (line: %d, hash: %s, open: %s) => %s", new Object[] { Integer.valueOf(i), localObject1, Boolean.toString(bool), ((SQLiteDebug.IOTraceStats)localObject4).toString() });
    localObject1 = "";
    if (((SQLiteDebug.IOTraceStats)localObject4).lastReadPage != null) {
      localObject1 = Base64.encodeToString(((SQLiteDebug.IOTraceStats)localObject4).lastReadPage, 2);
    }
    if (((SQLiteDebug.IOTraceStats)localObject4).lastJournalReadPage != null) {}
    label677:
    label707:
    String str1;
    for (localObject3 = Base64.encodeToString(((SQLiteDebug.IOTraceStats)localObject4).lastJournalReadPage, 2);; str1 = "")
    {
      localObject4 = new HashMap();
      ((HashMap)localObject4).put("lastReadPage", localObject1);
      ((HashMap)localObject4).put("lastJournalReadPage", localObject3);
      ((HashMap)localObject4).put("batteryInfo", localObject2);
      c.oRz.d("DBCorrupt", (String)localObject5, (Map)localObject4);
      v.e("MMDB.CorruptionDumper", ">>> DUMP CORRUPTED DATABASE <<<\n" + (String)localObject5);
      v.e("MMDB.CorruptionDumper", "> LAST READ PAGE:\n" + (String)localObject1);
      v.e("MMDB.CorruptionDumper", "> LAST READ JOURNAL:\n" + (String)localObject3);
      break;
      if (paramSQLiteDatabase.isWriteAheadLoggingEnabled()) {}
      for (i = 41;; i = 42)
      {
        c.oRz.a(181L, i, 1L, true);
        paramSQLiteDatabase.close();
        if (localList != null) {
          break;
        }
        Sr(str2);
        GMTrace.o(14898436243456L, 111002);
        return;
      }
      paramSQLiteDatabase = localList.iterator();
      while (paramSQLiteDatabase.hasNext()) {
        Sr((String)((Pair)paramSQLiteDatabase.next()).second);
      }
      GMTrace.o(14898436243456L, 111002);
      return;
    }
  }
  
  public final void onDatabaseCorrupted(SQLiteDatabase paramSQLiteDatabase)
  {
    GMTrace.i(14898838896640L, 111005);
    GMTrace.o(14898838896640L, 111005);
  }
  
  public final void onSQLExecuted(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, long paramLong)
  {
    GMTrace.i(14898570461184L, 111003);
    int i;
    if ((paramLong > 10L) && (paramSQLiteDatabase.getPath().endsWith("EnMicroMsg.db")))
    {
      if (!paramSQLiteDatabase.isWriteAheadLoggingEnabled()) {
        break label109;
      }
      i = 0;
      if (paramInt != 1) {
        break label115;
      }
    }
    label109:
    label115:
    for (int j = 0;; j = 6)
    {
      i = i + 24 + j;
      c.oRz.c(463, i + 1, i + 2, (int)paramLong, false);
      if (uJZ != null) {
        uJZ.onSQLExecuted(paramSQLiteDatabase, paramString, paramInt, paramLong);
      }
      GMTrace.o(14898570461184L, 111003);
      return;
      i = 3;
      break;
    }
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    GMTrace.i(13546058416128L, 100926);
    if (this.uJS != null)
    {
      l = this.uJS.replace(paramString1, paramString2, paramContentValues);
      GMTrace.o(13546058416128L, 100926);
      return l;
    }
    long l = this.uJT.replace(paramString1, paramString2, paramContentValues);
    GMTrace.o(13546058416128L, 100926);
    return l;
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    GMTrace.i(13545924198400L, 100925);
    if (this.uJS != null)
    {
      i = this.uJS.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      GMTrace.o(13545924198400L, 100925);
      return i;
    }
    int i = this.uJT.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
    GMTrace.o(13545924198400L, 100925);
    return i;
  }
  
  private static final class a
    extends CursorWrapper
  {
    private long mCreateTime;
    private int uKb;
    private String uKc;
    
    public a(com.tencent.wcdb.Cursor paramCursor, String paramString)
    {
      super();
      GMTrace.i(14898973114368L, 111006);
      this.uKc = paramString;
      if ((paramCursor instanceof SQLiteDirectCursor)) {
        this.uKb = 2;
      }
      for (;;)
      {
        this.mCreateTime = System.nanoTime();
        v.d("MicroMsg.MMDataBase", "TimingCursor opened, SQL: %s, hash: %d", new Object[] { this.uKc, Integer.valueOf(hashCode()) });
        GMTrace.o(14898973114368L, 111006);
        return;
        if ((paramCursor instanceof SQLiteCursor)) {
          this.uKb = 1;
        } else {
          this.uKb = -1;
        }
      }
    }
    
    public final void close()
    {
      GMTrace.i(13546997940224L, 100933);
      this.mCursor.close();
      long l = (System.nanoTime() - this.mCreateTime) / 1000L;
      int i = this.uKb;
      String str;
      if (this.uKc == null)
      {
        str = "(query)";
        v.d("MicroMsg.MMDataBase", "TimingCursor closed, mode: %d, time : %d us, SQL: %s, hash: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l), str, Integer.valueOf(hashCode()) });
        if (this.uKb != 1) {
          break label136;
        }
        i = 0;
      }
      for (;;)
      {
        if (i >= 0) {
          c.oRz.c(463, i + 1, i + 2, (int)l, false);
        }
        GMTrace.o(13546997940224L, 100933);
        return;
        str = this.uKc;
        break;
        label136:
        if (this.uKb == 2) {
          i = 3;
        } else {
          i = -1;
        }
      }
    }
    
    public final int getCount()
    {
      GMTrace.i(13547132157952L, 100934);
      v.w("MicroMsg.MMDataBase", "Slow operation: " + bf.g(new Throwable()));
      int i = this.mCursor.getCount();
      GMTrace.o(13547132157952L, 100934);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bj/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */