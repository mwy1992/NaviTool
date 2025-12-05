/*    */ package ecarx.car.hardware.annotation;public enum ApiResult { CARSIG_SERVICE_NOT_RUNNING, FAILED,
/*    */   INVALID,
/*    */   PARAM_ERROR,
/*  4 */   SUCCEED(0); private static final ApiResult[] $VALUES; static { FAILED = new ApiResult("FAILED", 1, 1); PARAM_ERROR = new ApiResult("PARAM_ERROR", 2, 2); CARSIG_SERVICE_NOT_RUNNING = new ApiResult("CARSIG_SERVICE_NOT_RUNNING", 3, 3); INVALID = new ApiResult("INVALID", 4, 80);
/*    */     $VALUES = new ApiResult[] { SUCCEED, FAILED, PARAM_ERROR, CARSIG_SERVICE_NOT_RUNNING, INVALID }; }
/*    */   
/*    */   public final int V;
/*    */   ApiResult(int paramInt1) {
/*  9 */     this.V = paramInt1;
/*    */   } }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\ApiResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */