package android.support.v7.widget;

public final class fw
{
  public int a = 0;
  public long b;
  public int c;
  public int d;
  public boolean e = false;
  public boolean f = false;
  public int g = 0;
  public int h = 1;
  public int i = 0;
  public boolean j = false;
  public boolean k = false;
  public boolean l = false;
  public int m = -1;
  public boolean n = false;
  
  public final int a()
  {
    if (this.e) {
      return this.i - this.a;
    }
    return this.g;
  }
  
  final void a(int paramInt)
  {
    if ((this.h & paramInt) == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Layout state should be one of ");
      localStringBuilder.append(Integer.toBinaryString(paramInt));
      localStringBuilder.append(" but it is ");
      localStringBuilder.append(Integer.toBinaryString(this.h));
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("State{mTargetPosition=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", mData=");
    localStringBuilder.append(null);
    localStringBuilder.append(", mItemCount=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mIsMeasuring=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mPreviousLayoutItemCount=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mStructureChanged=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", mInPreLayout=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mRunSimpleAnimations=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", mRunPredictiveAnimations=");
    localStringBuilder.append(this.j);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/fw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */