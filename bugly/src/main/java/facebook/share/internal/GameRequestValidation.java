/*    */ package com.facebook.share.internal;
/*    */ 
/*    */ import com.facebook.internal.Validate;
/*    */ import com.facebook.share.model.GameRequestContent;
/*    */ import com.facebook.share.model.GameRequestContent.ActionType;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameRequestValidation
/*    */ {
/*    */   public static void validate(GameRequestContent content)
/*    */   {
/* 36 */     Validate.notNull(content.getMessage(), "message");
/*    */     
/*    */ 
/* 39 */     if (((content.getObjectId() != null ? 1 : 0) ^ ((content.getActionType() == ActionType.ASKFOR) || (content.getActionType() == ActionType.SEND) ? 1 : 0)) != 0) {
/* 40 */       throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 45 */     int mutex = 0;
/* 46 */     if (content.getRecipients() != null) {
/* 47 */       mutex++;
/*    */     }
/* 49 */     if (content.getSuggestions() != null) {
/* 50 */       mutex++;
/*    */     }
/* 52 */     if (content.getFilters() != null) {
/* 53 */       mutex++;
/*    */     }
/* 55 */     if (mutex > 1) {
/* 56 */       throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/internal/GameRequestValidation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */