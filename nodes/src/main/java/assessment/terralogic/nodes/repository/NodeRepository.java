package assessment.terralogic.nodes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assessment.terralogic.nodes.entity.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, String> {

  
}