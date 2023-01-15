# Spring Boot application with 
- Spring cloud
- Flipt feature flag Integrated
- Hahsicorp Vault integration
- MySql

### Before Start update below
- Add the actual values of EVN variables in `application.properties` file
- Add the Vault URL and Root token in `bootstrap.yaml`


```bash
mvn clean install -DskipTests
docker build -t sujithes/exam-portal .
docker tag sujithes/exam-portal sujithes/exam-portal:6
docker push sujithes/exam-portal:6

kubectl apply -f k8s/.
```

### You will need to have [Kustomize installed](https://github.com/kubernetes-sigs/kustomize/blob/master/docs/INSTALL.md)
```agsl
kustomize build ./kustomize/base
```

This is our base deployment and service resources
```agsl
kustomize build ./kustomize/qa
```

Piping Kustomize Into Kubectl

```agsl
kustomize build kustomize/qa | kubectl apply -f -`
```

Cleanup
```agsl
kustomize build kustomize/qa | kubectl delete -f -
```