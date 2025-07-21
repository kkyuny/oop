# 🎯 객체지향 설계 및 구현: 음식점에서 음식 주문하는 과정

## 1. 도메인 객체 도출
- 도메인을 구성하는 핵심 객체들을 파악한다.  
- 예시
  - `Customer` (손님): 메뉴를 보고 음식을 주문함
  - `Menu` (메뉴판): 주문 가능한 메뉴 항목들의 목록 (`List<MenuItem>`)
  - `MenuItem` (메뉴 항목): 이름과 가격을 포함한 개별 요리 정보
  - `Cooking` (요리사): 주문을 받아 음식을 만듦
  - `CookedDish` (요리): 완성된 음식

## 2. 객체 간의 관계 설정
- `Customer` → `Menu`: 메뉴판을 보고 주문할 항목 선택
- `Customer` → `Cooking`: 선택한 `MenuItem`을 요리사에게 주문
- `Cooking` → `CookedDish`: 주문받은 `MenuItem`을 조리하여 반환

## 3. 도메인 모델링 (정적 타입으로 추상화)
동적인 개념들을 클래스로 정적으로 추상화한다
- `김치찌개`, `제육볶음` → `MenuItem`으로 추상화
- `List<MenuItem>` → `Menu`라는 일급 컬렉션으로 추상화
- `Cooking` → 조리 책임을 가진 능동적 객체
- `CookedDish` → 최종 결과물(음식)을 표현하는 객체

## 4. 객체 간 협력 설계
메시지 흐름 정의
1. `Customer`가 `Menu.choose(menuName)`를 호출하여 메뉴 확인
2. `Customer`가 선택한 `MenuItem`을 `Cooking.makeCook(menuItem)`로 전달
3. `Cooking`은 `MenuItem`을 기반으로 `CookedDish`를 생성하여 반환
4. `Customer`는 최종적으로 요리를 받는다

## 5. 책임 할당 및 캡슐화
- `Customer`: 주문 흐름의 시작점, 메뉴 확인 및 음식 주문
- `Menu`: 메뉴 항목 목록 제공, `MenuItem` 조회 기능 포함
- `MenuItem`: 이름, 가격 등 기본 정보 보유
- `Cooking`: 조리 책임, 주문받은 항목에 따라 요리 반환
- `CookedDish`: 완성된 음식 정보 보유

## 6. 구현
- 관심사에 따라 도메인을 분리하여 메서드를 잘 구현하여 실행한다.