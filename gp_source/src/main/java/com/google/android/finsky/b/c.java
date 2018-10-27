package com.google.android.finsky.b;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.finsky.bw.an;
import com.google.android.finsky.bw.s;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dfemodel.f;
import com.google.android.finsky.dfemodel.w;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.e.af;
import com.google.android.finsky.stream.base.playcluster.PlayCardClusterViewV2;
import com.google.android.finsky.stream.base.playcluster.a;
import com.google.android.play.image.x;
import com.google.android.play.image.y;
import com.google.android.play.image.z;

public final class c
  implements a
{
  public final int a;
  public final int b;
  public final com.google.android.finsky.navigationmanager.c c;
  private final x d;
  private final PlayCardClusterViewV2 e;
  private final Document f;
  private final Context g;
  private final af h;
  private final f i;
  private final an j;
  
  public c(Context paramContext, x paramx, com.google.android.finsky.navigationmanager.c paramc, Document paramDocument, f paramf, PlayCardClusterViewV2 paramPlayCardClusterViewV2, af paramaf, an paraman)
  {
    this.f = paramDocument;
    this.i = paramf;
    this.e = paramPlayCardClusterViewV2;
    this.g = paramContext;
    this.d = paramx;
    this.c = paramc;
    this.h = paramaf;
    this.j = paraman;
    paramContext = paramContext.getResources();
    this.b = paramContext.getDimensionPixelSize(2131166048);
    this.a = paramContext.getDimensionPixelSize(2131166047);
  }
  
  public final int a(int paramInt)
  {
    return 2131624820;
  }
  
  public final y a(int paramInt1, int paramInt2, int paramInt3, z paramz, int[] paramArrayOfInt)
  {
    Document localDocument = (Document)this.i.a(paramInt1, false);
    return an.a(this.g, localDocument, this.d, paramInt2, paramInt3, paramz, paramArrayOfInt);
  }
  
  public final String a()
  {
    return this.f.a.s;
  }
  
  public final float b(int paramInt)
  {
    return s.a(((Document)this.i.a(paramInt, false)).a.r);
  }
  
  public final boolean b()
  {
    return this.i.j;
  }
  
  public final int c()
  {
    return this.i.j();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */