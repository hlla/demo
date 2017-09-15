package com.google.android.gms.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class bb
  implements Cloneable
{
  private az<?, ?> aCF;
  private Object aCG;
  List<bg> aCH = new ArrayList();
  
  private byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[kK()];
    a(ax.b(arrayOfByte, 0, arrayOfByte.length));
    return arrayOfByte;
  }
  
  final void a(ax paramax)
  {
    if (this.aCG != null) {
      this.aCF.a(this.aCG, paramax);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.aCH.iterator();
      while (localIterator.hasNext())
      {
        bg localbg = (bg)localIterator.next();
        paramax.co(localbg.tag);
        paramax.g(localbg.aCK);
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof bb));
      paramObject = (bb)paramObject;
      if ((this.aCG == null) || (((bb)paramObject).aCG == null)) {
        break;
      }
      bool1 = bool2;
    } while (this.aCF != ((bb)paramObject).aCF);
    if (!this.aCF.aCz.isArray()) {
      return this.aCG.equals(((bb)paramObject).aCG);
    }
    if ((this.aCG instanceof byte[])) {
      return Arrays.equals((byte[])this.aCG, (byte[])((bb)paramObject).aCG);
    }
    if ((this.aCG instanceof int[])) {
      return Arrays.equals((int[])this.aCG, (int[])((bb)paramObject).aCG);
    }
    if ((this.aCG instanceof long[])) {
      return Arrays.equals((long[])this.aCG, (long[])((bb)paramObject).aCG);
    }
    if ((this.aCG instanceof float[])) {
      return Arrays.equals((float[])this.aCG, (float[])((bb)paramObject).aCG);
    }
    if ((this.aCG instanceof double[])) {
      return Arrays.equals((double[])this.aCG, (double[])((bb)paramObject).aCG);
    }
    if ((this.aCG instanceof boolean[])) {
      return Arrays.equals((boolean[])this.aCG, (boolean[])((bb)paramObject).aCG);
    }
    return Arrays.deepEquals((Object[])this.aCG, (Object[])((bb)paramObject).aCG);
    if ((this.aCH != null) && (((bb)paramObject).aCH != null)) {
      return this.aCH.equals(((bb)paramObject).aCH);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), ((bb)paramObject).toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public final int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  final int kK()
  {
    int j;
    if (this.aCG != null)
    {
      j = this.aCF.ad(this.aCG);
      return j;
    }
    Iterator localIterator = this.aCH.iterator();
    bg localbg;
    for (int i = 0;; i = localbg.aCK.length + (j + 0) + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      localbg = (bg)localIterator.next();
      j = ax.cp(localbg.tag);
    }
  }
  
  public final bb ly()
  {
    int i = 0;
    bb localbb = new bb();
    try
    {
      localbb.aCF = this.aCF;
      if (this.aCH == null) {
        localbb.aCH = null;
      }
      for (;;)
      {
        if (this.aCG == null) {
          return localbb;
        }
        if (!(this.aCG instanceof be)) {
          break;
        }
        localbb.aCG = ((be)this.aCG).lw();
        return localbb;
        localbb.aCH.addAll(this.aCH);
      }
      if (!(this.aCG instanceof byte[])) {
        break label119;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    localCloneNotSupportedException.aCG = ((byte[])this.aCG).clone();
    return localCloneNotSupportedException;
    label119:
    Object localObject1;
    Object localObject2;
    if ((this.aCG instanceof byte[][]))
    {
      localObject1 = (byte[][])this.aCG;
      localObject2 = new byte[localObject1.length][];
      localCloneNotSupportedException.aCG = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((this.aCG instanceof boolean[]))
    {
      localCloneNotSupportedException.aCG = ((boolean[])this.aCG).clone();
      return localCloneNotSupportedException;
    }
    if ((this.aCG instanceof int[]))
    {
      localCloneNotSupportedException.aCG = ((int[])this.aCG).clone();
      return localCloneNotSupportedException;
    }
    if ((this.aCG instanceof long[]))
    {
      localCloneNotSupportedException.aCG = ((long[])this.aCG).clone();
      return localCloneNotSupportedException;
    }
    if ((this.aCG instanceof float[]))
    {
      localCloneNotSupportedException.aCG = ((float[])this.aCG).clone();
      return localCloneNotSupportedException;
    }
    if ((this.aCG instanceof double[]))
    {
      localCloneNotSupportedException.aCG = ((double[])this.aCG).clone();
      return localCloneNotSupportedException;
    }
    if ((this.aCG instanceof be[]))
    {
      localObject1 = (be[])this.aCG;
      localObject2 = new be[localObject1.length];
      localCloneNotSupportedException.aCG = localObject2;
      while (i < localObject1.length)
      {
        localObject2[i] = localObject1[i].lw();
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */