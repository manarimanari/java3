# java3
java3Voici un résumé de la tâche proposée pour l'application de gestion de projet :

### Couche Persistance :
1. Développer les classes entités dans le package `ma.projet.classes`.
2. Créer un fichier de configuration Hibernate `hibernate.cfg.xml` dans le package `ma.projet.config`.
3. Créer la classe utilitaire `HibernateUtil` dans le package `ma.projet.util`.

### Couche Service :
1. Créer une interface générique `IDao` dans le package `ma.projet.dao`.
2. Implémenter cette interface dans les services suivants : `ProjetService`, `TacheService`, `EmployeService`, `EmployeTacheService`.
3. Dans la classe `EmployeService` :
   - Méthode pour afficher les tâches réalisées par un employé.
   - Méthode pour afficher les projets gérés par un employé.
4. Dans la classe `ProjetService` :
   - Méthode pour afficher les tâches planifiées pour un projet.
   - Méthode pour afficher les tâches réalisées dans un projet avec un exemple de format de sortie.
5. Dans la classe `TacheService` :
   - Méthode pour afficher les tâches dont le coût est supérieur à 1000 DH (utilisant une requête nommée).
   - Méthode pour afficher les tâches réalisées entre deux dates.
   
### Test :
- Créer des programmes pour tester toutes les méthodes mentionnées.
