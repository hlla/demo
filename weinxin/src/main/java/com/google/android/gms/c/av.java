package com.google.android.gms.c;

import java.util.Arrays;

public final class av
  extends ay<av>
{
  public a[] aBV = a.lj();
  
  public av()
  {
    this.aCy = null;
    this.aCJ = -1;
  }
  
  public final void a(ax paramax)
  {
    if ((this.aBV != null) && (this.aBV.length > 0))
    {
      int i = 0;
      while (i < this.aBV.length)
      {
        a locala = this.aBV[i];
        if (locala != null) {
          paramax.a(1, locala);
        }
        i += 1;
      }
    }
    super.a(paramax);
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
      } while (!(paramObject instanceof av));
      paramObject = (av)paramObject;
      bool1 = bool2;
    } while (!bc.equals(this.aBV, ((av)paramObject).aBV));
    return a((ay)paramObject);
  }
  
  public final int hashCode()
  {
    return (bc.hashCode(this.aBV) + 527) * 31 + lu();
  }
  
  protected final int kK()
  {
    int i = super.kK();
    int k = i;
    if (this.aBV != null)
    {
      k = i;
      if (this.aBV.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.aBV.length) {
            break;
          }
          a locala = this.aBV[j];
          k = i;
          if (locala != null) {
            k = i + ax.b(1, locala);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public static final class a
    extends ay<a>
  {
    private static volatile a[] aBW;
    public a aBX = null;
    public String name = "";
    
    public a()
    {
      this.aCy = null;
      this.aCJ = -1;
    }
    
    public static a[] lj()
    {
      if (aBW == null) {}
      synchronized (bc.aCI)
      {
        if (aBW == null) {
          aBW = new a[0];
        }
        return aBW;
      }
    }
    
    public final void a(ax paramax)
    {
      paramax.c(1, this.name);
      if (this.aBX != null) {
        paramax.a(2, this.aBX);
      }
      super.a(paramax);
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
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof a));
          paramObject = (a)paramObject;
          if (this.name != null) {
            break;
          }
          bool1 = bool2;
        } while (((a)paramObject).name != null);
        if (this.aBX != null) {
          break label79;
        }
        bool1 = bool2;
      } while (((a)paramObject).aBX != null);
      label79:
      while (this.aBX.equals(((a)paramObject).aBX))
      {
        return a((ay)paramObject);
        if (this.name.equals(((a)paramObject).name)) {
          break;
        }
        return false;
      }
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      int i;
      if (this.name == null)
      {
        i = 0;
        if (this.aBX != null) {
          break label48;
        }
      }
      for (;;)
      {
        return ((i + 527) * 31 + j) * 31 + lu();
        i = this.name.hashCode();
        break;
        label48:
        j = this.aBX.hashCode();
      }
    }
    
    protected final int kK()
    {
      int j = super.kK() + ax.d(1, this.name);
      int i = j;
      if (this.aBX != null) {
        i = j + ax.b(2, this.aBX);
      }
      return i;
    }
    
    public static final class a
      extends ay<a>
    {
      private static volatile a[] aBY;
      public a aBZ = null;
      public int type = 1;
      
      public a()
      {
        this.aCy = null;
        this.aCJ = -1;
      }
      
      public static a[] lk()
      {
        if (aBY == null) {}
        synchronized (bc.aCI)
        {
          if (aBY == null) {
            aBY = new a[0];
          }
          return aBY;
        }
      }
      
      public final void a(ax paramax)
      {
        paramax.ak(1, this.type);
        if (this.aBZ != null) {
          paramax.a(2, this.aBZ);
        }
        super.a(paramax);
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
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof a));
            paramObject = (a)paramObject;
            bool1 = bool2;
          } while (this.type != ((a)paramObject).type);
          if (this.aBZ != null) {
            break;
          }
          bool1 = bool2;
        } while (((a)paramObject).aBZ != null);
        while (this.aBZ.equals(((a)paramObject).aBZ)) {
          return a((ay)paramObject);
        }
        return false;
      }
      
      public final int hashCode()
      {
        int j = this.type;
        if (this.aBZ == null) {}
        for (int i = 0;; i = this.aBZ.hashCode()) {
          return (i + (j + 527) * 31) * 31 + lu();
        }
      }
      
      protected final int kK()
      {
        int j = super.kK() + ax.al(1, this.type);
        int i = j;
        if (this.aBZ != null) {
          i = j + ax.b(2, this.aBZ);
        }
        return i;
      }
      
      public static final class a
        extends ay<a>
      {
        public byte[] aCa = bh.aCS;
        public String aCb = "";
        public double aCc = 0.0D;
        public float aCd = 0.0F;
        public long aCe = 0L;
        public int aCf = 0;
        public int aCg = 0;
        public boolean aCh = false;
        public av.a[] aCi = av.a.lj();
        public av.a.a[] aCj = av.a.a.lk();
        public String[] aCk = bh.aCQ;
        public long[] aCl = bh.aCM;
        public float[] aCm = bh.aCN;
        public long aCn = 0L;
        
        public a()
        {
          this.aCy = null;
          this.aCJ = -1;
        }
        
        public final void a(ax paramax)
        {
          int j = 0;
          Object localObject;
          if (!Arrays.equals(this.aCa, bh.aCS))
          {
            localObject = this.aCa;
            paramax.am(1, 2);
            paramax.co(localObject.length);
            paramax.g((byte[])localObject);
          }
          if (!this.aCb.equals("")) {
            paramax.c(2, this.aCb);
          }
          if (Double.doubleToLongBits(this.aCc) != Double.doubleToLongBits(0.0D))
          {
            double d = this.aCc;
            paramax.am(3, 1);
            long l = Double.doubleToLongBits(d);
            paramax.cm((int)l & 0xFF);
            paramax.cm((int)(l >> 8) & 0xFF);
            paramax.cm((int)(l >> 16) & 0xFF);
            paramax.cm((int)(l >> 24) & 0xFF);
            paramax.cm((int)(l >> 32) & 0xFF);
            paramax.cm((int)(l >> 40) & 0xFF);
            paramax.cm((int)(l >> 48) & 0xFF);
            paramax.cm((int)(l >> 56) & 0xFF);
          }
          if (Float.floatToIntBits(this.aCd) != Float.floatToIntBits(0.0F)) {
            paramax.c(4, this.aCd);
          }
          if (this.aCe != 0L) {
            paramax.d(5, this.aCe);
          }
          if (this.aCf != 0) {
            paramax.ak(6, this.aCf);
          }
          int i;
          if (this.aCg != 0)
          {
            i = this.aCg;
            paramax.am(7, 0);
            paramax.co(ax.cq(i));
          }
          if (this.aCh) {
            paramax.q(8, this.aCh);
          }
          if ((this.aCi != null) && (this.aCi.length > 0))
          {
            i = 0;
            while (i < this.aCi.length)
            {
              localObject = this.aCi[i];
              if (localObject != null) {
                paramax.a(9, (be)localObject);
              }
              i += 1;
            }
          }
          if ((this.aCj != null) && (this.aCj.length > 0))
          {
            i = 0;
            while (i < this.aCj.length)
            {
              localObject = this.aCj[i];
              if (localObject != null) {
                paramax.a(10, (be)localObject);
              }
              i += 1;
            }
          }
          if ((this.aCk != null) && (this.aCk.length > 0))
          {
            i = 0;
            while (i < this.aCk.length)
            {
              localObject = this.aCk[i];
              if (localObject != null) {
                paramax.c(11, (String)localObject);
              }
              i += 1;
            }
          }
          if ((this.aCl != null) && (this.aCl.length > 0))
          {
            i = 0;
            while (i < this.aCl.length)
            {
              paramax.d(12, this.aCl[i]);
              i += 1;
            }
          }
          if (this.aCn != 0L) {
            paramax.d(13, this.aCn);
          }
          if ((this.aCm != null) && (this.aCm.length > 0))
          {
            i = j;
            while (i < this.aCm.length)
            {
              paramax.c(14, this.aCm[i]);
              i += 1;
            }
          }
          super.a(paramax);
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
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof a));
              paramObject = (a)paramObject;
              bool1 = bool2;
            } while (!Arrays.equals(this.aCa, ((a)paramObject).aCa));
            if (this.aCb != null) {
              break;
            }
            bool1 = bool2;
          } while (((a)paramObject).aCb != null);
          while (this.aCb.equals(((a)paramObject).aCb))
          {
            bool1 = bool2;
            if (Double.doubleToLongBits(this.aCc) != Double.doubleToLongBits(((a)paramObject).aCc)) {
              break;
            }
            bool1 = bool2;
            if (Float.floatToIntBits(this.aCd) != Float.floatToIntBits(((a)paramObject).aCd)) {
              break;
            }
            bool1 = bool2;
            if (this.aCe != ((a)paramObject).aCe) {
              break;
            }
            bool1 = bool2;
            if (this.aCf != ((a)paramObject).aCf) {
              break;
            }
            bool1 = bool2;
            if (this.aCg != ((a)paramObject).aCg) {
              break;
            }
            bool1 = bool2;
            if (this.aCh != ((a)paramObject).aCh) {
              break;
            }
            bool1 = bool2;
            if (!bc.equals(this.aCi, ((a)paramObject).aCi)) {
              break;
            }
            bool1 = bool2;
            if (!bc.equals(this.aCj, ((a)paramObject).aCj)) {
              break;
            }
            bool1 = bool2;
            if (!bc.equals(this.aCk, ((a)paramObject).aCk)) {
              break;
            }
            bool1 = bool2;
            if (!bc.equals(this.aCl, ((a)paramObject).aCl)) {
              break;
            }
            bool1 = bool2;
            if (!bc.equals(this.aCm, ((a)paramObject).aCm)) {
              break;
            }
            bool1 = bool2;
            if (this.aCn != ((a)paramObject).aCn) {
              break;
            }
            return a((ay)paramObject);
          }
          return false;
        }
        
        public final int hashCode()
        {
          int k = Arrays.hashCode(this.aCa);
          int i;
          int m;
          int n;
          int i1;
          int i2;
          int i3;
          if (this.aCb == null)
          {
            i = 0;
            long l = Double.doubleToLongBits(this.aCc);
            m = (int)(l ^ l >>> 32);
            n = Float.floatToIntBits(this.aCd);
            i1 = (int)(this.aCe ^ this.aCe >>> 32);
            i2 = this.aCf;
            i3 = this.aCg;
            if (!this.aCh) {
              break label221;
            }
          }
          label221:
          for (int j = 1231;; j = 1237)
          {
            return (((((((j + ((((((i + (k + 527) * 31) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + bc.hashCode(this.aCi)) * 31 + bc.hashCode(this.aCj)) * 31 + bc.hashCode(this.aCk)) * 31 + bc.hashCode(this.aCl)) * 31 + bc.hashCode(this.aCm)) * 31 + (int)(this.aCn ^ this.aCn >>> 32)) * 31 + lu();
            i = this.aCb.hashCode();
            break;
          }
        }
        
        protected final int kK()
        {
          int i2 = 0;
          int j = super.kK();
          int i = j;
          Object localObject;
          if (!Arrays.equals(this.aCa, bh.aCS))
          {
            localObject = this.aCa;
            i = ax.cn(1);
            k = ax.cp(localObject.length);
            i = j + (localObject.length + k + i);
          }
          j = i;
          if (!this.aCb.equals("")) {
            j = i + ax.d(2, this.aCb);
          }
          i = j;
          if (Double.doubleToLongBits(this.aCc) != Double.doubleToLongBits(0.0D)) {
            i = j + (ax.cn(3) + 8);
          }
          j = i;
          if (Float.floatToIntBits(this.aCd) != Float.floatToIntBits(0.0F)) {
            j = i + (ax.cn(4) + 4);
          }
          int k = j;
          if (this.aCe != 0L) {
            k = j + ax.e(5, this.aCe);
          }
          i = k;
          if (this.aCf != 0) {
            i = k + ax.al(6, this.aCf);
          }
          j = i;
          if (this.aCg != 0)
          {
            j = this.aCg;
            k = ax.cn(7);
            j = i + (ax.cp(ax.cq(j)) + k);
          }
          i = j;
          if (this.aCh) {
            i = j + (ax.cn(8) + 1);
          }
          j = i;
          if (this.aCi != null)
          {
            j = i;
            if (this.aCi.length > 0)
            {
              j = 0;
              while (j < this.aCi.length)
              {
                localObject = this.aCi[j];
                k = i;
                if (localObject != null) {
                  k = i + ax.b(9, (be)localObject);
                }
                j += 1;
                i = k;
              }
              j = i;
            }
          }
          i = j;
          if (this.aCj != null)
          {
            i = j;
            if (this.aCj.length > 0)
            {
              i = j;
              j = 0;
              while (j < this.aCj.length)
              {
                localObject = this.aCj[j];
                k = i;
                if (localObject != null) {
                  k = i + ax.b(10, (be)localObject);
                }
                j += 1;
                i = k;
              }
            }
          }
          j = i;
          if (this.aCk != null)
          {
            j = i;
            if (this.aCk.length > 0)
            {
              j = 0;
              k = 0;
              int n;
              for (int m = 0; j < this.aCk.length; m = n)
              {
                localObject = this.aCk[j];
                int i1 = k;
                n = m;
                if (localObject != null)
                {
                  n = m + 1;
                  i1 = k + ax.aj((String)localObject);
                }
                j += 1;
                k = i1;
              }
              j = i + k + m * 1;
            }
          }
          i = j;
          if (this.aCl != null)
          {
            i = j;
            if (this.aCl.length > 0)
            {
              k = 0;
              i = i2;
              while (i < this.aCl.length)
              {
                k += ax.k(this.aCl[i]);
                i += 1;
              }
              i = j + k + this.aCl.length * 1;
            }
          }
          j = i;
          if (this.aCn != 0L) {
            j = i + ax.e(13, this.aCn);
          }
          i = j;
          if (this.aCm != null)
          {
            i = j;
            if (this.aCm.length > 0) {
              i = j + this.aCm.length * 4 + this.aCm.length * 1;
            }
          }
          return i;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */