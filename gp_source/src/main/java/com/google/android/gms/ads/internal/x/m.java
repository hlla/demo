package com.google.android.gms.ads.internal.x;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.a.aa;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.v.f;
import java.util.concurrent.Executor;

@a
public class m
  extends j
  implements p
{
  private boolean a;
  private boolean b;
  private final k c;
  
  public m(Context paramContext, k paramk)
  {
    super(paramContext);
    bt.A.i.d();
    this.c = paramk;
    super.setWebViewClient(paramk);
  }
  
  private final void a()
  {
    try
    {
      if (!this.a)
      {
        this.a = true;
        bt.A.i.e();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void b(boolean paramBoolean) {}
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/google/android/gms/ads/internal/x/m:b	Z
    //   6: ifne +37 -> 43
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 58	com/google/android/gms/ads/internal/x/m:b	Z
    //   14: aload_0
    //   15: getfield 35	com/google/android/gms/ads/internal/x/m:c	Lcom/google/android/gms/ads/internal/x/k;
    //   18: aload_0
    //   19: putfield 64	com/google/android/gms/ads/internal/x/k:s	Lcom/google/android/gms/ads/internal/x/p;
    //   22: aload_0
    //   23: iconst_0
    //   24: invokevirtual 66	com/google/android/gms/ads/internal/x/m:b	(Z)V
    //   27: ldc 68
    //   29: invokestatic 72	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   32: ldc 74
    //   34: invokestatic 72	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: ldc 76
    //   40: invokespecial 79	com/google/android/gms/ads/internal/x/j:loadUrl	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: getstatic 23	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   50: getfield 27	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   53: aload_1
    //   54: ldc 81
    //   56: invokevirtual 84	com/google/android/gms/ads/internal/v/f:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   59: ldc 86
    //   61: aload_1
    //   62: invokestatic 90	com/google/android/gms/ads/internal/util/e:f	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   65: goto -22 -> 43
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	m
    //   46	16	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   68	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   37	43	46	java/lang/UnsatisfiedLinkError
    //   2	37	68	finally
    //   37	43	68	finally
    //   47	65	68	finally
  }
  
  /* Error */
  @TargetApi(19)
  public void evaluateJavascript(String paramString, android.webkit.ValueCallback paramValueCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 99	com/google/android/gms/ads/internal/x/m:g	()Z
    //   6: ifeq +22 -> 28
    //   9: ldc 101
    //   11: invokestatic 103	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: ifnull +10 -> 25
    //   18: aload_2
    //   19: aconst_null
    //   20: invokeinterface 109 2 0
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: invokespecial 111	com/google/android/gms/ads/internal/x/j:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   34: goto -9 -> 25
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	m
    //   0	42	1	paramString	String
    //   0	42	2	paramValueCallback	android.webkit.ValueCallback
    // Exception table:
    //   from	to	target	type
    //   2	14	37	finally
    //   18	25	37	finally
    //   28	34	37	finally
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 99	com/google/android/gms/ads/internal/x/m:g	()Z
    //   6: ifne +8 -> 14
    //   9: aload_0
    //   10: iconst_1
    //   11: invokevirtual 66	com/google/android/gms/ads/internal/x/m:b	(Z)V
    //   14: aload_0
    //   15: invokespecial 115	com/google/android/gms/ads/internal/x/m:a	()V
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_0
    //   21: invokespecial 119	java/lang/Object:finalize	()V
    //   24: return
    //   25: astore_1
    //   26: aload_0
    //   27: invokespecial 119	java/lang/Object:finalize	()V
    //   30: aload_1
    //   31: athrow
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	m
    //   25	6	1	localObject1	Object
    //   32	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	2	25	finally
    //   35	37	25	finally
    //   2	14	32	finally
    //   14	20	32	finally
    //   33	35	32	finally
  }
  
  public final boolean g()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void h()
  {
    try
    {
      e.a("Destroying WebView!");
      a();
      aa.b.execute(new n(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 99	com/google/android/gms/ads/internal/x/m:g	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 101
    //   11: invokestatic 103	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: aload_3
    //   21: invokespecial 142	com/google/android/gms/ads/internal/x/j:loadData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   24: goto -10 -> 14
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	m
    //   0	32	1	paramString1	String
    //   0	32	2	paramString2	String
    //   0	32	3	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   2	14	27	finally
    //   17	24	27	finally
  }
  
  /* Error */
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 99	com/google/android/gms/ads/internal/x/m:g	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 101
    //   11: invokestatic 103	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: aload_3
    //   21: aload 4
    //   23: aload 5
    //   25: invokespecial 146	com/google/android/gms/ads/internal/x/j:loadDataWithBaseURL	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   28: goto -14 -> 14
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	m
    //   0	36	1	paramString1	String
    //   0	36	2	paramString2	String
    //   0	36	3	paramString3	String
    //   0	36	4	paramString4	String
    //   0	36	5	paramString5	String
    // Exception table:
    //   from	to	target	type
    //   2	14	31	finally
    //   17	28	31	finally
  }
  
  /* Error */
  public void loadUrl(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 99	com/google/android/gms/ads/internal/x/m:g	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 101
    //   11: invokestatic 103	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 79	com/google/android/gms/ads/internal/x/j:loadUrl	(Ljava/lang/String;)V
    //   22: goto -8 -> 14
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	m
    //   0	30	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	25	finally
    //   17	22	25	finally
  }
  
  public final void o()
  {
    try
    {
      e.a("Blank page loaded, 1...");
      h();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @TargetApi(21)
  protected void onDraw(Canvas paramCanvas)
  {
    if (!g()) {
      super.onDraw(paramCanvas);
    }
  }
  
  public void onPause()
  {
    if (!g()) {
      super.onPause();
    }
  }
  
  public void onResume()
  {
    if (!g()) {
      super.onResume();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (!g()) && (super.onTouchEvent(paramMotionEvent));
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient) {}
  
  public void stopLoading()
  {
    if (!g()) {
      super.stopLoading();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/x/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */