package com.tencent.mm.ah;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.a;

final class i
  implements a
{
  private f<String, Bitmap> hGa;
  
  i()
  {
    GMTrace.i(3527644545024L, 26283);
    this.hGa = new f(5);
    GMTrace.o(3527644545024L, 26283);
  }
  
  public final Object get(Object paramObject)
  {
    GMTrace.i(3527912980480L, 26285);
    paramObject = this.hGa.get((String)paramObject);
    GMTrace.o(3527912980480L, 26285);
    return paramObject;
  }
  
  public final void m(Object paramObject1, Object paramObject2)
  {
    GMTrace.i(3527778762752L, 26284);
    this.hGa.k((String)paramObject1, (Bitmap)paramObject2);
    GMTrace.o(3527778762752L, 26284);
  }
  
  public final Object remove(Object paramObject)
  {
    GMTrace.i(3528047198208L, 26286);
    this.hGa.remove((String)paramObject);
    GMTrace.o(3528047198208L, 26286);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */