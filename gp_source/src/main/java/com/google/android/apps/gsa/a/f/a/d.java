package com.google.android.apps.gsa.a.f.a;

final class d
  implements Runnable
{
  private final Runnable a;
  private final com.google.android.apps.gsa.a.d.a b;
  private final com.google.android.apps.gsa.a.d.d c;
  
  d(com.google.android.apps.gsa.a.d.a parama, Runnable paramRunnable, com.google.android.apps.gsa.a.d.d paramd)
  {
    this.b = parama;
    this.a = paramRunnable;
    this.c = paramd;
  }
  
  public final void run()
  {
    try
    {
      com.google.android.apps.gsa.a.d.a locala = this.b;
      a.a.set(locala);
      this.a.run();
      return;
    }
    finally
    {
      this.c.b(this);
      a.a.set(null);
    }
  }
  
  public final String toString()
  {
    String str = String.valueOf(this.a);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 14);
    localStringBuilder.append("ProducerTask{");
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/apps/gsa/a/f/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */