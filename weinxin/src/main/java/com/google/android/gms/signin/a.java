package com.google.android.gms.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class a
  implements Parcelable.Creator<GoogleSignInAccount>
{
  static void a(GoogleSignInAccount paramGoogleSignInAccount, Parcel paramParcel, int paramInt)
  {
    int i = b.t(paramParcel, 20293);
    b.c(paramParcel, 1, paramGoogleSignInAccount.versionCode);
    b.a(paramParcel, 2, paramGoogleSignInAccount.ahk);
    b.a(paramParcel, 3, paramGoogleSignInAccount.alo);
    b.a(paramParcel, 4, paramGoogleSignInAccount.aDf);
    b.a(paramParcel, 5, paramGoogleSignInAccount.aDg);
    b.a(paramParcel, 6, paramGoogleSignInAccount.aDh, paramInt);
    b.u(paramParcel, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/signin/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */