package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.as.b;
import com.tencent.mm.sdk.platformtools.as.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

public final class t
  extends m
  implements as.c<Object, Object>
{
  public static final String[] gUn;
  private long hWE;
  private g hnp;
  private as<Object, Object> uxo;
  private as<Object, Object> uxp;
  private BlockingQueue<Integer> uxq;
  private BlockingQueue<String> uxr;
  
  static
  {
    GMTrace.i(13541897666560L, 100895);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )" };
    GMTrace.o(13541897666560L, 100895);
  }
  
  public t(g paramg)
  {
    GMTrace.i(13539481747456L, 100877);
    this.uxq = new LinkedBlockingQueue();
    this.uxr = new LinkedBlockingQueue();
    this.hnp = paramg;
    this.uxo = new as(this, h.vL().nIe.getLooper(), 100, 20, 60000L, 100L);
    this.uxo.setTag(Integer.valueOf(1));
    this.uxp = new as(this, h.vL().nIe.getLooper(), 100, 20, 60000L, 100L);
    this.uxp.setTag(Integer.valueOf(3));
    GMTrace.o(13539481747456L, 100877);
  }
  
  private static boolean a(String paramString, Object paramObject, boolean paramBoolean)
  {
    GMTrace.i(13540287053824L, 100883);
    if ((paramObject == null) && (paramBoolean))
    {
      GMTrace.o(13540287053824L, 100883);
      return true;
    }
    if ((paramString.equals("INT")) && ((paramObject instanceof Integer)))
    {
      GMTrace.o(13540287053824L, 100883);
      return true;
    }
    if ((paramString.equals("LONG")) && ((paramObject instanceof Long)))
    {
      GMTrace.o(13540287053824L, 100883);
      return true;
    }
    if ((paramString.equals("STRING")) && ((paramObject instanceof String)))
    {
      GMTrace.o(13540287053824L, 100883);
      return true;
    }
    if ((paramString.equals("BOOLEAN")) && ((paramObject instanceof Boolean)))
    {
      GMTrace.o(13540287053824L, 100883);
      return true;
    }
    if ((paramString.equals("FLOAT")) && ((paramObject instanceof Float)))
    {
      GMTrace.o(13540287053824L, 100883);
      return true;
    }
    if ((paramString.equals("DOUBLE")) && ((paramObject instanceof Double)))
    {
      GMTrace.o(13540287053824L, 100883);
      return true;
    }
    if ((paramObject != null) && (b.bIk())) {
      Assert.assertTrue("checkType failed, input type and value[" + paramString + ", " + paramObject + "] are not match", false);
    }
    if (paramBoolean) {
      v.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", new Object[] { paramString, paramObject });
    }
    GMTrace.o(13540287053824L, 100883);
    return false;
  }
  
  private static int bz(Object paramObject)
  {
    GMTrace.i(13540421271552L, 100884);
    if ((paramObject instanceof Integer))
    {
      GMTrace.o(13540421271552L, 100884);
      return 1;
    }
    if ((paramObject instanceof Long))
    {
      GMTrace.o(13540421271552L, 100884);
      return 2;
    }
    if ((paramObject instanceof String))
    {
      GMTrace.o(13540421271552L, 100884);
      return 3;
    }
    if ((paramObject instanceof Boolean))
    {
      GMTrace.o(13540421271552L, 100884);
      return 4;
    }
    if ((paramObject instanceof Float))
    {
      GMTrace.o(13540421271552L, 100884);
      return 5;
    }
    if ((paramObject instanceof Double))
    {
      GMTrace.o(13540421271552L, 100884);
      return 6;
    }
    v.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + paramObject.getClass().toString());
    GMTrace.o(13540421271552L, 100884);
    return -1;
  }
  
  private static Object i(int paramInt, String paramString)
  {
    GMTrace.i(13540555489280L, 100885);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(13540555489280L, 100885);
      return null;
      try
      {
        paramString = Integer.valueOf(paramString);
        GMTrace.o(13540555489280L, 100885);
        return paramString;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.ConfigStorage", "exception:%s", new Object[] { bf.g(paramString) });
      }
      paramString = Long.valueOf(paramString);
      GMTrace.o(13540555489280L, 100885);
      return paramString;
      GMTrace.o(13540555489280L, 100885);
      return paramString;
      paramString = Boolean.valueOf(paramString);
      GMTrace.o(13540555489280L, 100885);
      return paramString;
      paramString = Float.valueOf(paramString);
      GMTrace.o(13540555489280L, 100885);
      return paramString;
      paramString = Double.valueOf(paramString);
      GMTrace.o(13540555489280L, 100885);
      return paramString;
    }
  }
  
  protected final boolean Fd()
  {
    GMTrace.i(13540689707008L, 100886);
    if ((this.hnp == null) || (this.hnp.bKd()))
    {
      if (this.hnp == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.hnp.bKd()))
      {
        v.w("MicroMsg.ConfigStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        GMTrace.o(13540689707008L, 100886);
        return false;
      }
    }
    GMTrace.o(13540689707008L, 100886);
    return true;
  }
  
  public final boolean Kd()
  {
    GMTrace.i(13540823924736L, 100887);
    if (this.hnp.inTransaction())
    {
      v.i("MicroMsg.ConfigStorage", "summer preAppend inTransaction return false");
      GMTrace.o(13540823924736L, 100887);
      return false;
    }
    this.hWE = this.hnp.cs(Thread.currentThread().getId());
    if (this.hWE <= 0L)
    {
      v.i("MicroMsg.ConfigStorage", "summer preAppend ticket: " + this.hWE + " return false");
      GMTrace.o(13540823924736L, 100887);
      return false;
    }
    GMTrace.o(13540823924736L, 100887);
    return true;
  }
  
  public final void Ke()
  {
    GMTrace.i(13541092360192L, 100889);
    if (this.hWE > 0L) {
      this.hnp.aD(this.hWE);
    }
    GMTrace.o(13541092360192L, 100889);
  }
  
  public final void a(as<Object, Object> paramas, as.b<Object, Object> paramb)
  {
    GMTrace.i(13540958142464L, 100888);
    Object localObject1 = paramb.sUK;
    Object localObject2 = paramb.values;
    int i = paramb.utu;
    switch (((Integer)paramas.getTag()).intValue())
    {
    }
    for (;;)
    {
      GMTrace.o(13540958142464L, 100888);
      return;
      if (i == 1)
      {
        if ((localObject2 != null) && ((localObject2 instanceof a)))
        {
          paramas = (a)localObject2;
          if (paramas.type != -1)
          {
            localObject1 = new ContentValues();
            ((ContentValues)localObject1).put("id", (Integer)paramb.sUK);
            ((ContentValues)localObject1).put("type", Integer.valueOf(paramas.type));
            ((ContentValues)localObject1).put("value", paramas.hnA.toString());
            this.hnp.replace("userinfo", "id", (ContentValues)localObject1);
          }
          GMTrace.o(13540958142464L, 100888);
        }
      }
      else if (i == 2)
      {
        this.hnp.delete("userinfo", "id=" + localObject1, null);
        GMTrace.o(13540958142464L, 100888);
        return;
        if (i == 1)
        {
          if ((localObject2 != null) && ((localObject2 instanceof a)))
          {
            paramas = (a)localObject2;
            if (paramas.type != -1)
            {
              localObject1 = new ContentValues();
              ((ContentValues)localObject1).put("sid", (String)paramb.sUK);
              ((ContentValues)localObject1).put("type", Integer.valueOf(paramas.type));
              ((ContentValues)localObject1).put("value", paramas.hnA.toString());
              this.hnp.replace("userinfo2", "id", (ContentValues)localObject1);
            }
            GMTrace.o(13540958142464L, 100888);
          }
        }
        else if (i == 2) {
          this.hnp.delete("userinfo2", "sid=" + localObject1, null);
        }
      }
    }
  }
  
  public final void a(w.a parama, Object paramObject)
  {
    GMTrace.i(13540152836096L, 100882);
    if (parama == null)
    {
      GMTrace.o(13540152836096L, 100882);
      return;
    }
    Object localObject = parama.name();
    if (bf.mA((String)localObject))
    {
      GMTrace.o(13540152836096L, 100882);
      return;
    }
    String[] arrayOfString = ((String)localObject).split("_");
    String str = arrayOfString[(arrayOfString.length - 1)];
    if (str.equals("SYNC")) {
      str = arrayOfString[(arrayOfString.length - 2)];
    }
    for (int i = 1;; i = 0)
    {
      if (!a(str, paramObject, true))
      {
        GMTrace.o(13540152836096L, 100882);
        return;
      }
      int j = ((String)localObject).lastIndexOf(str);
      str = ((String)localObject).substring(0, str.length() + j);
      boolean bool2;
      boolean bool1;
      if (paramObject == null)
      {
        bool2 = this.uxp.q(str, null);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (!this.uxr.contains(str))
          {
            this.uxr.add(str);
            bool1 = bool2;
          }
        }
        if (bool1) {
          if (paramObject != null) {
            break label338;
          }
        }
      }
      label338:
      for (j = 5;; j = 4)
      {
        b(j, this, parama);
        if (i != 0) {
          jV(true);
        }
        GMTrace.o(13540152836096L, 100882);
        return;
        localObject = new a();
        ((a)localObject).type = bz(paramObject);
        if (((a)localObject).type == -1)
        {
          GMTrace.o(13540152836096L, 100882);
          return;
        }
        ((a)localObject).hnA = paramObject.toString();
        bool2 = this.uxp.q(str, localObject);
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        bool1 = bool2;
        if (!this.uxr.contains(str)) {
          break;
        }
        this.uxr.remove(str);
        bool1 = bool2;
        break;
      }
    }
  }
  
  public final boolean c(w.a parama, boolean paramBoolean)
  {
    GMTrace.i(13539884400640L, 100880);
    parama = get(parama, Boolean.valueOf(paramBoolean));
    if ((parama != null) && ((parama instanceof Boolean)))
    {
      paramBoolean = ((Boolean)parama).booleanValue();
      GMTrace.o(13539884400640L, 100880);
      return paramBoolean;
    }
    GMTrace.o(13539884400640L, 100880);
    return paramBoolean;
  }
  
  public final Object get(int paramInt, Object paramObject)
  {
    GMTrace.i(13539615965184L, 100878);
    if (this.hnp != null) {}
    Object localObject2;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("db is null", bool);
      localObject2 = this.uxo.get(Integer.valueOf(paramInt));
      if ((localObject2 != null) || (this.uxq.contains(Integer.valueOf(paramInt)))) {
        break;
      }
      localObject1 = new a();
      localObject2 = this.hnp.a("userinfo", null, "id=" + paramInt, null, null, null, null, 2);
      if (((Cursor)localObject2).moveToFirst())
      {
        ((a)localObject1).type = ((Cursor)localObject2).getInt(1);
        ((a)localObject1).hnA = ((Cursor)localObject2).getString(2);
      }
      ((Cursor)localObject2).close();
      localObject2 = i(((a)localObject1).type, ((a)localObject1).hnA);
      this.uxo.q(Integer.valueOf(paramInt), localObject1);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label254;
      }
      GMTrace.o(13539615965184L, 100878);
      return paramObject;
    }
    Object localObject1 = localObject2;
    if ((localObject2 instanceof a))
    {
      localObject1 = (a)localObject2;
      localObject2 = i(((a)localObject1).type, ((a)localObject1).hnA);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        GMTrace.o(13539615965184L, 100878);
        return paramObject;
      }
    }
    label254:
    GMTrace.o(13539615965184L, 100878);
    return localObject1;
  }
  
  public final Object get(w.a parama, Object paramObject)
  {
    GMTrace.i(13539750182912L, 100879);
    if (parama == null)
    {
      GMTrace.o(13539750182912L, 100879);
      return paramObject;
    }
    parama = parama.name();
    if (bf.mA(parama))
    {
      GMTrace.o(13539750182912L, 100879);
      return paramObject;
    }
    Object localObject = parama.split("_");
    String str = localObject[(localObject.length - 1)];
    if (str.equals("SYNC")) {
      str = localObject[(localObject.length - 2)];
    }
    for (;;)
    {
      parama = parama.substring(0, parama.lastIndexOf(str) + str.length());
      boolean bool;
      if (this.hnp != null)
      {
        bool = true;
        Assert.assertTrue("db is null", bool);
        localObject = this.uxp.get(parama);
        if ((localObject != null) || (this.uxr.contains(parama))) {
          break label291;
        }
        a locala = new a();
        localObject = this.hnp.a("userinfo2", null, "sid=?", new String[] { parama }, null, null, null, 2);
        if (((Cursor)localObject).moveToFirst())
        {
          locala.type = ((Cursor)localObject).getInt(1);
          locala.hnA = ((Cursor)localObject).getString(2);
        }
        ((Cursor)localObject).close();
        localObject = i(locala.type, locala.hnA);
        this.uxp.q(parama, locala);
        parama = (w.a)localObject;
        if (localObject == null) {
          parama = (w.a)paramObject;
        }
      }
      for (;;)
      {
        if (a(str, parama, false)) {
          break label334;
        }
        GMTrace.o(13539750182912L, 100879);
        return paramObject;
        bool = false;
        break;
        label291:
        parama = (w.a)localObject;
        if ((localObject instanceof a))
        {
          parama = (a)localObject;
          localObject = i(parama.type, parama.hnA);
          parama = (w.a)localObject;
          if (localObject == null) {
            parama = (w.a)paramObject;
          }
        }
      }
      label334:
      GMTrace.o(13539750182912L, 100879);
      return parama;
    }
  }
  
  public final int getInt(int paramInt1, int paramInt2)
  {
    GMTrace.i(13541495013376L, 100892);
    Integer localInteger = (Integer)get(paramInt1, null);
    if (localInteger == null)
    {
      GMTrace.o(13541495013376L, 100892);
      return paramInt2;
    }
    paramInt1 = localInteger.intValue();
    GMTrace.o(13541495013376L, 100892);
    return paramInt1;
  }
  
  public final void jV(boolean paramBoolean)
  {
    GMTrace.i(13541226577920L, 100890);
    long l = System.currentTimeMillis();
    this.uxo.jS(paramBoolean);
    this.uxp.jS(paramBoolean);
    v.i("MicroMsg.ConfigStorage", "summer config appendAllToDisk force[%b] end takes[%d]ms ", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(System.currentTimeMillis() - l) });
    GMTrace.o(13541226577920L, 100890);
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    GMTrace.i(13540018618368L, 100881);
    boolean bool1;
    boolean bool2;
    if (this.hnp != null)
    {
      bool1 = true;
      Assert.assertTrue("db is null", bool1);
      if (paramObject != null) {
        break label129;
      }
      bool2 = this.uxo.q(Integer.valueOf(paramInt), null);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!this.uxq.contains(Integer.valueOf(paramInt)))
        {
          this.uxq.add(Integer.valueOf(paramInt));
          bool1 = bool2;
        }
      }
      label92:
      if (bool1) {
        if (paramObject != null) {
          break label230;
        }
      }
    }
    label129:
    label230:
    for (int i = 5;; i = 4)
    {
      b(i, this, Integer.valueOf(paramInt));
      a locala;
      do
      {
        GMTrace.o(13540018618368L, 100881);
        return;
        bool1 = false;
        break;
        locala = new a();
        locala.type = bz(paramObject);
      } while (locala.type == -1);
      locala.hnA = paramObject.toString();
      bool2 = this.uxo.q(Integer.valueOf(paramInt), locala);
      bool1 = bool2;
      if (!bool2) {
        break label92;
      }
      bool1 = bool2;
      if (!this.uxq.contains(Integer.valueOf(paramInt))) {
        break label92;
      }
      this.uxq.remove(Integer.valueOf(paramInt));
      bool1 = bool2;
      break label92;
    }
  }
  
  public final void setInt(int paramInt1, int paramInt2)
  {
    GMTrace.i(13541360795648L, 100891);
    set(paramInt1, Integer.valueOf(paramInt2));
    GMTrace.o(13541360795648L, 100891);
  }
  
  public final void setLong(int paramInt, long paramLong)
  {
    GMTrace.i(13541629231104L, 100893);
    set(paramInt, Long.valueOf(paramLong));
    GMTrace.o(13541629231104L, 100893);
  }
  
  public final long yw(int paramInt)
  {
    GMTrace.i(13541763448832L, 100894);
    Long localLong = (Long)get(paramInt, null);
    if (localLong == null)
    {
      GMTrace.o(13541763448832L, 100894);
      return 0L;
    }
    long l = localLong.longValue();
    GMTrace.o(13541763448832L, 100894);
    return l;
  }
  
  static final class a
  {
    public String hnA;
    public int type;
    
    a()
    {
      GMTrace.i(13542031884288L, 100896);
      this.type = -1;
      this.hnA = null;
      GMTrace.o(13542031884288L, 100896);
    }
    
    public final boolean equals(Object paramObject)
    {
      GMTrace.i(13542166102016L, 100897);
      if (paramObject == null)
      {
        GMTrace.o(13542166102016L, 100897);
        return false;
      }
      if (!(paramObject instanceof a))
      {
        GMTrace.o(13542166102016L, 100897);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.type != ((a)paramObject).type)
      {
        GMTrace.o(13542166102016L, 100897);
        return false;
      }
      if (this.hnA == null)
      {
        if (((a)paramObject).hnA == null)
        {
          GMTrace.o(13542166102016L, 100897);
          return true;
        }
        GMTrace.o(13542166102016L, 100897);
        return false;
      }
      boolean bool = this.hnA.equals(((a)paramObject).hnA);
      GMTrace.o(13542166102016L, 100897);
      return bool;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */