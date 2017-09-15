package com.tencent.mm.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MCacheItem
  implements Parcelable
{
  public static final Parcelable.Creator<MCacheItem> CREATOR;
  private c gMG;
  
  static
  {
    GMTrace.i(13640950349824L, 101633);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(13640950349824L, 101633);
  }
  
  public MCacheItem(Parcel paramParcel)
  {
    GMTrace.i(13640279261184L, 101628);
    this.gMG = c(paramParcel);
    GMTrace.o(13640279261184L, 101628);
  }
  
  public MCacheItem(c paramc)
  {
    GMTrace.i(13640413478912L, 101629);
    this.gMG = paramc;
    GMTrace.o(13640413478912L, 101629);
  }
  
  /* Error */
  private c c(Parcel paramParcel)
  {
    // Byte code:
    //   0: ldc2_w 54
    //   3: ldc 56
    //   5: invokestatic 27	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: aload_1
    //   9: invokevirtual 62	android/os/Parcel:readString	()Ljava/lang/String;
    //   12: invokestatic 68	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   15: astore 4
    //   17: aload_0
    //   18: aload 4
    //   20: invokevirtual 72	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   23: checkcast 74	com/tencent/mm/sdk/e/c
    //   26: putfield 47	com/tencent/mm/cache/MCacheItem:gMG	Lcom/tencent/mm/sdk/e/c;
    //   29: aload 4
    //   31: invokestatic 78	com/tencent/mm/sdk/e/c:u	(Ljava/lang/Class;)[Ljava/lang/reflect/Field;
    //   34: astore 4
    //   36: aload 4
    //   38: arraylength
    //   39: istore_3
    //   40: iconst_0
    //   41: istore_2
    //   42: iload_2
    //   43: iload_3
    //   44: if_icmpge +119 -> 163
    //   47: aload 4
    //   49: iload_2
    //   50: aaload
    //   51: astore 5
    //   53: getstatic 82	com/tencent/mm/cache/MCacheItem$a:gMI	Ljava/util/Map;
    //   56: aload 5
    //   58: invokevirtual 88	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   61: invokeinterface 94 2 0
    //   66: checkcast 96	java/lang/reflect/Method
    //   69: astore 6
    //   71: aload 6
    //   73: ifnull +30 -> 103
    //   76: aload 6
    //   78: aconst_null
    //   79: iconst_3
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload 5
    //   91: aastore
    //   92: dup
    //   93: iconst_2
    //   94: aload_0
    //   95: getfield 47	com/tencent/mm/cache/MCacheItem:gMG	Lcom/tencent/mm/sdk/e/c;
    //   98: aastore
    //   99: invokevirtual 100	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: iload_2
    //   104: iconst_1
    //   105: iadd
    //   106: istore_2
    //   107: goto -65 -> 42
    //   110: astore 5
    //   112: ldc 102
    //   114: ldc 104
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload 5
    //   124: invokestatic 110	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   127: aastore
    //   128: invokestatic 116	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: goto -28 -> 103
    //   134: astore_1
    //   135: ldc 102
    //   137: ldc 104
    //   139: iconst_1
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: aload_1
    //   146: invokestatic 110	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   149: aastore
    //   150: invokestatic 116	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: ldc2_w 54
    //   156: ldc 56
    //   158: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   161: aconst_null
    //   162: areturn
    //   163: aload_0
    //   164: getfield 47	com/tencent/mm/cache/MCacheItem:gMG	Lcom/tencent/mm/sdk/e/c;
    //   167: astore_1
    //   168: ldc2_w 54
    //   171: ldc 56
    //   173: invokestatic 35	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   176: aload_1
    //   177: areturn
    //   178: astore 5
    //   180: goto -151 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	MCacheItem
    //   0	183	1	paramParcel	Parcel
    //   41	66	2	i	int
    //   39	6	3	j	int
    //   15	33	4	localObject1	Object
    //   51	39	5	localObject2	Object
    //   110	13	5	localException1	Exception
    //   178	1	5	localException2	Exception
    //   69	8	6	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   76	103	110	java/lang/Exception
    //   8	17	134	java/lang/Exception
    //   29	40	134	java/lang/Exception
    //   53	71	134	java/lang/Exception
    //   112	131	134	java/lang/Exception
    //   163	168	134	java/lang/Exception
    //   17	29	178	java/lang/Exception
  }
  
  public int describeContents()
  {
    GMTrace.i(13640681914368L, 101631);
    GMTrace.o(13640681914368L, 101631);
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(13640816132096L, 101632);
    paramParcel.writeString(this.gMG.getClass().getName());
    Field[] arrayOfField = c.u(this.gMG.getClass());
    int i = arrayOfField.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        Field localField = arrayOfField[paramInt];
        Method localMethod = (Method)a.gMH.get(localField.getType());
        if (localMethod != null) {}
        try
        {
          localMethod.invoke(null, new Object[] { paramParcel, localField, this.gMG });
          paramInt += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(localException) });
          }
        }
      }
    }
    GMTrace.o(13640816132096L, 101632);
  }
  
  static class a
  {
    public static Map<Class<?>, Method> gMH;
    public static Map<Class<?>, Method> gMI;
    
    static
    {
      GMTrace.i(13640145043456L, 101627);
      gMH = new HashMap();
      gMI = new HashMap();
      try
      {
        gMH.put(byte[].class, a.class.getMethod("keep_writeByteArray", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Short.TYPE, a.class.getMethod("keep_writeShort", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Short.class, a.class.getMethod("keep_writeShort", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Boolean.TYPE, a.class.getMethod("keep_writeBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Boolean.class, a.class.getMethod("keep_writeBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Integer.TYPE, a.class.getMethod("keep_writeInt", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Integer.class, a.class.getMethod("keep_writeInt", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Float.TYPE, a.class.getMethod("keep_writeFloat", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Float.class, a.class.getMethod("keep_writeFloat", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Double.TYPE, a.class.getMethod("keep_writeDouble", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Double.class, a.class.getMethod("keep_writeDouble", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Long.TYPE, a.class.getMethod("keep_writeLong", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(Long.class, a.class.getMethod("keep_writeLong", new Class[] { Parcel.class, Field.class, Object.class }));
        gMH.put(String.class, a.class.getMethod("keep_writeString", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(byte[].class, a.class.getMethod("keep_readByteArray", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Short.TYPE, a.class.getMethod("keep_readShort", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Short.class, a.class.getMethod("keep_readShort", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Boolean.TYPE, a.class.getMethod("keep_readBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Boolean.class, a.class.getMethod("keep_readBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Integer.TYPE, a.class.getMethod("keep_readInt", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Integer.class, a.class.getMethod("keep_readInt", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Float.TYPE, a.class.getMethod("keep_readFloat", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Float.class, a.class.getMethod("keep_readFloat", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Double.TYPE, a.class.getMethod("keep_readDouble", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Double.class, a.class.getMethod("keep_readDouble", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Long.TYPE, a.class.getMethod("keep_readLong", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(Long.class, a.class.getMethod("keep_readLong", new Class[] { Parcel.class, Field.class, Object.class }));
        gMI.put(String.class, a.class.getMethod("keep_readString", new Class[] { Parcel.class, Field.class, Object.class }));
        GMTrace.o(13640145043456L, 101627);
        return;
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(localException) });
        GMTrace.o(13640145043456L, 101627);
      }
    }
    
    a()
    {
      GMTrace.i(13637863342080L, 101610);
      GMTrace.o(13637863342080L, 101610);
    }
    
    public static void keep_readBoolean(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13639339737088L, 101621);
      try
      {
        if (paramParcel.readInt() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramField.setBoolean(paramObject, bool);
          GMTrace.o(13639339737088L, 101621);
          return;
        }
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13639339737088L, 101621);
      }
    }
    
    public static void keep_readByteArray(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13639071301632L, 101619);
      try
      {
        paramField.set(paramObject, paramParcel.createByteArray());
        GMTrace.o(13639071301632L, 101619);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13639071301632L, 101619);
      }
    }
    
    public static void keep_readDouble(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13639742390272L, 101624);
      try
      {
        paramField.setDouble(paramObject, paramParcel.readDouble());
        GMTrace.o(13639742390272L, 101624);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13639742390272L, 101624);
      }
    }
    
    public static void keep_readFloat(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13639608172544L, 101623);
      try
      {
        paramField.setFloat(paramObject, paramParcel.readFloat());
        GMTrace.o(13639608172544L, 101623);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13639608172544L, 101623);
      }
    }
    
    public static void keep_readInt(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13639473954816L, 101622);
      try
      {
        paramField.setInt(paramObject, paramParcel.readInt());
        GMTrace.o(13639473954816L, 101622);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13639473954816L, 101622);
      }
    }
    
    public static void keep_readLong(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13639876608000L, 101625);
      try
      {
        paramField.set(paramObject, Long.valueOf(paramParcel.readLong()));
        GMTrace.o(13639876608000L, 101625);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13639876608000L, 101625);
      }
    }
    
    public static void keep_readShort(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13639205519360L, 101620);
      try
      {
        paramField.setShort(paramObject, (short)paramParcel.readInt());
        GMTrace.o(13639205519360L, 101620);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13639205519360L, 101620);
      }
    }
    
    public static void keep_readString(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13640010825728L, 101626);
      try
      {
        paramField.set(paramObject, paramParcel.readString());
        GMTrace.o(13640010825728L, 101626);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13640010825728L, 101626);
      }
    }
    
    public static void keep_writeBoolean(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13638265995264L, 101613);
      try
      {
        if (paramField.getBoolean(paramObject)) {}
        for (int i = 1;; i = 0)
        {
          paramParcel.writeInt(i);
          GMTrace.o(13638265995264L, 101613);
          return;
        }
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13638265995264L, 101613);
      }
    }
    
    public static void keep_writeByteArray(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13637997559808L, 101611);
      try
      {
        paramParcel.writeByteArray((byte[])paramField.get(paramObject));
        GMTrace.o(13637997559808L, 101611);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13637997559808L, 101611);
      }
    }
    
    public static void keep_writeDouble(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13638668648448L, 101616);
      try
      {
        paramParcel.writeDouble(paramField.getDouble(paramObject));
        GMTrace.o(13638668648448L, 101616);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13638668648448L, 101616);
      }
    }
    
    public static void keep_writeFloat(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13638534430720L, 101615);
      try
      {
        paramParcel.writeFloat(paramField.getFloat(paramObject));
        GMTrace.o(13638534430720L, 101615);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13638534430720L, 101615);
      }
    }
    
    public static void keep_writeInt(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13638400212992L, 101614);
      try
      {
        paramParcel.writeInt(paramField.getInt(paramObject));
        GMTrace.o(13638400212992L, 101614);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13638400212992L, 101614);
      }
    }
    
    public static void keep_writeLong(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13638802866176L, 101617);
      try
      {
        paramParcel.writeLong(paramField.getLong(paramObject));
        GMTrace.o(13638802866176L, 101617);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13638802866176L, 101617);
      }
    }
    
    public static void keep_writeShort(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13638131777536L, 101612);
      try
      {
        paramParcel.writeInt(paramField.getShort(paramObject));
        GMTrace.o(13638131777536L, 101612);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13638131777536L, 101612);
      }
    }
    
    public static void keep_writeString(Parcel paramParcel, Field paramField, Object paramObject)
    {
      GMTrace.i(13638937083904L, 101618);
      try
      {
        paramParcel.writeString((String)paramField.get(paramObject));
        GMTrace.o(13638937083904L, 101618);
        return;
      }
      catch (Exception paramParcel)
      {
        v.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bf.g(paramParcel) });
        GMTrace.o(13638937083904L, 101618);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/cache/MCacheItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */