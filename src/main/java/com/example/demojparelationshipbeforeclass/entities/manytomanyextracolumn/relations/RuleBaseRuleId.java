package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.relations;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class RuleBaseRuleId implements Serializable {

    private Long baseRuleId;

    private Long ruleId;

}
