package com.google.android.finsky.ds.a;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;
import com.google.protobuf.nano.j;
import java.util.Arrays;

public final class hg
  extends b
{
  public int a = 0;
  public String b = "";
  public int c = 0;
  public hf d = null;
  public bu e = null;
  public String f = "";
  public he g = null;
  public he h = null;
  public byte[] i = j.b;
  public String j = "";
  private String k = "";
  
  public hg()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  private final hg b(a parama)
  {
    for (;;)
    {
      int m = parama.a();
      switch (m)
      {
      default: 
        if (super.a(parama, m)) {}
        break;
      case 0: 
        return this;
      case 82: 
        this.i = parama.d();
        this.a |= 0x20;
        break;
      case 74: 
        if (this.h == null) {
          this.h = new he();
        }
        parama.a(this.h);
        break;
      case 66: 
        if (this.g == null) {
          this.g = new he();
        }
        parama.a(this.g);
        break;
      case 58: 
        if (this.d == null) {
          this.d = new hf();
        }
        parama.a(this.d);
        break;
      case 50: 
        this.k = parama.c();
        this.a |= 0x10;
        break;
      case 42: 
        this.b = parama.c();
        this.a |= 0x8;
        break;
      case 34: 
        this.j = parama.c();
        this.a |= 0x4;
        break;
      case 26: 
        if (this.e == null) {
          this.e = new bu();
        }
        parama.a(this.e);
        break;
      case 16: 
        this.a |= 0x2;
        int n = parama.j();
        int i1;
        do
        {
          try
          {
            i1 = parama.e();
            if (i1 >= 0) {
              continue;
            }
            StringBuilder localStringBuilder = new StringBuilder(61);
            localStringBuilder.append(i1);
            localStringBuilder.append(" is not a valid enum NotificationCenterMessageIcon");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            parama.e(n);
            a(parama, m);
          }
          break;
        } while (i1 > 3);
        this.c = i1;
        this.a |= 0x2;
        break;
      case 10: 
        this.f = parama.c();
        this.a |= 0x1;
      }
    }
  }
  
  protected final int a()
  {
    int n = super.a();
    int m = n;
    if ((this.a & 0x1) != 0) {
      m = n + CodedOutputByteBufferNano.b(1, this.f);
    }
    n = m;
    if ((this.a & 0x2) != 0) {
      n = m + CodedOutputByteBufferNano.d(2, this.c);
    }
    Object localObject = this.e;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    n = m;
    if ((this.a & 0x4) != 0) {
      n = m + CodedOutputByteBufferNano.b(4, this.j);
    }
    m = n;
    if ((this.a & 0x8) != 0) {
      m = n + CodedOutputByteBufferNano.b(5, this.b);
    }
    n = m;
    if ((this.a & 0x10) != 0) {
      n = m + CodedOutputByteBufferNano.b(6, this.k);
    }
    localObject = this.d;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(7, (g)localObject);
    }
    localObject = this.g;
    n = m;
    if (localObject != null) {
      n = m + CodedOutputByteBufferNano.d(8, (g)localObject);
    }
    localObject = this.h;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.d(9, (g)localObject);
    }
    n = m;
    if ((this.a & 0x20) != 0) {
      n = m + CodedOutputByteBufferNano.b(10, this.i);
    }
    return n;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if ((this.a & 0x1) != 0) {
      paramCodedOutputByteBufferNano.a(1, this.f);
    }
    if ((this.a & 0x2) != 0) {
      paramCodedOutputByteBufferNano.a(2, this.c);
    }
    Object localObject = this.e;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    if ((this.a & 0x4) != 0) {
      paramCodedOutputByteBufferNano.a(4, this.j);
    }
    if ((this.a & 0x8) != 0) {
      paramCodedOutputByteBufferNano.a(5, this.b);
    }
    if ((this.a & 0x10) != 0) {
      paramCodedOutputByteBufferNano.a(6, this.k);
    }
    localObject = this.d;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(7, (g)localObject);
    }
    localObject = this.g;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(8, (g)localObject);
    }
    localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(9, (g)localObject);
    }
    if ((this.a & 0x20) != 0) {
      paramCodedOutputByteBufferNano.a(10, this.i);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof hg))
      {
        paramObject = (hg)paramObject;
        if (((this.a & 0x1) == (((hg)paramObject).a & 0x1)) && (this.f.equals(((hg)paramObject).f)) && ((this.a & 0x2) == (((hg)paramObject).a & 0x2)) && (this.c == ((hg)paramObject).c))
        {
          localObject = this.e;
          if (localObject != null) {
            break label345;
          }
          if (((hg)paramObject).e != null) {}
        }
      }
      label332:
      label345:
      while (((bu)localObject).equals(((hg)paramObject).e))
      {
        if (((this.a & 0x4) == (((hg)paramObject).a & 0x4)) && (this.j.equals(((hg)paramObject).j)) && ((this.a & 0x8) == (((hg)paramObject).a & 0x8)) && (this.b.equals(((hg)paramObject).b)) && ((this.a & 0x10) == (((hg)paramObject).a & 0x10)) && (this.k.equals(((hg)paramObject).k)))
        {
          localObject = this.d;
          if (localObject != null) {
            break label332;
          }
          if (((hg)paramObject).d != null) {}
        }
        while (((hf)localObject).equals(((hg)paramObject).d))
        {
          localObject = this.g;
          if (localObject == null) {
            if (((hg)paramObject).g != null) {}
          }
          while (((he)localObject).equals(((hg)paramObject).g))
          {
            localObject = this.h;
            if (localObject == null) {
              if (((hg)paramObject).h != null) {}
            }
            while (((he)localObject).equals(((hg)paramObject).h))
            {
              if (((this.a & 0x20) == (((hg)paramObject).a & 0x20)) && (Arrays.equals(this.i, ((hg)paramObject).i)))
              {
                localObject = this.unknownFieldData;
                if ((localObject == null) || (((d)localObject).a())) {
                  paramObject = ((hg)paramObject).unknownFieldData;
                }
              }
              else
              {
                return (paramObject == null) || (((d)paramObject).a());
              }
              return this.unknownFieldData.equals(((hg)paramObject).unknownFieldData);
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
    int i4 = 0;
    int i5 = getClass().getName().hashCode();
    int i6 = this.f.hashCode();
    int i7 = this.c;
    Object localObject = this.e;
    if (localObject != null) {}
    for (int m = ((bu)localObject).hashCode();; m = 0)
    {
      int i8 = this.j.hashCode();
      int i9 = this.b.hashCode();
      int i10 = this.k.hashCode();
      localObject = this.d;
      if (localObject != null) {}
      for (int n = ((hf)localObject).hashCode();; n = 0)
      {
        localObject = this.g;
        if (localObject != null) {}
        for (int i1 = ((he)localObject).hashCode();; i1 = 0)
        {
          localObject = this.h;
          if (localObject != null) {}
          for (int i2 = ((he)localObject).hashCode();; i2 = 0)
          {
            int i11 = Arrays.hashCode(this.i);
            localObject = this.unknownFieldData;
            int i3 = i4;
            if (localObject != null)
            {
              i3 = i4;
              if (!((d)localObject).a()) {
                i3 = this.unknownFieldData.hashCode();
              }
            }
            return ((i2 + (i1 + (n + ((((m + (((i5 + 527) * 31 + i6) * 31 + i7) * 31) * 31 + i8) * 31 + i9) * 31 + i10) * 31) * 31) * 31) * 31 + i11) * 31 + i3;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */