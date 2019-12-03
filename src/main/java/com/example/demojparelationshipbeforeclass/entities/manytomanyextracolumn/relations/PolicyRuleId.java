package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.relations;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PolicyRuleId implements Serializable {

    private Long policyId;

    private Long ruleId;

}
