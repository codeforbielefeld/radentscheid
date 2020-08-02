# Radunfallkarte als Service in k8s aufsetzen

Einige Hinweise für den Betrieb mit k8s (e.g. locally minikube).

# Minikube installieren

https://kubernetes.io/docs/setup/learning-environment/minikube/

Den Ingress in minikube aktivieren

```bash
  $ minikube addons enable ingress
```

Die Radunfallkarte als docker-image in der minikube docker registry bauen. 
Dazu mmüssen wir zunächst die docker registry auf die des minikube setzen. 
Das ist nur in dem aktuellen Terminal aktiv. 
Das deployment nutzt die pullImagePolicy: Never um nicht an eine öffentliche Registry zu gehen.

```bash
  $ eval $(minikube docker-env)
```

Wechsel in das Verzeichnis .../radentscheid/radunfallkarte/. Dieses enthält ein Dockerfile.

```bash
  $ docker build -t ruk:latest .
```

Wechsel in das Verzeichnis .../radentscheid/infrastructure/k8s.

```bash
  $ kubectl apply -f ruk.yaml
```

Wenn alles läuft ist die Anwendung nun verfügbar. Wo? Schauen wir mal nach:

```bash
  $ minikube dashboard
```

öffnet ein Browserfenster mit der Admin-Oberfläche des minikube clusters. Dort finden wir unter Overview den ruk-ingress Ingress und finden die Endpoint Adresse. Bei mir ist das http://192.168.99.100/
