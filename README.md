# RCGTH-2

1. create jar file
2. create dockerfile
3. create repository in docker hub
4. image build: docker build -t accountname/repositoryname:tagname .
5. docker push accountname/repositoryname:tagname
6. go to kubernet cluster from https://console.cloud.google.com/
7. create cluster
8. enter the cluster and click on "connect"
9. copy the command line access
10. open cmd in project folder and paste the command
11. kubectl create deployment containername --dry-run=client --image=accountname/repositoryname:tagname -o yaml>deployment.yaml
12. kubectl apply -f deployment.yaml
13. kubectl expose deployment containername --type=LoadBalancer --port=8083 --dry-run=client -o yaml>service.yaml
14. kubectl apply -f service.yaml
15. enter the particuler cluster
16. go to services & ingress and look at the created container, copy the endpoints
