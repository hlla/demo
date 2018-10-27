package com.google.android.finsky.as;

public final class a
  implements j
{
  private final k a;
  
  public a(k paramk)
  {
    this.a = paramk;
  }
  
  public final boolean a(String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfString != null) {
      bool1 = bool2;
    }
    try
    {
      if (paramArrayOfString.length == 3)
      {
        int i = Integer.parseInt(paramArrayOfString[2]);
        bool1 = bool2;
        if (i > 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (NumberFormatException paramArrayOfString) {}
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/as/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */