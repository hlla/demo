package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.security.SecureRandom;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class b
{
  private Context mContext = null;
  public i xkG = new i();
  private j xkH = new j(this.xkG);
  private f xkI = new f(this.xkG);
  private g xkJ = new g(this.xkG);
  private h xkK = new h(this.xkG);
  private e xkL = new e(this.xkG);
  public d xkM = null;
  private int xkN = 66560;
  private int xkO = 1404;
  
  public b(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    i locali = this.xkG;
    locali.xkU = paramContext;
    locali.xlv = paramInt;
    locali.xlP = new c(paramContext);
    paramContext = new byte[16];
    locali.xlm.nextBytes(paramContext);
    System.arraycopy(paramContext, 0, locali.xlp, 0, 16);
    chY();
  }
  
  private int chY()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = util.hW(this.mContext);
        if ((localObject1 == null) || (localObject1.length <= 0))
        {
          localObject1 = util.hP(this.mContext);
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            localObject1 = new String("%4;7t>;28<fc.5*6").getBytes();
            this.xkG.xlI = 0;
            util.b(this.mContext, (byte[])localObject1);
            this.xkG.xlH = 1;
            this.xkG.xlJ = 1;
            this.xkG.xlw = new byte[localObject1.length];
            System.arraycopy(localObject1, 0, this.xkG.xlw, 0, localObject1.length);
            Object localObject3 = new byte[localObject1.length + 1];
            localObject3[0] = 35;
            System.arraycopy(localObject1, 0, localObject3, 1, localObject1.length);
            this.xkG.xln = util.bT((byte[])localObject3);
            i.xlx = (byte[])this.xkG.xlw.clone();
            this.xkG.xly = util.hQ(this.mContext);
            i = util.hS(this.mContext);
            this.xkG.xlz = util.hR(this.mContext);
            if (i != this.xkG.xlz)
            {
              util.hT(this.mContext);
              util.an(this.mContext, this.xkG.xlz);
            }
            this.xkG.xlB = util.hU(this.mContext).getBytes();
            this.xkG.xlK = util.hV(this.mContext);
            this.xkG.xlA = util.hX(this.mContext);
            this.xkG.xlD = util.bN(this.mContext, new String(this.xkG.xlA));
            this.xkG.xlE = util.bO(this.mContext, new String(this.xkG.xlA));
            localObject1 = Build.MODEL;
            if (localObject1 != null) {
              break label475;
            }
            this.xkG.xlF = new byte[0];
            if ((util.isFileExist("/system/bin/su")) || (util.isFileExist("/system/xbin/su")) || (util.isFileExist("/sbin/su"))) {
              break label489;
            }
            i = 0;
            localObject1 = this.xkG;
            if (i == 0) {
              break label494;
            }
            i = 1;
            ((i)localObject1).xlG = i;
            localObject3 = Build.VERSION.RELEASE;
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = "";
            }
            util.Wp("WtloginHelper init ok: android version:" + (String)localObject1 + " release time:" + util.cio());
            return 0;
          }
          this.xkG.xlI = 1;
          continue;
        }
        this.xkG.xlI = 1;
      }
      finally {}
      this.xkG.xlH = 0;
      this.xkG.xlJ = 0;
      continue;
      label475:
      this.xkG.xlF = ((String)localObject2).getBytes();
      continue;
      label489:
      int i = 1;
      continue;
      label494:
      i = 0;
    }
  }
  
  public final byte[] a(long paramLong, a parama, String paramString)
  {
    util.Wp("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256" + " ...");
    String str = paramString;
    if (paramString.length() > 16) {
      str = paramString.substring(0, 16);
    }
    try
    {
      switch (chZ()[parama.ordinal()])
      {
      case 1: 
        return null;
      }
    }
    finally {}
    if ((str == null) || (str.length() == 0))
    {
      util.Wp("USER_WITH_PWD userPasswd null");
      return null;
    }
    parama = oicq.wlogin_sdk.tools.c.Wn(str);
    for (int i = 0;; i = 1)
    {
      this.xkG.xlz = util.hR(this.mContext);
      this.xkG.xlB = util.hU(this.mContext).getBytes();
      this.xkG._uin = paramLong;
      this.xkG.xls = 522017402L;
      this.xkG.xlt = 8256;
      this.xkG.xlq = new oicq.wlogin_sdk.a.f();
      this.xkM = this.xkH;
      if (i != 0) {}
      for (parama = this.xkH.a(522017402L, paramLong, this.xkG.xlN, parama, this.xkO, this.xkN, 8256, this.xkG.xlK);; parama = this.xkH.a(522017402L, paramLong, this.xkG.xlN, paramString, parama, this.xkO, this.xkN, 8256, this.xkG.xlK))
      {
        util.Wp("wtlogin login with GetStWithPasswd:user:" + paramLong + " appid:522017402 dwSigMap:8256" + " end");
        return parama;
        if ((str == null) || (str.length() == 0))
        {
          util.Wp("USER_WITH_MD5 userPasswd null");
          return null;
        }
        try
        {
          parama = (byte[])str.getBytes("ISO-8859-1").clone();
          i = 0;
        }
        catch (Exception parama)
        {
          return null;
        }
        parama = this.xkG.y(paramLong, 522017402L);
        if ((parama == null) || (parama._en_A1 == null) || (parama._en_A1.length <= 0)) {
          util.Wp("userAccount:" + paramLong + " appid:522017402" + " GetA1ByAccount return: null");
        }
        for (parama = null; (parama == null) || (parama.length < 16); parama = (byte[])parama._en_A1.clone())
        {
          util.Wp("USER_WITH_A1 tmp_pwd null");
          return null;
          util.Wp("userAccount:" + paramLong + " appid:522017402" + " GetA1ByAccount return: not null");
        }
        paramString = new byte[4];
        util.c(paramString, 0, i.cic());
      }
      break;
    }
  }
  
  public final byte[] f(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    util.Wp("user:" + paramLong + " CheckPicture ...");
    try
    {
      this.xkM = this.xkJ;
      paramArrayOfByte = this.xkJ.bL(paramArrayOfByte);
      util.Wp("user:" + paramLong + " CheckPicture end");
      return paramArrayOfByte;
    }
    finally {}
  }
  
  /* Error */
  public final byte[] ff(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	oicq/wlogin_sdk/request/b:xkG	Loicq/wlogin_sdk/request/i;
    //   6: getfield 403	oicq/wlogin_sdk/request/i:xlr	Loicq/wlogin_sdk/a/g;
    //   9: astore_3
    //   10: aload_3
    //   11: getfield 408	oicq/wlogin_sdk/a/g:xmc	I
    //   14: newarray <illegal type>
    //   16: astore 4
    //   18: aload_3
    //   19: getfield 408	oicq/wlogin_sdk/a/g:xmc	I
    //   22: ifgt +40 -> 62
    //   25: aload_0
    //   26: monitorexit
    //   27: new 252	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 390
    //   34: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: lload_1
    //   38: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: ldc_w 410
    //   44: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload 4
    //   49: arraylength
    //   50: invokevirtual 413	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 271	oicq/wlogin_sdk/tools/util:Wp	(Ljava/lang/String;)V
    //   59: aload 4
    //   61: areturn
    //   62: aload_3
    //   63: getfield 416	oicq/wlogin_sdk/a/g:xlc	[B
    //   66: aload_3
    //   67: getfield 419	oicq/wlogin_sdk/a/g:xme	I
    //   70: aload 4
    //   72: iconst_0
    //   73: aload_3
    //   74: getfield 408	oicq/wlogin_sdk/a/g:xmc	I
    //   77: invokestatic 109	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   80: goto -55 -> 25
    //   83: astore_3
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	b
    //   0	88	1	paramLong	long
    //   9	65	3	localg	oicq.wlogin_sdk.a.g
    //   83	4	3	localObject	Object
    //   16	55	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	25	83	finally
    //   25	27	83	finally
    //   62	80	83	finally
    //   84	86	83	finally
  }
  
  public final void fg(long paramLong)
  {
    util.Wp("user:" + paramLong + " ClearUserSigInfo");
    this.xkG.i(Long.valueOf(paramLong));
  }
  
  public static enum a {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/oicq/wlogin_sdk/request/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */