package com.tencent.mm.bj.a;

import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import java.util.ArrayList;

public abstract class g<K, T extends a>
{
  public d uKT;
  
  public g(d paramd, int paramInt)
  {
    GMTrace.i(17552189161472L, 130774);
    this.uKT = paramd;
    this.uKT.jX(true);
    this.uKT.a(new f.a()
    {
      public final ArrayList<a> ai(ArrayList<Object> paramAnonymousArrayList)
      {
        GMTrace.i(17537962082304L, 130668);
        paramAnonymousArrayList = g.this.ai(paramAnonymousArrayList);
        GMTrace.o(17537962082304L, 130668);
        return paramAnonymousArrayList;
      }
      
      public final a bNF()
      {
        GMTrace.i(17537827864576L, 130667);
        a locala = g.this.bNH();
        GMTrace.o(17537827864576L, 130667);
        return locala;
      }
    });
    if (paramInt != 0) {
      this.uKT.yM(paramInt);
    }
    getCount();
    GMTrace.o(17552189161472L, 130774);
  }
  
  public abstract ArrayList<T> ai(ArrayList<Object> paramArrayList);
  
  public final boolean bB(Object paramObject)
  {
    GMTrace.i(17553397121024L, 130783);
    boolean bool = this.uKT.bB(paramObject);
    GMTrace.o(17553397121024L, 130783);
    return bool;
  }
  
  public final boolean bNB()
  {
    GMTrace.i(17552994467840L, 130780);
    boolean bool = this.uKT.bNB();
    GMTrace.o(17552994467840L, 130780);
    return bool;
  }
  
  public abstract T bNH();
  
  public final SparseArray<K>[] bNz()
  {
    GMTrace.i(17553262903296L, 130782);
    SparseArray[] arrayOfSparseArray = this.uKT.bNz();
    GMTrace.o(17553262903296L, 130782);
    return arrayOfSparseArray;
  }
  
  public final void c(Object paramObject, T paramT)
  {
    GMTrace.i(17553128685568L, 130781);
    this.uKT.a(paramObject, paramT);
    GMTrace.o(17553128685568L, 130781);
  }
  
  public final void close()
  {
    GMTrace.i(17552323379200L, 130775);
    this.uKT.close();
    this.uKT = null;
    GMTrace.o(17552323379200L, 130775);
  }
  
  public final int getCount()
  {
    GMTrace.i(17552726032384L, 130778);
    int i = this.uKT.getCount();
    GMTrace.o(17552726032384L, 130778);
    return i;
  }
  
  public final boolean isClosed()
  {
    GMTrace.i(17552860250112L, 130779);
    boolean bool = this.uKT.isClosed();
    GMTrace.o(17552860250112L, 130779);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bj/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */