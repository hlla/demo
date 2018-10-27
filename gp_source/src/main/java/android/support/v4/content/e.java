package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class e
  extends a
{
  public String[] c;
  public Uri d;
  private b m;
  private Cursor n;
  private final i o = new i(this);
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private final void a(Cursor paramCursor)
  {
    if (!this.k)
    {
      localCursor = this.n;
      this.n = paramCursor;
      if (this.l) {
        super.b(paramCursor);
      }
      if ((localCursor != null) && (localCursor != paramCursor) && (!localCursor.isClosed())) {
        localCursor.close();
      }
    }
    while (paramCursor == null)
    {
      Cursor localCursor;
      return;
    }
    paramCursor.close();
  }
  
  @Deprecated
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mUri=");
    paramPrintWriter.println(this.d);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mProjection=");
    paramPrintWriter.println(Arrays.toString(this.c));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelection=");
    paramPrintWriter.println(null);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelectionArgs=");
    paramPrintWriter.println(Arrays.toString(null));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSortOrder=");
    paramPrintWriter.println(null);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCursor=");
    paramPrintWriter.println(this.n);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mContentChanged=");
    paramPrintWriter.println(this.f);
  }
  
  /* Error */
  public final void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 108	android/support/v4/content/a:e	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 110	android/support/v4/content/e:m	Landroid/support/v4/os/b;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_1
    //   19: monitorenter
    //   20: aload_1
    //   21: getfield 114	android/support/v4/os/b:b	Z
    //   24: ifne +47 -> 71
    //   27: aload_1
    //   28: iconst_1
    //   29: putfield 114	android/support/v4/os/b:b	Z
    //   32: aload_1
    //   33: getfield 117	android/support/v4/os/b:a	Ljava/lang/Object;
    //   36: astore_2
    //   37: aload_1
    //   38: monitorexit
    //   39: aload_2
    //   40: ifnull +10 -> 50
    //   43: aload_2
    //   44: checkcast 119	android/os/CancellationSignal
    //   47: invokevirtual 122	android/os/CancellationSignal:cancel	()V
    //   50: aload_1
    //   51: monitorenter
    //   52: aload_1
    //   53: invokevirtual 127	java/lang/Object:notifyAll	()V
    //   56: aload_1
    //   57: monitorexit
    //   58: goto -43 -> 15
    //   61: astore_2
    //   62: aload_1
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: aload_1
    //   72: monitorexit
    //   73: goto -58 -> 15
    //   76: astore_2
    //   77: aload_1
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    //   81: astore_2
    //   82: aload_1
    //   83: monitorenter
    //   84: aload_1
    //   85: invokevirtual 127	java/lang/Object:notifyAll	()V
    //   88: aload_1
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    //   92: astore_2
    //   93: aload_1
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	e
    //   10	53	1	localb	b
    //   66	28	1	localObject1	Object
    //   36	8	2	localObject2	Object
    //   61	4	2	localObject3	Object
    //   76	4	2	localObject4	Object
    //   81	10	2	localObject5	Object
    //   92	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   52	58	61	finally
    //   62	64	61	finally
    //   6	11	66	finally
    //   15	17	66	finally
    //   18	20	66	finally
    //   50	52	66	finally
    //   64	66	66	finally
    //   67	69	66	finally
    //   79	81	66	finally
    //   82	84	66	finally
    //   90	92	66	finally
    //   95	97	66	finally
    //   20	39	76	finally
    //   71	73	76	finally
    //   77	79	76	finally
    //   43	50	81	finally
    //   84	90	92	finally
    //   93	95	92	finally
  }
  
  /* Error */
  public Cursor f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 132	android/support/v4/content/a:a	Landroid/support/v4/content/b;
    //   6: ifnonnull +76 -> 82
    //   9: aload_0
    //   10: new 112	android/support/v4/os/b
    //   13: dup
    //   14: invokespecial 134	android/support/v4/os/b:<init>	()V
    //   17: putfield 110	android/support/v4/content/e:m	Landroid/support/v4/os/b;
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_0
    //   23: getfield 138	android/support/v4/content/h:g	Landroid/content/Context;
    //   26: invokevirtual 144	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: aload_0
    //   30: getfield 67	android/support/v4/content/e:d	Landroid/net/Uri;
    //   33: aload_0
    //   34: getfield 74	android/support/v4/content/e:c	[Ljava/lang/String;
    //   37: aload_0
    //   38: getfield 110	android/support/v4/content/e:m	Landroid/support/v4/os/b;
    //   41: invokestatic 149	android/support/v4/content/c:a	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Landroid/support/v4/os/b;)Landroid/database/Cursor;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull +20 -> 66
    //   49: aload_1
    //   50: invokeinterface 153 1 0
    //   55: pop
    //   56: aload_1
    //   57: aload_0
    //   58: getfield 25	android/support/v4/content/e:o	Landroid/support/v4/content/i;
    //   61: invokeinterface 157 2 0
    //   66: aload_0
    //   67: monitorenter
    //   68: aload_0
    //   69: aconst_null
    //   70: putfield 110	android/support/v4/content/e:m	Landroid/support/v4/os/b;
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: areturn
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: new 159	android/support/v4/os/OperationCanceledException
    //   85: dup
    //   86: invokespecial 160	android/support/v4/os/OperationCanceledException:<init>	()V
    //   89: athrow
    //   90: astore_1
    //   91: aload_0
    //   92: monitorenter
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 110	android/support/v4/content/e:m	Landroid/support/v4/os/b;
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_2
    //   103: aload_1
    //   104: invokeinterface 53 1 0
    //   109: aload_2
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	e
    //   44	32	1	localCursor	Cursor
    //   77	4	1	localObject1	Object
    //   90	14	1	localObject2	Object
    //   111	4	1	localObject3	Object
    //   116	4	1	localObject4	Object
    //   102	8	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   2	22	77	finally
    //   78	80	77	finally
    //   82	90	77	finally
    //   22	45	90	finally
    //   49	66	90	finally
    //   103	111	90	finally
    //   49	66	102	java/lang/RuntimeException
    //   68	75	111	finally
    //   112	114	111	finally
    //   93	100	116	finally
    //   117	119	116	finally
  }
  
  protected final void g()
  {
    Cursor localCursor = this.n;
    if (localCursor != null) {
      a(localCursor);
    }
    if ((l()) || (this.n == null)) {
      a();
    }
  }
  
  protected final void h()
  {
    b();
  }
  
  protected final void i()
  {
    super.i();
    h();
    Cursor localCursor = this.n;
    if ((localCursor != null) && (!localCursor.isClosed())) {
      this.n.close();
    }
    this.n = null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */