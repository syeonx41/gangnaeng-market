# 강냉마켓 🛍️  
**교내 중고물품 거래 플랫폼 (CRUD 프로젝트)**

---

## 📌 프로젝트 소개  
강냉마켓은 학교 구성원들이 사용할 수 있는 중고물품 거래 시스템입니다.  
Spring Boot와 Mustache를 기반으로 한 CRUD 중심 학습 프로젝트입니다.

---

## ⚙️ 기술 스택  
- **Java**: 17  
- **Spring Boot**: 3.1.0  
- **Template Engine**: Mustache  
- **Database**: H2
- **Build Tool**: Gradle  
- **Lombok**: 코드 간결화를 위한 애너테이션 기반 툴  

---

## ✅ 주요 기능  
- 📄 **게시글 등록, 목록 조회, 상세 보기, 수정, 삭제** (CRUD)  
- 🔍 **제목 키워드 기반 검색 기능**  
- 🔄 **게시글 상태 관리 (판매 중 / 거래 완료)**  

---

## 📁 디렉터리 구조

```plaintext
gangnaeng-market/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/gangnaeng/market/
│   │   │       ├── controller/      # 웹 요청 처리 컨트롤러
│   │   │       ├── dto/             # 요청/응답 데이터 전송 객체
│   │   │       ├── entity/          # JPA 엔티티 클래스 정의
│   │   │       ├── repository/      # JPA Repository 인터페이스
│   │   │       └── GangnaengMarketApplication.java  # 메인 실행 클래스
│   │   └── resources/
│   │       ├── static/              # 정적 리소스 (CSS, 이미지 등)
│   │       │   ├── css/
│   │       │   └── images/
│   │       ├── templates/           # Mustache 템플릿 파일
│   │       │   ├── items/           # 게시글 관련 뷰
│   │       │   └── layout/          # 공통 레이아웃 템플릿
│   │       ├── application.properties  # Spring 설정 파일
│   │       └── data.sql             # 초기 데이터 삽입용 SQL 스크립트
│   └── test/
│       └── java/
│           └── com/gangnaeng/market/
│               └── GangnaengMarketApplicationTests.java  # 테스트 클래스
├── build.gradle
├── settings.gradle
└── README.md
