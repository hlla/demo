package android.support.v4.f;

final class h
  implements i
{
  public static final h a = new h();
  
  public final int a(CharSequence paramCharSequence, int paramInt)
  {
    int i = 0;
    int j = 2;
    while ((i < paramInt) && (j == 2))
    {
      j = f.b(Character.getDirectionality(paramCharSequence.charAt(i)));
      i += 1;
    }
    return j;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */