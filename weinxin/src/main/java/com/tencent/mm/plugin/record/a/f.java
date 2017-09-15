package com.tencent.mm.plugin.record.a;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class f<T extends a>
{
  private boolean oMH;
  public final int oMI;
  private final int oMJ;
  private SparseArray<f<T>.b> oMK;
  private LinkedList<T> oML;
  
  public f()
  {
    GMTrace.i(7515521679360L, 55995);
    this.oMH = false;
    this.oMK = new SparseArray();
    this.oML = new LinkedList();
    this.oMI = 3;
    this.oMJ = 300000;
    GMTrace.o(7515521679360L, 55995);
  }
  
  protected abstract void a(T paramT);
  
  public final void aWs()
  {
    GMTrace.i(16040629108736L, 119512);
    if (this.oMH)
    {
      v.d("MicroMsg.RecordMsgBaseService", "is working, return");
      GMTrace.o(16040629108736L, 119512);
      return;
    }
    if (this.oML.isEmpty())
    {
      localObject1 = aWt().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        localObject3 = (b)this.oMK.get(((a)localObject2).aWv());
        if (localObject3 != null)
        {
          if ((((b)localObject3).ihB < 0) && (SystemClock.elapsedRealtime() - ((b)localObject3).oMN < this.oMJ)) {
            continue;
          }
          if (((b)localObject3).ihB < 0) {
            ((b)localObject3).ihB = this.oMI;
          }
        }
        for (;;)
        {
          v.d("MicroMsg.RecordMsgBaseService", "do add job from db, localId %d", new Object[] { Integer.valueOf(((a)localObject2).aWv()) });
          if (this.oML.contains(localObject2)) {
            break;
          }
          this.oML.add(localObject2);
          break;
          localObject3 = new b();
          this.oMK.put(((a)localObject2).aWv(), localObject3);
        }
      }
      v.i("MicroMsg.RecordMsgBaseService", "jobs list size is 0, new jobs list size[%d]", new Object[] { Integer.valueOf(this.oML.size()) });
    }
    if (this.oML.isEmpty())
    {
      v.i("MicroMsg.RecordMsgBaseService", "try to do job, but job list size is empty, return");
      finish();
      GMTrace.o(16040629108736L, 119512);
      return;
    }
    Object localObject3 = (a)this.oML.removeFirst();
    Object localObject2 = (b)this.oMK.get(((a)localObject3).aWv());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b();
      this.oMK.put(((a)localObject3).aWv(), localObject1);
    }
    ((b)localObject1).ihB -= 1;
    if (((b)localObject1).ihB < 0) {
      if (this.oMJ <= SystemClock.elapsedRealtime() - ((b)localObject1).oMN) {}
    }
    for (int i = 0; i != 0; i = 1)
    {
      a((a)localObject3);
      GMTrace.o(16040629108736L, 119512);
      return;
      ((b)localObject1).ihB = (this.oMI - 1);
      ((b)localObject1).oMN = SystemClock.elapsedRealtime();
    }
    run();
    GMTrace.o(16040629108736L, 119512);
  }
  
  protected abstract List<T> aWt();
  
  protected final void aWu()
  {
    GMTrace.i(7516058550272L, 55999);
    this.oMH = false;
    run();
    GMTrace.o(7516058550272L, 55999);
  }
  
  final void finish()
  {
    GMTrace.i(7516192768000L, 56000);
    this.oML.clear();
    this.oMK.clear();
    this.oMH = false;
    GMTrace.o(7516192768000L, 56000);
  }
  
  public final void run()
  {
    GMTrace.i(7515655897088L, 55996);
    ap.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(7512032018432L, 55969);
        f.this.aWs();
        GMTrace.o(7512032018432L, 55969);
      }
      
      public final String toString()
      {
        GMTrace.i(7512166236160L, 55970);
        String str = super.toString() + "|tryDoJob";
        GMTrace.o(7512166236160L, 55970);
        return str;
      }
    });
    GMTrace.o(7515655897088L, 55996);
  }
  
  public static abstract interface a
  {
    public abstract int aWv();
  }
  
  private final class b
  {
    int ihB;
    long oMN;
    
    public b()
    {
      GMTrace.i(7514716372992L, 55989);
      this.oMN = SystemClock.elapsedRealtime();
      this.ihB = f.this.oMI;
      GMTrace.o(7514716372992L, 55989);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/record/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */