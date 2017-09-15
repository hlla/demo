package com.tencent.mm.x;

import android.content.ContentValues;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.yk;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k.b;
import java.io.IOException;
import java.io.OutputStream;

final class k
  extends com.tencent.mm.y.k
  implements j
{
  private com.tencent.mm.y.e gUt;
  private String hqU;
  private int hqY;
  private String hra;
  private int hrq;
  private OutputStream hrr;
  private String hrs;
  private String username;
  
  public k(String paramString)
  {
    GMTrace.i(384533790720L, 2865);
    this.hrr = null;
    this.username = paramString;
    if (x.eO(paramString)) {
      this.username = x.QQ(paramString);
    }
    v.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + paramString + " out_username" + this.username);
    this.hqY = 480;
    this.hrq = 480;
    this.hra = "jpg";
    GMTrace.o(384533790720L, 2865);
  }
  
  private void Bv()
  {
    GMTrace.i(385741750272L, 2874);
    try
    {
      if (this.hrr != null)
      {
        this.hrr.flush();
        this.hrr.close();
        this.hrr = null;
      }
      GMTrace.o(385741750272L, 2874);
      return;
    }
    catch (IOException localIOException)
    {
      v.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bf.g(localIOException) });
      GMTrace.o(385741750272L, 2874);
    }
  }
  
  public static void S(String paramString1, String paramString2)
  {
    GMTrace.i(385204879360L, 2870);
    n.Bl().R(paramString1, paramString2);
    GMTrace.o(385204879360L, 2870);
  }
  
  private int z(byte[] paramArrayOfByte)
  {
    GMTrace.i(385607532544L, 2873);
    try
    {
      if (this.hrr == null) {
        this.hrr = FileOp.gQ(this.hrs);
      }
      this.hrr.write(paramArrayOfByte);
      int i = paramArrayOfByte.length;
      GMTrace.o(385607532544L, 2873);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      v.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", new Object[] { bf.g(paramArrayOfByte) });
      GMTrace.o(385607532544L, 2873);
    }
    return -1;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(384668008448L, 2866);
    this.gUt = parame1;
    if ((this.username == null) || (this.username.length() == 0))
    {
      v.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
      GMTrace.o(384668008448L, 2866);
      return -1;
    }
    if (this.username.endsWith("@qqim"))
    {
      v.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
      GMTrace.o(384668008448L, 2866);
      return -1;
    }
    Object localObject1 = n.By();
    n.Bl();
    this.hqU = d.r(this.username, true);
    if (FileOp.aO(this.hqU))
    {
      v.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
      GMTrace.o(384668008448L, 2866);
      return 0;
    }
    this.hrs = (this.hqU + ".tmp");
    parame1 = ((g)localObject1).hr(this.username);
    Object localObject2;
    if (parame1 == null)
    {
      FileOp.deleteFile(this.hrs);
      parame1 = new f();
      parame1.username = this.username;
      parame1.hra = this.hra;
      parame1.hqY = this.hqY;
      parame1.hqZ = this.hrq;
      parame1.fRM = -1;
      localObject2 = parame1.pv();
      ((g)localObject1).hnp.insert("hdheadimginfo", "username", (ContentValues)localObject2);
      localObject1 = new b.a();
      ((b.a)localObject1).hrV = new yk();
      ((b.a)localObject1).hrW = new yl();
      ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/gethdheadimg";
      ((b.a)localObject1).hrU = 158;
      ((b.a)localObject1).hrX = 47;
      ((b.a)localObject1).hrY = 1000000047;
      localObject1 = ((b.a)localObject1).BE();
      localObject2 = (yk)((com.tencent.mm.y.b)localObject1).hrS.hsa;
      if (x.eO(this.username)) {
        break label644;
      }
      ((yk)localObject2).jLx = this.username;
      ((yk)localObject2).tDl = 1;
    }
    for (;;)
    {
      v.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ((yk)localObject2).jLx + " outType:" + ((yk)localObject2).tDl);
      ((yk)localObject2).tDi = this.hqY;
      ((yk)localObject2).tDj = this.hrq;
      ((yk)localObject2).tDk = this.hra;
      ((yk)localObject2).tfd = parame1.hrb;
      ((yk)localObject2).tfe = parame1.hrc;
      int i = a(parame, (p)localObject1, this);
      GMTrace.o(384668008448L, 2866);
      return i;
      localObject2 = this.hrs;
      if ((parame1 == null) || (localObject2 == null) || (((String)localObject2).length() == 0)) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0)
        {
          FileOp.deleteFile(this.hrs);
          parame1.reset();
          parame1.username = this.username;
          parame1.hra = this.hra;
          parame1.hqY = this.hqY;
          parame1.hqZ = this.hrq;
          ((g)localObject1).a(this.username, parame1);
        }
        break;
        if ((!parame1.Bq().equals(this.hra)) || (parame1.hqY != this.hqY) || (parame1.hqZ != this.hrq)) {
          i = 0;
        } else if (FileOp.kj((String)localObject2) == parame1.hrc) {
          i = 1;
        } else {
          i = 0;
        }
      }
      label644:
      if (this.username.equals(m.xL() + "@bottle"))
      {
        ((yk)localObject2).jLx = m.xL();
        ((yk)localObject2).tDl = 2;
      }
      else
      {
        ((yk)localObject2).jLx = this.username;
        ((yk)localObject2).tDl = 2;
      }
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(384802226176L, 2867);
    if ((this.username == null) || (this.username.length() == 0))
    {
      i = k.b.hsD;
      GMTrace.o(384802226176L, 2867);
      return i;
    }
    int i = k.b.hsC;
    GMTrace.o(384802226176L, 2867);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(385070661632L, 2869);
    paramArrayOfByte = (yl)((com.tencent.mm.y.b)paramp).hrT.hsa;
    v.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      Bv();
      GMTrace.o(385070661632L, 2869);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      v.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:" + paramInt2);
      Bv();
      GMTrace.o(385070661632L, 2869);
      return;
    }
    paramInt1 = paramp.zg().sXW;
    if ((paramInt1 == -4) || (paramInt1 == -54) || (paramInt1 == -55)) {
      v.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == " + paramInt1);
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      v.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      Bv();
      GMTrace.o(385070661632L, 2869);
      return;
    }
    int i = -1;
    paramInt1 = i;
    if (paramArrayOfByte.tqC != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.tqC.tXD != null) {
        paramInt1 = z(paramArrayOfByte.tqC.tXD.sWU);
      }
    }
    if (paramInt1 < 0)
    {
      v.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      Bv();
      GMTrace.o(385070661632L, 2869);
      return;
    }
    paramp = n.By();
    f localf = paramp.hr(this.username);
    localf.hrc = (paramInt1 + paramArrayOfByte.tfe);
    localf.hrb = paramArrayOfByte.tfd;
    paramp.a(this.username, localf);
    if (localf.hrc >= localf.hrb) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      v.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", new Object[] { Integer.valueOf(hashCode()), this.username, Integer.valueOf(localf.hrc), Integer.valueOf(localf.hrb) });
      if (a(this.hsm, this.gUt) < 0) {
        this.gUt.a(3, -1, "", this);
      }
      GMTrace.o(385070661632L, 2869);
      return;
    }
    FileOp.aj(this.hrs, this.hqU);
    S(this.hqU, this.username);
    Bv();
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(385070661632L, 2869);
  }
  
  protected final void cancel()
  {
    GMTrace.i(385339097088L, 2871);
    super.cancel();
    Bv();
    GMTrace.o(385339097088L, 2871);
  }
  
  public final int getType()
  {
    GMTrace.i(385473314816L, 2872);
    GMTrace.o(385473314816L, 2872);
    return 158;
  }
  
  protected final int ub()
  {
    GMTrace.i(384936443904L, 2868);
    GMTrace.o(384936443904L, 2868);
    return 10;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */