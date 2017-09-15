package android.support.v4.d;

import java.util.Locale;

public final class e
{
  public static final d vA = new e(b.vH, false);
  public static final d vB = new e(b.vH, true);
  public static final d vC = new e(a.vF, false);
  public static final d vD = f.vK;
  public static final d vy = new e(null, false);
  public static final d vz = new e(null, true);
  
  public static int M(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2;
    case 0: 
      return 1;
    }
    return 0;
  }
  
  public static int N(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2;
    case 0: 
    case 14: 
    case 15: 
      return 1;
    }
    return 0;
  }
  
  private static final class a
    implements e.c
  {
    public static final a vF = new a(true);
    public static final a vG = new a(false);
    private final boolean vE;
    
    private a(boolean paramBoolean)
    {
      this.vE = paramBoolean;
    }
    
    public final int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      int j = 1;
      int i = 0;
      paramInt1 = 0;
      for (;;)
      {
        if (i < paramInt2 + 0) {
          switch (e.M(Character.getDirectionality(paramCharSequence.charAt(i))))
          {
          default: 
            i += 1;
            break;
          case 0: 
            if (this.vE) {
              paramInt1 = 0;
            }
            break;
          }
        }
      }
      do
      {
        do
        {
          return paramInt1;
          paramInt1 = 1;
          break;
          paramInt1 = j;
        } while (!this.vE);
        paramInt1 = 1;
        break;
        if (paramInt1 == 0) {
          break label108;
        }
        paramInt1 = j;
      } while (this.vE);
      return 0;
      label108:
      return 2;
    }
  }
  
  private static final class b
    implements e.c
  {
    public static final b vH = new b();
    
    public final int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      paramInt1 = 0;
      int i = 2;
      while ((paramInt1 < paramInt2 + 0) && (i == 2))
      {
        i = e.N(Character.getDirectionality(paramCharSequence.charAt(paramInt1)));
        paramInt1 += 1;
      }
      return i;
    }
  }
  
  private static abstract interface c
  {
    public abstract int a(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  }
  
  private static abstract class d
    implements d
  {
    private final e.c vI;
    
    public d(e.c paramc)
    {
      this.vI = paramc;
    }
    
    public final boolean a(CharSequence paramCharSequence, int paramInt)
    {
      boolean bool = false;
      if ((paramCharSequence == null) || (paramInt < 0) || (paramCharSequence.length() - paramInt < 0)) {
        throw new IllegalArgumentException();
      }
      if (this.vI == null)
      {
        bool = by();
        return bool;
      }
      switch (this.vI.a(paramCharSequence, 0, paramInt))
      {
      case 1: 
      default: 
        return by();
      }
      return true;
    }
    
    protected abstract boolean by();
  }
  
  private static final class e
    extends e.d
  {
    private final boolean vJ;
    
    public e(e.c paramc, boolean paramBoolean)
    {
      super();
      this.vJ = paramBoolean;
    }
    
    protected final boolean by()
    {
      return this.vJ;
    }
  }
  
  private static final class f
    extends e.d
  {
    public static final f vK = new f();
    
    public f()
    {
      super();
    }
    
    protected final boolean by()
    {
      return f.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */