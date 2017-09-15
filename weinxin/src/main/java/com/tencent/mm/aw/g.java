package com.tencent.mm.aw;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bjn;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class g
{
  public String icS;
  LinkedHashMap<String, a> icT;
  final ReadWriteLock icU;
  private StringBuilder icV;
  
  public g(String paramString)
  {
    GMTrace.i(4389993447424L, 32708);
    this.icU = new ReentrantReadWriteLock();
    this.icV = new StringBuilder();
    this.icT = new LinkedHashMap();
    this.icS = paramString;
    GMTrace.o(4389993447424L, 32708);
  }
  
  public final LinkedList<avu> LW()
  {
    GMTrace.i(4390127665152L, 32709);
    LinkedList localLinkedList = new LinkedList();
    this.icU.readLock().lock();
    Iterator localIterator = this.icT.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.icX) {
        localLinkedList.add(new avu().OU(locala.icW));
      }
    }
    this.icU.readLock().unlock();
    GMTrace.o(4390127665152L, 32709);
    return localLinkedList;
  }
  
  public final String LX()
  {
    GMTrace.i(4390261882880L, 32710);
    this.icV.setLength(0);
    this.icU.readLock().lock();
    Object localObject = this.icT.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.data != null) {
        this.icV.append(locala.data);
      }
    }
    this.icU.readLock().unlock();
    localObject = this.icV.toString();
    GMTrace.o(4390261882880L, 32710);
    return (String)localObject;
  }
  
  public final boolean LY()
  {
    GMTrace.i(4390396100608L, 32711);
    if (this.icT.size() == 0)
    {
      v.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
      GMTrace.o(4390396100608L, 32711);
      return false;
    }
    this.icU.readLock().lock();
    Iterator localIterator = this.icT.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      v.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[] { locala.icW, Boolean.valueOf(locala.icY), Boolean.valueOf(locala.idc) });
    } while (locala.idc);
    for (boolean bool = false;; bool = true)
    {
      this.icU.readLock().unlock();
      GMTrace.o(4390396100608L, 32711);
      return bool;
    }
  }
  
  public final void P(List<bjn> paramList)
  {
    GMTrace.i(4390530318336L, 32712);
    int i;
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      this.icU.readLock().lock();
      if (this.icT.size() != 0) {
        break label120;
      }
      this.icU.readLock().unlock();
      localObject = "[]";
    }
    for (;;)
    {
      v.d("MicroMsg.ShortSentenceContainer", "updateVoiceInfoResult respVTList size %s innerContainer %s", new Object[] { Integer.valueOf(i), localObject });
      if ((paramList != null) && (paramList.size() != 0)) {
        break label267;
      }
      v.i("MicroMsg.ShortSentenceContainer", "respList == null");
      GMTrace.o(4390530318336L, 32712);
      return;
      i = paramList.size();
      break;
      label120:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      localIterator = this.icT.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((a)localIterator.next()).icW).append(", ");
      }
      if (((StringBuilder)localObject).length() <= 3)
      {
        this.icU.readLock().unlock();
        localObject = "]";
      }
      else
      {
        ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        this.icU.readLock().unlock();
        localObject = "]";
      }
    }
    label267:
    this.icU.readLock().lock();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      bjn localbjn = (bjn)localIterator.next();
      if (localbjn == null)
      {
        v.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
      }
      else
      {
        a locala = (a)this.icT.get(localbjn.tpP);
        if (locala == null)
        {
          v.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[] { localbjn.tpP });
        }
        else if (localbjn == null)
        {
          v.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
        }
        else
        {
          String str1 = localbjn.tpP;
          i = localbjn.uhq;
          label419:
          boolean bool1;
          label430:
          int j;
          String str2;
          boolean bool2;
          boolean bool3;
          int k;
          int m;
          if ((localbjn.ufp == null) || (localbjn.ufp.tXD == null))
          {
            paramList = null;
            if (localbjn.the == 0) {
              break label630;
            }
            bool1 = true;
            j = localbjn.the;
            str2 = locala.icW;
            bool2 = locala.icX;
            bool3 = locala.icY;
            k = locala.icZ;
            m = locala.idb;
            if (locala.data != null) {
              break label636;
            }
          }
          label630:
          label636:
          for (localObject = null;; localObject = Integer.valueOf(locala.data.length()))
          {
            v.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", new Object[] { str1, Integer.valueOf(i), paramList, Boolean.valueOf(bool1), Integer.valueOf(j), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), localObject, Boolean.valueOf(locala.idc) });
            if ((localbjn.uhq >= locala.idb) && (!locala.idc)) {
              break label652;
            }
            v.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
            break;
            paramList = Integer.valueOf(localbjn.ufp.tXB);
            break label419;
            bool1 = false;
            break label430;
          }
          label652:
          locala.idb = localbjn.uhq;
          if ((localbjn.ufp == null) || (localbjn.ufp.tXD == null))
          {
            paramList = null;
            label683:
            locala.data = paramList;
            if (localbjn.the == 0) {
              break label819;
            }
            bool1 = true;
            label700:
            locala.idc = bool1;
            paramList = localbjn.tpP;
            j = locala.idb;
            bool1 = locala.idc;
            if (locala.data != null) {
              break label825;
            }
          }
          label819:
          label825:
          for (i = -1;; i = locala.data.length())
          {
            v.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", new Object[] { paramList, Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(i) });
            if (localbjn.the != 2) {
              break;
            }
            v.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[] { localbjn.tpP });
            break;
            paramList = localbjn.ufp.tXD.bGP();
            break label683;
            bool1 = false;
            break label700;
          }
        }
      }
    }
    this.icU.readLock().unlock();
    GMTrace.o(4390530318336L, 32712);
  }
  
  public final void gR(int paramInt)
  {
    GMTrace.i(4390664536064L, 32713);
    v.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0) {
      throw new IllegalStateException("splitShortSentence file mark less than zero. mark: " + paramInt);
    }
    this.icU.readLock().lock();
    if (this.icT.size() == 0)
    {
      v.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
      GMTrace.o(4390664536064L, 32713);
      return;
    }
    Iterator localIterator = this.icT.values().iterator();
    for (a locala = null; localIterator.hasNext(); locala = (a)localIterator.next()) {}
    if (locala == null) {
      throw new IllegalStateException("splitShortSentence last info is null");
    }
    v.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[] { Integer.valueOf(locala.icZ), locala.icW, Integer.valueOf(paramInt) });
    locala.icZ = paramInt;
    this.icU.readLock().unlock();
    GMTrace.o(4390664536064L, 32713);
  }
  
  public final a gS(int paramInt)
  {
    GMTrace.i(4390798753792L, 32714);
    if (this.icT.size() == 0)
    {
      GMTrace.o(4390798753792L, 32714);
      return null;
    }
    this.icU.readLock().lock();
    Iterator localIterator = this.icT.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      v.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.icZ), Boolean.valueOf(locala.icY) });
    } while ((locala.icY) || (paramInt > locala.icZ));
    for (;;)
    {
      this.icU.readLock().unlock();
      GMTrace.o(4390798753792L, 32714);
      return locala;
      locala = null;
    }
  }
  
  public final class a
  {
    public String data;
    public String icW;
    public boolean icX;
    public boolean icY;
    public int icZ;
    public int ida;
    public int idb;
    public boolean idc;
    
    public a()
    {
      GMTrace.i(4389859229696L, 32707);
      long l3 = 0xFFFFFFFF & System.currentTimeMillis();
      long l4 = 0xFFFFFFFF & new Random(System.currentTimeMillis()).nextInt();
      long l2 = l3 << 32 | l4;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = Math.abs(l2);
      }
      this$1 = g.this.icS + String.valueOf(l1);
      v.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", new Object[] { Long.valueOf(l4), Long.toBinaryString(l4), Long.valueOf(l3), Long.toBinaryString(l3), Long.valueOf(l1), Long.toBinaryString(l1), g.this.icS, g.this });
      this.icW = g.this;
      this.icX = false;
      this.icY = false;
      this.icZ = Integer.MAX_VALUE;
      this.ida = 0;
      this.idb = -1;
      this.data = null;
      this.idc = false;
      GMTrace.o(4389859229696L, 32707);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aw/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */