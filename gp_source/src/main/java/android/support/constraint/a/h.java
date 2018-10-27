package android.support.constraint.a;

public final class h
{
  public float a;
  public int b = -1;
  public int c = -1;
  public b[] d = new b[8];
  public int e = 0;
  public i f;
  public int g = 0;
  public float[] h = new float[6];
  
  public h(i parami)
  {
    this.f = parami;
  }
  
  public final void a()
  {
    this.f = i.c;
    this.g = 0;
    this.c = -1;
    this.b = -1;
    this.a = 0.0F;
    this.e = 0;
  }
  
  final void a(b paramb)
  {
    int k = 0;
    int i = 0;
    while (i < this.e)
    {
      int j = k;
      if (this.d[i] != paramb)
      {
        i += 1;
      }
      else
      {
        for (;;)
        {
          k = this.e;
          if (j >= k - i - 1) {
            break;
          }
          paramb = this.d;
          k = i + j;
          paramb[k] = paramb[(k + 1)];
          j += 1;
        }
        this.e = (k - 1);
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(null);
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */