/********* CURSOR(커서) **************
데이터베이스 커서(Cursor)는 일련의 데이터에 순차적으로 액세스할 때 
검색 및 "현재 위치"를 포함하는 데이터 요소

묵시적커서 : SELECT, INSERT, UPDATE, DELETE 문장이 실행될 때
     DBMS가 CURSOR(커서)의 Open, Fetch, Close 자동 처리
명시적커서 : 프로그램내에서 명시적으로 커서(CURSOR)를 선언한 경우

<커서(CURSOR) 사용 절차>
1. 선언(CURSOR 커서명 IS SELECT문)
2. 커서오픈(OPEN 커서명)
3. 데이타추출(FETCH 커서명 INTO)
4. 커서닫기(CLOSE)
*************************************/
-- 주문테이블(ORDERS)에 있는 전체 데이터를 가져와서 화면출력
CREATE OR REPLACE PROCEDURE DISP_ORDERS 
AS
    -- 1.커서 선언
    CURSOR C_ORDERS IS 
    SELECT ORDERID, GET_CUSTNAME(CUSTID) CUSTNAME
           , GET_BOOKNAME(BOOKID) AS BOOKNAME
           , SALEPRICE, ORDERDATE
      FROM ORDERS
     ORDER BY ORDERID;
     
     -- 사용할 변수 선언
     V_ORDERID ORDERS.ORDERID%TYPE;
     V_CUSTNAME CUSTOMER.NAME%TYPE;
     V_BOOKNAME BOOK.BOOKNAME%TYPE;
     V_SALEPRICE ORDERS.SALEPRICE%TYPE;
     V_ORDERDATE ORDERS.ORDERDATE%TYPE;
BEGIN
    -- 2.커서(CURSOR) 열기(OPEN)
    OPEN C_ORDERS;
    
    -- 3.데이터 추출(FETCH 커서명 INTO)
    LOOP 
        FETCH C_ORDERS
        INTO V_ORDERID, V_CUSTNAME, V_BOOKNAME, V_SALEPRICE, V_ORDERDATE;
        
        -- 커서에 데이터가 없는 경우 반복문을 빠져 나감
        EXIT WHEN C_ORDERS%NOTFOUND;    -- 커서에서 데이터를 찾지 못하면 종료
        
        -- 커서에서 추출한 데이터 화면 출력
        DBMS_OUTPUT.PUT_LINE(V_ORDERID||' '||V_CUSTNAME||' '||V_BOOKNAME||' '||V_SALEPRICE||' '||V_ORDERDATE);
    END LOOP;
    -- 4.커서닫기(CLOSE)
    CLOSE C_ORDERS;
END;

-----------------------
-- 커서 없이 사용
CREATE OR REPLACE PROCEDURE DISP_ORDERS_SELECT AS 
    V_CNT NUMBER;
    I NUMBER;
     V_ORDERID ORDERS.ORDERID%TYPE;
     V_CUSTNAME CUSTOMER.NAME%TYPE;
     V_BOOKNAME BOOK.BOOKNAME%TYPE;
     V_SALEPRICE ORDERS.SALEPRICE%TYPE;
     V_ORDERDATE ORDERS.ORDERDATE%TYPE;
     V_RNO NUMBER;
BEGIN
  SELECT COUNT(*) INTO V_CNT
    FROM ORDERS;
    
    DBMS_OUTPUT.PUT_LINE('ORDERS 테이블 건수 : '||V_CNT);
    
    FOR I IN 1..V_CNT LOOP
        SELECT RNO, ORDERID, CUSTNAME, BOOKNAME, SALEPRICE, ORDERDATE
          INTO V_RNO, V_ORDERID, V_CUSTNAME, V_BOOKNAME, V_SALEPRICE, V_ORDERDATE
          FROM (SELECT ROWNUM AS RNO
                       , A.ORDERID
                       , GET_CUSTNAME(CUSTID) CUSTNAME
                       , GET_BOOKNAME(BOOKID) BOOKNAME
                       , A.SALEPRICE, A.ORDERDATE
                  FROM (SELECT * 
                          FROM ORDERS
                      ORDER BY SALEPRICE DESC) A  
        )
        WHERE RNO = I;
        
        DBMS_OUTPUT.PUT_LINE(V_RNO ||' '|| V_ORDERID ||' '|| V_CUSTNAME ||' '|| 
                V_BOOKNAME ||' '|| V_SALEPRICE ||' '|| V_ORDERDATE);
    END LOOP;
    
END;