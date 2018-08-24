/*********** 역할(ROLE) ******************
역할(롤, ROLE) : DB 객체 및 시스템에 대한 권한을 모아둔 집합을 의미
역할 생성 : CREATE ROLE 역할이름
역할 제거 : DROP ROLE 역할이름
역할에 권한 부여 : GRANT 권한 [ON 객체] TO 역할이름
역할의 권한 회수 : REVOKE 권한 [ON 객체] FROM 역할이름
사용자에게 역할 부여 : GRANT 역할이름 TO 사용자

<역할 생성부터 사용자 추가까지의 단계>
CREATE ROLE - 역할생성
GRANT - 만들어진 역할에 권한 부여
GRANT - 사용자에게 역할 부여
-->>역할 제거할 경우 반대로 수행
DROP ROLE - 역할 삭제(사용자에게 부여된 역할에 대한 권한 역시 제거됨)
************************************/
-- (롤 생성 SYSTEM 계정) 'PROGRAMMER'라는 역할(롤, ROLE) 생성
CREATE ROLE PROGRAMMER;

-- (SYSTEM 계정) PROGRAMMER 롤에 테이블, 뷰(VIEW) 생성 권한 부여
GRANT CREATE ANY TABLE, CREATE ANY VIEW TO PROGRAMMER;

-- (SYSTEM 계정) MDGUEST 유저에게 PROGRAMMER 롤 부여
GRANT PROGRAMMER TO MDGUEST;
--
CREATE TABLE MDGUEST2.NEWTABLE (
    NAME VARCHAR2(30),
    PHONE VARCHAR2(30)
);
SELECT * FROM MDGUEST2.NEWTABLE;        -- 테이블 생성 권한은 있지만,
INSERT INTO MDGUEST2.NEWTABLE           -- 테이블 SELECT, INSERT등의 권한은 없음
    VALUES ('박세리', '000-0000-0000');
--
-- 권한 회수, 취소
REVOKE PROGRAMMER FROM MDGUEST;