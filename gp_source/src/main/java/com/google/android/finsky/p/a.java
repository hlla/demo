package com.google.android.finsky.p;

import android.media.MediaPlayer;
import android.util.SparseIntArray;
import com.google.android.finsky.e.af;
import com.google.wireless.android.a.b.a.a.cf;

public final class a
{
  private final d a;
  private final SparseIntArray b;
  
  a(d paramd)
  {
    this.a = paramd;
    this.b = new SparseIntArray();
    this.b.put(5, 1);
    this.b.put(6, 3);
    this.b.put(8, 4);
    this.b.put(7, 5);
    this.b.put(9, 6);
  }
  
  public final void a(af paramaf, byte[] paramArrayOfByte)
  {
    int k = -1;
    com.google.android.finsky.e.d locald;
    Object localObject;
    int i;
    int j;
    if ((this.a != null) && (paramaf != null))
    {
      locald = new com.google.android.finsky.e.d(558);
      int m = this.b.get(this.a.b.a, 0);
      if (m != 0)
      {
        localObject = this.a.b;
        switch (((c)localObject).a)
        {
        default: 
          i = -1;
          localObject = this.a.b;
          j = k;
          switch (((c)localObject).a)
          {
          default: 
            j = k;
          case 3: 
            label172:
            if ((i > 0) && (j >= 0))
            {
              localObject = new cf();
              ((cf)localObject).e = m;
              ((cf)localObject).c |= 0x1;
              if (i >= 0)
              {
                ((cf)localObject).c |= 0x4;
                ((cf)localObject).a = i;
              }
              if (j >= 0) {
                break label304;
              }
            }
            break;
          }
          break;
        }
      }
    }
    for (;;)
    {
      ((cf)localObject).d = 1;
      ((cf)localObject).c |= 0x2;
      locald.a.h = ((cf)localObject);
      locald.a(paramArrayOfByte);
      paramaf.a(locald);
      return;
      i = ((c)localObject).b.getDuration();
      break;
      j = ((c)localObject).b.getCurrentPosition();
      break label172;
      label304:
      ((cf)localObject).c |= 0x8;
      ((cf)localObject).b = j;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/p/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */