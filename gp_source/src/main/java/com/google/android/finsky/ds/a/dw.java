package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.bh;
import com.google.protobuf.cl;
import com.google.protobuf.cw;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import com.google.wireless.android.finsky.d.cm;
import com.google.wireless.android.finsky.d.cp;
import com.google.wireless.android.finsky.d.ct;
import com.google.wireless.android.finsky.d.cu;

public final class dw
  extends b
{
  private static volatile dw[] a;
  private Integer b;
  private int c = 0;
  private String d;
  private double[] e;
  private boolean f;
  private cm g;
  private Integer h;
  private long[] i;
  private boolean j = false;
  private cu k = cu.a;
  private int l;
  private String[] m;
  private long[] n;
  private dw[] o;
  
  public dw()
  {
    if (ct.a != null) {}
    for (Integer localInteger = Integer.valueOf(ct.a.b);; localInteger = null)
    {
      this.h = localInteger;
      this.m = j.h;
      this.n = j.g;
      this.i = j.g;
      this.e = j.d;
      this.o = d();
      this.l = 1;
      if (cp.a != null) {}
      for (localInteger = Integer.valueOf(cp.a.b);; localInteger = null)
      {
        this.b = localInteger;
        this.g = null;
        this.f = false;
        this.d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return;
      }
    }
  }
  
  private final dw b(a parama)
  {
    for (;;)
    {
      int i1 = parama.a();
      int i2;
      int i3;
      long[] arrayOfLong;
      Object localObject2;
      Object localObject1;
      switch (i1)
      {
      default: 
        if (super.a(parama, i1)) {}
        break;
      case 0: 
        return this;
      case 114: 
        this.g = ((cm)parama.a((cw)cm.a.a(bh.d, null)));
        break;
      case 104: 
        this.f = parama.b();
        this.c |= 0x10;
        break;
      case 96: 
        this.c |= 0x8;
        i2 = parama.j();
        i3 = parama.e();
        switch (i3)
        {
        default: 
          parama.e(i2);
          a(parama, i1);
          break;
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          this.b = Integer.valueOf(i3);
          this.c |= 0x8;
        }
        break;
      case 82: 
        i1 = parama.e();
        i3 = parama.c(i1);
        i2 = i1 / 8;
        arrayOfLong = this.n;
        if (arrayOfLong != null) {}
        for (i1 = arrayOfLong.length;; i1 = 0)
        {
          localObject2 = new long[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(arrayOfLong, 0, localObject2, 0, i1);
            i2 = i1;
          }
          for (;;)
          {
            if (i2 >= localObject2.length)
            {
              this.n = ((long[])localObject2);
              parama.d(i3);
              break;
            }
            localObject2[i2] = parama.h();
            i2 += 1;
          }
        }
      case 81: 
        i2 = j.a(parama, 81);
        arrayOfLong = this.n;
        if (arrayOfLong != null) {}
        for (i1 = arrayOfLong.length;; i1 = 0)
        {
          localObject2 = new long[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(arrayOfLong, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = parama.h();
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = parama.h();
          this.n = ((long[])localObject2);
          break;
        }
      case 74: 
        this.d = parama.c();
        this.c |= 0x20;
        break;
      case 64: 
        this.c |= 0x4;
        i2 = parama.j();
        try
        {
          this.l = dt.a(parama.e());
          this.c |= 0x4;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 58: 
        i2 = j.a(parama, 58);
        localObject1 = this.o;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new dw[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = new dw();
            parama.a(localObject2[i2]);
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = new dw();
          parama.a(localObject2[i2]);
          this.o = ((dw[])localObject2);
          break;
        }
      case 50: 
        i1 = parama.e();
        i3 = parama.c(i1);
        i2 = i1 / 8;
        localObject1 = this.e;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new double[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
            i2 = i1;
          }
          for (;;)
          {
            if (i2 >= localObject2.length)
            {
              this.e = ((double[])localObject2);
              parama.d(i3);
              break;
            }
            localObject2[i2] = Double.longBitsToDouble(parama.h());
            i2 += 1;
          }
        }
      case 49: 
        i2 = j.a(parama, 49);
        localObject1 = this.e;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new double[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = Double.longBitsToDouble(parama.h());
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = Double.longBitsToDouble(parama.h());
          this.e = ((double[])localObject2);
          break;
        }
      case 42: 
        i3 = parama.c(parama.e());
        i1 = parama.j();
        i2 = 0;
        for (;;)
        {
          if (parama.i() <= 0)
          {
            parama.e(i1);
            localObject1 = this.i;
            if (localObject1 != null) {}
            for (i1 = localObject1.length;; i1 = 0)
            {
              localObject2 = new long[i2 + i1];
              i2 = i1;
              if (i1 != 0)
              {
                System.arraycopy(localObject1, 0, localObject2, 0, i1);
                i2 = i1;
              }
              for (;;)
              {
                if (i2 >= localObject2.length)
                {
                  this.i = ((long[])localObject2);
                  parama.d(i3);
                  break;
                }
                localObject2[i2] = parama.f();
                i2 += 1;
              }
            }
          }
          parama.f();
          i2 += 1;
        }
      case 40: 
        i2 = j.a(parama, 40);
        localObject1 = this.i;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new long[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = parama.f();
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = parama.f();
          this.i = ((long[])localObject2);
          break;
        }
      case 34: 
        i2 = j.a(parama, 34);
        localObject1 = this.m;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new String[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = parama.c();
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = parama.c();
          this.m = ((String[])localObject2);
          break;
        }
      case 24: 
        this.c |= 0x2;
        i2 = parama.j();
        i3 = parama.e();
        switch (i3)
        {
        case 2: 
        case 24: 
        default: 
          parama.e(i2);
          a(parama, i1);
          break;
        case 1: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        case 21: 
        case 22: 
        case 23: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 30: 
        case 31: 
        case 32: 
        case 33: 
        case 34: 
        case 35: 
        case 36: 
        case 37: 
        case 38: 
        case 39: 
        case 40: 
        case 41: 
        case 42: 
        case 43: 
        case 44: 
        case 45: 
        case 46: 
        case 47: 
        case 48: 
          this.h = Integer.valueOf(i3);
          this.c |= 0x2;
        }
        break;
      case 16: 
        i2 = parama.j();
        i3 = parama.e();
        switch (i3)
        {
        default: 
          parama.e(i2);
          a(parama, i1);
          break;
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        case 21: 
        case 22: 
          this.k = cu.a(i3);
        }
        break;
      case 8: 
        this.j = parama.b();
        this.c |= 0x1;
      }
    }
  }
  
  private static dw[] d()
  {
    if (a == null) {}
    synchronized (f.a)
    {
      if (a == null) {
        a = new dw[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int i7 = 0;
    int i1 = super.a();
    int i2 = i1;
    if ((this.c & 0x1) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(8) + 1);
    }
    Object localObject = this.k;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(2, ((cu)localObject).b);
    }
    if ((this.c & 0x2) != 0)
    {
      localObject = this.h;
      if (localObject != null) {
        i1 += CodedOutputByteBufferNano.d(3, ((Integer)localObject).intValue());
      }
    }
    for (;;)
    {
      localObject = this.m;
      int i3;
      int i4;
      if (localObject != null) {
        if (localObject.length > 0)
        {
          i2 = 0;
          i3 = 0;
          i4 = 0;
          localObject = this.m;
          if (i2 >= localObject.length) {
            i1 = i1 + i3 + i4;
          }
        }
      }
      for (;;)
      {
        localObject = this.i;
        i2 = i1;
        if (localObject != null)
        {
          i2 = i1;
          if (localObject.length > 0)
          {
            i2 = 0;
            i3 = 0;
            for (;;)
            {
              localObject = this.i;
              i4 = localObject.length;
              if (i2 >= i4) {
                break;
              }
              i3 += CodedOutputByteBufferNano.b(localObject[i2]);
              i2 += 1;
            }
            i2 = i1 + i3 + i4;
          }
        }
        localObject = this.e;
        if (localObject != null)
        {
          i1 = localObject.length;
          if (i1 > 0) {
            i1 = i1 * 8 + i2 + i1;
          }
        }
        for (;;)
        {
          localObject = this.o;
          i2 = i1;
          if (localObject != null)
          {
            i2 = i1;
            if (localObject.length > 0)
            {
              i3 = i7;
              for (;;)
              {
                localObject = this.o;
                i2 = i1;
                if (i3 >= localObject.length) {
                  break;
                }
                localObject = localObject[i3];
                i2 = i1;
                if (localObject != null) {
                  i2 = i1 + CodedOutputByteBufferNano.d(7, (g)localObject);
                }
                i3 += 1;
                i1 = i2;
              }
            }
          }
          i3 = i2;
          if ((this.c & 0x4) != 0) {
            i3 = i2 + CodedOutputByteBufferNano.d(8, this.l);
          }
          i1 = i3;
          if ((this.c & 0x20) != 0) {
            i1 = i3 + CodedOutputByteBufferNano.b(9, this.d);
          }
          localObject = this.n;
          i2 = i1;
          if (localObject != null)
          {
            i3 = localObject.length;
            i2 = i1;
            if (i3 > 0) {
              i2 = i1 + i3 * 8 + i3;
            }
          }
          i1 = i2;
          if ((this.c & 0x8) != 0)
          {
            localObject = this.b;
            i1 = i2;
            if (localObject != null) {
              i1 = i2 + CodedOutputByteBufferNano.d(12, ((Integer)localObject).intValue());
            }
          }
          i2 = i1;
          if ((this.c & 0x10) != 0) {
            i2 = i1 + (CodedOutputByteBufferNano.d(104) + 1);
          }
          localObject = this.g;
          i1 = i2;
          if (localObject != null) {
            i1 = i2 + CodedOutputStream.c(14, (cl)localObject);
          }
          return i1;
          i1 = i2;
          continue;
          i1 = i2;
        }
        localObject = localObject[i2];
        int i6 = i3;
        int i5 = i4;
        if (localObject != null)
        {
          i5 = i4 + 1;
          i6 = i3 + CodedOutputByteBufferNano.a((String)localObject);
        }
        i2 += 1;
        i3 = i6;
        i4 = i5;
        break;
      }
    }
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i2 = 0;
    if ((this.c & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.j);
    }
    Object localObject = this.k;
    if (localObject == null) {}
    for (;;)
    {
      if ((this.c & 0x2) != 0)
      {
        localObject = this.h;
        if (localObject != null) {
          paramCodedOutputByteBufferNano.a(3, ((Integer)localObject).intValue());
        }
      }
      localObject = this.m;
      if ((localObject == null) || (localObject.length <= 0)) {}
      int i1;
      do
      {
        localObject = this.i;
        if ((localObject == null) || (localObject.length <= 0))
        {
          localObject = this.e;
          if ((localObject == null) || (localObject.length <= 0))
          {
            localObject = this.o;
            if ((localObject == null) || (localObject.length <= 0)) {}
            do
            {
              if ((this.c & 0x4) != 0) {
                paramCodedOutputByteBufferNano.a(8, this.l);
              }
              if ((this.c & 0x20) != 0) {
                paramCodedOutputByteBufferNano.a(9, this.d);
              }
              localObject = this.n;
              if (localObject != null)
              {
                i1 = i2;
                if (localObject.length > 0) {}
              }
              else
              {
                if ((this.c & 0x8) != 0)
                {
                  localObject = this.b;
                  if (localObject != null) {
                    paramCodedOutputByteBufferNano.a(12, ((Integer)localObject).intValue());
                  }
                }
                if ((this.c & 0x10) != 0) {
                  paramCodedOutputByteBufferNano.a(13, this.f);
                }
                localObject = this.g;
                if (localObject != null) {
                  paramCodedOutputByteBufferNano.a(14, (cl)localObject);
                }
                super.a(paramCodedOutputByteBufferNano);
                return;
              }
              for (;;)
              {
                localObject = this.n;
                if (i1 >= localObject.length) {
                  break;
                }
                paramCodedOutputByteBufferNano.c(10, localObject[i1]);
                i1 += 1;
              }
              i1 = 0;
              localObject = this.o;
            } while (i1 >= localObject.length);
            localObject = localObject[i1];
            if (localObject == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              paramCodedOutputByteBufferNano.b(7, (g)localObject);
            }
          }
          i1 = 0;
          for (;;)
          {
            localObject = this.e;
            if (i1 >= localObject.length) {
              break;
            }
            paramCodedOutputByteBufferNano.a(6, localObject[i1]);
            i1 += 1;
          }
        }
        i1 = 0;
        for (;;)
        {
          localObject = this.i;
          if (i1 >= localObject.length) {
            break;
          }
          paramCodedOutputByteBufferNano.b(5, localObject[i1]);
          i1 += 1;
        }
        i1 = 0;
        localObject = this.m;
      } while (i1 >= localObject.length);
      localObject = localObject[i1];
      if (localObject == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        paramCodedOutputByteBufferNano.a(4, (String)localObject);
      }
      paramCodedOutputByteBufferNano.a(2, ((cu)localObject).b);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      int i1;
      int i2;
      Object localObject;
      if ((paramObject instanceof dw))
      {
        paramObject = (dw)paramObject;
        i1 = this.c;
        i2 = ((dw)paramObject).c;
        if (((i1 & 0x1) == (i2 & 0x1)) && (this.j == ((dw)paramObject).j) && (this.k == ((dw)paramObject).k) && ((i1 & 0x2) == (i2 & 0x2)) && (this.h == ((dw)paramObject).h) && (f.a(this.m, ((dw)paramObject).m)) && (f.a(this.n, ((dw)paramObject).n)) && (f.a(this.i, ((dw)paramObject).i)) && (f.a(this.e, ((dw)paramObject).e)) && (f.a(this.o, ((dw)paramObject).o)))
        {
          i1 = this.c;
          i2 = ((dw)paramObject).c;
          if (((i1 & 0x4) == (i2 & 0x4)) && (this.l == ((dw)paramObject).l) && ((i1 & 0x8) == (i2 & 0x8)) && (this.b == ((dw)paramObject).b))
          {
            localObject = this.g;
            if (localObject != null) {
              break label326;
            }
            if (((dw)paramObject).g != null) {}
          }
        }
      }
      label326:
      while (((bb)localObject).equals(((dw)paramObject).g))
      {
        i1 = this.c;
        i2 = ((dw)paramObject).c;
        if (((i1 & 0x10) == (i2 & 0x10)) && (this.f == ((dw)paramObject).f) && ((i1 & 0x20) == (i2 & 0x20)) && (this.d.equals(((dw)paramObject).d)))
        {
          localObject = this.unknownFieldData;
          if ((localObject == null) || (((d)localObject).a())) {
            paramObject = ((dw)paramObject).unknownFieldData;
          }
        }
        else
        {
          return (paramObject == null) || (((d)paramObject).a());
        }
        return this.unknownFieldData.equals(((dw)paramObject).unknownFieldData);
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i3 = 1237;
    int i5 = 0;
    int i4 = getClass().getName().hashCode();
    if (!this.j) {}
    for (int i1 = 1237;; i1 = 1231)
    {
      Object localObject = this.k;
      if (localObject != null) {}
      for (int i2 = ((cu)localObject).hashCode();; i2 = 0)
      {
        i2 += (i1 + (i4 + 527) * 31) * 31;
        localObject = this.h;
        i1 = i2;
        if (localObject != null) {
          i1 = i2 * 31 + ((Integer)localObject).intValue();
        }
        i2 = (((((i1 * 31 + f.a(this.m)) * 31 + f.a(this.n)) * 31 + f.a(this.i)) * 31 + f.a(this.e)) * 31 + f.a(this.o)) * 31 + this.l;
        localObject = this.b;
        i1 = i2;
        if (localObject != null) {
          i1 = i2 * 31 + ((Integer)localObject).intValue();
        }
        localObject = this.g;
        if (localObject != null) {}
        for (i2 = ((bb)localObject).hashCode();; i2 = 0)
        {
          if (!this.f) {}
          for (;;)
          {
            int i6 = this.d.hashCode();
            localObject = this.unknownFieldData;
            i4 = i5;
            if (localObject != null)
            {
              i4 = i5;
              if (!((d)localObject).a()) {
                i4 = this.unknownFieldData.hashCode();
              }
            }
            return (((i2 + i1 * 31) * 31 + i3) * 31 + i6) * 31 + i4;
            i3 = 1231;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */