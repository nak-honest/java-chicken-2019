# java-chicken-2019
## 기능 목록

- [x] 메인 화면을 화면에 출력한다.
<br>

- [x] 명령어 1, 2, 3 중 하나를 입력 받는다.
  - [ ] 1을 입력 받으면 주문을 등록한다.
    - [ ] 테이블 목록을 화면에 출력한다.
    - [ ] 테이블 번호를 입력 받는다.
    - [ ] 메뉴 목록을 화면에 출력한다.
    - [ ] 등록할 메뉴의 번호를 입력 받는다.
    - [ ] 등록할 메뉴의 수량을 입력 받는다.
    
  - [ ] 2를 입력 받으면 결제를 진행한다.
    - [ ] 모든 테이블이 결제할 금액이 없는 경우 예외를 발생시킨다.
      - [ ] 메인 화면으로 되돌아간다.
    - [ ] 테이블 목록을 화면에 출력한다.
    - [ ] 테이블 번호를 입력 받는다.
      - [ ] 결제할 금액이 없는 테이블인 경우 예외를 발생시킨다.
        - [ ] 테이블 번호를 다시 입력받는다.
    - [ ] 주문 내역을 화면에 출력한다.
    - [ ] 결제 수단 번호를 입력 받는다.
    - [ ] 최종 결제할 금액을 계산한다.
  
  - [ ] 3을 입력 받으면 프로그램을 종료한다.
  - [x] 명령어가 1, 2, 3 중 하나가 아니라면 예외를 발생시킨다.
    - [ ] 명령어 번호를 다시 입력받는다.
      <br>

- [x] 테이블 목록을 화면에 출력한다.
  - [x] 테이블은 총 6개이다.
  - [x] 각 테이블 번호는 1, 2, 3, 5, 6, 8 이다.
  - [x] 결제가 이루어지지 않은 메뉴가 등록되어 있는 테이블에 "₩" 을 표시한다.
  - [x] 테이블 목록은 다음과 같이 출력한다.
    ```
    ┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓
    | 1 || 2 || 3 || 5 || 6 || 8 |
    ┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛
    ```
  <br>

- [x] 테이블 번호를 입력 받는다.
  - [x] 테이블 번호가 1, 2, 3, 5, 6, 8 중 하나가 아니라면 예외를 발생시킨다.
    - [ ] 테이블 번호를 다시 입력 받는다.
      <br>

- [x] 메뉴 목록을 화면에 출력한다.
  - [x] 메뉴 목록은 메뉴의 종류, 메뉴의 번호, 메뉴의 이름, 가격으로 구성된다.
  - [x] `"[<메뉴 종류>] <메뉴 번호> - <메뉴이름> : <메뉴 가격>원"` 형식으로 출력한다.
    <br>

- [x] 등록할 메뉴의 번호를 입력 받는다.
  - [x] 존재하지 않는 메뉴 번호라면 예외를 발생시킨다.
    - [ ] 메뉴 번호를 다시 입력 받는다.
  - [ ] 해당 테이블에서 해당 메뉴의 수량 개수가 99개라면 예외를 발생시킨다.
    - [ ] 메뉴 번호를 다시 입력 받는다.
      <br>

- [x] 등록할 메뉴의 수량을 입력 받는다.
  - [ ] 메뉴의 개수가 양의 정수가 아니라면 예외를 발생시킨다.
    - [ ] 메뉴의 개수를 다시 입력 받는다.
  - [x] 한 테이블에서 해당 메뉴의 수량 개수가 총 100개 이상이 되면 예외를 발생시킨다.
    - [ ] 메뉴의 개수를 다시 입력 받는다.
      <br>


- [ ] 주문 내역을 화면에 출력한다.
  - [ ] 주문 내역은 메뉴의 이름, 메뉴의 수량, 메뉴의 가격으로 구성된다.
  - [ ] `"<메뉴 이름>  <메뉴 수량>  <메뉴 가격>"` 형식으로 출력한다.

- [x] 테이블에 누적된 총 주문 금액을 계산한다.
- [x] 테이블에 누적된 치킨 종류 메뉴의 개수를 계산한다.
- [x] 테이블에 누적된 치킨 종류 메뉴의 개수가 10개 이상이라면 할인된다.
  - 치킨 종류 개수 10개당 10,000원씩 할인된다.

- [x] 결제 수단 번호를 입력 받는다.
  - 결제 수단이 1번 이라면 신용 카드 결제이다.
  - 결제 수단이 2번 이라면 현금 결제이다.
  - [x] 결제 수단이 1번, 2번이 아니라면 예외를 발생시킨다.
    - [ ] 결제 수단 번호를 다시 입력 받는다.
- [x] 현금 결제라면 5% 할인된다.


- [x] 최종 결제할 금액을 계산한다.
- [ ] 최종 결제할 금액을 화면에 출력한다.
  - [ ] 최종 결제할 금액은 "<최종 결제할 금액>원" 형식으로 출력한다.
- [x] 해당 테이블의 주문 내역을 초기화한다.
<br>
