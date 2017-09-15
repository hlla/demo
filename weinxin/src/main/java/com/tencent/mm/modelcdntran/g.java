package com.tencent.mm.modelcdntran;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import com.tencent.mm.y.n;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class g
  implements am
{
  private b hyH;
  private c hyI;
  private com.tencent.mm.y.c hyJ;
  
  public g()
  {
    GMTrace.i(575794053120L, 4290);
    this.hyH = null;
    this.hyI = null;
    GMTrace.o(575794053120L, 4290);
  }
  
  public static g Ej()
  {
    GMTrace.i(575928270848L, 4291);
    g localg = (g)l.o(g.class);
    GMTrace.o(575928270848L, 4291);
    return localg;
  }
  
  public static String Ek()
  {
    GMTrace.i(576330924032L, 4294);
    h.vG().uQ();
    String str = h.vI().cachePath + "cdndnsinfo/";
    GMTrace.o(576330924032L, 4294);
    return str;
  }
  
  public static com.tencent.mm.y.c El()
  {
    GMTrace.i(16420733714432L, 122344);
    com.tencent.mm.y.c localc = Ej().hyJ;
    GMTrace.o(16420733714432L, 122344);
    return localc;
  }
  
  public static c Em()
  {
    GMTrace.i(576867794944L, 4298);
    if (Ej().hyI == null) {
      Ej().hyI = new c();
    }
    c localc = Ej().hyI;
    GMTrace.o(576867794944L, 4298);
    return localc;
  }
  
  public static b En()
  {
    GMTrace.i(577002012672L, 4299);
    if (Ej().hyH == null)
    {
      h.vG();
      if (!a.uU()) {
        break label68;
      }
    }
    Object localObject;
    for (Ej().hyH = new b(h.vI().cachePath, Em());; Ej().hyH = new b((String)localObject, Em()))
    {
      localObject = Ej().hyH;
      GMTrace.o(577002012672L, 4299);
      return (b)localObject;
      label68:
      localObject = com.tencent.mm.a.g.n(("mm" + new Random().nextLong()).getBytes());
      localObject = w.hgg + (String)localObject + "/";
      v.v("MicroMsg.SubCoreCdnTransport", "hy: cdn temp path: %s", new Object[] { localObject });
    }
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(576599359488L, 4296);
    onAccountRelease();
    h.vG().uQ();
    File localFile = new File(Ek());
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    this.hyJ = new com.tencent.mm.y.c()
    {
      public final void a(if paramAnonymousif1, if paramAnonymousif2, if paramAnonymousif3)
      {
        GMTrace.i(578344189952L, 4309);
        v.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + paramAnonymousif1.toString() + " getCore().engine:" + g.En());
        if (g.En() != null)
        {
          g.En().a(paramAnonymousif1, paramAnonymousif2, paramAnonymousif3, null, null, null);
          h.vL().D(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(582639157248L, 4341);
              if (g.Em() != null) {
                g.Em().be(false);
              }
              GMTrace.o(582639157248L, 4341);
            }
            
            public final String toString()
            {
              GMTrace.i(582773374976L, 4342);
              String str = super.toString() + "|infoUpdate";
              GMTrace.o(582773374976L, 4342);
              return str;
            }
          });
        }
        GMTrace.o(578344189952L, 4309);
      }
    };
    GMTrace.o(576599359488L, 4296);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(576465141760L, 4295);
    GMTrace.o(576465141760L, 4295);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(576196706304L, 4293);
    GMTrace.o(576196706304L, 4293);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(577136230400L, 4300);
    this.hyJ = null;
    Object localObject;
    if (this.hyH != null)
    {
      localObject = this.hyH;
      CdnLogic.setCallBack(null);
      ((b)localObject).hxL = null;
      this.hyH = null;
    }
    if (this.hyI != null)
    {
      localObject = this.hyI;
      if (h.vG().uV()) {
        h.vI().vr().b((m.b)localObject);
      }
      h.vH().b(((c)localObject).hxS);
      h.vH().gXs.b(379, (com.tencent.mm.y.e)localObject);
      this.hyI = null;
    }
    GMTrace.o(577136230400L, 4300);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(576062488576L, 4292);
    GMTrace.o(576062488576L, 4292);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcdntran/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */