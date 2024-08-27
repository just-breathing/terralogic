package assessment.terralogic.nodes.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@Table(name="nodes")
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    @Id
    @Column(name = "node_id", nullable = false,unique=true)
    @NotBlank(message = "Node ID is required")
    @Pattern(regexp = "^[^!@#$%^&*()]+$", message = "Node ID contains special characters")
    private String nodeId;

    
    @NotBlank(message = "Node Name is required")
    @Pattern(regexp = "^[^!@#$%^&*()]+$", message = "Node Name contains special characters")
    @Column(name = "node_name", nullable = false, unique = true)
    private String nodeName;

    @Column(name = "description")
    private String description;

    @Column(name = "memo")
    private String memo;

    @Column(name = "node_type", nullable = false)
    private String nodeType;

    @NotBlank(message = "Parent Node Group Name is required")
    @Pattern(regexp = "^[^!@#$%^&*()]+$", message = "Parent Node Group Name contains special characters")
    @Column(name = "parent_node_group_name",nullable = false)
    private String parentNodeGroupName;

    @Column(name = "parent_node_group_id")
    @NotBlank(message = "Parent Node Group Id is required")
    @Pattern(regexp = "^[^!@#$%^&*()]+$", message = "Parent Node Group ID contains special characters")
    private String parentNodeGroupId;

    @Column(name = "parent_node_group_memo")
    private String parentNodeGroupMemo;

   
}
