package com.tencent.mm.bj;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public class g
  implements com.tencent.mm.sdk.e.e
{
  public String TAG;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  private long jAW;
  protected e uJJ;
  private a uKh;
  public a uKi;
  private String uKj;
  public String uKk;
  public final LinkedList<b> uKl;
  private ad uKm;
  
  public g()
  {
    GMTrace.i(13560151277568L, 101031);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.uJJ = null;
    this.uKh = null;
    this.uKi = new a();
    this.uKj = "";
    this.uKk = "";
    this.uKl = new LinkedList();
    this.uKm = null;
    this.jAW = 0L;
    GMTrace.o(13560151277568L, 101031);
  }
  
  public g(a parama)
  {
    GMTrace.i(13560017059840L, 101030);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.TAG = "MicroMsg.SqliteDB";
    this.uJJ = null;
    this.uKh = null;
    this.uKi = new a();
    this.uKj = "";
    this.uKk = "";
    this.uKl = new LinkedList();
    this.uKm = null;
    this.jAW = 0L;
    this.uKh = parama;
    GMTrace.o(13560017059840L, 101030);
  }
  
  private void St(String paramString)
  {
    GMTrace.i(13560822366208L, 101036);
    String str1 = aa.um();
    String str2 = aa.getPackageName();
    v.i(this.TAG, "check process :[%s] [%s] path[%s]", new Object[] { str1, str2, paramString });
    if ((str1 != null) && (str2 != null) && (!str2.equals(str1))) {
      Assert.assertTrue("processName:" + str1 + "  packagename:" + str2, false);
    }
    GMTrace.o(13560822366208L, 101036);
  }
  
  public static String dP(String paramString)
  {
    GMTrace.i(13561761890304L, 101043);
    if (bf.mA(paramString))
    {
      GMTrace.o(13561761890304L, 101043);
      return "";
    }
    paramString = DatabaseUtils.sqlEscapeString(paramString);
    GMTrace.o(13561761890304L, 101043);
    return paramString;
  }
  
  public final boolean Su(String paramString)
  {
    GMTrace.i(13563640938496L, 101057);
    if (!isOpen())
    {
      v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
      GMTrace.o(13563640938496L, 101057);
      return false;
    }
    try
    {
      this.uJJ.execSQL("DROP TABLE " + paramString);
      GMTrace.o(13563640938496L, 101057);
      return false;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.report.c.oRz.a(181L, 11L, 1L, false);
      v.e(this.TAG, "drop table Error :" + paramString.getMessage());
      b.i(paramString);
      GMTrace.o(13563640938496L, 101057);
    }
    return false;
  }
  
  public final long a(String paramString1, String paramString2, ContentValues paramContentValues, boolean paramBoolean)
  {
    GMTrace.i(16006537805824L, 119258);
    if (!isOpen())
    {
      v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
      GMTrace.o(16006537805824L, 119258);
      return -2L;
    }
    b.begin();
    try
    {
      long l = this.uJJ.insert(paramString1, paramString2, paramContentValues);
      b.a(paramString1, null, this.jAW);
      GMTrace.o(16006537805824L, 119258);
      return l;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.c.oRz.a(181L, 11L, 1L, false);
      v.e(this.TAG, "insert Error :" + paramString1.getMessage());
      b.i(paramString1);
      if (paramBoolean) {
        throw paramString1;
      }
      GMTrace.o(16006537805824L, 119258);
    }
    return -1L;
  }
  
  public final Cursor a(final String paramString, final String[] paramArrayOfString, int paramInt)
  {
    GMTrace.i(13562298761216L, 101047);
    if (!bf.mA(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
      paramString = c.bNy();
      GMTrace.o(13562298761216L, 101047);
      return paramString;
    }
    b.begin();
    try
    {
      paramArrayOfString = this.uJJ.a(paramString, paramArrayOfString, paramInt);
      if ((com.tencent.mm.sdk.a.b.bIi()) || (com.tencent.mm.sdk.a.b.bIk()))
      {
        if (this.uKm == null)
        {
          localObject = com.tencent.mm.sdk.f.e.Qt("CheckCursor");
          ((HandlerThread)localObject).start();
          this.uKm = new ad(((HandlerThread)localObject).getLooper());
        }
        final Object localObject = new Throwable().getStackTrace();
        this.uKm.postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(13556527398912L, 101004);
            long l1;
            boolean bool1;
            Object localObject5;
            int i;
            Object localObject6;
            try
            {
              l1 = bf.NA();
              if (paramArrayOfString != null)
              {
                bool1 = paramArrayOfString.isClosed();
                if (!bool1) {}
              }
              else
              {
                GMTrace.o(13556527398912L, 101004);
                return;
              }
              localObject5 = new HashMap();
              i = 0;
              synchronized (g.this.uKl)
              {
                Iterator localIterator = g.this.uKl.iterator();
                if (!localIterator.hasNext()) {
                  break label613;
                }
                localObject6 = (g.b)localIterator.next();
                if ((localObject6 == null) || (((g.b)localObject6).uKq == null) || (((g.b)localObject6).uKq.isClosed())) {
                  localIterator.remove();
                }
              }
              if ((l1 - ((g.b)localObject6).lastReportTime) / 1000L <= 100L) {
                break label312;
              }
            }
            catch (Exception localException1)
            {
              v.e(g.this.TAG, "checkCursor table:[%s] e:%s[%s]", new Object[] { paramString, localException1.getMessage(), bf.g(localException1) });
              GMTrace.o(13556527398912L, 101004);
              return;
            }
            ((g.b)localObject6).lastReportTime = l1;
            if (((g.b)localObject6).uKt) {
              if (TextUtils.isEmpty(((g.b)localObject6).uKu)) {
                v.w(g.this.TAG, "CheckCursorRES time:%d MSG: BadOut cu:%s caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l1 - ((g.b)localObject6).uKs), Integer.valueOf(((g.b)localObject6).uKq.hashCode()), ((g.b)localObject6).uKr, Boolean.valueOf(((g.b)localObject6).uKt), ((g.b)localObject6).uKu });
              }
            }
            label312:
            Object localObject7;
            int j;
            for (;;)
            {
              localObject7 = (Pair)((HashMap)localObject5).get(((g.b)localObject6).uKr);
              if (localObject7 != null) {
                break label528;
              }
              localObject7 = ((g.b)localObject6).uKr;
              if (l1 - ((g.b)localObject6).uKs <= 30000L) {
                break label1327;
              }
              j = 1;
              label356:
              ((HashMap)localObject5).put(localObject7, new Pair(Integer.valueOf(j), localObject6));
              break;
              v.w(g.this.TAG, "CheckCursorRES time:%d MSG: Adapter cu:%s caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l1 - ((g.b)localObject6).uKs), Integer.valueOf(((g.b)localObject6).uKq.hashCode()), ((g.b)localObject6).uKr, Boolean.valueOf(((g.b)localObject6).uKt), ((g.b)localObject6).uKu });
              continue;
              v.w(g.this.TAG, "CheckCursorRES time:%d MSG: NOTCLOSE cu:%s caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l1 - ((g.b)localObject6).uKs), Integer.valueOf(((g.b)localObject6).uKq.hashCode()), ((g.b)localObject6).uKr, Boolean.valueOf(((g.b)localObject6).uKt), ((g.b)localObject6).uKu });
            }
            label528:
            label613:
            label672:
            label700:
            Object localObject2;
            label864:
            long l2;
            if (l1 - ((g.b)localObject6).uKs > 30000L)
            {
              ((HashMap)localObject5).put(((g.b)localObject6).uKr, new Pair(Integer.valueOf(((Integer)((Pair)localObject7).first).intValue() + 1), localObject6));
              if (i >= ((Integer)((Pair)localObject7).first).intValue() + 1) {
                break label1335;
              }
              i = ((Integer)((Pair)localObject7).first).intValue() + 1;
              break label1332;
              v.d(g.this.TAG, "CheckCursor: checkAss max:%d list:%d map:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(g.this.uKl.size()), Integer.valueOf(((HashMap)localObject5).size()) });
              if (!com.tencent.mm.sdk.a.b.bIi()) {
                break label1346;
              }
              j = 20;
              if (i <= j)
              {
                j = g.this.uKl.size();
                if (!com.tencent.mm.sdk.a.b.bIi()) {
                  break label1352;
                }
                i = 50;
                break label1338;
              }
              localObject6 = ((HashMap)localObject5).keySet().iterator();
              Pair localPair;
              for (localObject2 = ""; ((Iterator)localObject6).hasNext(); localObject2 = (String)localObject2 + (String)localObject7 + "," + localPair.first + "," + ((g.b)localPair.second).uKt + "," + ((g.b)localPair.second).uKu + ";")
              {
                localObject7 = (String)((Iterator)localObject6).next();
                localPair = (Pair)((HashMap)localObject5).get(localObject7);
              }
              Assert.assertTrue("LeakCursor:" + (String)localObject2, false);
              GMTrace.o(13556527398912L, 101004);
              return;
              l2 = bf.NA();
              localObject2 = new g.b();
              ((g.b)localObject2).uKq = paramArrayOfString;
              ((g.b)localObject2).uvu = paramString;
              ((g.b)localObject2).uKs = l1;
              ((g.b)localObject2).uKr = "";
              ((g.b)localObject2).uKt = true;
              j = 0;
            }
            for (;;)
            {
              if (j < localObject.length)
              {
                localObject6 = localObject[j].getClassName();
                ??? = localObject[j].getMethodName();
                i = localObject[j].getLineNumber();
                localObject5 = ((String)localObject6).replace("com.tencent.mm.", "") + ":" + (String)??? + "(" + i + ")";
                localObject6 = Class.forName((String)localObject6);
              }
              for (;;)
              {
                try
                {
                  localObject7 = ((Class)localObject6).getDeclaredField("field_MARK_CURSOR_CHECK_IGNORE");
                  if (localObject7 == null) {
                    continue;
                  }
                  i = 1;
                }
                catch (Exception localException2)
                {
                  int k;
                  boolean bool2;
                  label1327:
                  label1332:
                  label1335:
                  label1338:
                  label1346:
                  label1352:
                  i = 0;
                  continue;
                  j += 1;
                }
                if (i != 0) {
                  continue;
                }
                if (TextUtils.isEmpty(((g.b)localObject2).uKr))
                {
                  ((g.b)localObject2).uKr = ((String)localObject5);
                  localObject5 = ((Class)localObject6).getMethods();
                  k = localObject5.length;
                  bool1 = false;
                  i = 0;
                  bool2 = bool1;
                  if (i < k)
                  {
                    localObject6 = localObject5[i];
                    if (((Method)localObject6).getName().equals(???))
                    {
                      bool1 = ((Method)localObject6).getReturnType().getName().contains(".Cursor");
                      bool2 = bool1;
                      if (bool1 != true) {}
                    }
                  }
                  else
                  {
                    ((g.b)localObject2).uKt = bool2;
                    continue;
                  }
                }
                else
                {
                  if (((g.b)localObject2).uKt)
                  {
                    ??? = ((String)localObject5).toLowerCase();
                    if ((!((String)???).contains("cursor")) && (!((String)???).contains("adapter"))) {
                      continue;
                    }
                    ((g.b)localObject2).uKu = ((String)localObject5);
                    continue;
                  }
                  if (TextUtils.isEmpty(((g.b)localObject2).uKr)) {
                    ((g.b)localObject2).uKr = ag.b(localObject);
                  }
                  synchronized (g.this.uKl)
                  {
                    g.this.uKl.add(localObject2);
                    v.d(g.this.TAG, "checkCursor insert [%d,%d] caller:%s outCu:%b kw:%s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(bf.aA(l1)), ((g.b)localObject2).uKr, Boolean.valueOf(((g.b)localObject2).uKt), ((g.b)localObject2).uKu });
                    GMTrace.o(13556527398912L, 101004);
                    return;
                  }
                  continue;
                  j = 0;
                  break label356;
                  break;
                  continue;
                  if (j > i)
                  {
                    break label700;
                    j = 50;
                    break label672;
                    i = 100;
                    continue;
                  }
                  break label864;
                }
                i += 1;
                continue;
                i = 0;
              }
            }
          }
        }, 500L);
      }
      b.a(paramString, paramArrayOfString, this.jAW);
      GMTrace.o(13562298761216L, 101047);
      return paramArrayOfString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.plugin.report.c.oRz.a(181L, 10L, 1L, false);
      v.e(this.TAG, "execSQL Error :" + paramString.getMessage());
      b.i(paramString);
      paramString = c.bNy();
      GMTrace.o(13562298761216L, 101047);
    }
    return paramString;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    GMTrace.i(13562164543488L, 101046);
    if (!isOpen())
    {
      v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
      paramString1 = c.bNy();
      GMTrace.o(13562164543488L, 101046);
      return paramString1;
    }
    b.begin();
    try
    {
      paramArrayOfString1 = this.uJJ.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramInt);
      b.a(paramString1, paramArrayOfString1, this.jAW);
      GMTrace.o(13562164543488L, 101046);
      return paramArrayOfString1;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.c.oRz.a(181L, 10L, 1L, false);
      v.e(this.TAG, "execSQL Error :" + paramString1.getMessage());
      b.i(paramString1);
      paramString1 = c.bNy();
      GMTrace.o(13562164543488L, 101046);
    }
    return paramString1;
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong, String paramString3, HashMap<Integer, c> paramHashMap)
  {
    GMTrace.i(13561225019392L, 101039);
    boolean bool = a(paramString1, paramString2, "", paramLong, paramString3, paramHashMap, true);
    GMTrace.o(13561225019392L, 101039);
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, HashMap<Integer, c> paramHashMap, boolean paramBoolean)
  {
    GMTrace.i(13561090801664L, 101038);
    int i = paramString1.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString1.substring(i + 1));
    }
    St(paramString2);
    if ((this.uKi.a(paramString1, paramString2, paramString3, paramLong, paramString4, paramHashMap, paramBoolean)) && (this.uKi.uJJ != null))
    {
      this.uKk = this.uKi.getError();
      this.uJJ = this.uKi.uJJ;
      GMTrace.o(13561090801664L, 101038);
      return true;
    }
    this.uKk = this.uKi.getError();
    this.uJJ = null;
    this.uKi = null;
    v.i(this.TAG, "initDB failed. %s", new Object[] { this.uKk });
    GMTrace.o(13561090801664L, 101038);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, List<String> paramList, DBDumpUtil.ExecuteSqlCallback paramExecuteSqlCallback)
  {
    GMTrace.i(14899107332096L, 111007);
    if (!isOpen())
    {
      v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
      GMTrace.o(14899107332096L, 111007);
      return false;
    }
    boolean bool = DBDumpUtil.doRecoveryDb(this.uJJ.uJS, paramString1, paramString2, paramString3, paramList, null, paramExecuteSqlCallback, true);
    GMTrace.o(14899107332096L, 111007);
    return bool;
  }
  
  public final int aD(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      long l1;
      long l2;
      try
      {
        GMTrace.i(13563909373952L, 101059);
        l1 = bf.NA();
        l2 = Thread.currentThread().getId();
        v.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b  {%s} ", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.jAW), Boolean.valueOf(isOpen()), bf.bJP() });
        if (!isOpen())
        {
          v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
          i = -4;
          GMTrace.o(13563909373952L, 101059);
          return i;
        }
        if (paramLong != this.jAW)
        {
          v.e(this.TAG, "ERROR endTransaction ticket:" + paramLong + " transactionTicket:" + this.jAW);
          i = -1;
          GMTrace.o(13563909373952L, 101059);
          continue;
        }
        l3 = paramLong >> 32 & 0x7FFFFFFF;
      }
      finally {}
      long l3;
      if (l3 != l2)
      {
        v.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", new Object[] { Long.toHexString(paramLong), Long.valueOf(l3), Long.valueOf(l2) });
        i = -2;
        GMTrace.o(13563909373952L, 101059);
      }
      else
      {
        try
        {
          b.begin();
          this.uJJ.endTransaction();
          v.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b  {%s} ", new Object[] { Long.valueOf(bf.aA(l1)), Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(this.jAW), Boolean.valueOf(isOpen()), bf.bJP() });
          b.a("endTrans", null, 0L);
          this.jAW = 0L;
          if (this.uKh != null) {
            this.uKh.vA();
          }
          GMTrace.o(13563909373952L, 101059);
        }
        catch (Exception localException)
        {
          v.e(this.TAG, "endTransaction Error :" + localException.getMessage());
          com.tencent.mm.plugin.report.c.oRz.a(181L, 9L, 1L, false);
          b.i(localException);
          i = -3;
          GMTrace.o(13563909373952L, 101059);
        }
      }
    }
  }
  
  public final boolean b(String paramString, HashMap<Integer, c> paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13560956583936L, 101037);
    int i = paramString.lastIndexOf("/");
    if (i != -1) {
      this.TAG = (this.TAG + "." + paramString.substring(i + 1));
    }
    St(paramString);
    if ((this.uKi.a(paramString, paramHashMap, true, paramBoolean2)) && (this.uKi.uJJ != null))
    {
      this.uJJ = this.uKi.uJJ;
      GMTrace.o(13560956583936L, 101037);
      return true;
    }
    this.uJJ = null;
    this.uKi = null;
    v.e(this.TAG, "initDB failed.");
    GMTrace.o(13560956583936L, 101037);
    return false;
  }
  
  public final boolean bKd()
  {
    GMTrace.i(13560688148480L, 101035);
    if ((this.uJJ == null) || (!this.uJJ.isOpen()))
    {
      GMTrace.o(13560688148480L, 101035);
      return true;
    }
    GMTrace.o(13560688148480L, 101035);
    return false;
  }
  
  public final SQLiteDatabase bND()
  {
    GMTrace.i(14899241549824L, 111008);
    if (this.uJJ.uJS != null)
    {
      localSQLiteDatabase = this.uJJ.uJS;
      GMTrace.o(14899241549824L, 111008);
      return localSQLiteDatabase;
    }
    SQLiteDatabase localSQLiteDatabase = this.uJJ.uJT;
    GMTrace.o(14899241549824L, 111008);
    return localSQLiteDatabase;
  }
  
  public void cQ(String paramString)
  {
    GMTrace.i(13560553930752L, 101034);
    if (this.uJJ == null)
    {
      GMTrace.o(13560553930752L, 101034);
      return;
    }
    if (this.uKh != null) {
      this.uKh.vy();
    }
    v.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", new Object[] { Boolean.valueOf(inTransaction()), Long.toHexString(this.jAW), Long.valueOf(Thread.currentThread().getId()), bf.bJP() });
    com.tencent.mm.compatible.util.g.a locala = new com.tencent.mm.compatible.util.g.a();
    if (paramString != null) {
      this.uKj = paramString;
    }
    this.uJJ.close();
    this.uJJ = null;
    v.d(this.TAG, "end close db time:%d", new Object[] { Long.valueOf(locala.se()) });
    GMTrace.o(13560553930752L, 101034);
  }
  
  public final long cs(long paramLong)
  {
    for (;;)
    {
      long l;
      try
      {
        GMTrace.i(13563775156224L, 101058);
        l = Thread.currentThread().getId();
        v.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b  {%s}", new Object[] { Long.valueOf(paramLong), Long.valueOf(l), Long.valueOf(this.jAW), Boolean.valueOf(isOpen()), bf.bJP() });
        if (!isOpen())
        {
          v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
          paramLong = -4L;
          GMTrace.o(13563775156224L, 101058);
          return paramLong;
        }
        if (this.jAW > 0L)
        {
          v.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.jAW);
          paramLong = -1L;
          GMTrace.o(13563775156224L, 101058);
          continue;
        }
        if (ae.isMainThread()) {
          break label232;
        }
      }
      finally {}
      if (paramLong == -1L)
      {
        v.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
        paramLong = -2L;
        GMTrace.o(13563775156224L, 101058);
      }
      else
      {
        try
        {
          label232:
          b.begin();
          this.uJJ.beginTransaction();
          b.a("beginTrans", null, 0L);
          this.jAW = (bf.NA() & 0x7FFFFFFF);
          this.jAW = ((l & 0x7FFFFFFF) << 32 | this.jAW);
          if (this.uKh != null) {
            this.uKh.vz();
          }
          paramLong = this.jAW;
          GMTrace.o(13563775156224L, 101058);
        }
        catch (Exception localException)
        {
          com.tencent.mm.plugin.report.c.oRz.a(181L, 8L, 1L, false);
          v.e(this.TAG, "beginTransaction Error :" + localException.getMessage());
          b.i(localException);
          paramLong = -3L;
          GMTrace.o(13563775156224L, 101058);
        }
      }
    }
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    GMTrace.i(13563506720768L, 101056);
    if (!isOpen())
    {
      v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
      GMTrace.o(13563506720768L, 101056);
      return -2;
    }
    b.begin();
    try
    {
      int i = this.uJJ.delete(paramString1, paramString2, paramArrayOfString);
      b.a(paramString1, null, this.jAW);
      GMTrace.o(13563506720768L, 101056);
      return i;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.c.oRz.a(181L, 11L, 1L, false);
      v.e(this.TAG, "delete Error :" + paramString1.getMessage());
      b.i(paramString1);
      GMTrace.o(13563506720768L, 101056);
    }
    return -1;
  }
  
  public final boolean eE(String paramString1, String paramString2)
  {
    GMTrace.i(13562969849856L, 101052);
    if (!bf.mA(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("sql is null ", bool);
      if (isOpen()) {
        break;
      }
      v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
      GMTrace.o(13562969849856L, 101052);
      return false;
    }
    b.begin();
    try
    {
      this.uJJ.execSQL(paramString2);
      b.a(paramString2, null, this.jAW);
      GMTrace.o(13562969849856L, 101052);
      return true;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.c.oRz.a(181L, 11L, 1L, false);
      paramString2 = paramString1.getMessage();
      v.e(this.TAG, "execSQL Error :" + paramString2);
      if ((paramString2 != null) && (paramString2.contains("no such table")))
      {
        paramString2 = this.uKi;
        v.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", new Object[] { paramString2.uJK });
        com.tencent.mm.loader.stub.b.deleteFile(paramString2.uJK);
        Assert.assertTrue("clean ini cache and reboot", false);
      }
      b.i(paramString1);
      GMTrace.o(13562969849856L, 101052);
    }
    return false;
  }
  
  protected void finalize()
  {
    GMTrace.i(13560285495296L, 101032);
    cQ(null);
    GMTrace.o(13560285495296L, 101032);
  }
  
  public final String getKey()
  {
    GMTrace.i(13561493454848L, 101041);
    if (this.uKi == null)
    {
      GMTrace.o(13561493454848L, 101041);
      return null;
    }
    String str = this.uKi.arH;
    GMTrace.o(13561493454848L, 101041);
    return str;
  }
  
  public final long getPageSize()
  {
    GMTrace.i(13562701414400L, 101050);
    long l = this.uJJ.uJS.getPageSize();
    GMTrace.o(13562701414400L, 101050);
    return l;
  }
  
  public final String getPath()
  {
    GMTrace.i(13561627672576L, 101042);
    if (!isOpen())
    {
      v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
      GMTrace.o(13561627672576L, 101042);
      return null;
    }
    String str = this.uJJ.getPath();
    GMTrace.o(13561627672576L, 101042);
    return str;
  }
  
  /* Error */
  public final boolean inTransaction()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc2_w 551
    //   7: ldc_w 553
    //   10: invokestatic 49	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   13: aload_0
    //   14: invokevirtual 161	com/tencent/mm/bj/g:isOpen	()Z
    //   17: ifne +35 -> 52
    //   20: aload_0
    //   21: getfield 55	com/tencent/mm/bj/g:TAG	Ljava/lang/String;
    //   24: ldc -93
    //   26: iconst_1
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: invokestatic 167	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
    //   35: aastore
    //   36: invokestatic 170	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: ldc2_w 551
    //   42: ldc_w 553
    //   45: invokestatic 82	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   48: aload_0
    //   49: monitorexit
    //   50: iload_1
    //   51: ireturn
    //   52: aload_0
    //   53: getfield 79	com/tencent/mm/bj/g:jAW	J
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle +17 -> 75
    //   61: ldc2_w 551
    //   64: ldc_w 553
    //   67: invokestatic 82	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   70: iconst_1
    //   71: istore_1
    //   72: goto -24 -> 48
    //   75: ldc2_w 551
    //   78: ldc_w 553
    //   81: invokestatic 82	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   84: goto -36 -> 48
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	g
    //   1	71	1	bool	boolean
    //   87	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	48	87	finally
    //   52	70	87	finally
    //   75	84	87	finally
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    GMTrace.i(13563104067584L, 101053);
    long l = a(paramString1, paramString2, paramContentValues, false);
    GMTrace.o(13563104067584L, 101053);
    return l;
  }
  
  public final boolean isOpen()
  {
    GMTrace.i(13561359237120L, 101040);
    if ((this.uJJ != null) && (this.uJJ.isOpen()))
    {
      GMTrace.o(13561359237120L, 101040);
      return true;
    }
    Assert.assertTrue("DB has been closed :[" + this.uKj + "]", bf.mA(this.uKj));
    GMTrace.o(13561359237120L, 101040);
    return false;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    GMTrace.i(13562030325760L, 101045);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0);
    GMTrace.o(13562030325760L, 101045);
    return paramString1;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(13562432978944L, 101048);
    paramString = a(paramString, paramArrayOfString, 0);
    GMTrace.o(13562432978944L, 101048);
    return paramString;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    GMTrace.i(13563372503040L, 101055);
    if (!isOpen())
    {
      v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
      GMTrace.o(13563372503040L, 101055);
      return -2L;
    }
    b.begin();
    try
    {
      long l = this.uJJ.replace(paramString1, paramString2, paramContentValues);
      b.a(paramString1, null, this.jAW);
      GMTrace.o(13563372503040L, 101055);
      return l;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.c.oRz.a(181L, 11L, 1L, false);
      v.e(this.TAG, "repalce  Error :" + paramString1.getMessage());
      b.i(paramString1);
      GMTrace.o(13563372503040L, 101055);
    }
    return -1L;
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    GMTrace.i(13563238285312L, 101054);
    if (!isOpen())
    {
      v.e(this.TAG, "DB IS CLOSED ! {%s}", new Object[] { bf.bJP() });
      GMTrace.o(13563238285312L, 101054);
      return -2;
    }
    b.begin();
    try
    {
      int i = this.uJJ.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      b.a(paramString1, null, this.jAW);
      GMTrace.o(13563238285312L, 101054);
      return i;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.plugin.report.c.oRz.a(181L, 11L, 1L, false);
      v.e(this.TAG, "update Error :" + paramString1.getMessage());
      b.i(paramString1);
      GMTrace.o(13563238285312L, 101054);
    }
    return -1;
  }
  
  public void wL()
  {
    GMTrace.i(13560419713024L, 101033);
    cQ(null);
    GMTrace.o(13560419713024L, 101033);
  }
  
  public static abstract interface a
  {
    public abstract void vA();
    
    public abstract void vy();
    
    public abstract void vz();
  }
  
  public static final class b
  {
    public long lastReportTime;
    public Cursor uKq;
    public String uKr;
    public long uKs;
    public boolean uKt;
    public String uKu;
    public String uvu;
    
    public b()
    {
      GMTrace.i(13564848898048L, 101066);
      GMTrace.o(13564848898048L, 101066);
    }
  }
  
  public static abstract interface c
  {
    public abstract String[] pP();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bj/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */