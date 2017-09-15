package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class b
{
  private static final Map<Class<?>, Object> gMH;
  private static final Map<Class<?>, Object> gMI;
  private static final Map<Class<?>, String> uvo;
  
  static
  {
    GMTrace.i(13973273444352L, 104109);
    gMH = new HashMap();
    gMI = new HashMap();
    uvo = new HashMap();
    try
    {
      gMH.put(byte[].class, new Object() {});
      gMH.put(Short.TYPE, new Object() {});
      gMH.put(Short.class, new Object() {});
      gMH.put(Boolean.TYPE, new Object() {});
      gMH.put(Boolean.class, new Object() {});
      gMH.put(Integer.TYPE, new Object() {});
      gMH.put(Integer.class, new Object() {});
      gMH.put(Float.TYPE, new Object() {});
      gMH.put(Float.class, new Object() {});
      gMH.put(Double.TYPE, new Object() {});
      gMH.put(Double.class, new Object() {});
      gMH.put(Long.TYPE, new Object() {});
      gMH.put(Long.class, new Object() {});
      gMH.put(String.class, new Object() {});
      gMI.put(byte[].class, new Object() {});
      gMI.put(Short.TYPE, new Object() {});
      gMI.put(Short.class, new Object() {});
      gMI.put(Boolean.TYPE, new Object() {});
      gMI.put(Boolean.class, new Object() {});
      gMI.put(Integer.TYPE, new Object() {});
      gMI.put(Integer.class, new Object() {});
      gMI.put(Float.TYPE, new Object() {});
      gMI.put(Float.class, new Object() {});
      gMI.put(Double.TYPE, new Object() {});
      gMI.put(Double.class, new Object() {});
      gMI.put(Long.TYPE, new Object() {});
      gMI.put(Long.class, new Object() {});
      gMI.put(String.class, new Object() {});
      uvo.put(byte[].class, "BLOB");
      uvo.put(Short.TYPE, "SHORT");
      uvo.put(Short.class, "SHORT");
      uvo.put(Boolean.TYPE, "INTEGER");
      uvo.put(Boolean.class, "INTEGER");
      uvo.put(Integer.TYPE, "INTEGER");
      uvo.put(Integer.class, "INTEGER");
      uvo.put(Float.TYPE, "FLOAT");
      uvo.put(Float.class, "FLOAT");
      uvo.put(Double.TYPE, "DOUBLE");
      uvo.put(Double.class, "DOUBLE");
      uvo.put(Long.TYPE, "LONG");
      uvo.put(Long.class, "LONG");
      uvo.put(String.class, "TEXT");
      GMTrace.o(13973273444352L, 104109);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", localException, "", new Object[0]);
      GMTrace.o(13973273444352L, 104109);
    }
  }
  
  public static void keep_getBlob(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    GMTrace.i(13971260178432L, 104094);
    try
    {
      paramContentValues.put(c.a(paramField), (byte[])paramField.get(paramObject));
      GMTrace.o(13971260178432L, 104094);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13971260178432L, 104094);
    }
  }
  
  public static void keep_getBoolean(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    GMTrace.i(13971797049344L, 104098);
    try
    {
      String str = c.a(paramField);
      if (paramField.getBoolean(paramObject)) {}
      for (int i = 1;; i = 0)
      {
        paramContentValues.put(str, Integer.valueOf(i));
        GMTrace.o(13971797049344L, 104098);
        return;
      }
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13971797049344L, 104098);
    }
  }
  
  public static void keep_getDouble(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    GMTrace.i(13972602355712L, 104104);
    try
    {
      if (!paramField.getType().equals(Double.TYPE))
      {
        paramContentValues.put(c.a(paramField), (Double)paramField.get(paramObject));
        GMTrace.o(13972602355712L, 104104);
        return;
      }
      paramContentValues.put(c.a(paramField), Double.valueOf(paramField.getDouble(paramObject)));
      GMTrace.o(13972602355712L, 104104);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13972602355712L, 104104);
    }
  }
  
  public static void keep_getFloat(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    GMTrace.i(13972333920256L, 104102);
    try
    {
      if (!paramField.getType().equals(Float.TYPE))
      {
        paramContentValues.put(c.a(paramField), (Float)paramField.get(paramObject));
        GMTrace.o(13972333920256L, 104102);
        return;
      }
      paramContentValues.put(c.a(paramField), Float.valueOf(paramField.getFloat(paramObject)));
      GMTrace.o(13972333920256L, 104102);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13972333920256L, 104102);
    }
  }
  
  public static void keep_getInt(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    GMTrace.i(13972065484800L, 104100);
    try
    {
      if (!paramField.getType().equals(Integer.TYPE))
      {
        paramContentValues.put(c.a(paramField), (Integer)paramField.get(paramObject));
        GMTrace.o(13972065484800L, 104100);
        return;
      }
      paramContentValues.put(c.a(paramField), Integer.valueOf(paramField.getInt(paramObject)));
      GMTrace.o(13972065484800L, 104100);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13972065484800L, 104100);
    }
  }
  
  public static void keep_getLong(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    GMTrace.i(13972870791168L, 104106);
    try
    {
      if (!paramField.getType().equals(Long.TYPE))
      {
        paramContentValues.put(c.a(paramField), (Long)paramField.get(paramObject));
        GMTrace.o(13972870791168L, 104106);
        return;
      }
      paramContentValues.put(c.a(paramField), Long.valueOf(paramField.getLong(paramObject)));
      GMTrace.o(13972870791168L, 104106);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13972870791168L, 104106);
    }
  }
  
  public static void keep_getShort(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    GMTrace.i(13971528613888L, 104096);
    try
    {
      paramContentValues.put(c.a(paramField), Short.valueOf(paramField.getShort(paramObject)));
      GMTrace.o(13971528613888L, 104096);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13971528613888L, 104096);
    }
  }
  
  public static void keep_getString(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    GMTrace.i(13973139226624L, 104108);
    try
    {
      paramContentValues.put(c.a(paramField), (String)paramField.get(paramObject));
      GMTrace.o(13973139226624L, 104108);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13973139226624L, 104108);
    }
  }
  
  public static void keep_setBlob(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    GMTrace.i(13971125960704L, 104093);
    try
    {
      paramField.set(paramObject, paramCursor.getBlob(paramInt));
      GMTrace.o(13971125960704L, 104093);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13971125960704L, 104093);
    }
  }
  
  public static void keep_setBoolean(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    GMTrace.i(13971662831616L, 104097);
    for (;;)
    {
      try
      {
        if (paramField.getType().equals(Boolean.TYPE))
        {
          if (paramCursor.getInt(paramInt) != 0)
          {
            bool = true;
            paramField.setBoolean(paramObject, bool);
            GMTrace.o(13971662831616L, 104097);
          }
        }
        else
        {
          paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
          GMTrace.o(13971662831616L, 104097);
          return;
        }
      }
      catch (Exception paramField)
      {
        v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
        GMTrace.o(13971662831616L, 104097);
        return;
      }
      boolean bool = false;
    }
  }
  
  public static void keep_setDouble(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    GMTrace.i(13972468137984L, 104103);
    try
    {
      if (paramField.getType().equals(Double.TYPE))
      {
        paramField.setDouble(paramObject, paramCursor.getDouble(paramInt));
        GMTrace.o(13972468137984L, 104103);
        return;
      }
      paramField.set(paramObject, Double.valueOf(paramCursor.getDouble(paramInt)));
      GMTrace.o(13972468137984L, 104103);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13972468137984L, 104103);
    }
  }
  
  public static void keep_setFloat(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    GMTrace.i(13972199702528L, 104101);
    try
    {
      if (paramField.getType().equals(Float.TYPE))
      {
        paramField.setFloat(paramObject, paramCursor.getFloat(paramInt));
        GMTrace.o(13972199702528L, 104101);
        return;
      }
      paramField.set(paramObject, Float.valueOf(paramCursor.getFloat(paramInt)));
      GMTrace.o(13972199702528L, 104101);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13972199702528L, 104101);
    }
  }
  
  public static void keep_setInt(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    GMTrace.i(13971931267072L, 104099);
    try
    {
      if (paramField.getType().equals(Integer.TYPE))
      {
        paramField.setInt(paramObject, paramCursor.getInt(paramInt));
        GMTrace.o(13971931267072L, 104099);
        return;
      }
      paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
      GMTrace.o(13971931267072L, 104099);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13971931267072L, 104099);
    }
  }
  
  public static void keep_setLong(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    GMTrace.i(13972736573440L, 104105);
    try
    {
      if (paramField.getType().equals(Long.TYPE))
      {
        paramField.setLong(paramObject, paramCursor.getLong(paramInt));
        GMTrace.o(13972736573440L, 104105);
        return;
      }
      paramField.set(paramObject, Long.valueOf(paramCursor.getLong(paramInt)));
      GMTrace.o(13972736573440L, 104105);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13972736573440L, 104105);
    }
  }
  
  public static void keep_setShort(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    GMTrace.i(13971394396160L, 104095);
    try
    {
      if (paramField.getType().equals(Short.TYPE))
      {
        paramField.setShort(paramObject, paramCursor.getShort(paramInt));
        GMTrace.o(13971394396160L, 104095);
        return;
      }
      paramField.set(paramObject, Short.valueOf(paramCursor.getShort(paramInt)));
      GMTrace.o(13971394396160L, 104095);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13971394396160L, 104095);
    }
  }
  
  public static void keep_setString(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    GMTrace.i(13973005008896L, 104107);
    try
    {
      paramField.set(paramObject, paramCursor.getString(paramInt));
      GMTrace.o(13973005008896L, 104107);
      return;
    }
    catch (Exception paramField)
    {
      v.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      GMTrace.o(13973005008896L, 104107);
    }
  }
  
  public static String t(Class<?> paramClass)
  {
    GMTrace.i(13970991742976L, 104092);
    paramClass = (String)uvo.get(paramClass);
    GMTrace.o(13970991742976L, 104092);
    return paramClass;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */