package com.tencent.mm.bj.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

public final class e
  extends AbstractCursor
  implements d
{
  private DataSetObserver mObserver;
  private d uKJ;
  public d[] uKK;
  
  public e(f[] paramArrayOff)
  {
    GMTrace.i(17539438477312L, 130679);
    this.mObserver = new DataSetObserver()
    {
      public final void onChanged()
      {
        GMTrace.i(17555007733760L, 130795);
        e.a(e.this);
        GMTrace.o(17555007733760L, 130795);
      }
      
      public final void onInvalidated()
      {
        GMTrace.i(17555141951488L, 130796);
        e.b(e.this);
        GMTrace.o(17555141951488L, 130796);
      }
    };
    this.uKK = paramArrayOff;
    this.uKJ = paramArrayOff[0];
    while (i < this.uKK.length)
    {
      if (this.uKK[i] != null) {
        this.uKK[i].registerDataSetObserver(this.mObserver);
      }
      i += 1;
    }
    GMTrace.o(17539438477312L, 130679);
  }
  
  public final void a(f.a parama)
  {
    GMTrace.i(17541988614144L, 130698);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      if (this.uKK[i] != null) {
        this.uKK[i].a(parama);
      }
      i += 1;
    }
    GMTrace.o(17541988614144L, 130698);
  }
  
  public final boolean a(Object paramObject, a parama)
  {
    boolean bool1 = false;
    GMTrace.i(17542525485056L, 130702);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.uKK[i] != null)
      {
        bool2 = bool1;
        if (this.uKK[i].a(paramObject, parama)) {
          bool2 = true;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    GMTrace.o(17542525485056L, 130702);
    return bool1;
  }
  
  public final boolean bB(Object paramObject)
  {
    boolean bool1 = false;
    GMTrace.i(17542928138240L, 130705);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.uKK[i] != null)
      {
        bool2 = bool1;
        if (this.uKK[i].bB(paramObject)) {
          bool2 = true;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    GMTrace.o(17542928138240L, 130705);
    return bool1;
  }
  
  public final a bC(Object paramObject)
  {
    GMTrace.i(17543062355968L, 130706);
    paramObject = this.uKJ.bC(paramObject);
    GMTrace.o(17543062355968L, 130706);
    return (a)paramObject;
  }
  
  public final HashMap bNA()
  {
    GMTrace.i(18785247428608L, 139961);
    GMTrace.o(18785247428608L, 139961);
    return null;
  }
  
  public final boolean bNB()
  {
    GMTrace.i(17542257049600L, 130700);
    int j = this.uKK.length;
    boolean bool1 = true;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.uKK[i] != null)
      {
        bool2 = bool1;
        if (!this.uKK[i].bNB()) {
          bool2 = false;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    GMTrace.o(17542257049600L, 130700);
    return bool1;
  }
  
  public final SparseArray<Object>[] bNz()
  {
    GMTrace.i(17542659702784L, 130703);
    int j = this.uKK.length;
    SparseArray[] arrayOfSparseArray = new SparseArray[j];
    int i = 0;
    while (i < j)
    {
      arrayOfSparseArray[i] = this.uKK[i].bNz()[0];
      i += 1;
    }
    GMTrace.o(17542659702784L, 130703);
    return arrayOfSparseArray;
  }
  
  public final void close()
  {
    GMTrace.i(17541183307776L, 130692);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      if (this.uKK[i] != null) {
        this.uKK[i].close();
      }
      i += 1;
    }
    super.close();
    GMTrace.o(17541183307776L, 130692);
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    GMTrace.i(17543330791424L, 130708);
    GMTrace.o(17543330791424L, 130708);
  }
  
  public final void deactivate()
  {
    GMTrace.i(17541049090048L, 130691);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      if (this.uKK[i] != null) {
        this.uKK[i].deactivate();
      }
      i += 1;
    }
    super.deactivate();
    GMTrace.o(17541049090048L, 130691);
  }
  
  public final byte[] getBlob(int paramInt)
  {
    GMTrace.i(17540780654592L, 130689);
    byte[] arrayOfByte = this.uKJ.getBlob(paramInt);
    GMTrace.o(17540780654592L, 130689);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    GMTrace.i(17540914872320L, 130690);
    if (this.uKJ != null)
    {
      String[] arrayOfString = this.uKJ.getColumnNames();
      GMTrace.o(17540914872320L, 130690);
      return arrayOfString;
    }
    GMTrace.o(17540914872320L, 130690);
    return new String[0];
  }
  
  public final int getCount()
  {
    int j = 0;
    GMTrace.i(17539572695040L, 130680);
    int m = this.uKK.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (this.uKK[i] != null) {
        k = j + this.uKK[i].getCount();
      }
      i += 1;
      j = k;
    }
    GMTrace.o(17539572695040L, 130680);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    GMTrace.i(17540512219136L, 130687);
    double d = this.uKJ.getDouble(paramInt);
    GMTrace.o(17540512219136L, 130687);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    GMTrace.i(17540378001408L, 130686);
    float f = this.uKJ.getFloat(paramInt);
    GMTrace.o(17540378001408L, 130686);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    GMTrace.i(17540109565952L, 130684);
    paramInt = this.uKJ.getInt(paramInt);
    GMTrace.o(17540109565952L, 130684);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    GMTrace.i(17540243783680L, 130685);
    long l = this.uKJ.getLong(paramInt);
    GMTrace.o(17540243783680L, 130685);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    GMTrace.i(17539975348224L, 130683);
    short s = this.uKJ.getShort(paramInt);
    GMTrace.o(17539975348224L, 130683);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    GMTrace.i(17539841130496L, 130682);
    String str = this.uKJ.getString(paramInt);
    GMTrace.o(17539841130496L, 130682);
    return str;
  }
  
  public final boolean isNull(int paramInt)
  {
    GMTrace.i(17540646436864L, 130688);
    boolean bool = this.uKJ.isNull(paramInt);
    GMTrace.o(17540646436864L, 130688);
    return bool;
  }
  
  public final void jX(boolean paramBoolean)
  {
    GMTrace.i(17542122831872L, 130699);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      if (this.uKK[i] != null) {
        this.uKK[i].jX(paramBoolean);
      }
      i += 1;
    }
    GMTrace.o(17542122831872L, 130699);
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    GMTrace.i(17539706912768L, 130681);
    this.uKJ = null;
    int k = this.uKK.length;
    paramInt1 = 0;
    int j;
    for (int i = 0;; i = j)
    {
      if (paramInt1 < k)
      {
        j = i;
        if (this.uKK[paramInt1] == null) {
          break label116;
        }
        if (paramInt2 < this.uKK[paramInt1].getCount() + i) {
          this.uKJ = this.uKK[paramInt1];
        }
      }
      else
      {
        if (this.uKJ == null) {
          break;
        }
        boolean bool = this.uKJ.moveToPosition(paramInt2 - i);
        GMTrace.o(17539706912768L, 130681);
        return bool;
      }
      j = i + this.uKK[paramInt1].getCount();
      label116:
      paramInt1 += 1;
    }
    GMTrace.o(17539706912768L, 130681);
    return false;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    GMTrace.i(17541317525504L, 130693);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      if (this.uKK[i] != null) {
        this.uKK[i].registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    GMTrace.o(17541317525504L, 130693);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    GMTrace.i(17541585960960L, 130695);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      if (this.uKK[i] != null) {
        this.uKK[i].registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    GMTrace.o(17541585960960L, 130695);
  }
  
  public final boolean requery()
  {
    GMTrace.i(17541854396416L, 130697);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      if ((this.uKK[i] != null) && (!this.uKK[i].requery()))
      {
        GMTrace.o(17541854396416L, 130697);
        return false;
      }
      i += 1;
    }
    GMTrace.o(17541854396416L, 130697);
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    GMTrace.i(17541451743232L, 130694);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      if (this.uKK[i] != null) {
        this.uKK[i].unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    GMTrace.o(17541451743232L, 130694);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    GMTrace.i(17541720178688L, 130696);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      if (this.uKK[i] != null) {
        this.uKK[i].unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    GMTrace.o(17541720178688L, 130696);
  }
  
  public final boolean yK(int paramInt)
  {
    GMTrace.i(17542793920512L, 130704);
    int j = this.uKK.length;
    boolean bool1 = true;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.uKK[i] != null)
      {
        bool2 = bool1;
        if (!this.uKK[i].yK(paramInt)) {
          bool2 = false;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    GMTrace.o(17542793920512L, 130704);
    return bool1;
  }
  
  public final a yL(int paramInt)
  {
    GMTrace.i(17542391267328L, 130701);
    int k = this.uKK.length;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      j = this.uKK[paramInt].getCount();
      if (i < j)
      {
        a locala = this.uKK[paramInt].yL(i);
        GMTrace.o(17542391267328L, 130701);
        return locala;
      }
      i -= j;
      paramInt += 1;
    }
    GMTrace.o(17542391267328L, 130701);
    return null;
  }
  
  public final void yM(int paramInt)
  {
    GMTrace.i(17543196573696L, 130707);
    int j = this.uKK.length;
    int i = 0;
    while (i < j)
    {
      if (this.uKK[i] != null) {
        this.uKK[i].yM(paramInt);
      }
      i += 1;
    }
    GMTrace.o(17543196573696L, 130707);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bj/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */