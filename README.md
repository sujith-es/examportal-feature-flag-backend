
- Add the actual values of EVN variables in `application.properties` file
- Add the Vault URL and Root token in `bootstrap.yaml`


```bash
mvn clean install -DskipTests
docker build -t sujithes/exam-portal .
docker tag sujithes/exam-portal sujithes/exam-portal:6
docker push sujithes/exam-portal:6

kubectl apply -f k8s/.
```