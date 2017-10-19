/*    */ package com.tencent.bugly.crashreport.common.info;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ import android.os.Parcelable.Creator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlugInBean
/*    */   implements Parcelable
/*    */ {
/*    */   public final String a;
/*    */   public final String b;
/*    */   public final String c;
/*    */   
/*    */   public PlugInBean(String paramString1, String paramString2, String paramString3)
/*    */   {
/* 29 */     this.a = paramString1;
/* 30 */     this.b = paramString2;
/* 31 */     this.c = paramString3;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 36 */     return "plid:" + this.a + " plV:" + this.b + " plUUID:" + this.c;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public PlugInBean(Parcel paramParcel)
/*    */   {
/* 45 */     this.a = paramParcel.readString();
/* 46 */     this.b = paramParcel.readString();
/* 47 */     this.c = paramParcel.readString();
/*    */   }
/*    */   
/*    */   public int describeContents()
/*    */   {
/* 52 */     return 0;
/*    */   }
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt)
/*    */   {
/* 57 */     paramParcel.writeString(this.a);
/* 58 */     paramParcel.writeString(this.b);
/* 59 */     paramParcel.writeString(this.c);
/*    */   }
/*    */   
/* 62 */   public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator() {};
/*    */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/crashreport/common/info/PlugInBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */