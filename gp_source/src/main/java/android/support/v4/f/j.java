package android.support.v4.f;

abstract class j
  implements e
{
  private final i a;
  
  j(i parami)
  {
    this.a = parami;
  }
  
  protected abstract boolean a();
  
  public final boolean a(CharSequence paramCharSequence, int paramInt)
  {
    if ((paramCharSequence == null) || (paramInt < 0) || (paramCharSequence.length() - paramInt < 0)) {
      throw new IllegalArgumentException();
    }
    i locali = this.a;
    if (locali == null) {
      return a();
    }
    switch (locali.a(paramCharSequence, paramInt))
    {
    default: 
      return a();
    case 1: 
      return false;
    }
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/f/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */