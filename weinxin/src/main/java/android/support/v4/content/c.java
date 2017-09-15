package android.support.v4.content;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class c<D>
{
  public int dX;
  Context mContext;
  public boolean ny = false;
  public b<D> ts;
  public a<D> tt;
  public boolean tu = false;
  public boolean tv = true;
  public boolean tw = false;
  public boolean tx = false;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public final void a(a<D> parama)
  {
    if (this.tt == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.tt != parama) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.tt = null;
  }
  
  public final void a(b<D> paramb)
  {
    if (this.ts == null) {
      throw new IllegalStateException("No listener register");
    }
    if (this.ts != paramb) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    this.ts = null;
  }
  
  public final void deliverResult(D paramD)
  {
    if (this.ts != null) {
      this.ts.b(this, paramD);
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.dX);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.ts);
    if ((this.ny) || (this.tw) || (this.tx))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.ny);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.tw);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.tx);
    }
    if ((this.tu) || (this.tv))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.tu);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.tv);
    }
  }
  
  public void onReset() {}
  
  public void onStartLoading() {}
  
  public void onStopLoading() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    android.support.v4.e.c.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.dX);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static abstract interface a<D> {}
  
  public static abstract interface b<D>
  {
    public abstract void b(c<D> paramc, D paramD);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/content/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */