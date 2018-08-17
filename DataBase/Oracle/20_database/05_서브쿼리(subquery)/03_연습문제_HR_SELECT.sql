/* ** 실습문제 : HR유저(DB)에서 요구사항 해결 **********
-- 사번(employee_id)이 100인 직원 정보 전체 보기
-- 월급(salary)이 15000 이상인 직원의 모든 정보 보기
-- 월급이 15000 이상인 사원의 사번, 이름(LAST_NAME), 입사일(hire_date), 월급여 정보 보기
-- 월급이 10000 이하인 사원의 사번, 이름(LAST_NAME), 입사일, 월급여 정보 보기
---- (급여가 많은 사람부터)
-- 이름(first_name)이 john인 사원의 모든 정보 조회
-- 이름(first_name)이 john인 사원은 몇 명인가?
-- 2008년에 입사한 사원의 사번, 성명('first_name last_name'), 월급여 정보 조회
---- 성명 출력예) 'Steven King'
-- 월급여가 20000~30000 구간인 직원 사번, 성명(last_name first_name), 월급여 정보 조회
-- 관리자ID(MANAGER_ID)가 없는 사람 정보 조회
-- 직종(job_id)코드 'IT_PROG'에서 가장 많은 월급여는 얼마
-- 직종별 최대 월급여 검색
-- 직종별 최대 월급여 검색하고, 최대 월급여가 10000이상인 직종 조회
-- 직종별 평균급여 이상인 직원 조회
**********************************************************/
SELECT * FROM EMPLOYEES ORDER BY JOB_ID;
-- 사번(employee_id)이 100인 직원 정보 전체 보기
SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 100;
-- 월급(salary)이 15000 이상인 직원의 모든 정보 보기
SELECT * FROM EMPLOYEES WHERE SALARY >= 15000;
-- 월급이 15000 이상인 사원의 사번, 이름(LAST_NAME), 입사일(hire_date), 월급여 정보 보기
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY FROM EMPLOYEES WHERE SALARY >= 15000;
-- 월급이 10000 이하인 사원의 사번, 이름(LAST_NAME), 입사일, 월급여 정보 보기
---- (급여가 많은 사람부터)
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY FROM EMPLOYEES WHERE SALARY <= 10000 ORDER BY SALARY DESC;
-- 이름(first_name)이 john인 사원의 모든 정보 조회
SELECT * FROM EMPLOYEES WHERE UPPER (FIRST_NAME) IN ('JOHN');
-- 이름(first_name)이 john인 사원은 몇 명인가?
SELECT COUNT(*) FROM EMPLOYEES WHERE UPPER (FIRST_NAME) IN ('JOHN');
-- 2008년에 입사한 사원의 사번, 성명('first_name last_name'), 월급여 정보 조회
---- 성명 출력예) 'Steven King'
SELECT EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME, SALARY FROM EMPLOYEES WHERE HIRE_DATE LIKE '08%';
-- 월급여가 20000~30000 구간인 직원 사번, 성명(last_name first_name), 월급여 정보 조회
SELECT EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME, SALARY FROM EMPLOYEES WHERE SALARY BETWEEN 20000 AND 30000;
-- 관리자ID(MANAGER_ID)가 없는 사람 정보 조회
SELECT * FROM EMPLOYEES WHERE MANAGER_ID IS NULL;
-- 직종(job_id)코드 'IT_PROG'에서 가장 많은 월급여는 얼마
SELECT MAX(SALARY) FROM EMPLOYEES WHERE UPPER (JOB_ID) IN 'IT_PROG';
-- 직종별 최대 월급여 검색
SELECT JOB_ID, MAX(SALARY) MAX FROM EMPLOYEES GROUP BY JOB_ID ORDER BY MAX;
-- 직종별 최대 월급여 검색하고, 최대 월급여가 10000이상인 직종 조회
SELECT E.JOB_ID, MAX(SALARY) FROM EMPLOYEES E 
 WHERE (SELECT MAX(SALARY) 
                 FROM EMPLOYEES 
               WHERE E.JOB_ID = JOB_ID) >= 10000 GROUP BY JOB_ID;
-- 직종별 평균급여 이상인 직원 조회
SELECT AVG(SALARY) FROM EMPLOYEES GROUP BY JOB_ID; --   직종별 평균 급여
SELECT E.*
           , (SELECT AVG(SALARY) FROM EMPLOYEES WHERE E.JOB_ID = JOB_ID) AVG_SAL  
   FROM EMPLOYEES E 
 WHERE SALARY >= (SELECT AVG(SALARY) 
                                   FROM EMPLOYEES 
                                 WHERE E.JOB_ID = JOB_ID)
ORDER BY JOB_ID, SALARY;