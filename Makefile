run-db:
	mvn spring-boot:run -f ./platform-database/pom.xml

run-mqtt: build-libs
	mvn clean install spring-boot:run -f ./platform-mqtt-subscriber/pom.xml

run-locker: build-libs
	mvn clean install spring-boot:run -f ./platform-locker-microservices/pom.xml


run-rider: build-libs
	mvn clean install spring-boot:run -f ./platform-rider-microservices/pom.xml

build-libs:
	mvn clean install

