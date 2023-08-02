### Spring Docker Compose Support  
- compose.ymal 파일 작성  
- application 실행 될 떄 docker compose up  
- application 다운 될 때 docker compose down 
- zookeeper 이미지 다운로드
- kafka 하위 파일 존재해야 이미지 및 컨테이너 생성 가능
  - Dockerfile
  - create-topic.sh
  - broker-list.sh
  - download-kafka.sh
  - start-kafka.sh
  - version.sh
- mysql 이미지 다운로드
  - mysql init table 생성
  - data 폴더에 데이터 연동

해당 로그 파일을 volume ./kafka-log에 연결해두어 컨테이너가 내려갔다가 올라가도 없어지지 않도록 설정 

### Spring STOMP

- 해당 Docker 컨테이너로 올린 카프카로 broker 역할로 STOMP을 통해 체팅 개발 예정 
- 카프카를 이용하여 하는 것은 서버가 여러대로 변경될 경우에 시도해보는 것으로 변경 
- 현재는 서버 한대 운영하는 쪽으로 SimpleBroker을 이용하여 구축 예정

### Spring Security

- Spring Security를 이용하여 OAuth2 사용해 구글 로그인하여 사용자가 회원가입 및 로그인을 진행하도록 수정
- CORS 설정하여 내 front-end client만 접근 가능하도록 설정
- Spring Basic Login으로 일단 OAuth 테스트 진행하여 Docker Mysql DB에 User Table 저장 확인
- Spring Security Test Code 작성 필요