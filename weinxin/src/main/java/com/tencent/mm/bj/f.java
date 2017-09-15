package com.tencent.mm.bj;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.sdk.e.e
{
  public static String uKe;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  public boolean sCt;
  public e uJJ;
  public g uKd;
  public Map<String, h> uKf;
  public Queue<a> uKg;
  
  static
  {
    GMTrace.i(13549145423872L, 100949);
    uKe = "";
    GMTrace.o(13549145423872L, 100949);
  }
  
  public final int Ss(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    GMTrace.i(13547803246592L, 100939);
    if (!this.sCt)
    {
      GMTrace.o(13547803246592L, 100939);
      return -4;
    }
    if ((this.uKd == null) || (this.uKd.inTransaction()))
    {
      v.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
      GMTrace.o(13547803246592L, 100939);
      return -3;
    }
    try
    {
      if (e.a(this.uJJ, paramString))
      {
        this.uJJ.execSQL("drop table " + paramString);
        v.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", new Object[] { paramString });
      }
      Cursor localCursor = this.uKd.a(" select sql from sqlite_master where tbl_name=\"" + paramString + "\" and type = \"table\"", null, 0);
      if (localCursor != null)
      {
        localObject1 = localObject2;
        if (localCursor.getCount() == 1)
        {
          localCursor.moveToFirst();
          localObject1 = localCursor.getString(0);
        }
        localCursor.close();
      }
      if (localObject1 == null)
      {
        v.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
        GMTrace.o(13547803246592L, 100939);
        return -1;
      }
      this.uJJ.execSQL((String)localObject1);
      this.uJJ.execSQL("insert into " + paramString + " select * from old." + paramString);
      v.d("MicroMsg.MemoryStorage", "copy table %s success", new Object[] { paramString });
      GMTrace.o(13547803246592L, 100939);
      return 0;
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.MemoryStorage", paramString, "copy table failed with exception.\n", new Object[0]);
      GMTrace.o(13547803246592L, 100939);
    }
    return -2;
  }
  
  public final Cursor a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    GMTrace.i(13549011206144L, 100948);
    paramString = rawQuery(paramString, paramArrayOfString);
    GMTrace.o(13549011206144L, 100948);
    return paramString;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    GMTrace.i(13548742770688L, 100946);
    paramString1 = query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
    GMTrace.o(13548742770688L, 100946);
    return paramString1;
  }
  
  public final boolean bKd()
  {
    GMTrace.i(13547669028864L, 100938);
    if ((this.uJJ == null) || (!this.uJJ.isOpen()))
    {
      v.e("MicroMsg.MemoryStorage", "memory db is close [%s]", new Object[] { uKe });
      GMTrace.o(13547669028864L, 100938);
      return true;
    }
    GMTrace.o(13547669028864L, 100938);
    return false;
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    GMTrace.i(13547937464320L, 100940);
    Assert.assertTrue("Not Attach Mem Storage:" + paramString1, this.uKf.containsKey(paramString1));
    int i;
    if ((this.uJJ != null) && (this.uJJ.isOpen()))
    {
      h localh = (h)this.uKf.get(paramString1);
      h.a locala = new h.a();
      locala.utu = 5;
      locala.uKx = paramString2;
      locala.G(paramArrayOfString);
      localh.a(locala);
      i = this.uJJ.delete(paramString1, paramString2, paramArrayOfString);
      GMTrace.o(13547937464320L, 100940);
      return i;
    }
    v.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", new Object[] { paramString1, uKe });
    if ((this.uKd != null) && (this.uKd.isOpen()))
    {
      i = this.uKd.delete(paramString1, paramString2, paramArrayOfString);
      GMTrace.o(13547937464320L, 100940);
      return i;
    }
    GMTrace.o(13547937464320L, 100940);
    return -1;
  }
  
  public final boolean eE(String paramString1, String paramString2)
  {
    GMTrace.i(13548071682048L, 100941);
    Assert.assertTrue("Not Attach Mem Storage:" + paramString1, this.uKf.containsKey(paramString1));
    if ((this.uJJ != null) && (this.uJJ.isOpen()))
    {
      paramString1 = (h)this.uKf.get(paramString1);
      h.a locala = new h.a();
      locala.utu = 1;
      locala.uvs = paramString2;
      paramString1.a(locala);
      this.uJJ.execSQL(paramString2);
      GMTrace.o(13548071682048L, 100941);
      return true;
    }
    v.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", new Object[] { paramString1, uKe });
    if ((this.uKd != null) && (this.uKd.isOpen()))
    {
      this.uKd.eE(paramString2, paramString1);
      GMTrace.o(13548071682048L, 100941);
      return true;
    }
    GMTrace.o(13548071682048L, 100941);
    return false;
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    GMTrace.i(13548205899776L, 100942);
    Assert.assertTrue("Not Attach Mem Storage:" + paramString1, this.uKf.containsKey(paramString1));
    long l;
    if ((this.uJJ != null) && (this.uJJ.isOpen()))
    {
      h localh = (h)this.uKf.get(paramString1);
      h.a locala = new h.a();
      locala.utu = 2;
      locala.uvq = paramString2;
      locala.values = new ContentValues(paramContentValues);
      localh.a(locala);
      l = this.uJJ.insert(paramString1, paramString2, paramContentValues);
      GMTrace.o(13548205899776L, 100942);
      return l;
    }
    v.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", new Object[] { paramString1, uKe });
    if ((this.uKd != null) && (this.uKd.isOpen()))
    {
      l = this.uKd.insert(paramString1, paramString2, paramContentValues);
      GMTrace.o(13548205899776L, 100942);
      return l;
    }
    GMTrace.o(13548205899776L, 100942);
    return -1L;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    GMTrace.i(13548608552960L, 100945);
    if ((this.uJJ != null) && (this.uJJ.isOpen()))
    {
      paramString1 = this.uJJ.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0);
      GMTrace.o(13548608552960L, 100945);
      return paramString1;
    }
    v.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", new Object[] { paramString1, uKe });
    paramString1 = c.bNy();
    GMTrace.o(13548608552960L, 100945);
    return paramString1;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(13548876988416L, 100947);
    if ((this.uJJ != null) && (this.uJJ.isOpen()))
    {
      paramString = this.uJJ.a(paramString, paramArrayOfString, 0);
      GMTrace.o(13548876988416L, 100947);
      return paramString;
    }
    v.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", new Object[] { paramString, uKe });
    paramString = c.bNy();
    GMTrace.o(13548876988416L, 100947);
    return paramString;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    GMTrace.i(13548340117504L, 100943);
    Assert.assertTrue("Not Attach Mem Storage:" + paramString1, this.uKf.containsKey(paramString1));
    long l;
    if ((this.uJJ != null) && (this.uJJ.isOpen()))
    {
      h localh = (h)this.uKf.get(paramString1);
      h.a locala = new h.a();
      locala.utu = 4;
      locala.uvq = paramString2;
      locala.values = new ContentValues(paramContentValues);
      localh.a(locala);
      l = this.uJJ.replace(paramString1, paramString2, paramContentValues);
      GMTrace.o(13548340117504L, 100943);
      return l;
    }
    v.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", new Object[] { paramString1, uKe });
    if ((this.uKd != null) && (this.uKd.isOpen()))
    {
      l = this.uKd.replace(paramString1, paramString2, paramContentValues);
      GMTrace.o(13548340117504L, 100943);
      return l;
    }
    GMTrace.o(13548340117504L, 100943);
    return -1L;
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    GMTrace.i(13548474335232L, 100944);
    Assert.assertTrue("Not Attach Mem Storage:" + paramString1, this.uKf.containsKey(paramString1));
    int i;
    if ((this.uJJ != null) && (this.uJJ.isOpen()))
    {
      h localh = (h)this.uKf.get(paramString1);
      h.a locala = new h.a();
      locala.utu = 3;
      locala.uKx = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locala.G(paramArrayOfString);
      localh.a(locala);
      i = this.uJJ.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      GMTrace.o(13548474335232L, 100944);
      return i;
    }
    v.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", new Object[] { paramString1, uKe });
    if ((this.uKd != null) && (this.uKd.isOpen()))
    {
      i = this.uKd.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      GMTrace.o(13548474335232L, 100944);
      return i;
    }
    GMTrace.o(13548474335232L, 100944);
    return -1;
  }
  
  public static abstract interface a
  {
    public abstract int a(f paramf);
    
    public abstract String getTableName();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bj/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */