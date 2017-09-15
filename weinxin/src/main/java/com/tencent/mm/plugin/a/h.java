package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends a
{
  long duration;
  long ilE;
  long[] ilI;
  List<g> ilK;
  List<Pair> ilL;
  long ilO;
  private long ilP;
  private long ilQ;
  private long ilR;
  private long ilS;
  private int[] ilT;
  private int[] ilU;
  private int[] ilV;
  private long[] ilW;
  private int[] ilX;
  private int[] ilY;
  private int[] ilZ;
  
  public h(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    super(paramInt1, paramLong1, paramInt2, 0L);
    GMTrace.i(16392682209280L, 122135);
    this.ilK = new LinkedList();
    this.ilL = new LinkedList();
    GMTrace.o(16392682209280L, 122135);
  }
  
  private boolean NH()
  {
    GMTrace.i(16393487515648L, 122141);
    if (this.ilV != null) {}
    int m;
    for (int i = this.ilV.length;; i = this.ilW.length)
    {
      j = i - 1;
      m = this.ilT.length;
      i = 1;
      while (i < m)
      {
        this.ilT[(i - 1)] = (this.ilT[i] - this.ilT[(i - 1)]);
        i += 1;
      }
    }
    this.ilT[(m - 1)] = (j - this.ilT[(m - 1)] + 1);
    this.ilZ = new int[j + 1];
    this.ilZ[0] = 0;
    int j = 1;
    i = 0;
    int k;
    while (i < m)
    {
      int n = this.ilT[i];
      int i1 = this.ilU[i];
      k = 0;
      while (k < n)
      {
        this.ilZ[j] = (this.ilZ[(j - 1)] + i1);
        j += 1;
        k += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < this.ilI.length)
    {
      k = (int)this.ilI[i];
      m = hc(k);
      j = this.ilZ[(m - 1)] + 1;
      if (this.ilX.length == 1)
      {
        l2 = (k - j) * this.ilX[0];
        l1 = hd(m);
        this.ilI[i] = (l2 + l1);
        i += 1;
      }
      else
      {
        l1 = 0L;
        for (;;)
        {
          l2 = l1;
          if (j >= k) {
            break;
          }
          l1 += this.ilX[j];
          j += 1;
        }
      }
    }
    Object localObject = this.ilK.iterator();
    j = 0;
    long l2 = 0L;
    i = 1;
    long l1 = 0L;
    if (((Iterator)localObject).hasNext())
    {
      g localg = (g)((Iterator)localObject).next();
      localg.size = this.ilX[i];
      k = hc(i);
      if (k != j) {}
      for (localg.start = hd(k);; localg.start = l2)
      {
        l2 = localg.start + localg.size;
        l1 += localg.ilM;
        localg.ilM = (((float)l1 * 1.0F / (float)this.ilE * 1000.0F * 1000.0F));
        localg.id = i;
        i += 1;
        j = k;
        break;
      }
    }
    i = 0;
    while (i < this.ilY.length)
    {
      localObject = (g)this.ilK.get(this.ilY[i] - 1);
      ((g)localObject).ilN = 1;
      localObject = new Pair(Integer.valueOf(this.ilY[i] - 1), Long.valueOf(((g)localObject).ilM));
      this.ilL.add(localObject);
      i += 1;
    }
    GMTrace.o(16393487515648L, 122141);
    return true;
  }
  
  private long a(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    GMTrace.i(16392950644736L, 122137);
    this.ilP = paramRandomAccessFile.getFilePointer();
    if (!c.a(paramRandomAccessFile, 4L))
    {
      GMTrace.o(16392950644736L, 122137);
      return -1L;
    }
    byte[] arrayOfByte = new byte[12];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      v.w("MicroMsg.StblAtom", "stsc read entry count error");
      GMTrace.o(16392950644736L, 122137);
      return -1L;
    }
    int i = c.l(arrayOfByte, 0);
    long l3 = 12L * i;
    if ((l3 > paramInt - 16) || (l3 <= 0L))
    {
      v.w("MicroMsg.StblAtom", "stsc error entryCount : " + i);
      GMTrace.o(16392950644736L, 122137);
      return -1L;
    }
    v.d("MicroMsg.StblAtom", "handle stsc entryCount : " + i);
    this.ilT = new int[i];
    this.ilU = new int[i];
    i = 0;
    long l1 = 0L;
    for (paramInt = paramRandomAccessFile.read(arrayOfByte);; paramInt = paramRandomAccessFile.read(arrayOfByte))
    {
      long l2 = l1;
      if (paramInt >= 12)
      {
        l1 += paramInt;
        this.ilT[i] = c.l(arrayOfByte, 0);
        this.ilU[i] = c.l(arrayOfByte, 4);
        i += 1;
        if (l1 >= l3)
        {
          v.d("MicroMsg.StblAtom", "read stsc atom end");
          l2 = l1;
        }
      }
      else
      {
        GMTrace.o(16392950644736L, 122137);
        return l2 + 8L;
      }
    }
  }
  
  private long b(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    GMTrace.i(16393084862464L, 122138);
    this.ilQ = paramRandomAccessFile.getFilePointer();
    if (!c.a(paramRandomAccessFile, 4L))
    {
      GMTrace.o(16393084862464L, 122138);
      return -1L;
    }
    byte[] arrayOfByte = new byte[4];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      v.w("MicroMsg.StblAtom", "stco read entry count error");
      GMTrace.o(16393084862464L, 122138);
      return -1L;
    }
    int i = c.l(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      v.w("MicroMsg.StblAtom", "stco error entryCount : " + i);
      GMTrace.o(16393084862464L, 122138);
      return -1L;
    }
    this.ilV = new int[i + 1];
    paramInt = 1;
    long l1 = 0L;
    i = paramRandomAccessFile.read(arrayOfByte);
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.ilV[paramInt] = c.l(arrayOfByte, 0);
        if (l1 >= l3)
        {
          v.d("MicroMsg.StblAtom", "read stco atom end");
          l2 = l1;
        }
      }
      else
      {
        GMTrace.o(16393084862464L, 122138);
        return l2 + 8L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  private long c(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    GMTrace.i(16393219080192L, 122139);
    this.ilR = paramRandomAccessFile.getFilePointer();
    if (!c.a(paramRandomAccessFile, 4L))
    {
      GMTrace.o(16393219080192L, 122139);
      return -1L;
    }
    byte[] arrayOfByte = new byte[8];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      v.w("MicroMsg.StblAtom", "co64 read entry count error");
      GMTrace.o(16393219080192L, 122139);
      return -1L;
    }
    int i = c.l(arrayOfByte, 0);
    long l3 = 8L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      v.w("MicroMsg.StblAtom", "stco error entryCount : " + i);
      GMTrace.o(16393219080192L, 122139);
      return -1L;
    }
    this.ilW = new long[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 8)
      {
        l1 += i;
        this.ilW[paramInt] = c.I(arrayOfByte);
        if (l1 >= l3)
        {
          v.d("MicroMsg.StblAtom", "read stco atom end");
          l2 = l1;
        }
      }
      else
      {
        GMTrace.o(16393219080192L, 122139);
        return l2 + 8L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  private long d(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    GMTrace.i(16393353297920L, 122140);
    this.ilS = paramRandomAccessFile.getFilePointer();
    if (!c.a(paramRandomAccessFile, 4L))
    {
      GMTrace.o(16393353297920L, 122140);
      return -1L;
    }
    byte[] arrayOfByte = new byte[4];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      v.w("MicroMsg.StblAtom", "stsz read sample size error");
      GMTrace.o(16393353297920L, 122140);
      return -1L;
    }
    int i = c.l(arrayOfByte, 0);
    if (i > 0)
    {
      this.ilX = new int[1];
      this.ilX[0] = i;
      v.i("MicroMsg.StblAtom", "all sample size is the same. size : " + i);
      GMTrace.o(16393353297920L, 122140);
      return 8L;
    }
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      v.w("MicroMsg.StblAtom", "stsz read entry count error");
      GMTrace.o(16393353297920L, 122140);
      return -1L;
    }
    i = c.l(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 20))
    {
      v.w("MicroMsg.StblAtom", "stco error entryCount : " + i);
      GMTrace.o(16393353297920L, 122140);
      return -1L;
    }
    this.ilX = new int[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.ilX[paramInt] = c.l(arrayOfByte, 0);
        if (l1 >= l3)
        {
          v.d("MicroMsg.StblAtom", "read stsz atom end");
          l2 = l1;
        }
      }
      else
      {
        GMTrace.o(16393353297920L, 122140);
        return l2 + 12L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  private long e(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    GMTrace.i(17457968316416L, 130072);
    if (!c.a(paramRandomAccessFile, 4L))
    {
      GMTrace.o(17457968316416L, 130072);
      return -1L;
    }
    byte[] arrayOfByte = new byte[4];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      v.w("MicroMsg.StblAtom", "stss rread entry count error");
      GMTrace.o(17457968316416L, 130072);
      return -1L;
    }
    int i = c.l(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      v.w("MicroMsg.StblAtom", "stss error entryCount : " + i);
      GMTrace.o(17457968316416L, 130072);
      return -1L;
    }
    this.ilY = new int[i];
    paramInt = 0;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.ilY[paramInt] = c.l(arrayOfByte, 0);
        if (l1 >= l3)
        {
          v.d("MicroMsg.StblAtom", "read stss atom end");
          l2 = l1;
        }
      }
      else
      {
        GMTrace.o(17457968316416L, 130072);
        return l2 + 8L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  private int hc(int paramInt)
  {
    GMTrace.i(17458102534144L, 130073);
    int i = 0;
    if (i < this.ilZ.length) {
      if (paramInt > this.ilZ[i]) {}
    }
    for (;;)
    {
      GMTrace.o(17458102534144L, 130073);
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  private long hd(int paramInt)
  {
    GMTrace.i(17458236751872L, 130074);
    long l;
    if (this.ilV != null)
    {
      l = this.ilV[paramInt];
      GMTrace.o(17458236751872L, 130074);
      return l;
    }
    if (this.ilW != null)
    {
      l = this.ilW[paramInt];
      GMTrace.o(17458236751872L, 130074);
      return l;
    }
    GMTrace.o(17458236751872L, 130074);
    return 0L;
  }
  
  public final void b(RandomAccessFile paramRandomAccessFile)
  {
    GMTrace.i(16392816427008L, 122136);
    byte[] arrayOfByte1 = new byte[8];
    int i3 = paramRandomAccessFile.read(arrayOfByte1);
    int m = 0;
    int n = 0;
    int k = 0;
    int i = 0;
    int j = 0;
    int i5;
    int i1;
    long l1;
    label93:
    label108:
    byte[] arrayOfByte2;
    int i2;
    int i4;
    if (i3 >= 8)
    {
      i5 = c.l(arrayOfByte1, 0);
      i1 = c.l(arrayOfByte1, 4);
      l1 = 0L;
      if (i1 == a.ikO)
      {
        this.ilO = paramRandomAccessFile.getFilePointer();
        if (!c.a(paramRandomAccessFile, 4L)) {
          l1 = -1L;
        }
        long l2;
        for (;;)
        {
          m = n;
          n = 1;
          i1 = j;
          j = i;
          i = i1;
          if (c.a(paramRandomAccessFile, i5 - l1 - i3)) {
            break label692;
          }
          throw new IOException("skip file error.");
          arrayOfByte2 = new byte[8];
          if (paramRandomAccessFile.read(arrayOfByte2, 0, 4) < 4)
          {
            v.w("MicroMsg.StblAtom", "stts read entry count error");
            l1 = -1L;
          }
          else
          {
            m = c.l(arrayOfByte2, 0);
            l2 = m * 8L;
            if ((l2 <= i5 - 16) && (l2 > 0L)) {
              break;
            }
            v.w("MicroMsg.StblAtom", "stts error entryCount : " + m);
            l1 = -1L;
          }
        }
        i2 = 0;
        i1 = 0;
        this.ilI = new long[(int)(this.duration / this.ilE) + 2];
        Object localObject = this.ilI;
        m = 1;
        localObject[0] = 1L;
        i4 = paramRandomAccessFile.read(arrayOfByte2);
        l1 = 0L;
        label286:
        if (i4 < 8) {
          break label792;
        }
        l1 = i4 + l1;
        int i6 = c.l(arrayOfByte2, 0);
        int i7 = c.l(arrayOfByte2, 4);
        i4 = 0;
        while (i4 < i6)
        {
          localObject = new g();
          ((g)localObject).ilM = i7;
          this.ilK.add(localObject);
          i2 += i7;
          i1 += 1;
          while ((i2 >= this.ilE) && (m < this.ilI.length))
          {
            i2 = (int)(i2 - this.ilE);
            this.ilI[m] = i1;
            m += 1;
          }
          i4 += 1;
        }
        if (l1 >= l2) {
          v.d("MicroMsg.StblAtom", "read stts Atom end");
        }
      }
    }
    label692:
    label792:
    for (;;)
    {
      if (m < this.ilI.length) {
        this.ilI[m] = i1;
      }
      l1 += 8L;
      break label93;
      i4 = paramRandomAccessFile.read(arrayOfByte2);
      break label286;
      if (i1 == a.ikR)
      {
        l1 = a(paramRandomAccessFile, i5);
        i2 = 1;
        i1 = m;
        k = i;
        i = j;
        j = k;
        k = i2;
        m = n;
        n = i1;
        break label108;
      }
      if (i1 == a.ikT)
      {
        l1 = b(paramRandomAccessFile, i5);
        i1 = 1;
        n = m;
        m = i;
        i = j;
        j = m;
        m = i1;
        break label108;
      }
      if (i1 == a.ikU)
      {
        l1 = c(paramRandomAccessFile, i5);
        i1 = 1;
        n = m;
        m = i;
        i = j;
        j = m;
        m = i1;
        break label108;
      }
      if (i1 == a.ikS)
      {
        l1 = d(paramRandomAccessFile, i5);
        i1 = m;
        m = 1;
        i = j;
        j = m;
        m = n;
        n = i1;
        break label108;
      }
      if (i1 == a.ikP)
      {
        l1 = e(paramRandomAccessFile, i5);
        i2 = 1;
        i1 = m;
        j = i;
        i = i2;
        m = n;
        n = i1;
        break label108;
        if ((n != 0) && (m != 0) && (k != 0) && (j != 0) && (i != 0))
        {
          v.i("MicroMsg.StblAtom", "read stbl atom finish");
          NH();
          GMTrace.o(16392816427008L, 122136);
          return;
        }
        i3 = paramRandomAccessFile.read(arrayOfByte1);
        i1 = j;
        i2 = m;
        m = n;
        j = i;
        i = i1;
        n = i2;
        break;
      }
      i1 = m;
      m = i;
      i = j;
      j = m;
      m = n;
      n = i1;
      break label108;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */