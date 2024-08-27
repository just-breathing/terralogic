package assessment.terralogic.nodes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import assessment.terralogic.nodes.entity.Node;
import assessment.terralogic.nodes.service.NodeService;


@RestController
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @GetMapping("/all-nodes")
    public ResponseEntity<List<Node>>  getAllNodes() {
        return nodeService.getAllNodes();
    }

    @PostMapping("/create-node")
    public ResponseEntity<String> createNode(@RequestBody Node node) {
        return nodeService.createNode(node);
    }

    
}
