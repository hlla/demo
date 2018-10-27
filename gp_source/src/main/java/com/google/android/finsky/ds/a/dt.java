package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.bh;
import com.google.protobuf.cl;
import com.google.protobuf.cw;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.f;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import com.google.wireless.android.finsky.d.aj;
import com.google.wireless.android.finsky.d.ch;
import com.google.wireless.android.finsky.d.cm;
import com.google.wireless.android.finsky.d.co;

public final class dt
  extends b
{
  public boolean a = false;
  public int b = 1;
  private co[] c = new co[0];
  private com.google.n.b.a.a d = null;
  private int e = 0;
  private bs f = null;
  private ch g = null;
  private dv h = null;
  private boolean i = false;
  private aj[] j = new aj[0];
  private cm k = null;
  private int l = 1;
  private hp m = null;
  private du[] n = du.b();
  private long o = 0L;
  private dw p = null;
  
  public dt()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt <= 0) {}
    while (paramInt > 2)
    {
      if (paramInt < 6) {}
      while (paramInt > 18)
      {
        if ((paramInt >= 20) && (paramInt <= 25)) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder(55);
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" is not a valid enum AvailabilityRestriction");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return paramInt;
    }
    return paramInt;
  }
  
  private final dt b(com.google.protobuf.nano.a parama)
  {
    for (;;)
    {
      int i1 = parama.a();
      int i2;
      Object localObject1;
      Object localObject2;
      switch (i1)
      {
      default: 
        if (super.a(parama, i1)) {}
        break;
      case 0: 
        return this;
      case 210: 
        this.k = ((cm)parama.a((cw)cm.a.a(bh.d, null)));
        break;
      case 200: 
        this.o = parama.f();
        this.e |= 0x10;
        break;
      case 194: 
        if (this.f == null) {
          this.f = new bs();
        }
        parama.a(this.f);
        break;
      case 186: 
        this.g = ((ch)parama.a((cw)ch.a.a(bh.d, null)));
        break;
      case 168: 
        this.i = parama.b();
        this.e |= 0x8;
        break;
      case 154: 
        this.d = ((com.google.n.b.a.a)parama.a((cw)com.google.n.b.a.a.b.a(bh.d, null)));
        break;
      case 146: 
        i2 = j.a(parama, 146);
        localObject1 = this.c;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new co[i2 + i1];
          if (i1 != 0) {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
          }
          for (;;)
          {
            if (i1 < localObject2.length - 1)
            {
              localObject2[i1] = ((co)parama.a((cw)co.a.a(bh.d, null)));
              parama.a();
              i1 += 1;
            }
            else
            {
              localObject2[i1] = ((co)parama.a((cw)co.a.a(bh.d, null)));
              this.c = ((co[])localObject2);
              break;
            }
          }
        }
      case 138: 
        if (this.m == null) {
          this.m = new hp();
        }
        parama.a(this.m);
        break;
      case 130: 
        if (this.h == null) {
          this.h = new dv();
        }
        parama.a(this.h);
        break;
      case 114: 
        i2 = j.a(parama, 114);
        localObject1 = this.j;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new aj[i2 + i1];
          if (i1 != 0) {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
          }
          for (;;)
          {
            if (i1 < localObject2.length - 1)
            {
              localObject2[i1] = ((aj)parama.a((cw)aj.a.a(bh.d, null)));
              parama.a();
              i1 += 1;
            }
            else
            {
              localObject2[i1] = ((aj)parama.a((cw)aj.a.a(bh.d, null)));
              this.j = ((aj[])localObject2);
              break;
            }
          }
        }
      case 104: 
        this.a = parama.b();
        this.e |= 0x2;
        break;
      case 75: 
        i2 = j.a(parama, 75);
        localObject1 = this.n;
        if (localObject1 != null) {}
        for (i1 = localObject1.length;; i1 = 0)
        {
          localObject2 = new du[i2 + i1];
          i2 = i1;
          if (i1 != 0)
          {
            System.arraycopy(localObject1, 0, localObject2, 0, i1);
            i2 = i1;
          }
          while (i2 < localObject2.length - 1)
          {
            localObject2[i2] = new du();
            parama.a(localObject2[i2], 9);
            parama.a();
            i2 += 1;
          }
          localObject2[i2] = new du();
          parama.a(localObject2[i2], 9);
          this.n = ((du[])localObject2);
          break;
        }
      case 58: 
        if (this.p == null) {
          this.p = new dw();
        }
        parama.a(this.p);
        break;
      case 48: 
        this.e |= 0x4;
        i2 = parama.j();
        try
        {
          this.l = cb.a(parama.e());
          this.e |= 0x4;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          parama.e(i2);
          a(parama, i1);
        }
        break;
      case 40: 
        this.e |= 0x1;
        i2 = parama.j();
        try
        {
          this.b = a(parama.e());
          this.e |= 0x1;
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          parama.e(i2);
          a(parama, i1);
        }
      }
    }
  }
  
  protected final int a()
  {
    int i4 = 0;
    int i2 = super.a();
    int i1 = i2;
    if ((this.e & 0x1) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.d(5, this.b);
    }
    i2 = i1;
    if ((this.e & 0x4) != 0) {
      i2 = i1 + CodedOutputByteBufferNano.d(6, this.l);
    }
    Object localObject = this.p;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    localObject = this.n;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.n;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.c(9, (g)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if ((this.e & 0x2) != 0) {
      i1 = i2 + (CodedOutputByteBufferNano.d(104) + 1);
    }
    localObject = this.j;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = 0;
        for (;;)
        {
          localObject = this.j;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputStream.c(14, (cl)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    localObject = this.h;
    int i3 = i2;
    if (localObject != null) {
      i3 = i2 + CodedOutputByteBufferNano.d(16, (g)localObject);
    }
    localObject = this.m;
    i1 = i3;
    if (localObject != null) {
      i1 = i3 + CodedOutputByteBufferNano.d(17, (g)localObject);
    }
    localObject = this.c;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = i4;
        for (;;)
        {
          localObject = this.c;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputStream.c(18, (cl)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    localObject = this.d;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputStream.c(19, (cl)localObject);
    }
    i2 = i1;
    if ((this.e & 0x8) != 0) {
      i2 = i1 + (CodedOutputByteBufferNano.d(168) + 1);
    }
    localObject = this.g;
    i1 = i2;
    if (localObject != null) {
      i1 = i2 + CodedOutputStream.c(23, (cl)localObject);
    }
    localObject = this.f;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputByteBufferNano.d(24, (g)localObject);
    }
    i1 = i2;
    if ((this.e & 0x10) != 0) {
      i1 = i2 + CodedOutputByteBufferNano.f(25, this.o);
    }
    localObject = this.k;
    i2 = i1;
    if (localObject != null) {
      i2 = i1 + CodedOutputStream.c(26, (cl)localObject);
    }
    return i2;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i2 = 0;
    if ((this.e & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.b);
    }
    if ((this.e & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.l);
    }
    Object localObject = this.p;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    localObject = this.n;
    if ((localObject == null) || (localObject.length <= 0)) {}
    int i1;
    label290:
    do
    {
      if ((this.e & 0x2) != 0) {
        paramCodedOutputByteBufferNano.a(13, this.a);
      }
      localObject = this.j;
      if ((localObject == null) || (localObject.length <= 0)) {}
      do
      {
        localObject = this.h;
        if (localObject != null) {
          paramCodedOutputByteBufferNano.b(16, (g)localObject);
        }
        localObject = this.m;
        if (localObject != null) {
          paramCodedOutputByteBufferNano.b(17, (g)localObject);
        }
        localObject = this.c;
        if (localObject != null)
        {
          i1 = i2;
          if (localObject.length > 0) {
            break label290;
          }
        }
        do
        {
          localObject = this.d;
          if (localObject != null) {
            paramCodedOutputByteBufferNano.a(19, (cl)localObject);
          }
          if ((this.e & 0x8) != 0) {
            paramCodedOutputByteBufferNano.a(21, this.i);
          }
          localObject = this.g;
          if (localObject != null) {
            paramCodedOutputByteBufferNano.a(23, (cl)localObject);
          }
          localObject = this.f;
          if (localObject != null) {
            paramCodedOutputByteBufferNano.b(24, (g)localObject);
          }
          if ((this.e & 0x10) != 0) {
            paramCodedOutputByteBufferNano.b(25, this.o);
          }
          localObject = this.k;
          if (localObject != null) {
            paramCodedOutputByteBufferNano.a(26, (cl)localObject);
          }
          super.a(paramCodedOutputByteBufferNano);
          return;
          localObject = this.c;
        } while (i1 >= localObject.length);
        localObject = localObject[i1];
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          paramCodedOutputByteBufferNano.a(18, (cl)localObject);
        }
        i1 = 0;
        localObject = this.j;
      } while (i1 >= localObject.length);
      localObject = localObject[i1];
      if (localObject == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        paramCodedOutputByteBufferNano.a(14, (cl)localObject);
      }
      i1 = 0;
      localObject = this.n;
    } while (i1 >= localObject.length);
    localObject = localObject[i1];
    if (localObject == null) {}
    for (;;)
    {
      i1 += 1;
      break;
      paramCodedOutputByteBufferNano.a(9, (g)localObject);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof dt))
      {
        paramObject = (dt)paramObject;
        if (((this.e & 0x1) == (((dt)paramObject).e & 0x1)) && (this.b == ((dt)paramObject).b) && (f.a(this.c, ((dt)paramObject).c)) && ((this.e & 0x2) == (((dt)paramObject).e & 0x2)) && (this.a == ((dt)paramObject).a))
        {
          localObject = this.k;
          if (localObject != null) {
            break label432;
          }
          if (((dt)paramObject).k != null) {}
        }
      }
      label354:
      label380:
      label406:
      label419:
      label432:
      while (((bb)localObject).equals(((dt)paramObject).k))
      {
        if (((this.e & 0x4) == (((dt)paramObject).e & 0x4)) && (this.l == ((dt)paramObject).l))
        {
          localObject = this.m;
          if (localObject != null) {
            break label419;
          }
          if (((dt)paramObject).m != null) {}
        }
        while (((hp)localObject).equals(((dt)paramObject).m))
        {
          if (((this.e & 0x8) == (((dt)paramObject).e & 0x8)) && (this.i == ((dt)paramObject).i) && (f.a(this.j, ((dt)paramObject).j)))
          {
            localObject = this.g;
            if (localObject != null) {
              break label406;
            }
            if (((dt)paramObject).g != null) {}
          }
          while (((bb)localObject).equals(((dt)paramObject).g))
          {
            localObject = this.f;
            if (localObject == null) {
              if (((dt)paramObject).f != null) {}
            }
            while (((bs)localObject).equals(((dt)paramObject).f))
            {
              if (((this.e & 0x10) == (((dt)paramObject).e & 0x10)) && (this.o == ((dt)paramObject).o))
              {
                localObject = this.p;
                if (localObject != null) {
                  break label380;
                }
                if (((dt)paramObject).p != null) {}
              }
              while (((dw)localObject).equals(((dt)paramObject).p))
              {
                localObject = this.d;
                if (localObject == null) {
                  if (((dt)paramObject).d != null) {}
                }
                while (((bb)localObject).equals(((dt)paramObject).d))
                {
                  if (f.a(this.n, ((dt)paramObject).n))
                  {
                    localObject = this.h;
                    if (localObject != null) {
                      break label354;
                    }
                    if (((dt)paramObject).h != null) {}
                  }
                  while (((dv)localObject).equals(((dt)paramObject).h))
                  {
                    localObject = this.unknownFieldData;
                    if ((localObject == null) || (((d)localObject).a()))
                    {
                      paramObject = ((dt)paramObject).unknownFieldData;
                      return (paramObject == null) || (((d)paramObject).a());
                    }
                    return this.unknownFieldData.equals(((dt)paramObject).unknownFieldData);
                  }
                  return false;
                }
                return false;
              }
              return false;
            }
            return false;
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int i4 = 1237;
    int i11 = 0;
    int i12 = getClass().getName().hashCode();
    int i13 = this.b;
    int i14 = f.a(this.c);
    if (!this.a) {}
    for (int i1 = 1237;; i1 = 1231)
    {
      Object localObject = this.k;
      if (localObject != null) {}
      for (int i2 = ((bb)localObject).hashCode();; i2 = 0)
      {
        int i15 = this.l;
        localObject = this.m;
        if (localObject != null) {}
        for (int i3 = ((hp)localObject).hashCode();; i3 = 0)
        {
          if (!this.i) {}
          for (;;)
          {
            int i16 = f.a(this.j);
            localObject = this.g;
            if (localObject != null) {}
            for (int i5 = ((bb)localObject).hashCode();; i5 = 0)
            {
              localObject = this.f;
              if (localObject != null) {}
              for (int i6 = ((bs)localObject).hashCode();; i6 = 0)
              {
                long l1 = this.o;
                localObject = this.p;
                int i17 = (int)(l1 ^ l1 >>> 32);
                if (localObject != null) {}
                for (int i7 = ((dw)localObject).hashCode();; i7 = 0)
                {
                  localObject = this.d;
                  if (localObject != null) {}
                  for (int i8 = ((bb)localObject).hashCode();; i8 = 0)
                  {
                    int i18 = f.a(this.n);
                    localObject = this.h;
                    if (localObject != null) {}
                    for (int i9 = ((dv)localObject).hashCode();; i9 = 0)
                    {
                      localObject = this.unknownFieldData;
                      int i10 = i11;
                      if (localObject != null)
                      {
                        i10 = i11;
                        if (!((d)localObject).a()) {
                          i10 = this.unknownFieldData.hashCode();
                        }
                      }
                      return (i9 + ((i8 + (i7 + ((i6 + (i5 + (((i3 + ((i2 + (i1 + (((i12 + 527) * 31 + i13) * 31 + i14) * 31) * 31) * 31 + i15) * 31) * 31 + i4) * 31 + i16) * 31) * 31) * 31 + i17) * 31) * 31) * 31 + i18) * 31) * 31 + i10;
                    }
                  }
                }
              }
            }
            i4 = 1231;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */