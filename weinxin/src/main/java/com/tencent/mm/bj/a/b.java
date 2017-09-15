package com.tencent.mm.bj.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a>
  extends SQLiteClosable
{
  int mStartPos;
  int uKA;
  HashMap<Object, T> uKB;
  ArrayList<Object> uKC;
  T uKD;
  SparseArray<Object> uKz;
  
  public b()
  {
    GMTrace.i(17543733444608L, 130711);
    this.mStartPos = 0;
    this.uKz = new SparseArray();
    this.uKB = new HashMap();
    GMTrace.o(17543733444608L, 130711);
  }
  
  public final void QZ()
  {
    GMTrace.i(17544404533248L, 130716);
    v.i("WCDB.CursorDataWindow", "clearData");
    this.uKz.clear();
    this.uKB.clear();
    GMTrace.o(17544404533248L, 130716);
  }
  
  public abstract ArrayList<T> ai(ArrayList<Object> paramArrayList);
  
  final void b(Object paramObject, T paramT)
  {
    GMTrace.i(18785515864064L, 139963);
    this.uKB.put(paramObject, paramT);
    GMTrace.o(18785515864064L, 139963);
  }
  
  public final boolean bB(Object paramObject)
  {
    GMTrace.i(17544807186432L, 130719);
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 1)
      {
        if ((this.uKB != null) && (this.uKB.containsKey(arrayOfObject[0])))
        {
          GMTrace.o(17544807186432L, 130719);
          return true;
        }
        GMTrace.o(17544807186432L, 130719);
        return false;
      }
    }
    if ((this.uKB != null) && (this.uKB.containsKey(paramObject)))
    {
      GMTrace.o(17544807186432L, 130719);
      return true;
    }
    GMTrace.o(17544807186432L, 130719);
    return false;
  }
  
  public abstract T bNF();
  
  public final void dQ(int paramInt1, int paramInt2)
  {
    GMTrace.i(17544001880064L, 130713);
    if (paramInt2 != 0)
    {
      v.e("WCDB.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.uKz.remove(paramInt1);
      GMTrace.o(17544001880064L, 130713);
      return;
    }
    if (this.uKD != null)
    {
      Object localObject = this.uKD.getKey();
      b(localObject, this.uKD);
      this.uKz.put(paramInt1, localObject);
    }
    GMTrace.o(17544001880064L, 130713);
  }
  
  protected void onAllReferencesReleased()
  {
    GMTrace.i(17544538750976L, 130717);
    QZ();
    GMTrace.o(17544538750976L, 130717);
  }
  
  final void q(Object[] paramArrayOfObject)
  {
    GMTrace.i(17544672968704L, 130718);
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = 0;
    if (i < this.uKz.size())
    {
      int i2 = this.uKz.keyAt(i);
      Object localObject = this.uKz.valueAt(i);
      int i1 = 1;
      int i3 = paramArrayOfObject.length;
      int n = 0;
      label62:
      int k = j;
      int m = i1;
      if (n < i3)
      {
        if (paramArrayOfObject[n].equals(localObject))
        {
          k = j + 1;
          m = 0;
        }
      }
      else
      {
        if (m == 0) {
          break label132;
        }
        localSparseArray.put(i2 - k, localObject);
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        n += 1;
        break label62;
        label132:
        v.i("WCDB.CursorDataWindow", "newcursor delete index : " + i + " obj : " + localObject);
      }
    }
    if (this.uKz.size() != localSparseArray.size()) {
      v.i("WCDB.CursorDataWindow", "newcursor oldposition size :" + this.uKz.size() + " newposistion Size : " + localSparseArray.size());
    }
    this.uKz = localSparseArray;
    GMTrace.o(17544672968704L, 130718);
  }
  
  public final boolean yN(int paramInt)
  {
    GMTrace.i(17543867662336L, 130712);
    if (this.uKz.indexOfKey(paramInt) >= 0)
    {
      GMTrace.o(17543867662336L, 130712);
      return true;
    }
    GMTrace.o(17543867662336L, 130712);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bj/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */