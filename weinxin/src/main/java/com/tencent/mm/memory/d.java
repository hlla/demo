package com.tencent.mm.memory;

import com.tencent.gmtrace.GMTrace;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S>
{
  protected Queue<T> hgq;
  protected S hgr;
  
  public d(S paramS)
  {
    GMTrace.i(1287819100160L, 9595);
    this.hgq = new ConcurrentLinkedQueue();
    this.hgr = paramS;
    GMTrace.o(1287819100160L, 9595);
  }
  
  public final T pop()
  {
    GMTrace.i(1287953317888L, 9596);
    Object localObject = this.hgq.poll();
    GMTrace.o(1287953317888L, 9596);
    return (T)localObject;
  }
  
  public final void put(T paramT)
  {
    GMTrace.i(1288087535616L, 9597);
    this.hgq.add(paramT);
    GMTrace.o(1288087535616L, 9597);
  }
  
  public final int size()
  {
    GMTrace.i(1288221753344L, 9598);
    int i = this.hgq.size();
    GMTrace.o(1288221753344L, 9598);
    return i;
  }
  
  public final S wm()
  {
    GMTrace.i(1288355971072L, 9599);
    Object localObject = this.hgr;
    GMTrace.o(1288355971072L, 9599);
    return (S)localObject;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/memory/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */