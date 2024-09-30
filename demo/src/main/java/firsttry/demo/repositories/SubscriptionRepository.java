package firsttry.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import firsttry.demo.models.papers.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer>{
    
}
