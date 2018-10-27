package android.support.v7.widget;

final class bt
{
  public int a;
  public int b;
  public fz c;
  public fz d;
  public int e;
  public int f;
  
  private bt(fz paramfz1, fz paramfz2)
  {
    this.d = paramfz1;
    this.c = paramfz2;
  }
  
  bt(fz paramfz1, fz paramfz2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramfz1, paramfz2);
    this.a = paramInt1;
    this.b = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChangeInfo{oldHolder=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", newHolder=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", fromX=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", fromY=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", toX=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", toY=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */