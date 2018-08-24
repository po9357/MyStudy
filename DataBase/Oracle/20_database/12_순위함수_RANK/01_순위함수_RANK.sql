-- 순위함수 : RANK(), DENSE_RANK(), ROW_NUMBER()
-- PARTITION BY : 그룹 조건 (GROUP BY와 비슷)
-- ORDER BY : 순위 기준
-----------------------------------------------------------
-- RANK() : 순위를 구함(동일순위자 숫자 반영)
-- 문법 : RANK() OVER (PARTITION BY 컬럼 ORDER BY 컬럼)
-- 동작형태 : 1, 2, 2, 4, 5
-----------------------------------------------------------
-- DENSE_RANK() : 순위를 구함(동일순위자 숫자 무시)
-- 문법 : DENSE_RANK() OVER (PARTITION BY 컬럼 ORDER BY 컬럼)
-- 동작형태 : 1, 2, 2, 2, 3, 4, 5
-----------------------------------------------------------
-- ROW_NUMBER() : 순위를 구함(동일순위자 숫자 무시)
-- 문법 : ROW_NUMBER() OVER (PARTITION BY 컬럼 ORDER BY 컬럼)
-- 동작형태 : 1, 2, 3, 4, 5
-----------------------------------------------------------
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
       , RANK() OVER (ORDER BY SALARY DESC) RANK_SALARY
       , DENSE_RANK() OVER (ORDER BY SALARY DESC) RANK_SALARY
       , ROW_NUMBER() OVER (ORDER BY SALARY DESC) RANK_SALARY
  FROM EMPLOYEES;
  
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, SALARY
       , RANK() OVER (PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) RANK_SALARY
       , DENSE_RANK() OVER (PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) RANK_SALARY
       , ROW_NUMBER() OVER (PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) RANK_SALARY
  FROM EMPLOYEES;