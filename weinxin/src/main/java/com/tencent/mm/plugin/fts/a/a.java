package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a
  implements g
{
  private boolean lXe;
  private boolean lXf;
  private com.tencent.mm.a.f<String, String> lXg;
  public f lXh;
  public SQLiteStatement lXi;
  private SQLiteStatement lXj;
  private SQLiteStatement lXk;
  private SQLiteStatement lXl;
  private SQLiteStatement lXm;
  public SQLiteStatement lXn;
  private SQLiteStatement lXo;
  public SQLiteStatement lXp;
  
  public a()
  {
    GMTrace.i(18627810033664L, 138788);
    v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create %s", new Object[] { getName() });
    GMTrace.o(18627810033664L, 138788);
  }
  
  private static String aW(String paramString, int paramInt)
  {
    GMTrace.i(18628481122304L, 138793);
    paramString = paramString + "​" + paramInt;
    GMTrace.o(18628481122304L, 138793);
    return paramString;
  }
  
  public final Cursor a(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    GMTrace.i(18630225952768L, 138806);
    if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3) && (!paramBoolean4) && (!paramBoolean5))
    {
      paramArrayOfInt = c.bNy();
      GMTrace.o(18630225952768L, 138806);
      return paramArrayOfInt;
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      paramArrayOfInt = c.bNy();
      GMTrace.o(18630225952768L, 138806);
      return paramArrayOfInt;
    }
    Object localObject = new StringBuilder(64);
    if (paramBoolean1) {
      ((StringBuilder)localObject).append("docid,");
    }
    if (paramBoolean2) {
      ((StringBuilder)localObject).append("entity_id,");
    }
    if (paramBoolean3) {
      ((StringBuilder)localObject).append("aux_index,");
    }
    if (paramBoolean4) {
      ((StringBuilder)localObject).append("timestamp,");
    }
    if (paramBoolean5) {
      ((StringBuilder)localObject).append("status,");
    }
    ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 1);
    localObject = ((StringBuilder)localObject).toString();
    paramArrayOfInt = String.format("SELECT %s FROM %s WHERE type IN " + d.k(paramArrayOfInt) + ";", new Object[] { localObject, axx() });
    paramArrayOfInt = this.lXh.rawQuery(paramArrayOfInt, null);
    GMTrace.o(18630225952768L, 138806);
    return paramArrayOfInt;
  }
  
  public final Cursor a(String[] paramArrayOfString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    GMTrace.i(18629823299584L, 138803);
    paramArrayOfString = a(paramArrayOfString, paramArrayOfInt, null, null, paramBoolean, true);
    GMTrace.o(18629823299584L, 138803);
    return paramArrayOfString;
  }
  
  public final Cursor a(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    GMTrace.i(18629957517312L, 138804);
    paramArrayOfString = a(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, null, true, true);
    GMTrace.o(18629957517312L, 138804);
    return paramArrayOfString;
  }
  
  public final Cursor a(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(18630091735040L, 138805);
    String str = d.s(paramArrayOfString);
    label65:
    label94:
    StringBuilder localStringBuilder;
    if (paramBoolean1)
    {
      paramArrayOfString = String.format(",MMHighlight(%s, -1, type, subtype)", new Object[] { axy() });
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
        break label242;
      }
      paramArrayOfInt2 = " AND subtype IN " + d.k(paramArrayOfInt2);
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) {
        break label248;
      }
      paramArrayOfInt1 = " AND type IN " + d.k(paramArrayOfInt1);
      localStringBuilder = new StringBuilder("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp");
      if (!paramBoolean2) {
        break label254;
      }
    }
    label242:
    label248:
    label254:
    for (paramString = ", content";; paramString = "")
    {
      paramArrayOfString = String.format(paramString + paramArrayOfString + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramArrayOfInt1 + "" + " AND status >= 0" + paramArrayOfInt2 + ";", new Object[] { axx(), axx(), axy(), axx(), axy(), axy(), str });
      paramArrayOfString = this.lXh.a(paramArrayOfString, null, null);
      GMTrace.o(18630091735040L, 138805);
      return paramArrayOfString;
      paramArrayOfString = "";
      break;
      paramArrayOfInt2 = "";
      break label65;
      paramArrayOfInt1 = "";
      break label94;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    GMTrace.i(18628346904576L, 138792);
    paramString2 = d.wV(paramString2);
    if (bf.mA(paramString2))
    {
      GMTrace.o(18628346904576L, 138792);
      return;
    }
    boolean bool = this.lXh.inTransaction();
    if (!bool) {
      this.lXh.beginTransaction();
    }
    try
    {
      this.lXi.bindString(1, paramString2);
      this.lXi.execute();
      this.lXj.bindLong(1, paramInt1);
      this.lXj.bindLong(2, paramInt2);
      this.lXj.bindLong(3, paramLong1);
      this.lXj.bindString(4, paramString1);
      this.lXj.bindLong(5, paramLong2);
      this.lXj.execute();
      if (!bool) {
        this.lXh.commit();
      }
      if (axA()) {
        this.lXg.put(aW(paramString1, paramInt2), paramString2);
      }
      GMTrace.o(18628346904576L, 138792);
      return;
    }
    catch (SQLiteException paramString2)
    {
      v.e("MicroMsg.FTS.BaseFTS5NativeStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
      paramString1 = this.lXp.simpleQueryForString();
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        v.e("MicroMsg.FTS.BaseFTS5NativeStorage", ">> " + paramString1);
      }
      throw paramString2;
    }
  }
  
  public final void a(int[] paramArrayOfInt, long paramLong)
  {
    GMTrace.i(18628883775488L, 138796);
    ArrayList localArrayList = new ArrayList(16);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.k(paramArrayOfInt) + " AND entity_id=?;", new Object[] { axx() });
    paramArrayOfInt = this.lXh.rawQuery(paramArrayOfInt, new String[] { Long.toString(paramLong) });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    aC(localArrayList);
    GMTrace.o(18628883775488L, 138796);
  }
  
  public final void a(int[] paramArrayOfInt, String paramString)
  {
    GMTrace.i(18628615340032L, 138794);
    ArrayList localArrayList = new ArrayList(16);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.k(paramArrayOfInt) + " AND aux_index=?;", new Object[] { axx() });
    paramArrayOfInt = this.lXh.rawQuery(paramArrayOfInt, new String[] { paramString });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    aC(localArrayList);
    GMTrace.o(18628615340032L, 138794);
  }
  
  public final void aC(List<Long> paramList)
  {
    GMTrace.i(18629017993216L, 138797);
    boolean bool = this.lXh.inTransaction();
    if (!bool) {
      this.lXh.beginTransaction();
    }
    Iterator localIterator = paramList.iterator();
    long l;
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      this.lXk.bindLong(1, l);
      this.lXk.execute();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      l = ((Long)paramList.next()).longValue();
      this.lXl.bindLong(1, l);
      this.lXl.execute();
    }
    if (!bool) {
      commit();
    }
    GMTrace.o(18629017993216L, 138797);
  }
  
  public final String aX(String paramString, int paramInt)
  {
    GMTrace.i(18631836565504L, 138818);
    if (axA())
    {
      localObject = aW(paramString, paramInt);
      if (this.lXg.aV(localObject))
      {
        v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "hit lru insert content map");
        paramString = (String)this.lXg.get(localObject);
        GMTrace.o(18631836565504L, 138818);
        return paramString;
      }
    }
    Object localObject = String.format("SELECT content FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE aux_index=? AND subtype=?", new Object[] { axx(), axy(), axx(), axy() });
    localObject = this.lXh.rawQuery((String)localObject, new String[] { paramString, String.valueOf(paramInt) });
    paramString = null;
    if (((Cursor)localObject).moveToFirst()) {
      paramString = ((Cursor)localObject).getString(0);
    }
    ((Cursor)localObject).close();
    GMTrace.o(18631836565504L, 138818);
    return paramString;
  }
  
  public boolean axA()
  {
    GMTrace.i(18631970783232L, 138819);
    GMTrace.o(18631970783232L, 138819);
    return false;
  }
  
  public final String axx()
  {
    GMTrace.i(18630628605952L, 138809);
    String str = "FTS5Meta" + getTableName();
    GMTrace.o(18630628605952L, 138809);
    return str;
  }
  
  public final String axy()
  {
    GMTrace.i(18630762823680L, 138810);
    String str = "FTS5Index" + getTableName();
    GMTrace.o(18630762823680L, 138810);
    return str;
  }
  
  public String axz()
  {
    GMTrace.i(18631433912320L, 138815);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { axx() });
    GMTrace.o(18631433912320L, 138815);
    return str;
  }
  
  public final List<Long> b(int[] paramArrayOfInt, String paramString)
  {
    GMTrace.i(18629554864128L, 138801);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + d.k(paramArrayOfInt) + ";", new Object[] { axx() });
    paramArrayOfInt = this.lXh.rawQuery(paramArrayOfInt, new String[] { paramString });
    paramString = new ArrayList();
    while (paramArrayOfInt.moveToNext()) {
      paramString.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    f(paramString, 1);
    GMTrace.o(18629554864128L, 138801);
    return paramString;
  }
  
  public final void beginTransaction()
  {
    GMTrace.i(18630897041408L, 138811);
    this.lXh.beginTransaction();
    GMTrace.o(18630897041408L, 138811);
  }
  
  public final boolean cb(int paramInt1, int paramInt2)
  {
    GMTrace.i(18631299694592L, 138814);
    boolean bool = this.lXh.cb(paramInt1, paramInt2);
    GMTrace.o(18631299694592L, 138814);
    return bool;
  }
  
  public final void commit()
  {
    GMTrace.i(18631031259136L, 138812);
    this.lXh.commit();
    GMTrace.o(18631031259136L, 138812);
  }
  
  public final void create()
  {
    GMTrace.i(18627944251392L, 138789);
    v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnCreate %s | isCreated =%b", new Object[] { getName(), Boolean.valueOf(this.lXe) });
    int i;
    if (!this.lXe)
    {
      if (((l)h.j(l.class)).isFTSContextReady()) {
        break label99;
      }
      v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Fail!");
      i = 0;
      if (i != 0)
      {
        v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetCreated");
        this.lXe = true;
      }
    }
    GMTrace.o(18627944251392L, 138789);
    return;
    label99:
    this.lXh = ((l)h.j(l.class)).getFTSIndexDB();
    v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Success!");
    String str2 = axy();
    String str1 = axx();
    v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "indexTableName=%s | metaTableName=%s | TableName=%s", new Object[] { str2, str1, getTableName() });
    if ((this.lXh.wP(str2)) && (this.lXh.wP(str1)) && (!tS())) {
      v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Exist, Not Need To Create");
    }
    for (;;)
    {
      String str3 = String.format("INSERT INTO %s (content) VALUES (?);", new Object[] { str2 });
      this.lXi = this.lXh.compileStatement(str3);
      str3 = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?);", new Object[] { str1 });
      this.lXj = this.lXh.compileStatement(str3);
      str2 = String.format("DELETE FROM %s WHERE rowid=?;", new Object[] { str2 });
      this.lXk = this.lXh.compileStatement(str2);
      str2 = String.format("DELETE FROM %s WHERE docid=?;", new Object[] { str1 });
      this.lXl = this.lXh.compileStatement(str2);
      str2 = String.format("UPDATE %s SET status=? WHERE docid=?;", new Object[] { str1 });
      this.lXm = this.lXh.compileStatement(str2);
      str2 = String.format("UPDATE %s SET status=? WHERE aux_index=? AND status=?", new Object[] { str1 });
      this.lXn = this.lXh.compileStatement(str2);
      str1 = String.format("UPDATE %s SET timestamp=? WHERE aux_index=?", new Object[] { str1 });
      this.lXo = this.lXh.compileStatement(str1);
      this.lXp = this.lXh.compileStatement("SELECT mm_last_error();");
      this.lXg = new com.tencent.mm.a.f(100);
      tR();
      i = 1;
      break;
      v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Not Exist, Need To Create");
      str3 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { str2 });
      String str4 = String.format("DROP TABLE IF EXISTS %s;", new Object[] { str1 });
      this.lXh.execSQL(str3);
      this.lXh.execSQL(str4);
      str3 = String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[] { axy() });
      this.lXh.execSQL(str3);
      str3 = axz();
      this.lXh.execSQL(str3);
      str3 = String.format("CREATE INDEX IF NOT EXISTS %s_typeId ON %s(type, entity_id);", new Object[] { str1, str1 });
      this.lXh.execSQL(str3);
      str3 = String.format("CREATE INDEX IF NOT EXISTS %s_entity_id_subtype ON %s(entity_id, subtype);", new Object[] { str1, str1 });
      this.lXh.execSQL(str3);
      str3 = String.format("CREATE INDEX IF NOT EXISTS %s_aux_index_subtype ON %s(aux_index, subtype);", new Object[] { str1, str1 });
      this.lXh.execSQL(str3);
      str3 = String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[] { str1, str1 });
      this.lXh.execSQL(str3);
    }
  }
  
  public final void destroy()
  {
    GMTrace.i(18630360170496L, 138807);
    v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.lXf), Boolean.valueOf(this.lXe) });
    if ((!this.lXf) && (this.lXe) && (tT()))
    {
      v.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetDestroyed");
      this.lXf = true;
    }
    GMTrace.o(18630360170496L, 138807);
  }
  
  public final List<b> e(int[] paramArrayOfInt, int paramInt)
  {
    GMTrace.i(18629689081856L, 138802);
    paramArrayOfInt = String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + d.k(paramArrayOfInt) + ";", new Object[] { axx() });
    paramArrayOfInt = this.lXh.rawQuery(paramArrayOfInt, null);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    while (paramArrayOfInt.moveToNext())
    {
      b localb = new b();
      localb.lYa = paramArrayOfInt.getLong(0);
      localb.type = paramArrayOfInt.getInt(1);
      localb.hOZ = paramArrayOfInt.getInt(2);
      localb.lYb = paramArrayOfInt.getString(3);
      localArrayList1.add(localb);
      localArrayList2.add(Long.valueOf(localb.lYa));
    }
    paramArrayOfInt.close();
    f(localArrayList2, paramInt);
    GMTrace.o(18629689081856L, 138802);
    return localArrayList1;
  }
  
  public final void f(List<Long> paramList, int paramInt)
  {
    GMTrace.i(18629420646400L, 138800);
    boolean bool = this.lXh.inTransaction();
    if (!bool) {
      this.lXh.beginTransaction();
    }
    this.lXm.bindLong(1, paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      long l = ((Long)paramList.next()).longValue();
      this.lXm.bindLong(2, l);
      this.lXm.execute();
    }
    if (!bool) {
      this.lXh.commit();
    }
    GMTrace.o(18629420646400L, 138800);
  }
  
  public String getTableName()
  {
    GMTrace.i(18628212686848L, 138791);
    GMTrace.o(18628212686848L, 138791);
    return "Common";
  }
  
  public final void h(Long paramLong)
  {
    GMTrace.i(18629286428672L, 138799);
    boolean bool = this.lXh.inTransaction();
    if (!bool) {
      this.lXh.beginTransaction();
    }
    this.lXk.bindLong(1, paramLong.longValue());
    this.lXk.execute();
    this.lXl.bindLong(1, paramLong.longValue());
    this.lXl.execute();
    if (!bool) {
      commit();
    }
    GMTrace.o(18629286428672L, 138799);
  }
  
  public final void i(long paramLong1, long paramLong2)
  {
    GMTrace.i(18631165476864L, 138813);
    this.lXh.i(paramLong1, paramLong2);
    GMTrace.o(18631165476864L, 138813);
  }
  
  public final void i(int[] paramArrayOfInt)
  {
    GMTrace.i(18628749557760L, 138795);
    ArrayList localArrayList = new ArrayList(2048);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.k(paramArrayOfInt) + ";", new Object[] { axx() });
    paramArrayOfInt = this.lXh.rawQuery(paramArrayOfInt, null);
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    aC(localArrayList);
    GMTrace.o(18628749557760L, 138795);
  }
  
  public final long j(int[] paramArrayOfInt)
  {
    GMTrace.i(18631702347776L, 138817);
    paramArrayOfInt = String.format("SELECT count(*) FROM %s WHERE type IN %s", new Object[] { axx(), d.k(paramArrayOfInt) });
    long l = 0L;
    Cursor localCursor;
    try
    {
      localCursor = this.lXh.rawQuery(paramArrayOfInt, null);
      if (localCursor == null) {
        break label102;
      }
    }
    finally
    {
      try
      {
        if (localCursor.moveToNext()) {
          l = localCursor.getLong(0);
        }
        localCursor.close();
        GMTrace.o(18631702347776L, 138817);
        return l;
      }
      finally {}
      paramArrayOfInt = finally;
      localCursor = null;
    }
    localCursor.close();
    label102:
    throw paramArrayOfInt;
  }
  
  public abstract void tR();
  
  public boolean tS()
  {
    GMTrace.i(18631568130048L, 138816);
    GMTrace.o(18631568130048L, 138816);
    return false;
  }
  
  public boolean tT()
  {
    GMTrace.i(18630494388224L, 138808);
    this.lXh = null;
    this.lXi.close();
    this.lXj.close();
    this.lXk.close();
    this.lXl.close();
    this.lXm.close();
    this.lXp.close();
    if (this.lXg != null) {
      this.lXg.clear();
    }
    GMTrace.o(18630494388224L, 138808);
    return true;
  }
  
  public final void u(String paramString, long paramLong)
  {
    GMTrace.i(18629152210944L, 138798);
    this.lXo.bindLong(1, paramLong);
    this.lXo.bindString(2, paramString);
    this.lXo.execute();
    GMTrace.o(18629152210944L, 138798);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */