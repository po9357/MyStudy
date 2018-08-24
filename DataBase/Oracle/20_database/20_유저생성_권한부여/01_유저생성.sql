/******* 사용자 생성, 삭제 **********
사용자(DB)생성 : CREATE USER
CREATE USER [사용자이름] 
IDENTIFIED BY [비밀번호]
DEFALUT TABLESPACE [테이블스페이스];
--DEFALUT TABLESPACE 지정하지 않으면 오라클 SYSTEM 지정

사용자수정 : ALTER USER - 비밀번호 변경등
ALTER USER 사용자이름 INDENTIFIED BY 비밀번호;

사용자삭제 : DROP USER
DROP USER 사용자이름 [CASCADE];
--CASCADE : 삭제시점에 사용자가 보유한 모든 데이타를 같이 삭제처리
**********************************/

-- (관리자계정 SYSTEM에서 작업) 유저 생성
CREATE USER MDGUEST  IDENTIFIED BY "mdguest";
CREATE USER mdguest2 IDENTIFIED BY "mdguest2"
DEFAULT TABLESPACE USERS;

-- 권한부여
GRANT CONNECT, RESOURCE TO MDGUEST;
GRANT CONNECT, RESOURCE TO MDGUEST2;

/****** 권한 부여(GRANT), 권한 취소(REVOKE) **********************
GRANT 권한 [ON 객체] TO {사용자|ROLE|PUBLIC,.., n} [WITH GRANT OPTION]
--PUBLIC은 모든 사용자에게 적용을 의미

GRANT 권한 TO 사용자; --권한을 사용자에게 부여
GRANT 권한 ON 객체 TO 사용자; -객체에 대한 권한을 사용자에게 부여
-->> WITH GRANT OPTION :객체에 대한 권한을 사용자에게 부여 
-- 권한을 받은 사용자가 다른 사용자에게 권한부여할 권리 포함
GRANT 권한 ON 객체 TO 사용자 WITH GRANT OPTION;
----------------------------
-->>>권한 취소(REVOKE)
REVOKE 권한 [ON 객체] FROM {사용자|ROLE|PUBLIC,.., n} CASCADE
--CASCADE는 사용자가 다른 사용자에게 부여한 권한까지 취소시킴
  (확인 및 검증 후 작업)

REVOKE 권한 FROM 사용자; --권한을 사용자에게 부여
REVOKE 권한 ON 객체 FROM 사용자; -객체에 대한 권한을 사용자에게 부여
*************************************************/

-- MADANG 유저인 경우(MADANG 유저명 생략 가능)
GRANT SELECT ON MADANG.BOOK TO MDGUEST;

REVOKE SELECT ON MADANG.BOOK FROM MDGUEST;
----------------------
-- MADANG.CUSTOMER 테이블에 대하여 MDGUEST 유저에게
----------- SELECT, UPDATE 권한 부여
GRANT SELECT, UPDATE ON MADANG.CUSTOMER TO MDGUEST;

SELECT * FROM MADANG.CUSTOMER;
UPDATE MADANG.CUSTOMER
   SET PHONE = '010-1111-1111'
 WHERE NAME = '박세리'
;

-- SQL 오류: ORA-01031: insufficient privileges
DELETE FROM MADANG.CUSTOMER    -- 접근 권한은 있으나
 WHERE NAME = '박세리'          -- 삭제 권한이 없어 삭제 불가
;

-- ORA-00942: table or view does not exist
SELECT * FROM MADANG.BOOK;      -- SELECT 권한이 없음
--------------------------------------------
-- WITH GRANT OPTION : 다른 유저에게 권한 부여할 수 있도록 권한 부여
GRANT SELECT, UPDATE ON MADANG.BOOK TO MDGUEST
WITH GRANT OPTION;
--
GRANT SELECT, UPDATE ON MADANG.BOOK TO MDGUEST2;
--------------------------
-- 권한 회수 REVOKE
REVOKE SELECT, UPDATE ON MADANG.BOOK FROM MDGUEST;