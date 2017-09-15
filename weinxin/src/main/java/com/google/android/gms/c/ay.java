package com.google.android.gms.c;

import java.util.List;

public abstract class ay<M extends ay<M>>
  extends be
{
  protected ba aCy;
  
  private M lv()
  {
    ay localay = (ay)lw();
    bc.a(this, localay);
    return localay;
  }
  
  public void a(ax paramax)
  {
    if (this.aCy == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.aCy.size())
      {
        this.aCy.cr(i).a(paramax);
        i += 1;
      }
    }
  }
  
  protected final boolean a(aw paramaw, int paramInt)
  {
    int i = paramaw.getPosition();
    if (!paramaw.cf(paramInt)) {
      return false;
    }
    int j = bh.cu(paramInt);
    int k = paramaw.getPosition() - i;
    bg localbg;
    label69:
    Object localObject;
    if (k == 0)
    {
      paramaw = bh.aCS;
      localbg = new bg(paramInt, paramaw);
      if (this.aCy != null) {
        break label162;
      }
      this.aCy = new ba();
      paramaw = null;
      localObject = paramaw;
      if (paramaw == null)
      {
        paramaw = new bb();
        localObject = this.aCy;
        paramInt = ((ba)localObject).cs(j);
        if (paramInt < 0) {
          break label205;
        }
        ((ba)localObject).aCE[paramInt] = paramaw;
        localObject = paramaw;
      }
    }
    for (;;)
    {
      ((bb)localObject).aCH.add(localbg);
      return true;
      localObject = new byte[k];
      int m = paramaw.aCo;
      System.arraycopy(paramaw.buffer, i + m, localObject, 0, k);
      paramaw = (aw)localObject;
      break;
      label162:
      paramaw = this.aCy;
      paramInt = paramaw.cs(j);
      if ((paramInt < 0) || (paramaw.aCE[paramInt] == ba.aCB))
      {
        paramaw = null;
        break label69;
      }
      paramaw = paramaw.aCE[paramInt];
      break label69;
      label205:
      i = paramInt ^ 0xFFFFFFFF;
      if ((i < ((ba)localObject).hP) && (localObject.aCE[i] == ba.aCB))
      {
        ((ba)localObject).aCD[i] = j;
        ((ba)localObject).aCE[i] = paramaw;
        localObject = paramaw;
      }
      else
      {
        paramInt = i;
        if (((ba)localObject).aCC)
        {
          paramInt = i;
          if (((ba)localObject).hP >= ((ba)localObject).aCD.length)
          {
            ((ba)localObject).gc();
            paramInt = ((ba)localObject).cs(j) ^ 0xFFFFFFFF;
          }
        }
        if (((ba)localObject).hP >= ((ba)localObject).aCD.length)
        {
          i = ba.P(((ba)localObject).hP + 1);
          int[] arrayOfInt = new int[i];
          bb[] arrayOfbb = new bb[i];
          System.arraycopy(((ba)localObject).aCD, 0, arrayOfInt, 0, ((ba)localObject).aCD.length);
          System.arraycopy(((ba)localObject).aCE, 0, arrayOfbb, 0, ((ba)localObject).aCE.length);
          ((ba)localObject).aCD = arrayOfInt;
          ((ba)localObject).aCE = arrayOfbb;
        }
        if (((ba)localObject).hP - paramInt != 0)
        {
          System.arraycopy(((ba)localObject).aCD, paramInt, ((ba)localObject).aCD, paramInt + 1, ((ba)localObject).hP - paramInt);
          System.arraycopy(((ba)localObject).aCE, paramInt, ((ba)localObject).aCE, paramInt + 1, ((ba)localObject).hP - paramInt);
        }
        ((ba)localObject).aCD[paramInt] = j;
        ((ba)localObject).aCE[paramInt] = paramaw;
        ((ba)localObject).hP += 1;
        localObject = paramaw;
      }
    }
  }
  
  protected final boolean a(M paramM)
  {
    if ((this.aCy == null) || (this.aCy.isEmpty())) {
      return (paramM.aCy == null) || (paramM.aCy.isEmpty());
    }
    return this.aCy.equals(paramM.aCy);
  }
  
  protected int kK()
  {
    int j = 0;
    if (this.aCy != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= this.aCy.size()) {
          break;
        }
        i += this.aCy.cr(j).kK();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  protected final int lu()
  {
    if ((this.aCy == null) || (this.aCy.isEmpty())) {
      return 0;
    }
    return this.aCy.hashCode();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */