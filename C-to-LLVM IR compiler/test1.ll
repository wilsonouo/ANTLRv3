@.str0 = private unnamed_addr constant [4 x i8] c"%f\0A\00", align 1
@.str1 = private unnamed_addr constant [4 x i8] c"%f\0A\00", align 1
; === prologue ====
declare dso_local i32 @printf(i8*, ...)
define dso_local i32 @main()
{
%t0 = alloca float, align 4
%t1 = alloca float, align 4
%t2 = alloca float, align 4
store float 0x3ff244d020000000, float* %t1, align 4
store float 0x4001226800000000, float* %t2, align 4
%t3 = load float, float* %t2, align 4
%t4 = load float, float* %t1, align 4
%t5 = fcmp ogt float %t3, %t4
br i1 %t5, label %L1, label %L2
L1:
%t6 = load float, float* %t2, align 4
%t7 = fpext float %t6 to double
%t8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str0, i64 0, i64 0), double %t7)
br label %L2
L2:
%t9 = load float, float* %t2, align 4
%t10 = fpext float %t9 to double
%t11 = fcmp ogt double %t10, 0x3ff0000000000000
br i1 %t11, label %L3, label %L4
L3:
%t12 = load float, float* %t2, align 4
%t13 = fpext float %t12 to double
%t14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str1, i64 0, i64 0), double %t13)
br label %L4
L4:

; === epilogue ===
ret i32 0
}
