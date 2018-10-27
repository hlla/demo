package android.support.v7.widget;

final class bf
{
  public long a = 0L;
  public bf b;
  
  private final void a()
  {
    if (this.b == null) {
      this.b = new bf();
    }
  }
  
  final void a(int paramInt)
  {
    bf localbf = this;
    while (paramInt >= 64)
    {
      localbf.a();
      localbf = localbf.b;
      paramInt -= 64;
    }
    localbf.a |= 1L << paramInt;
  }
  
  final void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    bf localbf = this;
    while (paramInt >= 64)
    {
      localbf.a();
      localbf = localbf.b;
      paramInt -= 64;
    }
    long l1 = localbf.a;
    if ((0x8000000000000000 & l1) != 0L) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      long l2 = (1L << paramInt) - 1L;
      long l3 = (l2 ^ 0xFFFFFFFFFFFFFFFF) & l1;
      localbf.a = (l1 & l2 | l3 + l3);
      if (bool) {
        localbf.a(paramInt);
      }
      for (;;)
      {
        if (paramBoolean) {}
        while (localbf.b != null)
        {
          localbf.a();
          localbf = localbf.b;
          paramInt = 0;
          bool = paramBoolean;
          break;
        }
        return;
        localbf.b(paramInt);
      }
    }
  }
  
  final void b(int paramInt)
  {
    bf localbf = this;
    for (;;)
    {
      if (paramInt < 64) {
        localbf.a &= (1L << paramInt ^ 0xFFFFFFFFFFFFFFFF);
      }
      do
      {
        return;
        localbf = localbf.b;
      } while (localbf == null);
      paramInt -= 64;
    }
  }
  
  final boolean c(int paramInt)
  {
    bf localbf = this;
    while (paramInt >= 64)
    {
      localbf.a();
      localbf = localbf.b;
      paramInt -= 64;
    }
    return (localbf.a & 1L << paramInt) != 0L;
  }
  
  final boolean d(int paramInt)
  {
    bf localbf1 = this;
    for (;;)
    {
      if (paramInt < 64)
      {
        long l1 = 1L << paramInt;
        long l2 = localbf1.a;
        if ((l2 & l1) != 0L) {}
        for (boolean bool = true;; bool = false)
        {
          localbf1.a = (l2 & (l1 ^ 0xFFFFFFFFFFFFFFFF));
          l1 -= 1L;
          l2 = localbf1.a;
          localbf1.a = (Long.rotateRight((l1 ^ 0xFFFFFFFFFFFFFFFF) & l2, 1) | l2 & l1);
          bf localbf2 = localbf1.b;
          if (localbf2 != null)
          {
            if (localbf2.c(0)) {
              localbf1.a(63);
            }
            localbf1.b.d(0);
          }
          return bool;
        }
      }
      localbf1.a();
      localbf1 = localbf1.b;
      paramInt -= 64;
    }
  }
  
  final int e(int paramInt)
  {
    bf localbf = this.b;
    if (localbf != null)
    {
      if (paramInt >= 64) {
        return localbf.e(paramInt - 64) + Long.bitCount(this.a);
      }
      return Long.bitCount(this.a & (1L << paramInt) - 1L);
    }
    if (paramInt < 64) {
      return Long.bitCount(this.a & (1L << paramInt) - 1L);
    }
    return Long.bitCount(this.a);
  }
  
  public final String toString()
  {
    if (this.b != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.toString());
      localStringBuilder.append("xx");
      localStringBuilder.append(Long.toBinaryString(this.a));
      return localStringBuilder.toString();
    }
    return Long.toBinaryString(this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */