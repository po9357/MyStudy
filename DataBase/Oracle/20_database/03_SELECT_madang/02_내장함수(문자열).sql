/******************************* 
오라클의 내장함수 - 문자열, 숫자, 날짜 관련 함수
<문자열 관련 내장함수>
UPPER : 대문자로 변경
LOWER : 소문자로 변경
INITCAP : 첫 글자만 대문자로 나머지는 소문자
LENGTH : 문자열의 길이(문자단위)
LENGTHB : 문자열의 길이(BYTE 단위)
SUBSTR(대상, 시작위치, 길이) : 문자열의 일부 추출
   (시작위치는 1부터 시작, 오른쪽에서 시작하는 경우 마이너스(-)값 사용)
INSTR(대상, 찾는문자) : 대상문자열에 찾는문자 위치값 리턴
INSTR(대상, 찾는문자, 시작위치)
INSTR(대상, 찾는문자, 시작위치, nth) : nth 찾은값의 순서값(3 : 3번째 찾은 값)
TRIM('문자열') : 양쪽 공백 제거
LTRIM('문자열') : 왼쪽에 있는 공백 제거
RTRIM('문자열') : 오른쪽에 있는 공백 제거
CONCAT(문자열1, 문자열2) : 문자열 연결 - 문자열1 || 문자열2
LPAD(대상문자열, 전체글자수, 삽입될문자) : 왼쪽에 삽입
RPAD(대상문자열, 전체글자수, 삽입될문자) : 오른쪽에 삽입
REPLACE(대상문자열, 찾을문자, 변경문자) : 문자열에서 찾은문자를 변경
********************************/
SELECT * FROM DUAL;         --  오라클에서 제공하는 더미테이블
SELECT 1000 * 1234, 123-456 FROM DUAL;
-----------------------------------
--  UPPER : 대문자로 변경
--  LOWER : 소문자로 변경
--  INITCAP : 첫 글자만 대문자로 나머지는 소문자
SELECT BOOKNAME, UPPER (BOOKNAME) FROM BOOK;
SELECT UPPER ('Olympic Champions') from DUAL;
SELECT UPPER ('OLYMPIC CHAMPIONS') from DUAL;
SELECT INITCAP ('OLYMPIC CHAMPIONS') FROM DUAL;
SELECT INITCAP ('olympic champions') FROM DUAL;
SELECT * FROM BOOK WHERE BOOKNAME LIKE 'OLYMPIC%';              --  데이터는 대소문자를 구분함.
SELECT * FROM BOOK WHERE BOOKNAME LIKE 'olympic%';
SELECT * FROM BOOK WHERE BOOKNAME LIKE 'Olympic%';                --  데이터의 대소문자를 정확히 입력
SELECT BOOKNAME, UPPER(BOOKNAME) FROM BOOK WHERE UPPER (BOOKNAME) LIKE 'OLYMPIC%';
------------------------------------
--  TRIM('문자열') : 양쪽 공백 제거
SELECT '    TEST    ' FROM DUAL;
SELECT '    TEST    ', TRIM   ('     TEST       ') FROM DUAL;
--  LTRIM('문자열') : 왼쪽에 있는 공백 제거
SELECT '    TEST    ', LTRIM ('     TEST       ') FROM DUAL;
--  RTRIM('문자열') : 오른쪽에 있는 공백 제거
SELECT '    TEST    ', RTRIM ('     TEST       ') FROM DUAL;
--------------------------------------
--  CONCAT(문자열1, 문자열2) : 문자열 연결 - 문자열1 || 문자열2
SELECT CONCAT ('HELLO ', 'WORLD!!!') FROM DUAL;
SELECT 'HELLO ' || 'WORLD!!!' FROM DUAL;

--  LPAD(대상문자열, 전체글자수, 삽입될문자) : 왼쪽에 삽입
--  RPAD(대상문자열, 전체글자수, 삽입될문자) : 오른쪽에 삽입
SELECT LPAD ('OLYMPIC', 10, '*') FROM DUAL;
SELECT RPAD ('OLYMPIC', 10, '*') FROM DUAL;
SELECT LPAD ('OLYMPIC', 10) FROM DUAL;
SELECT RPAD ('OLYMPIC', 10, '*!%^&*()') FROM DUAL;

-------------------------------------
--  LENGTH : 문자열의 길이(문자단위)
--  LENGTHB : 문자열의 길이(BYTE 단위)
SELECT LENGTH ('ABCDE123') FROM DUAL;        -- 문자 단위
SELECT LENGTHB ('ABCDE123') FROM DUAL;      -- BYTE 단위

SELECT LENGTH ('홍길동123') FROM DUAL;              -- 글자 길이   (홍길동123     =       6글자)
SELECT LENGTHB ('홍길동123') FROM DUAL;            -- BYTE 길이 (한글 3글자 (9BYTE) 숫자 3자리 (3BYTE) = 12BYTE)

--  SUBSTR(대상, 시작위치, 길이) : 문자열의 일부 추출
--     (시작위치는 1부터 시작, 오른쪽에서 시작하는 경우 마이너스(-)값 사용)
SELECT SUBSTR ('홍길동123', 1, 3) FROM DUAL;       --  홍길동 (자바의 substring과 비슷)
SELECT SUBSTR ('홍길동123', -3, 3) FROM DUAL;      --  123
SELECT SUBSTR ('홍길동12345', 4) FROM DUAL;        --  12345
SELECT SUBSTR ('홍길동123', -4) FROM DUAL;         --  동123

--  INSTR(대상, 찾는문자) : 대상문자열에 찾는문자 위치값 리턴
--  INSTR(대상, 찾는문자, 시작위치)
--  INSTR(대상, 찾는문자, 시작위치, nth) : nth 찾은값의 순서값(3 : 3번째 찾은 값)
SELECT INSTR ('900101-1234567', '-') FROM DUAL;           --  찾는 문자가 있으면 해당 위치값
SELECT INSTR ('900101-1234567', '*') FROM DUAL;           --  찾는 문자가 없으면 0
SELECT INSTR ('900101-1234567', '34') FROM DUAL;         --  위치값 10
SELECT INSTR ('900101-1234567', '1') FROM DUAL;           --  중복된 값을 찾으면 제일 앞에 있는 문자의 위치값만 보여줌
SELECT INSTR ('900101-1234567', '1', 5) FROM DUAL;       --  5번째 부터 찾기 시작
SELECT INSTR ('900101-1234567', '1', 1, 3) FROM DUAL;   --  1번째 부터 찾기 시작해서 3번째 있는 '1'의 위치값

--  REPLACE(대상문자열, 찾을문자, 변경문자) : 문자열에서 찾은문자를 변경
SELECT 'HELLO JAVA', REPLACE ('HELLO JAVA', 'A', 'O') FROM DUAL;
SELECT 'HELLO JAVA', REPLACE ('HELLO JAVA', 'JAVA', 'WORLD!!!') FROM DUAL;