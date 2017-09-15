package com.tencent.mm.ui;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.a.a;
import com.tencent.mm.bj.a.d;
import com.tencent.mm.bj.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class e<K, T extends a>
  extends BaseAdapter
{
  public String TAG;
  public Context context;
  private int naZ;
  private int pageSize;
  public boolean uMQ;
  public e<K, T>.c uMR;
  private HashMap<K, b<K, T>> uMS;
  protected a uMT;
  public int uMU;
  public int uMV;
  public boolean uMW;
  int uMX;
  private boolean uMY;
  private boolean uMZ;
  private e<K, T>.e uNa;
  public K uNb;
  
  public e(Context paramContext)
  {
    this(true, paramContext);
    GMTrace.i(2934402187264L, 21863);
    this.pageSize = 5000;
    v.i(this.TAG, "newCursor setPageSize %d", new Object[] { Integer.valueOf(5000) });
    GMTrace.o(2934402187264L, 21863);
  }
  
  public e(Context paramContext, byte paramByte)
  {
    this(paramContext, 800, 2000);
    GMTrace.i(2934804840448L, 21866);
    GMTrace.o(2934804840448L, 21866);
  }
  
  private e(Context paramContext, int paramInt1, int paramInt2)
  {
    GMTrace.i(2934670622720L, 21865);
    this.TAG = "MicroMsg.CursorDataAdapter";
    this.uMQ = true;
    this.uMU = 1000;
    this.uMV = 3000;
    this.uMW = true;
    this.naZ = 0;
    this.uMX = 0;
    this.uNb = null;
    this.context = paramContext;
    this.uMY = true;
    this.uMZ = false;
    this.uMU = 800;
    this.uMV = 2000;
    GMTrace.o(2934670622720L, 21865);
  }
  
  private e(boolean paramBoolean, Context paramContext)
  {
    GMTrace.i(2934536404992L, 21864);
    this.TAG = "MicroMsg.CursorDataAdapter";
    this.uMQ = true;
    this.uMU = 1000;
    this.uMV = 3000;
    this.uMW = true;
    this.naZ = 0;
    this.uMX = 0;
    this.uNb = null;
    this.context = paramContext;
    this.uMY = true;
    GMTrace.o(2934536404992L, 21864);
  }
  
  private void a(d<K> paramd)
  {
    GMTrace.i(16852109492224L, 125558);
    ke(true);
    if ((this.uMR == null) || (this.uMR.uKT != paramd))
    {
      if ((this.uMR != null) && (!this.uMR.isClosed()))
      {
        this.uMR.close();
        this.uMR = null;
      }
      this.uMR = new c(paramd);
      this.uMR.getCount();
      bOC();
      notifyDataSetChanged();
    }
    GMTrace.o(16852109492224L, 125558);
  }
  
  private void a(e<K, T>.c parame)
  {
    GMTrace.i(2934939058176L, 21867);
    ke(false);
    this.uMR = parame;
    this.uMR.getCount();
    bOC();
    GMTrace.o(2934939058176L, 21867);
  }
  
  private void a(final e<K, T>.c parame, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(2937891848192L, 21889);
    if (paramBoolean1)
    {
      if ((this.uNa != null) && (this.uNa.bOP())) {
        this.uNa.bOM();
      }
      if (this.uMS != null) {
        this.uMS.clear();
      }
    }
    if (paramBoolean2)
    {
      a(new d()
      {
        public final void bOJ()
        {
          GMTrace.i(3088752574464L, 23013);
          e.a(e.this, parame);
          GMTrace.o(3088752574464L, 23013);
        }
      });
      GMTrace.o(2937891848192L, 21889);
      return;
    }
    a(parame);
    GMTrace.o(2937891848192L, 21889);
  }
  
  private void a(d paramd)
  {
    GMTrace.i(2937623412736L, 21887);
    long l = System.currentTimeMillis();
    if (this.uMT != null) {
      this.uMT.OJ();
    }
    paramd.bOJ();
    notifyDataSetChanged();
    if (this.uMT != null) {
      this.uMT.OI();
    }
    if (this.uNa != null) {
      this.uNa.bOQ();
    }
    v.i(this.TAG, "newcursor update callback last :%d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    GMTrace.o(2937623412736L, 21887);
  }
  
  private void bOC()
  {
    GMTrace.i(2935207493632L, 21869);
    if (this.uMY) {
      if (!this.uMR.bNB()) {
        break label114;
      }
    }
    label114:
    for (int i = 1;; i = 2)
    {
      if ((i != this.uMX) && (this.uMX != 0))
      {
        if ((this.uNa != null) && (this.uNa.bOP())) {
          a(new c(bOE()), true, false);
        }
        v.i(this.TAG, "newcursor change update stats  %d ", new Object[] { Integer.valueOf(i) });
      }
      this.uMX = i;
      GMTrace.o(2935207493632L, 21869);
      return;
    }
  }
  
  private void bOG()
  {
    GMTrace.i(2936952324096L, 21882);
    this.uMS.clear();
    this.uMS.put(this.uNb, null);
    GMTrace.o(2936952324096L, 21882);
  }
  
  private int bOH()
  {
    GMTrace.i(2937220759552L, 21884);
    if ((this.uMS == null) || (this.uMS.size() == 0))
    {
      GMTrace.o(2937220759552L, 21884);
      return 0;
    }
    if (this.uMS.containsKey(this.uNb))
    {
      GMTrace.o(2937220759552L, 21884);
      return 2;
    }
    GMTrace.o(2937220759552L, 21884);
    return 1;
  }
  
  private void bOI()
  {
    GMTrace.i(2937757630464L, 21888);
    if ((this.uMR != null) && (!this.uMR.isClosed()) && (this.uMS.size() == 0))
    {
      v.i(this.TAG, "events size is 0  ");
      GMTrace.o(2937757630464L, 21888);
      return;
    }
    a(new d()
    {
      public final void bOJ()
      {
        GMTrace.i(2536580841472L, 18899);
        Object localObject1;
        Object localObject2;
        if (e.a(e.this, e.b(e.this)))
        {
          localObject1 = new HashSet(e.b(e.this).size());
          localObject2 = e.b(e.this).values().iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((HashSet)localObject1).add(((e.b)((Iterator)localObject2).next()).zk);
          }
          v.i(e.this.TAG, "newcursor all event is delete");
          e.c(e.this).c(((HashSet)localObject1).toArray(), null);
        }
        for (;;)
        {
          e.b(e.this).clear();
          GMTrace.o(2536580841472L, 18899);
          return;
          long l;
          if (!e.b(e.this).containsKey(e.this.uNb))
          {
            l = System.currentTimeMillis();
            localObject2 = e.this.bOF();
            localObject1 = e.this.a(new HashSet(e.b(e.this).values()), (SparseArray[])localObject2);
            int j = localObject2.length;
            if (j > 1)
            {
              int i = 0;
              while (i < j)
              {
                v.i(e.this.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[i].size()), Integer.valueOf(localObject1[i].size()) });
                i += 1;
              }
            }
            v.i(e.this.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[0].size()), Integer.valueOf(localObject1[0].size()) });
            localObject2 = e.b(e.this).values().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              e.b localb = (e.b)((Iterator)localObject2).next();
              if (localb != null)
              {
                if (localb.uNf != null) {
                  v.i(e.this.TAG, "newcursor notify cache update : key : %s ", new Object[] { localb.zk });
                }
                e.c(e.this).c(localb.zk, (a)localb.uNf);
              }
              else
              {
                v.e(e.this.TAG, "newcursor event is null ! ");
              }
            }
            e.this.a((SparseArray[])localObject1);
            v.i(e.this.TAG, "newcursor after resort new pos size :%d  ", new Object[] { Integer.valueOf(e.c(e.this).bNz()[0].size()) });
          }
          else
          {
            l = System.currentTimeMillis();
            e.a(e.this, new e.c(e.this, e.this.bOE()), true, false);
            v.i(e.this.TAG, "cache unuseful,reset cursor,last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          }
        }
      }
    });
    GMTrace.o(2937757630464L, 21888);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(2934133751808L, 21861);
    this.uMT = parama;
    GMTrace.o(2934133751808L, 21861);
  }
  
  public final void a(SparseArray<K>[] paramArrayOfSparseArray)
  {
    GMTrace.i(2938026065920L, 21890);
    SparseArray[] arrayOfSparseArray = this.uMR.bNz();
    int i = 0;
    while (i < arrayOfSparseArray.length)
    {
      arrayOfSparseArray[i].clear();
      int j = 0;
      while (j < paramArrayOfSparseArray[i].size())
      {
        arrayOfSparseArray[i].put(j, paramArrayOfSparseArray[i].get(j));
        j += 1;
      }
      i += 1;
    }
    GMTrace.o(2938026065920L, 21890);
  }
  
  public abstract SparseArray<K>[] a(HashSet<b<K, T>> paramHashSet, SparseArray<K>[] paramArrayOfSparseArray);
  
  public final void aR(String paramString, boolean paramBoolean)
  {
    GMTrace.i(2935744364544L, 21873);
    if (this.naZ == 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && ((this.uMW | paramBoolean)))
      {
        if (!paramBoolean) {
          v.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[] { Boolean.valueOf(this.uMW), paramString, bf.bJP() });
        }
        kd(false);
      }
      GMTrace.o(2935744364544L, 21873);
      return;
    }
  }
  
  public abstract ArrayList<T> ai(ArrayList<K> paramArrayList);
  
  public final T bC(K paramK)
  {
    GMTrace.i(16852377927680L, 125560);
    if (this.uMR == null)
    {
      GMTrace.o(16852377927680L, 125560);
      return null;
    }
    paramK = this.uMR.uKT.bC(paramK);
    GMTrace.o(16852377927680L, 125560);
    return paramK;
  }
  
  public boolean bNB()
  {
    GMTrace.i(2935341711360L, 21870);
    if (this.uMR == null)
    {
      GMTrace.o(2935341711360L, 21870);
      return false;
    }
    boolean bool = this.uMR.bNB();
    GMTrace.o(2935341711360L, 21870);
    return bool;
  }
  
  public abstract T bNF();
  
  public final void bOB()
  {
    GMTrace.i(2934267969536L, 21862);
    this.uMT = null;
    GMTrace.o(2934267969536L, 21862);
  }
  
  public final int bOD()
  {
    GMTrace.i(2935610146816L, 21872);
    if (this.uMR == null)
    {
      GMTrace.o(2935610146816L, 21872);
      return 0;
    }
    d locald = this.uMR.uKT;
    if (locald == null)
    {
      GMTrace.o(2935610146816L, 21872);
      return 0;
    }
    if ((locald instanceof com.tencent.mm.bj.a.e))
    {
      int i = ((com.tencent.mm.bj.a.e)locald).uKK[0].getCount();
      GMTrace.o(2935610146816L, 21872);
      return i;
    }
    throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
  }
  
  public abstract d<K> bOE();
  
  public final SparseArray<K>[] bOF()
  {
    GMTrace.i(2936818106368L, 21881);
    if (this.uMR == null)
    {
      GMTrace.o(2936818106368L, 21881);
      return null;
    }
    SparseArray[] arrayOfSparseArray1 = this.uMR.bNz();
    SparseArray[] arrayOfSparseArray2 = new SparseArray[arrayOfSparseArray1.length];
    int i = 0;
    while (i < arrayOfSparseArray2.length)
    {
      arrayOfSparseArray2[i] = new SparseArray();
      int j = 0;
      while (j < arrayOfSparseArray1[i].size())
      {
        arrayOfSparseArray2[i].put(j, arrayOfSparseArray1[i].get(j));
        j += 1;
      }
      i += 1;
    }
    GMTrace.o(2936818106368L, 21881);
    return arrayOfSparseArray2;
  }
  
  public int getCount()
  {
    GMTrace.i(2935475929088L, 21871);
    if (this.uMR == null)
    {
      long l = System.currentTimeMillis();
      a(bOE());
      v.i(this.TAG, "newcursor createCursor last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    aR("getcount", false);
    int i = this.uMR.getCount();
    GMTrace.o(2935475929088L, 21871);
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    GMTrace.i(2936012800000L, 21875);
    GMTrace.o(2936012800000L, 21875);
    return 0L;
  }
  
  public final void kd(boolean paramBoolean)
  {
    GMTrace.i(2937086541824L, 21883);
    int i;
    if ((this.uMZ) || (paramBoolean)) {
      if (((this.uNa != null) && (this.uNa.bOP())) || (bOH() != 0))
      {
        i = 1;
        if (i != 0)
        {
          i = bOH();
          if (this.uNa == null) {
            break label266;
          }
          int j = this.uNa.bOR();
          v.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[] { Integer.valueOf(j) });
          if (j != 0) {
            this.uNa.bOM();
          }
          if (i == 2) {
            break label266;
          }
          i = j;
        }
      }
    }
    label266:
    for (;;)
    {
      v.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[] { Integer.valueOf(i) });
      this.naZ = 0;
      if (i == 2) {
        a(new c(bOE()), true, true);
      }
      for (;;)
      {
        this.naZ = 0;
        GMTrace.o(2937086541824L, 21883);
        return;
        i = 0;
        break;
        bOI();
        continue;
        i = bOH();
        if (i == 0)
        {
          v.i(this.TAG, "newcursor need not change ");
          GMTrace.o(2937086541824L, 21883);
          return;
        }
        if (i == 2)
        {
          v.i(this.TAG, "newcursor enqueueMessage resetcursor ");
          this.uMS.clear();
        }
        if (this.uNa == null) {
          this.uNa = new e();
        }
        this.uNa.yU(i);
      }
    }
  }
  
  public final void ke(boolean paramBoolean)
  {
    GMTrace.i(2938160283648L, 21891);
    if (this.uMR != null)
    {
      this.uMR.close();
      this.uMR = null;
    }
    if ((paramBoolean) && (this.uNa != null))
    {
      this.uNa.quit();
      this.uNa = null;
      if (this.uMS != null)
      {
        this.uMS.clear();
        v.i(this.TAG, "newcursor closeCursor,clear events");
      }
    }
    this.naZ = 0;
    this.uMX = 0;
    GMTrace.o(2938160283648L, 21891);
  }
  
  public void o(K paramK, int paramInt)
  {
    GMTrace.i(2937354977280L, 21885);
    if (this.uMR != null)
    {
      if (this.uMS == null) {
        this.uMS = new HashMap();
      }
      boolean bool = this.uMS.containsKey(this.uNb);
      int i;
      label96:
      int j;
      if ((paramInt == 5) || (!this.uMY) || (paramInt == 1)) {
        if (paramInt != 5)
        {
          bOG();
          v.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[] { Integer.valueOf(paramInt) });
          i = 1;
          this.naZ = bOH();
          paramK = this.TAG;
          j = this.naZ;
          if (this.uMX != 1) {
            break label737;
          }
        }
      }
      label331:
      label416:
      label701:
      label737:
      for (bool = true;; bool = false)
      {
        v.i(paramK, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (i == 0) {
          break label743;
        }
        v.i(this.TAG, "newcursor event is refresh sync ");
        kd(true);
        GMTrace.o(2937354977280L, 21885);
        return;
        if (bool) {
          break;
        }
        this.uMS.put(paramK, new b(paramK, paramInt, null));
        break;
        if (bool)
        {
          v.i(this.TAG, "newcursor need reset ,return ");
          GMTrace.o(2937354977280L, 21885);
          return;
        }
        if (this.uMX == 1)
        {
          if ((this.uMR.bB(paramK)) || (paramInt == 2))
          {
            HashMap localHashMap = this.uMS;
            b localb1 = new b(paramK, paramInt, null);
            if ((localb1.uNe == 2) && (this.uMR.bB(localb1.zk))) {
              localb1.uNe = 3;
            }
            b localb2 = (b)localHashMap.get(paramK);
            if (localb2 != null)
            {
              i = 1;
              if (i == 0) {
                break label701;
              }
              localHashMap.remove(localb2);
              switch (localb1.uNe)
              {
              case 3: 
              case 4: 
              default: 
                switch (localb2.uNe)
                {
                case 3: 
                case 4: 
                default: 
                  localb1.uNe = 3;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
            for (;;)
            {
              paramK = this.uMR;
              i = localHashMap.size();
              if (!paramK.uKT.yK(i))
              {
                v.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[] { Integer.valueOf(localHashMap.size()) });
                localHashMap.clear();
                localHashMap.put(this.uNb, null);
              }
              v.i(this.TAG, "newcursor add event events size %d", new Object[] { Integer.valueOf(this.uMS.size()) });
              i = 0;
              break;
              i = 0;
              break label331;
              switch (localb2.uNe)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                localb1.uNe = 5;
                break;
              case 5: 
                v.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                localb1.uNe = 5;
                break;
                switch (localb2.uNe)
                {
                case 3: 
                case 4: 
                default: 
                  v.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                  localb1.uNe = 2;
                  break;
                case 5: 
                  localb1.uNe = 3;
                  break;
                case 2: 
                  v.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                  localb1.uNe = 2;
                  break;
                  v.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                  break label416;
                  localb1.uNe = 2;
                  break;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
          }
          v.i(this.TAG, "newcursor event pass ");
          i = 0;
          break label96;
        }
        bOG();
        i = 0;
        break label96;
      }
      label743:
      if ((this.uMQ) && (this.uMW)) {
        kd(false);
      }
    }
    GMTrace.o(2937354977280L, 21885);
  }
  
  public void pause()
  {
    GMTrace.i(2937489195008L, 21886);
    this.uMQ = false;
    v.i(this.TAG, "new cursor pasue");
    GMTrace.o(2937489195008L, 21886);
  }
  
  public final T yL(int paramInt)
  {
    GMTrace.i(16852243709952L, 125559);
    if (this.uMR == null) {
      a(bOE());
    }
    aR("getItem", false);
    this.uMR.uKT.moveToPosition(paramInt);
    a locala = this.uMR.uKT.yL(paramInt);
    if (locala != null) {
      locala.bKC();
    }
    for (;;)
    {
      GMTrace.o(16852243709952L, 125559);
      return locala;
      v.e(this.TAG, "newcursor getItem error %d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  public static abstract interface a
  {
    public abstract void OI();
    
    public abstract void OJ();
  }
  
  public static final class b<K, T>
  {
    public int uNe;
    public T uNf;
    public K zk;
    
    public b(K paramK, int paramInt, T paramT)
    {
      GMTrace.i(2065208180736L, 15387);
      this.zk = paramK;
      this.uNe = paramInt;
      this.uNf = null;
      GMTrace.o(2065208180736L, 15387);
    }
    
    public final boolean equals(Object paramObject)
    {
      GMTrace.i(2065476616192L, 15389);
      if (this == paramObject)
      {
        GMTrace.o(2065476616192L, 15389);
        return true;
      }
      if (paramObject == null)
      {
        GMTrace.o(2065476616192L, 15389);
        return false;
      }
      if (getClass() != paramObject.getClass())
      {
        GMTrace.o(2065476616192L, 15389);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.uNe != ((b)paramObject).uNe)
      {
        GMTrace.o(2065476616192L, 15389);
        return false;
      }
      if (this.zk == null)
      {
        if (((b)paramObject).zk != null)
        {
          GMTrace.o(2065476616192L, 15389);
          return false;
        }
      }
      else if (!this.zk.equals(((b)paramObject).zk))
      {
        GMTrace.o(2065476616192L, 15389);
        return false;
      }
      GMTrace.o(2065476616192L, 15389);
      return true;
    }
    
    public final int hashCode()
    {
      GMTrace.i(2065342398464L, 15388);
      int j = this.uNe;
      if (this.zk == null) {}
      for (int i = 0;; i = this.zk.hashCode())
      {
        GMTrace.o(2065342398464L, 15388);
        return i + (j + 31) * 31;
      }
    }
  }
  
  final class c
    extends g<K, T>
  {
    public c()
    {
      super(e.a(e.this));
      GMTrace.i(16804596416512L, 125204);
      GMTrace.o(16804596416512L, 125204);
    }
    
    public final ArrayList<T> ai(ArrayList paramArrayList)
    {
      GMTrace.i(2551344791552L, 19009);
      paramArrayList = e.this.ai(paramArrayList);
      GMTrace.o(2551344791552L, 19009);
      return paramArrayList;
    }
    
    public final T bNH()
    {
      GMTrace.i(16804730634240L, 125205);
      a locala = e.this.bNF();
      GMTrace.o(16804730634240L, 125205);
      return locala;
    }
  }
  
  private static abstract interface d
  {
    public abstract void bOJ();
  }
  
  private final class e
  {
    public e<K, T>.e.b uNg;
    private e<K, T>.e.c uNh;
    public LinkedList<Integer> uNi;
    public int uNj;
    
    public e()
    {
      GMTrace.i(1704296710144L, 12698);
      bOK();
      GMTrace.o(1704296710144L, 12698);
    }
    
    private void bOK()
    {
      GMTrace.i(1704430927872L, 12699);
      this.uNg = new b(Looper.getMainLooper());
      this.uNh = new c(ap.vL().nIe.getLooper());
      GMTrace.o(1704430927872L, 12699);
    }
    
    private void bOL()
    {
      GMTrace.i(1704565145600L, 12700);
      Object localObject = this.uNh;
      ((c)localObject).removeMessages(((c)localObject).uNq);
      ((c)localObject).removeMessages(((c)localObject).uNr);
      localObject = this.uNg;
      ((b)localObject).uNm = true;
      ((b)localObject).removeMessages(1);
      ((b)localObject).removeMessages(2);
      this.uNi.clear();
      this.uNj = 0;
      GMTrace.o(1704565145600L, 12700);
    }
    
    public final void bOM()
    {
      try
      {
        GMTrace.i(1704699363328L, 12701);
        v.i(e.this.TAG, "newcursor resetQueue ");
        bOL();
        bOK();
        GMTrace.o(1704699363328L, 12701);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final void bON()
    {
      GMTrace.i(16013651345408L, 119311);
      Object localObject3;
      try
      {
        int i = bOO();
        this.uNi.clear();
        localObject3 = new a(i);
        if (((a)localObject3).uNk == 2)
        {
          long l = System.currentTimeMillis();
          Object localObject1 = ((a)localObject3).uNl.uNc.bOE();
          localObject1 = new e.c(((a)localObject3).uNl.uNc, (d)localObject1);
          i = ((e.c)localObject1).getCount();
          v.i(((a)localObject3).uNl.uNc.TAG, "newcursor fillCursor last : %d  count %d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
          localObject3 = ((a)localObject3).uNl.uNg;
          Message localMessage = Message.obtain();
          localMessage.obj = localObject1;
          localMessage.what = 2;
          ((b)localObject3).sendMessage(localMessage);
          GMTrace.o(16013651345408L, 119311);
          return;
        }
      }
      finally {}
      ((a)localObject3).uNl.uNg.sendEmptyMessage(1);
      GMTrace.o(16013651345408L, 119311);
    }
    
    public final int bOO()
    {
      int i = 0;
      GMTrace.i(1704967798784L, 12703);
      if (this.uNi.size() > 1) {
        i = 2;
      }
      for (;;)
      {
        GMTrace.o(1704967798784L, 12703);
        return i;
        if (this.uNi.size() == 1) {
          i = ((Integer)this.uNi.get(0)).intValue();
        }
      }
    }
    
    /* Error */
    public final boolean bOP()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc2_w 215
      //   5: sipush 12704
      //   8: invokestatic 44	com/tencent/gmtrace/GMTrace:i	(JI)V
      //   11: aload_0
      //   12: getfield 111	com/tencent/mm/ui/e$e:uNj	I
      //   15: ifeq +18 -> 33
      //   18: iconst_1
      //   19: istore_1
      //   20: ldc2_w 215
      //   23: sipush 12704
      //   26: invokestatic 50	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   29: aload_0
      //   30: monitorexit
      //   31: iload_1
      //   32: ireturn
      //   33: iconst_0
      //   34: istore_1
      //   35: ldc2_w 215
      //   38: sipush 12704
      //   41: invokestatic 50	com/tencent/gmtrace/GMTrace:o	(JI)V
      //   44: goto -15 -> 29
      //   47: astore_2
      //   48: aload_0
      //   49: monitorexit
      //   50: aload_2
      //   51: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	52	0	this	e
      //   19	16	1	bool	boolean
      //   47	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	18	47	finally
      //   20	29	47	finally
      //   35	44	47	finally
    }
    
    public final void bOQ()
    {
      try
      {
        GMTrace.i(1705236234240L, 12705);
        this.uNh.lastUpdateTime = System.currentTimeMillis();
        GMTrace.o(1705236234240L, 12705);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final int bOR()
    {
      try
      {
        GMTrace.i(1705370451968L, 12706);
        int i = this.uNj;
        GMTrace.o(1705370451968L, 12706);
        return i;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final void quit()
    {
      try
      {
        GMTrace.i(1704833581056L, 12702);
        v.i(e.this.TAG, "newcursor quit ");
        bOL();
        GMTrace.o(1704833581056L, 12702);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final void yU(int paramInt)
    {
      try
      {
        GMTrace.i(1705504669696L, 12707);
        if (!this.uNi.contains(Integer.valueOf(paramInt))) {
          this.uNi.add(Integer.valueOf(paramInt));
        }
        this.uNj = bOO();
        c localc = this.uNh;
        localc.sendEmptyMessage(localc.uNr);
        GMTrace.o(1705504669696L, 12707);
        return;
      }
      finally {}
    }
    
    private final class a
    {
      int uNk;
      
      public a(int paramInt)
      {
        GMTrace.i(2916685447168L, 21731);
        this.uNk = paramInt;
        GMTrace.o(2916685447168L, 21731);
      }
    }
    
    final class b
      extends ad
    {
      boolean uNm;
      public final int uNn;
      public final int uNo;
      
      public b(Looper paramLooper)
      {
        super();
        GMTrace.i(1603633414144L, 11948);
        this.uNn = 1;
        this.uNo = 2;
        GMTrace.o(1603633414144L, 11948);
      }
      
      public final void handleMessage(Message paramMessage)
      {
        GMTrace.i(1603767631872L, 11949);
        super.handleMessage(paramMessage);
        if (this.uNm)
        {
          GMTrace.o(1603767631872L, 11949);
          return;
        }
        synchronized (e.e.this)
        {
          e.e.this.uNj = e.e.this.bOO();
          v.i(e.this.TAG, "newcursor updateWorkerRefresh status %d", new Object[] { Integer.valueOf(e.e.this.uNj) });
          if (paramMessage.what == 1)
          {
            e.d(e.this);
            GMTrace.o(1603767631872L, 11949);
            return;
          }
        }
        if (paramMessage.what == 2) {
          e.a(e.this, (e.c)paramMessage.obj, false, true);
        }
        GMTrace.o(1603767631872L, 11949);
      }
    }
    
    final class c
      extends ad
    {
      long lastUpdateTime;
      long uNp;
      final int uNq;
      final int uNr;
      
      public c(Looper paramLooper)
      {
        super();
        GMTrace.i(2933865316352L, 21859);
        this.uNq = (hashCode() | 0x776);
        this.uNr = (hashCode() | 0x77A);
        e.e.this.uNi = new LinkedList();
        GMTrace.o(2933865316352L, 21859);
      }
      
      public final void handleMessage(Message paramMessage)
      {
        GMTrace.i(2933999534080L, 21860);
        super.handleMessage(paramMessage);
        if (paramMessage.what == this.uNr)
        {
          removeMessages(this.uNq);
          long l = System.currentTimeMillis();
          if ((l - this.uNp > e.this.uMU) || (l - this.uNp < 0L) || ((this.lastUpdateTime != 0L) && (l - this.lastUpdateTime > e.this.uMV)) || (l - this.lastUpdateTime < 0L)) {
            e.e.this.bON();
          }
          for (;;)
          {
            this.uNp = l;
            GMTrace.o(2933999534080L, 21860);
            return;
            sendEmptyMessageDelayed(this.uNq, e.this.uMU);
          }
        }
        if (paramMessage.what == this.uNq) {
          e.e.this.bON();
        }
        GMTrace.o(2933999534080L, 21860);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */