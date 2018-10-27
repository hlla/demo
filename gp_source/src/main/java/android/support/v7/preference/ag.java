package android.support.v7.preference;

import android.text.TextUtils;

final class ag
{
  public String a;
  public int b;
  public int c;
  
  ag() {}
  
  ag(ag paramag)
  {
    this.b = paramag.b;
    this.c = paramag.c;
    this.a = paramag.a;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof ag))
    {
      paramObject = (ag)paramObject;
      bool1 = bool2;
      if (this.b == ((ag)paramObject).b)
      {
        bool1 = bool2;
        if (this.c == ((ag)paramObject).c)
        {
          bool1 = bool2;
          if (TextUtils.equals(this.a, ((ag)paramObject).a)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return ((this.b + 527) * 31 + this.c) * 31 + this.a.hashCode();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */