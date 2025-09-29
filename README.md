# 🎓 SIGE - Système de Gestion des Écoles

SIGE (**Système de Gestion des Écoles**) est **mon tout premier projet en architecture microservices**.  
L’objectif principal est de **me familiariser avec les microservices, Docker, et tout ce qui va avec**.

---

## 🛠️ Microservices développés
J’ai développé 4 microservices simples :
- **classe-service** → gestion des classes
- **eleve-service** → gestion des élèves
- **inscription-service** → gestion des inscriptions
- **scolarite-service** → gestion de la scolarité et des frais

Chaque service expose un CRUD basique grâce à **Spring Data REST**, permettant de tester rapidement des endpoints REST sans écrire trop de code.

---

## 🚀 Technologies utilisées
- **Java / Spring Boot**
- **Spring Data REST** (CRUD automatique)
- **Eureka Server** pour la découverte de services
- **Spring Cloud Gateway** pour le routage centralisé
- **Docker & Docker Compose** pour la containerisation et l’orchestration

---

## ⚙️ Prérequis
Avant de lancer le projet, assurez-vous d’avoir installé :
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

---

## 🌐 Ports et accès
### 🔹 Ports directs
- Eureka Server → http://localhost:8761

- Gateway → http://localhost:8888

- classe-service → http://localhost:8083

- eleve-service → http://localhost:8082

- inscription-service → http://localhost:8081

- scolarite-service → http://localhost:8080

### 🔹 Accès via Gateway

- classe-service → http://localhost:8888/classe-service/api/v1/classes

- eleve-service → http://localhost:8888/eleve-service/api/v1/eleves

- inscription-service → http://localhost:8888/inscription-service/api/v1/inscriptions

- scolarite-service → http://localhost:8888/scolarite-service/api/v1/scolarites

---
## 📥 Cloner le projet
Pour cloner le projet très facilement depuis GitHub :

```bash
git clone https://github.com/trabrouss1/ms-sige-demo.git
cd ms-sige-demo

```
## ▶️ Lancement du projet

Pour démarrer tous les microservices :

```bash
docker compose up -d --build
```