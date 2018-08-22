-- 비교구문 : IF문
-- IF () THEN ~ END IF;
-- IF () THEN ~ ELSE ~ END IF;
-- IF () THEN ~ ELSIF ~ ELSIF ~ ELSE ~ END IF;
CREATE OR REPLACE PROCEDURE PRC_IF (
    IN_NUM NUMBER
) AS
    V_STR VARCHAR2(1000);
BEGIN
    -- 짝수, 홀수 판별
    IF (MOD(IN_NUM, 2) = 0) THEN 
        V_STR := V_STR || '짝수';
    ELSE
        V_STR := V_STR || '홀수';
    END IF;
    DBMS_OUTPUT.PUT_LINE(IN_NUM || V_STR || '입니다');
    -- 4으로 나눈 나머지 값 확인
    IF (MOD(IN_NUM, 4) = 0) THEN
        V_STR := V_STR || ', 4으로 나눈 나머지 0';
    ELSIF (MOD(IN_NUM, 4) = 1) THEN
        V_STR := V_STR || ', 4으로 나눈 나머지 1';
    ELSIF (MOD(IN_NUM, 4) = 2) THEN
        V_STR := V_STR || ', 4으로 나눈 나머지 2';
    ELSE
        V_STR := V_STR || ', 4으로 나눈 나머지 3';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(IN_NUM || V_STR);
        
END;

--------------------------------------------------
-- 반복문 : FOR, WHILE
-- FOR문
-- 숫자
CREATE OR REPLACE PROCEDURE PRC_FOR_SUM (
    IN_NUM NUMBER
) AS
    V_SUM NUMBER := 0;      -- 변수 초기값 설정
    I NUMBER := 0;
BEGIN
    -- 입력받은 숫자까지의 합계 구하기 (1 ~ IN_NUM까지)
    DBMS_OUTPUT.PUT('1 부터 '||IN_NUM||'까지의 합 : ');
    
    -- FOR문으로 반복처리
    -- FOR 변수 IN 초기값..최종값 LOOP ~ END LOOP;
    FOR I IN 1..IN_NUM LOOP
        V_SUM := V_SUM+I;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(V_SUM);
END;
------------------------------------
-- WHILE문
CREATE OR REPLACE PROCEDURE PRC_WHILE_SUM (
    IN_NUM NUMBER
) AS
    V_SUM NUMBER := 0;      -- 변수 초기값 설정
    I NUMBER := 0;
BEGIN
    -- 입력받은 숫자까지의 합계 구하기 (1 ~ IN_NUM까지)
    DBMS_OUTPUT.PUT('1 부터 '||IN_NUM||'까지의 합 : ');
    
   --WHILE문
    WHILE (I <= IN_NUM) LOOP
        V_SUM := V_SUM + I;
        I := I+1;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(V_SUM);
END;

-----------------------------------------
-- (실습) 숫자를 하나 입력받아 0 부터 숫자값까지 합계 구하기
-- 입력값이 홀수이면 홀수값만 더하고,
-- 입력값이 짝수이면 짝수값만 더해서
-- 최종 결과를 화면에 출력
-- 출력 형태
-- 입력숫자 : 입력받은 값, 홀수/짝수, 합계 : 합계 결과값
-- 출력 예) 입력숫자 : 4, 짝수, 합계 : 6
CREATE OR REPLACE PROCEDURE PRC_SUM_EVENODD (
    IN_NUM IN NUMBER
) AS
    V_ODD_SUM NUMBER := 0;
    V_EVEN_SUM NUMBER := 0;
    I NUMBER := 0;
BEGIN
    FOR I IN 1..IN_NUM LOOP
        IF (MOD(I, 2) = 0) THEN
            V_EVEN_SUM := V_EVEN_SUM+I;
        ELSE
            V_ODD_SUM := V_ODD_SUM+I;
        END IF;
    END LOOP;

    IF (MOD(IN_NUM, 2) = 0) THEN
        DBMS_OUTPUT.PUT_LINE('입력 숫자 : '||IN_NUM||', 짝수, 합계 : '||V_EVEN_SUM);
    ELSE 
        DBMS_OUTPUT.PUT_LINE('입력 숫자 : '||IN_NUM||', 홀수, 합계 : '||V_ODD_SUM);
    END IF;    
   -- DBMS_OUTPUT.PUT_LINE('입력 숫자 : '||IN_NUM||', 짝수 합계 : '||V_EVEN_SUM||', 홀수 합계 : '||V_ODD_SUM);
END;

/*
    V_NUM := MOD(IN_NUM, 2);        -- 0, 1
    IF (MOD(IN_NUM, 2) = 0) THEN
        V_EVEN_ODD := '짝수';
    ELSE
        V_EVEN_ODD := '홀수';
    END IF;
    
    FOR I IN 0..IN_NUM LOOP
        IF (MOD(I, 2) = V_NUM) THEN
            V_SUM := V_SUM+I;
        END IF;
    END LOOP;
        