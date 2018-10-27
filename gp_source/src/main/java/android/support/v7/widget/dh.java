package android.support.v7.widget;

public class dh
{
  public static final dh a = ;
  public final cx b;
  public final dd c;
  public final boolean d;
  public final float e;
  
  dh(boolean paramBoolean, int paramInt1, int paramInt2, cx paramcx, float paramFloat)
  {
    this(paramBoolean, new dd(paramInt1, paramInt1 + paramInt2), paramcx, paramFloat);
  }
  
  private dh(boolean paramBoolean, dd paramdd, cx paramcx, float paramFloat)
  {
    this.d = paramBoolean;
    this.c = paramdd;
    this.b = paramcx;
    this.e = paramFloat;
  }
  
  public final cx a(boolean paramBoolean)
  {
    if (this.b != GridLayout.d) {
      return this.b;
    }
    if (this.e == 0.0F)
    {
      if (!paramBoolean) {
        return GridLayout.a;
      }
      return GridLayout.c;
    }
    return GridLayout.b;
  }
  
  final dh a(dd paramdd)
  {
    return new dh(this.d, paramdd, this.b, this.e);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        break label59;
      }
      paramObject = (dh)paramObject;
      if (!this.b.equals(((dh)paramObject).b)) {}
    }
    else
    {
      return this.c.equals(((dh)paramObject).c);
    }
    return false;
    label59:
    return false;
  }
  
  public int hashCode()
  {
    return this.c.hashCode() * 31 + this.b.hashCode();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */