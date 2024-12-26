# Kubernetes Deployment Guide with Helm and Argo CD

## Prerequisites
- Docker
- Minikube
- Kubectl
- Helm
- Argo CD

You can follow online blogs for installing these requirements.

## Local Deployment Testing with Helm Chart

1. Clone the repository in the local machine and navigate to argo test directory:
   ```bash
   cd argo-test/deployments/helm
   ```

2. Create a chart using the following commands:
   ```bash
   # Install the chart (. specifies the current directory)
   helm install tomato-chart .
   
   # List running charts
   helm list
   ```

3. Check deployed Kubernetes cluster:
   ```bash
   # Check deployments in tomato namespace
   kubectl get deploy -n tomato
   
   # Check services
   kubectl get svc -n tomato
   
   # Check pods
   kubectl get pods -n tomato
   ```

This way you can test if the services are deployed using Helm and experiment with the setup.

## Argo CD Testing

1. Fork the repository to your GitHub profile

2. Install Argo CD in the default cluster on local machine:
   ```bash
   # Create namespace for Argo CD
   kubectl create namespace argocd
   
   # Install Argo CD
   kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
   
   # Expose Argo CD API server
   kubectl patch svc argocd-server -n argocd -p '{"spec": {"type": "LoadBalancer"}}'
   
   # Port forward to 8080 (default port 443 might be occupied)
   kubectl port-forward svc/argocd-server -n argocd 8080:443
   ```
   
   You can now access the Argo CD server in your local web browser on port 8080

3. Login with admin credentials:
   ```bash
   # Get the admin password
   kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
   ```
   
   - Username: admin
   - Password: (use the password from above command)

4. Add application from the GUI:
   - Specify your GitHub repo URL
   - Set target folder as `deployments/helm/values.yaml`
   - Argo CD listens to this file
   - Save the changes

5. Your application should now be up and running
   - To test, make changes to `values.yaml` file (e.g., modify replica set)
   - Push the changes to GitHub
   
6. Test sync and out-of-sync functionality in Argo CD

## Note
Make sure all prerequisites are properly installed and configured before starting the deployment process.
