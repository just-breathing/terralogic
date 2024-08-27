package assessment.terralogic.nodes.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import assessment.terralogic.nodes.entity.Node;
import assessment.terralogic.nodes.repository.NodeRepository;

@Service
public class NodeService {

    @Autowired
    private NodeRepository nodeRepository;


    public ResponseEntity<List<Node>> getAllNodes() {
        try {
            return new ResponseEntity<>(nodeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<String> createNode(Node node) {
        try {
            nodeRepository.save(node);
            return new ResponseEntity<>("Node created successfully", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Node creation failed ", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    
}
