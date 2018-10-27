package com.google.protobuf.nano;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class b
  extends g
{
  public d unknownFieldData;
  
  public int a()
  {
    int j = 0;
    if (this.unknownFieldData != null)
    {
      int i = 0;
      for (;;)
      {
        d locald = this.unknownFieldData;
        k = i;
        if (j >= locald.b) {
          break;
        }
        i += locald.a[j].a();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public final b a(c paramc, Object paramObject)
  {
    int i = paramc.c >>> 3;
    Object localObject = this.unknownFieldData;
    if (localObject == null) {
      this.unknownFieldData = new d();
    }
    for (localObject = null;; localObject = ((d)localObject).a(i))
    {
      if (localObject == null)
      {
        this.unknownFieldData.a(i, new e(paramc, paramObject));
        return this;
      }
      ((e)localObject).a(paramc, paramObject);
      return this;
    }
  }
  
  public void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.unknownFieldData != null)
    {
      int i = 0;
      for (;;)
      {
        d locald = this.unknownFieldData;
        if (i >= locald.b) {
          break;
        }
        locald.a[i].a(paramCodedOutputByteBufferNano);
        i += 1;
      }
    }
  }
  
  public final boolean a(a parama, int paramInt)
  {
    int i = parama.j();
    if (parama.b(paramInt))
    {
      int j = paramInt >>> 3;
      int k = parama.j() - i;
      if (k == 0) {}
      Object localObject1;
      for (parama = j.b;; parama = (a)localObject1)
      {
        Object localObject2 = new i(paramInt, parama);
        parama = this.unknownFieldData;
        if (parama == null) {
          this.unknownFieldData = new d();
        }
        for (parama = null;; parama = parama.a(j))
        {
          if (parama == null)
          {
            localObject1 = new e();
            this.unknownFieldData.a(j, (e)localObject1);
          }
          for (;;)
          {
            parama = ((e)localObject1).b;
            if (parama != null)
            {
              parama.add(localObject2);
              return true;
            }
            parama = ((e)localObject1).c;
            if ((parama instanceof g))
            {
              parama = ((i)localObject2).a;
              paramInt = parama.length;
              parama = a.a(parama, 0, paramInt);
              i = parama.e();
              if (i != paramInt - CodedOutputByteBufferNano.b(i)) {
                throw InvalidProtocolBufferNanoException.a();
              }
              parama = ((g)((e)localObject1).c).a(parama);
            }
            for (;;)
            {
              ((e)localObject1).a(((e)localObject1).a, parama);
              break;
              if ((parama instanceof g[]))
              {
                localObject2 = (g[])((e)localObject1).a.a(Collections.singletonList(localObject2));
                parama = (g[])((e)localObject1).c;
                paramInt = parama.length;
                i = localObject2.length;
                parama = (g[])Arrays.copyOf(parama, paramInt + i);
                System.arraycopy(localObject2, 0, parama, paramInt, i);
              }
              else
              {
                parama = ((e)localObject1).a.a(Collections.singletonList(localObject2));
              }
            }
            localObject1 = parama;
          }
        }
        localObject1 = new byte[k];
        int m = parama.b;
        System.arraycopy(parama.a, i + m, localObject1, 0, k);
      }
    }
    return false;
  }
  
  public final boolean a(c paramc)
  {
    boolean bool2 = false;
    d locald = this.unknownFieldData;
    boolean bool1 = bool2;
    if (locald != null)
    {
      bool1 = bool2;
      if (locald.a(paramc.c >>> 3) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public b ap_()
  {
    b localb = (b)super.aq_();
    f.a(this, localb);
    return localb;
  }
  
  public final Object b(c paramc)
  {
    Object localObject2 = null;
    Object localObject3 = this.unknownFieldData;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((d)localObject3).a(paramc.c >>> 3);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        if (((e)localObject3).c != null)
        {
          if (!((e)localObject3).a.equals(paramc)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
          }
        }
        else
        {
          ((e)localObject3).a = paramc;
          ((e)localObject3).c = paramc.a(((e)localObject3).b);
          ((e)localObject3).b = null;
        }
        localObject1 = ((e)localObject3).c;
      }
    }
    return localObject1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/protobuf/nano/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */