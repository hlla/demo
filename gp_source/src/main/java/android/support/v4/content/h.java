package android.support.v4.content;

import android.content.Context;
import android.support.v4.g.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class h
{
  public boolean e = false;
  public boolean f = false;
  public Context g;
  public int h;
  public j i;
  public boolean j = false;
  public boolean k = true;
  public boolean l = false;
  
  public h(Context paramContext)
  {
    this.g = paramContext.getApplicationContext();
  }
  
  public void a() {}
  
  @Deprecated
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.h);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.i);
    if ((this.l) || (this.f) || (this.j))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.l);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.f);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.j);
    }
    if ((this.e) || (this.k))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.e);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.k);
    }
  }
  
  public void b(Object paramObject)
  {
    j localj = this.i;
    if (localj != null) {
      localj.b(paramObject);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public final void j()
  {
    a();
  }
  
  public final void k()
  {
    i();
    this.k = true;
    this.l = false;
    this.e = false;
    this.f = false;
    this.j = false;
  }
  
  public final boolean l()
  {
    boolean bool = this.f;
    this.f = false;
    this.j |= bool;
    return bool;
  }
  
  public void m()
  {
    if (!this.l)
    {
      this.f = true;
      return;
    }
    a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    f.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */