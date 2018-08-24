/****** HR 데이타 조회 문제2 ****************
/*1■ HR 부서의 어떤 사원은 급여정보를 조회하는 업무를 맡고 있다. 
  Tucker 사원 보다 급여를 많이 받고 있는 사원의 
  이름과 성(Name으로 별칭), 업무, 급여를 출력하시오
*****************************************************/

/*2■ 사원의 급여 정보 중 업무별 최소 급여를 받고 있는 사원의 
  이름과 성(Name으로별칭), 업무, 급여, 입사일을 출력하시오
********************************************************/

/*3■ 소속 부서의 평균 급여보다 많은 급여를 받는 사원의 
  이름과 성(Name으로 별칭), 급여, 부서번호, 업무를 출력하시오
***********************************************************/

/*4■ 모든 사원의 소속부서 평균연봉을 계산하여 사원별로 이름과 성(Name으로 별칭),
  업무, 급여, 부서번호, 부서평균연봉(Department Avg Salary로 별칭)을 출력하시오
***************************************************************/

/*5■ HR 스키마에 있는 Job_history 테이블은 사원들의 업무 변경 이력을 나타내는 테이블이다. 
  이 정보를 이용하여 모든 사원의 현재 및 이전의 업무 이력 정보를 출력하고자 한다. 
  중복된 사원정보가 있으면 한 번만 표시하여 출력하시오
  (사원번호, 업무)
*********************************************************************/

/*6■ 위 문제에서 각 사원의 업무 이력 정보를 확인하였다. 하지만 '모든 사원의
  업무 이력 전체'를 보지는 못했다. 여기에서는 모든 사원의 
  업무 이력 변경 정보(JOB_HISTORY) 및 업무변경에 따른 부서정보를 
  사원번호가 빠른 순서대로 출력하시오(집합연산자 UNION)
  (사원번호, 부서정보, 업무)
**********************************************************************/
  
/*7■ HR 부서에서는 신규 프로젝트를 성공으로 이끈 해당 업무자들의 
  급여를 인상 하기로 결정하였다. 
  사원은 현재 107명이며 19개의 업무에 소속되어 근무 중이다. 
  급여 인상 대상자는 회사의 업무(Distinct job_id) 중 다음 5개 업무에서 
  일하는 사원에 해당된다. 나머지 업무에 대해서는 급여가 동결된다. 
  5개 업무의 급여 인상안은 다음과 같다.
  HR_REP(10%), MK_REP(12%), PR_REP(15%), SA_REP(18%), IT_PROG(20%)
**********************************************************************/

/*8■ HR 부서에서는 최상위 입사일에 해당하는 2001년부터 2003년까지 입사자들의 급여를 
  각각 5%, 3%, 1% 인상하여 지분에 따른 배당금으로 지급하고자 한다. 
  전체 사원들 중 해당 년도에 해당하는 사원들의 급여를 검색하여 적용하고, 
  입사일자에 따른 오름차순 정렬을 수행하시오
**********************************************************************/

/*9■ 부서별 급여 합계를 구하고, 그 결과를 다음과 같이 표현하시오.
  Sum Salary > 100000 이면, "Excellent"
  Sum Salary > 50000 이면, "Good"
  Sum Salary > 10000 이면, "Medium"
  Sum Salary <= 10000 이면, "Well"
**********************************************************************/

/*10■ 2005년 이전에 입사한 사원 중 업무에 "MGR"이 포함된 사원은 15%, 
  "MAN"이 포함된 사원은 20% 급여를 인상한다. 
  또한 2005년부터 근무를 시작한 사원 중 "MGR"이 포함된 사원은 25% 급여를 인상한다. 
  이를 수행하는 쿼리를 작성하시오
**********************************************************************/

/*11■ 월별로 입사한 사원 수 출력
  (방식1) 월별로 입사한 사원 수가 아래와 같이 각 행별로 출력되도록 하시오(12행).
  1월 xx
  2월 xx
  3월 xx
  ..
  12월 xx
  합계 XXX
**********************************************************************/  
---------------------------------------------------------
/* (방식2) 첫 행에 모든 월별 입사 사원 수가 출력되도록 하시오
  1월 2월 3월 4월 .... 11월 12월
  xx  xx  xx xx  .... xx   xx
**********************************************************************/

/*1■ HR 부서의 어떤 사원은 급여정보를 조회하는 업무를 맡고 있다. 
  Tucker 사원 보다 급여를 많이 받고 있는 사원의 
  이름과 성(Name으로 별칭), 업무, 급여를 출력하시오
*****************************************************/
SELECT FIRST_NAME||' '||LAST_NAME NAME, JOB_ID, SALARY FROM EMPLOYEES 
 WHERE SALARY > (SELECT SALARY FROM EMPLOYEES WHERE UPPER(LAST_NAME) IN 'TUCKER')
 ORDER BY SALARY DESC;
 
/*2■ 사원의 급여 정보 중 업무별 최소 급여를 받고 있는 사원의 
  이름과 성(Name으로별칭), 업무, 급여, 입사일을 출력하시오
********************************************************/
SELECT FIRST_NAME||' '||LAST_NAME NAME, E.JOB_ID, SALARY, HIRE_DATE
  FROM EMPLOYEES E, (SELECT MIN(SALARY) MIN, JOB_ID FROM EMPLOYEES GROUP BY JOB_ID) SUB
 WHERE E.JOB_ID = SUB.JOB_ID
   AND SUB.MIN = SALARY
 ORDER BY JOB_ID;
 
-- 상관 서브쿼리 사용
SELECT FIRST_NAME||' '||LAST_NAME NAME, E.JOB_ID, SALARY, HIRE_DATE
  FROM EMPLOYEES E
 WHERE E.SALARY = (SELECT MIN(SALARY)
                     FROM EMPLOYEES
                    WHERE E.JOB_ID = JOB_ID
                    GROUP BY JOB_ID);

/*3■ 소속 부서의 평균 급여보다 많은 급여를 받는 사원의 
  이름과 성(Name으로 별칭), 급여, 부서번호, 업무를 출력하시오
***********************************************************/
SELECT E.FIRST_NAME||' '||E.LAST_NAME NAME, E.SALARY, E.DEPARTMENT_ID, E.JOB_ID, ROUND(SUB.AVG, 2)
  FROM EMPLOYEES E, (SELECT AVG(SALARY) AVG, DEPARTMENT_ID FROM EMPLOYEES GROUP BY DEPARTMENT_ID) SUB
 WHERE E.DEPARTMENT_ID = SUB.DEPARTMENT_ID
   AND E.SALARY > SUB.AVG
 ORDER BY SALARY;
-- 상관 서브쿼리 사용
SELECT E.FIRST_NAME||' '||E.LAST_NAME NAME, E.SALARY, E.DEPARTMENT_ID, E.JOB_ID
  FROM EMPLOYEES E
 WHERE E.SALARY > (SELECT AVG(SALARY) AVG FROM EMPLOYEES WHERE E.DEPARTMENT_ID = DEPARTMENT_ID GROUP BY DEPARTMENT_ID);

/*4■ 모든 사원의 소속부서 평균연봉을 계산하여 사원별로 이름과 성(Name으로 별칭),
  업무, 급여, 부서번호, 부서평균연봉(Department Avg Salary로 별칭)을 출력하시오
***************************************************************/
SELECT E.FIRST_NAME||' '||E.LAST_NAME NAME, E.JOB_ID, E.SALARY, E.DEPARTMENT_ID
                , ROUND(SUB.AVG, 2) "Department Avg Salary"
  FROM EMPLOYEES E, (SELECT AVG(SALARY) AVG, DEPARTMENT_ID FROM EMPLOYEES GROUP BY DEPARTMENT_ID) SUB
 WHERE E.DEPARTMENT_ID = SUB.DEPARTMENT_ID
 ORDER BY AVG DESC;

/*5■ HR 스키마에 있는 Job_history 테이블은 사원들의 업무 변경 이력을 나타내는 테이블이다. 
  이 정보를 이용하여 모든 사원의 현재 및 이전의 업무 이력 정보를 출력하고자 한다. 
  중복된 사원정보가 있으면 한 번만 표시하여 출력하시오
  (사원번호, 업무)
*********************************************************************/
SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID FROM EMPLOYEES
UNION ALL
SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID FROM JOB_HISTORY
 ORDER BY EMPLOYEE_ID, JOB_ID;
 
/*6■ 위 문제에서 각 사원의 업무 이력 정보를 확인하였다. 하지만 '모든 사원의
  업무 이력 전체'를 보지는 못했다. 여기에서는 모든 사원의 
  업무 이력 변경 정보(JOB_HISTORY) 및 업무변경에 따른 부서정보를 
  사원번호가 빠른 순서대로 출력하시오(집합연산자 UNION)
  (사원번호, 부서정보, 업무)
**********************************************************************/
SELECT EMPLOYEE_ID, DEPARTMENT_ID, JOB_ID
  FROM EMPLOYEES 
UNION
SELECT EMPLOYEE_ID, DEPARTMENT_ID, JOB_ID
  FROM JOB_HISTORY
ORDER BY EMPLOYEE_ID
;
/*7■ HR 부서에서는 신규 프로젝트를 성공으로 이끈 해당 업무자들의 
  급여를 인상 하기로 결정하였다. 
  사원은 현재 107명이며 19개의 업무에 소속되어 근무 중이다. 
  급여 인상 대상자는 회사의 업무(Distinct job_id) 중 다음 5개 업무에서 
  일하는 사원에 해당된다. 나머지 업무에 대해서는 급여가 동결된다. 
  5개 업무의 급여 인상안은 다음과 같다.
  HR_REP(10%), MK_REP(12%), PR_REP(15%), SA_REP(18%), IT_PROG(20%)
**********************************************************************/
SELECT EMPLOYEE_ID, JOB_ID, SALARY, NVL((CASE WHEN (JOB_ID = 'HR_REP') THEN TO_CHAR(SALARY*1.10)
                                              WHEN (JOB_ID = 'MK_REP') THEN TO_CHAR(SALARY*1.12)
                                              WHEN (JOB_ID = 'PR_REP') THEN TO_CHAR(SALARY*1.15)
                                              WHEN (JOB_ID = 'SA_REP') THEN TO_CHAR(SALARY*1.18)
                                              WHEN (JOB_ID = 'IT_PROG') THEN TO_CHAR(SALARY*1.20)
                                          END), '급여동결') AS "인상후 급여"
FROM EMPLOYEES;
-- DECODE(JOB_ID, 'HR_REP', SALARY * 1.10
--              , 'MK_REP', SALARY * 1.12 ... 'IT_PROG', SALARY * 1.20, SALARY)

/*8■ HR 부서에서는 최상위 입사일에 해당하는 2001년부터 2003년까지 입사자들의 급여를 
  각각 5%, 3%, 1% 인상하여 지분에 따른 배당금으로 지급하고자 한다. 
  전체 사원들 중 해당 년도에 해당하는 사원들의 급여를 검색하여 적용하고, 
  입사일자에 따른 오름차순 정렬을 수행하시오
**********************************************************************/
SELECT E.EMPLOYEE_ID 사원번호, E.FIRST_NAME||' '||E.LAST_NAME NAME, E.HIRE_DATE, E.SALARY
       , (CASE WHEN (TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) = 1) THEN SALARY * 1.05
               WHEN (TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) = 2) THEN SALARY * 1.03
               WHEN (TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) = 3) THEN SALARY * 1.01
          END) "인상급여"
  FROM EMPLOYEES E
 WHERE TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) BETWEEN 1 AND 3
 ORDER BY HIRE_DATE;

/*9■ 부서별 급여 합계를 구하고, 그 결과를 다음과 같이 표현하시오.
  Sum Salary > 100000 이면, "Excellent"
  Sum Salary > 50000 이면, "Good"
  Sum Salary > 10000 이면, "Medium"
  Sum Salary <= 10000 이면, "Well"
**********************************************************************/
SELECT DEPARTMENT_ID, SUM(SALARY) SUM_SAL
       , (CASE WHEN SUM(SALARY) > 100000 THEN 'Excellent'
               WHEN SUM(SALARY) > 50000 THEN 'Good'
               WHEN SUM(SALARY) > 10000 THEN 'Medium'
               WHEN SUM(SALARY) <= 10000 THEN 'Well' END) 등급
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY SUM_SAL DESC;
--------------------------------------------
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
-- 함수 만들어서 처리
SELECT EMPLOYEE_ID, FIRST_NAME||' '||LAST_NAME, DEPARTMENT_ID, GET_DEPT_NAME(DEPARTMENT_ID) FROM EMPLOYEES;
SELECT DEPARTMENT_ID DEPT_ID, GET_DEPT_NAME(DEPARTMENT_ID) DEPT_NAME
       , SUM(SALARY) SUM_SAL, GET_GRADE(DEPARTMENT_ID) GRADE 
  FROM EMPLOYEES 
 GROUP BY DEPARTMENT_ID
 ORDER BY SUM_SAL DESC;




/*10■ 2005년 이전에 입사한 사원 중 업무에 "MGR"이 포함된 사원은 15%, 
  "MAN"이 포함된 사원은 20% 급여를 인상한다. 
  또한 2005년부터 근무를 시작한 사원 중 "MGR"이 포함된 사원은 25% 급여를 인상한다. 
  이를 수행하는 쿼리를 작성하시오
**********************************************************************/
SELECT E.*, NVL((CASE WHEN JOB_ID LIKE '%MGR%' AND TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) < 5 
                                                             THEN TO_CHAR(SALARY*1.15)
                      WHEN JOB_ID LIKE '%MAN%' AND TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) < 5 
                                                             THEN TO_CHAR(SALARY*1.20)
                      WHEN JOB_ID LIKE '%MGR%' AND TO_NUMBER(TO_CHAR(HIRE_DATE, 'YY')) >= 5 
                                                             THEN TO_CHAR(SALARY*1.25)END), '급여동결') 인상급여
  FROM EMPLOYEES E
 WHERE E.JOB_ID LIKE '%MGR%' OR JOB_ID LIKE '%MAN%'
 ORDER BY "인상급여";

SELECT CASE WHEN TO_CHAR(HIRE_DATE, 'YYYY') < '2005' THEN
                 CASE WHEN JOB_ID LIKE '%MGR%' THEN SALARY * 1.15
                      WHEN JOB_ID LIKE '%MAN%' THEN SALARY * 1.2
                      ELSE SALARY
                 END
            WHEN TO_CHAR(HIRE_DATE, 'YYYY') >= '2005' THEN
                 SALARY * 1.25
       END
       AS "변경된 급여"
 FROM EMPLOYEES
 WHERE JOB_ID LIKE '%MGR%' OR JOB_ID LIKE '%MAN%'
 ORDER BY ;
/*11■ 월별로 입사한 사원 수 출력
  (방식1) 월별로 입사한 사원 수가 아래와 같이 각 행별로 출력되도록 하시오(12행).
  1월 xx
  2월 xx
  3월 xx
  ..
  12월 xx
  합계 XXX
**********************************************************************/  
SELECT '합계' 입사월, COUNT(*) 사원수
  FROM EMPLOYEES
union   
SELECT TO_CHAR(HIRE_DATE, 'MM')||'월' 입사월, COUNT(*) 사원수
  FROM EMPLOYEES
 GROUP BY TO_CHAR(HIRE_DATE, 'MM') 
 ORDER BY "입사월"
;
---------------------------------------------------------
/* (방식2) 첫 행에 모든 월별 입사 사원 수가 출력되도록 하시오
  1월 2월 3월 4월 .... 11월 12월
  xx  xx  xx xx  .... xx   xx
**********************************************************************/
SELECT COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '01', 1)) AS "01월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '02', 1)) AS "02월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '03', 1)) AS "03월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '04', 1)) AS "04월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '05', 1)) AS "05월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '06', 1)) AS "06월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '07', 1)) AS "07월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '08', 1)) AS "08월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '09', 1)) AS "09월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '10', 1)) AS "10월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '11', 1)) AS "11월"
       , COUNT(DECODE(TO_CHAR(HIRE_DATE, 'MM'), '12', 1)) AS "12월"
       , COUNT(*) AS "총합"      
  FROM EMPLOYEES;
  


