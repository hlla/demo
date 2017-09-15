package com.tencent.mm.sdk.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c<T extends b>
{
  final int priority;
  public int uqt;
  private com.tencent.mm.vending.b.b<c> uqu;
  
  public c()
  {
    this(0);
    GMTrace.i(13956630446080L, 103985);
    GMTrace.o(13956630446080L, 103985);
  }
  
  public c(int paramInt)
  {
    GMTrace.i(13956764663808L, 103986);
    this.uqt = 0;
    this.priority = paramInt;
    GMTrace.o(13956764663808L, 103986);
  }
  
  public abstract boolean a(T paramT);
  
  final int bIn()
  {
    GMTrace.i(13956898881536L, 103987);
    if (this.uqt == 0)
    {
      long l = System.currentTimeMillis();
      Type localType2 = getClass().getGenericSuperclass();
      Type localType1 = localType2;
      if (!(localType2 instanceof ParameterizedType)) {
        localType1 = getClass().getSuperclass().getGenericSuperclass();
      }
      localType1 = ((ParameterizedType)localType1).getActualTypeArguments()[0];
      this.uqt = ((Class)localType1).getName().hashCode();
      v.v("IListener", "genEventID, %s<%s>, useTime:%d", new Object[] { getClass().getName(), localType1, Long.valueOf(System.currentTimeMillis() - l) });
    }
    int i = this.uqt;
    GMTrace.o(13956898881536L, 103987);
    return i;
  }
  
  public final com.tencent.mm.vending.b.b<c> bIo()
  {
    try
    {
      GMTrace.i(13957167316992L, 103989);
      if (this.uqu == null) {
        this.uqu = a.uql.a(this);
      }
      com.tencent.mm.vending.b.b localb = this.uqu;
      GMTrace.o(13957167316992L, 103989);
      return localb;
    }
    finally {}
  }
  
  public final void dead()
  {
    try
    {
      GMTrace.i(13957301534720L, 103990);
      if (this.uqu != null)
      {
        this.uqu.dead();
        this.uqu = null;
      }
      GMTrace.o(13957301534720L, 103990);
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */