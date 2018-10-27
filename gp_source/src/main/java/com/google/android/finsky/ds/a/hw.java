package com.google.android.finsky.ds.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.bb;
import com.google.protobuf.cl;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.d;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.dfe.q.u;

public final class hw
  extends b
{
  public static volatile hw[] _emptyArray;
  public u allKnownExperimentsResponse = null;
  public do experimentsResponse = null;
  public hu oBSOLETEPlusProfileResponse = null;
  public hz plusProfileResponse = null;
  public ki searchSuggestResponse = null;
  public ms userProfileResponse = null;
  
  public hw()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    Object localObject = this.oBSOLETEPlusProfileResponse;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(1, (g)localObject);
    }
    localObject = this.plusProfileResponse;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(2, (g)localObject);
    }
    localObject = this.experimentsResponse;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(3, (g)localObject);
    }
    localObject = this.allKnownExperimentsResponse;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputStream.c(4, (cl)localObject);
    }
    localObject = this.userProfileResponse;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.d(5, (g)localObject);
    }
    localObject = this.searchSuggestResponse;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.d(6, (g)localObject);
    }
    return j;
  }
  
  public final void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.oBSOLETEPlusProfileResponse;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(1, (g)localObject);
    }
    localObject = this.plusProfileResponse;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(2, (g)localObject);
    }
    localObject = this.experimentsResponse;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(3, (g)localObject);
    }
    localObject = this.allKnownExperimentsResponse;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.a(4, (cl)localObject);
    }
    localObject = this.userProfileResponse;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(5, (g)localObject);
    }
    localObject = this.searchSuggestResponse;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.b(6, (g)localObject);
    }
    super.a(paramCodedOutputByteBufferNano);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      Object localObject;
      if ((paramObject instanceof hw))
      {
        paramObject = (hw)paramObject;
        localObject = this.oBSOLETEPlusProfileResponse;
        if (localObject != null) {
          break label226;
        }
        if (((hw)paramObject).oBSOLETEPlusProfileResponse != null) {}
      }
      label226:
      while (((hu)localObject).equals(((hw)paramObject).oBSOLETEPlusProfileResponse))
      {
        localObject = this.plusProfileResponse;
        if (localObject == null) {
          if (((hw)paramObject).plusProfileResponse != null) {}
        }
        while (((hz)localObject).equals(((hw)paramObject).plusProfileResponse))
        {
          localObject = this.experimentsResponse;
          if (localObject == null) {
            if (((hw)paramObject).experimentsResponse != null) {}
          }
          while (((do)localObject).equals(((hw)paramObject).experimentsResponse))
          {
            localObject = this.allKnownExperimentsResponse;
            if (localObject == null) {
              if (((hw)paramObject).allKnownExperimentsResponse != null) {}
            }
            while (((bb)localObject).equals(((hw)paramObject).allKnownExperimentsResponse))
            {
              localObject = this.userProfileResponse;
              if (localObject == null) {
                if (((hw)paramObject).userProfileResponse != null) {}
              }
              while (((ms)localObject).equals(((hw)paramObject).userProfileResponse))
              {
                localObject = this.searchSuggestResponse;
                if (localObject == null) {
                  if (((hw)paramObject).searchSuggestResponse != null) {}
                }
                while (((ki)localObject).equals(((hw)paramObject).searchSuggestResponse))
                {
                  localObject = this.unknownFieldData;
                  if ((localObject == null) || (((d)localObject).a()))
                  {
                    paramObject = ((hw)paramObject).unknownFieldData;
                    return (paramObject == null) || (((d)paramObject).a());
                  }
                  return this.unknownFieldData.equals(((hw)paramObject).unknownFieldData);
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
    int i3 = 0;
    int i4 = getClass().getName().hashCode();
    Object localObject = this.oBSOLETEPlusProfileResponse;
    if (localObject != null) {}
    for (int i = ((hu)localObject).hashCode();; i = 0)
    {
      localObject = this.plusProfileResponse;
      if (localObject != null) {}
      for (int j = ((hz)localObject).hashCode();; j = 0)
      {
        localObject = this.experimentsResponse;
        if (localObject != null) {}
        for (int k = ((do)localObject).hashCode();; k = 0)
        {
          localObject = this.allKnownExperimentsResponse;
          if (localObject != null) {}
          for (int m = ((bb)localObject).hashCode();; m = 0)
          {
            localObject = this.userProfileResponse;
            if (localObject != null) {}
            for (int n = ((ms)localObject).hashCode();; n = 0)
            {
              localObject = this.searchSuggestResponse;
              if (localObject != null) {}
              for (int i1 = ((ki)localObject).hashCode();; i1 = 0)
              {
                localObject = this.unknownFieldData;
                int i2 = i3;
                if (localObject != null)
                {
                  i2 = i3;
                  if (!((d)localObject).a()) {
                    i2 = this.unknownFieldData.hashCode();
                  }
                }
                return (i1 + (n + (m + (k + (j + (i + (i4 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ds/a/hw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */