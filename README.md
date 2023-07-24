### Spring Docker Compose Support 
> compose.ymal 파일 작성  
> application 실행 될 떄 docker compose up  
> application 다운 될 때 docker compose down 
> > - zookeeper 이미지 다운로드
> > - kafka 하위 파일 존재해야 이미지 및 컨테이너 생성 가능
> >   - Dockerfile
> >   - create-topic.sh
> >   - broker-list.sh
> >   - download-kafka.sh
> >   - start-kafka.sh
> >   - version.sh

해당 로그 파일을 volume ./kafka-log에 연결해두어 컨테이너가 내려갔다가 올라가도 없어지지 않도록 설정 

### Spring STOMP

- 해당 Docker 컨테이너로 올린 카프카로 broker 역할로 STOMP을 통해 체팅 개발 예정 
- 