/*    */ package com.facebook.internal;
/*    */ 
/*    */ import java.util.EnumSet;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum SmartLoginOption
/*    */ {
/* 25 */   None(0L), 
/* 26 */   Enabled(1L), 
/* 27 */   RequireConfirm(2L);
/*    */   
/* 29 */   public static final EnumSet<SmartLoginOption> ALL = EnumSet.allOf(SmartLoginOption.class);
/*    */   
/* 31 */   public static EnumSet<SmartLoginOption> parseOptions(long bitmask) { EnumSet<SmartLoginOption> result = EnumSet.noneOf(SmartLoginOption.class);
/* 32 */     for (SmartLoginOption opt : ALL) {
/* 33 */       if ((bitmask & opt.getValue()) != 0L) {
/* 34 */         result.add(opt);
/*    */       }
/*    */     }
/* 37 */     return result;
/*    */   }
/*    */   
/*    */   private final long mValue;
/*    */   private SmartLoginOption(long value)
/*    */   {
/* 43 */     this.mValue = value;
/*    */   }
/*    */   
/*    */   public long getValue() {
/* 47 */     return this.mValue;
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/SmartLoginOption.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */