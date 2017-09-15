package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public abstract class i<T extends c>
  extends j
  implements d<T>
{
  public int field_MARK_CURSOR_CHECK_IGNORE;
  private final e gUp;
  public final c.a uvt;
  private final String uvu;
  
  public i(e parame, c.a parama, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(13966965211136L, 104062);
    this.field_MARK_CURSOR_CHECK_IGNORE = 1;
    this.gUp = parame;
    this.uvt = parama;
    parama = this.uvt;
    if (bf.mA(this.uvt.uvq)) {}
    int i;
    for (parame = "rowid";; parame = this.uvt.uvq)
    {
      parama.uvq = parame;
      this.uvu = paramString;
      parame = a(this.uvt, getTableName(), this.gUp);
      i = 0;
      while (i < parame.size())
      {
        this.gUp.eE(this.uvu, (String)parame.get(i));
        i += 1;
      }
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      i = j;
      while (i < paramArrayOfString.length)
      {
        this.gUp.eE(this.uvu, paramArrayOfString[i]);
        i += 1;
      }
    }
    GMTrace.o(13966965211136L, 104062);
  }
  
  private void Qr(String paramString)
  {
    GMTrace.i(13969918001152L, 104084);
    v.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + paramString);
    GMTrace.o(13969918001152L, 104084);
  }
  
  private void Qs(String paramString)
  {
    GMTrace.i(13970052218880L, 104085);
    v.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + paramString);
    GMTrace.o(13970052218880L, 104085);
  }
  
  public static String a(c.a parama, String paramString)
  {
    GMTrace.i(13967233646592L, 104064);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + paramString + " ( ");
    localStringBuilder.append(parama.uvs);
    localStringBuilder.append(");");
    parama = localStringBuilder.toString();
    GMTrace.o(13967233646592L, 104064);
    return parama;
  }
  
  private static StringBuilder a(ContentValues paramContentValues, String... paramVarArgs)
  {
    GMTrace.i(13969649565696L, 104082);
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localStringBuilder.append(str + " = ? AND ");
      if (paramContentValues.get(str) == null)
      {
        GMTrace.o(13969649565696L, 104082);
        return null;
      }
      i += 1;
    }
    localStringBuilder.append(" 1=1");
    GMTrace.o(13969649565696L, 104082);
    return localStringBuilder;
  }
  
  public static List<String> a(c.a parama, String paramString, e parame)
  {
    GMTrace.i(13967367864320L, 104065);
    ArrayList localArrayList = new ArrayList();
    if ((parame == null) || (paramString == null))
    {
      if (parame == null) {}
      for (boolean bool = true;; bool = false)
      {
        v.e("MicroMsg.SDK.MAutoStorage", "dk getUpdateSQLs db==null :%b  table:%s", new Object[] { Boolean.valueOf(bool), paramString });
        GMTrace.o(13967367864320L, 104065);
        return localArrayList;
      }
    }
    Object localObject1 = parame.a("PRAGMA table_info( " + paramString + " )", new String[0], 2);
    if (localObject1 == null)
    {
      GMTrace.o(13967367864320L, 104065);
      return localArrayList;
    }
    parame = new HashMap();
    int i = ((Cursor)localObject1).getColumnIndex("name");
    int j = ((Cursor)localObject1).getColumnIndex("type");
    while (((Cursor)localObject1).moveToNext()) {
      parame.put(((Cursor)localObject1).getString(i), ((Cursor)localObject1).getString(j));
    }
    ((Cursor)localObject1).close();
    parama = parama.uvr.entrySet().iterator();
    while (parama.hasNext())
    {
      Object localObject2 = (Map.Entry)parama.next();
      localObject1 = (String)((Map.Entry)localObject2).getValue();
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        String str = (String)parame.get(localObject2);
        if (str == null)
        {
          localArrayList.add("ALTER TABLE " + paramString + " ADD COLUMN " + (String)localObject2 + " " + (String)localObject1 + ";");
          parame.remove(localObject2);
        }
        else if (!((String)localObject1).toLowerCase().startsWith(str.toLowerCase()))
        {
          v.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + (String)localObject2 + ", " + str + "<o-n>" + (String)localObject1);
          parame.remove(localObject2);
        }
      }
    }
    GMTrace.o(13967367864320L, 104065);
    return localArrayList;
  }
  
  private static String[] a(String[] paramArrayOfString, ContentValues paramContentValues)
  {
    GMTrace.i(13969783783424L, 104083);
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = bf.mz(paramContentValues.getAsString(paramArrayOfString[i]));
      i += 1;
    }
    GMTrace.o(13969783783424L, 104083);
    return arrayOfString;
  }
  
  private boolean b(ContentValues paramContentValues)
  {
    GMTrace.i(13969112694784L, 104078);
    Cursor localCursor = this.gUp.query(getTableName(), this.uvt.columns, this.uvt.uvq + " = ?", new String[] { bf.mz(paramContentValues.getAsString(this.uvt.uvq)) }, null, null, null);
    boolean bool = c.a(paramContentValues, localCursor);
    localCursor.close();
    GMTrace.o(13969112694784L, 104078);
    return bool;
  }
  
  public Cursor Kl()
  {
    GMTrace.i(13969246912512L, 104079);
    Cursor localCursor = this.gUp.query(getTableName(), this.uvt.columns, null, null, null, null, null);
    GMTrace.o(13969246912512L, 104079);
    return localCursor;
  }
  
  public boolean a(long paramLong, T paramT)
  {
    GMTrace.i(13968575823872L, 104074);
    paramT = paramT.pv();
    if ((paramT == null) || (paramT.size() <= 0))
    {
      Qs("update failed, value.size <= 0");
      GMTrace.o(13968575823872L, 104074);
      return false;
    }
    Cursor localCursor = this.gUp.query(getTableName(), this.uvt.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (c.a(paramT, localCursor))
    {
      localCursor.close();
      Qr("no need replace , fields no change");
      GMTrace.o(13968575823872L, 104074);
      return true;
    }
    localCursor.close();
    if (this.gUp.update(getTableName(), paramT, "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        doNotify();
      }
      GMTrace.o(13968575823872L, 104074);
      return bool;
    }
  }
  
  public boolean a(T paramT)
  {
    GMTrace.i(13968978477056L, 104077);
    boolean bool;
    ContentValues localContentValues;
    int j;
    int k;
    if (!bf.mA(this.uvt.uvq))
    {
      bool = true;
      Assert.assertTrue("replace primaryKey == null", bool);
      localContentValues = paramT.pv();
      if (localContentValues != null)
      {
        j = localContentValues.size();
        k = paramT.sY().hXn.length;
        if (!localContentValues.containsKey("rowid")) {
          break label104;
        }
      }
    }
    label104:
    for (int i = 1;; i = 0)
    {
      if (j == i + k) {
        break label109;
      }
      Qs("replace failed, cv.size() != item.fields().length");
      GMTrace.o(13968978477056L, 104077);
      return false;
      bool = false;
      break;
    }
    label109:
    if (b(localContentValues))
    {
      Qr("no need replace , fields no change");
      GMTrace.o(13968978477056L, 104077);
      return true;
    }
    if (this.gUp.replace(getTableName(), this.uvt.uvq, localContentValues) > 0L)
    {
      Qq(this.uvt.uvq);
      GMTrace.o(13968978477056L, 104077);
      return true;
    }
    Qs("replace failed");
    GMTrace.o(13968978477056L, 104077);
    return false;
  }
  
  public boolean a(T paramT, boolean paramBoolean)
  {
    GMTrace.i(13967770517504L, 104068);
    ContentValues localContentValues = paramT.pv();
    if ((localContentValues == null) || (localContentValues.size() <= 0))
    {
      Qs("insert failed, value.size <= 0");
      GMTrace.o(13967770517504L, 104068);
      return false;
    }
    paramT.uvp = this.gUp.insert(getTableName(), this.uvt.uvq, localContentValues);
    if (paramT.uvp <= 0L)
    {
      Qs("insert failed");
      GMTrace.o(13967770517504L, 104068);
      return false;
    }
    localContentValues.put("rowid", Long.valueOf(paramT.uvp));
    if (paramBoolean) {
      Qq(localContentValues.getAsString(this.uvt.uvq));
    }
    GMTrace.o(13967770517504L, 104068);
    return true;
  }
  
  public boolean a(T paramT, boolean paramBoolean, String... paramVarArgs)
  {
    boolean bool = false;
    GMTrace.i(13968710041600L, 104075);
    paramT = paramT.pv();
    if ((paramT == null) || (paramT.size() <= 0))
    {
      Qs("update failed, value.size <= 0");
      GMTrace.o(13968710041600L, 104075);
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      Qr("update with primary key");
      if (b(paramT))
      {
        Qr("no need replace , fields no change");
        GMTrace.o(13968710041600L, 104075);
        return true;
      }
      if (this.gUp.update(getTableName(), paramT, this.uvt.uvq + " = ?", new String[] { bf.mz(paramT.getAsString(this.uvt.uvq)) }) > 0) {
        bool = true;
      }
      if ((bool) && (paramBoolean)) {
        doNotify();
      }
      GMTrace.o(13968710041600L, 104075);
      return bool;
    }
    StringBuilder localStringBuilder = a(paramT, paramVarArgs);
    if (localStringBuilder == null)
    {
      Qs("update failed, check keys failed");
      GMTrace.o(13968710041600L, 104075);
      return false;
    }
    if (this.gUp.update(getTableName(), paramT, localStringBuilder.toString(), a(paramVarArgs, paramT)) > 0)
    {
      if (paramBoolean) {
        Qq(paramT.getAsString(this.uvt.uvq));
      }
      GMTrace.o(13968710041600L, 104075);
      return true;
    }
    Qs("update failed");
    GMTrace.o(13968710041600L, 104075);
    return false;
  }
  
  public boolean a(T paramT, String... paramVarArgs)
  {
    GMTrace.i(13968038952960L, 104070);
    boolean bool = b(paramT, true, paramVarArgs);
    GMTrace.o(13968038952960L, 104070);
    return bool;
  }
  
  public final boolean b(long paramLong, T paramT)
  {
    GMTrace.i(13968307388416L, 104072);
    Cursor localCursor = this.gUp.a(getTableName(), this.uvt.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      paramT.b(localCursor);
      localCursor.close();
      GMTrace.o(13968307388416L, 104072);
      return true;
    }
    localCursor.close();
    GMTrace.o(13968307388416L, 104072);
    return false;
  }
  
  public boolean b(T paramT)
  {
    GMTrace.i(13967636299776L, 104067);
    boolean bool = a(paramT, true);
    GMTrace.o(13967636299776L, 104067);
    return bool;
  }
  
  public boolean b(T paramT, boolean paramBoolean, String... paramVarArgs)
  {
    boolean bool = false;
    GMTrace.i(13967904735232L, 104069);
    paramT = paramT.pv();
    if ((paramT == null) || (paramT.size() <= 0))
    {
      Qs("delete failed, value.size <= 0");
      GMTrace.o(13967904735232L, 104069);
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      Qr("delete with primary key");
      if (this.gUp.delete(getTableName(), this.uvt.uvq + " = ?", new String[] { bf.mz(paramT.getAsString(this.uvt.uvq)) }) > 0) {
        bool = true;
      }
      if ((bool) && (paramBoolean)) {
        doNotify();
      }
      GMTrace.o(13967904735232L, 104069);
      return bool;
    }
    StringBuilder localStringBuilder = a(paramT, paramVarArgs);
    if (localStringBuilder == null)
    {
      Qs("delete failed, check keys failed");
      GMTrace.o(13967904735232L, 104069);
      return false;
    }
    if ((this.gUp.delete(getTableName(), localStringBuilder.toString(), a(paramVarArgs, paramT)) > 0) && (paramBoolean))
    {
      Qq(this.uvt.uvq);
      GMTrace.o(13967904735232L, 104069);
      return true;
    }
    Qs("delete failed");
    GMTrace.o(13967904735232L, 104069);
    return false;
  }
  
  public boolean b(T paramT, String... paramVarArgs)
  {
    GMTrace.i(13968441606144L, 104073);
    ContentValues localContentValues = paramT.pv();
    if ((localContentValues == null) || (localContentValues.size() <= 0))
    {
      Qs("get failed, value.size <= 0");
      GMTrace.o(13968441606144L, 104073);
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      Qr("get with primary key");
      paramVarArgs = this.gUp.a(getTableName(), this.uvt.columns, this.uvt.uvq + " = ?", new String[] { bf.mz(localContentValues.getAsString(this.uvt.uvq)) }, null, null, null, 2);
      if (paramVarArgs.moveToFirst())
      {
        paramT.b(paramVarArgs);
        paramVarArgs.close();
        GMTrace.o(13968441606144L, 104073);
        return true;
      }
      paramVarArgs.close();
      GMTrace.o(13968441606144L, 104073);
      return false;
    }
    StringBuilder localStringBuilder = a(localContentValues, paramVarArgs);
    if (localStringBuilder == null)
    {
      Qs("get failed, check keys failed");
      GMTrace.o(13968441606144L, 104073);
      return false;
    }
    paramVarArgs = this.gUp.a(getTableName(), this.uvt.columns, localStringBuilder.toString(), a(paramVarArgs, localContentValues), null, null, null, 2);
    if (paramVarArgs.moveToFirst())
    {
      paramT.b(paramVarArgs);
      paramVarArgs.close();
      GMTrace.o(13968441606144L, 104073);
      return true;
    }
    paramVarArgs.close();
    Qr("get failed, not found");
    GMTrace.o(13968441606144L, 104073);
    return false;
  }
  
  public boolean c(T paramT, String... paramVarArgs)
  {
    GMTrace.i(13968844259328L, 104076);
    boolean bool = a(paramT, true, paramVarArgs);
    GMTrace.o(13968844259328L, 104076);
    return bool;
  }
  
  public boolean delete(long paramLong)
  {
    boolean bool = true;
    GMTrace.i(13968173170688L, 104071);
    if (this.gUp.delete(getTableName(), "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (;;)
    {
      if (bool) {
        doNotify();
      }
      GMTrace.o(13968173170688L, 104071);
      return bool;
      bool = false;
    }
  }
  
  public final boolean eE(String paramString1, String paramString2)
  {
    GMTrace.i(13967502082048L, 104066);
    if (paramString1.length() == 0)
    {
      Qs("null or nill table");
      GMTrace.o(13967502082048L, 104066);
      return false;
    }
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      Qs("null or nill sql");
      GMTrace.o(13967502082048L, 104066);
      return false;
    }
    boolean bool = this.gUp.eE(paramString1, paramString2);
    GMTrace.o(13967502082048L, 104066);
    return bool;
  }
  
  public int getCount()
  {
    GMTrace.i(13969381130240L, 104080);
    Cursor localCursor = rawQuery("select count(*) from " + getTableName(), new String[0]);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      int i = localCursor.getInt(0);
      localCursor.close();
      GMTrace.o(13969381130240L, 104080);
      return i;
    }
    GMTrace.o(13969381130240L, 104080);
    return 0;
  }
  
  public String getTableName()
  {
    GMTrace.i(13967099428864L, 104063);
    String str = this.uvu;
    GMTrace.o(13967099428864L, 104063);
    return str;
  }
  
  public final Cursor rawQuery(String paramString, String... paramVarArgs)
  {
    GMTrace.i(13969515347968L, 104081);
    paramString = this.gUp.rawQuery(paramString, paramVarArgs);
    GMTrace.o(13969515347968L, 104081);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/e/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */