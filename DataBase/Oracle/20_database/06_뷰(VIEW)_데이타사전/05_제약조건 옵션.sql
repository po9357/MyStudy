/*****************************************
제약조건 옵션
CASCADE : 부모테이블의 제약조건 비활성화(삭제) 시키면서 참조하고 있는
          자녀(SUB)테이블의 제약조건까지 비활성화(삭제)
*****************************************/
-- 부모테이블 DEPT의 PK 비활성화 시키면서 자녀테이블의 제약조건(FK)도 비활성화
ALTER TABLE DEPT DISABLE PRIMARY KEY CASCADE; -- CASCADE가 붙으면 자녀들도 모두 비활성화
ALTER TABLE EMP01 DISABLE CONSTRAINT EMP01_DEPTNO_FK;
-- DEPT 테이블의 PRIMARY KEY DISABLE 처리할 경우
-- 외래키 연결된 테이블의 제약조건을 비활성화 한 후에 처리
ALTER TABLE DEPT DISABLE PRIMARY KEY;
ALTER TABLE DEPT ENABLE PRIMARY KEY;
-- 부모와 자식 모두 비활성화 되면, 부모가 먼저 활성화가 되어야 자식도 활성화 가능.
-- 반대로 CASCADE가 없으면 자식들이 모두 비활성화 되어야 부모도 비활성화 가능
ALTER TABLE EMP01 DISABLE CONSTRAINT EMP01_DEPTNO_FK;
ALTER TABLE EMP02 DISABLE CONSTRAINT SYS_C007033;
ALTER TABLE EMP03 DISABLE CONSTRAINT EMP03_DEPTNO_FK;

ALTER TABLE EMP01 ENABLE CONSTRAINT EMP01_DEPTNO_FK;
ALTER TABLE EMP02 ENABLE CONSTRAINT SYS_C007033;
ALTER TABLE EMP03 ENABLE CONSTRAINT EMP03_DEPTNO_FK;

-- CASCADE 옵션 사용
-- 외래키 설정된 자녀테이블의 외래키 설정도 동시에 비활성화 하면서
-- 부모 테이블의 제약조건을 비활성화 처리(일괄작업)
ALTER TABLE DEPT DISABLE PRIMARY KEY CASCADE;

-- 
CREATE TABLE C_TEST_MAIN (
    MAIN_PK NUMBER PRIMARY KEY,
    MAIN_DATE VARCHAR2(30)
);
CREATE TABLE C_TEST_SUB (
    SUB_PK NUMBER PRIMARY KEY,
    SUB_DATA VARCHAR2(30),
    SUB_FK NUMBER,
    CONSTRAINT C_TEST_SUB_FK FOREIGN KEY (SUB_FK)
    REFERENCES C_TEST_MAIN (MAIN_PK) ON DELETE CASCADE  -- ON DELETE CASCADE는
);                              -- 부모 테이블의 PK가 삭제되면 PK와 같은 데이터를 가진 자식테이블의 FK도 함께 삭제
INSERT INTO C_TEST_MAIN VALUES (1111, '1번째 메인 데이터');
INSERT INTO C_TEST_MAIN VALUES (2222, '2번째 메인 데이터');
INSERT INTO C_TEST_MAIN VALUES (3333, '3번째 메인 데이터');
SELECT * FROM C_TEST_MAIN;
COMMIT;
----
INSERT INTO C_TEST_SUB VALUES (1, '1번째 SUB 데이터', 1111);
INSERT INTO C_TEST_SUB VALUES (2, '2번째 SUB 데이터', 2222);
INSERT INTO C_TEST_SUB VALUES (3, '3번째 SUB 데이터', 3333);
INSERT INTO C_TEST_SUB VALUES (4, '4번째 SUB 데이터', 3333);
SELECT * FROM C_TEST_SUB;
--------------
DELETE FROM C_TEST_MAIN WHERE MAIN_PK = 1111;
COMMIT;
DELETE FROM C_TEST_MAIN WHERE MAIN_PK = 3333;
-----------------------------------------
-- 테이블 삭제 : 부모테이블 - 자녀테이블 관계에서 부모테이블 삭제
DROP TABLE C_TEST_MAIN;  -- 02449. 00000 -  "unique/primary keys in table referenced by foreign keys"
-- 방법1 : 서브테이블에 있는 FK 설정을 모두 삭제 후 부모테이블 삭제
-- FK 비활성화 설정으로는 안됨. FK 삭제처리 해야함
ALTER TABLE C_TEST_SUB DROP CONSTRAINT C_TEST_SUB_FK;
DROP TABLE C_TEST_MAIN;

-- 방법2 : 서브테이블을 모두 삭제 후 부모테이블 삭제
DROP TABLE C_TEST_SUB;
DROP TABLE C_TEST_MAIN;

-- 방법3 : 부모테이블 삭제시 CASCADE CONSTRAINTS 옵션 사용
-- 서브테이블의 제약조건 삭제 후 메인테이블 삭제처리 
DROP TABLE C_TEST_MAIN CASCADE CONSTRAINTS;


------------------- 실험시간 -------------------
SELECT * FROM C_TEST_MAIN;
SELECT * FROM C_TEST_SUB;
-- 오류 : ORA-02292: integrity constraint (MADANG.C_TEST_SUB_FK) violated - child record found
DELETE FROM C_TEST_MAIN WHERE MAIN_PK = 1111;       -- 자식 테이블에 FK 존재
DELETE FROM C_TEST_SUB WHERE SUB_FK = 1111;         -- 같은 데이터를 가진 FK 삭제시 부모테이블의 PK 삭제 가능
                                                    -- ON DELETE CASCADE옵션을 걸어두면 PK삭제시 자식테이블의 FK도 삭제
                                                    
ALTER TABLE C_TEST_MAIN DISABLE PRIMARY KEY;        -- 자식테이블의 FK가 활성화된 상태에서 부모테이블 PK 비활성화 불가
ALTER TABLE C_TEST_SUB DISABLE CONSTRAINT C_TEST_SUB_FK;   

ALTER TABLE C_TEST_MAIN ENABLE PRIMARY KEY;         
ALTER TABLE C_TEST_SUB ENABLE CONSTRAINT C_TEST_SUB_FK; -- 부모테이블이 비활성화된 상태에서 자식테이블 FK 활성화 불가