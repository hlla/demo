package android.support.v7.widget;

import android.support.v4.e.a;
import android.support.v4.e.e;
import android.support.v4.e.h.a;
import android.support.v4.e.h.b;

final class as
{
  final a<RecyclerView.t, a> afE = new a();
  final e<RecyclerView.t> afF = new e();
  
  final void a(long paramLong, RecyclerView.t paramt)
  {
    this.afF.put(paramLong, paramt);
  }
  
  final void a(b paramb)
  {
    int i = this.afE.size() - 1;
    if (i >= 0)
    {
      RecyclerView.t localt = (RecyclerView.t)this.afE.keyAt(i);
      a locala = (a)this.afE.removeAt(i);
      if ((locala.flags & 0x3) == 3) {
        paramb.i(localt);
      }
      for (;;)
      {
        a.a(locala);
        i -= 1;
        break;
        if ((locala.flags & 0x1) != 0)
        {
          if (locala.afG == null) {
            paramb.i(localt);
          } else {
            paramb.a(localt, locala.afG, locala.afH);
          }
        }
        else if ((locala.flags & 0xE) == 14) {
          paramb.b(localt, locala.afG, locala.afH);
        } else if ((locala.flags & 0xC) == 12) {
          paramb.c(localt, locala.afG, locala.afH);
        } else if ((locala.flags & 0x4) != 0) {
          paramb.a(localt, locala.afG, null);
        } else if ((locala.flags & 0x8) != 0) {
          paramb.b(localt, locala.afG, locala.afH);
        } else {
          int j = locala.flags;
        }
      }
    }
  }
  
  final void b(RecyclerView.t paramt, RecyclerView.e.c paramc)
  {
    a locala2 = (a)this.afE.get(paramt);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.he();
      this.afE.put(paramt, locala1);
    }
    locala1.afG = paramc;
    locala1.flags |= 0x4;
  }
  
  final RecyclerView.e.c c(RecyclerView.t paramt, int paramInt)
  {
    Object localObject2 = null;
    int i = this.afE.indexOfKey(paramt);
    Object localObject1;
    if (i < 0) {
      localObject1 = localObject2;
    }
    a locala;
    do
    {
      do
      {
        return (RecyclerView.e.c)localObject1;
        locala = (a)this.afE.valueAt(i);
        localObject1 = localObject2;
      } while (locala == null);
      localObject1 = localObject2;
    } while ((locala.flags & paramInt) == 0);
    locala.flags &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramt = locala.afG;; paramt = locala.afH)
    {
      localObject1 = paramt;
      if ((locala.flags & 0xC) != 0) {
        break;
      }
      this.afE.removeAt(i);
      a.a(locala);
      return paramt;
      if (paramInt != 8) {
        break label129;
      }
    }
    label129:
    throw new IllegalArgumentException("Must provide flag PRE or POST");
  }
  
  final void c(RecyclerView.t paramt, RecyclerView.e.c paramc)
  {
    a locala2 = (a)this.afE.get(paramt);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.he();
      this.afE.put(paramt, locala1);
    }
    locala1.afH = paramc;
    locala1.flags |= 0x8;
  }
  
  final void clear()
  {
    this.afE.clear();
    e locale = this.afF;
    int j = locale.hP;
    Object[] arrayOfObject = locale.vW;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    locale.hP = 0;
    locale.vU = false;
  }
  
  final boolean u(RecyclerView.t paramt)
  {
    paramt = (a)this.afE.get(paramt);
    return (paramt != null) && ((paramt.flags & 0x1) != 0);
  }
  
  final void v(RecyclerView.t paramt)
  {
    a locala2 = (a)this.afE.get(paramt);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.he();
      this.afE.put(paramt, locala1);
    }
    locala1.flags |= 0x1;
  }
  
  final void w(RecyclerView.t paramt)
  {
    paramt = (a)this.afE.get(paramt);
    if (paramt == null) {
      return;
    }
    paramt.flags &= 0xFFFFFFFE;
  }
  
  final void x(RecyclerView.t paramt)
  {
    int i = this.afF.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramt != this.afF.valueAt(i)) {
          break label78;
        }
        e locale = this.afF;
        if (locale.vW[i] != e.vT)
        {
          locale.vW[i] = e.vT;
          locale.vU = true;
        }
      }
      paramt = (a)this.afE.remove(paramt);
      if (paramt != null) {
        a.a(paramt);
      }
      return;
      label78:
      i -= 1;
    }
  }
  
  static final class a
  {
    static h.a<a> afI = new h.b(20);
    RecyclerView.e.c afG;
    RecyclerView.e.c afH;
    int flags;
    
    static void a(a parama)
    {
      parama.flags = 0;
      parama.afG = null;
      parama.afH = null;
      afI.i(parama);
    }
    
    static a he()
    {
      a locala2 = (a)afI.bF();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      return locala1;
    }
    
    static void hf()
    {
      while (afI.bF() != null) {}
    }
  }
  
  static abstract interface b
  {
    public abstract void a(RecyclerView.t paramt, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2);
    
    public abstract void b(RecyclerView.t paramt, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2);
    
    public abstract void c(RecyclerView.t paramt, RecyclerView.e.c paramc1, RecyclerView.e.c paramc2);
    
    public abstract void i(RecyclerView.t paramt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */