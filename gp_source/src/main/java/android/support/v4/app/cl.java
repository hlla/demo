package android.support.v4.app;

import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.List;

final class cl
{
  private static Field a;
  private static boolean b;
  private static final Object c = new Object();
  
  static
  {
    new Object();
  }
  
  public static Bundle a(Notification.Builder paramBuilder, cd paramcd)
  {
    paramBuilder.addAction(paramcd.b, paramcd.i, paramcd.a);
    paramBuilder = new Bundle(paramcd.e);
    co[] arrayOfco = paramcd.f;
    if (arrayOfco == null) {}
    for (;;)
    {
      arrayOfco = paramcd.d;
      if (arrayOfco != null) {
        paramBuilder.putParcelableArray("android.support.dataRemoteInputs", a(arrayOfco));
      }
      paramBuilder.putBoolean("android.support.allowGeneratedReplies", paramcd.c);
      return paramBuilder;
      paramBuilder.putParcelableArray("android.support.remoteInputs", a(arrayOfco));
    }
  }
  
  /* Error */
  public static Bundle a(android.app.Notification paramNotification)
  {
    // Byte code:
    //   0: getstatic 17	android/support/v4/app/cl:c	Ljava/lang/Object;
    //   3: astore 4
    //   5: aload 4
    //   7: monitorenter
    //   8: getstatic 79	android/support/v4/app/cl:b	Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +115 -> 128
    //   16: getstatic 81	android/support/v4/app/cl:a	Ljava/lang/reflect/Field;
    //   19: ifnull +41 -> 60
    //   22: getstatic 81	android/support/v4/app/cl:a	Ljava/lang/reflect/Field;
    //   25: aload_0
    //   26: invokevirtual 87	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 39	android/os/Bundle
    //   32: astore_3
    //   33: aload_3
    //   34: astore_2
    //   35: aload_3
    //   36: ifnonnull +19 -> 55
    //   39: new 39	android/os/Bundle
    //   42: dup
    //   43: invokespecial 88	android/os/Bundle:<init>	()V
    //   46: astore_2
    //   47: getstatic 81	android/support/v4/app/cl:a	Ljava/lang/reflect/Field;
    //   50: aload_0
    //   51: aload_2
    //   52: invokevirtual 92	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   55: aload 4
    //   57: monitorexit
    //   58: aload_2
    //   59: areturn
    //   60: ldc 94
    //   62: ldc 96
    //   64: invokevirtual 102	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   67: astore_2
    //   68: ldc 39
    //   70: aload_2
    //   71: invokevirtual 106	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   74: invokevirtual 110	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   77: ifne +20 -> 97
    //   80: ldc 112
    //   82: ldc 114
    //   84: invokestatic 119	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   87: pop
    //   88: iconst_1
    //   89: putstatic 79	android/support/v4/app/cl:b	Z
    //   92: aload 4
    //   94: monitorexit
    //   95: aconst_null
    //   96: areturn
    //   97: aload_2
    //   98: iconst_1
    //   99: invokevirtual 123	java/lang/reflect/Field:setAccessible	(Z)V
    //   102: aload_2
    //   103: putstatic 81	android/support/v4/app/cl:a	Ljava/lang/reflect/Field;
    //   106: goto -84 -> 22
    //   109: astore_0
    //   110: ldc 112
    //   112: ldc 125
    //   114: aload_0
    //   115: invokestatic 128	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   118: pop
    //   119: iconst_1
    //   120: putstatic 79	android/support/v4/app/cl:b	Z
    //   123: aload 4
    //   125: monitorexit
    //   126: aconst_null
    //   127: areturn
    //   128: aload 4
    //   130: monitorexit
    //   131: aconst_null
    //   132: areturn
    //   133: astore_0
    //   134: aload 4
    //   136: monitorexit
    //   137: aload_0
    //   138: athrow
    //   139: astore_0
    //   140: ldc 112
    //   142: ldc 125
    //   144: aload_0
    //   145: invokestatic 128	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   148: pop
    //   149: goto -30 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramNotification	android.app.Notification
    //   11	2	1	bool	boolean
    //   34	69	2	localObject1	Object
    //   32	4	3	localBundle	Bundle
    //   3	132	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	22	109	java/lang/IllegalAccessException
    //   22	33	109	java/lang/IllegalAccessException
    //   39	55	109	java/lang/IllegalAccessException
    //   60	92	109	java/lang/IllegalAccessException
    //   97	106	109	java/lang/IllegalAccessException
    //   8	12	133	finally
    //   16	22	133	finally
    //   22	33	133	finally
    //   39	55	133	finally
    //   55	58	133	finally
    //   60	92	133	finally
    //   92	95	133	finally
    //   97	106	133	finally
    //   110	119	133	finally
    //   119	126	133	finally
    //   128	131	133	finally
    //   134	137	133	finally
    //   140	149	133	finally
    //   16	22	139	java/lang/NoSuchFieldException
    //   22	33	139	java/lang/NoSuchFieldException
    //   39	55	139	java/lang/NoSuchFieldException
    //   60	92	139	java/lang/NoSuchFieldException
    //   97	106	139	java/lang/NoSuchFieldException
  }
  
  static Bundle a(cd paramcd)
  {
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("icon", paramcd.b);
    localBundle2.putCharSequence("title", paramcd.i);
    localBundle2.putParcelable("actionIntent", paramcd.a);
    Bundle localBundle1 = paramcd.e;
    if (localBundle1 == null) {}
    for (localBundle1 = new Bundle();; localBundle1 = new Bundle(localBundle1))
    {
      localBundle1.putBoolean("android.support.allowGeneratedReplies", paramcd.c);
      localBundle2.putBundle("extras", localBundle1);
      localBundle2.putParcelableArray("remoteInputs", a(paramcd.f));
      localBundle2.putBoolean("showsUserInterface", paramcd.h);
      localBundle2.putInt("semanticAction", paramcd.g);
      return localBundle2;
    }
  }
  
  public static SparseArray a(List paramList)
  {
    int j = paramList.size();
    Object localObject1 = null;
    int i = 0;
    if (i < j)
    {
      Bundle localBundle = (Bundle)paramList.get(i);
      if (localBundle == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new SparseArray();
        }
        ((SparseArray)localObject2).put(i, localBundle);
        localObject1 = localObject2;
      }
    }
    return (SparseArray)localObject1;
  }
  
  private static Bundle[] a(co[] paramArrayOfco)
  {
    if (paramArrayOfco != null)
    {
      int i = paramArrayOfco.length;
      paramArrayOfco = new Bundle[i];
      if (i > 0)
      {
        new Bundle();
        throw new NoSuchMethodError();
      }
    }
    else
    {
      paramArrayOfco = null;
    }
    return paramArrayOfco;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */