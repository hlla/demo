package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.u;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.atomic.AtomicLong;

public final class d
  extends i<u>
{
  public static final String[] gUn;
  public com.tencent.mm.sdk.e.e gUp;
  final k<a, d.a.b> htP;
  private AtomicLong hws;
  
  static
  {
    GMTrace.i(4573334863872L, 34074);
    gUn = new String[] { i.a(c.gTF, "BizChatInfo") };
    GMTrace.o(4573334863872L, 34074);
  }
  
  public d(com.tencent.mm.sdk.e.e arg1)
  {
    super(???, c.gTF, "BizChatInfo", null);
    GMTrace.i(4572126904320L, 34065);
    this.hws = new AtomicLong(-1L);
    this.htP = new k() {};
    this.gUp = ???;
    ???.eE("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
    ???.eE("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
    ???.eE("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
    synchronized (this.hws)
    {
      Cursor localCursor = this.gUp.a("select max(bizChatLocalId) from BizChatInfo", null, 2);
      long l1 = 0L;
      if (localCursor.moveToFirst())
      {
        long l2 = localCursor.getInt(0);
        l1 = l2;
        if (l2 > this.hws.get())
        {
          this.hws.set(l2);
          l1 = l2;
        }
      }
      localCursor.close();
      v.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:" + l1);
      GMTrace.o(4572126904320L, 34065);
      return;
    }
  }
  
  private long DX()
  {
    GMTrace.i(4573200646144L, 34073);
    synchronized (this.hws)
    {
      long l = this.hws.incrementAndGet();
      v.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", new Object[] { Long.valueOf(l) });
      GMTrace.o(4573200646144L, 34073);
      return l;
    }
  }
  
  public final boolean V(long paramLong)
  {
    GMTrace.i(4572797992960L, 34070);
    c localc = aa(paramLong);
    boolean bool = super.a(localc, new String[] { "bizChatLocalId" });
    if (bool)
    {
      d.a.b localb = new d.a.b();
      localb.hwo = localc.field_bizChatLocalId;
      localb.fGj = localc.field_brandUserName;
      localb.hwy = d.a.a.hwv;
      localb.hwz = localc;
      this.htP.by(localb);
      this.htP.doNotify();
    }
    GMTrace.o(4572797992960L, 34070);
    return bool;
  }
  
  public final void a(a parama)
  {
    GMTrace.i(4572395339776L, 34067);
    if (this.htP != null) {
      this.htP.remove(parama);
    }
    GMTrace.o(4572395339776L, 34067);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    GMTrace.i(4572261122048L, 34066);
    this.htP.a(parama, paramLooper);
    GMTrace.o(4572261122048L, 34066);
  }
  
  public final boolean a(c paramc)
  {
    GMTrace.i(4572932210688L, 34071);
    if (paramc == null)
    {
      v.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
      GMTrace.o(4572932210688L, 34071);
      return false;
    }
    if (bf.mA(paramc.field_bizChatServId))
    {
      v.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
      GMTrace.o(4572932210688L, 34071);
      return false;
    }
    Object localObject = ir(paramc.field_bizChatServId);
    if (localObject != null)
    {
      paramc.field_bizChatLocalId = ((c)localObject).field_bizChatLocalId;
      v.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
      GMTrace.o(4572932210688L, 34071);
      return true;
    }
    paramc.field_bizChatLocalId = DX();
    boolean bool = super.b(paramc);
    if (bool)
    {
      localObject = new d.a.b();
      ((d.a.b)localObject).hwo = paramc.field_bizChatLocalId;
      ((d.a.b)localObject).fGj = paramc.field_brandUserName;
      ((d.a.b)localObject).hwy = d.a.a.hwu;
      ((d.a.b)localObject).hwz = paramc;
      this.htP.by(localObject);
      this.htP.doNotify();
    }
    GMTrace.o(4572932210688L, 34071);
    return bool;
  }
  
  public final c aa(long paramLong)
  {
    GMTrace.i(4572529557504L, 34068);
    c localc = new c();
    localc.field_bizChatLocalId = paramLong;
    super.b(localc, new String[0]);
    GMTrace.o(4572529557504L, 34068);
    return localc;
  }
  
  public final boolean b(c paramc)
  {
    GMTrace.i(4573066428416L, 34072);
    if (paramc == null)
    {
      v.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
      GMTrace.o(4573066428416L, 34072);
      return false;
    }
    if (paramc.field_bizChatLocalId < 0L)
    {
      v.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
      GMTrace.o(4573066428416L, 34072);
      return false;
    }
    Object localObject = aa(paramc.field_bizChatLocalId);
    if ((!bf.mA(((c)localObject).field_bizChatServId)) && (!((c)localObject).field_bizChatServId.equals(paramc.field_bizChatServId)))
    {
      v.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
      GMTrace.o(4573066428416L, 34072);
      return false;
    }
    if ((paramc == null) || (bf.mA(paramc.field_chatName))) {
      v.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
    }
    for (;;)
    {
      boolean bool = super.a(paramc);
      if (bool)
      {
        e.g(paramc);
        localObject = new d.a.b();
        ((d.a.b)localObject).hwo = paramc.field_bizChatLocalId;
        ((d.a.b)localObject).fGj = paramc.field_brandUserName;
        ((d.a.b)localObject).hwy = d.a.a.hww;
        ((d.a.b)localObject).hwz = paramc;
        this.htP.by(localObject);
        this.htP.doNotify();
      }
      GMTrace.o(4573066428416L, 34072);
      return bool;
      paramc.field_chatNamePY = com.tencent.mm.platformtools.c.mq(paramc.field_chatName);
    }
  }
  
  public final c ir(String paramString)
  {
    GMTrace.i(4572663775232L, 34069);
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("select * ");
    ((StringBuilder)localObject3).append(" from BizChatInfo");
    ((StringBuilder)localObject3).append(" where bizChatServId = '").append(paramString).append("' ");
    ((StringBuilder)localObject3).append(" limit 1");
    paramString = ((StringBuilder)localObject3).toString();
    v.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", new Object[] { paramString });
    localObject3 = rawQuery(paramString, new String[0]);
    paramString = (String)localObject2;
    if (localObject3 != null)
    {
      paramString = (String)localObject1;
      if (((Cursor)localObject3).moveToFirst())
      {
        paramString = new c();
        paramString.b((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(4572663775232L, 34069);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public static enum a
    {
      static
      {
        GMTrace.i(4582730104832L, 34144);
        hwu = 1;
        hwv = 2;
        hww = 3;
        hwx = new int[] { hwu, hwv, hww };
        GMTrace.o(4582730104832L, 34144);
      }
    }
    
    public static final class b
    {
      public String fGj;
      public long hwo;
      public int hwy;
      public c hwz;
      
      public b()
      {
        GMTrace.i(4557362954240L, 33955);
        GMTrace.o(4557362954240L, 33955);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */