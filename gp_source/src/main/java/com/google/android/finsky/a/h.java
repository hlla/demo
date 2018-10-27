package com.google.android.finsky.a;

import e.a.a;

public final class h
{
  public final a a;
  public final a b;
  public final a c;
  public final a d;
  public final a e;
  public final a f;
  
  public h(a parama1, a parama2, a parama3, a parama4, a parama5, a parama6)
  {
    this.c = ((a)a(parama1, 1));
    this.a = ((a)a(parama2, 2));
    this.b = ((a)a(parama3, 3));
    this.f = ((a)a(parama4, 4));
    this.e = ((a)a(parama5, 5));
    this.d = ((a)a(parama6, 6));
  }
  
  public static Object a(Object paramObject, int paramInt)
  {
    if (paramObject == null)
    {
      paramObject = new StringBuilder(93);
      ((StringBuilder)paramObject).append("@AutoFactory method argument is null but is not marked @Nullable. Argument index: ");
      ((StringBuilder)paramObject).append(paramInt);
      throw new NullPointerException(((StringBuilder)paramObject).toString());
    }
    return paramObject;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */