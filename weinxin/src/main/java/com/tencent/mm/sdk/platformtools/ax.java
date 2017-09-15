package com.tencent.mm.sdk.platformtools;

import com.tencent.gmtrace.GMTrace;

public class ax<T>
{
  public Object[] wf;
  public int wg;
  
  public ax(int paramInt)
  {
    GMTrace.i(13924820844544L, 103748);
    this.wf = new Object[20];
    GMTrace.o(13924820844544L, 103748);
  }
  
  public T bF()
  {
    GMTrace.i(13924955062272L, 103749);
    if (this.wf == null)
    {
      GMTrace.o(13924955062272L, 103749);
      return null;
    }
    if (this.wg > 0)
    {
      int i = this.wg - 1;
      Object localObject = this.wf[i];
      this.wf[i] = null;
      this.wg -= 1;
      GMTrace.o(13924955062272L, 103749);
      return (T)localObject;
    }
    GMTrace.o(13924955062272L, 103749);
    return null;
  }
  
  public boolean i(T paramT)
  {
    GMTrace.i(13925089280000L, 103750);
    if (this.wf == null)
    {
      GMTrace.o(13925089280000L, 103750);
      return false;
    }
    if (this.wf != null)
    {
      i = 0;
      if (i < this.wg) {
        if (this.wf[i] != paramT) {}
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label80;
      }
      GMTrace.o(13925089280000L, 103750);
      return false;
      i += 1;
      break;
    }
    label80:
    if ((this.wg < this.wf.length) && (this.wg >= 0))
    {
      this.wf[this.wg] = paramT;
      this.wg += 1;
      GMTrace.o(13925089280000L, 103750);
      return true;
    }
    v.e("MicroMsg.SimpleObjectPool", "error index %d %d", new Object[] { Integer.valueOf(this.wg), Integer.valueOf(this.wf.length) });
    GMTrace.o(13925089280000L, 103750);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */